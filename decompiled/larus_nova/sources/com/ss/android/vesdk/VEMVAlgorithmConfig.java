package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public class VEMVAlgorithmConfig {
    public AlgorithmInfo[] infos;

    public class AlgorithmInfo {
        public AlgorithmItem[] items;
        public String photoPath;
        final /* synthetic */ VEMVAlgorithmConfig this$0;

        public class AlgorithmItem {
            public String algorithmName;
            public String algorithmParamJson;
            public boolean isNeedServerExecute;
            public MV_REESULT_OUT_TYPE result_out_type;
            final /* synthetic */ AlgorithmInfo this$1;

            public AlgorithmItem(AlgorithmInfo r100, String r101, boolean r102) {
                this(r100, r101, r102, null);
            }

            public AlgorithmItem(AlgorithmInfo r100, String r101, boolean r102, String r110) {
                this(r100, r101, r102, r110, -1);
            }

            public AlgorithmItem(AlgorithmInfo r100, String r101, boolean r102, String r103, int r104) {
                this.this$1 = r100;
                this.algorithmName = r101;
                this.isNeedServerExecute = r102;
                this.algorithmParamJson = r103;
                if (r104 != 0) goto L6;
                this.result_out_type = MV_REESULT_OUT_TYPE.MV_REESULT_OUT_TYPE_IMAGE;
                return;
            L6:
                if (r104 != 1) goto L9;
                this.result_out_type = MV_REESULT_OUT_TYPE.MV_REESULT_OUT_TYPE_VIDEO;
                return;
            L9:
                if (r104 != 2) goto L12;
                this.result_out_type = MV_REESULT_OUT_TYPE.MV_REESULT_OUT_TYPE_IMAGE_AND_JSON;
                return;
            L12:
                if (r104 != 3) goto L15;
                this.result_out_type = MV_REESULT_OUT_TYPE.MV_REESULT_OUT_TYPE_VIDEO_AND_JSON;
                return;
            L15:
                if (r104 != 4) goto L17;
                this.result_out_type = MV_REESULT_OUT_TYPE.MV_REESULT_OUT_TYPE_JSON;
                return;
            L17:
                this.result_out_type = MV_REESULT_OUT_TYPE.MV_REESULT_OUT_TYPE_INVALID;
            }
        }

        public AlgorithmInfo(VEMVAlgorithmConfig r100) {
            this.this$0 = r100;
        }
    }

    public static final enum MV_REESULT_IN_TYPE extends Enum<MV_REESULT_IN_TYPE> {
        private static final /* synthetic */ MV_REESULT_IN_TYPE[] $VALUES = null;
        public static final MV_REESULT_IN_TYPE MV_REESULT_IN_TYPE_IMAGE = null;
        public static final MV_REESULT_IN_TYPE MV_REESULT_IN_TYPE_JSON = null;
        public static final MV_REESULT_IN_TYPE MV_REESULT_IN_TYPE_VIDEO = null;

        private static /* synthetic */ MV_REESULT_IN_TYPE[] $values() {
            return new MV_REESULT_IN_TYPE[]{MV_REESULT_IN_TYPE_IMAGE, MV_REESULT_IN_TYPE_VIDEO, MV_REESULT_IN_TYPE_JSON};
        }

        static {
            MV_REESULT_IN_TYPE_IMAGE = new MV_REESULT_IN_TYPE("MV_REESULT_IN_TYPE_IMAGE", 0);
            MV_REESULT_IN_TYPE_VIDEO = new MV_REESULT_IN_TYPE("MV_REESULT_IN_TYPE_VIDEO", 1);
            MV_REESULT_IN_TYPE_JSON = new MV_REESULT_IN_TYPE("MV_REESULT_IN_TYPE_JSON", 2);
            $VALUES = $values();
        }

        public static MV_REESULT_IN_TYPE[] values() {
            return (MV_REESULT_IN_TYPE[]) $VALUES.clone();
        }

        public static MV_REESULT_IN_TYPE valueOf(String r100) {
            return (MV_REESULT_IN_TYPE) r27.a.a(MV_REESULT_IN_TYPE.class, r100);
        }

        private MV_REESULT_IN_TYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum MV_REESULT_OUT_TYPE extends Enum<MV_REESULT_OUT_TYPE> {
        private static final /* synthetic */ MV_REESULT_OUT_TYPE[] $VALUES = null;
        public static final MV_REESULT_OUT_TYPE MV_REESULT_OUT_TYPE_IMAGE = null;
        public static final MV_REESULT_OUT_TYPE MV_REESULT_OUT_TYPE_IMAGE_AND_JSON = null;
        public static final MV_REESULT_OUT_TYPE MV_REESULT_OUT_TYPE_INVALID = null;
        public static final MV_REESULT_OUT_TYPE MV_REESULT_OUT_TYPE_JSON = null;
        public static final MV_REESULT_OUT_TYPE MV_REESULT_OUT_TYPE_VIDEO = null;
        public static final MV_REESULT_OUT_TYPE MV_REESULT_OUT_TYPE_VIDEO_AND_JSON = null;

        private static /* synthetic */ MV_REESULT_OUT_TYPE[] $values() {
            return new MV_REESULT_OUT_TYPE[]{MV_REESULT_OUT_TYPE_IMAGE, MV_REESULT_OUT_TYPE_VIDEO, MV_REESULT_OUT_TYPE_IMAGE_AND_JSON, MV_REESULT_OUT_TYPE_VIDEO_AND_JSON, MV_REESULT_OUT_TYPE_JSON, MV_REESULT_OUT_TYPE_INVALID};
        }

        static {
            MV_REESULT_OUT_TYPE_IMAGE = new MV_REESULT_OUT_TYPE("MV_REESULT_OUT_TYPE_IMAGE", 0);
            MV_REESULT_OUT_TYPE_VIDEO = new MV_REESULT_OUT_TYPE("MV_REESULT_OUT_TYPE_VIDEO", 1);
            MV_REESULT_OUT_TYPE_IMAGE_AND_JSON = new MV_REESULT_OUT_TYPE("MV_REESULT_OUT_TYPE_IMAGE_AND_JSON", 2);
            MV_REESULT_OUT_TYPE_VIDEO_AND_JSON = new MV_REESULT_OUT_TYPE("MV_REESULT_OUT_TYPE_VIDEO_AND_JSON", 3);
            MV_REESULT_OUT_TYPE_JSON = new MV_REESULT_OUT_TYPE("MV_REESULT_OUT_TYPE_JSON", 4);
            MV_REESULT_OUT_TYPE_INVALID = new MV_REESULT_OUT_TYPE("MV_REESULT_OUT_TYPE_INVALID", 5);
            $VALUES = $values();
        }

        public static MV_REESULT_OUT_TYPE[] values() {
            return (MV_REESULT_OUT_TYPE[]) $VALUES.clone();
        }

        public static MV_REESULT_OUT_TYPE valueOf(String r100) {
            return (MV_REESULT_OUT_TYPE) r27.a.a(MV_REESULT_OUT_TYPE.class, r100);
        }

        private MV_REESULT_OUT_TYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public VEMVAlgorithmConfig() {
    }
}
