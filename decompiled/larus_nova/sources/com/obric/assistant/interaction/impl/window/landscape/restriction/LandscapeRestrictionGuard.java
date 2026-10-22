package com.obric.assistant.interaction.impl.window.landscape.restriction;

import android.app.Dialog;
import android.content.Context;
import android.os.SystemClock;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.AssistantChatDialog;
import com.obric.assistant.interaction.impl.window.WindowHost;
import com.obric.assistant.spi.window.ChatWindowServiceDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.lang.reflect.Field;
import jea.a;
import jea.b;
import jea.c;
import jea.d;
import jea.e;
import jea.f;
import jea.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010(\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u001e2\b\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010+\u001a\u00020,H\u0007J\u001a\u0010-\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u0005H\u0007J\u0012\u00101\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u000102H\u0007J\u0012\u00103\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u000102H\u0007J\u0012\u00104\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010/H\u0007J\u0012\u00105\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010/H\u0007J\u0012\u00106\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010/H\u0007J\u0012\u00107\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010/H\u0007J$\u00108\u001a\u00020\r2\b\u00109\u001a\u0004\u0018\u00010\u001a2\b\u0010)\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020\u0005H\u0007J$\u00108\u001a\u00020\r2\b\u00109\u001a\u0004\u0018\u00010\u001a2\b\u0010)\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020,H\u0007J$\u0010:\u001a\u00020\r2\b\u0010;\u001a\u0004\u0018\u00010\u00012\b\u0010)\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020\u0005H\u0007J$\u0010:\u001a\u00020\r2\b\u0010;\u001a\u0004\u0018\u00010\u00012\b\u0010)\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020,H\u0007J6\u0010:\u001a\u00020\r2\b\u0010;\u001a\u0004\u0018\u00010\u00012\b\u0010)\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010<\u001a\u00020\tH\u0007J6\u0010:\u001a\u00020\r2\b\u0010;\u001a\u0004\u0018\u00010\u00012\b\u0010)\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020,2\b\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010<\u001a\u00020\tH\u0007J:\u0010=\u001a\u00020\r2\b\u00109\u001a\u0004\u0018\u00010\u001a2\b\u0010)\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020,2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010<\u001a\u00020\tH\u0002J\u0014\u0010>\u001a\u0004\u0018\u00010\u001a2\b\u0010;\u001a\u0004\u0018\u00010\u0001H\u0002J\u001e\u0010?\u001a\u0004\u0018\u00010@2\n\u0010A\u001a\u0006\u0012\u0002\b\u00030B2\u0006\u0010C\u001a\u00020\u0005H\u0002J\u0012\u0010D\u001a\u00020\r2\b\u0010E\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\r0\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\r0\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R(\u0010\u001d\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020\r0\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R*\u0010!\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018R&\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020%0\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018¨\u0006H"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/restriction/LandscapeRestrictionGuard;", "", "<init>", "()V", "TAG", "", "TOAST_DEDUP_INTERVAL_MS", "", "NO_CONTAINER_VIEW_ID", "", "lastToastUptimeMs", "landscapeRestrictionActiveResolver", "Lkotlin/Function0;", "", "getLandscapeRestrictionActiveResolver$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function0;", "setLandscapeRestrictionActiveResolver$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function0;)V", "windowContextResolver", "Lkotlin/Function1;", "Landroid/content/Context;", "getWindowContextResolver$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function1;", "setWindowContextResolver$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function1;)V", "windowRootFragmentManagerResolver", "Landroidx/fragment/app/FragmentManager;", "getWindowRootFragmentManagerResolver$impl_mainlandRelease", "setWindowRootFragmentManagerResolver$impl_mainlandRelease", "currentChatFragmentResolver", "Landroidx/fragment/app/Fragment;", "getCurrentChatFragmentResolver$impl_mainlandRelease", "setCurrentChatFragmentResolver$impl_mainlandRelease", "fragmentManagerResolver", "getFragmentManagerResolver$impl_mainlandRelease", "setFragmentManagerResolver$impl_mainlandRelease", "portraitToastReporter", "", "getPortraitToastReporter$impl_mainlandRelease", "setPortraitToastReporter$impl_mainlandRelease", "markDialogFragmentIfAllowed", WidgetService.PARAM_FRAGMENT, "tag", WikiFolderPushPlugin.OPT, "Lcom/obric/assistant/interaction/impl/window/landscape/restriction/LandscapeRestrictionOperation;", "markDialogAllowed", "dialog", "Landroid/app/Dialog;", ControlRule.KEY_RULE_ID, "bindDialogForAllowedDialogFragment", "Landroidx/fragment/app/DialogFragment;", "clearAllowedDialogFragment", "clearAllowedDialog", "onDialogShown", "onDialogDismissed", "shouldBlockDialogShow", "shouldBlockDialogFragmentShow", "fragmentManager", "shouldBlockFragmentTransaction", "transaction", "containerViewId", "shouldBlockFragmentManagerOperation", "resolveFragmentManager", "findField", "Ljava/lang/reflect/Field;", "clsStart", "Ljava/lang/Class;", "name", "isWindowContext", PerfLog.PARAM_KEY_CONTEXT_ID, "showPortraitOnlyToast", "reason", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LandscapeRestrictionGuard {
    public static final LandscapeRestrictionGuard INSTANCE = null;
    private static final int NO_CONTAINER_VIEW_ID = 0;
    private static final String TAG = "LandscapeRestrictionGuard";
    private static final long TOAST_DEDUP_INTERVAL_MS = 800;
    private static Function1<? super Fragment, Boolean> currentChatFragmentResolver;
    private static Function1<Object, ? extends FragmentManager> fragmentManagerResolver;
    private static Function0<Boolean> landscapeRestrictionActiveResolver;
    private static volatile long lastToastUptimeMs;
    private static Function1<? super String, Unit> portraitToastReporter;
    private static Function1<? super Context, Boolean> windowContextResolver;
    private static Function1<? super FragmentManager, Boolean> windowRootFragmentManagerResolver;

    private LandscapeRestrictionGuard() {
    }

    public static /* synthetic */ void a() {
        showPortraitOnlyToast$lambda$11();
    }

    public static /* synthetic */ boolean b(Context r100) {
        return windowContextResolver$lambda$1(r100);
    }

    public static /* synthetic */ boolean c(Fragment r100) {
        return currentChatFragmentResolver$lambda$3(r100);
    }

    public static /* synthetic */ boolean d() {
        return landscapeRestrictionActiveResolver$lambda$0();
    }

    public static /* synthetic */ FragmentManager e(Object r100) {
        return fragmentManagerResolver$lambda$4(r100);
    }

    public static /* synthetic */ boolean f(FragmentManager r100) {
        return windowRootFragmentManagerResolver$lambda$2(r100);
    }

    public static /* synthetic */ Unit g(String r100) {
        return portraitToastReporter$lambda$5(r100);
    }

    static {
        INSTANCE = new LandscapeRestrictionGuard();
        landscapeRestrictionActiveResolver = new a();
        windowContextResolver = new b();
        windowRootFragmentManagerResolver = new c();
        currentChatFragmentResolver = new d();
        fragmentManagerResolver = new e();
        portraitToastReporter = new f();
    }

    private static final boolean landscapeRestrictionActiveResolver$lambda$0() {
        return WindowHost.INSTANCE.isLandscapeRestrictionActive();
    }

    private static final void showPortraitOnlyToast$lambda$11() {
        s.f544207a.g(AppHost.f326268a.getApplication(), R.string.obric_rotate_screen_and_retry, false);
    }

    public final Function1<Fragment, Boolean> getCurrentChatFragmentResolver$impl_mainlandRelease() {
        return currentChatFragmentResolver;
    }

    public final Function1<Object, FragmentManager> getFragmentManagerResolver$impl_mainlandRelease() {
        return fragmentManagerResolver;
    }

    public final Function0<Boolean> getLandscapeRestrictionActiveResolver$impl_mainlandRelease() {
        return landscapeRestrictionActiveResolver;
    }

    public final Function1<String, Unit> getPortraitToastReporter$impl_mainlandRelease() {
        return portraitToastReporter;
    }

    public final Function1<Context, Boolean> getWindowContextResolver$impl_mainlandRelease() {
        return windowContextResolver;
    }

    public final Function1<FragmentManager, Boolean> getWindowRootFragmentManagerResolver$impl_mainlandRelease() {
        return windowRootFragmentManagerResolver;
    }

    @JvmStatic
    public static final void bindDialogForAllowedDialogFragment(DialogFragment r100) {
        LandscapeRestrictionManager.bindDialogForAllowedDialogFragment(r100);
    }

    @JvmStatic
    public static final void clearAllowedDialog(Dialog r100) {
        LandscapeRestrictionManager.clearAllowedDialog(r100);
    }

    @JvmStatic
    public static final void clearAllowedDialogFragment(DialogFragment r100) {
        LandscapeRestrictionManager.clearAllowedDialogFragment(r100);
    }

    private static final boolean currentChatFragmentResolver$lambda$3(Fragment r100) {
        return WindowHost.INSTANCE.isCurrentChatFragment(r100);
    }

    private static final FragmentManager fragmentManagerResolver$lambda$4(Object r100) {
        return INSTANCE.resolveFragmentManager(r100);
    }

    private final boolean isWindowContext(Context r100) {
        if (r100 != null) goto L17;
        return false;
    L17:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(Boolean.valueOf(ChatWindowServiceDelegate.f392926b.d(r100)));     // Catch: Throwable -> L7
    L9:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L12;
        FLogger.f375446a.w(TAG, "isWindowContext failed, context=" + r100, r103);
    L12:
        Boolean r104 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r102) == false) goto L16;
        r102 = r104;
    L16:
        return ((Boolean) r102).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    @JvmStatic
    public static final void onDialogDismissed(Dialog r100) {
        LandscapeRestrictionManager.onDialogDismissed(r100);
    }

    @JvmStatic
    public static final void onDialogShown(Dialog r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (landscapeRestrictionActiveResolver.invoke().booleanValue() == true) goto L8;
        return;
    L8:
        if (windowContextResolver.invoke(r100.getContext()).booleanValue() == true) goto L10;
        return;
    L10:
        LandscapeRestrictionManager.onDialogShown(r100);
    }

    private static final Unit portraitToastReporter$lambda$5(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        INSTANCE.showPortraitOnlyToast(r100);
        return Unit.INSTANCE;
    }

    private final FragmentManager resolveFragmentManager(Object r100) {
        Object r101 = null;
        if (r100 != null) goto L26;
        return null;
    L26:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L15
        Field r103 = findField(r100.getClass(), "mManager");     // Catch: Throwable -> L15
        if (r103 == null) goto L8;
        Object r104 = r103.get(r100);     // Catch: Throwable -> L15
    L10:
        if ((r104 instanceof FragmentManager) == false) goto L12;
        FragmentManager r105 = (FragmentManager) r104;     // Catch: Throwable -> L15
    L13:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L15
    L17:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L21;
        FLogger.f375446a.w(TAG, "resolveFragmentManager failed, transaction=" + r100, r107);
    L21:
        if (Result.m9455isFailureimpl(r106) == true) goto L25;
        r101 = r106;
    L25:
        return (FragmentManager) r101;
    L12:
        r105 = null;
        goto L13
    L8:
        r104 = null;
    L15:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    @JvmStatic
    public static final boolean shouldBlockDialogShow(Dialog r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof AssistantChatDialog) == false) goto L9;
        return false;
    L9:
        if (landscapeRestrictionActiveResolver.invoke().booleanValue() == true) goto L12;
        return false;
    L12:
        if (windowContextResolver.invoke(r100.getContext()).booleanValue() == true) goto L15;
        return false;
    L15:
        if (LandscapeRestrictionManager.isDialogAllowed(r100, LandscapeRestrictionOperation.DIALOG_SHOW) == false) goto L18;
        return false;
    L18:
        if (LandscapeRestrictionManager.isDialogAllowedByVisibleScope(r100) == false) goto L21;
        return false;
    L21:
        if (LandscapeRestrictionManager.hasVisibleAllowedDialog() == false) goto L24;
        return false;
    L24:
        if (LandscapeRestrictionManager.isDialogAllowedByTaskbarScope(r100) == false) goto L27;
        return false;
    L27:
        if (LandscapeTaskbarExpandedAllowHelper.isTaskbarExpanded() == false) goto L29;
        return false;
    L29:
        FLogger.f375446a.i(TAG, "block dialog show in landscape restriction, dialog=".concat(r100.getClass().getName()));
        portraitToastReporter.invoke("dialog");
        return true;
    }

    private final synchronized void showPortraitOnlyToast(String r100) {
        monitor-enter(this);
        long r101 = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        if ((r101 - lastToastUptimeMs) >= 800) goto L8;
        monitor-exit(this);
        return;
    L8:
        lastToastUptimeMs = r101;     // Catch: Throwable -> L11
        t0.e(new g());     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private static final boolean windowContextResolver$lambda$1(Context r100) {
        return INSTANCE.isWindowContext(r100);
    }

    private static final boolean windowRootFragmentManagerResolver$lambda$2(FragmentManager r100) {
        return WindowHost.INSTANCE.isWindowRootFragmentManager(r100);
    }

    public final void setCurrentChatFragmentResolver$impl_mainlandRelease(Function1<? super Fragment, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        currentChatFragmentResolver = r100;
    }

    public final void setFragmentManagerResolver$impl_mainlandRelease(Function1<Object, ? extends FragmentManager> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        fragmentManagerResolver = r100;
    }

    public final void setLandscapeRestrictionActiveResolver$impl_mainlandRelease(Function0<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        landscapeRestrictionActiveResolver = r100;
    }

    public final void setPortraitToastReporter$impl_mainlandRelease(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        portraitToastReporter = r100;
    }

    public final void setWindowContextResolver$impl_mainlandRelease(Function1<? super Context, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        windowContextResolver = r100;
    }

    public final void setWindowRootFragmentManagerResolver$impl_mainlandRelease(Function1<? super FragmentManager, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        windowRootFragmentManagerResolver = r100;
    }

    private final Field findField(Class<?> r100, String r101) {
    L2:
        if (r100 == null) goto L6;
        Field r102 = r100.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L5
        r102.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        return r102;
    L5:
        r100 = r100.getSuperclass();
        goto L2
    L6:
        return null;
    }

    @JvmStatic
    public static final void markDialogAllowed(Dialog r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, ControlRule.KEY_RULE_ID);
        LandscapeRestrictionManager.markDialogAllowed(r100, r101);
    }

    @JvmStatic
    public static final void markDialogFragmentIfAllowed(Fragment r100, String r101, LandscapeRestrictionOperation r102) {
        Intrinsics.checkNotNullParameter(r102, WikiFolderPushPlugin.OPT);
        LandscapeRestrictionManager.markDialogFragmentIfAllowed(r100, r101, r102);
    }

    @JvmStatic
    public static final boolean shouldBlockDialogFragmentShow(FragmentManager r100, Fragment r101, LandscapeRestrictionOperation r110) {
        Intrinsics.checkNotNullParameter(r110, WikiFolderPushPlugin.OPT);
        if (landscapeRestrictionActiveResolver.invoke().booleanValue() == true) goto L7;
        return false;
    L7:
        return shouldBlockFragmentManagerOperation$default(INSTANCE, r100, r101, r110, null, 0, 24, null);
    }

    @JvmStatic
    public static final boolean shouldBlockFragmentTransaction(Object r100, Fragment r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, WikiFolderPushPlugin.OPT);
        return shouldBlockFragmentTransaction(r100, r101, LandscapeRestrictionOperation.Companion.fromLegacyName(r102));
    }

    @JvmStatic
    public static final boolean shouldBlockDialogFragmentShow(FragmentManager r100, Fragment r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, WikiFolderPushPlugin.OPT);
        return shouldBlockDialogFragmentShow(r100, r101, LandscapeRestrictionOperation.Companion.fromLegacyName(r102));
    }

    @JvmStatic
    public static final boolean shouldBlockFragmentTransaction(Object r100, Fragment r101, LandscapeRestrictionOperation r102) {
        Intrinsics.checkNotNullParameter(r102, WikiFolderPushPlugin.OPT);
        return shouldBlockFragmentTransaction(r100, r101, r102, null, 0);
    }

    private final boolean shouldBlockFragmentManagerOperation(FragmentManager r100, Fragment r101, LandscapeRestrictionOperation r102, String r103, int r104) {
        if (r101 != null) goto L6;
        return false;
    L6:
        if (windowRootFragmentManagerResolver.invoke(r100).booleanValue() == true) goto L9;
        return false;
    L9:
        if (currentChatFragmentResolver.invoke(r101).booleanValue() == false) goto L12;
        return false;
    L12:
        if (LandscapeRestrictionManager.isDialogFragmentAllowed(r101, r102) == false) goto L15;
        return false;
    L15:
        if ((r101 instanceof DialogFragment) == false) goto L33;
        if (LandscapeRestrictionManager.isDialogFragmentAllowedByVisibleScope(r101, r102) == false) goto L20;
        return false;
    L20:
        if (LandscapeRestrictionManager.markDialogFragmentAllowedByVisibleScope(r101, r102) == false) goto L23;
        return false;
    L23:
        if (LandscapeRestrictionManager.isDialogFragmentAllowedByTaskbarScope(r101, r102) == false) goto L26;
        return false;
    L26:
        if (r102.isDialogFragmentShowOperation() == false) goto L33;
        if (LandscapeTaskbarExpandedAllowHelper.isTaskbarExpanded() == false) goto L33;
        if (LandscapeRestrictionManager.markDialogFragmentAllowedByTaskbarScope(r101, r102) == false) goto L33;
        return false;
    L33:
        if (LandscapeRestrictionManager.isFragmentAllowed(r101, r102) == false) goto L36;
        return false;
    L36:
        if (LandscapeRestrictionManager.markFragmentIfAllowed(r101, r103, r104, r102) == false) goto L38;
        return false;
    L38:
        FLogger.f375446a.i(TAG, "block fragment in landscape restriction, operation=" + r102.getTraceName$impl_mainlandRelease() + ", fragment=" + r101.getClass().getName());
        portraitToastReporter.invoke(WidgetService.PARAM_FRAGMENT);
        return true;
    }

    @JvmStatic
    public static final boolean shouldBlockFragmentTransaction(Object r100, Fragment r101, LandscapeRestrictionOperation r110, String r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, WikiFolderPushPlugin.OPT);
        if (r101 != null) goto L6;
        return false;
    L6:
        if (landscapeRestrictionActiveResolver.invoke().booleanValue() == true) goto L9;
        return false;
    L9:
        return INSTANCE.shouldBlockFragmentManagerOperation(fragmentManagerResolver.invoke(r100), r101, r110, r111, r112);
    }

    @JvmStatic
    public static final boolean shouldBlockFragmentTransaction(Object r100, Fragment r101, String r102, String r103, int r104) {
        Intrinsics.checkNotNullParameter(r102, WikiFolderPushPlugin.OPT);
        return shouldBlockFragmentTransaction(r100, r101, LandscapeRestrictionOperation.Companion.fromLegacyName(r102), r103, r104);
    }

    public static /* synthetic */ boolean shouldBlockFragmentManagerOperation$default(LandscapeRestrictionGuard r100, FragmentManager r101, Fragment r102, LandscapeRestrictionOperation r103, String r110, int r111, int r112, Object r113) {
        if ((r112 & 8) == 0) goto L5;
        r110 = null;
    L5:
        String r104 = r110;
        if ((r112 & 16) == 0) goto L8;
        int r105 = 0;
    L10:
        return r100.shouldBlockFragmentManagerOperation(r101, r102, r103, r104, r105);
    L8:
        r105 = r111;
        goto L10
    }
}
