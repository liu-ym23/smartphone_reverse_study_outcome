package com.bytedance.kmp.ec.yata.common.platform.executor;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class g extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f251524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f251525e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.kmp.ec.yata.common.platform.executor.c
    public final void b() {
        h r100 = this.f251524d;
        monitor-enter(r100);
        this.f251513a = true;     // Catch: Throwable -> L11
        int r101 = ((ArrayList) this.f251515c).size() - 1;     // Catch: Throwable -> L11
    L6:
        if ((-1) >= r101) goto L8;
        ListProtector.remove(this.f251515c, r101);     // Catch: Throwable -> L11
        r101 = r101 - 1;     // Catch: Throwable -> L11
        goto L6
    L8:
        this.f251524d.e(this);     // Catch: Throwable -> L11
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r100);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void c() {
        h r100 = this.f251524d;
        monitor-enter(r100);
        int r101 = ((ArrayList) this.f251515c).size() - 1;     // Catch: Throwable -> L10
    L5:
        if ((-1) >= r101) goto L7;
        ListProtector.remove(this.f251515c, r101);     // Catch: Throwable -> L10
        r101 = r101 - 1;     // Catch: Throwable -> L10
        goto L5
    L7:
        this.f251524d.e(this);     // Catch: Throwable -> L10
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r100);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public g(h r100) {
        Intrinsics.checkNotNullParameter(r100, "taskRunner");
        Intrinsics.checkNotNullParameter("parallel-queue", "name");
        this.f251524d = r100;
        this.f251525e = false;
    }

    @Override // com.bytedance.kmp.ec.yata.common.platform.executor.c
    public final void a(f r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        h r102 = this.f251524d;
        monitor-enter(r102);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.f251513a == false) goto L8;
    L10:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r102);
        return;
    L8:
        if (d(r100, r101) == false) goto L10;
        this.f251524d.e(this);     // Catch: Throwable -> L13
        goto L10
    }

    public final boolean d(f r110, long r111) {
        Intrinsics.checkNotNullParameter(this, "queue");
        g r100 = r110.f251522a;
        if (r100 == this) goto L10;
        if (r100 != null) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L35;
        r110.f251522a = this;
        goto L10
    L35:
        throw new IllegalStateException("task is in multiple queues".toString());
    L7:
        r101 = false;
    L10:
        long r102 = this.f251524d.f251527a.nanoTime();
        long r103 = r102 + r111;
        int r104 = ((ArrayList) this.f251515c).indexOf(r110);
        if (r104 != (-1)) goto L13;
    L16:
        r110.f251523b = r103;
        Iterator r105 = ((ArrayList) this.f251515c).iterator();
        int r106 = 0;
    L18:
        if (r105.hasNext() == false) goto L26;
        if ((((f) r105.next()).f251523b - r102) <= r111) goto L22;
        boolean r107 = true;
    L23:
        if (r107 == true) goto L27;
        r106 = r106 + 1;
    L27:
        if (r106 != (-1)) goto L29;
        r106 = ((ArrayList) this.f251515c).size();
    L29:
        ListProtector.add(this.f251515c, r106, r110);
        if (r106 == 0) goto L38;
        return false;
    L38:
        return true;
    L22:
        r107 = false;
        goto L23
    L26:
        r106 = -1;
        goto L27
    L13:
        if (r110.f251523b > r103) goto L15;
        return false;
    L15:
        ListProtector.remove(this.f251515c, r104);
        goto L16
    }
}
