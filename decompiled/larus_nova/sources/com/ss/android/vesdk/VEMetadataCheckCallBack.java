package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public interface VEMetadataCheckCallBack {
    public static final int VE_CHECK_METADATA_TIME_COST = 2;
    public static final int VE_INVALID_METADATA_READ = 0;
    public static final int VE_INVALID_METADATA_WRITE = 1;

    void onInfoCallback(int r100, String r101);
}
