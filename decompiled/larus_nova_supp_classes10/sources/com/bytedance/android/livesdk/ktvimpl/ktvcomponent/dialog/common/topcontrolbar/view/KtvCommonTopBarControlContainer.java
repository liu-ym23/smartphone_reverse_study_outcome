package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.model.MusicOperateType;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0016R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010&\u001a\u0004\u0018\u00010\u00078\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b#\u0010\t\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\rR$\u0010*\u001a\u0004\u0018\u00010\u001b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!R$\u00101\u001a\u0004\u0018\u00010\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00105\u001a\u0004\u0018\u00010\u00078\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b2\u0010\t\u001a\u0004\b3\u0010\u000b\"\u0004\b4\u0010\rR$\u0010=\u001a\u0004\u0018\u0001068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010A\u001a\u0004\u0018\u00010\u001b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b>\u0010\u001d\u001a\u0004\b?\u0010\u001f\"\u0004\b@\u0010!R\u001b\u0010G\u001a\u00020B8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001b\u0010L\u001a\u00020H8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bI\u0010D\u001a\u0004\bJ\u0010KR\u001b\u0010Q\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010D\u001a\u0004\bO\u0010PR\u001b\u0010V\u001a\u00020R8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bS\u0010D\u001a\u0004\bT\u0010UR'\u0010]\u001a\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020Y0W8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010D\u001a\u0004\b[\u0010\\R\u001a\u0010c\u001a\u00020^8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b¨\u0006d"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonTopBarControlContainer;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "", "getLayoutId", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "Landroidx/constraintlayout/widget/ConstraintLayout;", "a", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMusicInfoArea", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMusicInfoArea", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "musicInfoArea", "b", "getMusicCoverContainer", "setMusicCoverContainer", "musicCoverContainer", "Lcom/bytedance/android/live/core/widget/HSImageView;", "c", "Lcom/bytedance/android/live/core/widget/HSImageView;", "getMusicCoverIv", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "setMusicCoverIv", "(Lcom/bytedance/android/live/core/widget/HSImageView;)V", "musicCoverIv", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "getMusicTimeTv", "()Landroid/widget/TextView;", "setMusicTimeTv", "(Landroid/widget/TextView;)V", "musicTimeTv", "e", "getMusicContentContainer", "setMusicContentContainer", "musicContentContainer", "f", "getMusicNameTv", "setMusicNameTv", "musicNameTv", "g", "Landroid/widget/FrameLayout;", "getUserInfoContainer", "()Landroid/widget/FrameLayout;", "setUserInfoContainer", "(Landroid/widget/FrameLayout;)V", "userInfoContainer", "h", "getMusicOperateArea", "setMusicOperateArea", "musicOperateArea", "Landroid/widget/LinearLayout;", "i", "Landroid/widget/LinearLayout;", "getMusicOperateContainer", "()Landroid/widget/LinearLayout;", "setMusicOperateContainer", "(Landroid/widget/LinearLayout;)V", "musicOperateContainer", "j", "getBusinessSwitch", "setBusinessSwitch", "businessSwitch", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonSingleAvatarView;", "k", "Lkotlin/Lazy;", "getKtvCommonSingleAvatarView", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonSingleAvatarView;", "ktvCommonSingleAvatarView", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonStackAvatarView;", "l", "getKtvCommonStackAvatarView", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonStackAvatarView;", "ktvCommonStackAvatarView", "Landroidx/lifecycle/LifecycleRegistry;", "m", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "Lio/reactivex/disposables/CompositeDisposable;", "n", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/model/MusicOperateType;", "Landroid/view/View;", "o", "getMusicOperateViewMap", "()Ljava/util/Map;", "musicOperateViewMap", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/a;", "p", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/a;", "getOuterInjectCallback", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/a;", "outerInjectCallback", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class KtvCommonTopBarControlContainer extends FrameLayout implements LifecycleOwnerCompat {
    public ConstraintLayout a;
    public ConstraintLayout b;
    public HSImageView c;
    public TextView d;
    public ConstraintLayout e;
    public TextView f;
    public FrameLayout g;
    public ConstraintLayout h;
    public LinearLayout i;
    public TextView j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final a p;

    private final LifecycleRegistry getLifecycleRegistry() {
        return (LifecycleRegistry) this.m.getValue();
    }

    public abstract void b();

    public abstract void c();

    public abstract void e(boolean r1);

    public final CompositeDisposable getCompositeDisposable() {
        return (CompositeDisposable) this.n.getValue();
    }

    public final KtvCommonSingleAvatarView getKtvCommonSingleAvatarView() {
        return (KtvCommonSingleAvatarView) this.k.getValue();
    }

    public final KtvCommonStackAvatarView getKtvCommonStackAvatarView() {
        return (KtvCommonStackAvatarView) this.l.getValue();
    }

    public int getLayoutId() {
        return 2131566454;
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public final Map<MusicOperateType, View> getMusicOperateViewMap() {
        return (Map) this.o.getValue();
    }

    public Lifecycle getLifecycleCompat() {
        return getLifecycleRegistry();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getLifecycleRegistry().setCurrentState(Lifecycle.State.STARTED);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getLifecycleRegistry().setCurrentState(Lifecycle.State.DESTROYED);
        Iterator<T> r0 = getMusicOperateViewMap().values().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        KeyEvent.Callback r1 = (View) r0.next();
        if ((r1 instanceof b) == true) goto L8;
        r1 = null;
    L8:
        b r2 = (b) r1;
        if (r2 == null) goto L4;
        r2.onRelease();
        goto L4
    L11:
        getCompositeDisposable().clear();
    }

    public final TextView getBusinessSwitch() {
        return this.j;
    }

    public final ConstraintLayout getMusicContentContainer() {
        return this.e;
    }

    public final ConstraintLayout getMusicCoverContainer() {
        return this.b;
    }

    public final HSImageView getMusicCoverIv() {
        return this.c;
    }

    public final ConstraintLayout getMusicInfoArea() {
        return this.a;
    }

    public final TextView getMusicNameTv() {
        return this.f;
    }

    public final ConstraintLayout getMusicOperateArea() {
        return this.h;
    }

    public final LinearLayout getMusicOperateContainer() {
        return this.i;
    }

    public final TextView getMusicTimeTv() {
        return this.d;
    }

    public final a getOuterInjectCallback() {
        return this.p;
    }

    public final FrameLayout getUserInfoContainer() {
        return this.g;
    }

    public final void f(int r2) {
        if (r2 != 0) goto L4;
        setVisibility(0);
        return;
    L4:
        if (r2 == 8) goto L6;
        setVisibility(4);
        return;
    L6:
        setVisibility(8);
    }

    public final b g(MusicOperateType r4) {
        Intrinsics.checkNotNullParameter(r4, "musicOperateType");
        LinearLayout r0 = this.i;
        Object r1 = null;
        if (r0 == null) goto L10;
        View r5 = r0.getChildAt(r0.indexOfChild(getMusicOperateViewMap().get(r4)));
        if ((r5 instanceof b) == false) goto L9;
        r1 = r5;
    L9:
        return (b) r1;
    L10:
        return null;
    }

    public final void setBusinessSwitch(TextView r1) {
        this.j = r1;
    }

    public final void setMusicContentContainer(ConstraintLayout r1) {
        this.e = r1;
    }

    public final void setMusicCoverContainer(ConstraintLayout r1) {
        this.b = r1;
    }

    public final void setMusicCoverIv(HSImageView r1) {
        this.c = r1;
    }

    public final void setMusicInfoArea(ConstraintLayout r1) {
        this.a = r1;
    }

    public final void setMusicNameTv(TextView r1) {
        this.f = r1;
    }

    public final void setMusicOperateArea(ConstraintLayout r1) {
        this.h = r1;
    }

    public final void setMusicOperateContainer(LinearLayout r1) {
        this.i = r1;
    }

    public final void setMusicTimeTv(TextView r1) {
        this.d = r1;
    }

    public final void setUserInfoContainer(FrameLayout r1) {
        this.g = r1;
    }

    public KtvCommonTopBarControlContainer(a r3, final Context r4) {
        Intrinsics.checkNotNullParameter(r3, "outerInjectCallback");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 0);
        this.p = r3;
        this.k = LazyKt.lazy(new KtvCommonTopBarControlContainer$ktvCommonSingleAvatarView$2(r4));
        this.l = LazyKt.lazy(new KtvCommonTopBarControlContainer$ktvCommonStackAvatarView$2(r4));
        this.m = LazyKt.lazy(new KtvCommonTopBarControlContainer$lifecycleRegistry$2(this));
        this.n = LazyKt.lazy(KtvCommonTopBarControlContainer$compositeDisposable$2.INSTANCE);
        this.o = LazyKt.lazy(KtvCommonTopBarControlContainer$musicOperateViewMap$2.INSTANCE);
        getLifecycleRegistry().setCurrentState(Lifecycle.State.CREATED);
        LayoutInflater.from(r4).inflate(getLayoutId(), this, true);
        this.a = findViewById(2131380493);
        this.b = findViewById(2131380487);
        this.c = findViewById(2131380488);
        this.d = (TextView) findViewById(2131380524);
        this.e = findViewById(2131380484);
        this.f = (TextView) findViewById(2131380505);
        this.g = (FrameLayout) findViewById(2131392032);
        this.h = findViewById(2131380506);
        this.i = (LinearLayout) findViewById(2131380507);
        this.j = (TextView) findViewById(2131364968);
        e(true);
        b();
        c();
    }

    public final void a(View r2, MusicOperateType r3) {
        Intrinsics.checkNotNullParameter(r3, "musicOperateType");
        LinearLayout r0 = this.i;
        if (r0 == null) goto L6;
        r0.removeView(r2);
        r0.addView(r2);
        View r4 = getMusicOperateViewMap().put(r3, r2);
        return;
    }
}
