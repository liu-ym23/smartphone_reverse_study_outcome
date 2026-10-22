package com.bytedance.ee.bear.document.offline.file.upload;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class UploadProgressModel implements NonProguard {
    private static final String OPERATION_UPDATE = "updateProgress";
    private Body body;
    private String operation;

    public static class Body implements NonProguard {
        private float progress;
        private String uuid;

        public float getProgress() {
            return this.progress;
        }

        public String getUuid() {
            return this.uuid;
        }

        public void setProgress(float r1) {
            this.progress = r1;
        }

        public void setUuid(String r1) {
            this.uuid = r1;
        }

        public Body(float r1, String r2) {
            this.progress = r1;
            this.uuid = r2;
        }
    }

    public Body getBody() {
        return this.body;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setBody(Body r1) {
        this.body = r1;
    }

    public void setOperation(String r1) {
        this.operation = r1;
    }

    public UploadProgressModel(float r2, String r3) {
        this.operation = OPERATION_UPDATE;
        this.body = new Body(r2, r3);
    }
}
