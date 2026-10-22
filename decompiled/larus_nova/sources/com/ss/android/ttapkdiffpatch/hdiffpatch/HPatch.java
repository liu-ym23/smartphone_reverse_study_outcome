package com.ss.android.ttapkdiffpatch.hdiffpatch;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes38.dex */
public class HPatch {
    public HPatch() {
    }

    public static native int hpatch(String r100, String r101, String r102, long r103);

    public static native int hpatch(ByteBuffer[] r100, String r101, String r102, long r103);
}
