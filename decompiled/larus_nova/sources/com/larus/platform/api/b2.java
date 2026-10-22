package com.larus.platform.api;

import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes4.dex */
public interface b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f364870a = null;

    public static final class a implements b2 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f364871b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<b2> f364872c = null;

        public a() {
        }

        static {
            f364871b = new a();
            f364872c = LazyKt.lazy(new a2());
        }

        public static b2 p() {
            return f364872c.getValue();
        }

        @Override // com.larus.platform.api.b2
        public final i a() {
            b2 r100 = p();
            if (r100 == null) goto L7;
            i r101 = r100.a();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return i.f365140h;
        }

        @Override // com.larus.platform.api.b2
        public final Map<String, String> b() {
            b2 r100 = p();
            if (r100 == null) goto L7;
            Map<String, String> r101 = r100.b();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return MapsKt.emptyMap();
        }

        @Override // com.larus.platform.api.b2
        public final String c() {
            b2 r100 = p();
            if (r100 == null) goto L8;
            String r101 = r100.c();
            if (r101 == null) goto L8;
            return r101;
        L8:
            throw new IllegalStateException("Host must provide SecLink base URL".toString());
        }

        @Override // com.larus.platform.api.b2
        public final hq9.q1 d() {
            b2 r100 = p();
            if (r100 == null) goto L7;
            hq9.q1 r101 = r100.d();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return new hq9.q1(0);
        }

        @Override // com.larus.platform.api.b2
        public final String e() {
            b2 r100 = p();
            if (r100 == null) goto L5;
            String r101 = r100.e();
        L6:
            if (r101 != null) goto L9;
            return "";
        L9:
            return r101;
        L5:
            r101 = null;
            goto L6
        }

        @Override // com.larus.platform.api.b2
        public final Map<String, String> f() {
            b2 r100 = p();
            if (r100 == null) goto L7;
            Map<String, String> r101 = r100.f();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return MapsKt.emptyMap();
        }

        @Override // com.larus.platform.api.b2
        public final String g() {
            b2 r100 = p();
            if (r100 == null) goto L6;
            String r101 = r100.g();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.larus.platform.api.b2
        public final Map<String, String> getCommonParams() {
            b2 r100 = p();
            if (r100 == null) goto L7;
            Map<String, String> r101 = r100.getCommonParams();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return MapsKt.emptyMap();
        }

        @Override // com.larus.platform.api.b2
        public final int getPluginVersion() {
            b2 r100 = p();
            if (r100 != null) goto L7;
            return -1;
        L7:
            return r100.getPluginVersion();
        }

        @Override // com.larus.platform.api.b2
        public final String h() {
            b2 r100 = p();
            if (r100 == null) goto L6;
            String r101 = r100.h();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.larus.platform.api.b2
        public final List<String> i() {
            b2 r100 = p();
            if (r100 == null) goto L7;
            List<String> r101 = r100.i();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return CollectionsKt.emptyList();
        }

        @Override // com.larus.platform.api.b2
        public final String j() {
            b2 r100 = p();
            if (r100 == null) goto L8;
            String r101 = r100.j();
            if (r101 == null) goto L8;
            return r101;
        L8:
            throw new IllegalStateException("Host must provide settings base URL".toString());
        }

        @Override // com.larus.platform.api.b2
        public final String k() {
            b2 r100 = p();
            if (r100 == null) goto L6;
            String r101 = r100.k();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.larus.platform.api.b2
        public final String l() {
            b2 r100 = p();
            if (r100 == null) goto L6;
            String r101 = r100.l();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.larus.platform.api.b2
        public final Object m() {
            b2 r100 = p();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.m();
        }

        @Override // com.larus.platform.api.b2
        public final Object n() {
            b2 r100 = p();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.n();
        }

        @Override // com.larus.platform.api.b2
        public final String o() {
            b2 r100 = p();
            if (r100 == null) goto L6;
            String r101 = r100.o();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }
    }

    static {
        f364870a = a.f364871b;
    }

    i a();

    Map<String, String> b();

    String c();

    hq9.q1 d();

    String e();

    Map<String, String> f();

    String g();

    Map<String, String> getCommonParams();

    int getPluginVersion();

    String h();

    List<String> i();

    String j();

    String k();

    String l();

    Object m();

    Object n();

    String o();
}
