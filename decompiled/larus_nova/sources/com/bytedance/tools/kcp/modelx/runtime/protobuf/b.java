package com.bytedance.tools.kcp.modelx.runtime.protobuf;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f270999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f271000b;

    public b(boolean r100) {
        this.f271000b = r100;
        this.f270999a = new ArrayList();
    }

    public final MessagePayload a(int r100) {
        return new MessagePayload(r100, this.f270999a);
    }

    public final void b(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (this.f271000b == true) goto L5;
    L10:
        ((ArrayList) this.f270999a).add(new a(r101, r100));
        return;
    L5:
        if (r100.length != 0) goto L7;
        boolean r102 = true;
    L9:
        if ((!r102) == true) goto L10;
        return;
    L7:
        r102 = false;
        goto L9
    }

    public final void c(int r100, int r101) {
        if (this.f271000b == false) goto L5;
        if (r100 != 0) goto L5;
        return;
    L5:
        List<d> r102 = this.f270999a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new c(r101, r100));
    }

    public final void d(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (this.f271000b == true) goto L5;
    L9:
        List<d> r102 = this.f270999a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new h(r101, r100));
        return;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L9;
        return;
    L7:
        r104 = false;
        goto L8
    }
}
