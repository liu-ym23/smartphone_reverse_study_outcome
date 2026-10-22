package com.larus.drive.sdk.impl.view.chat;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import androidx.collection.LruCache;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.drive.sdk.impl.view.common.TouchInterceptFrameLayout;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 D2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010#\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010-\u001a\u00020\u0019H\u0016J\u000e\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u000bJ\u000e\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u000bJ\b\u00102\u001a\u00020\u0019H\u0002J\b\u00103\u001a\u00020\u0019H\u0002J\b\u00104\u001a\u00020\u0019H\u0002J\b\u00105\u001a\u00020\u0019H\u0002J\u001a\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u000b2\b\b\u0002\u00108\u001a\u00020\u000bH\u0002J\b\u00109\u001a\u00020\u0011H\u0002J\b\u0010:\u001a\u00020\u0019H\u0002J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0011H\u0002J\b\u0010>\u001a\u00020\u000bH\u0002J\b\u0010?\u001a\u00020\u0011H\u0002J\u0010\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u0011H\u0002J\b\u0010B\u001a\u00020\u0011H\u0002J\b\u0010C\u001a\u00020\u0011H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0016\u001a\u0004\b \u0010!¨\u0006E"}, d2 = {"Lcom/larus/drive/sdk/impl/view/chat/DriveInputFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "driveInputContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "rootView", "Landroid/view/View;", "interceptorView", "contentView", "inputDisabled", "", "windowManager", "Landroid/view/WindowManager;", "globalListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "preHeight", "", "originBottomMargin", "getOriginBottomMargin", "()I", "originBottomMargin$delegate", "Lkotlin/Lazy;", "updateInterceptRunnable", "Lkotlin/Function0;", "", "driveInputAbility", "Lcom/larus/drive/sdk/api/ability/IDriveGalleryInputAbility;", "getDriveInputAbility", "()Lcom/larus/drive/sdk/api/ability/IDriveGalleryInputAbility;", "driveInputAbility$delegate", "shouldSubtractHostConsumedBottomInset", "getShouldSubtractHostConsumedBottomInset", "()Z", "shouldSubtractHostConsumedBottomInset$delegate", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "changeInputVisible", "visible", "setInputEnabled", "enabled", "attachComponents", "watchOnImeStatus", "watchOnInsetsAnimation", "watchOnGlobalLayout", "updateInterceptorView", "isImeShow", "needSetExternalImeFunc", "getInterceptorTopOffset", "removeImeInterceptView", "getLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "h", "isImeVisible", "resolveCurrentImePaddingBottom", "resolveImePaddingBottom", "rawImeBottomInset", "resolveHostConsumedBottomInset", "getDecorViewInvisibleHeight", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveInputFragment extends Fragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f342066o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TouchInterceptFrameLayout f342067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f342068e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f342069f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f342070g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WindowManager f342071h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public p f342072i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f342073j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f342074k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a0 f342075l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f342076m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f342077n;

    public static final class a {
    }

    static {
    }

    public final void V90() {
        View r100 = this.f342068e;
        Unit r101 = null;
        if (r100 == null) goto L5;
        ViewParent r102 = r100.getParent();
    L7:
        if (r102 != null) goto L21;
        FLogger.f375446a.i("DriveGalleryInputFragment", "DriveInput interceptorView no parent");
        return;
    L21:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L15
        WindowManager r104 = this.f342071h;     // Catch: Throwable -> L15
        if (r104 == null) goto L13;
        r104.removeViewImmediate(this.f342068e);     // Catch: Throwable -> L15
        r101 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Object r105 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L15
    L17:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L23;
        FLogger.f375446a.e("DriveGalleryInputFragment", "RemoveWindowView failed throwable=" + r106 + ", message=" + r106.getMessage());
        return;
    L23:
        return;
    L15:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L5:
        r102 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.drive.sdk.impl.view.chat.a0] */
    public DriveInputFragment() {
        this.f342074k = LazyKt.lazy(new z(this));
        this.f342075l = new a0(this);
        this.f342076m = LazyKt.lazy(new b0(this));
        this.f342077n = LazyKt.lazy(new c0(this));
    }

    public final int T90() {
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L11;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L13;
        View r102 = S90(r101);
        if (r102 == null) goto L14;
        Rect r103 = new Rect();
        r102.getWindowVisibleDisplayFrame(r103);
        return RangesKt.coerceAtLeast(Math.abs(r102.getBottom() - r103.bottom), ((Number) this.f342074k.getValue()).intValue());
    L14:
        return 0;
    L13:
        return 0;
    L11:
        return 0;
    }

    public final boolean U90() {
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L12;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L12;
        View r102 = S90(r101);
        if (r102 == null) goto L12;
        Rect r103 = new Rect();
        r102.getWindowVisibleDisplayFrame(r103);
        int r104 = r102.getHeight();
        if ((r104 - r103.height()) <= (((double) r104) * 0.15d)) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        V90();
        View r100 = this.f342069f;
        if (r100 == null) goto L7;
        ViewTreeObserver r101 = r100.getViewTreeObserver();
        if (r101 == null) goto L7;
        r101.removeOnGlobalLayoutListener(this.f342072i);
    L7:
        TouchInterceptFrameLayout r102 = this.f342067d;
        if (r102 == null) goto L11;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        ViewCompat.setWindowInsetsAnimationCallback(r102, null);
        return;
    }

    public static View S90(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final int W90(int r100) {
        if (((Boolean) this.f342077n.getValue()).booleanValue() == false) goto L29;
        TouchInterceptFrameLayout r101 = this.f342067d;
        if (r101 == null) goto L26;
        Integer r102 = Integer.valueOf(r101.getHeight());
        if (r102.intValue() <= 0) goto L10;
        boolean r103 = true;
    L11:
        Integer r104 = null;
        if (r103 == true) goto L15;
        r102 = null;
    L15:
        if (r102 == null) goto L17;
        int r105 = r102.intValue();
    L25:
        int[] r106 = new int[2];
        r101.getLocationOnScreen(r106);
        int r107 = r106[1] + r105;
        int r108 = m0.f375450a;
        int r109 = RangesKt.coerceAtLeast(m0.a(getContext()) - r107, 0);
    L27:
        r100 = RangesKt.coerceAtLeast(r100 - r109, 0);
        goto L29
    L17:
        Integer r110 = Integer.valueOf(r101.getMeasuredHeight());
        if (r110.intValue() <= 0) goto L20;
        boolean r111 = true;
    L21:
        if (r111 == false) goto L23;
        r104 = r110;
    L23:
        if (r104 == null) goto L26;
        r105 = r104.intValue();
        goto L25
    L20:
        r111 = false;
        goto L21
    L10:
        r103 = false;
    L26:
        r109 = 0;
    L29:
        return RangesKt.coerceAtLeast(r100, ((Number) this.f342074k.getValue()).intValue());
    }

    public final void X90(boolean r100) {
        boolean r101 = !r100;
        if (this.f342070g != r101) goto L5;
        return;
    L5:
        TouchInterceptFrameLayout r102 = this.f342067d;
        if (r102 != null) goto L8;
        return;
    L8:
        this.f342070g = r101;
        if (r101 == false) goto L11;
        float r103 = 0.5f;
    L12:
        r102.setAlpha(r103);
        if (r101 == false) goto L17;
        r79.c r104 = (r79.c) this.f342076m.getValue();
        if (r104 == null) goto L17;
        r104.g();
    L17:
        r102.setInterceptAllTouch(r101);
        return;
    L11:
        r103 = 1.0f;
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r210) {
        super.onCreate(r210);
        Bundle r100 = getArguments();
        if (r100 != null) goto L5;
        r100 = com.larus.utils.f.c(new Pair[0]);
    L5:
        Bundle r101 = new Bundle(r100);
        r101.remove("arg_subtract_host_consumed_bottom_inset");
        t1a.b r102 = s1a.a.g(this);
        LruCache<String, wc9.e> r103 = ko8.a.f504531a;
        RecommendFrom r104 = null;
        SearchMobParam r105 = null;
        String r106 = null;
        String r211 = null;
        r102.n(new de8.c(r101, r101, false, r104, r105, false, r106, r211, null, null, false, false, null, ko8.a.g(), 24572), de8.c.class);
        ChatParam r107 = new ChatParam(null, null, null, null, null, 255);
        r107.f296892d = "ai_space_detail";
        r107.f296889a = "";
        r107.f296890b = com.larus.drive.sdk.impl.utils.n.f();
        s1a.a.g(this).n(r107, ChatParam.class);
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_ONLY);
        k1a.b.a(this, new v(this));
    }

    public final void Y90(boolean r100, boolean r101) {
        if (r100 == false) goto L71;
        Unit r102 = null;
        if (this.f342068e != null) goto L19;
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L9;
        Object r104 = r103.getSystemService(LiveEndPageData.TAG_WINDOW);
    L11:
        if ((r104 instanceof WindowManager) == false) goto L13;
        WindowManager r105 = (WindowManager) r104;
    L14:
        this.f342071h = r105;
        View r106 = new View(getContext());
        e1.d(r106, new d0(this));
        this.f342068e = r106;
        if (r101 == false) goto L19;
        r79.c r107 = (r79.c) this.f342076m.getValue();
        if (r107 == null) goto L19;
        r107.i1(new q(this));
        goto L19
    L13:
        r105 = null;
        goto L14
    L9:
        r104 = null;
    L19:
        View r108 = this.f342068e;
        boolean r109 = true;
        if (r108 == null) goto L22;
        r108.setClickable(true);
    L22:
        View r110 = this.f342068e;
        if (r110 == null) goto L25;
        ViewParent r111 = r110.getParent();
    L26:
        if (r111 == null) goto L76;
        V90();
    L76:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L65
        TouchInterceptFrameLayout r113 = this.f342067d;     // Catch: Throwable -> L65
        if (r113 == null) goto L38;
        Integer r114 = Integer.valueOf(r113.getHeight());     // Catch: Throwable -> L65
        if (r114.intValue() <= 0) goto L33;
        boolean r115 = true;
    L34:
        if (r115 == true) goto L37;
        r114 = null;
    L37:
        if (r114 == null) goto L38;
    L42:
        if (r114 != null) goto L44;
    L52:
        TouchInterceptFrameLayout r116 = this.f342067d;     // Catch: Throwable -> L65
        if (r116 == null) goto L55;
        int r117 = r116.getPaddingBottom();     // Catch: Throwable -> L65
    L56:
        int r118 = m0.f375450a;     // Catch: Throwable -> L65
        int r119 = m0.a(getContext()) - r117;     // Catch: Throwable -> L65
        if (Build.VERSION.SDK_INT >= 30) goto L59;
        int r120 = 0;
    L60:
        int r121 = r119 - r120;     // Catch: Throwable -> L65
        WindowManager r122 = this.f342071h;     // Catch: Throwable -> L65
        if (r122 == null) goto L63;
        View r123 = this.f342068e;     // Catch: Throwable -> L65
        int r124 = RangesKt.coerceAtLeast(r121, 0);     // Catch: Throwable -> L65
        WindowManager.LayoutParams r125 = new WindowManager.LayoutParams();     // Catch: Throwable -> L65
        r125.type = 2;     // Catch: Throwable -> L65
        r125.flags = 552;     // Catch: Throwable -> L65
        r125.format = -2;     // Catch: Throwable -> L65
        r125.gravity = 8388659;     // Catch: Throwable -> L65
        r125.width = -1;     // Catch: Throwable -> L65
        r125.height = r124;     // Catch: Throwable -> L65
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r123, r125);     // Catch: Throwable -> L65
        r122.addView(r123, r125);     // Catch: Throwable -> L65
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L65
    L63:
        Object r126 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L65
    L67:
        Throwable r127 = Result.m9452exceptionOrNullimpl(r126);
        if (r127 == null) goto L70;
        FLogger.f375446a.e("DriveGalleryInputFragment", "AddWindowView failed throwable=" + r127 + ", message=" + r127.getMessage());
    L70:
        Result.m9448boximpl(r126);
        return;
    L59:
        i0.f375410a.getClass();     // Catch: Throwable -> L65
        r120 = i0.g();     // Catch: Throwable -> L65
        goto L60
    L55:
        r117 = 0;
        goto L56
    L44:
        if (r114.intValue() > 0) goto L47;
        r109 = false;
    L47:
        if (r109 == true) goto L50;
        r114 = null;
    L50:
        if (r114 == null) goto L52;
        r117 = r114.intValue();     // Catch: Throwable -> L65
        goto L56
    L33:
        r115 = false;
    L38:
        TouchInterceptFrameLayout r128 = this.f342067d;     // Catch: Throwable -> L65
        if (r128 == null) goto L41;
        r114 = Integer.valueOf(r128.getMeasuredHeight());     // Catch: Throwable -> L65
        goto L42
    L41:
        r114 = null;
    L65:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L67
    L25:
        r111 = null;
        goto L26
    L71:
        View r130 = this.f342068e;
        if (r130 == null) goto L74;
        r130.setClickable(false);
    L74:
        V90();
    }

    /* JADX WARN: Type inference failed for: r8v7, types: [com.larus.drive.sdk.impl.view.chat.p] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        TouchInterceptFrameLayout r102 = this.f342067d;
        if (r102 == null) goto L6;
        r102.setPadding(0, 0, 0, ((Number) this.f342074k.getValue()).intValue());
    L6:
        if (Build.VERSION.SDK_INT < 30) goto L10;
        FLogger.f375446a.i("DriveGalleryInputFragment", "[Ime Status] watchOnInsetsAnimation");
        TouchInterceptFrameLayout r103 = this.f342067d;
        if (r103 == null) goto L30;
        ViewExtKt.l(r103, new w(), null, new x(this), new y(this), 2);
        return;
    L30:
        return;
    L10:
        FLogger.f375446a.i("DriveGalleryInputFragment", "[Ime Status] watchOnGlobalLayout");
        FragmentActivity r104 = getActivity();
        if (r104 == null) goto L36;
        Window r105 = r104.getWindow();
        if (r105 == null) goto L32;
        WindowManager.LayoutParams r106 = r105.getAttributes();
        if (r106 != null) goto L18;
        return;
    L18:
        if ((r106.flags & 512) != 0) goto L24;
        FragmentActivity r107 = getActivity();
        if (r107 == null) goto L24;
        Window r108 = r107.getWindow();
        if (r108 == null) goto L24;
        r108.clearFlags(512);
    L24:
        this.f342069f = r104.findViewById(R.id.content);
        this.f342073j = T90();
        this.f342072i = new p(this);
        View r109 = this.f342069f;
        if (r109 == null) goto L34;
        ViewTreeObserver r110 = r109.getViewTreeObserver();
        if (r110 == null) goto L35;
        r110.addOnGlobalLayoutListener(this.f342072i);
        return;
    L35:
        return;
    L34:
        return;
    L32:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(com.larus.nova.R.layout.larus_layout_gallery_input_view, r101, false);
        ViewStub r104 = (ViewStub) r103.findViewById(com.larus.nova.R.id.input_delegate);
        InputViewCreatorDelegate r105 = InputViewCreatorDelegate.f298409b;
        Intrinsics.checkNotNull(r104);
        r105.a(r104, Integer.valueOf(com.larus.nova.R.id.input_delegate));
        TouchInterceptFrameLayout r106 = new TouchInterceptFrameLayout(r100.getContext(), null, 6, 0);
        ViewGroup.LayoutParams r107 = r103.getLayoutParams();
        if (r107 == null) goto L5;
        r106.setLayoutParams(r107);
    L5:
        r106.addView(r103, new ViewGroup.LayoutParams(-1, -2));
        this.f342067d = r106;
        return r106;
    }
}
