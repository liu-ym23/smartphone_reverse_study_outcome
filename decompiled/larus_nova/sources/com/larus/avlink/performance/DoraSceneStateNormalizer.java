package com.larus.avlink.performance;

import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes25.dex */
public final class DoraSceneStateNormalizer {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f293520g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f293521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<b, Unit> f293522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f293523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Job f293524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f293525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashMap<String, b> f293526f;

    public static final class a {
    }

    static {
    }

    public final synchronized void a() {
        monitor-enter(this);
        Job r100 = this.f293524d;     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);     // Catch: Throwable -> L9
    L6:
        this.f293524d = null;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void e() {
        monitor-enter(this);
        FLogger.f375446a.e("DoraSceneStateNormalizer", "reset overlapped dora scene record, reason:overlap timeout, currentScene:" + this.f293525e + ", activeScenes:" + this.f293526f);     // Catch: Throwable -> L10
        Job r100 = this.f293524d;     // Catch: Throwable -> L10
        if (r100 == null) goto L7;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);     // Catch: Throwable -> L10
    L7:
        this.f293524d = null;     // Catch: Throwable -> L10
        this.f293525e = null;     // Catch: Throwable -> L10
        this.f293526f.clear();     // Catch: Throwable -> L10
        this.f293523c.invoke();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void f() {
        boolean r100 = true;
        if (this.f293525e != null) goto L5;
    L17:
        Job r101 = this.f293524d;
        if (r101 == null) goto L20;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L20:
        this.f293524d = null;
        return;
    L5:
        if (this.f293526f.size() <= 1) goto L17;
        Job r102 = this.f293524d;
        if (r102 != null) goto L10;
    L12:
        r100 = false;
    L13:
        if (r100 == false) goto L15;
        return;
    L15:
        this.f293524d = BuildersKt.launch$default(this.f293521a, null, null, new DoraSceneStateNormalizer$scheduleOverlapTimeout$1(this, null), 3, null);
        return;
    L10:
        if (r102.isActive() != true) goto L12;
        goto L12
    }

    public final void b(b r100) {
        this.f293526f.put(r100.f293535a, r100);
        b r101 = this.f293525e;
        if (r101 != null) goto L7;
        this.f293525e = r100;
        this.f293522b.invoke(r100);
        return;
    L7:
        if (Intrinsics.areEqual(r100.f293535a, r101.f293535a) == false) goto L10;
        FLogger.f375446a.d("DoraSceneStateNormalizer", "skip duplicate enter scene, scene:" + r100.f293535a);
        return;
    L10:
        f();
    }

    public final void c(b r100) {
        if (this.f293526f.remove(r100.f293535a) != null) goto L6;
        FLogger.f375446a.e("DoraSceneStateNormalizer", "skip bad exit scene case, scene:" + r100.f293535a);
        return;
    L6:
        String r101 = r100.f293535a;
        b r102 = this.f293525e;
        if (r102 == null) goto L9;
        String r103 = r102.f293535a;
    L11:
        if (Intrinsics.areEqual(r101, r103) == true) goto L14;
        f();
        return;
    L14:
        this.f293522b.invoke(r100);
        this.f293525e = null;
        Job r104 = this.f293524d;
        if (r104 == null) goto L17;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
    L17:
        this.f293524d = null;
        b r105 = (b) CollectionsKt.firstOrNull(this.f293526f.values());
        if (r105 == null) goto L22;
        this.f293525e = r105;
        this.f293522b.invoke(r105);
        f();
        return;
    L22:
        return;
    L9:
        r103 = null;
        goto L11
    }

    public final synchronized void d(b r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "event");     // Catch: Throwable -> L18
        int r101 = r100.f293536b;     // Catch: Throwable -> L18
        if (r101 != 1) goto L7;
    L11:
        if (r101 != 1) goto L15;
        b(r100);     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L15:
        c(r100);     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L7:
        if (r101 == 2) goto L11;
        FLogger.f375446a.d("DoraSceneStateNormalizer", "skip unknown scene state record, event:" + r100);     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public DoraSceneStateNormalizer(CoroutineScope r100, c r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "onNormalizedStateChange");
        Intrinsics.checkNotNullParameter(r102, "onBadCaseReset");
        this.f293521a = r100;
        this.f293522b = r101;
        this.f293523c = r102;
        this.f293526f = new LinkedHashMap();
    }
}
