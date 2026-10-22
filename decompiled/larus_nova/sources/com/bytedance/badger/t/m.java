package com.bytedance.badger.t;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import kotlin.UByte;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes47.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f199207a;

    public m(byte[] r100) {
        this.f199207a = ByteBuffer.wrap(r100).order(ByteOrder.BIG_ENDIAN);
    }

    public final List a(int r100) {
        ArrayList r101 = new ArrayList();
    L4:
        if (this.f199207a.hasRemaining() == false) goto L10;
        int r102 = this.f199207a.position();
        if ((this.f199207a.get() & UByte.MAX_VALUE) == r100) goto L7;
        this.f199207a.position(r102);
        r101.add(b());
        goto L4
    L7:
        return r101;
    L10:
        throw new IllegalStateException("Missing end marker: " + r100);
    }

    public final l b() {
        int r100 = this.f199207a.get() & UByte.MAX_VALUE;
        boolean r101 = true;
        if (r100 != 1) goto L6;
        return new g(this.f199207a.getInt());
    L6:
        if (r100 != 2) goto L9;
        return new i(this.f199207a.getLong());
    L9:
        if (r100 != 5) goto L16;
        if (this.f199207a.get() != 0) goto L32;
        r101 = false;
    L32:
        return new e(r101);
    L16:
        if (r100 != 3) goto L19;
        byte[] r102 = new byte[this.f199207a.getShort() & 65535];
        this.f199207a.get(r102);
        return new k(new String(r102, Charsets.UTF_8));
    L19:
        if (r100 != 4) goto L22;
        byte[] r103 = new byte[this.f199207a.getShort() & 65535];
        this.f199207a.get(r103);
        return new f(r103);
    L22:
        if (r100 != 16) goto L25;
        return new j(a(17));
    L25:
        if (r100 != 32) goto L29;
        return new h(a(33));
    L29:
        throw new IllegalArgumentException("Unknown TLV type: " + r100);
    }
}
