package com.larus.bmhome.chat.component.util;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import ce8.e;
import ce8.f;
import ce8.g;
import ce8.h;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.chat.ChatBubbleParams;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.WeakHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import t1a.b;
import va8.m;

/* JADX INFO: loaded from: classes25.dex */
public final class PaneAwareBottomSheetController {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final WeakHashMap<View, Boolean> f301858d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BottomSheetDialogFragment f301859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f301860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PaneAwareBottomSheetController$lifecycleObserver$1 f301861c;

    public static final class a {
        public static void b(View r100) {
            if (r100.getFitsSystemWindows() == false) goto L6;
            r100.setFitsSystemWindows(false);
        L6:
            if (r100.getPaddingLeft() == 0) goto L8;
        L13:
            r100.setPadding(0, 0, 0, 0);
            return;
        L8:
            if (r100.getPaddingTop() != 0) goto L13;
            if (r100.getPaddingRight() != 0) goto L13;
            if (r100.getPaddingBottom() != 0) goto L13;
        }

        public static WindowInsetsCompat a(View r100, WindowInsetsCompat r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "insets");
            WeakHashMap<View, Boolean> r102 = PaneAwareBottomSheetController.f301858d;
            b(r100);
            WindowInsetsCompat.Builder r103 = new WindowInsetsCompat.Builder(r101);
            int r104 = WindowInsetsCompat.Type.navigationBars();
            Insets r105 = Insets.NONE;
            return r103.setInsets(r104, r105).setInsets(WindowInsetsCompat.Type.statusBars(), r105).build();
        }

        public static Pair c(View r100, View r101) {
            Intrinsics.checkNotNullParameter(r100, "pane");
            Intrinsics.checkNotNullParameter(r101, "rootView");
            int r102 = 0;
            int r103 = 0;
        L3:
            if (r100 == r101) goto L11;
            r102 = r102 + (r100.getLeft() - r100.getScrollX());
            r103 = r103 + (r100.getTop() - r100.getScrollY());
            Object r104 = r100.getParent();
            if ((r104 instanceof View) == false) goto L7;
            r100 = (View) r104;
        L8:
            if (r100 != null) goto L3;
            return null;
        L7:
            r100 = null;
            goto L8
        L11:
            return TuplesKt.to(Integer.valueOf(r102), Integer.valueOf(r103));
        }
    }

    static {
        f301858d = new WeakHashMap();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.bmhome.chat.component.util.PaneAwareBottomSheetController$createDialog$1] */
    public final PaneAwareBottomSheetController$createDialog$1 b() {
        final Context r100 = this.f301859a.requireContext();
        final int r101 = this.f301859a.getTheme();
        return new PaneAwareBottomSheetController$createDialog$1(this, r100, r101);
    }

    public final boolean c() {
        Fragment r100 = this.f301859a.getParentFragment();
        xe8.a r101 = null;
        if (r100 == null) goto L9;
        b r102 = s1a.a.g(r100);
        if (r102 == null) goto L9;
        m r103 = (m) r102.getAbility(m.class);
        if (r103 == null) goto L9;
        Fragment r104 = r103.getChatFragment();
    L11:
        if ((r104 instanceof xe8.a) == false) goto L14;
        r101 = (xe8.a) r104;
    L14:
        if (r101 == null) goto L21;
        ChatBubbleParams r105 = r101.Mz();
        if (r105 != null) goto L18;
        return false;
    L18:
        if (r105.f296840a != true) goto L23;
        return true;
    L23:
        return false;
    L21:
        return false;
    L9:
        r104 = null;
        goto L11
    }

    public final void e() {
        this.f301859a.getLifecycle().removeObserver(this.f301861c);
        View r100 = this.f301860b;
        if (r100 == null) goto L13;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L8;
        ViewGroup r102 = (ViewGroup) r101;
    L9:
        if (r102 == null) goto L11;
        r102.removeView(r100);
    L11:
        this.f301860b = null;
        return;
    L8:
        r102 = null;
        goto L9
    }

    public final void d() {
        if (c() == true) goto L6;
        return;
    L6:
        if (this.f301860b != null) goto L42;
        FragmentActivity r100 = this.f301859a.getActivity();
        View r101 = null;
        if (r100 == null) goto L17;
        Window r102 = r100.getWindow();
        if (r102 == null) goto L17;
        View r103 = r102.getDecorView();
        if (c.f346345e == false) goto L19;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == c.f346341a) goto L19;
        c.a(r104, "getDecorView");
    L19:
        if ((r103 instanceof ViewGroup) == false) goto L21;
        ViewGroup r105 = (ViewGroup) r103;
    L22:
        if (r105 != null) goto L24;
        FLogger.f375446a.w("PaneAwareBSC", "attachMask skip: activity or decorView unavailable");
        goto L42
    L24:
        final View r106 = new View(r105.getContext());
        r106.setBackgroundColor(1711276032);
        r106.setOnClickListener(new h(r106, this));
        Fragment r107 = this.f301859a.getParentFragment();
        if (r107 == null) goto L27;
        View r108 = r107.getView();
    L28:
        if (r108 == null) goto L30;
        r101 = r108.getRootView();
    L30:
        int r109 = 0;
        if (r108 == null) goto L40;
        if (r101 == null) goto L40;
        if (r108.getWidth() <= 0) goto L40;
        if (r101.getWidth() <= 0) goto L40;
        Pair r110 = a.c(r108, r101);
        if (r110 == null) goto L40;
        int r111 = RangesKt.coerceAtLeast(((Number) r110.getFirst()).intValue(), 0);
        r109 = r108.getWidth();
        int r112 = r111;
    L41:
        FrameLayout.LayoutParams r113 = new FrameLayout.LayoutParams(r109, -1);
        r113.gravity = 8388659;
        r113.leftMargin = r112;
        r105.addView(r106, r113);
        this.f301860b = r106;
        this.f301859a.getLifecycle().addObserver(this.f301861c);
        FLogger.f375446a.d("PaneAwareBSC", "maskAttach: initLeft=" + r112 + ", initWidth=" + r109);
    L40:
        r112 = 0;
        goto L41
    L27:
        r108 = null;
        goto L28
    L21:
        r105 = null;
    L17:
        r103 = null;
    L42:
        Dialog r114 = this.f301859a.getDialog();
        if (r114 == null) goto L62;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L53
        View r116 = r114.findViewById(R.id.design_bottom_sheet);     // Catch: Throwable -> L53
        if (r116 != null) goto L48;
        FLogger.f375446a.w("PaneAwareBSC", "ensureExpanded: design_bottom_sheet not found");     // Catch: Throwable -> L53
    L51:
        Object r117 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L53
    L55:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L61;
        FLogger.f375446a.w("PaneAwareBSC", "ensureBottomSheetExpanded failed: " + r118);
        return;
    L61:
        return;
    L48:
        BottomSheetBehavior r119 = BottomSheetBehavior.from(r116);     // Catch: Throwable -> L53
        if (r119.getState() == 3) goto L51;
        r119.setSkipCollapsed(true);     // Catch: Throwable -> L53
        r119.setState(3);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L55
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.bmhome.chat.component.util.PaneAwareBottomSheetController$lifecycleObserver$1] */
    public PaneAwareBottomSheetController(BottomSheetDialogFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f301859a = r100;
        this.f301861c = new PaneAwareBottomSheetController$lifecycleObserver$1(this);
    }

    public final void a(Window r100) {
        Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
        if (c() == true) goto L5;
        return;
    L5:
        Fragment r101 = this.f301859a.getParentFragment();
        if (r101 == null) goto L8;
        View r102 = r101.getView();
    L9:
        if (r102 != null) goto L11;
        return;
    L11:
        int r103 = r102.getWidth();
        int r104 = r102.getHeight();
        if (r103 <= 0) goto L26;
        if (r104 <= 0) goto L27;
        View r105 = r102.getRootView();
        if (r105 != null) goto L18;
        return;
    L18:
        int r106 = r105.getHeight();
        if (r106 > 0) goto L21;
        return;
    L21:
        Pair r107 = a.c(r102, r105);
        if (r107 != null) goto L24;
        return;
    L24:
        int r108 = ((Number) r107.component1()).intValue();
        int r109 = ((Number) r107.component2()).intValue();
        int r110 = RangesKt.coerceAtLeast(r108, 0);
        int r111 = RangesKt.coerceAtLeast(r106 - (r109 + r104), 0);
        WindowManager.LayoutParams r112 = r100.getAttributes();
        r112.width = r103;
        r112.height = -2;
        r112.gravity = 8388691;
        r112.x = r110;
        r112.y = r111;
        r100.setAttributes(r112);
        FLogger.f375446a.d("PaneAwareBSC", "initialWindowApply: paneW=" + r103 + ", paneH=" + r104 + ", paneLeft=" + r110 + ", y=" + r111);
        return;
    L27:
        return;
    L26:
        return;
    L8:
        r102 = null;
        goto L9
    }

    public final View f(Context r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "content");
        if (c() == true) goto L5;
        return r101;
    L5:
        PaneAwareFrameLayout r102 = new PaneAwareFrameLayout(r100, null, 6, 0);
        r102.setPaneProvider(new e(this));
        r102.setWindowProvider(new f(this));
        r102.setMaskProvider(new g(this));
        r102.addView(r101, new FrameLayout.LayoutParams(-1, -2));
        return r102;
    }
}
