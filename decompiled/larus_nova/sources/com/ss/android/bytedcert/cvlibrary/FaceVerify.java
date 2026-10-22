package com.ss.android.bytedcert.cvlibrary;

import hsa.a;

/* JADX INFO: loaded from: classes34.dex */
public class FaceVerify extends a {
    public native int native_FV_AddOri(byte[] r100, int r101, int r102, int r103, int r104, int r105);

    public native int native_FV_CreateHandler(String r100, String r101);

    public native int native_FV_ReleaseHandle();

    public native int native_FV_Verify(byte[] r100, int r101, int r102, int r103, int r104, int r105);

    public FaceVerify() {
    }
}
