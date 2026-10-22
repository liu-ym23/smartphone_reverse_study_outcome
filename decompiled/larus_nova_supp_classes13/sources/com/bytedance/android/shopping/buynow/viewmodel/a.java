package com.bytedance.android.shopping.buynow.viewmodel;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.buynow.data.model.PageType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import nl.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public c a;
    public String b;
    public String c;
    public PageFinder d;
    public long e;
    public Float f;
    public String g;
    public int h;
    public boolean i;
    public Map<String, ? extends Object> j;
    public String k;
    public String l;
    public boolean m;

    public final boolean a() {
        return Intrinsics.areEqual(this.g, PageType.BUYNOW);
    }

    public final boolean b() {
        return Intrinsics.areEqual(this.g, PageType.CONTINUEPAY);
    }

    public final boolean c() {
        return Intrinsics.areEqual(this.g, PageType.ULTIMATEBUYNOW);
    }

    public a(int r4) {
        Intrinsics.checkNotNullParameter(PageType.BUYNOW, "pageType");
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = null;
        this.g = PageType.BUYNOW;
        this.h = 0;
        this.i = false;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = false;
    }
}
