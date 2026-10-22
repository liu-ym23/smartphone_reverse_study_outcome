package com.bytedance.tools.kcp.modelx.runtime.protobuf;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class h extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f271007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f271008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f271009d;

    @Override // com.bytedance.tools.kcp.modelx.runtime.protobuf.d
    public final int b() {
        return this.f271008c;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.protobuf.d
    public final int c() {
        return this.f271007b;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.protobuf.d
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "writer");
        String r101 = this.f271009d;
        Intrinsics.checkNotNullParameter(r101, "value");
        r100.f271006b.writeString(r101);
    }

    public h(int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "value");
        super(r110);
        this.f271009d = r111;
        this.f271007b = 2;
        int r100 = r111.length();
        boolean r101 = true;
        if (r100 < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L45;
        if (r100 <= r111.length()) goto L11;
        r101 = false;
    L11:
        if (r101 == false) goto L43;
        long r103 = 0;
        int r104 = 0;
    L13:
        if (r104 >= r100) goto L40;
        char r105 = r111.charAt(r104);
        if (r105 < 128) goto L16;
        if (r105 < 2048) goto L19;
        if (r105 < 55296) goto L37;
        if (r105 > 57343) goto L37;
        int r106 = r104 + 1;
        if (r106 >= r100) goto L28;
        char r112 = r111.charAt(r106);
    L30:
        if (r105 > 56319) goto L36;
        if (r112 < 56320) goto L36;
        if (r112 > 57343) goto L36;
        r103 = r103 + ((long) 4);
        r104 = r104 + 2;
    L36:
        r103 = r103 + 1;
        r104 = r106;
        goto L13
    L28:
        r112 = 0;
    L37:
        int r107 = 3;
    L38:
        r103 = r103 + ((long) r107);
    L39:
        r104 = r104 + 1;
        goto L13
    L19:
        r107 = 2;
        goto L38
    L16:
        r103 = r103 + 1;
        goto L39
    L40:
        this.f271008c = (int) r103;
        return;
    L43:
        throw new IllegalArgumentException(("endIndex > string.length: " + r100 + " > " + r111.length()).toString());
    L45:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r100 + " < 0").toString());
    L5:
        r102 = false;
        goto L6
    }
}
