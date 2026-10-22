package com.bytedance.android.ui.ec.widget.photodraweeview;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
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
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionUtils;
import com.bytedance.crash.d;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.GenericDraweeView;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001bJ\b\u00109\u001a\u000207H\u0016J\u0006\u0010:\u001a\u000207J\b\u0010;\u001a\u000207H\u0002J\u0012\u0010<\u001a\u0002072\b\u0010=\u001a\u0004\u0018\u00010>H\u0014J\b\u0010?\u001a\u000207H\u0007J\u0010\u0010@\u001a\u0002072\u0006\u0010A\u001a\u00020\fH\u0016J\u000e\u0010B\u001a\u0002072\u0006\u00108\u001a\u00020\u001bJ\u000e\u0010C\u001a\u0002072\u0006\u0010D\u001a\u00020\fJ\u001a\u0010E\u001a\u0002072\u0006\u0010D\u001a\u00020\f2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0014J\u0016\u0010E\u001a\u0002072\u0006\u0010D\u001a\u00020\f2\u0006\u0010G\u001a\u00020HR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020,@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u00100\u001a\u000201¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0015\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u00105¨\u0006I"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/PhotoViewerDialog;", "Landroid/app/Dialog;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "transitionAdapter", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPagerAdapter;", "(Landroid/content/Context;Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPagerAdapter;)V", "backgroundAlphaFactor", "", "backgroundAlphaFactorWhenDragEnd", "value", "", "currentPosInternal", "setCurrentPosInternal", "(I)V", "currentPosition", "getCurrentPosition", "()I", "defaultStartRect", "Landroid/graphics/Rect;", "getDefaultStartRect", "()Landroid/graphics/Rect;", "setDefaultStartRect", "(Landroid/graphics/Rect;)V", "indicatorViews", "Ljava/util/ArrayList;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/IIndicatorView;", "Lkotlin/collections/ArrayList;", "isAnimatedShow", "", "onDismissListener", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/OnDismissListener;", "getOnDismissListener", "()Lcom/bytedance/android/ui/ec/widget/photodraweeview/OnDismissListener;", "setOnDismissListener", "(Lcom/bytedance/android/ui/ec/widget/photodraweeview/OnDismissListener;)V", "onPageSelectedListener", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/OnPageSelectedListener;", "getOnPageSelectedListener", "()Lcom/bytedance/android/ui/ec/widget/photodraweeview/OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/bytedance/android/ui/ec/widget/photodraweeview/OnPageSelectedListener;)V", "<set-?>", "Landroidx/recyclerview/widget/RecyclerView;", "pager", "getPager", "()Landroidx/recyclerview/widget/RecyclerView;", "rootContainer", "Landroid/widget/FrameLayout;", "getRootContainer", "()Landroid/widget/FrameLayout;", "getTransitionAdapter", "()Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPagerAdapter;", "addIndicatorView", "", "indicatorView", "dismiss", "dispatchOnPageSelected", "initAdapter", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPageSelected", "pos", "removeIndicatorView", "show", "position", "showAnimated", "startRect", "view", "Landroid/view/View;", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PhotoViewerDialog extends Dialog implements LifecycleObserver {
    private float backgroundAlphaFactor;
    private float backgroundAlphaFactorWhenDragEnd;
    private int currentPosInternal;
    private Rect defaultStartRect;
    private ArrayList<IIndicatorView> indicatorViews;
    private boolean isAnimatedShow;
    private OnDismissListener onDismissListener;
    private OnPageSelectedListener onPageSelectedListener;
    private RecyclerView pager;
    private final FrameLayout rootContainer;
    private final TransitionPagerAdapter<?> transitionAdapter;

    public static /* synthetic */ void access$000(Dialog r0) {
        super.dismiss();
    }

    public void onPageSelected(int r1) {
    }

    private final void initAdapter() {
        this.pager.setAdapter(this.transitionAdapter);
        this.transitionAdapter.setInternalTransitionListener(new AnonymousClass1(this));
        this.transitionAdapter.registerAdapterDataObserver(new AnonymousClass2(this));
    }

    public final void dispatchOnPageSelected() {
        Iterator<T> r0 = this.indicatorViews.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IIndicatorView) r0.next()).onPageSelected(this.currentPosInternal);
        goto L4
    L6:
        onPageSelected(this.currentPosInternal);
        OnPageSelectedListener r1 = this.onPageSelectedListener;
        if (r1 == null) goto L11;
        r1.onPageSelected(this.currentPosInternal);
        return;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (isShowing() == false) goto L9;
        this.transitionAdapter.onDestroy();
        OnDismissListener r0 = this.onDismissListener;
        if (r0 == null) goto L7;
        r0.onDismiss(this.currentPosInternal);
    L7:
        INVOKESPECIAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        if (isShowing() == false) goto L5;
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);
        return;
    L5:
        this.transitionAdapter.onDestroy();
    }

    public final int getCurrentPosition() {
        return this.currentPosInternal;
    }

    public final Rect getDefaultStartRect() {
        return this.defaultStartRect;
    }

    public final OnDismissListener getOnDismissListener() {
        return this.onDismissListener;
    }

    public final OnPageSelectedListener getOnPageSelectedListener() {
        return this.onPageSelectedListener;
    }

    public final RecyclerView getPager() {
        return this.pager;
    }

    public final FrameLayout getRootContainer() {
        return this.rootContainer;
    }

    public final TransitionPagerAdapter<?> getTransitionAdapter() {
        return this.transitionAdapter;
    }

    public static void INVOKESPECIAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        access$000(r3);     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static View INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(PhotoViewerDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(PhotoViewerDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public static final /* synthetic */ float access$getBackgroundAlphaFactor$p(PhotoViewerDialog r0) {
        return r0.backgroundAlphaFactor;
    }

    public static final /* synthetic */ float access$getBackgroundAlphaFactorWhenDragEnd$p(PhotoViewerDialog r0) {
        return r0.backgroundAlphaFactorWhenDragEnd;
    }

    public static final /* synthetic */ int access$getCurrentPosInternal$p(PhotoViewerDialog r0) {
        return r0.currentPosInternal;
    }

    public static final /* synthetic */ ArrayList access$getIndicatorViews$p(PhotoViewerDialog r0) {
        return r0.indicatorViews;
    }

    public static final /* synthetic */ RecyclerView access$getPager$p(PhotoViewerDialog r0) {
        return r0.pager;
    }

    private final void setCurrentPosInternal(int r2) {
        if (this.currentPosInternal == r2) goto L6;
        this.currentPosInternal = r2;
        dispatchOnPageSelected();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void addIndicatorView(IIndicatorView r3) {
        Intrinsics.checkNotNullParameter(r3, "indicatorView");
        this.indicatorViews.add(r3);
        this.rootContainer.addView((View) r3);
        r3.onAttach(this.currentPosInternal, this.transitionAdapter);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r7) {
        super.onCreate(r7);
        Window r8 = getWindow();
        if (r8 == null) goto L5;
        r8.requestFeature(1);
    L5:
        setContentView(this.rootContainer);
        Window r9 = getWindow();
        if (r9 != null) goto L8;
        return;
    L8:
        WindowManager.LayoutParams r1 = r9.getAttributes();
        r9.setLayout(-1, -1);
        r9.setBackgroundDrawable(new ColorDrawable(0));
        r9.clearFlags(2);
        int r2 = Build.VERSION.SDK_INT;
        r9.addFlags(Integer.MIN_VALUE);
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r9).setSystemUiVisibility(1280);
        if (r2 <= 28) goto L11;
        r1.layoutInDisplayCutoutMode = 1;
    L11:
        this.rootContainer.setBackgroundColor(getContext().getResources().getColor(R.color.black));
        if (this.isAnimatedShow == false) goto L14;
        this.rootContainer.getBackground().setAlpha(0);
        this.backgroundAlphaFactor = 0.0f;
    L14:
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r9).setPadding(0, 0, 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void removeIndicatorView(IIndicatorView r3) {
        Intrinsics.checkNotNullParameter(r3, "indicatorView");
        this.indicatorViews.remove(r3);
        this.rootContainer.removeView((View) r3);
        r3.onDetach(this.currentPosInternal, this.transitionAdapter);
    }

    public final void setDefaultStartRect(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.defaultStartRect = r2;
    }

    public final void setOnDismissListener(OnDismissListener r1) {
        this.onDismissListener = r1;
    }

    public final void setOnPageSelectedListener(OnPageSelectedListener r1) {
        this.onPageSelectedListener = r1;
    }

    public final void show(int r3) {
        if (isShowing() == true) goto L6;
        this.pager.scrollToPosition(Math.min(r3, this.transitionAdapter.getItemCount()));
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this);
        return;
    }

    public PhotoViewerDialog(Context r6, TransitionPagerAdapter<?> r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "transitionAdapter");
        super(r6);
        this.transitionAdapter = r7;
        FrameLayout r8 = new FrameLayout(r6);
        r8.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Unit r0 = Unit.INSTANCE;
        this.rootContainer = r8;
        this.currentPosInternal = -1;
        Rect r1 = new Rect();
        Window r2 = getWindow();
        if (r2 == null) goto L9;
        WindowManager r3 = r2.getWindowManager();
        if (r3 == null) goto L9;
        Display r4 = r3.getDefaultDisplay();
        if (r4 == null) goto L9;
        int r5 = r4.getWidth();
    L10:
        Window r9 = getWindow();
        if (r9 == null) goto L17;
        WindowManager r10 = r9.getWindowManager();
        if (r10 == null) goto L17;
        Display r11 = r10.getDefaultDisplay();
        if (r11 == null) goto L17;
        int r12 = r11.getHeight();
    L18:
        int r13 = r5 / 2;
        r1.left = r13;
        int r14 = r12 / 2;
        r1.top = r14;
        r1.right = r13;
        r1.bottom = r14;
        this.defaultStartRect = r1;
        this.indicatorViews = new ArrayList();
        this.backgroundAlphaFactor = 1.0f;
        this.backgroundAlphaFactorWhenDragEnd = 1.0f;
        RecyclerView r15 = new RecyclerView(r6);
        r15.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.pager = r15;
        final LinearLayoutManager r16 = new LinearLayoutManager(r6);
        RecyclerView r17 = this.pager;
        r16.setOrientation(0);
        r17.setLayoutManager(r16);
        new PagerSnapHelper().attachToRecyclerView(this.pager);
        r8.addView(this.pager, 0);
        this.pager.addOnScrollListener(new AnonymousClass3(this, r16));
        initAdapter();
        if ((r6 instanceof FragmentActivity) == true) goto L21;
        r6 = null;
    L21:
        FragmentActivity r18 = (FragmentActivity) r6;
        if (r18 == null) goto L27;
        Lifecycle r19 = r18.getLifecycle();
        if (r19 == null) goto L28;
        r19.addObserver(this);
        return;
    L28:
        return;
    L27:
        return;
    L17:
        r12 = 0;
    L9:
        r5 = 0;
        goto L10
    }

    public static final /* synthetic */ void access$setBackgroundAlphaFactor$p(PhotoViewerDialog r0, float r1) {
        r0.backgroundAlphaFactor = r1;
    }

    public static final /* synthetic */ void access$setBackgroundAlphaFactorWhenDragEnd$p(PhotoViewerDialog r0, float r1) {
        r0.backgroundAlphaFactorWhenDragEnd = r1;
    }

    public static final /* synthetic */ void access$setCurrentPosInternal$p(PhotoViewerDialog r0, int r1) {
        r0.setCurrentPosInternal(r1);
    }

    public static final /* synthetic */ void access$setIndicatorViews$p(PhotoViewerDialog r0, ArrayList r1) {
        r0.indicatorViews = r1;
    }

    public static final /* synthetic */ void access$setPager$p(PhotoViewerDialog r0, RecyclerView r1) {
        r0.pager = r1;
    }

    public final void showAnimated(int r5, View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        if ((r6 instanceof GenericDraweeView) == true) goto L5;
        View r0 = null;
    L6:
        GenericDraweeView r1 = (GenericDraweeView) r0;
        if (r1 == null) goto L11;
        GenericDraweeHierarchy r2 = r1.getHierarchy();
        if (r2 == null) goto L11;
        RectF r3 = new RectF();
        r2.getActualImageBounds(r3);
        int r4 = (int) r3.width();
        int r7 = (int) r3.height();
    L12:
        if (r7 == 0) goto L14;
        if (r4 == 0) goto L14;
    L15:
        showAnimated(r5, TransitionUtils.calculateStartRect(r6, new int[]{r4, r7}));
        return;
    L14:
        r4 = r6.getWidth();
        r7 = r6.getHeight();
    L11:
        r4 = 0;
        r7 = 0;
        goto L12
    L5:
        r0 = r6;
        goto L6
    }

    public final void showAnimated(int r2, Rect r3) {
        if (isShowing() == false) goto L5;
        return;
    L5:
        if (r2 < this.transitionAdapter.getItemCount()) goto L7;
        setCurrentPosInternal(0);
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this);
        return;
    L7:
        setCurrentPosInternal(r2);
        this.pager.scrollToPosition(r2);
        TransitionPagerAdapter<?> r0 = this.transitionAdapter;
        if (r3 != null) goto L10;
        r3 = this.defaultStartRect;
    L10:
        r0.setEnterAnimationParams(r2, r3);
        this.isAnimatedShow = true;
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this);
    }

    public static /* synthetic */ void showAnimated$default(PhotoViewerDialog r0, int r1, Rect r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.showAnimated(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAnimated");
    }
}
