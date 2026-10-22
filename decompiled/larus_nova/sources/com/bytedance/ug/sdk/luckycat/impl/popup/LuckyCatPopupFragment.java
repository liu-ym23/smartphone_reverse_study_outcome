package com.bytedance.ug.sdk.luckycat.impl.popup;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ug.sdk.luckycat.impl.lynx.CloseType;
import com.bytedance.ug.sdk.luckycat.impl.lynx.LuckyCatContainerIDManager;
import com.bytedance.ug.sdk.luckycat.impl.lynx.m;
import com.bytedance.ug.sdk.luckycat.impl.popup.roundLayout.RoundFrameLayout;
import com.bytedance.ug.sdk.luckycat.impl.popup.utils.LuckyCatPopupConfig;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/popup/LuckyCatPopupFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/bytedance/ug/sdk/luckycat/impl/lynx/c;", "Landroid/content/DialogInterface$OnKeyListener;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
public final class LuckyCatPopupFragment extends DialogFragment implements com.bytedance.ug.sdk.luckycat.impl.lynx.c, DialogInterface.OnKeyListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RelativeLayout f271411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RoundFrameLayout f271412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LuckyCatPopupConfig f271413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f271414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f271415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.ug.sdk.luckycat.impl.lynx.a f271416i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.lynx.c
    public final boolean IC() {
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.lynx.c
    public final vi7.c Qw() {
        com.bytedance.ug.sdk.luckycat.impl.lynx.a r100 = this.f271416i;
        if (r100 == null) goto L5;
        r100.getClass();
        return null;
    L5:
        return null;
    }

    public final void T90() {
        RelativeLayout r100 = this.f271411d;
        if (r100 == null) goto L7;
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{r100.getAlpha(), 1.0f});
        r101.setDuration(200);
        r101.start();
        return;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.lynx.c
    public final String getContainerID() {
        com.bytedance.ug.sdk.luckycat.impl.lynx.a r100 = this.f271416i;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f271214b;
    }

    public LuckyCatPopupFragment() {
        this.f271413f = new LuckyCatPopupConfig();
        this.f271414g = "";
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.ug.sdk.luckycat.impl.lynx.a r100 = this.f271416i;
        if (r100 == null) goto L10;
        r100.getClass();
        m.c(r100);
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L11;
        Map<String, WeakReference<com.bytedance.ug.sdk.luckycat.impl.lynx.c>> r102 = LuckyCatContainerIDManager.f271169a;
        String r103 = r100.f271214b;
        LuckyCatContainerIDManager.f271169a.remove(r103);
        Map<String, Map<String, WeakReference<com.bytedance.ug.sdk.luckycat.impl.lynx.c>>> r104 = LuckyCatContainerIDManager.f271170b;
        LinkedHashMap r105 = (LinkedHashMap) r104;
        Map r106 = (Map) r105.get(r101.toString());
        if (r106 == null) goto L12;
        WeakReference r107 = (WeakReference) r106.remove(r103);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatDialogFragment", "onPageInvisible");
        com.bytedance.ug.sdk.luckycat.impl.lynx.a r100 = this.f271416i;
        if (r100 == null) goto L7;
        com.bytedance.ug.sdk.luckycat.impl.lynx.a.C3801a r101 = r100.f271218f;
        if (r101 == null) goto L7;
        r101.f();
    L7:
        com.bytedance.ug.sdk.luckycat.impl.lynx.a r102 = this.f271416i;
        if (r102 == null) goto L13;
        bk7.c r103 = r102.f271222j;
        if (r103 == null) goto L14;
        r103.onHide();
        return;
    L14:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatDialogFragment", "onPageVisible");
        Map<String, WeakReference<com.bytedance.ug.sdk.luckycat.impl.lynx.c>> r100 = LuckyCatContainerIDManager.f271169a;
        com.bytedance.ug.sdk.luckycat.impl.lynx.a r101 = this.f271416i;
        if (r101 == null) goto L7;
        com.bytedance.ug.sdk.luckycat.impl.lynx.a.C3801a r102 = r101.f271218f;
        if (r102 == null) goto L7;
        r102.g();
    L7:
        com.bytedance.ug.sdk.luckycat.impl.lynx.a r103 = this.f271416i;
        if (r103 == null) goto L13;
        bk7.c r104 = r103.f271222j;
        if (r104 == null) goto L14;
        r104.onShow();
        return;
    L14:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        LuckyCatPopupConfig r100 = this.f271413f;
        if (r100 == null) goto L5;
        String r101 = r100.getPopupEnterType();
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        T90();
    L9:
        if (r101 == null) goto L53;
        int r102 = r101.hashCode();
        if (r102 == (-1383228885)) goto L33;
        if (r102 == (-1364013995)) goto L30;
        if (r102 == 108511772) goto L19;
        return;
    L19:
        if (r101.equals("right") == false) goto L43;
        AnimatorSet r103 = new AnimatorSet();
        r103.setDuration(200);
        int r104 = W90(com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f());
        if (this.f271411d == null) goto L44;
        RoundFrameLayout r105 = this.f271412e;
        if (r105 == null) goto L45;
        List r106 = CollectionsKt.mutableListOf(new Animator[]{ObjectAnimator.ofFloat(r105, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r104, 0.0f})});
        RelativeLayout r107 = this.f271411d;
        if (r107 == null) goto L28;
        r106.add(ObjectAnimator.ofFloat(r107, "alpha", new float[]{r107.getAlpha(), 1.0f}));
        r103.playTogether(r106);
        r103.start();
        return;
    L28:
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    L45:
        return;
    L44:
        return;
    L43:
        return;
    L30:
        if (r101.equals("center") == false) goto L47;
        T90();
        return;
    L47:
        return;
    L33:
        if (r101.equals("bottom") == false) goto L49;
        AnimatorSet r108 = new AnimatorSet();
        r108.setDuration(200);
        int r109 = V90(getContext());
        if (this.f271411d == null) goto L50;
        RoundFrameLayout r110 = this.f271412e;
        if (r110 == null) goto L51;
        List r111 = CollectionsKt.mutableListOf(new Animator[]{ObjectAnimator.ofFloat(r110, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r109, 0.0f})});
        RelativeLayout r112 = this.f271411d;
        if (r112 == null) goto L42;
        r111.add(ObjectAnimator.ofFloat(r112, "alpha", new float[]{r112.getAlpha(), 1.0f}));
        r108.playTogether(r111);
        r108.start();
        return;
    L42:
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L53:
        return;
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.lynx.c
    public final String getCurrentUrl() {
        return this.f271415h;
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

    public static int W90(Context r100) {
        int[] r101 = X90(r100);     // Catch: Throwable -> L7
        if (r101 == null) goto L5;
        int r102 = r101[0];     // Catch: Throwable -> L7
    L12:
    L8:
        if (r102 <= 0) goto L10;
        return r102;
    L10:
        return com.bytedance.ug.sdk.luckycat.utils.h.b(r100);
    L5:
        r102 = com.bytedance.ug.sdk.luckycat.utils.h.b(r100);     // Catch: Throwable -> L7
    L7:
        r102 = com.bytedance.ug.sdk.luckycat.utils.h.b(r100);
        goto L8
    }

    public static int[] X90(Context r100) {
        if (r100 != null) goto L5;
        r100 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f();
    L5:
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L22
        if (r100 != null) goto L9;
        Intrinsics.throwNpe();     // Catch: Throwable -> L22
    L9:
        Object r103 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L22
        if ((r103 instanceof WindowManager) == true) goto L12;
        r103 = null;
    L12:
        WindowManager r104 = (WindowManager) r103;     // Catch: Throwable -> L22
        if (r104 == null) goto L15;
        Display r105 = r104.getDefaultDisplay();     // Catch: Throwable -> L22
    L17:
        if (r105 == null) goto L19;
        Point r106 = new Point();     // Catch: Throwable -> L22
        r105.getRealSize(r106);     // Catch: Throwable -> L22
        int[] r107 = {r106.x, r106.y};     // Catch: Throwable -> L22
    L20:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L22
    L24:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L28;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.b("LuckyCatDialogFragment", "getScreenSize failed! reason: " + r109.getMessage());
    L28:
        if (Result.m9455isFailureimpl(r108) == true) goto L32;
        r101 = r108;
    L32:
        return (int[]) r101;
    L19:
        Resources r110 = r100.getResources();     // Catch: Throwable -> L22
        DisplayMetrics r111 = WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics());     // Catch: Throwable -> L22
        r107 = new int[]{r111.widthPixels, r111.heightPixels};     // Catch: Throwable -> L22
        goto L20
    L15:
        r105 = null;
    L22:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    }

    public final void U90(Function0<Unit> r100) {
        RelativeLayout r101 = this.f271411d;
        if (r101 == null) goto L7;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, "alpha", new float[]{1.0f, 0.0f});
        r102.setDuration(200);
        r102.addListener(new b(r100));
        r102.start();
        return;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    }

    public final int V90(Context r100) {
        boolean r101 = true;
        if (r100 != null) goto L52;
        int r102 = 0;
    L12:
        if (r102 > 0) goto L14;
        return 0;
    L14:
        if (r100 != null) goto L17;
        r100 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f();
    L17:
        Object r103 = null;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L33
        if (r100 != null) goto L21;
        Intrinsics.throwNpe();     // Catch: Throwable -> L33
    L21:
        Resources r105 = r100.getApplicationContext().getResources();     // Catch: Throwable -> L33
        Integer r106 = Integer.valueOf(r105.getIdentifier("status_bar_height", "dimen", "android"));     // Catch: Throwable -> L33
        if (r106.intValue() > 0) goto L25;
        r101 = false;
    L25:
        if (r101 == true) goto L28;
        r106 = null;
    L28:
        if (r106 == null) goto L30;
        Integer r107 = Integer.valueOf(r105.getDimensionPixelSize(r106.intValue()));     // Catch: Throwable -> L33
    L31:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L33
    L35:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L39;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.b("LuckyCatDialogFragment", "getStatusBarHeight failed! reason: " + r109.getMessage());
    L39:
        if (Result.m9455isFailureimpl(r108) == true) goto L42;
        r103 = r108;
    L42:
        Integer r110 = (Integer) r103;
        if (r110 == null) goto L45;
        int r111 = r110.intValue();
    L46:
        if (r111 < r102) goto L48;
        return 0;
    L48:
        return r102;
    L45:
        r111 = 0;
        goto L46
    L30:
        r107 = null;
    L33:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L52:
        int[] r113 = X90(r100);     // Catch: Throwable -> L10
        if (r113 == null) goto L8;
        r102 = r113[1];     // Catch: Throwable -> L10
    L51:
        goto L12
    L8:
        r102 = com.bytedance.ug.sdk.luckycat.utils.h.a(getContext());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.getMessage();
        r102 = com.bytedance.ug.sdk.luckycat.utils.h.a(getContext());
        goto L12
    }

    public final void Y90(boolean r100) {
        JSONObject r101 = new JSONObject();
        r101.put("code", 1);
        JSONObject r102 = new JSONObject();
        r102.put("from", "lynx_popup");
        r101.putOpt("data", r102);
        r101.put("msg", "success");
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.lynx.c
    public final void Zf(CloseType r110) {
        Function0<Unit> r111 = new LuckyCatPopupFragment$close$1(this);
        LuckyCatPopupConfig r100 = this.f271413f;
        if (r100 == null) goto L5;
        String r101 = r100.getPopupExitType();
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        U90(r111);
    L9:
        if (r101 == null) goto L53;
        int r102 = r101.hashCode();
        if (r102 == (-1383228885)) goto L33;
        if (r102 == (-1364013995)) goto L30;
        if (r102 == 108511772) goto L19;
        return;
    L19:
        if (r101.equals("right") == false) goto L43;
        AnimatorSet r103 = new AnimatorSet();
        r103.addListener(new b(r111));
        r103.setDuration(200);
        if (this.f271411d != null) goto L23;
        return;
    L23:
        if (this.f271412e == null) goto L45;
        List r112 = CollectionsKt.mutableListOf(new Animator[]{ObjectAnimator.ofFloat(this.f271412e, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, W90(com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f())})});
        RelativeLayout r104 = this.f271411d;
        if (r104 == null) goto L28;
        r112.add(ObjectAnimator.ofFloat(r104, "alpha", new float[]{1.0f, 0.0f}));
        r103.playTogether(r112);
        r103.start();
        return;
    L28:
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    L45:
        return;
    L43:
        return;
    L30:
        if (r101.equals("center") == false) goto L47;
        U90(r111);
        return;
    L47:
        return;
    L33:
        if (r101.equals("bottom") == false) goto L49;
        AnimatorSet r105 = new AnimatorSet();
        r105.addListener(new b(r111));
        r105.setDuration(200);
        if (this.f271411d != null) goto L37;
        return;
    L37:
        if (this.f271412e == null) goto L51;
        List r113 = CollectionsKt.mutableListOf(new Animator[]{ObjectAnimator.ofFloat(this.f271412e, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, V90(getContext())})});
        RelativeLayout r106 = this.f271411d;
        if (r106 == null) goto L42;
        r113.add(ObjectAnimator.ofFloat(r106, "alpha", new float[]{1.0f, 0.0f}));
        r105.playTogether(r113);
        r105.start();
        return;
    L42:
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    L51:
        return;
    L49:
        return;
    L53:
        return;
    L5:
        r101 = null;
        goto L7
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L7;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        r102.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        Dialog r103 = getDialog();
        if (r103 == null) goto L12;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L12;
        r104.setLayout(-1, -1);
    L12:
        Dialog r105 = getDialog();
        if (r105 == null) goto L19;
        Window r106 = r105.getWindow();
        if (r106 == null) goto L19;
        View r107 = S90(r106);
        if (r107 == null) goto L19;
        r107.setPadding(0, 0, 0, 0);
    L19:
        Dialog r108 = getDialog();
        View r109 = null;
        if (r108 == null) goto L24;
        Window r110 = r108.getWindow();
        if (r110 == null) goto L24;
        WindowManager.LayoutParams r111 = r110.getAttributes();
    L26:
        if (Build.VERSION.SDK_INT < 28) goto L36;
        if (r111 == null) goto L29;
        r111.layoutInDisplayCutoutMode = 1;
    L29:
        Dialog r112 = getDialog();
        if (r112 == null) goto L34;
        Window r113 = r112.getWindow();
        if (r113 == null) goto L34;
        r109 = S90(r113);
    L34:
        if (r109 == null) goto L36;
        r109.setSystemUiVisibility(1280);
    L36:
        if (r111 == null) goto L38;
        r111.dimAmount = 0.0f;
    L38:
        Dialog r114 = getDialog();
        if (r114 == null) goto L42;
        r114.setOnKeyListener(this);
        return;
    L42:
        return;
    L24:
        r111 = null;
        goto L26
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        super.onAttach(r100);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (this.f271416i == null) goto L43;
        Bundle r101 = getArguments();
        String r102 = null;
        if (r101 == null) goto L19;
        Serializable r103 = r101.getSerializable("popup_config");
    L21:
        if ((r103 instanceof LuckyCatPopupConfig) == false) goto L23;
        this.f271413f = (LuckyCatPopupConfig) r103;
    L23:
        Bundle r104 = getArguments();
        if (r104 == null) goto L26;
        String r105 = r104.getString("schema", "");
    L27:
        this.f271414g = r105;
        Bundle r106 = getArguments();
        if (r106 == null) goto L30;
        r102 = r106.getString("url", "");
    L30:
        this.f271415h = r102;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatDialogFragment", "initData : schema = " + this.f271414g + ", url = " + this.f271415h);
        if (TextUtils.isEmpty(this.f271414g) == false) goto L33;
    L34:
        com.bytedance.ug.sdk.luckycat.impl.lynx.a r107 = this.f271416i;
        if (r107 == null) goto L38;
        r107.Zf(CloseType.CLOSE_BY_ERROR);
    L38:
        if (this.f271413f.isUseDialogFullScreenStyle() == false) goto L45;
        setStyle(0, R.style.Theme.Black.NoTitleBar.Fullscreen);
        return;
    L45:
        return;
    L33:
        if (TextUtils.isEmpty(this.f271415h) == false) goto L38;
    L26:
        r105 = null;
        goto L27
    L19:
        r103 = null;
        goto L21
    L43:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L13
        dismissAllowingStateLoss();     // Catch: Exception -> L7 Throwable -> L13
    L11:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        com.bytedance.ug.sdk.luckycat.impl.utils.a.b("LuckyCatDialogFragment", "close dismissAllowingStateLoss when fakeLynxPopupContainer is null");
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_popup_recovery", new JSONObject(), true);
        goto L38
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r109 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r109 == null) goto L11;
        com.bytedance.crash.d.d(r109, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        if (r101 == null) goto L7;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        r102.requestFeature(1);
    L7:
        return r101;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        super.onCreateView(r110, r111, r112);
        int r113 = 0;
        View r114 = r110.inflate(com.larus.nova.R.layout.luckycat_popup_frame_layout, r111, false);
        RoundFrameLayout r100 = null;
        if ((r114 instanceof RelativeLayout) == true) goto L5;
        r114 = null;
    L5:
        RelativeLayout r115 = (RelativeLayout) r114;
        this.f271411d = r115;
        if (r115 == null) goto L8;
        RoundFrameLayout r116 = (RoundFrameLayout) r115.findViewById(com.larus.nova.R.id.popup_content);
    L10:
        if ((r116 instanceof RoundFrameLayout) == true) goto L12;
        r116 = null;
    L12:
        this.f271412e = r116;
        FrameLayout.LayoutParams r117 = new FrameLayout.LayoutParams(W90(getContext()), V90(getContext()));
        RelativeLayout r118 = this.f271411d;
        if (r118 == null) goto L15;
        r118.setLayoutParams(r117);
    L15:
        Context r119 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f();
        if (r119 == null) goto L72;
        int r120 = W90(r119);
        int r101 = V90(r119);
        if (r120 > 0) goto L21;
        if (r101 > 0) goto L21;
        Pair r121 = new Pair(0, 0);
    L73:
        int r122 = ((Number) r121.getFirst()).intValue();
        int r123 = ((Number) r121.getSecond()).intValue();
        int r102 = this.f271413f.getRadius();
        if (r102 > 0) goto L76;
        r102 = 0;
    L79:
        RoundFrameLayout r103 = this.f271412e;
        if (r103 == null) goto L83;
        r103.f271424a.a(r102, this.f271413f.getPopupEnterType());
    L83:
        if (this.f271413f.getCloseByMask() == false) goto L87;
        RelativeLayout r104 = this.f271411d;
        if (r104 == null) goto L87;
        r104.setOnClickListener(new d(this));
    L87:
        RelativeLayout.LayoutParams r105 = new RelativeLayout.LayoutParams(r122, r123);
        String r124 = this.f271413f.getPopupEnterType();
        if (r124 == null) goto L101;
        int r106 = r124.hashCode();
        if (r106 == (-1383228885)) goto L99;
        if (r106 != 108511772) goto L101;
        if (r124.equals("right") == false) goto L101;
        r105.addRule(11);
        r105.addRule(13);
    L102:
        RoundFrameLayout r125 = this.f271412e;
        if (r125 == null) goto L105;
        r125.setLayoutParams(r105);
    L105:
        RoundFrameLayout r126 = this.f271412e;
        if ((r126 instanceof FrameLayout) == false) goto L109;
        r100 = r126;
    L109:
        if (r100 == null) goto L133;
        com.bytedance.ug.sdk.luckycat.impl.lynx.a r127 = this.f271416i;
        if (r127 == null) goto L133;
        r127.getClass();
    L133:
        LuckyCatPopupConfig r128 = this.f271413f;     // Catch: Throwable -> L121
        if (r128 == null) goto L118;
        String r129 = r128.getMaskColor();     // Catch: Throwable -> L121
        if (r129 == null) goto L118;
    L119:
        r113 = Color.parseColor(r129);     // Catch: Throwable -> L121
    L118:
        r129 = "";
    L122:
        RelativeLayout r130 = this.f271411d;
        if (r130 == null) goto L125;
        r130.setBackgroundColor(r113);
    L125:
        RoundFrameLayout r131 = this.f271412e;
        if (r131 == null) goto L128;
        r131.setMaskColor(r113);
    L128:
        RoundFrameLayout r132 = this.f271412e;
        if (r132 == null) goto L132;
        r132.setBackgroundColor(r113);
    L132:
        return this.f271411d;
    L99:
        if (r124.equals("bottom") == false) goto L101;
        r105.addRule(14);
        r105.addRule(12);
    L101:
        r105.addRule(14);
        r105.addRule(13);
        goto L102
    L76:
        int r107 = RangesKt.coerceAtMost(r122 / 2, r123 / 2);
        if (r102 <= r107) goto L79;
        r102 = r107;
    L21:
        LuckyCatPopupConfig r108 = this.f271413f;
        float r109 = r108.getWidth();
        Resources r133 = r119.getResources();
        float r134 = (r109 * WindowDisplayMetricsOverride.apply(r133, r133.getDisplayMetrics()).density) + 0.5f;
        float r135 = r108.getHeight();
        Resources r136 = r119.getResources();
        float r137 = (r135 * WindowDisplayMetricsOverride.apply(r136, r136.getDisplayMetrics()).density) + 0.5f;
        if (r108.getWidth() == 0) goto L24;
    L26:
        boolean r138 = true;
    L27:
        int r139 = r108.getWidthPercent();
        if (1 > r139) goto L39;
        if (100 < r139) goto L39;
        if (r138 == true) goto L39;
        float r140 = r120 * r108.getWidthPercent();
        float r141 = 100;
        int r142 = MathKt.roundToInt(r140 / r141);
        int r143 = r108.getHeightPercent();
        if (1 > r143) goto L37;
        if (100 < r143) goto L37;
        r121 = new Pair(Integer.valueOf(r142), Integer.valueOf(MathKt.roundToInt((r101 * r108.getHeightPercent()) / r141)));
    L37:
        Pair r144 = new Pair(Integer.valueOf(r142), Integer.valueOf(r101));
    L38:
        r121 = r144;
    L39:
        int r145 = r108.getHeightPercent();
        if (1 > r145) goto L51;
        if (100 < r145) goto L51;
        if (r138 == true) goto L51;
        float r146 = r101;
        float r147 = 100;
        int r148 = MathKt.roundToInt((r108.getHeightPercent() * r146) / r147);
        int r149 = r108.getWidthPercent();
        if (1 > r149) goto L49;
        if (100 < r149) goto L49;
        r144 = new Pair(Integer.valueOf(MathKt.roundToInt((r146 * r108.getHeightPercent()) / r147)), Integer.valueOf(r148));
    L49:
        r121 = new Pair(Integer.valueOf(r120), Integer.valueOf(r148));
    L51:
        if (r134 == 0.5f) goto L53;
        float r150 = r120;
        if (r134 >= 1.0f) goto L59;
    L63:
        if (r134 >= 1.0f) goto L65;
    L71:
        r121 = new Pair(Integer.valueOf(r120), Integer.valueOf(r101));
        goto L73
    L65:
        if (r134 > r150) goto L71;
        float r151 = r101;
        if (r137 < 1.0f) goto L71;
        if (r137 > r151) goto L71;
        r121 = new Pair(Integer.valueOf(MathKt.roundToInt(r134)), Integer.valueOf(MathKt.roundToInt(r137)));
        goto L73
    L59:
        if (r134 > r150) goto L63;
        if (r108.getAspectRatio() <= 0) goto L63;
        r144 = new Pair(Integer.valueOf(MathKt.roundToInt(r134)), Integer.valueOf(MathKt.roundToInt(((double) r134) * r108.getAspectRatio())));
        goto L38
    L53:
        if (r108.getAspectRatio() <= 0) goto L55;
        r144 = new Pair(Integer.valueOf(MathKt.roundToInt(((double) r137) / r108.getAspectRatio())), Integer.valueOf(MathKt.roundToInt(r137)));
        goto L38
    L55:
        r121 = new Pair(Integer.valueOf(r120), Integer.valueOf(MathKt.roundToInt(r137)));
        goto L73
    L24:
        if (r108.getHeight() != 0) goto L26;
        r138 = false;
        goto L27
    L72:
        r121 = new Pair(0, 0);
        goto L73
    L8:
        r116 = null;
        goto L10
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
        if (r101 != 4) goto L15;
        if (r102 != null) goto L6;
        return false;
    L6:
        if (r102.getAction() != 1) goto L18;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatDialogFragment", "KEYCODE_BACK and ACTION_UP");
        if (this.f271413f.isBlockBackPress() == false) goto L11;
        JSONObject r103 = new JSONObject();
        r103.put("code", 1);
        JSONObject r104 = new JSONObject();
        r104.put("from", "lynx");
        r103.putOpt("data", r104);
        r103.put("msg", "success");
        return true;
    L11:
        com.bytedance.ug.sdk.luckycat.impl.lynx.a r105 = this.f271416i;
        if (r105 == null) goto L19;
        r105.Zf(CloseType.CLOSE_BY_BACK);
        return true;
    L19:
        return false;
    L18:
        return false;
    L15:
        return false;
    }
}
