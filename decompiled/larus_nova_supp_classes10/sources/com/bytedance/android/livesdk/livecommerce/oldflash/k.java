package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class k extends c implements m {
    public boolean c;
    public boolean d;
    public boolean e;
    public xi2.k0 f;
    public String g;
    public n h;
    public int i;
    public int j;
    public int k;
    public Function0<? extends List<String>> l;
    public String m;
    public List<String> n;
    public String o;
    public final boolean p;

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.m
    public final boolean a() {
        if (this.a == false) goto L25;
        int r0 = this.k;
        if (r0 == 0) goto L18;
        if (r0 == 1) goto L15;
        String r1 = this.g;
        if (r1 != null) goto L10;
    L21:
        boolean r2 = false;
    L22:
        if (r2 == true) goto L26;
        return true;
    L26:
        return false;
    L10:
        if (r1.length() <= 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 != true) goto L21;
    L20:
        r2 = true;
        goto L22
    L12:
        r3 = false;
        goto L13
    L15:
        si2.i r4 = s.s;
        if (s.d.e(this.g, 100) <= 0) goto L21;
    L18:
        si2.i r5 = s.s;
        if (s.d.e(this.g, 1) <= 0) goto L21;
    L25:
        return false;
    }

    public final List<String> d() {
        Function0<? extends List<String>> r0 = this.l;
        if (r0 == null) goto L6;
        List<String> r1 = (List) r0.invoke();
        if (r1 == null) goto L6;
    L10:
        if (r1 == null) goto L12;
        return r1;
    L12:
        return new ArrayList();
    L6:
        xi2.k0 r2 = this.f;
        if (r2 == null) goto L9;
        r1 = r2.b();
        goto L10
    L9:
        r1 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.m
    public final String b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (this.p == true) goto L6;
        return th.a.h(r4, 2131896620, new Object[]{this.b});
    L6:
        return th.a.h(r4, 2131896619, new Object[]{this.b});
    }

    public String c(Context r4) {
        if (r4 == null) goto L4;
        String r5 = th.a.h(r4, 2131896579, new Object[]{this.b});
    L5:
        if (r5 != null) goto L8;
        return "";
    L8:
        return r5;
    L4:
        r5 = null;
        goto L5
    }

    public k(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "label");
        Intrinsics.checkNotNullParameter(r3, "hint");
        super(r2);
        this.o = r3;
        this.p = r4;
        this.i = 20;
        this.j = Integer.MIN_VALUE;
        this.k = 2;
        this.n = CollectionsKt.emptyList();
    }
}
