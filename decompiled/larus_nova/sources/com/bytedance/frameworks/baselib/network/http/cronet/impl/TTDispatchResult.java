package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes6.dex */
public class TTDispatchResult {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Exception mDispatchException;
    public final DispatchState mDispatchState;
    public final String mEpoch;
    public final String mEtag;
    public final String mFinalUrl;
    public final String mOriginalUrl;
    public final String mTTNetOriginHost;

    public static final enum DispatchState extends Enum<DispatchState> {
        private static final /* synthetic */ DispatchState[] $VALUES = null;
        public static final DispatchState CRONET_NOT_INIT = null;
        public static final DispatchState INVALID_FINAL_URL = null;
        public static final DispatchState INVALID_ORIGIN_URL = null;
        public static final DispatchState NOT_REACHED = null;
        public static final DispatchState OKHTTP_DISPATCH_FAILED = null;
        public static final DispatchState SUCCESS = null;
        public static final DispatchState TIMEOUT = null;
        public static final DispatchState WRONG_FORMAT = null;

        static {
            DispatchState r100 = new DispatchState("SUCCESS", 0);
            SUCCESS = r100;
            DispatchState r101 = new DispatchState("INVALID_ORIGIN_URL", 1);
            INVALID_ORIGIN_URL = r101;
            DispatchState r102 = new DispatchState("CRONET_NOT_INIT", 2);
            CRONET_NOT_INIT = r102;
            DispatchState r103 = new DispatchState("TIMEOUT", 3);
            TIMEOUT = r103;
            DispatchState r104 = new DispatchState("INVALID_FINAL_URL", 4);
            INVALID_FINAL_URL = r104;
            DispatchState r105 = new DispatchState("WRONG_FORMAT", 5);
            WRONG_FORMAT = r105;
            DispatchState r110 = new DispatchState("OKHTTP_DISPATCH_FAILED", 6);
            OKHTTP_DISPATCH_FAILED = r110;
            DispatchState r111 = new DispatchState("NOT_REACHED", 7);
            NOT_REACHED = r111;
            $VALUES = new DispatchState[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static DispatchState[] values() {
            return (DispatchState[]) $VALUES.clone();
        }

        public static DispatchState valueOf(String r100) {
            return (DispatchState) r27.a.a(DispatchState.class, r100);
        }

        private DispatchState(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
    }

    public Exception getDispatchException() {
        return this.mDispatchException;
    }

    public DispatchState getDispatchState() {
        return this.mDispatchState;
    }

    public String getEpoch() {
        return this.mEpoch;
    }

    public String getEtag() {
        return this.mEtag;
    }

    public String getFinalUrl() {
        return this.mFinalUrl;
    }

    public String getOriginalUrl() {
        return this.mOriginalUrl;
    }

    public String getTTNetOriginHost() {
        return this.mTTNetOriginHost;
    }

    public TTDispatchResult(String r100, DispatchState r101, Exception r102) {
        this.mOriginalUrl = r100;
        this.mFinalUrl = r100;
        this.mEpoch = "0";
        this.mEtag = "0";
        this.mDispatchState = r101;
        this.mDispatchException = r102;
        this.mTTNetOriginHost = "";
    }

    public TTDispatchResult(String r100, String r101, String r102, String r103, DispatchState r104, String r105) {
        this.mOriginalUrl = r100;
        this.mFinalUrl = r101;
        if (TextUtils.isEmpty(r102) == true) goto L5;
        this.mEpoch = r102;
    L7:
        if (TextUtils.isEmpty(r103) == true) goto L9;
        this.mEtag = r103;
    L11:
        if (TextUtils.isEmpty(r105) == true) goto L13;
        this.mTTNetOriginHost = r105;
    L14:
        this.mDispatchState = r104;
        this.mDispatchException = null;
        return;
    L13:
        this.mTTNetOriginHost = "";
        goto L14
    L9:
        this.mEtag = "0";
        goto L11
    L5:
        this.mEpoch = "0";
        goto L7
    }
}
