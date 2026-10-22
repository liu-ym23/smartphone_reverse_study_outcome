package qh2;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.android.ec.adapter.api.handler.viewinterface.IECWidgetType;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.eventcenter.LiveEventCenter;
import com.bytedance.android.livesdk.livecommerce.intro.manager.IntroCardAnimController;
import com.bytedance.android.livesdk.livecommerce.intro.manager.i;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroCardLoadOpt;
import com.bytedance.android.livesdk.livecommerce.room.api.e;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.model.g;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IWidgetType;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends ak2.b implements IECWidgetType, IWidgetType, qh2.b, qh2.c {
    public final i a;
    public boolean b;
    public boolean c;
    public RunnableC0163d d;
    public final ECContext e;
    public final e f;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.livesdk.livecommerce.intro.event.a {
        @Override // com.bytedance.android.livesdk.livecommerce.intro.event.a
        public final void a() {
        }

        @Override // com.bytedance.android.livesdk.livecommerce.intro.event.a
        public final void b() {
        }

        @Override // com.bytedance.android.livesdk.livecommerce.intro.event.a
        public final void c() {
        }

        @Override // com.bytedance.android.livesdk.livecommerce.intro.event.a
        public final void d() {
        }

        public b() {
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ d a;

        public c(d r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (IntroCardLoadOpt.j == true) goto L6;
            this.a.t(r3.booleanValue());
            return;
        }
    }

    /* JADX INFO: renamed from: qh2.d$d, reason: collision with other inner class name */
    public static final class RunnableC0163d implements Runnable {
        public final /* synthetic */ d a;
        public final /* synthetic */ boolean b;

        public RunnableC0163d(d r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.t(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // ak2.b
    public final void onHide() {
    }

    @Override // ak2.b
    public final void onLoad() {
        this.b = true;
    }

    @Override // ak2.b
    public final void onShow() {
    }

    @Override // ak2.b
    public final void onUnload() {
        this.b = false;
    }

    @Override // ak2.b
    public final void onViewAttached(wd.c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
    }

    @Override // qh2.c
    public final int B() {
        this.f.B();
        return -1;
    }

    public final View getView() {
        return this.a.a;
    }

    public final void load() {
        ECLiveEntranceMonitor.trace$default("load", "IntroCardWidget", false, 4, null);
        this.e.isIntroCardVisible().a().subscribe(new c(this));
        dm.a.a("LiveCardLoad").i("try show intro card on room enter");
        com.bytedance.android.livesdk.livecommerce.intro.manager.c.a.a(this.a, IntroCardScene.ENTER_ROOM, 126);
    }

    public final void u() {
        this.f.M(this);
        i r0 = this.a;
        r0.f = null;
        if (r0.e == false) goto L6;
        r0.getClass();
        r0.l.A().q.g = null;
        Lazy r2 = LiveEventCenter.b;
        LiveEventCenter.a.a().a(r0.h);
        r0.e = false;
    L6:
        ECLiveHybridUtil.p("closeExplainCard", r0.g);
        SparseArray<com.bytedance.android.livesdk.livecommerce.intro.controller.b> r3 = r0.d;
        int r4 = r3.size();
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L9;
        r3.keyAt(r5);
        r3.valueAt(r5).onDestroy();
        r5 = r5 + 1;
        goto L7
    L9:
        IntroCardAnimController r6 = r0.c;
        r6.h.set(true);
        Iterator<T> r7 = r6.g.iterator();
    L11:
        if (r7.hasNext() == false) goto L13;
        Message r8 = (Message) r7.next();
        ((Handler) r6.e.getValue()).removeCallbacksAndMessages(r8);
        goto L11
    L13:
        Iterator<T> r9 = r6.f.iterator();
    L15:
        if (r9.hasNext() == false) goto L17;
        Message r10 = (Message) r9.next();
        r6.d.removeCallbacksAndMessages(r10);
        goto L15
    L17:
        r0.m.b();
        r0.b.b(220, 0, 0);
        this.d = null;
    }

    public final IWidgetType.ExternalWidgetType getWidgetType() {
        return IWidgetType.ExternalWidgetType.ECOMMERCE_POP_CARD;
    }

    public final IECWidgetType.ECExternalWidgetType j() {
        return IECWidgetType.ECExternalWidgetType.ECOMMERCE_POP_CARD;
    }

    @Override // ak2.b
    public final void onViewWillAttach(wd.c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        gk2.a.a(getView());
    }

    @Override // qh2.b
    public final void t(boolean r6) {
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_WIDGET_LOAD_FIX() == true) goto L5;
    L8:
        ECLiveEntranceMonitor.trace$default("isIntroCardVisible=" + r6 + ", hasLoaded=" + this.b, "IntroCardWidget", false, 4, null);
        dm.a.b r0 = dm.a.a("IntroCardWidget");
        StringBuilder r1 = new StringBuilder("setIntroCardVisibility = ");
        r1.append(r6);
        r0.a(r1.toString());
        if (r6 == true) goto L11;
        dm.a.a("IntroCardWidget").a("iLiveRoomViewHandler.requestDismiss");     // Catch: Exception -> L16
        this.f.K(this);     // Catch: Exception -> L16
        return;
    L11:
        if (this.b == true) goto L13;
        dm.a.a("IntroCardWidget").a("iLiveRoomViewHandler.provideWidget");     // Catch: Exception -> L16
        this.f.L(this, xd.a.a);     // Catch: Exception -> L16
    L13:
        dm.a.a("IntroCardWidget").a("iLiveRoomViewHandler.requestShow");     // Catch: Exception -> L16
        this.f.O(this);     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        ECExceptionMonitor.e(e);
        dm.a.a("IntroCardWidget").b("setIntroCardVisibility error", e);
        return;
    L5:
        if (this.c == true) goto L8;
        this.d = new RunnableC0163d(this, r6);
    }

    public final void v(boolean r1) {
        this.c = r1;
        if (r1 == false) goto L9;
        RunnableC0163d r2 = this.d;
        if (r2 == null) goto L7;
        r2.run();
    L7:
        this.d = null;
        return;
    }

    @Override // qh2.c
    public final void g(int r1, int r2) {
        this.f.M(this);
    }

    public d(Context r10, ECContext r11, e r12, RoomContextController r13, LiveRoomParams r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "ecContext");
        Intrinsics.checkNotNullParameter(r12, "iLiveRoomViewHandler");
        Intrinsics.checkNotNullParameter(r13, "roomContextController");
        this.e = r11;
        this.f = r12;
        this.a = new i(r10, new g(r11, r13), r14, r13, new b(), this, this);
    }
}
