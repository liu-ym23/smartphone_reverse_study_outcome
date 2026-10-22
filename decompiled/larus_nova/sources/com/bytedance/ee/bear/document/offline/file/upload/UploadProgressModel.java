package com.bytedance.ee.bear.document.offline.file.upload;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
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

        public void setProgress(float r100) {
            this.progress = r100;
        }

        public void setUuid(String r100) {
            this.uuid = r100;
        }

        public Body(float r100, String r101) {
            this.progress = r100;
            this.uuid = r101;
        }
    }

    public Body getBody() {
        return this.body;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setBody(Body r100) {
        this.body = r100;
    }

    public void setOperation(String r100) {
        this.operation = r100;
    }

    public UploadProgressModel(float r100, String r101) {
        this.operation = OPERATION_UPDATE;
        this.body = new Body(r100, r101);
    }
}
