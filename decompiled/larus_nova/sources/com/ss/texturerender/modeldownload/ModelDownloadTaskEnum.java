package com.ss.texturerender.modeldownload;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum ModelDownloadTaskEnum extends Enum<ModelDownloadTaskEnum> {
    private static final /* synthetic */ ModelDownloadTaskEnum[] $VALUES = null;
    public static final ModelDownloadTaskEnum OCL_SR_BMF = null;

    static {
        ModelDownloadTaskEnum r100 = new ModelDownloadTaskEnum("OCL_SR_BMF", 0);
        OCL_SR_BMF = r100;
        $VALUES = new ModelDownloadTaskEnum[]{r100};
    }

    public static ModelDownloadTaskEnum[] values() {
        return (ModelDownloadTaskEnum[]) $VALUES.clone();
    }

    public static ModelDownloadTaskEnum valueOf(String r100) {
        return (ModelDownloadTaskEnum) a.a(ModelDownloadTaskEnum.class, r100);
    }

    private ModelDownloadTaskEnum(String r100, int r101) {
        super(r100, r101);
    }
}
