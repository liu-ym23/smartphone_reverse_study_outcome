package com.ss.android.ttve.vealgorithm.params;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes38.dex */
public class VEBachCommonImageParam extends VEAlgorithmParam {
    private static final int MATTTING_OUTPUTTYPE_NMP = 2;
    private static final int MATTTING_OUTPUTTYPE_PNG = 1;
    private static final int MATTTING_OUTPUTTYPE_RGBA = 0;
    public int algorithmType;
    public Bitmap[] bitmaps;
    public String configPath;
    public int mattingOutType;
    public String outDir;
    public String path;
    public float reframeRatio;

    public VEBachCommonImageParam() {
        this.algorithmType = VEBachCommonImageType.VEBachAlgorithmTypeNone;
        this.configPath = "";
        this.mattingOutType = 0;
        this.outDir = null;
        this.bitmaps = null;
        this.type = VEAlgorithmType.VEAlgorithmTypeBachCommonImage;
    }
}
