package com.larus.avlink.performance;

import com.larus.avlink.model.FlowDoraSceneState;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f293527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f293528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<b, Unit> f293529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f293530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f293531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<Integer> f293532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f293533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Job f293534h;

    /* JADX INFO: renamed from: com.larus.avlink.performance.a$a, reason: collision with other inner class name */
    public static final class C4003a {
    }

    static {
    }

    public final synchronized void a() {
        monitor-enter(this);
        Boolean r100 = this.f293530d;     // Catch: Throwable -> L23
        Boolean r101 = Boolean.FALSE;     // Catch: Throwable -> L23
        if (Intrinsics.areEqual(r100, r101) == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.f293531e == false) goto L10;
    L16:
        Job r102 = this.f293534h;     // Catch: Throwable -> L23
        if (r102 == null) goto L19;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);     // Catch: Throwable -> L23
    L19:
        this.f293534h = BuildersKt.launch$default(this.f293527a, null, null, new DoraIdleSceneCompat$scheduleDisconnectReset$1(this, null), 3, null);     // Catch: Throwable -> L23
    L20:
        this.f293530d = r101;     // Catch: Throwable -> L23
        c();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L10:
        if ((!this.f293532f.isEmpty()) == true) goto L16;
        Job r103 = this.f293534h;     // Catch: Throwable -> L23
        if (r103 == null) goto L15;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);     // Catch: Throwable -> L23
    L15:
        this.f293534h = null;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public final void c() {
        if (this.f293531e == false) goto L5;
    L11:
        String r100 = null;
    L13:
        if (Intrinsics.areEqual(r100, this.f293533g) == false) goto L15;
        return;
    L15:
        String r101 = this.f293533g;
        if (r101 == null) goto L18;
        this.f293529c.invoke(new b(r101, 2, null));
    L18:
        this.f293533g = r100;
        if (r100 == null) goto L22;
        this.f293529c.invoke(new b(r100, 1, null));
        return;
    L22:
        return;
    L5:
        if ((!this.f293532f.isEmpty()) == true) goto L11;
        if (Intrinsics.areEqual(this.f293530d, Boolean.TRUE) == false) goto L10;
        r100 = "998";
        goto L13
    L10:
        r100 = "999";
        goto L13
    }

    public final synchronized void b(int r100, @FlowDoraSceneState int r101) {
        monitor-enter(this);
        if (r101 != 1) goto L6;
        this.f293532f.add(Integer.valueOf(r100));     // Catch: Throwable -> L14
    L11:
        c();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L6:
        if (r101 == 2) goto L9;
        monitor-exit(this);
        return;
    L9:
        this.f293532f.remove(Integer.valueOf(r100));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public a(CoroutineScope r100, e r101, f r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "onDisconnectReset");
        Intrinsics.checkNotNullParameter(r102, "onIdleSceneStateChange");
        this.f293527a = r100;
        this.f293528b = r101;
        this.f293529c = r102;
        this.f293532f = new LinkedHashSet();
    }
}
