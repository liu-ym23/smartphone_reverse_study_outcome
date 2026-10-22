package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bitable.filtersortviewsetting.BitableFilterSortViewSettingPanel;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public static final boolean c(DialogFragment r8, Fragment r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        return e(r8, r9, null, false, 0, false, 62);
    }

    public static final void g(ActionSheetDialogFragment r9, FragmentActivity r10, ForsetiNavOptions.DestinationStyle r11, View r12, String r13) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r11, JSEventListener.STYLE);
        h(r9, r10, r11, r12, -2, r13, null, false, 448);
    }

    public static final void a(DialogFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        tt5.a.h("DialogRouteCompat", "close() called");
    L11:
        th = move-exception;
        tt5.a.f("DialogRouteCompat", th, false);
        iu5.d.a("DialogRouteCompat_dismissIgnoreErr()", th);
        return;
    L4:
        if (r2.isAdded() == true) goto L20;
        tt5.a.d("DialogRouteCompat", "fragment is not add");     // Catch: Throwable -> L11
    L17:
        return;
    L20:
        r2.dismissAllowingStateLoss();     // Catch: Exception -> L7 Throwable -> L11
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r3 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r3 == null) goto L17;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L17
    }

    public static final int b(FragmentActivity r4, View r5) {
        if (r4 == null) goto L14;
        if (r5 == null) goto L14;
        Window r0 = r4.getWindow();
        if (r0 == null) goto L14;
        View r1 = r0.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L12;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L12;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L12:
        if (r1 == null) goto L14;
        int r3 = ((r1.getHeight() - r5.getHeight()) - com.bytedance.ee.util.ui.k.e(r4)) - com.bytedance.ee.util.ui.k.c(r4);
        com.ss.android.lark.forsetiutils.b.a.getClass();
        return com.ss.android.lark.forsetiutils.b.b(r3, r4);
    L14:
        return -1;
    }

    public static void i(final BitableFilterSortViewSettingPanel r18, final Fragment r19, final FragmentActivity r20, final Function1 r21) {
        final String r16 = "FilterSortViewSetting";
        final boolean r4 = true;
        final ForsetiNavOptions.DestinationStyle r8 = ForsetiNavOptions.DestinationStyle.HALF_FLOAT;
        final boolean r9 = false;
        final View r10 = null;
        final int r11 = -1;
        final boolean r12 = false;
        Intrinsics.checkNotNullParameter(r18, "<this>");
        Intrinsics.checkNotNullParameter(r8, JSEventListener.STYLE);
        tt5.a.h("DialogRouteCompat", "fragment: " + r18 + ", sourceFragment: " + r19 + ", needDownGrade=true");
        final Ref.BooleanRef r1 = new Ref.BooleanRef();
        final Ref.ObjectRef r2 = new Ref.ObjectRef();
        tua.b r13 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r20);
        final Ref.ObjectRef r7 = new Ref.ObjectRef();
        if (r13 == null) goto L5;
        com.ss.android.lark.forseti.global.a r0 = r13.K(new DialogRouteCompatKt$showWithDowngrade$disposable$1(r1, r2, r18, r4, r20, r19, r21, r8, r9, r10, r11, r12, r16), true);
    L6:
        r7.element = r0;
        com.bytedance.ee.util.ui.j.c(new DialogRouteCompatKt$showWithDowngrade$1(r18, r16, r7));
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static final boolean d(DialogFragment r5, Fragment r6, ForsetiNavOptions.DestinationStyle r7, boolean r8, View r9, int r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r7, JSEventListener.STYLE);
        if (r6 == null) goto L19;
        com.suite.lark.component.navroute.forseti.g r1 = com.suite.lark.component.navroute.forseti.f.b(r6);     // Catch: Throwable -> L14
        if (r1 == null) goto L20;
        com.suite.lark.component.navroute.fragment.c r2 = new com.suite.lark.component.navroute.fragment.c(r5);     // Catch: Throwable -> L14
        ForsetiNavOptions.a r3 = new ForsetiNavOptions.a();     // Catch: Throwable -> L14
        if (r9 == null) goto L9;
        Rect r4 = new Rect();     // Catch: Throwable -> L14
        r9.getGlobalVisibleRect(r4);     // Catch: Throwable -> L14
        r3.b(r4, r10);     // Catch: Throwable -> L14
    L9:
        Intrinsics.checkNotNullParameter(r7, "value");     // Catch: Throwable -> L14
        r3.e = r7;     // Catch: Throwable -> L14
        r3.i = r11;     // Catch: Throwable -> L14
        if (r8 == false) goto L12;
        r3.b = "CLEAR_TOP_SOURCE";     // Catch: Throwable -> L14
        r3.c = true;     // Catch: Throwable -> L14
    L12:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L14
        r1.b(r2, r3.a());     // Catch: Throwable -> L14
        return true;
    L20:
        return true;
    L14:
        th = move-exception;
        tt5.a.e("DialogRouteCompat", "route error! fragment: " + r5 + ", sourceFragment: " + r6, th, !eu5.c.d());
        return false;
    L19:
        return true;
    }

    public static /* synthetic */ boolean e(DialogFragment r7, Fragment r8, ForsetiNavOptions.DestinationStyle r9, boolean r10, int r11, boolean r12, int r13) {
        if ((r13 & 2) == 0) goto L5;
        r9 = ForsetiNavOptions.DestinationStyle.HALF_FLOAT;
    L5:
        ForsetiNavOptions.DestinationStyle r2 = r9;
        if ((r13 & 4) == 0) goto L8;
        boolean r3 = false;
    L10:
        if ((r13 & 16) == 0) goto L12;
        int r5 = -1;
    L14:
        if ((r13 & 32) == 0) goto L16;
        boolean r6 = false;
    L18:
        return d(r7, r8, r2, r3, null, r5, r6);
    L16:
        r6 = r12;
        goto L18
    L12:
        r5 = r11;
        goto L14
    L8:
        r3 = r10;
        goto L10
    }

    public static /* synthetic */ void h(DialogFragment r12, FragmentActivity r13, ForsetiNavOptions.DestinationStyle r14, View r16, int r17, String r18, Fragment r19, boolean r110, int r20) {
        if ((r20 & 2) == 0) goto L5;
        ForsetiNavOptions.DestinationStyle r4 = ForsetiNavOptions.DestinationStyle.HALF_FLOAT;
    L7:
        if ((r20 & 8) == 0) goto L9;
        View r6 = null;
    L11:
        if ((r20 & 16) == 0) goto L13;
        int r7 = -2;
    L15:
        if ((r20 & 32) == 0) goto L17;
        String r8 = r12.getClass().getName();
    L19:
        if ((r20 & 64) == 0) goto L21;
        Fragment r9 = null;
    L23:
        if ((r20 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L25;
        boolean r10 = false;
    L26:
        f(r12, r13, r4, false, r6, r7, r8, r9, r10, null);
        return;
    L25:
        r10 = r110;
        goto L26
    L21:
        r9 = r19;
        goto L23
    L17:
        r8 = r18;
        goto L19
    L13:
        r7 = r17;
        goto L15
    L9:
        r6 = r16;
        goto L11
    L5:
        r4 = r14;
        goto L7
    }

    public static final void f(final DialogFragment r17, final FragmentActivity r18, final ForsetiNavOptions.DestinationStyle r19, final boolean r20, final View r21, final int r22, final String r23, final Fragment r24, final boolean r26, final Function1 r27) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.checkNotNullParameter(r19, JSEventListener.STYLE);
        tt5.a.h("DialogRouteCompat", "fragment: " + r17 + ", popOverHeight=" + r22);
        if (ForsetiHelper.s(r24) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        boolean r1 = ForsetiHelper.o();
        DialogFragment r2 = null;
        if (r0 == false) goto L21;
        if (r1 == false) goto L21;
        if (r21 == null) goto L21;
        final Ref.BooleanRef r3 = new Ref.BooleanRef();
        final Ref.ObjectRef r4 = new Ref.ObjectRef();
        tua.b r16 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r18);
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        if (r16 == null) goto L17;
        r2 = r16.K(new DialogRouteCompatKt$showPopCompat$disposable$1(r3, r4, r17, r18, r24, r27, r19, r21, r22, r20, r26, r23), true);
        final Ref.ObjectRef r5 = r11;
    L18:
        r5.element = r2;
        com.bytedance.ee.util.ui.j.c(new DialogRouteCompatKt$showPopCompat$2(r17, r5));
        return;
    L17:
        r5 = r11;
    L21:
        if (r18 == null) goto L24;
        FragmentManager r6 = r18.getSupportFragmentManager();
        if (r6 == null) goto L24;
    L29:
        if (r6 != null) goto L31;
        return;
    L31:
        if ((r17 instanceof Fragment) == false) goto L33;
        r2 = r17;
    L33:
        LandscapeRestrictionOperation r7 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, r23, r7);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r2, r7) == true) goto L43;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
    L37:
        r17.show(r6, r23);
        return;
    L43:
        return;
    L24:
        if (r24 == null) goto L28;
        FragmentActivity r8 = r24.getActivity();
        if (r8 == null) goto L28;
        r6 = r8.getSupportFragmentManager();
    L28:
        r6 = null;
        goto L29
    L5:
        if (ForsetiHelper.t(r18) == true) goto L8;
        r0 = false;
        goto L9
    }
}
