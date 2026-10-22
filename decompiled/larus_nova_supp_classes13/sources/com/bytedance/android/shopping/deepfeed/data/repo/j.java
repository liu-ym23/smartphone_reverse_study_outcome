package com.bytedance.android.shopping.deepfeed.data.repo;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements uc3.f {
    public long a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public int o;
    public int p;
    public int q;
    public int r;
    public long s;
    public long t;
    public long u;
    public long v;
    public long w;

    public static final class a {
    }

    static {
    }

    public j() {
    }

    @Override // uc3.f
    public final Map<String, Object> a() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("t_page_route_start", 0L), TuplesKt.to("t_request_start_pack", 0L), TuplesKt.to("t_request_end_pack", Long.valueOf(this.a)), TuplesKt.to("t_request_start_feed", 0L), TuplesKt.to("t_request_end_feed", Long.valueOf(this.b)), TuplesKt.to("t_page_cache_show", Long.valueOf(this.c)), TuplesKt.to("t_first_card_show", Long.valueOf(this.d)), TuplesKt.to("t_page_show", Long.valueOf(this.e)), TuplesKt.to("slc_cache_card_draw_end", Long.valueOf(this.f)), TuplesKt.to("slc_first_card_draw_end", Long.valueOf(this.g)), TuplesKt.to("slc_second_card_draw_end", Long.valueOf(this.h)), TuplesKt.to("schema_cache_hit", 0), TuplesKt.to("slc_cache_card_bind_end", Long.valueOf(this.i)), TuplesKt.to("slc_first_card_bind_end", Long.valueOf(this.j)), TuplesKt.to("slc_second_card_bind_end", Long.valueOf(this.k)), TuplesKt.to("cache_card_bind_start", Long.valueOf(this.l)), TuplesKt.to("first_card_bind_start", Long.valueOf(this.m)), TuplesKt.to("second_card_bind_start", Long.valueOf(this.n)), TuplesKt.to("activity_code_root", Integer.valueOf(this.o)), TuplesKt.to("fragment_pre_inflate_enabled", Integer.valueOf(this.p)), TuplesKt.to("fragment_pre_inflate_has_cache_entry", Integer.valueOf(this.q)), TuplesKt.to("fragment_pre_inflate_hit", Integer.valueOf(this.r)), TuplesKt.to("fragment_pre_inflate_request_time", Long.valueOf(this.s)), TuplesKt.to("fragment_pre_inflate_end_time", Long.valueOf(this.t)), TuplesKt.to("fragment_pre_inflate_consume_time", Long.valueOf(this.u)), TuplesKt.to("fragment_pre_inflate_cost", Long.valueOf(this.v)), TuplesKt.to("fragment_pre_inflate_wait_time", Long.valueOf(this.w))});
    }

    @Override // uc3.f
    public final void b(long r1) {
        this.f = r1;
    }

    @Override // uc3.f
    public final void c(long r1) {
        this.e = r1;
    }

    @Override // uc3.f
    public final void d(long r1) {
        this.k = r1;
    }

    @Override // uc3.f
    public final void e(long r1) {
        this.i = r1;
    }

    @Override // uc3.f
    public final void f(long r1) {
        this.d = r1;
    }

    @Override // uc3.f
    public final void g(long r1) {
        this.h = r1;
    }

    @Override // uc3.f
    public final void h(long r1) {
        this.g = r1;
    }

    @Override // uc3.f
    public final void i(long r1) {
        this.j = r1;
    }

    @Override // uc3.f
    public final void j(long r1) {
        this.a = r1;
    }

    @Override // uc3.f
    public final void k(long r1) {
        this.c = r1;
    }

    public final void l(boolean r2, boolean r3, boolean r4, long r5, long r7, long r9) {
        this.p = r2 ? 1 : 0;
        this.q = r3 ? 1 : 0;
        this.r = r4 ? 1 : 0;
        this.s = r5;
        this.t = r7;
        this.u = r9;
        long r6 = 0;
        if (r5 > 0) goto L5;
    L7:
        long r8 = 0;
    L8:
        this.v = r8;
        if (r5 > 0) goto L11;
    L13:
        this.w = r6;
        return;
    L11:
        if (r9 <= 0) goto L13;
        r6 = r9 - r5;
        goto L13
    L5:
        if (r7 <= 0) goto L7;
        r8 = r7 - r5;
        goto L8
    }
}
