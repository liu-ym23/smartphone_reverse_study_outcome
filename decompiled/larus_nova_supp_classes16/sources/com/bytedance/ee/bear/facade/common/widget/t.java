package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t extends s {
    public final Context g;
    public int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.s
    public final String a() {
        String r0 = this.g.getString(2131889728);
        return xo5.a.c(this.g, this.k, "contact_support", r0);
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.s
    public final String b() {
        String r0 = this.g.getString(2131889728);
        return xo5.a.c(this.g, this.j, "contact_support", r0);
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.s
    public final String c() {
        String r0 = this.g.getString(2131889727);
        return xo5.a.c(this.g, this.l, "appeal", r0);
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.s
    public final String d() {
        String r0 = this.g.getString(2131889726);
        return xo5.a.c(this.g, this.i, "progress", r0);
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.s
    public final String e() {
        String r0 = this.g.getString(2131889743);
        String r1 = this.g.getString(2131889742);
        HashMap r2 = new HashMap();
        r2.put("appeal", r1);
        r2.put("agreement", r0);
        return xo5.a.d(this.g, this.h, r2);
    }

    public t(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        super(r2);
        this.g = r2;
        this.h = 2131889729;
        this.i = 2131889725;
        this.j = 2131889724;
        this.k = 2131889723;
        this.l = 2131889722;
    }
}
