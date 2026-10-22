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
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.tts.lynx.view.TtsLynxFullscreenPlayerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001:\u0002TUB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\nH\u0016J\u0010\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020\nH\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\u0012\u0010$\u001a\u00020 2\b\b\u0001\u0010%\u001a\u00020\u0012H\u0016J\u0010\u0010&\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010'\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010(\u001a\u00020 2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010)\u001a\u00020\u0016H\u0014J\n\u0010*\u001a\u0004\u0018\u00010+H\u0014J\b\u0010,\u001a\u00020\u0012H\u0014J\b\u0010-\u001a\u00020.H\u0014J\b\u0010/\u001a\u00020\u0012H\u0014J\b\u00100\u001a\u00020.H\u0014J\b\u00101\u001a\u00020\u0012H\u0014J\b\u00102\u001a\u00020 H\u0014J\n\u00103\u001a\u0004\u0018\u000104H\u0004J\n\u00105\u001a\u0004\u0018\u000106H\u0004J\n\u00107\u001a\u0004\u0018\u000104H\u0004J&\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u001a\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u0002092\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0012\u0010B\u001a\u00020C2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010D\u001a\u00020 H\u0016J\b\u0010E\u001a\u00020 H\u0016J\u0010\u0010F\u001a\u00020 2\u0006\u0010G\u001a\u00020HH\u0016J\u0010\u0010I\u001a\u00020 2\u0006\u0010G\u001a\u00020HH\u0016J\b\u0010J\u001a\u00020 H\u0016J\b\u0010K\u001a\u00020 H\u0016J\b\u0010L\u001a\u00020 H\u0002J\b\u0010M\u001a\u00020 H\u0002J\b\u0010N\u001a\u00020 H\u0002J\b\u0010O\u001a\u00020 H\u0002J\b\u0010P\u001a\u00020 H\u0002J\b\u0010Q\u001a\u00020 H\u0002J\b\u0010R\u001a\u00020 H\u0002J\b\u0010S\u001a\u00020 H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001c\u0010\u001d¨\u0006V"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseUDBottomSheetDialogFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/CompatLandscapeBottomSheetDialogFragment;", "logTag", "", "<init>", "(Ljava/lang/String;)V", "getLogTag", "()Ljava/lang/String;", "stateListenerSet", "", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseUDBottomSheetDialogFragment$OnStateListener;", "getStateListenerSet", "()Ljava/util/Set;", "stateListenerSet$delegate", "Lkotlin/Lazy;", "onViewMeasuredRunnable", "Ljava/lang/Runnable;", "bgColorInt", "", "bgDrawable", "Landroid/graphics/drawable/GradientDrawable;", "isDraggable", "", "isShowDragBar", "titleText", "", "insetsBgDrawable", "Lcom/ss/android/lark/insets/InsetsDecorationDrawable;", "getInsetsBgDrawable", "()Lcom/ss/android/lark/insets/InsetsDecorationDrawable;", "insetsBgDrawable$delegate", "addStateListener", "", "listener", "removeStateListener", "isNeedFitSystemWindows", "setBackgroundColor", "colorInt", "setDraggable", "setIsShowDragBar", "setTitle", "getIsImmersiveStatusBar", "getCornerRadius", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseUDBottomSheetDialogFragment$CornerRadius;", "getMaxHeightPx", "getMaxHeightRate", "", "getMinHeightPx", "getMinHeightRate", "calculateHeightPx", "onViewMeasured", "getDragBarContainer", "Landroid/widget/FrameLayout;", "getTitleContainer", "Landroid/widget/LinearLayout;", "getContentContainer", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onCreateDialog", "Landroid/app/Dialog;", "onStart", "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onCancel", "onDestroy", "dismissAllowingStateLoss", "resetBackgroundColor", "resetImmersiveStatusBar", "resetCornerRadius", "resetDraggable", "resetDragBar", "resizeDialogFragment", "resetTitle", "notifyClosed", "OnStateListener", "CornerRadius", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseUDBottomSheetDialogFragment extends CompatLandscapeBottomSheetDialogFragment {
    public final String k;
    public final Lazy l;
    public final c m;
    public int n;
    public final GradientDrawable o;
    public boolean p;
    public boolean q;
    public CharSequence r;
    public final Lazy s;

    public static final class a {
        public static final /* synthetic */ int d = 0;
        public final int a;
        public final int b;
        public final Rect c;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment$a$a, reason: collision with other inner class name */
        public static final class C0032a {
            @JvmStatic
            public static a a(int r2) {
                Rect r0 = new Rect();
                r0.bottom = r2;
                Unit r1 = Unit.INSTANCE;
                return new a(r2, r2, r0);
            }
        }

        static {
        }

        public a(int r1, int r2, Rect r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public interface b {
        void a(BaseUDBottomSheetDialogFragment r1);
    }

    public static final class c implements Runnable {
        public final /* synthetic */ BaseUDBottomSheetDialogFragment a;

        public c(BaseUDBottomSheetDialogFragment r1) {
            this.a = r1;
        }

        public final void a() {
            BaseUDBottomSheetDialogFragment r0 = this.a;
            tt5.a.h(r0.k, "onViewMeasured");
            View r1 = r0.getView();
            if (r1 != null) goto L5;
            tt5.a.k(r0.k, "resetCornerRadius, view is null.");
            return;
        L5:
            a r2 = r0.ga0();
            r1.setClipToOutline(true);
            if (Build.VERSION.SDK_INT < 33) goto L20;
            float r4 = 0.0f;
            if (r2 == null) goto L10;
            float r5 = r2.a;
        L11:
            if (r2 == null) goto L13;
            float r7 = r2.b;
        L14:
            if (r2 == null) goto L16;
            float r8 = 0;
        L17:
            if (r2 == null) goto L19;
            r4 = 0;
        L19:
            r0.o.setCornerRadii(new float[]{r5, r5, r7, r7, r8, r8, r4, r4});
            r1.setBackground(r0.o);
            r1.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
            tt5.a.h(r0.k, "resetCornerRadius, by GradientDrawable, cornerRadius: " + r2);
            return;
        L16:
            r8 = 0.0f;
            goto L17
        L13:
            r7 = 0.0f;
            goto L14
        L10:
            r5 = 0.0f;
            goto L11
        L20:
            if (r2 == null) goto L24;
            Rect r3 = r2.c;
            if (r3 == null) goto L24;
            int r9 = r3.left;
        L25:
            if (r2 == null) goto L29;
            Rect r6 = r2.c;
            if (r6 == null) goto L29;
            int r10 = r6.top;
        L30:
            if (r2 == null) goto L34;
            Rect r11 = r2.c;
            if (r11 == null) goto L34;
            int r12 = r11.right;
        L35:
            if (r2 == null) goto L39;
            Rect r13 = r2.c;
            if (r13 == null) goto L39;
            int r14 = r13.bottom;
        L40:
            Rect r16 = new Rect(0, 0, r1.getWidth(), r1.getHeight());
            r1.setOutlineProvider(new com.bytedance.ee.bear.bizwidget.dialogfragment.a(r16, r9, r10, r12, r14, RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(r9, r10), r12), r14)));
            tt5.a.h(r0.k, "resetCornerRadius, by ViewOutlineProvider, cornerRadius: " + r2 + ", viewRect: " + r16);
            return;
        L39:
            r14 = 0;
        L34:
            r12 = 0;
        L29:
            r10 = 0;
        L24:
            r9 = 0;
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
        public final /* synthetic */ View a;
        public final /* synthetic */ View b;
        public final /* synthetic */ BaseUDBottomSheetDialogFragment c;

        public d(View r1, View r2, BaseUDBottomSheetDialogFragment r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            this.b.setBackground((g) this.c.s.getValue());
            WindowInsetsCompat r0 = ViewCompat.getRootWindowInsets(this.b);
            if (r0 == null) goto L5;
            Insets r1 = r0.getInsets(WindowInsetsCompat.Type.systemBars());
        L6:
            ((g) this.c.s.getValue()).a(r1);
            if (this.c.ja0() == false) goto L9;
            g r2 = (g) this.c.s.getValue();
            r2.f = this.c.n;
        L10:
            g r3 = (g) this.c.s.getValue();
            r3.g = UIUtils.getColor(this.c.getActivity(), 2131100545);
            return;
        L9:
            ((g) this.c.s.getValue()).f = 0;
            goto L10
        L5:
            r1 = null;
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
        int r0 = 0;
        this.q = false;
        tt5.a.h(this.k, "resetDragBar, isShowDragBar: " + this.q);
        View r1 = getView();
        if (r1 == null) goto L5;
        FrameLayout r2 = (FrameLayout) r1.findViewById(2131372648);
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        if (this.q == true) goto L11;
        r0 = 8;
    L11:
        r2.setVisibility(r0);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void ma0() {
        tt5.a.h(this.k, "resetDraggable, isDraggable: " + this.p);
        BottomSheetDialog r0 = getDialog();     // Catch: Throwable -> L13
        if ((r0 instanceof BottomSheetDialog) == false) goto L6;
        BottomSheetDialog r1 = r0;     // Catch: Throwable -> L13
    L7:
        if (r1 == null) goto L11;
        BottomSheetBehavior r2 = r1.getBehavior();     // Catch: Throwable -> L13
        if (r2 == null) goto L11;
        r2.setDraggable(this.p);     // Catch: Throwable -> L13
        return;
    L11:
        tt5.a.k(this.k, "resetDraggable, BottomSheetBehavior not found.");     // Catch: Throwable -> L13
        return;
    L6:
        r1 = null;
    L13:
        th = move-exception;
        tt5.a.e(this.k, "resetDraggable, error when disabling drag for BottomSheetBehavior:", th, false);
    }

    public final void na0() {
        if ((this instanceof TtsLynxFullscreenPlayerView) == true) goto L5;
        return;
    L5:
        Dialog r0 = getDialog();
        int r1 = WindowInsetsUtils.a;
        if (r0 == null) goto L11;
        Window r2 = r0.getWindow();
        if (r2 == null) goto L11;
        WindowInsetsUtils.h(r2, WindowInsetsUtils.a(r0));
    L11:
        Dialog r3 = getDialog();
        if (r3 == null) goto L16;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L16;
        View r5 = r4.findViewById(2131367728);
    L17:
        if (r5 == null) goto L19;
        OneShotPreDrawListener.add(r5, new d(r5, r5, this));
    L19:
        Dialog r6 = getDialog();
        if (r6 == null) goto L31;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L32;
        da0(r7).setSystemUiVisibility(1280);
        r7.addFlags(ShareItemModel.SRC_TINT_UNDEFINED);
        if (Build.VERSION.SDK_INT < 23) goto L33;
        WindowInsetsControllerCompat r8 = WindowCompat.getInsetsController(r7, da0(r7));
        if (r8 == null) goto L28;
        r8.setAppearanceLightStatusBars(BaseAntiScreenshotsSheetDialogFragment.a.a(this.n));
    L28:
        if (r8 == null) goto L34;
        r8.setAppearanceLightNavigationBars(BaseAntiScreenshotsSheetDialogFragment.a.a(this.n));
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
        r5 = null;
        goto L17
    }

    private final void la0() {
        View r0 = getView();
        if (r0 == null) goto L6;
        tt5.a.h(this.k, "resetBackgroundColor, color: " + this.n);
        r0.setBackground(this.o);
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final void dismissAllowingStateLoss() {
        super.dismissAllowingStateLoss();     // Catch: Exception -> L4 Throwable -> L9
    L12:
        return;
    L9:
        th = move-exception;
        tt5.a.e(this.k, "dismissAllowingStateLoss error,", th, false);
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L9
        Throwable r0 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L9
        if (r0 == null) goto L12;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L9
        goto L12
    }

    public int ea0() {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        r0 = LarkContext.getApplication();
    L5:
        int r1 = DeviceUtils.getRealScreenHeight(r0);
        tt5.a.h(this.k, "calculateHeightPx, screenHeight: " + r1);
        Integer r2 = Integer.valueOf(ia0());
        int r3 = r2.intValue();
        tt5.a.h(this.k, "calculateHeightPx, getMinHeightPx: " + r3);
        boolean r4 = true;
        if (r2.intValue() <= 0) goto L8;
        boolean r5 = true;
    L9:
        Integer r6 = null;
        if (r5 == true) goto L14;
        r2 = null;
    L14:
        if (r2 == null) goto L16;
    L15:
        int r7 = r2.intValue();
    L29:
        Integer r8 = 0;
        int r9 = r8.intValue();
        tt5.a.h(this.k, "calculateHeightPx, getMaxHeightPx: " + r9);
        if (r8.intValue() <= 0) goto L32;
        boolean r10 = true;
    L33:
        if (r10 == true) goto L36;
        r8 = null;
    L36:
        if (r8 == null) goto L38;
        int r11 = r8.intValue();
    L51:
        Integer r12 = Integer.valueOf(RangesKt.coerceIn(r11, 0, r1));
        if (r12.intValue() > RangesKt.coerceIn(r7, 0, r1)) goto L55;
        r4 = false;
    L55:
        if (r4 == false) goto L57;
        r6 = r12;
    L57:
        if (r6 == null) goto L59;
        r7 = r6.intValue();
    L59:
        tt5.a.h(this.k, "calculateHeightPx, targetHeightPx: " + r7);
        return r7;
    L38:
        Float r13 = Float.valueOf(ha0());
        float r14 = r13.floatValue();
        tt5.a.h(this.k, "calculateHeightPx, getMaxHeightRate: " + r14);
        if (r13.floatValue() <= 0.0f) goto L41;
        boolean r16 = true;
    L42:
        if (r16 == true) goto L45;
        r13 = null;
    L45:
        if (r13 == null) goto L47;
        Integer r17 = Integer.valueOf(RangesKt.coerceAtMost((int) (r13.floatValue() * r1), r1));
    L48:
        if (r17 == null) goto L50;
        r11 = r17.intValue();
        goto L51
    L50:
        r11 = r1;
        goto L51
    L47:
        r17 = null;
        goto L48
    L41:
        r16 = false;
        goto L42
    L32:
        r10 = false;
        goto L33
    L16:
        Float r18 = Float.valueOf(0.0f);
        float r19 = r18.floatValue();
        tt5.a.h(this.k, "calculateHeightPx, getMinHeightRate: " + r19);
        if (r18.floatValue() <= 0.0f) goto L19;
        boolean r20 = true;
    L20:
        if (r20 == true) goto L23;
        r18 = null;
    L23:
        if (r18 == null) goto L25;
        r2 = Integer.valueOf((int) (r18.floatValue() * r1));
    L26:
        if (r2 != null) goto L15;
        r7 = 0;
        goto L29
    L25:
        r2 = null;
        goto L26
    L19:
        r20 = false;
        goto L20
    L8:
        r5 = false;
        goto L9
    }

    public final FrameLayout fa0() {
        View r0 = getView();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (FrameLayout) r0.findViewById(2131372645);
    }

    public final void oa0() {
        View r0 = getView();
        TextView r1 = null;
        if (r0 == null) goto L5;
        LinearLayout r2 = (LinearLayout) r0.findViewById(2131378593);
    L6:
        if (r2 == null) goto L8;
        r1 = (TextView) r2.findViewById(2131390084);
    L8:
        if (r1 == null) goto L10;
        r1.setText(this.r);
    L10:
        if (r2 == null) goto L22;
        CharSequence r3 = this.r;
        int r4 = 0;
        if (r3 != null) goto L14;
    L17:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L20;
        r4 = 8;
    L20:
        r2.setVisibility(r4);
        return;
    L14:
        if (r3.length() == 0) goto L17;
        r5 = false;
        goto L18
    L22:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment
    public void onDestroy() {
        super.onDestroy();
        tt5.a.h(this.k, "onDestroy");
        View r0 = getView();
        if (r0 == null) goto L6;
        r0.removeCallbacks(this.m);
        return;
    }

    public void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        tt5.a.h(this.k, "onDestroyView");
        View r0 = getView();
        if (r0 == null) goto L6;
        r0.removeCallbacks(this.m);
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment
    public void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        tt5.a.h(this.k, "onStart");
        na0();
        la0();
        ma0();
        oa0();
        int r0 = ea0();
        tt5.a.h(this.k, "resizeDialogFragment, targetHeightPx: " + r0);
        Dialog r1 = getDialog();
        if (r1 == null) goto L16;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L16;
        if (ja0() == false) goto L9;
        WindowManager.LayoutParams r3 = r2.getAttributes();
        r3.height = r0;
        r2.setAttributes(r3);
        r2.setGravity(80);
        da0(r2).requestLayout();
    L17:
        View r4 = getView();
        if (r4 == null) goto L20;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        r5.height = r0;
        r4.setLayoutParams(r5);
        return;
    L20:
        tt5.a.d(this.k, "resizeDialogFragment, rootView is null.");
        return;
    L9:
        View r6 = r2.findViewById(2131367947);
        if (r6 == null) goto L12;
        r6.setFitsSystemWindows(false);
    L12:
        View r7 = r2.findViewById(2131367728);
        if (r7 == null) goto L15;
        r7.setFitsSystemWindows(false);
    L15:
        r2.setGravity(80);
    L16:
        tt5.a.d(this.k, "resizeDialogFragment, dialogWindow is null.");
        goto L17
    }

    public BaseUDBottomSheetDialogFragment(String r2) {
        Intrinsics.checkNotNullParameter(r2, "logTag");
        this.k = r2;
        this.l = LazyKt.lazy(BaseUDBottomSheetDialogFragment$stateListenerSet$2.INSTANCE);
        this.m = new c(this);
        GradientDrawable r3 = new GradientDrawable();
        r3.setShape(0);
        r3.setColor(0);
        this.o = r3;
        this.p = true;
        this.q = true;
        this.s = LazyKt.lazy(BaseUDBottomSheetDialogFragment$insetsBgDrawable$2.INSTANCE);
    }

    public static View da0(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void ka0(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((Set) this.l.getValue()).remove(r2);
    }

    public void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onCancel(r2);
        tt5.a.h(this.k, "onCancel");
        Iterator r3 = ((Set) this.l.getValue()).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((b) r3.next()).a(this);
        goto L4
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.CompatLandscapeBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment
    public final Dialog onCreateDialog(Bundle r1) {
        Dialog r2 = super.onCreateDialog(r1);
        ma0();
        return r2;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment
    public void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L9
        super.onDismiss(r2);     // Catch: Throwable -> L9
        tt5.a.h(this.k, "onDismiss");     // Catch: Throwable -> L9
        Iterator r3 = ((Set) this.l.getValue()).iterator();     // Catch: Throwable -> L9
    L4:
        if (r3.hasNext() == false) goto L7;
        ((b) r3.next()).a(this);     // Catch: Throwable -> L9
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

    public final void pa0(int r2) {
        this.n = r2;
        this.o.setColor(r2);
        na0();
        la0();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        tt5.a.h(this.k, "onViewCreated");
        View r4 = getView();
        if (r4 == null) goto L6;
        r4.post(this.m);
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        tt5.a.h(this.k, "onCreateView");
        return r2.inflate(2131563287, r3, false);
    }
}
