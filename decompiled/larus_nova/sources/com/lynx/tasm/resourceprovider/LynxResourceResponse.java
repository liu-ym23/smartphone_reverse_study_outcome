package com.lynx.tasm.resourceprovider;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final class LynxResourceResponse<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ResponseState f383708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f383709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Throwable f383710c;

    public static final enum ResponseState extends Enum<ResponseState> {
        public static final ResponseState FAILED = null;
        public static final ResponseState SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ResponseState[] f383711a = null;

        static {
            ResponseState r100 = new ResponseState("FAILED", 0);
            FAILED = r100;
            ResponseState r101 = new ResponseState("SUCCESS", 1);
            SUCCESS = r101;
            f383711a = new ResponseState[]{r100, r101};
        }

        public static ResponseState[] values() {
            return (ResponseState[]) f383711a.clone();
        }

        public static ResponseState valueOf(String r100) {
            return (ResponseState) a.a(ResponseState.class, r100);
        }

        public ResponseState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public LynxResourceResponse() {
    }

    public static LynxResourceResponse a(Throwable r100) {
        LynxResourceResponse r101 = new LynxResourceResponse();
        r101.f383708a = ResponseState.FAILED;
        r101.f383710c = r100;
        return r101;
    }

    public static <T> LynxResourceResponse<T> b(T r100) {
        LynxResourceResponse<T> r101 = new LynxResourceResponse();
        r101.f383708a = ResponseState.SUCCESS;
        r101.f383709b = r100;
        return r101;
    }
}
