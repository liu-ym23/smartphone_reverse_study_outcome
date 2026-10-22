package com.bytedance.android.shopping.prepurchase.arch.standard.component.pref;

import android.os.Handler;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.l;
import com.bytedance.android.shopping.prepurchase.arch.container.aware.RenderLifecycleDispatcher;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.component.i;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.j;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class StandardPrefService<STATE extends h, STORE> extends i<STATE, STORE> implements l {
    public boolean i;
    public final Lazy j;
    public final Lazy k;
    public final com.bytedance.android.shopping.prepurchase.arch.container.aware.e l;
    public final com.bytedance.android.shopping.prepurchase.arch.standard.component.pref.a m;

    public static final class a extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
        public final /* synthetic */ StandardPrefService c;

        @Override // java.lang.Runnable
        public final void run() {
            this.c.l.onFirstScreen();
        }

        public a(StandardPrefService r1) {
            this.c = r1;
            super("first_screen_callback");
        }
    }

    public final TaskScheduler b2() {
        return (TaskScheduler) this.k.getValue();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(j.class);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.l
    public final void C0() {
        final TaskScheduler r0 = b2();
        r0.getClass();
        com.bytedance.android.shopping.prepurchase.arch.utils.a.a(new TaskScheduler$onFirstFrameRender$1(r0));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public void T1() {
        super.T1();
        Z1(j.class, new StandardPrefService$onAttach$1(this, null));
        e1(new a(this));
        AbsComponent.Y1(this, l.class, this, false, 12);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.l
    public final void U() {
        final TaskScheduler r0 = b2();
        r0.getClass();
        com.bytedance.android.shopping.prepurchase.arch.utils.a.a(new TaskScheduler$onPreviewRender$1(r0));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public void U1() {
        super.U1();
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.c(this, "onDetach");
        ((Handler) this.j.getValue()).removeCallbacksAndMessages(null);
        final TaskScheduler r0 = b2();
        r0.getClass();
        com.bytedance.android.shopping.prepurchase.arch.utils.a.a(new TaskScheduler$stop$1(r0));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.l
    public final boolean e0() {
        if (b2().a < 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Handler a2(StandardPrefService r0) {
        return (Handler) r0.j.getValue();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.l
    public final void e1(com.bytedance.android.shopping.prepurchase.arch.container.ability.b r4) {
        Intrinsics.checkNotNullParameter(r4, "task");
        TaskScheduler r0 = b2();
        int r1 = TaskScheduler.i;
        r0.b(3, r4, null);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.l
    public final void n0(com.bytedance.android.shopping.prepurchase.arch.container.ability.b r4) {
        Intrinsics.checkNotNullParameter(r4, "task");
        TaskScheduler r0 = b2();
        int r1 = TaskScheduler.i;
        r0.b(4, r4, null);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.l
    public final void s1(com.bytedance.android.shopping.prepurchase.arch.container.ability.b r4) {
        Intrinsics.checkNotNullParameter(r4, "task");
        TaskScheduler r0 = b2();
        int r1 = TaskScheduler.i;
        r0.b(2, r4, null);
    }

    public StandardPrefService(RenderLifecycleDispatcher r2, com.bytedance.android.shopping.prepurchase.business.pdp.f r3) {
        Intrinsics.checkNotNullParameter(r2, "renderListener");
        Intrinsics.checkNotNullParameter(r3, "provider");
        this.l = r2;
        this.m = r3;
        this.j = LazyKt.lazy(StandardPrefService$handler$2.INSTANCE);
        this.k = LazyKt.lazy(new StandardPrefService$taskScheduler$2(this));
    }
}
