package com.lynx.tasm;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes32.dex */
public abstract class PlatformCallBack {
    public PlatformCallBack() {
    }

    public abstract void a(Object r100);

    private void onDataBack(ByteBuffer r100) {
        j7a.a.f497652a.getClass();
        a(j7a.a.a(r100));
    }
}
