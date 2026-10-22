package v61;

import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.messagewindow.business.card.BottomRightCommonCard;
import com.bytedance.android.live.room.api.messagewindow.anim.CardAnimState;
import com.bytedance.android.live.room.api.messagewindow.anim.CardAnimType;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle$State;
import com.bytedance.android.live.room.api.messagewindow.service.IPlatformCardService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.message.model.i3;
import com.bytedance.android.livesdkapi.interact.IAbsCardWindow;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import s71.g;
import vh7.h;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a implements c, b, IAbsCardWindow, r61.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MsgWindowPosition f553370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CardConstraint f553371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f553372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f553373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f553374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f553375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f553376g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b71.a f553377h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DataCenter f553378i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f553379j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f553380k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final s61.a f553381l;

    public final ICardLifecycle$State A() {
        return this.f553381l.d();
    }

    public boolean E() {
        return this instanceof BottomRightCommonCard;
    }

    public final void H(p71.a r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f553381l.p(r100);
    }

    public void I() {
    }

    public void J() {
        this.f553372c = false;
        this.f553374e = false;
    }

    public void K() {
    }

    public void L() {
    }

    public void M() {
    }

    public void N(View r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
    }

    public void Q(HybridCard r100) {
    }

    public void R(i3 r100) {
    }

    @Override // t61.b
    public final void a(CardAnimType r100) {
        Intrinsics.checkNotNullParameter(r100, "animType");
        this.f553381l.a(r100);
    }

    @Override // r61.b
    public final t61.a b() {
        return this.f553381l.b();
    }

    @Override // r61.b
    public final void c(t61.a r100) {
        Intrinsics.checkNotNullParameter(r100, "anim");
        this.f553381l.c(r100);
    }

    @Override // r61.b
    public final void dismiss() {
        this.f553381l.dismiss();
    }

    public void e(h r100, String r101) {
    }

    @Override // t61.b
    public final Observable<CardAnimState> f() {
        return this.f553381l.f();
    }

    @Override // r61.a
    public final void g(o r100, DataCenter r101) {
        this.f553381l.g(r100, r101);
    }

    @Override // r61.b
    public final o getRoomContext() {
        return this.f553381l.getRoomContext();
    }

    @Override // t61.b
    public final void h(CardAnimType r100) {
        Intrinsics.checkNotNullParameter(r100, "animType");
        this.f553381l.h(r100);
    }

    @Override // r61.b
    public final void hide() {
        this.f553381l.hide();
    }

    @Override // r61.b
    public final void i(t71.a r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        this.f553381l.i(r100);
    }

    @Override // r61.b
    public final g<c> j() {
        return this.f553381l.j();
    }

    @Override // b71.b
    public final Observable<b71.a> l() {
        return this.f553381l.l();
    }

    @Override // r61.b
    public final boolean o() {
        return this.f553381l.o();
    }

    @Override // r61.a
    public final void s(CardConstraint r100) {
        Intrinsics.checkNotNullParameter(r100, "newConstraint");
        this.f553381l.s(r100);
    }

    @Override // r61.b
    public final void show() {
        this.f553381l.show();
    }

    @Override // r61.b
    public final void t(g<? extends c> r100) {
        Intrinsics.checkNotNullParameter(r100, "fight");
        this.f553381l.t(r100);
    }

    @Override // r61.b
    public final Collection<t71.a> u() {
        return this.f553381l.u();
    }

    @Override // c71.b
    public final Observable<ICardLifecycle$State> v() {
        return this.f553381l.v();
    }

    @Override // o71.a
    public final Observable<p71.a> w() {
        return this.f553381l.w();
    }

    @Override // r61.b
    public final Disposable x(long r100) {
        return this.f553381l.x(r100);
    }

    @Override // v61.c
    public final boolean isShowing() {
        if (A().compareTo(ICardLifecycle$State.Showed) >= 0) goto L5;
    L7:
        return false;
    L5:
        if (A().compareTo(ICardLifecycle$State.Hidden) >= 0) goto L7;
        return true;
    }

    public boolean isShowingWindow() {
        return isShowing();
    }

    @Override // c71.b
    public final /* bridge */ /* synthetic */ ICardLifecycle$State m() {
        return A();
    }

    public CardConstraint z() {
        return y();
    }

    public d B() {
        return this.f553376g;
    }

    public boolean C() {
        return this.f553375f;
    }

    public void dismissWindow() {
        dismiss();
    }

    public DataCenter getDataCenter() {
        return this.f553378i;
    }

    @Override // v61.c
    public final Object getIdentity() {
        return this.f553379j;
    }

    @Override // v61.c
    public MsgWindowPosition getPosition() {
        return this.f553370a;
    }

    @Override // v61.c
    public final b71.a p() {
        return this.f553377h;
    }

    public void showWindow() {
        show();
    }

    public CardConstraint y() {
        return this.f553371b;
    }

    public void O(CardConstraint r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f553371b = r100;
    }

    public final void P(CardConstraint r100) {
        Intrinsics.checkNotNullParameter(r100, "constraint");
        O(r100);
        if (this.f553372c == false) goto L6;
        s(r100);
        return;
    }

    @Override // o71.a
    public final /* bridge */ /* synthetic */ void k(Object r100) {
        H((p71.a) r100);
    }

    @Override // c71.b
    public final void n(Object r100) {
        ICardLifecycle$State r101 = (ICardLifecycle$State) r100;
        Intrinsics.checkNotNullParameter(r101, "state");
        this.f553381l.e(r101);
    }

    public a(DataCenter r100, Object r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, DownloadHelper.IDENTITY);
        s61.a r103 = new s61.a();
        this.f553378i = r100;
        this.f553379j = r101;
        this.f553380k = r102;
        this.f553381l = r103;
        this.f553370a = MsgWindowPosition.BOTTOM_RIGHT;
        this.f553371b = new CardConstraint(-2, -2);
        this.f553376g = new d(0);
        this.f553377h = new b71.a.b();
        Intrinsics.checkNotNullParameter(this, "cardWindow");
        IPlatformCardService.Companion.getClass();
        IPlatformCardService r104 = IPlatformCardService.a.a();
        if (r104 == null) goto L5;
        r61.a r105 = r104.newCardAbilityImpl(this);
    L6:
        r103.f540778a = r105;
        return;
    L5:
        r105 = null;
        goto L6
    }
}
