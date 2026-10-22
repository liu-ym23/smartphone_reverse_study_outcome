package com.bytedance.ee.bear.drive.biz.versions.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class VersionChangeModel implements Serializable {
    public static final String OPERATION_DELETE = "versionDidDelete";
    public static final String OPERATION_UPDATE = "versionDidUpdate";
    private Body body;
    private Identifier identifier;
    private String operation;

    public static class Body implements Serializable {
        private Data data;

        public static class Data implements Serializable {
            private String version;

            public Data() {
            }

            public String getVersion() {
                return this.version;
            }

            public void setVersion(String r100) {
                this.version = r100;
            }
        }

        public Body() {
        }

        public Data getData() {
            return this.data;
        }

        public void setData(Data r100) {
            this.data = r100;
        }
    }

    public static class Identifier implements Serializable {
        private String token;
        private int type;

        public Identifier() {
        }

        public String getToken() {
            return this.token;
        }

        public int getType() {
            return this.type;
        }

        public void setToken(String r100) {
            this.token = r100;
        }

        public void setType(int r100) {
            this.type = r100;
        }
    }

    public VersionChangeModel() {
    }

    public Body getBody() {
        return this.body;
    }

    public Identifier getIdentifier() {
        return this.identifier;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setBody(Body r100) {
        this.body = r100;
    }

    public void setIdentifier(Identifier r100) {
        this.identifier = r100;
    }

    public void setOperation(String r100) {
        this.operation = r100;
    }
}
