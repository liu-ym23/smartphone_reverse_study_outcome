package com.ss.android.vesdk.filterparam;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class VEMattingTypeParam {
    public String algorithmConfigPath;
    public String extInfoJson;
    public String extMaskPath;
    public VEMattingType mattingType;
    public String workSpace;

    public static final enum VEMattingType extends Enum<VEMattingType> {
        public static final VEMattingType MATTING_TYPE_COMBINE = null;
        public static final VEMattingType MATTING_TYPE_EXTRA = null;
        public static final VEMattingType MATTING_TYPE_FACE = null;
        public static final VEMattingType MATTING_TYPE_FOLLOW = null;
        public static final VEMattingType MATTING_TYPE_HEAD = null;
        public static final VEMattingType MATTING_TYPE_INTERACTIVE = null;
        public static final VEMattingType MATTING_TYPE_NONE = null;
        public static final VEMattingType MATTING_TYPE_PORTRAIT = null;
        public static final VEMattingType MATTING_TYPE_SALIENCY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VEMattingType[] f455813a = null;

        static {
            VEMattingType r100 = new VEMattingType("MATTING_TYPE_NONE", 0);
            MATTING_TYPE_NONE = r100;
            VEMattingType r101 = new VEMattingType("MATTING_TYPE_PORTRAIT", 1);
            MATTING_TYPE_PORTRAIT = r101;
            VEMattingType r102 = new VEMattingType("MATTING_TYPE_HEAD", 2);
            MATTING_TYPE_HEAD = r102;
            VEMattingType r103 = new VEMattingType("MATTING_TYPE_INTERACTIVE", 3);
            MATTING_TYPE_INTERACTIVE = r103;
            VEMattingType r104 = new VEMattingType("MATTING_TYPE_FOLLOW", 4);
            MATTING_TYPE_FOLLOW = r104;
            VEMattingType r105 = new VEMattingType("MATTING_TYPE_COMBINE", 5);
            MATTING_TYPE_COMBINE = r105;
            VEMattingType r110 = new VEMattingType("MATTING_TYPE_EXTRA", 6);
            MATTING_TYPE_EXTRA = r110;
            VEMattingType r111 = new VEMattingType("MATTING_TYPE_FACE", 7);
            MATTING_TYPE_FACE = r111;
            VEMattingType r112 = new VEMattingType("MATTING_TYPE_SALIENCY", 8);
            MATTING_TYPE_SALIENCY = r112;
            f455813a = new VEMattingType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        }

        public static VEMattingType[] values() {
            return (VEMattingType[]) f455813a.clone();
        }

        public static VEMattingType valueOf(String r100) {
            return (VEMattingType) a.a(VEMattingType.class, r100);
        }

        public VEMattingType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public int getMattingTypeByNative() {
        return this.mattingType.ordinal();
    }

    public VEMattingTypeParam() {
        this.mattingType = VEMattingType.MATTING_TYPE_NONE;
    }
}
