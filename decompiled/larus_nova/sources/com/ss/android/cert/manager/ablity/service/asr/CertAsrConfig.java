package com.ss.android.cert.manager.ablity.service.asr;

/* JADX INFO: loaded from: classes34.dex */
public class CertAsrConfig {
    public String address;
    public String appId;
    public String appToken;
    public int channel;
    public boolean isAutoDestroy;
    public String resourceId;
    public int sampleRate;
    public String uri;

    public static class Builder {
        private String address;
        private String appId;
        private String appToken;
        private int channel;
        private boolean isAutoDestroy;
        private String resourceId;
        private int sampleRate;
        private String uri;

        public CertAsrConfig build() {
            return new CertAsrConfig(this.address, this.uri, this.appId, this.appToken, this.resourceId, this.isAutoDestroy, this.sampleRate, this.channel);
        }

        public Builder() {
            this.isAutoDestroy = true;
            this.channel = 1;
            this.sampleRate = 0;
        }

        public Builder setAddress(String r100) {
            this.address = r100;
            return this;
        }

        public Builder setAppId(String r100) {
            this.appId = r100;
            return this;
        }

        public Builder setAppToken(String r100) {
            this.appToken = r100;
            return this;
        }

        public Builder setAutoDestroy(boolean r100) {
            this.isAutoDestroy = r100;
            return this;
        }

        public Builder setChannel(int r100) {
            this.channel = r100;
            return this;
        }

        public Builder setResourceId(String r100) {
            this.resourceId = r100;
            return this;
        }

        public Builder setSampleRate(int r100) {
            this.sampleRate = r100;
            return this;
        }

        public Builder setUri(String r100) {
            this.uri = r100;
            return this;
        }
    }

    public CertAsrConfig(String r100, String r101, String r102, String r103, String r104, boolean r105, int r106, int r107) {
        this.address = r100;
        this.uri = r101;
        this.appId = r102;
        this.appToken = r103;
        this.resourceId = r104;
        this.isAutoDestroy = r105;
        this.sampleRate = r106;
        this.channel = r107;
    }
}
