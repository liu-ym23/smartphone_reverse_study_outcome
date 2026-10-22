package com.bytedance.vmsdk.worker;

/* JADX INFO: loaded from: classes3.dex */
public interface IWorkerExceptionDelegate {

    /* JADX INFO: loaded from: classes22.dex */
    public static final enum ErrorCode extends Enum<ErrorCode> {
        public static final ErrorCode VMSDK_ERROR_CODE_JNI = null;
        public static final ErrorCode VMSDK_ERROR_CODE_JS = null;
        public static final ErrorCode VMSDK_ERROR_CODE_SCRIPT_EMPTY = null;
        public static final ErrorCode VMSDK_ERROR_CODE_SUCCESS = null;
        public static final ErrorCode VMSDK_ERROR_CODE_UNKNOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ErrorCode[] f272514a = null;
        public int mValue;

        static {
            ErrorCode r100 = new ErrorCode("VMSDK_ERROR_CODE_UNKNOW", 0, -1);
            VMSDK_ERROR_CODE_UNKNOW = r100;
            ErrorCode r101 = new ErrorCode("VMSDK_ERROR_CODE_SUCCESS", 1, 0);
            VMSDK_ERROR_CODE_SUCCESS = r101;
            ErrorCode r102 = new ErrorCode("VMSDK_ERROR_CODE_JNI", 2, 100);
            VMSDK_ERROR_CODE_JNI = r102;
            ErrorCode r103 = new ErrorCode("VMSDK_ERROR_CODE_JS", 3, 200);
            VMSDK_ERROR_CODE_JS = r103;
            ErrorCode r104 = new ErrorCode("VMSDK_ERROR_CODE_SCRIPT_EMPTY", 4, 300);
            VMSDK_ERROR_CODE_SCRIPT_EMPTY = r104;
            f272514a = new ErrorCode[]{r100, r101, r102, r103, r104};
        }

        public static ErrorCode[] values() {
            return (ErrorCode[]) f272514a.clone();
        }

        public static ErrorCode toErrorCode(int r100) {
            ErrorCode[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            ErrorCode r104 = r101[r103];
            if (r100 == r104.mValue) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            return VMSDK_ERROR_CODE_UNKNOW;
        }

        public static ErrorCode valueOf(String r100) {
            return (ErrorCode) r27.a.a(ErrorCode.class, r100);
        }

        public ErrorCode(String r100, int r101, int r102) {
            super(r100, r101);
            this.mValue = r102;
        }
    }

    void onError(int r100, String r101);
}
