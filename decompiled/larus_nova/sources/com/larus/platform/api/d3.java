package com.larus.platform.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public interface d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f365092a = null;

    public static final class a implements d3 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f365093b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<d3> f365094c = null;

        public a() {
        }

        static {
            f365093b = new a();
            f365094c = LazyKt.lazy(new c3());
        }

        @Override // com.larus.platform.api.d3
        public final void d() {
            d3 r100 = f365094c.getValue();
            if (r100 == null) goto L6;
            r100.d();
            return;
        }

        @Override // com.larus.platform.api.d3
        public final void e() {
            d3 r100 = f365094c.getValue();
            if (r100 == null) goto L6;
            r100.e();
            return;
        }

        @Override // com.larus.platform.api.d3
        public final void a(com.larus.commercemembership.impl.component.d r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            d3 r101 = f365094c.getValue();
            if (r101 == null) goto L6;
            r101.a(r100);
            return;
        }

        @Override // com.larus.platform.api.d3
        public final void b(com.larus.commercemembership.impl.component.d r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            d3 r101 = f365094c.getValue();
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        }

        @Override // com.larus.platform.api.d3
        public final boolean c(hq9.n3 r100) {
            d3 r101 = f365094c.getValue();
            if (r101 != null) goto L7;
            return false;
        L7:
            return r101.c(r100);
        }
    }

    static {
        f365092a = a.f365093b;
    }

    void a(com.larus.commercemembership.impl.component.d r100);

    void b(com.larus.commercemembership.impl.component.d r100);

    boolean c(hq9.n3 r100);

    void d();

    void e();
}
