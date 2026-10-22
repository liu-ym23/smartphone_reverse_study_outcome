package com.bytedance.ee.bear.bizwidget.dialogfragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.Insets;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment;
import com.bytedance.ee.bear.tts.lynx.view.TtsLynxFullscreenPlayerView;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.g;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001:\u0002TUB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\nH\u0016J\u0010\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020\nH\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\u0012\u0010$\u001a\u00020 2\b\b\u0001\u0010%\u001a\u00020\u0012H\u0016J\u0010\u0010&\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010'\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010(\u001a\u00020 2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010)\u001a\u00020\u0016H\u0014J\n\u0010*\u001a\u0004\u0018\u00010+H\u0014J\b\u0010,\u001a\u00020\u0012H\u0014J\b\u0010-\u001a\u00020.H\u0014J\b\u0010/\u001a\u00020\u0012H\u0014J\b\u00100\u001a\u00020.H\u0014J\b\u00101\u001a\u00020\u0012H\u0014J\b\u00102\u001a\u00020 H\u0014J\n\u00103\u001a\u0004\u0018\u000104H\u0004J\n\u00105\u001a\u0004\u0018\u000106H\u0004J\n\u00107\u001a\u0004\u0018\u000104H\u0004J&\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u001a\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u0002092\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0012\u0010B\u001a\u00020C2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010D\u001a\u00020 H\u0016J\b\u0010E\u001a\u00020 H\u0016J\u0010\u0010F\u001a\u00020 2\u0006\u0010G\u001a\u00020HH\u0016J\u0010\u0010I\u001a\u00020 2\u0006\u0010G\u001a\u00020HH\u0016J\b\u0010J\u001a\u00020 H\u0016J\b\u0010K\u001a\u00020 H\u0016J\b\u0010L\u001a\u00020 H\u0002J\b\u0010M\u001a\u00020 H\u0002J\b\u0010N\u001a\u00020 H\u0002J\b\u0010O\u001a\u00020 H\u0002J\b\u0010P\u001a\u00020 H\u0002J\b\u0010Q\u001a\u00020 H\u0002J\b\u0010R\u001a\u00020 H\u0002J\b\u0010S\u001a\u00020 H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001c\u0010\u001d¨\u0006V"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseUDBottomSheetDialogFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/CompatLandscapeBottomSheetDialogFragment;", "logTag", "", "<init>", "(Ljava/lang/String;)V", "getLogTag", "()Ljava/lang/String;", "stateListenerSet", "", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseUDBottomSheetDialogFragment$OnStateListener;", "getStateListenerSet", "()Ljava/util/Set;", "stateListenerSet$delegate", "Lkotlin/Lazy;", "onViewMeasuredRunnable", "Ljava/lang/Runnable;", "bgColorInt", "", "bgDrawable", "Landroid/graphics/drawable/GradientDrawable;", "isDraggable", "", "isShowDragBar", "titleText", "", "insetsBgDrawable", "Lcom/ss/android/lark/insets/InsetsDecorationDrawable;", "getInsetsBgDrawable", "()Lcom/ss/android/lark/insets/InsetsDecorationDrawable;", "insetsBgDrawable$delegate", "addStateListener", "", "listener", "removeStateListener", "isNeedFitSystemWindows", "setBackgroundColor", "colorInt", "setDraggable", "setIsShowDragBar", com.alipay.sdk.m.x.d.f25925o, "getIsImmersiveStatusBar", "getCornerRadius", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseUDBottomSheetDialogFragment$CornerRadius;", "getMaxHeightPx", "getMaxHeightRate", "", "getMinHeightPx", "getMinHeightRate", "calculateHeightPx", "onViewMeasured", "getDragBarContainer", "Landroid/widget/FrameLayout;", "getTitleContainer", "Landroid/widget/LinearLayout;", "getContentContainer", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onCreateDialog", "Landroid/app/Dialog;", WidgetCostModule.TYPE_ON_START, "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onCancel", LiveCommonConstants.REASON_ON_DEDTROY, "dismissAllowingStateLoss", "resetBackgroundColor", "resetImmersiveStatusBar", "resetCornerRadius", "resetDraggable", "resetDragBar", "resizeDialogFragment", "resetTitle", "notifyClosed", "OnStateListener", "CornerRadius", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseUDBottomSheetDialogFragment extends CompatLandscapeBottomSheetDialogFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f216379k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f216380l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f216381m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f216382n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final GradientDrawable f216383o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f216384p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f216385q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f216386r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f216387s;

    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int f216388d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f216389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f216390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Rect f216391c;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment$a$a, reason: collision with other inner class name */
        public static final class C3088a {
            @JvmStatic
            public static a a(int r100) {
                Rect r101 = new Rect();
                r101.bottom = r100;
                Unit r102 = Unit.INSTANCE;
                return new a(r100, r100, r101);
            }
        }

        static {
        }

        public a(int r100, int r101, Rect r102) {
            this.f216389a = r100;
            this.f216390b = r101;
            this.f216391c = r102;
        }
    }

    public interface b {
        void a(BaseUDBottomSheetDialogFragment r100);
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseUDBottomSheetDialogFragment f216392a;

        public c(BaseUDBottomSheetDialogFragment r100) {
            this.f216392a = r100;
        }

        public final void a() {
            BaseUDBottomSheetDialogFragment r100 = this.f216392a;
            tt5.a.h(r100.f216379k, "onViewMeasured");
            View r101 = r100.getView();
            if (r101 != null) goto L5;
            tt5.a.k(r100.f216379k, "resetCornerRadius, view is null.");
            return;
        L5:
            a r102 = r100.ga0();
            r101.setClipToOutline(true);
            if (Build.VERSION.SDK_INT < 33) goto L20;
            float r103 = 0.0f;
            if (r102 == null) goto L10;
            float r104 = r102.f216389a;
        L11:
            if (r102 == null) goto L13;
            float r105 = r102.f216390b;
        L14:
            if (r102 == null) goto L16;
            float r106 = 0;
        L17:
            if (r102 == null) goto L19;
            r103 = 0;
        L19:
            r100.f216383o.setCornerRadii(new float[]{r104, r104, r105, r105, r106, r106, r103, r103});
            r101.setBackground(r100.f216383o);
            r101.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
            tt5.a.h(r100.f216379k, "resetCornerRadius, by GradientDrawable, cornerRadius: " + r102);
            return;
        L16:
            r106 = 0.0f;
            goto L17
        L13:
            r105 = 0.0f;
            goto L14
        L10:
            r104 = 0.0f;
            goto L11
        L20:
            if (r102 == null) goto L24;
            Rect r107 = r102.f216391c;
            if (r107 == null) goto L24;
            int r108 = r107.left;
        L25:
            if (r102 == null) goto L29;
            Rect r109 = r102.f216391c;
            if (r109 == null) goto L29;
            int r110 = r109.top;
        L30:
            if (r102 == null) goto L34;
            Rect r111 = r102.f216391c;
            if (r111 == null) goto L34;
            int r112 = r111.right;
        L35:
            if (r102 == null) goto L39;
            Rect r113 = r102.f216391c;
            if (r113 == null) goto L39;
            int r114 = r113.bottom;
        L40:
            Rect r115 = new Rect(0, 0, r101.getWidth(), r101.getHeight());
            r101.setOutlineProvider(new com.bytedance.ee.bear.bizwidget.dialogfragment.a(r115, r108, r110, r112, r114, RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(r108, r110), r112), r114)));
            tt5.a.h(r100.f216379k, "resetCornerRadius, by ViewOutlineProvider, cornerRadius: " + r102 + ", viewRect: " + r115);
            return;
        L39:
            r114 = 0;
        L34:
            r112 = 0;
        L29:
            r110 = 0;
        L24:
            r108 = 0;
            goto L25
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f216393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f216394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseUDBottomSheetDialogFragment f216395c;

        public d(View r100, View r101, BaseUDBottomSheetDialogFragment r102) {
            this.f216393a = r100;
            this.f216394b = r101;
            this.f216395c = r102;
        }

        public final void a() {
            this.f216394b.setBackground((g) this.f216395c.f216387s.getValue());
            WindowInsetsCompat r100 = ViewCompat.getRootWindowInsets(this.f216394b);
            if (r100 == null) goto L5;
            Insets r101 = r100.getInsets(WindowInsetsCompat.Type.systemBars());
        L6:
            ((g) this.f216395c.f216387s.getValue()).a(r101);
            if (this.f216395c.ja0() == false) goto L9;
            g r102 = (g) this.f216395c.f216387s.getValue();
            r102.f427755f = this.f216395c.f216382n;
        L10:
            g r103 = (g) this.f216395c.f216387s.getValue();
            r103.f427756g = UIUtils.getColor(this.f216395c.getActivity(), R.color.bg_base);
            return;
        L9:
            ((g) this.f216395c.f216387s.getValue()).f427755f = 0;
            goto L10
        L5:
            r101 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a ga0() {
        return null;
    }

    public float ha0() {
        return 0.0f;
    }

    public int ia0() {
        return 0;
    }

    public boolean ja0() {
        return this instanceof TtsLynxFullscreenPlayerView;
    }

    public final void qa0() {
        int r100 = 0;
        this.f216385q = false;
        tt5.a.h(this.f216379k, "resetDragBar, isShowDragBar: " + this.f216385q);
        View r101 = getView();
        if (r101 == null) goto L5;
        FrameLayout r102 = (FrameLayout) r101.findViewById(R.id.flDragBarContainer);
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        if (this.f216385q == true) goto L11;
        r100 = 8;
    L11:
        r102.setVisibility(r100);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void ma0() {
        tt5.a.h(this.f216379k, "resetDraggable, isDraggable: " + this.f216384p);
        Dialog r100 = getDialog();     // Catch: Throwable -> L13
        if ((r100 instanceof BottomSheetDialog) == false) goto L6;
        BottomSheetDialog r101 = (BottomSheetDialog) r100;     // Catch: Throwable -> L13
    L7:
        if (r101 == null) goto L11;
        BottomSheetBehavior r102 = r101.getBehavior();     // Catch: Throwable -> L13
        if (r102 == null) goto L11;
        r102.setDraggable(this.f216384p);     // Catch: Throwable -> L13
        return;
    L11:
        tt5.a.k(this.f216379k, "resetDraggable, BottomSheetBehavior not found.");     // Catch: Throwable -> L13
        return;
    L6:
        r101 = null;
    L13:
        th = move-exception;
        tt5.a.e(this.f216379k, "resetDraggable, error when disabling drag for BottomSheetBehavior:", th, false);
    }

    public final void na0() {
        if ((this instanceof TtsLynxFullscreenPlayerView) == true) goto L5;
        return;
    L5:
        Dialog r100 = getDialog();
        int r101 = WindowInsetsUtils.f427723a;
        if (r100 == null) goto L11;
        Window r102 = r100.getWindow();
        if (r102 == null) goto L11;
        WindowInsetsUtils.h(r102, WindowInsetsUtils.a(r100));
    L11:
        Dialog r103 = getDialog();
        if (r103 == null) goto L16;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L16;
        View r105 = r104.findViewById(R.id.container);
    L17:
        if (r105 == null) goto L19;
        OneShotPreDrawListener.add(r105, new d(r105, r105, this));
    L19:
        Dialog r106 = getDialog();
        if (r106 == null) goto L31;
        Window r107 = r106.getWindow();
        if (r107 == null) goto L32;
        da0(r107).setSystemUiVisibility(1280);
        r107.addFlags(Integer.MIN_VALUE);
        if (Build.VERSION.SDK_INT < 23) goto L33;
        WindowInsetsControllerCompat r108 = WindowCompat.getInsetsController(r107, da0(r107));
        if (r108 == null) goto L28;
        r108.setAppearanceLightStatusBars(BaseAntiScreenshotsSheetDialogFragment.a.a(this.f216382n));
    L28:
        if (r108 == null) goto L34;
        r108.setAppearanceLightNavigationBars(BaseAntiScreenshotsSheetDialogFragment.a.a(this.f216382n));
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L16:
        r105 = null;
        goto L17
    }

    private final void la0() {
        View r100 = getView();
        if (r100 == null) goto L6;
        tt5.a.h(this.f216379k, "resetBackgroundColor, color: " + this.f216382n);
        r100.setBackground(this.f216383o);
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final void dismissAllowingStateLoss() {
        super.dismissAllowingStateLoss();     // Catch: Exception -> L4 Throwable -> L9
    L12:
        return;
    L9:
        th = move-exception;
        tt5.a.e(this.f216379k, "dismissAllowingStateLoss error,", th, false);
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L9
        Throwable r100 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L9
        if (r100 == null) goto L12;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L9
        goto L12
    }

    public int ea0() {
        Context r100 = getContext();
        if (r100 != null) goto L5;
        r100 = LarkContext.getApplication();
    L5:
        int r101 = DeviceUtils.getRealScreenHeight(r100);
        tt5.a.h(this.f216379k, "calculateHeightPx, screenHeight: " + r101);
        Integer r102 = Integer.valueOf(ia0());
        int r103 = r102.intValue();
        tt5.a.h(this.f216379k, "calculateHeightPx, getMinHeightPx: " + r103);
        boolean r104 = true;
        if (r102.intValue() <= 0) goto L8;
        boolean r105 = true;
    L9:
        Integer r106 = null;
        if (r105 == true) goto L14;
        r102 = null;
    L14:
        if (r102 == null) goto L16;
    L15:
        int r107 = r102.intValue();
    L29:
        Integer r108 = 0;
        int r109 = r108.intValue();
        tt5.a.h(this.f216379k, "calculateHeightPx, getMaxHeightPx: " + r109);
        if (r108.intValue() <= 0) goto L32;
        boolean r110 = true;
    L33:
        if (r110 == true) goto L36;
        r108 = null;
    L36:
        if (r108 == null) goto L38;
        int r111 = r108.intValue();
    L51:
        Integer r112 = Integer.valueOf(RangesKt.coerceIn(r111, 0, r101));
        if (r112.intValue() > RangesKt.coerceIn(r107, 0, r101)) goto L55;
        r104 = false;
    L55:
        if (r104 == false) goto L57;
        r106 = r112;
    L57:
        if (r106 == null) goto L59;
        r107 = r106.intValue();
    L59:
        tt5.a.h(this.f216379k, "calculateHeightPx, targetHeightPx: " + r107);
        return r107;
    L38:
        Float r113 = Float.valueOf(ha0());
        float r114 = r113.floatValue();
        tt5.a.h(this.f216379k, "calculateHeightPx, getMaxHeightRate: " + r114);
        if (r113.floatValue() <= 0.0f) goto L41;
        boolean r115 = true;
    L42:
        if (r115 == true) goto L45;
        r113 = null;
    L45:
        if (r113 == null) goto L47;
        Integer r116 = Integer.valueOf(RangesKt.coerceAtMost((int) (r113.floatValue() * r101), r101));
    L48:
        if (r116 == null) goto L50;
        r111 = r116.intValue();
        goto L51
    L50:
        r111 = r101;
        goto L51
    L47:
        r116 = null;
        goto L48
    L41:
        r115 = false;
        goto L42
    L32:
        r110 = false;
        goto L33
    L16:
        Float r117 = Float.valueOf(0.0f);
        float r118 = r117.floatValue();
        tt5.a.h(this.f216379k, "calculateHeightPx, getMinHeightRate: " + r118);
        if (r117.floatValue() <= 0.0f) goto L19;
        boolean r119 = true;
    L20:
        if (r119 == true) goto L23;
        r117 = null;
    L23:
        if (r117 == null) goto L25;
        r102 = Integer.valueOf((int) (r117.floatValue() * r101));
    L26:
        if (r102 != null) goto L15;
        r107 = 0;
        goto L29
    L25:
        r102 = null;
        goto L26
    L19:
        r119 = false;
        goto L20
    L8:
        r105 = false;
        goto L9
    }

    public final FrameLayout fa0() {
        View r100 = getView();
        if (r100 != null) goto L7;
        return null;
    L7:
        return (FrameLayout) r100.findViewById(R.id.flContentContainer);
    }

    public final void oa0() {
        View r100 = getView();
        TextView r101 = null;
        if (r100 == null) goto L5;
        LinearLayout r102 = (LinearLayout) r100.findViewById(R.id.llTitleContainer);
    L6:
        if (r102 == null) goto L8;
        r101 = (TextView) r102.findViewById(R.id.tvTitle);
    L8:
        if (r101 == null) goto L10;
        r101.setText(this.f216386r);
    L10:
        if (r102 == null) goto L22;
        CharSequence r103 = this.f216386r;
        int r104 = 0;
        if (r103 != null) goto L14;
    L17:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L20;
        r104 = 8;
    L20:
        r102.setVisibility(r104);
        return;
    L14:
        if (r103.length() == 0) goto L17;
        r105 = false;
        goto L18
    L22:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        tt5.a.h(this.f216379k, LiveCommonConstants.REASON_ON_DEDTROY);
        View r100 = getView();
        if (r100 == null) goto L6;
        r100.removeCallbacks(this.f216381m);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        tt5.a.h(this.f216379k, "onDestroyView");
        View r100 = getView();
        if (r100 == null) goto L6;
        r100.removeCallbacks(this.f216381m);
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        tt5.a.h(this.f216379k, WidgetCostModule.TYPE_ON_START);
        na0();
        la0();
        ma0();
        oa0();
        int r100 = ea0();
        tt5.a.h(this.f216379k, "resizeDialogFragment, targetHeightPx: " + r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L16;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L16;
        if (ja0() == false) goto L9;
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r103.height = r100;
        r102.setAttributes(r103);
        r102.setGravity(80);
        da0(r102).requestLayout();
    L17:
        View r104 = getView();
        if (r104 == null) goto L20;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        r105.height = r100;
        r104.setLayoutParams(r105);
        return;
    L20:
        tt5.a.d(this.f216379k, "resizeDialogFragment, rootView is null.");
        return;
    L9:
        View r106 = r102.findViewById(R.id.coordinator);
        if (r106 == null) goto L12;
        r106.setFitsSystemWindows(false);
    L12:
        View r107 = r102.findViewById(R.id.container);
        if (r107 == null) goto L15;
        r107.setFitsSystemWindows(false);
    L15:
        r102.setGravity(80);
    L16:
        tt5.a.d(this.f216379k, "resizeDialogFragment, dialogWindow is null.");
        goto L17
    }

    public BaseUDBottomSheetDialogFragment(String r100) {
        Intrinsics.checkNotNullParameter(r100, "logTag");
        this.f216379k = r100;
        this.f216380l = LazyKt.lazy(BaseUDBottomSheetDialogFragment$stateListenerSet$2.INSTANCE);
        this.f216381m = new c(this);
        GradientDrawable r101 = new GradientDrawable();
        r101.setShape(0);
        r101.setColor(0);
        this.f216383o = r101;
        this.f216384p = true;
        this.f216385q = true;
        this.f216387s = LazyKt.lazy(BaseUDBottomSheetDialogFragment$insetsBgDrawable$2.INSTANCE);
    }

    public static View da0(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void ka0(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((Set) this.f216380l.getValue()).remove(r100);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onCancel(r100);
        tt5.a.h(this.f216379k, "onCancel");
        Iterator r101 = ((Set) this.f216380l.getValue()).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((b) r101.next()).a(this);
        goto L4
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.CompatLandscapeBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        ma0();
        return r101;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L9
        super.onDismiss(r100);     // Catch: Throwable -> L9
        tt5.a.h(this.f216379k, "onDismiss");     // Catch: Throwable -> L9
        Iterator r101 = ((Set) this.f216380l.getValue()).iterator();     // Catch: Throwable -> L9
    L4:
        if (r101.hasNext() == false) goto L7;
        ((b) r101.next()).a(this);     // Catch: Throwable -> L9
        goto L4
    L7:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L9:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void pa0(int r100) {
        this.f216382n = r100;
        this.f216383o.setColor(r100);
        na0();
        la0();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        tt5.a.h(this.f216379k, "onViewCreated");
        View r102 = getView();
        if (r102 == null) goto L6;
        r102.post(this.f216381m);
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        tt5.a.h(this.f216379k, "onCreateView");
        return r100.inflate(R.layout.layout_base_ud_bottom_sheet, r101, false);
    }
}
