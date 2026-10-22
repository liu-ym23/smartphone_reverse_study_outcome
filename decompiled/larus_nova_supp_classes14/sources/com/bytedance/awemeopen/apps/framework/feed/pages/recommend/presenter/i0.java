package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import android.os.SystemClock;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i0 extends com.bytedance.awemeopen.infra.util.j {
    public final /* synthetic */ k0 c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            r0[Lifecycle.Event.ON_RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public i0(k0 r1) {
        this.c = r1;
    }

    public final void a(LifecycleOwner r3, Lifecycle.Event r4) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "event");
        int r5 = a.a[r4.ordinal()];
        if (r5 == 1) goto L19;
        if (r5 == 2) goto L12;
        if (r5 != 3) goto L27;
        this.c.getClass();
        throw null;
    L27:
        return;
    L12:
        if (Intrinsics.areEqual(this.c.e.c.getFeedHomeContainerDeliverHiddenState().getValue(), Boolean.TRUE) == true) goto L25;
        k0 r6 = this.c;
        if (r6.d == false) goto L16;
        r6.n();
        this.c.j.c();
    L16:
        this.c.getClass();
        throw null;
    L25:
        return;
    L19:
        if (Intrinsics.areEqual(this.c.e.c.getFeedHomeContainerDeliverHiddenState().getValue(), Boolean.TRUE) == true) goto L26;
        k0 r7 = this.c;
        if (r7.d == false) goto L23;
        r7.m();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.i r8 = this.c.f;
        r8.getClass();
        r8.a = SystemClock.elapsedRealtime();
        this.c.j.a();
    L23:
        this.c.getClass();
        throw null;
    }
}
