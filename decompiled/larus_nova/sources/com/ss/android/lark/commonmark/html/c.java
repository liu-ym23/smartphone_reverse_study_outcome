package com.ss.android.lark.commonmark.html;

import kotlin.jvm.internal.Intrinsics;
import v7b.b0;
import v7b.l;
import v7b.n;
import v7b.s;
import w7b.e;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f417165a;

    public c(boolean r100) {
        this.f417165a = r100;
    }

    @Override // w7b.e
    public final s a(s r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        c(r100, this.f417165a);
        return r100;
    }

    public static void b(s r100, StringBuilder r101) {
        if ((r100 instanceof b0) == false) goto L6;
        r101.append(((b0) r100).f553548j);
        return;
    L6:
        s r102 = r100.f553569e;
    L7:
        if (r102 == null) goto L9;
        s r103 = r102.f553572h;
        b(r102, r101);
        r102 = r103;
        goto L7
    }

    public static void c(s r100, boolean r101) {
        if (r101 == false) goto L36;
        boolean r102 = true;
        if ((r100 instanceof l) == false) goto L20;
        l r103 = (l) r100;
        String r104 = r103.f553560k;
        if (r104 != null) goto L8;
    L11:
        if (r102 == false) goto L16;
        StringBuilder r105 = new StringBuilder();
        s r106 = r100.f553569e;
    L13:
        if (r106 == null) goto L15;
        b(r106, r105);
        r106 = r106.f553572h;
        goto L13
    L15:
        r103.f553560k = r105.toString();
    L16:
        s r107 = r100.f553569e;
    L17:
        if (r107 == null) goto L70;
        s r108 = r107.f553572h;
        r107.p();
        r107 = r108;
        goto L17
    L70:
        return;
    L8:
        if (r104.length() == 0) goto L11;
        r102 = false;
        goto L11
    L20:
        if ((r100 instanceof n) == false) goto L32;
        n r109 = (n) r100;
        String r110 = r109.f553562k;
        if (r110 != null) goto L24;
    L27:
        if (r102 == false) goto L35;
        StringBuilder r111 = new StringBuilder();
        s r112 = r100.f553569e;
    L29:
        if (r112 == null) goto L31;
        b(r112, r111);
        r112 = r112.f553572h;
        goto L29
    L31:
        r109.f553562k = r111.toString();
        return;
    L35:
        return;
    L24:
        if (r110.length() == 0) goto L27;
        r102 = false;
        goto L27
    L32:
        s r113 = r100.f553569e;
    L33:
        if (r113 == null) goto L71;
        c(r113, r101);
        r113 = r113.f553572h;
        goto L33
    L71:
        return;
    L36:
        String r114 = "";
        if ((r100 instanceof l) == false) goto L46;
        l r115 = (l) r100;
        s r116 = r100.f553569e;
    L39:
        if (r116 == null) goto L44;
        if ((r116 instanceof b0) == false) goto L43;
        r114 = ((b0) r116).f553548j;
    L43:
        r116.p();
        r116 = r100.f553569e;
        goto L39
    L44:
        r115.f553560k = r114;
        return;
    L46:
        if ((r100 instanceof n) == false) goto L54;
        n r117 = (n) r100;
        s r118 = r100.f553569e;
    L48:
        if (r118 == null) goto L53;
        if ((r118 instanceof b0) == false) goto L52;
        r114 = ((b0) r118).f553548j;
    L52:
        r118.p();
        r118 = r100.f553569e;
        goto L48
    L53:
        r117.f553562k = r114;
        return;
    L54:
        s r119 = r100.f553569e;
    L55:
        if (r119 == null) goto L73;
        c(r119, r101);
        r119 = r119.f553572h;
        goto L55
    }
}
