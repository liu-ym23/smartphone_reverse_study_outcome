package com.xiaomi.mipush.sdk;

import com.xiaomi.push.service.module.PushChannelRegion;

/* JADX INFO: loaded from: classes41.dex */
public class PushConfiguration {
    private boolean mGeoEnable;
    private boolean mOpenCOSPush;
    private boolean mOpenFCMPush;
    private boolean mOpenFTOSPush;
    private boolean mOpenHmsPush;
    private PushChannelRegion mRegion;

    /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.PushConfiguration$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class PushConfigurationBuilder {
        private boolean mGeoEnable;
        private boolean mOpenCOSPush;
        private boolean mOpenFCMPush;
        private boolean mOpenFTOSPush;
        private boolean mOpenHmsPush;
        private PushChannelRegion mRegion;

        public PushConfiguration build() {
            return new PushConfiguration(this, null);
        }

        public PushConfigurationBuilder() {
        }

        public static /* synthetic */ PushChannelRegion access$000(PushConfigurationBuilder r100) {
            return r100.mRegion;
        }

        public static /* synthetic */ boolean access$100(PushConfigurationBuilder r100) {
            return r100.mOpenHmsPush;
        }

        public static /* synthetic */ boolean access$200(PushConfigurationBuilder r100) {
            return r100.mOpenFCMPush;
        }

        public static /* synthetic */ boolean access$300(PushConfigurationBuilder r100) {
            return r100.mOpenCOSPush;
        }

        public static /* synthetic */ boolean access$400(PushConfigurationBuilder r100) {
            return r100.mOpenFTOSPush;
        }

        public PushConfigurationBuilder openCOSPush(boolean r100) {
            this.mOpenCOSPush = r100;
            return this;
        }

        public PushConfigurationBuilder openFCMPush(boolean r100) {
            this.mOpenFCMPush = r100;
            return this;
        }

        public PushConfigurationBuilder openFTOSPush(boolean r100) {
            this.mOpenFTOSPush = r100;
            return this;
        }

        public PushConfigurationBuilder openHmsPush(boolean r100) {
            this.mOpenHmsPush = r100;
            return this;
        }

        public PushConfigurationBuilder region(PushChannelRegion r100) {
            this.mRegion = r100;
            return this;
        }
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer("PushConfiguration{Region:");
        PushChannelRegion r101 = this.mRegion;
        if (r101 != null) goto L5;
        r100.append("null");
    L6:
        r100.append(",mOpenHmsPush:" + this.mOpenHmsPush);
        r100.append(",mOpenFCMPush:" + this.mOpenFCMPush);
        r100.append(",mOpenCOSPush:" + this.mOpenCOSPush);
        r100.append(",mOpenFTOSPush:" + this.mOpenFTOSPush);
        r100.append('}');
        return r100.toString();
    L5:
        r100.append(r101.name());
        goto L6
    }

    public PushConfiguration() {
        this.mRegion = PushChannelRegion.China;
        this.mOpenHmsPush = false;
        this.mOpenFCMPush = false;
        this.mOpenCOSPush = false;
        this.mOpenFTOSPush = false;
    }

    public boolean getOpenCOSPush() {
        return this.mOpenCOSPush;
    }

    public boolean getOpenFCMPush() {
        return this.mOpenFCMPush;
    }

    public boolean getOpenFTOSPush() {
        return this.mOpenFTOSPush;
    }

    public boolean getOpenHmsPush() {
        return this.mOpenHmsPush;
    }

    public PushChannelRegion getRegion() {
        return this.mRegion;
    }

    private PushConfiguration(PushConfigurationBuilder r100) {
        if (PushConfigurationBuilder.access$000(r100) != null) goto L5;
        PushChannelRegion r101 = PushChannelRegion.China;
    L6:
        this.mRegion = r101;
        this.mOpenHmsPush = PushConfigurationBuilder.access$100(r100);
        this.mOpenFCMPush = PushConfigurationBuilder.access$200(r100);
        this.mOpenCOSPush = PushConfigurationBuilder.access$300(r100);
        this.mOpenFTOSPush = PushConfigurationBuilder.access$400(r100);
        return;
    L5:
        r101 = PushConfigurationBuilder.access$000(r100);
        goto L6
    }

    public void setOpenCOSPush(boolean r100) {
        this.mOpenCOSPush = r100;
    }

    public void setOpenFCMPush(boolean r100) {
        this.mOpenFCMPush = r100;
    }

    public void setOpenFTOSPush(boolean r100) {
        this.mOpenFTOSPush = r100;
    }

    public void setOpenHmsPush(boolean r100) {
        this.mOpenHmsPush = r100;
    }

    public void setRegion(PushChannelRegion r100) {
        this.mRegion = r100;
    }

    public /* synthetic */ PushConfiguration(PushConfigurationBuilder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
