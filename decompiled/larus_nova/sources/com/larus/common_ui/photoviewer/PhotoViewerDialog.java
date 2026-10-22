package com.larus.common_ui.photoviewer;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.facebook.drawee.view.GenericDraweeView;
import com.larus.common_ui.photoviewer.transition.TransitionPagerAdapter;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import j19.d;
import j19.e;
import j19.f;
import j19.g;
import j19.i;
import j19.j;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l19.h;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020EH\u0002J\u0010\u0010G\u001a\u00020E2\u0006\u0010H\u001a\u00020!H\u0002J\u0018\u0010I\u001a\u00020E2\u0006\u0010H\u001a\u00020!2\u0006\u0010J\u001a\u00020,H\u0002J\u000e\u0010K\u001a\u00020E2\u0006\u0010L\u001a\u00020/J\u000e\u0010M\u001a\u00020E2\u0006\u0010L\u001a\u00020/J\u0012\u0010N\u001a\u00020E2\b\u0010O\u001a\u0004\u0018\u00010PH\u0014J\b\u0010Q\u001a\u00020EH\u0002J\u001a\u0010R\u001a\u00020E2\u0006\u0010S\u001a\u00020!2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010&J\u0016\u0010R\u001a\u00020E2\u0006\u0010S\u001a\u00020!2\u0006\u0010U\u001a\u00020VJ\u001e\u0010R\u001a\u00020E2\u0006\u0010S\u001a\u00020!2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020,J\u000e\u0010X\u001a\u00020E2\u0006\u0010S\u001a\u00020!J\b\u0010Y\u001a\u00020EH\u0007J\b\u0010Z\u001a\u00020EH\u0016J\u0018\u0010[\u001a\u00020E2\u0006\u0010H\u001a\u00020!2\u0006\u0010J\u001a\u00020,H\u0002J\u000e\u0010\\\u001a\u00020E2\u0006\u0010]\u001a\u00020\rR\u0015\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u0012\u0012\u0004\u0012\u00020/0.j\b\u0012\u0004\u0012\u00020/`0X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R(\u00107\u001a\u0004\u0018\u0001062\b\u0010\f\u001a\u0004\u0018\u000106@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010<\u001a\u00020,2\u0006\u0010\f\u001a\u00020,@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010@\u001a\u00020!2\u0006\u0010\f\u001a\u00020!@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010#\"\u0004\bB\u0010C¨\u0006^"}, d2 = {"Lcom/larus/common_ui/photoviewer/PhotoViewerDialog;", "Landroid/app/Dialog;", "Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;", "Landroidx/lifecycle/LifecycleObserver;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "transitionAdapter", "Lcom/larus/common_ui/photoviewer/transition/TransitionPagerAdapter;", "<init>", "(Landroid/content/Context;Lcom/larus/common_ui/photoviewer/transition/TransitionPagerAdapter;)V", "getTransitionAdapter", "()Lcom/larus/common_ui/photoviewer/transition/TransitionPagerAdapter;", "value", "Landroidx/recyclerview/widget/RecyclerView;", "pager", "getPager", "()Landroidx/recyclerview/widget/RecyclerView;", "rootContainer", "Landroid/widget/FrameLayout;", "getRootContainer", "()Landroid/widget/FrameLayout;", "onPageSelectedListener", "getOnPageSelectedListener", "()Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;)V", "onDismissListener", "Lcom/larus/common_ui/photoviewer/OnDismissListener;", "getOnDismissListener", "()Lcom/larus/common_ui/photoviewer/OnDismissListener;", "setOnDismissListener", "(Lcom/larus/common_ui/photoviewer/OnDismissListener;)V", "currentPos", "", "getCurrentPos", "()I", "_currentPos", "defaultStartRect", "Landroid/graphics/Rect;", "getDefaultStartRect", "()Landroid/graphics/Rect;", "setDefaultStartRect", "(Landroid/graphics/Rect;)V", "isAnimatedShow", "", "indicatorViews", "Ljava/util/ArrayList;", "Lcom/larus/common_ui/photoviewer/IIndicatorView;", "Lkotlin/collections/ArrayList;", "backgroundAlphaFactor", "", "backgroundAlphaFactorWhenDragEnd", "orientationHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "restoreTransitionProvider", "getRestoreTransitionProvider", "()Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "setRestoreTransitionProvider", "(Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;)V", "isInfinityLoop", "()Z", "setInfinityLoop", "(Z)V", "dismissAnimationType", "getDismissAnimationType", "setDismissAnimationType", "(I)V", "updateLayoutManager", "", "initAdapter", "dispatchOnPageUnSelected", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "dispatchOnPageSelected", "byScroll", "addIndicatorView", "indicatorView", "removeIndicatorView", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "makeNavigateBarTransparent", "showAnimated", "position", "startRect", "view", "Landroid/view/View;", "enableRestoreTransition", "show", LiveCommonConstants.REASON_ON_DEDTROY, "dismiss", "setCurrentPos", "bindRestoreRecyclerView", "recyclerView", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PhotoViewerDialog extends Dialog implements g, LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TransitionPagerAdapter<?> f327626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f327627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f327628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f327629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f327630e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f327631f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f327632g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f327633h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<d> f327634i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f327635j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f327636k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OrientationHelper f327637l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e f327638m;

    @Override // j19.g
    public final void S80(int r100) {
    }

    @Override // j19.g
    public final void onPageSelected(int r100) {
    }

    @Override // j19.g
    public final void onPageSelected(int r100, boolean r101) {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        this.f327626a.getClass();
        f r100 = this.f327630e;
        if (r100 == null) goto L5;
        r100.onDismiss();
    L5:
        Handler r101 = DialogLancet.resolveDialogHandler(this);
        if (r101 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r102 == null) goto L19;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L8:
        if (Looper.myLooper() == r101.getLooper()) goto L10;
        r101.post(DialogLancet.createDismissRunnable(this));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        if (isShowing() == false) goto L21;
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(this);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r101 == null) goto L18;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r100.getLooper()) goto L9;
        r100.post(DialogLancet.createDismissRunnable(this));
        return;
    L21:
        this.f327626a.getClass();
    }

    public static View b(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void c(PhotoViewerDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.requestFeature(1);
    L5:
        setContentView(this.f327628c);
        Window r102 = getWindow();
        if (r102 != null) goto L8;
        return;
    L8:
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r102.setLayout(-1, -1);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.clearFlags(2);
        b(r102).setPadding(0, 0, 0, 0);
        int r104 = Build.VERSION.SDK_INT;
        r102.addFlags(Integer.MIN_VALUE);
        b(r102).setSystemUiVisibility(1280);
        if (r104 <= 28) goto L11;
        r103.layoutInDisplayCutoutMode = 1;
    L11:
        Window r105 = getWindow();
        if (r105 == null) goto L15;
        r105.setNavigationBarColor(0);
        r105.addFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
    L15:
        this.f327628c.setBackgroundColor(getContext().getResources().getColor(R.color.black));
        if (this.f327633h == false) goto L19;
        this.f327628c.getBackground().setAlpha(0);
        this.f327635j = 0.0f;
        return;
    }

    public PhotoViewerDialog(Context r100, TransitionPagerAdapter<?> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "transitionAdapter");
        super(r100);
        this.f327626a = r101;
        FrameLayout r102 = new FrameLayout(r100);
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f327628c = r102;
        this.f327631f = -1;
        Rect r103 = new Rect();
        Window r104 = getWindow();
        if (r104 == null) goto L9;
        WindowManager r105 = r104.getWindowManager();
        if (r105 == null) goto L9;
        Display r106 = r105.getDefaultDisplay();
        if (r106 == null) goto L9;
        int r107 = r106.getWidth();
    L10:
        Window r108 = getWindow();
        if (r108 == null) goto L17;
        WindowManager r109 = r108.getWindowManager();
        if (r109 == null) goto L17;
        Display r110 = r109.getDefaultDisplay();
        if (r110 == null) goto L17;
        int r111 = r110.getHeight();
    L18:
        int r112 = r107 / 2;
        r103.left = r112;
        int r113 = r111 / 2;
        r103.top = r113;
        r103.right = r112;
        r103.bottom = r113;
        this.f327632g = r103;
        this.f327634i = new ArrayList();
        this.f327635j = 1.0f;
        this.f327636k = 1.0f;
        RecyclerView r114 = new RecyclerView(r100);
        r114.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f327627b = r114;
        new PagerSnapHelper().attachToRecyclerView(r114);
        r102.addView(r114, 0);
        r114.addOnScrollListener(new AnonymousClass2(this));
        r114.setAdapter(r101);
        i r115 = new i(this);
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r101.f327749b = r115;
        r101.registerAdapterDataObserver(new PhotoViewerDialog$initAdapter$2(this));
        if ((r100 instanceof FragmentActivity) == false) goto L21;
        FragmentActivity r116 = (FragmentActivity) r100;
    L22:
        if (r116 == null) goto L26;
        Lifecycle r117 = r116.getLifecycle();
        if (r117 == null) goto L26;
        r117.addObserver(this);
    L26:
        LinearLayoutManager r118 = new LinearLayoutManager(getContext());
        r118.setOrientation(0);
        r114.setLayoutManager(r118);
        this.f327637l = OrientationHelper.createHorizontalHelper(r114.getLayoutManager());
        return;
    L21:
        r116 = null;
    L17:
        r111 = 0;
    L9:
        r107 = 0;
        goto L10
    }

    public final void d(int r100, boolean r101) {
        int r102 = this.f327631f;
        if (r102 == r100) goto L30;
        Iterator<d> r103 = this.f327634i.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r103.next().S80(r102);
        goto L6
    L8:
        g r104 = this.f327629d;
        if (r104 == null) goto L11;
        r104.S80(r102);
    L11:
        this.f327626a.S80(r102);
        this.f327631f = r100;
        Iterator<d> r105 = this.f327634i.iterator();
    L13:
        if (r105.hasNext() == false) goto L15;
        r105.next().onPageSelected(r100);
        goto L13
    L15:
        g r106 = this.f327629d;
        if (r106 == null) goto L18;
        r106.onPageSelected(r100);
    L18:
        this.f327626a.onPageSelected(r100);
        Iterator<d> r107 = this.f327634i.iterator();
    L20:
        if (r107.hasNext() == false) goto L22;
        r107.next().onPageSelected(r100, r101);
        goto L20
    L22:
        g r108 = this.f327629d;
        if (r108 == null) goto L25;
        r108.onPageSelected(r100, r101);
    L25:
        this.f327626a.getClass();
        return;
    }

    public final void e(int r100, Rect r101) {
        if (isShowing() == false) goto L5;
        return;
    L5:
        if (r100 < this.f327626a.getItemCount()) goto L7;
        d(0, false);
        this.f327627b.scrollToPosition(0);
        c(this);
        return;
    L7:
        d(r100, false);
        this.f327627b.scrollToPosition(r100);
        TransitionPagerAdapter<?> r102 = this.f327626a;
        if (r101 != null) goto L10;
        r101 = this.f327632g;
    L10:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "startRect");
        if (r100 >= r102.getItemCount()) goto L14;
        r102.f327748a = true;
        r102.f327754g.set(r101);
    L14:
        this.f327633h = true;
        c(this);
    }

    public final void f(int r100, View r101) {
        Intrinsics.checkNotNullParameter(r101, "view");
        if (this.f327638m != null) goto L5;
        j r102 = new j(r100, r101);
        this.f327638m = r102;
        this.f327626a.f327751d = r102;
    L5:
        Intrinsics.checkNotNullParameter(r101, "view");
        GenericDraweeView r103 = j19.c.b(r101);
        if (r103 == null) goto L8;
        r101 = r103;
    L8:
        e(r100, h.a(r101));
    }
}
