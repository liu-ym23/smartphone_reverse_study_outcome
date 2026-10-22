package com.xiaomi.clientreport.data;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.bk;

/* JADX INFO: loaded from: classes41.dex */
public class Config {
    public static final boolean DEFAULT_EVENT_ENCRYPTED = true;
    public static final long DEFAULT_EVENT_UPLOAD_FREQUENCY = 86400;
    public static final boolean DEFAULT_EVENT_UPLOAD_SWITCH_OPEN = false;
    public static final long DEFAULT_MAX_FILE_LENGTH = 1048576;
    public static final long DEFAULT_PERF_UPLOAD_FREQUENCY = 86400;
    public static final boolean DEFAULT_PERF_UPLOAD_SWITCH_OPEN = false;
    private String mAESKey;
    private boolean mEventEncrypted;
    private long mEventUploadFrequency;
    private boolean mEventUploadSwitchOpen;
    private long mMaxFileLength;
    private long mPerfUploadFrequency;
    private boolean mPerfUploadSwitchOpen;

    /* JADX INFO: renamed from: com.xiaomi.clientreport.data.Config$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private String mAESKey;
        private int mEventEncrypted;
        private long mEventUploadFrequency;
        private int mEventUploadSwitchOpen;
        private long mMaxFileLength;
        private long mPerfUploadFrequency;
        private int mPerfUploadSwitchOpen;

        public Builder() {
            this.mEventEncrypted = -1;
            this.mEventUploadSwitchOpen = -1;
            this.mPerfUploadSwitchOpen = -1;
            this.mAESKey = null;
            this.mMaxFileLength = -1;
            this.mEventUploadFrequency = -1;
            this.mPerfUploadFrequency = -1;
        }

        public static /* synthetic */ int access$000(Builder r100) {
            return r100.mEventEncrypted;
        }

        public static /* synthetic */ String access$100(Builder r100) {
            return r100.mAESKey;
        }

        public static /* synthetic */ long access$200(Builder r100) {
            return r100.mMaxFileLength;
        }

        public static /* synthetic */ long access$300(Builder r100) {
            return r100.mEventUploadFrequency;
        }

        public static /* synthetic */ long access$400(Builder r100) {
            return r100.mPerfUploadFrequency;
        }

        public static /* synthetic */ int access$500(Builder r100) {
            return r100.mEventUploadSwitchOpen;
        }

        public static /* synthetic */ int access$600(Builder r100) {
            return r100.mPerfUploadSwitchOpen;
        }

        public Config build(Context r100) {
            return new Config(r100, this, null);
        }

        public Builder setAESKey(String r100) {
            this.mAESKey = r100;
            return this;
        }

        public Builder setEventEncrypted(boolean r100) {
            this.mEventEncrypted = r100 ? 1 : 0;
            return this;
        }

        public Builder setEventUploadFrequency(long r100) {
            this.mEventUploadFrequency = r100;
            return this;
        }

        public Builder setEventUploadSwitchOpen(boolean r100) {
            this.mEventUploadSwitchOpen = r100 ? 1 : 0;
            return this;
        }

        public Builder setMaxFileLength(long r100) {
            this.mMaxFileLength = r100;
            return this;
        }

        public Builder setPerfUploadFrequency(long r100) {
            this.mPerfUploadFrequency = r100;
            return this;
        }

        public Builder setPerfUploadSwitchOpen(boolean r100) {
            this.mPerfUploadSwitchOpen = r100 ? 1 : 0;
            return this;
        }
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public String toString() {
        return "Config{mEventEncrypted=" + this.mEventEncrypted + ", mAESKey='" + this.mAESKey + "', mMaxFileLength=" + this.mMaxFileLength + ", mEventUploadSwitchOpen=" + this.mEventUploadSwitchOpen + ", mPerfUploadSwitchOpen=" + this.mPerfUploadSwitchOpen + ", mEventUploadFrequency=" + this.mEventUploadFrequency + ", mPerfUploadFrequency=" + this.mPerfUploadFrequency + '}';
    }

    private Config() {
        this.mEventEncrypted = true;
        this.mEventUploadSwitchOpen = false;
        this.mPerfUploadSwitchOpen = false;
        this.mMaxFileLength = 1048576;
        this.mEventUploadFrequency = 86400;
        this.mPerfUploadFrequency = 86400;
    }

    public long getEventUploadFrequency() {
        return this.mEventUploadFrequency;
    }

    public long getMaxFileLength() {
        return this.mMaxFileLength;
    }

    public long getPerfUploadFrequency() {
        return this.mPerfUploadFrequency;
    }

    public boolean isEventEncrypted() {
        return this.mEventEncrypted;
    }

    public boolean isEventUploadSwitchOpen() {
        return this.mEventUploadSwitchOpen;
    }

    public boolean isPerfUploadSwitchOpen() {
        return this.mPerfUploadSwitchOpen;
    }

    public static Config defaultConfig(Context r100) {
        return getBuilder().setEventEncrypted(true).setAESKey(bk.a(r100)).setMaxFileLength(1048576).setEventUploadSwitchOpen(false).setEventUploadFrequency(86400).setPerfUploadSwitchOpen(false).setPerfUploadFrequency(86400).build(r100);
    }

    private Config(Context r110, Builder r111) {
        this.mEventEncrypted = true;
        this.mEventUploadSwitchOpen = false;
        this.mPerfUploadSwitchOpen = false;
        this.mMaxFileLength = 1048576;
        this.mEventUploadFrequency = 86400;
        this.mPerfUploadFrequency = 86400;
        if (Builder.access$000(r111) != 0) goto L6;
        this.mEventEncrypted = false;
    L10:
        if (TextUtils.isEmpty(Builder.access$100(r111)) == true) goto L12;
        this.mAESKey = Builder.access$100(r111);
    L14:
        if (Builder.access$200(r111) <= (-1)) goto L16;
        this.mMaxFileLength = Builder.access$200(r111);
    L18:
        if (Builder.access$300(r111) <= (-1)) goto L20;
        this.mEventUploadFrequency = Builder.access$300(r111);
    L22:
        if (Builder.access$400(r111) <= (-1)) goto L24;
        this.mPerfUploadFrequency = Builder.access$400(r111);
    L26:
        if (Builder.access$500(r111) != 0) goto L29;
        this.mEventUploadSwitchOpen = false;
    L33:
        if (Builder.access$600(r111) != 0) goto L36;
        this.mPerfUploadSwitchOpen = false;
        return;
    L36:
        if (Builder.access$600(r111) != 1) goto L38;
        this.mPerfUploadSwitchOpen = true;
        return;
    L38:
        this.mPerfUploadSwitchOpen = false;
        return;
    L29:
        if (Builder.access$500(r111) != 1) goto L31;
        this.mEventUploadSwitchOpen = true;
        goto L33
    L31:
        this.mEventUploadSwitchOpen = false;
        goto L33
    L24:
        this.mPerfUploadFrequency = 86400;
        goto L26
    L20:
        this.mEventUploadFrequency = 86400;
        goto L22
    L16:
        this.mMaxFileLength = 1048576;
        goto L18
    L12:
        this.mAESKey = bk.a(r110);
        goto L14
    L6:
        if (Builder.access$000(r111) != 1) goto L8;
        this.mEventEncrypted = true;
        goto L10
    L8:
        this.mEventEncrypted = true;
        goto L10
    }

    public /* synthetic */ Config(Context r100, Builder r101, AnonymousClass1 r102) {
        this(r100, r101);
    }
}
