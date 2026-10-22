package com.ss.android.lark.keyboard;

import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import cya.c;
import cya.d;
import cya.h;
import cya.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    public static final d a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        com.ss.android.lark.keyboard.keyboard2.b r101 = r100.L();
        if ((r101 instanceof c) == false) goto L5;
        c r102 = (c) r101;
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.a();
    L5:
        r102 = null;
        goto L6
    }

    public static final String b(b r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        d r101 = a(r100);
        if (r101 == null) goto L8;
        h r102 = r101.d();
    L9:
        boolean r103 = false;
        if (r102 != null) goto L12;
    L14:
        if (r103 == false) goto L22;
        i r104 = (i) r102.f465978a.a(i.f465980h);
        if (r104 == null) goto L23;
        String r105 = r104.f465981a;
        if (r105 != null) goto L21;
        return "";
    L21:
        return r105;
    L23:
        return "";
    L22:
        return "";
    L12:
        if (r102.a() != 2) goto L14;
        r103 = true;
        goto L14
    L8:
        r102 = null;
        goto L9
    }

    public static final PartialReplyInfo c(b r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        d r101 = a(r100);
        if (r101 == null) goto L8;
        h r102 = r101.d();
    L9:
        boolean r103 = false;
        if (r102 != null) goto L12;
    L14:
        if (r103 == false) goto L19;
        i r104 = (i) r102.f465978a.a(i.f465980h);
        if (r104 != null) goto L18;
        return null;
    L18:
        return r104.f465987g;
    L19:
        return null;
    L12:
        if (r102.a() != 2) goto L14;
        r103 = true;
        goto L14
    L8:
        r102 = null;
        goto L9
    }

    public static final String d(b r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        d r101 = a(r100);
        if (r101 == null) goto L8;
        h r102 = r101.d();
    L9:
        boolean r103 = false;
        if (r102 != null) goto L12;
    L14:
        if (r103 == false) goto L22;
        i r104 = (i) r102.f465978a.a(i.f465980h);
        if (r104 == null) goto L23;
        String r105 = r104.f465982b;
        if (r105 != null) goto L21;
        return "";
    L21:
        return r105;
    L23:
        return "";
    L22:
        return "";
    L12:
        if (r102.a() != 2) goto L14;
        r103 = true;
        goto L14
    L8:
        r102 = null;
        goto L9
    }
}
