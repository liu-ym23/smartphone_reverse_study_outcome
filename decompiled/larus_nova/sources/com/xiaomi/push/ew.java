package com.xiaomi.push;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes41.dex */
public final class ew extends eq {
    public ew() {
        a("PING", null);
        a("0");
        a(0);
    }

    @Override // com.xiaomi.push.eq
    public int c() {
        if (m9062a().length != 0) goto L7;
        return 0;
    L7:
        return super.c();
    }

    @Override // com.xiaomi.push.eq
    /* JADX INFO: renamed from: a */
    public ByteBuffer mo9059a(ByteBuffer r100) {
        if (m9062a().length != 0) goto L6;
        return r100;
    L6:
        return super.mo9059a(r100);
    }
}
