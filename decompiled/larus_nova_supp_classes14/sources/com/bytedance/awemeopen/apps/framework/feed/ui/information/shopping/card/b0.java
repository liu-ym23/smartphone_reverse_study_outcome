package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card;

import com.bytedance.awemeopen.bizmodels.feed.shopping.card.DetailPromotion;
import java.util.List;
import java.util.Map;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b0 extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b {
    public final tz3.b<com.bytedance.awemeopen.infra.base.image.b> a;
    public final tz3.b<Triple<String, String, String>> b;
    public final tz3.b<Map<String, String>> c;
    public final tz3.b<List<String>> d;
    public final tz3.b<Boolean> e;
    public final tz3.b<List<DetailPromotion>> f;
    public final tz3.b<Unit> g;
    public final tz3.b<Boolean> h;
    public final tz3.b<Unit> i;
    public final tz3.b<Boolean> j;

    public final void a() {
        this.b.b(new Triple(null, null, null));
        this.c.b(null);
        this.d.b(CollectionsKt.emptyList());
        tz3.b<Boolean> r0 = this.e;
        Boolean r1 = Boolean.FALSE;
        r0.b(r1);
        this.f.b(null);
        this.h.b(r1);
        this.j.b(r1);
    }

    public b0() {
        this.a = new tz3.b();
        this.b = new tz3.b();
        this.c = new tz3.b();
        this.d = new tz3.b();
        this.e = new tz3.b();
        this.f = new tz3.b();
        this.g = new tz3.b();
        this.h = new tz3.b();
        this.i = new tz3.b();
        this.j = new tz3.b();
    }
}
