package com.ss.android.lark.integrator.im.feed_shared;

import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.integrator.im.feed_shared.dependency.c;
import com.ss.android.lark.integrator.im.feed_shared.dependency.d;
import com.ss.android.lark.integrator.im.feed_shared.dependency.e;
import com.ss.android.lark.integrator.im.feed_shared.dependency.f;
import com.ss.android.lark.integrator.im.feed_shared.dependency.g;
import com.ss.android.lark.integrator.im.feed_shared.dependency.j;
import com.ss.android.lark.integrator.im.feed_shared.dependency.k;
import com.ss.android.lark.integrator.im.feed_shared.dependency.m;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.l0;
import java.util.concurrent.ConcurrentHashMap;
import peb.b;

/* JADX INFO: loaded from: classes36.dex */
@ClaymoreImpl(b.class)
public class FeedSharedModuleDependency implements b {
    public static final String TAG = "FeedSharedModuleDependency";
    private static final l0 sDependencyFetcher = null;
    private final Context context;

    public class a implements b.e {
        @Override // peb.b.e
        public final void a() {
        }

        @Override // peb.b.e
        public final void b() {
        }

        public a() {
        }
    }

    public static /* synthetic */ b.c a(Class r100) {
        return lambda$getBrowserDependency$2(r100);
    }

    public static /* synthetic */ b.j b(Class r100) {
        return lambda$getResourceDependency$0(r100);
    }

    public static /* synthetic */ b.InterfaceC7189b c(Class r100) {
        return lambda$getAppConfigDependency$7(r100);
    }

    public static /* synthetic */ b.k d(Class r100) {
        return lambda$getSettingDependency$3(r100);
    }

    public static /* synthetic */ b.g e(Class r100) {
        return lambda$getGuideDependency$8(r100);
    }

    public static /* synthetic */ b.f f(Class r100) {
        return lambda$getFeatureGatingDependency$1(r100);
    }

    public static /* synthetic */ b.i g(Class r100) {
        return lambda$getPushDependency$9(r100);
    }

    public static /* synthetic */ b.a h(Class r100) {
        return lambda$getAccountDependency$6(r100);
    }

    public static /* synthetic */ b.d i(Class r100) {
        return lambda$getChatDependency$5(r100);
    }

    public static /* synthetic */ b.e j(FeedSharedModuleDependency r100, Class r101) {
        return r100.lambda$getDocDependency$4(r101);
    }

    static {
        sDependencyFetcher = new l0();
    }

    @Override // peb.b
    public b.a getAccountDependency() {
        l0 r100 = sDependencyFetcher;
        Object r101 = ((ConcurrentHashMap) r100.f444740a).get(b.a.class);
        if (r101 != null) goto L15;
        monitor-enter(r100);
        if (r101 == null) goto L16;
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L16:
        r101 = h(b.a.class);     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        ((ConcurrentHashMap) r100.f444740a).put(b.a.class, r101);     // Catch: Throwable -> L11
    L15:
        return (b.a) r101;
    }

    @Override // peb.b
    public b.InterfaceC7189b getAppConfigDependency() {
        l0 r100 = sDependencyFetcher;
        Object r101 = ((ConcurrentHashMap) r100.f444740a).get(b.InterfaceC7189b.class);
        if (r101 != null) goto L15;
        monitor-enter(r100);
        if (r101 == null) goto L16;
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L16:
        r101 = c(b.InterfaceC7189b.class);     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        ((ConcurrentHashMap) r100.f444740a).put(b.InterfaceC7189b.class, r101);     // Catch: Throwable -> L11
    L15:
        return (b.InterfaceC7189b) r101;
    }

    @Override // peb.b
    public b.c getBrowserDependency() {
        l0 r100 = sDependencyFetcher;
        Object r101 = ((ConcurrentHashMap) r100.f444740a).get(b.c.class);
        if (r101 != null) goto L15;
        monitor-enter(r100);
        if (r101 == null) goto L16;
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L16:
        r101 = a(b.c.class);     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        ((ConcurrentHashMap) r100.f444740a).put(b.c.class, r101);     // Catch: Throwable -> L11
    L15:
        return (b.c) r101;
    }

    @Override // peb.b
    public b.d getChatDependency() {
        l0 r100 = sDependencyFetcher;
        Object r101 = ((ConcurrentHashMap) r100.f444740a).get(b.d.class);
        if (r101 != null) goto L15;
        monitor-enter(r100);
        if (r101 == null) goto L16;
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L16:
        r101 = i(b.d.class);     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        ((ConcurrentHashMap) r100.f444740a).put(b.d.class, r101);     // Catch: Throwable -> L11
    L15:
        return (b.d) r101;
    }

    @Override // peb.b
    public b.e getDocDependency() {
        l0 r100 = sDependencyFetcher;
        Object r101 = ((ConcurrentHashMap) r100.f444740a).get(b.e.class);
        if (r101 != null) goto L15;
        monitor-enter(r100);
        if (r101 == null) goto L16;
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L16:
        r101 = j(this, b.e.class);     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        ((ConcurrentHashMap) r100.f444740a).put(b.e.class, r101);     // Catch: Throwable -> L11
    L15:
        return (b.e) r101;
    }

    @Override // peb.b
    public b.f getFeatureGatingDependency() {
        l0 r100 = sDependencyFetcher;
        Object r101 = ((ConcurrentHashMap) r100.f444740a).get(b.f.class);
        if (r101 != null) goto L15;
        monitor-enter(r100);
        if (r101 == null) goto L16;
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L16:
        r101 = f(b.f.class);     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        ((ConcurrentHashMap) r100.f444740a).put(b.f.class, r101);     // Catch: Throwable -> L11
    L15:
        return (b.f) r101;
    }

    @Override // peb.b
    public peb.a getFeedDependency() {
        return new f();
    }

    @Override // peb.b
    public b.g getGuideDependency() {
        l0 r100 = sDependencyFetcher;
        Object r101 = ((ConcurrentHashMap) r100.f444740a).get(b.g.class);
        if (r101 != null) goto L15;
        monitor-enter(r100);
        if (r101 == null) goto L16;
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L16:
        r101 = e(b.g.class);     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        ((ConcurrentHashMap) r100.f444740a).put(b.g.class, r101);     // Catch: Throwable -> L11
    L15:
        return (b.g) r101;
    }

    @Override // peb.b
    public b.i getPushDependency() {
        l0 r100 = sDependencyFetcher;
        Object r101 = ((ConcurrentHashMap) r100.f444740a).get(b.i.class);
        if (r101 != null) goto L15;
        monitor-enter(r100);
        if (r101 == null) goto L16;
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L16:
        r101 = g(b.i.class);     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        ((ConcurrentHashMap) r100.f444740a).put(b.i.class, r101);     // Catch: Throwable -> L11
    L15:
        return (b.i) r101;
    }

    @Override // peb.b
    public b.j getResourceDependency() {
        l0 r100 = sDependencyFetcher;
        Object r101 = ((ConcurrentHashMap) r100.f444740a).get(b.j.class);
        if (r101 != null) goto L15;
        monitor-enter(r100);
        if (r101 == null) goto L16;
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L16:
        r101 = b(b.j.class);     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        ((ConcurrentHashMap) r100.f444740a).put(b.j.class, r101);     // Catch: Throwable -> L11
    L15:
        return (b.j) r101;
    }

    @Override // peb.b
    public b.k getSettingDependency() {
        l0 r100 = sDependencyFetcher;
        Object r101 = ((ConcurrentHashMap) r100.f444740a).get(b.k.class);
        if (r101 != null) goto L15;
        monitor-enter(r100);
        if (r101 == null) goto L16;
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L16:
        r101 = d(b.k.class);     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        ((ConcurrentHashMap) r100.f444740a).put(b.k.class, r101);     // Catch: Throwable -> L11
    L15:
        return (b.k) r101;
    }

    public FeedSharedModuleDependency() {
        this.context = LarkContext.getApplication();
    }

    @Override // peb.b
    public Context getApplictaionContext() {
        return this.context;
    }

    private static /* synthetic */ b.a lambda$getAccountDependency$6(Class r100) {
        return new com.ss.android.lark.integrator.im.feed_shared.dependency.a();
    }

    private static /* synthetic */ b.InterfaceC7189b lambda$getAppConfigDependency$7(Class r100) {
        return new com.ss.android.lark.integrator.im.feed_shared.dependency.b();
    }

    private static /* synthetic */ b.c lambda$getBrowserDependency$2(Class r100) {
        return new c();
    }

    private static /* synthetic */ b.d lambda$getChatDependency$5(Class r100) {
        return new d();
    }

    private /* synthetic */ b.e lambda$getDocDependency$4(Class r100) {
        return new a();
    }

    private static /* synthetic */ b.f lambda$getFeatureGatingDependency$1(Class r100) {
        return new e();
    }

    private static /* synthetic */ b.g lambda$getGuideDependency$8(Class r100) {
        return new g();
    }

    private static /* synthetic */ b.i lambda$getPushDependency$9(Class r100) {
        return new j();
    }

    private static /* synthetic */ b.j lambda$getResourceDependency$0(Class r100) {
        return new k();
    }

    private static /* synthetic */ b.k lambda$getSettingDependency$3(Class r100) {
        return new m();
    }
}
