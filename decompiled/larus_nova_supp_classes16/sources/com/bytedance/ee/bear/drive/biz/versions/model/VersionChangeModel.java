package com.bytedance.ee.bear.drive.biz.versions.model;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

            public void setVersion(String r1) {
                this.version = r1;
            }
        }

        public Body() {
        }

        public Data getData() {
            return this.data;
        }

        public void setData(Data r1) {
            this.data = r1;
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

        public void setToken(String r1) {
            this.token = r1;
        }

        public void setType(int r1) {
            this.type = r1;
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

    public void setBody(Body r1) {
        this.body = r1;
    }

    public void setIdentifier(Identifier r1) {
        this.identifier = r1;
    }

    public void setOperation(String r1) {
        this.operation = r1;
    }
}
