package com.ss.bduploader;

/* JADX INFO: loaded from: classes40.dex */
public interface BDObjectUploaderListener {
    int objectUploadCheckNetState(int r100, int r101);

    void onLog(int r100, int r101, String r102);

    void onNotify(int r100, long r101, BDObjectInfo r102);
}
