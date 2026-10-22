package com.ss.android.download.api.model;

/* JADX INFO: loaded from: classes34.dex */
public class QuickAppModel {
    private String mExtraData;
    private String mOpenUrl;

    public static class Builder {
        private String mExtraData;
        private String mOpenUrl;

        public Builder() {
        }

        public QuickAppModel build() {
            return new QuickAppModel(this);
        }

        public static /* synthetic */ String access$000(Builder r100) {
            return r100.mOpenUrl;
        }

        public static /* synthetic */ String access$100(Builder r100) {
            return r100.mExtraData;
        }

        public Builder setExtraData(String r100) {
            this.mExtraData = r100;
            return this;
        }

        public Builder setOpenUrl(String r100) {
            this.mOpenUrl = r100;
            return this;
        }
    }

    public String getExtData() {
        return this.mExtraData;
    }

    public String getQuickOpenUrl() {
        return this.mOpenUrl;
    }

    public QuickAppModel(Builder r100) {
        this.mOpenUrl = Builder.access$000(r100);
        this.mExtraData = Builder.access$100(r100);
    }
}
