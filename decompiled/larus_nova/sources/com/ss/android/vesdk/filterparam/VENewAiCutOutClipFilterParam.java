package com.ss.android.vesdk.filterparam;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class VENewAiCutOutClipFilterParam extends VEBaseFilterParam {
    public long archer_strategy;
    public VEMattingTypeParam baseType;
    public String blendBackGroundColor;
    public VEMattingBlendMode blendMode;
    public VEMattingTypeParam curType;
    public boolean disableDownSampleForBach;
    public boolean disableSaveCacheInCompile;
    public VEMattingFollowParam followParam;
    public String rgba;
    public String strokeParamJson;

    public static final enum VEMattingBlendMode extends Enum<VEMattingBlendMode> {
        public static final VEMattingBlendMode MATTING_BLEND_MODE_NORMAL = null;
        public static final VEMattingBlendMode MATTING_BLEND_MODE_NORMAL_WITH_BACKGROUND = null;
        public static final VEMattingBlendMode MATTING_BLEND_MODE_PREVIEW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VEMattingBlendMode[] f455814a = null;

        static {
            VEMattingBlendMode r100 = new VEMattingBlendMode("MATTING_BLEND_MODE_NORMAL", 0);
            MATTING_BLEND_MODE_NORMAL = r100;
            VEMattingBlendMode r101 = new VEMattingBlendMode("MATTING_BLEND_MODE_PREVIEW", 1);
            MATTING_BLEND_MODE_PREVIEW = r101;
            VEMattingBlendMode r102 = new VEMattingBlendMode("MATTING_BLEND_MODE_NORMAL_WITH_BACKGROUND", 2);
            MATTING_BLEND_MODE_NORMAL_WITH_BACKGROUND = r102;
            f455814a = new VEMattingBlendMode[]{r100, r101, r102};
        }

        public static VEMattingBlendMode[] values() {
            return (VEMattingBlendMode[]) f455814a.clone();
        }

        public static VEMattingBlendMode valueOf(String r100) {
            return (VEMattingBlendMode) a.a(VEMattingBlendMode.class, r100);
        }

        public VEMattingBlendMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public int getMattingBlendModeByNative() {
        return this.blendMode.ordinal();
    }

    public VENewAiCutOutClipFilterParam() {
        this.archer_strategy = 0;
        this.blendMode = VEMattingBlendMode.MATTING_BLEND_MODE_NORMAL;
        this.curType = null;
        this.baseType = null;
        this.followParam = null;
        this.blendBackGroundColor = "#FF000000";
        this.disableSaveCacheInCompile = false;
        this.disableDownSampleForBach = false;
        this.filterName = "video matting filter name";
        this.filterType = 62;
        this.filterDurationType = 1;
    }
}
