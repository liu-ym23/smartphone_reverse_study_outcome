package com.ss.fastcl.algorithm;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class ML {

    public static final enum AlgoType extends Enum<AlgoType> {
        public static final AlgoType LGBM = null;
        public static final AlgoType XGB = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AlgoType[] f456614a = null;

        static {
            AlgoType r100 = new AlgoType("XGB", 0);
            XGB = r100;
            AlgoType r101 = new AlgoType("LGBM", 1);
            LGBM = r101;
            f456614a = new AlgoType[]{r100, r101};
        }

        public static AlgoType[] values() {
            return (AlgoType[]) f456614a.clone();
        }

        public static AlgoType valueOf(String r100) {
            return (AlgoType) a.a(AlgoType.class, r100);
        }

        public AlgoType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum MLErrorCode extends Enum<MLErrorCode> {
        public static final MLErrorCode ERR_DATA_ERR = null;
        public static final MLErrorCode ERR_LOAD_MODE_FAILED = null;
        public static final MLErrorCode ERR_PREDICATION = null;
        public static final MLErrorCode NO_ERROR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MLErrorCode[] f456615a = null;

        static {
            MLErrorCode r100 = new MLErrorCode("NO_ERROR", 0);
            NO_ERROR = r100;
            MLErrorCode r101 = new MLErrorCode("ERR_LOAD_MODE_FAILED", 1);
            ERR_LOAD_MODE_FAILED = r101;
            MLErrorCode r102 = new MLErrorCode("ERR_DATA_ERR", 2);
            ERR_DATA_ERR = r102;
            MLErrorCode r103 = new MLErrorCode("ERR_PREDICATION", 3);
            ERR_PREDICATION = r103;
            f456615a = new MLErrorCode[]{r100, r101, r102, r103};
        }

        public static MLErrorCode[] values() {
            return (MLErrorCode[]) f456615a.clone();
        }

        public static MLErrorCode valueOf(String r100) {
            return (MLErrorCode) a.a(MLErrorCode.class, r100);
        }

        public MLErrorCode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static native long nativeCreateEngineInstance(String r100, int r101);

    public static native void nativeDestroyEngine(long r100);

    public static native int nativePredicationEngine(long r100, long r101, long r102);

    public ML() {
        AlgoType r100 = AlgoType.XGB;
    }
}
