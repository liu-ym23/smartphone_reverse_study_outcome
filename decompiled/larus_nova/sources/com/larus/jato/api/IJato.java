package com.larus.jato.api;

import android.app.Application;
import android.content.Context;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.larus.nova.NovaApplication;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wg9.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0002\b\f\bg\u0018\u0000 92\u00020\u0001:\u00019J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\nH&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0\u001eH&J\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0003H&J\b\u0010\"\u001a\u00020\u0003H&J\b\u0010#\u001a\u00020\u0003H&J\b\u0010$\u001a\u00020\u0003H&J\b\u0010%\u001a\u00020\u0003H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0005H&J\u0018\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0005H&J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.H&J\b\u0010/\u001a\u00020\u0003H&J\u0018\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\u0014H&J\b\u00103\u001a\u00020\u0003H&J\u0010\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u001fH&J\u0010\u00106\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u001fH&J\u0010\u00107\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u00108\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006:"}, d2 = {"Lcom/larus/jato/api/IJato;", "", "initJato", "", "enableLogCut", "", "appContext", "Landroid/content/Context;", "requestBlockGc", "duration", "", "disableClassVerify", "logCutStart", "bypassPoisonDeadObjects", "initInterpreterBridge", "hiddenApiOptDoOptimize", "optScheduler", "boostGLESInit", "boostRenderThread", "priority", "", "application", "Landroid/app/Application;", "cpuAndGpuBoost", "boostDuration", "createBoostFramework", "optLargeObj", "optimizeGCForWeakReferences", "throwableUnwindOptDoOptimize", "getLeakRecords", "", "", "initMemoryLeakCheck", "resetRenderThread", "releaseBoost", "bindBigCore", "bindSmallCore", "resetCoreBind", "setThreadPriority", "removeGCWaitingBlock", "onlyOptimizeMainThread", "classVisibleInitializedOpt", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "useMembarrier", "youngGCOpt", "adjustment", "", "enableGpuResourceCleanup", "softReferenceLruOpt", VideoThumbInfo.KEY_INTERVAL, URLDispatch.KEY_EPOCH, "enableJITCodeCacheOpt", "startBlockGc", "scene", "stopBlockGc", "tryCpuBoost", "tryGpuBoost", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IJato {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f351658a = null;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0011H\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010!\u001a\u00020\nH\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\b\u0010#\u001a\u00020\nH\u0016J\u0014\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0%H\u0016J\b\u0010'\u001a\u00020\nH\u0016J\b\u0010(\u001a\u00020\nH\u0016J\b\u0010)\u001a\u00020\nH\u0016J\b\u0010*\u001a\u00020\nH\u0016J\b\u0010+\u001a\u00020\nH\u0016J\b\u0010,\u001a\u00020\nH\u0016J\u0010\u0010-\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\fH\u0016J\u0018\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\fH\u0016J\u0010\u00103\u001a\u00020\n2\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020\nH\u0016J\u0018\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u001bH\u0016J\b\u0010:\u001a\u00020\nH\u0016J\u0010\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020&H\u0016J\u0010\u0010=\u001a\u00020\n2\u0006\u0010<\u001a\u00020&H\u0016J\u0010\u0010>\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010?\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006@"}, d2 = {"Lcom/larus/jato/api/IJato$Companion;", "Lcom/larus/jato/api/IJato;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/jato/api/IJato;", "impl$delegate", "Lkotlin/Lazy;", "initJato", "", "enableLogCut", "", "appContext", "Landroid/content/Context;", "requestBlockGc", "duration", "", "disableClassVerify", "logCutStart", "bypassPoisonDeadObjects", "initInterpreterBridge", "hiddenApiOptDoOptimize", "optScheduler", "boostGLESInit", "boostRenderThread", "priority", "", "application", "Landroid/app/Application;", "cpuAndGpuBoost", "boostDuration", "createBoostFramework", "optLargeObj", "optimizeGCForWeakReferences", "throwableUnwindOptDoOptimize", "getLeakRecords", "", "", "initMemoryLeakCheck", "resetRenderThread", "releaseBoost", "bindBigCore", "bindSmallCore", "resetCoreBind", "setThreadPriority", "removeGCWaitingBlock", "onlyOptimizeMainThread", "classVisibleInitializedOpt", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "useMembarrier", "youngGCOpt", "adjustment", "", "enableGpuResourceCleanup", "softReferenceLruOpt", VideoThumbInfo.KEY_INTERVAL, URLDispatch.KEY_EPOCH, "enableJITCodeCacheOpt", "startBlockGc", "scene", "stopBlockGc", "tryCpuBoost", "tryGpuBoost", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IJato {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f351659b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IJato> f351660c = null;

        private Companion() {
        }

        static {
            f351659b = new Companion();
            f351660c = LazyKt.lazy(new a());
        }

        public static IJato w() {
            return f351660c.getValue();
        }

        @Override // com.larus.jato.api.IJato
        public final void r() {
            Intrinsics.checkNotNullParameter("WholeProcessOptimization1", "scene");
            IJato r100 = w();
            if (r100 == null) goto L6;
            r100.r();
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void bindBigCore() {
            IJato r100 = w();
            if (r100 == null) goto L6;
            r100.bindBigCore();
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void c() {
            IJato r100 = w();
            if (r100 == null) goto L6;
            r100.c();
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void d() {
            IJato r100 = w();
            if (r100 == null) goto L6;
            r100.d();
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void enableGpuResourceCleanup() {
            IJato r100 = w();
            if (r100 == null) goto L6;
            r100.enableGpuResourceCleanup();
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void enableJITCodeCacheOpt() {
            IJato r100 = w();
            if (r100 == null) goto L6;
            r100.enableJITCodeCacheOpt();
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void g() {
            IJato r100 = w();
            if (r100 == null) goto L6;
            r100.g();
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void i() {
            IJato r100 = w();
            if (r100 == null) goto L6;
            r100.i();
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void j() {
            IJato r100 = w();
            if (r100 == null) goto L6;
            r100.j();
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void l() {
            IJato r100 = w();
            if (r100 == null) goto L6;
            r100.l();
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void m() {
            IJato r100 = w();
            if (r100 == null) goto L6;
            r100.m();
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void o() {
            IJato r100 = w();
            if (r100 == null) goto L6;
            r100.o();
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void q() {
            IJato r100 = w();
            if (r100 == null) goto L6;
            r100.q();
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void resetCoreBind() {
            IJato r100 = w();
            if (r100 == null) goto L6;
            r100.resetCoreBind();
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void s() {
            IJato r100 = w();
            if (r100 == null) goto L6;
            r100.s();
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void b(long r100) {
            IJato r101 = w();
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void e(double r100) {
            IJato r101 = w();
            if (r101 == null) goto L6;
            r101.e(r100);
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void h(long r100) {
            IJato r101 = w();
            if (r101 == null) goto L6;
            r101.h(r100);
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void n(long r100) {
            IJato r101 = w();
            if (r101 == null) goto L6;
            r101.n(r100);
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void p(long r100) {
            IJato r101 = w();
            if (r101 == null) goto L6;
            r101.p(r100);
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void stopBlockGc(String r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            IJato r101 = w();
            if (r101 == null) goto L6;
            r101.stopBlockGc(r100);
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void t(int r100) {
            IJato r101 = w();
            if (r101 == null) goto L6;
            r101.t(r100);
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void u(Application r100) {
            Intrinsics.checkNotNullParameter(r100, "application");
            IJato r101 = w();
            if (r101 == null) goto L6;
            r101.u(r100);
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void v(NovaApplication r100) {
            Intrinsics.checkNotNullParameter(r100, "appContext");
            IJato r101 = w();
            if (r101 == null) goto L6;
            r101.v(r100);
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void a(int r100, boolean r101) {
            IJato r102 = w();
            if (r102 == null) goto L6;
            r102.a(r100, r101);
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void f(long r100, int r101) {
            IJato r102 = w();
            if (r102 == null) goto L6;
            r102.f(r100, r101);
            return;
        }

        @Override // com.larus.jato.api.IJato
        public final void k(boolean r100, Context r101) {
            Intrinsics.checkNotNullParameter(r101, "appContext");
            IJato r102 = w();
            if (r102 == null) goto L6;
            r102.k(r100, r101);
            return;
        }
    }

    static {
        f351658a = Companion.f351659b;
    }

    void a(int r100, boolean r101);

    void b(long r100);

    void bindBigCore();

    void c();

    void d();

    void e(double r100);

    void enableGpuResourceCleanup();

    void enableJITCodeCacheOpt();

    void f(long r100, int r101);

    void g();

    void h(long r100);

    void i();

    void j();

    void k(boolean r100, Context r101);

    void l();

    void m();

    void n(long r100);

    void o();

    void p(long r100);

    void q();

    void r();

    void resetCoreBind();

    void s();

    void stopBlockGc(String r100);

    void t(int r100);

    void u(Application r100);

    void v(NovaApplication r100);
}
