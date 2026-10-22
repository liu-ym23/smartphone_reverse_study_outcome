package u19;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.common_ui.toast.ToastLayout;
import com.larus.utils.logger.FLogger;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public class e extends a<Balloon> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f548334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f548335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f548336c;

    public boolean b() {
        return false;
    }

    public e() {
        this.f548334a = true;
        this.f548335b = 3500;
        this.f548336c = new AtomicBoolean(false);
    }

    @Override // u19.a, u19.f
    public final void dismiss() {
        super.dismiss();
        FLogger.f375446a.d("ToastLogger", "balloon holder dismiss, instance: " + getInstance() + '.');
        clear();
        Balloon r100 = getInstance();
        if (r100 == null) goto L5;
        r100.h();
    L5:
        setInstance(null);
        this.f548336c.set(true);
    }

    @Override // u19.a
    public final int getDisplayDuration() {
        return this.f548335b;
    }

    @Override // u19.a
    public final boolean getSupportLottie() {
        return this.f548334a;
    }

    public static View a(Window r100) {
        if (r100 == null) goto L16;
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L8;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L8;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L8:
        if (r101 == null) goto L20;
        ViewParent r103 = r101.getParent();
    L11:
        if (r103 == null) goto L15;
        if ((r103 instanceof View) == false) goto L15;
        r101 = r103;
        r103 = r101.getParent();
    L15:
        return r101;
    L20:
        return null;
    L16:
        return null;
    }

    @Override // u19.a
    public final void setDisplayDuration(int r100) {
        this.f548335b = r100;
    }

    @Override // u19.f
    public final void setDuration(int r100) {
        if (r100 != 0) goto L4;
        r100 = 3500;
    L4:
        this.f548335b = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u19.a
    public final void show(Activity r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (this.f548336c.get() == false) goto L6;
        dismiss();
        return;
    L6:
        LifecycleOwner r102 = null;
        if (b() == false) goto L42;
        View r103 = null;
    L21:
        if (r103 != null) goto L23;
        r103 = a(r100.getWindow());
    L31:
        if (r103 != null) goto L35;
        dismiss();
        FLogger.f375446a.d("ToastLogger", "balloon holder show interrupt, because find anchor from activity" + r100 + " view failed!");
        return;
    L35:
        if (b() == false) goto L37;
        FLogger.f375446a.i("ToastLogger", "action toast use activity decor anchor activity=" + r100.getClass().getSimpleName() + " identity=" + System.identityHashCode(r100));
    L37:
        super.show(r100, r101);
        FLogger.f375446a.d("ToastLogger", "show balloon holder from activity");
        if ((r100 instanceof LifecycleOwner) == false) goto L40;
        r102 = (LifecycleOwner) r100;
    L40:
        c(r100, r102, r103, r101);
        return;
    L23:
        Rect r104 = new Rect();
        if (r103.getLocalVisibleRect(r104) == true) goto L26;
    L29:
        r103 = a(r100.getWindow());
        goto L31
    L26:
        if (r104.width() == 0) goto L29;
        if (r104.height() != 0) goto L31;
    L42:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L15
        if ((r100 instanceof FragmentActivity) == false) goto L12;
        View r106 = ((Fragment) CollectionsKt.last(((FragmentActivity) r100).getSupportFragmentManager().getFragments())).getView();     // Catch: Throwable -> L15
    L13:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r107) == false) goto L20;
        r107 = null;
    L20:
        r103 = (View) r107;
        goto L21
    L12:
        r106 = null;
    L15:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    @Override // u19.a, u19.f
    public final void show(Fragment r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        if (this.f548336c.get() == false) goto L6;
        dismiss();
        return;
    L6:
        Context r102 = r100.getContext();
        if (r102 != null) goto L9;
        return;
    L9:
        FragmentActivity r103 = r100.getActivity();
        if (r103 == null) goto L12;
        Window r104 = r103.getWindow();
    L13:
        View r105 = a(r104);
        if (r105 != null) goto L17;
        dismiss();
        FLogger.f375446a.d("ToastLogger", "balloon holder show interrupt, because find anchor from fragment" + r100 + " view failed!");
        return;
    L17:
        LifecycleOwner r106 = r100.getViewLifecycleOwnerLiveData().getValue();
        if (r106 != null) goto L20;
        return;
    L20:
        super.show(r100, r101);
        FLogger.f375446a.d("ToastLogger", "show balloon holder from fragment");
        c(r102, r106, r105, r101);
        return;
    L12:
        r104 = null;
        goto L13
    }

    @Override // u19.a, u19.f
    public final void show(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f548336c.get() == false) goto L7;
        dismiss();
        return;
    L7:
        if ((r100 instanceof Activity) == false) goto L9;
        show((Activity) r100, r101);
        return;
    L9:
        FLogger.f375446a.d("ToastLogger", "balloon holder show interrupt, because passing context is not a valid Activity instance: " + r100 + '.');
    }

    public final void c(Context r100, LifecycleOwner r101, View r102, boolean r103) {
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("balloon holder show, disable: ");
        r105.append(this.f548336c.get());
        r105.append(",duration: ");
        r105.append(this.f548335b);
        r105.append(", lifecycle state: ");
        Lifecycle.State r106 = null;
        if (r101 == null) goto L7;
        Lifecycle r107 = r101.getLifecycle();
        if (r107 == null) goto L7;
        Lifecycle.State r108 = r107.getCurrentState();
    L8:
        r105.append(r108);
        r104.d("ToastLogger", r105.toString());
        if (this.f548336c.get() == false) goto L11;
    L26:
        r104.d("ToastLogger", "balloon holder show interrupt.");
        dismiss();
        return;
    L11:
        if (this.f548335b == 0) goto L26;
        if (r101 == null) goto L17;
        Lifecycle r109 = r101.getLifecycle();
        if (r109 == null) goto L17;
        r106 = r109.getCurrentState();
    L17:
        if (r106 == Lifecycle.State.DESTROYED) goto L26;
        if (this.f548336c.get() == false) goto L22;
    L24:
        r104.d("ToastLogger", "balloon holder show interrupt, because anchor view is detached or holder is prohibited from being displayed.");
        dismiss();
        return;
    L22:
        if (r102.isAttachedToWindow() == false) goto L24;
        Balloon.w(ensureInstance(r100, r101, this.f548335b, r103), r102, 0, 6);
        r104.d("ToastLogger", "balloon holder show.");
        return;
    L7:
        r108 = null;
        goto L8
    }

    @Override // u19.a
    public final Balloon newInstance(Context r100, LifecycleOwner r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Balloon.a r104 = new Balloon.a(r100);
        r104.n(Integer.MIN_VALUE);
        r104.j(Integer.MIN_VALUE);
        r104.f406065z = 16.0f;
        r104.e(ArrowPositionRules.ALIGN_BALLOON);
        boolean r105 = false;
        r104.f(0);
        r104.f406055p = 0.5f;
        r104.f406061v = 0;
        r104.g(BalloonAnimation.FADE);
        r104.f406044g0 = false;
        r104.W = r101;
        if (getShouldAutoDisappear() == false) goto L7;
        if (r102 <= 0) goto L7;
        r104.V = r102;
    L7:
        if (getShouldAutoDisappear() == true) goto L9;
    L11:
        r104.h(r105);
        r104.T = true;
        r104.l(new d(this));
        ToastLayout r106 = buildLayout(r100, r103);
        Intrinsics.checkNotNullParameter(r106, "layout");
        r104.I = r106;
        return r104.b();
    L9:
        if (this.f548335b <= 0) goto L11;
        r105 = true;
        goto L11
    }
}
