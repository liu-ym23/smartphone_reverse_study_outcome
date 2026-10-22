package dm0;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.room.api.messagewindow.builder.card.CardMountingsBuilder;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v61.d;
import x61.h;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends v61.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CardMountingsBuilder.ContainerBuilder f469211m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CardMountingsBuilder.b f469212n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CardMountingsBuilder.d f469213o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final d f469214p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final MsgWindowPosition f469215q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CardConstraint f469216r;

    /* JADX INFO: renamed from: dm0.a$a, reason: collision with other inner class name */
    public static final class C5688a {
    }

    static {
    }

    @Override // v61.a
    public final boolean C() {
        return false;
    }

    @Override // v61.a
    public final void I() {
        ALogger.d("MountingsCard", WidgetCostModule.TYPE_ON_CREATE);
        Function0<Unit> r100 = this.f469212n.f98934a;
        if (r100 == null) goto L5;
        Unit r101 = r100.invoke();
    L5:
        ArrayList r102 = (ArrayList) this.f469213o.f98941b;
        if ((!r102.isEmpty()) == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L14;
        Iterator r103 = r102.iterator();
    L12:
        if (r103.hasNext() == false) goto L14;
        i((t71.a) r103.next());
    L14:
        this.f469213o.getClass();
    }

    @Override // v61.a
    public final void K() {
        ALogger.d("MountingsCard", "onHide");
        Function0<Unit> r100 = this.f469212n.f98936c;
        if (r100 == null) goto L6;
        Unit r101 = r100.invoke();
        return;
    }

    @Override // v61.a
    public final void L() {
        ALogger.d("MountingsCard", SendEventContainerMethodParamModel.EventKinds.onShow);
        Function0<Unit> r100 = this.f469212n.f98935b;
        if (r100 == null) goto L6;
        Unit r101 = r100.invoke();
        return;
    }

    @Override // v61.a
    public final void M() {
        ALogger.d("MountingsCard", WidgetCostModule.TYPE_ON_START);
        this.f469212n.getClass();
    }

    @Override // v61.c
    public final h<?, ?> content() {
        ALogger.d("MountingsCard", "getContent");
        return this.f469211m.f98932a.invoke();
    }

    @Override // v61.a
    public final void J() {
        super.J();
        ALogger.d("MountingsCard", LiveCommonConstants.REASON_ON_DEDTROY);
        Function0<Unit> r100 = this.f469212n.f98937d;
        if (r100 == null) goto L6;
        Unit r101 = r100.invoke();
        return;
    }

    @Override // v61.a, com.bytedance.android.livesdkapi.interact.IAbsCardWindow
    public final boolean isShowingWindow() {
        return isShowing();
    }

    @Override // v61.a
    public final d B() {
        return this.f469214p;
    }

    @Override // v61.a, com.bytedance.android.livesdkapi.interact.IAbsCardWindow
    public final void dismissWindow() {
        dismiss();
    }

    @Override // v61.a, v61.c
    public final MsgWindowPosition getPosition() {
        return this.f469215q;
    }

    @Override // v61.a, com.bytedance.android.livesdkapi.interact.IAbsCardWindow
    public final void showWindow() {
        show();
    }

    @Override // v61.a
    public final CardConstraint y() {
        return this.f469216r;
    }

    public a(com.bytedance.android.live.room.api.messagewindow.builder.card.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mountings");
        DataCenter r101 = r100.f98956a;
        Object r102 = r100.f98957b;
        int r103 = r100.f98958c;
        r100.getContext();
        super(r101, r102, r103);
        CardMountingsBuilder.ContainerBuilder r104 = new CardMountingsBuilder.ContainerBuilder();
        r100.f98961f.invoke(r104);
        this.f469211m = r104;
        Intrinsics.checkNotNullParameter(this, BrowserDependency.UrlClickType.CARD);
        CardMountingsBuilder.b r105 = new CardMountingsBuilder.b(this);
        r100.f98962g.invoke(r105);
        this.f469212n = r105;
        CardMountingsBuilder.d r106 = new CardMountingsBuilder.d();
        r100.f98963h.invoke(r106);
        this.f469213o = r106;
        CardMountingsBuilder.a r107 = new CardMountingsBuilder.a();
        r100.f98964i.invoke(r107);
        this.f469214p = new d(0);
        this.f469215q = r100.f98960e;
        this.f469216r = r104.f98933b;
    }

    @Override // v61.a
    public final void N(View r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        ALogger.d("MountingsCard", "onViewCreated");
        this.f469211m.getClass();
    }

    @Override // v61.a
    public final void O(CardConstraint r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f469216r = r100;
    }
}
