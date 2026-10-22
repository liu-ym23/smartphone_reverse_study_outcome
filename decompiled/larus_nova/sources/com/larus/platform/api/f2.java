package com.larus.platform.api;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
public interface f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f365106a = null;

    public static final class a implements f2 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f365107b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<f2> f365108c = null;

        public a() {
        }

        static {
            f365107b = new a();
            f365108c = LazyKt.lazy(new e2());
        }

        public static f2 v() {
            return f365108c.getValue();
        }

        @Override // com.larus.platform.api.f2
        public final String a() {
            f2 r100 = v();
            if (r100 == null) goto L5;
            String r101 = r100.a();
        L6:
            if (r101 != null) goto L9;
            return "";
        L9:
            return r101;
        L5:
            r101 = null;
            goto L6
        }

        @Override // com.larus.platform.api.f2
        public final String audioMediaSceneConfig() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.audioMediaSceneConfig();
        }

        @Override // com.larus.platform.api.f2
        public final String b() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.b();
        }

        @Override // com.larus.platform.api.f2
        public final boolean c() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return true;
        L7:
            return r100.c();
        }

        @Override // com.larus.platform.api.f2
        public final boolean canGetDouyinLunaInstallBackground() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.canGetDouyinLunaInstallBackground();
        }

        @Override // com.larus.platform.api.f2
        public final long d() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return 1000;
        L7:
            return r100.d();
        }

        @Override // com.larus.platform.api.f2
        public final String e() {
            f2 r100 = v();
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

        @Override // com.larus.platform.api.f2
        public final boolean enableActRefreshProtect() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.enableActRefreshProtect();
        }

        @Override // com.larus.platform.api.f2
        public final boolean enableIndependentImageCache() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.enableIndependentImageCache();
        }

        @Override // com.larus.platform.api.f2
        public final boolean enableReconnectFrontierForDoraWhenBackground() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.enableReconnectFrontierForDoraWhenBackground();
        }

        @Override // com.larus.platform.api.f2
        public final String f() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f();
        }

        @Override // com.larus.platform.api.f2
        public final boolean g() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.g();
        }

        @Override // com.larus.platform.api.f2
        public final int getMediaRequestManagerConfig() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.getMediaRequestManagerConfig();
        }

        @Override // com.larus.platform.api.f2
        public final boolean h() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.h();
        }

        @Override // com.larus.platform.api.f2
        public final List<String> i() {
            f2 r100 = v();
            if (r100 == null) goto L7;
            List<String> r101 = r100.i();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return CollectionsKt.emptyList();
        }

        @Override // com.larus.platform.api.f2
        public final Boolean j() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.j();
        }

        @Override // com.larus.platform.api.f2
        public final String k() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.k();
        }

        @Override // com.larus.platform.api.f2
        public final Boolean l() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.l();
        }

        @Override // com.larus.platform.api.f2
        public final boolean m() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.m();
        }

        @Override // com.larus.platform.api.f2
        public final boolean n() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.n();
        }

        @Override // com.larus.platform.api.f2
        public final boolean o() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.o();
        }

        @Override // com.larus.platform.api.f2
        public final List<String> p() {
            return CollectionsKt.emptyList();
        }

        @Override // com.larus.platform.api.f2
        public final boolean q() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.q();
        }

        @Override // com.larus.platform.api.f2
        public final boolean r() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.r();
        }

        @Override // com.larus.platform.api.f2
        public final long s() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return 5000;
        L7:
            return r100.s();
        }

        @Override // com.larus.platform.api.f2
        public final String t() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.t();
        }

        @Override // com.larus.platform.api.f2
        public final boolean u() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.u();
        }

        @Override // com.larus.platform.api.f2
        public final boolean useNewAsrTasks() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.useNewAsrTasks();
        }

        @Override // com.larus.platform.api.f2
        public final boolean useNewAsrTasksV2() {
            f2 r100 = v();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.useNewAsrTasksV2();
        }
    }

    static {
        f365106a = a.f365107b;
    }

    String a();

    String audioMediaSceneConfig();

    String b();

    boolean c();

    boolean canGetDouyinLunaInstallBackground();

    long d();

    String e();

    boolean enableActRefreshProtect();

    boolean enableIndependentImageCache();

    boolean enableReconnectFrontierForDoraWhenBackground();

    String f();

    boolean g();

    int getMediaRequestManagerConfig();

    boolean h();

    List<String> i();

    Boolean j();

    String k();

    Boolean l();

    boolean m();

    boolean n();

    boolean o();

    List<String> p();

    boolean q();

    boolean r();

    long s();

    String t();

    boolean u();

    boolean useNewAsrTasks();

    boolean useNewAsrTasksV2();
}
