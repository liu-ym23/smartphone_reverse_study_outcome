package com.obric.assistant.interaction.impl.toast;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.WindowHost;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeWindowToastBoundsAdapter;
import com.obric.oui.common.style.l;
import com.obric.oui.common.style.q;
import com.obric.oui.toast.f;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import we8.j;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004GHIJB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J*\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0006H\u0014J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\nH\u0016J\u0018\u0010#\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0006H\u0016J\u0018\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020\u0006H\u0016J\u0018\u0010#\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020\u0006H\u0016J\u0018\u0010(\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0006H\u0002J\b\u0010)\u001a\u00020\"H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010\u00172\u0006\u0010-\u001a\u00020\u0006H\u0002J\u001a\u0010.\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010\u00172\u0006\u00100\u001a\u00020\u0019H\u0002J\u001a\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u00104\u001a\u00020\"H\u0002J\u001a\u00105\u001a\u00020\"2\u0006\u00102\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u00010\u0013H\u0002J\u0018\u00106\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0006H\u0002J\b\u00107\u001a\u00020\u0006H\u0002J\u0012\u00108\u001a\u00020\n2\b\b\u0001\u00109\u001a\u00020\nH\u0002J\f\u0010:\u001a\u00020\u0006*\u00020\u0002H\u0002J\u0012\u0010;\u001a\u0004\u0018\u00010%2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020\u0002H\u0002J \u0010>\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%2\u0006\u0010=\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\nH\u0002J\u0010\u0010@\u001a\u00020\n2\u0006\u0010=\u001a\u00020\u0002H\u0002J\u0010\u0010A\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H\u0002J$\u0010B\u001a\u00020\"2\u0006\u00102\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010C\u001a\u00020\u0006H\u0002J\u0010\u0010D\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0014\u0010E\u001a\u00020\n*\u00020\u001c2\u0006\u0010F\u001a\u00020\nH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder;", "Lcom/larus/common_ui/toast/abs/AbsToastHolder;", "Landroid/view/View;", "<init>", "()V", "supportLottie", "", "getSupportLottie", "()Z", "displayDuration", "", "getDisplayDuration", "()I", "setDisplayDuration", "(I)V", "toastView", "mainHandler", "Landroid/os/Handler;", "windowManager", "Landroid/view/WindowManager;", "removeRunnable", "Ljava/lang/Runnable;", "currentToastSignature", "Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$ToastSignature;", "currentParamsSignature", "Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$WindowParamsSignature;", "newInstance", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "duration", "isForceDarkMode", "setDuration", "", "show", "activity", "Landroid/app/Activity;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "showInternal", "dismiss", "createLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "buildToastSignature", "isDarkMode", "tryAdoptPendingToast", "toastSignature", "paramsSignature", "schedulePendingRemove", "view", "wm", "flushPendingToast", "scheduleAutoRemove", "buildOuiToastLayout", "shouldShowIconDrawableRes", "normalizeIconDrawableRes", "drawableRes", "isAttachedForToast", "resolveToastActivity", "setupOuiToastBackground", "content", "wrapWithOToastShadowFrame", "bottomInset", "getToastCornerRadius", "getOToastShadowSpaceTop", "removeViewIfNeeded", "retryOnFailure", "isAppDarkMode", "dp", "value", "Companion", "ToastSignature", "WindowParamsSignature", "PendingToast", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowToastHolder extends u19.a<View> {
    public static final Companion Companion = null;
    private static final int OUI_TOAST_BOTTOM_MARGIN_DP = 144;
    private static final int OUI_TOAST_DEFAULT_CORNER_RADIUS_DP = 24;
    public static final long REMOVE_RETRY_DELAY_MS = 16;
    private static final int TOAST_LONG_DURATION_MS = 3500;
    private static final int TOAST_SHORT_DURATION_MS = 2000;
    private static final int TOAST_SHORT_DURATION_THRESHOLD_MS = 1500;
    private static final Set<Integer> WARNING_ICON_DRAWABLE_RES = null;
    private static Function1<? super WindowManager.LayoutParams, Unit> layoutParamsAdapter;
    private static PendingToast pendingToast;
    private static Function1<? super Context, ? extends WindowManager> windowManagerProvider;
    private WindowParamsSignature currentParamsSignature;
    private ToastSignature currentToastSignature;
    private int displayDuration;
    private final Handler mainHandler;
    private Runnable removeRunnable;
    private final boolean supportLottie;
    private View toastView;
    private WindowManager windowManager;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$Companion;", "", "<init>", "()V", "TOAST_SHORT_DURATION_THRESHOLD_MS", "", "TOAST_SHORT_DURATION_MS", "TOAST_LONG_DURATION_MS", "OUI_TOAST_BOTTOM_MARGIN_DP", "OUI_TOAST_DEFAULT_CORNER_RADIUS_DP", "REMOVE_RETRY_DELAY_MS", "", "pendingToast", "Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$PendingToast;", "WARNING_ICON_DRAWABLE_RES", "", "layoutParamsAdapter", "Lkotlin/Function1;", "Landroid/view/WindowManager$LayoutParams;", "", "getLayoutParamsAdapter$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function1;", "setLayoutParamsAdapter$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function1;)V", "windowManagerProvider", "Landroid/content/Context;", "Landroid/view/WindowManager;", "getWindowManagerProvider$impl_mainlandRelease", "setWindowManagerProvider$impl_mainlandRelease", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Function1<WindowManager.LayoutParams, Unit> getLayoutParamsAdapter$impl_mainlandRelease() {
            return WindowToastHolder.access$getLayoutParamsAdapter$cp();
        }

        public final Function1<Context, WindowManager> getWindowManagerProvider$impl_mainlandRelease() {
            return WindowToastHolder.access$getWindowManagerProvider$cp();
        }

        public final void setLayoutParamsAdapter$impl_mainlandRelease(Function1<? super WindowManager.LayoutParams, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            WindowToastHolder.access$setLayoutParamsAdapter$cp(r100);
        }

        public final void setWindowManagerProvider$impl_mainlandRelease(Function1<? super Context, ? extends WindowManager> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            WindowToastHolder.access$setWindowManagerProvider$cp(r100);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$PendingToast;", "", "view", "Landroid/view/View;", "windowManager", "Landroid/view/WindowManager;", "toastSignature", "Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$ToastSignature;", "paramsSignature", "Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$WindowParamsSignature;", "owner", "Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder;", "<init>", "(Landroid/view/View;Landroid/view/WindowManager;Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$ToastSignature;Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$WindowParamsSignature;Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder;)V", "getView", "()Landroid/view/View;", "getWindowManager", "()Landroid/view/WindowManager;", "getToastSignature", "()Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$ToastSignature;", "getParamsSignature", "()Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$WindowParamsSignature;", "getOwner", "()Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder;", "removeRunnable", "Ljava/lang/Runnable;", "getRemoveRunnable", "()Ljava/lang/Runnable;", "setRemoveRunnable", "(Ljava/lang/Runnable;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PendingToast {
        private final WindowToastHolder owner;
        private final WindowParamsSignature paramsSignature;
        public Runnable removeRunnable;
        private final ToastSignature toastSignature;
        private final View view;
        private final WindowManager windowManager;

        public final Runnable getRemoveRunnable() {
            Runnable r100 = this.removeRunnable;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("removeRunnable");
            return null;
        }

        public final WindowToastHolder getOwner() {
            return this.owner;
        }

        public final WindowParamsSignature getParamsSignature() {
            return this.paramsSignature;
        }

        public final ToastSignature getToastSignature() {
            return this.toastSignature;
        }

        public final View getView() {
            return this.view;
        }

        public final WindowManager getWindowManager() {
            return this.windowManager;
        }

        public final void setRemoveRunnable(Runnable r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.removeRunnable = r100;
        }

        public PendingToast(View r100, WindowManager r101, ToastSignature r102, WindowParamsSignature r103, WindowToastHolder r104) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r104, "owner");
            this.view = r100;
            this.windowManager = r101;
            this.toastSignature = r102;
            this.paramsSignature = r103;
            this.owner = r104;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$ToastSignature;", "", "text", "", "iconDrawableRes", "", "yOffsetPx", "isDarkMode", "", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;Z)V", "getText", "()Ljava/lang/String;", "getIconDrawableRes", "()I", "getYOffsetPx", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Z", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;ILjava/lang/Integer;Z)Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$ToastSignature;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ToastSignature {
        private final int iconDrawableRes;
        private final boolean isDarkMode;
        private final String text;
        private final Integer yOffsetPx;

        public static /* synthetic */ ToastSignature copy$default(ToastSignature r100, String r101, int r102, Integer r103, boolean r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.text;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.iconDrawableRes;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.yOffsetPx;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.isDarkMode;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final String component1() {
            return this.text;
        }

        public final int component2() {
            return this.iconDrawableRes;
        }

        public final Integer component3() {
            return this.yOffsetPx;
        }

        public final boolean component4() {
            return this.isDarkMode;
        }

        public final ToastSignature copy(String r100, int r101, Integer r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "text");
            return new ToastSignature(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ToastSignature) == true) goto L8;
            return false;
        L8:
            ToastSignature r101 = (ToastSignature) r100;
            if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
            return false;
        L12:
            if (this.iconDrawableRes == r101.iconDrawableRes) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.yOffsetPx, r101.yOffsetPx) == true) goto L18;
            return false;
        L18:
            if (this.isDarkMode == r101.isDarkMode) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r100 = ((this.text.hashCode() * 31) + this.iconDrawableRes) * 31;
            Integer r101 = this.yOffsetPx;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.isDarkMode == false) goto L9;
            int r104 = 1231;
        L11:
            return r103 + r104;
        L9:
            r104 = 1237;
            goto L11
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public String toString() {
            return "ToastSignature(text=" + this.text + ", iconDrawableRes=" + this.iconDrawableRes + ", yOffsetPx=" + this.yOffsetPx + ", isDarkMode=" + this.isDarkMode + ')';
        }

        public final int getIconDrawableRes() {
            return this.iconDrawableRes;
        }

        public final String getText() {
            return this.text;
        }

        public final Integer getYOffsetPx() {
            return this.yOffsetPx;
        }

        public final boolean isDarkMode() {
            return this.isDarkMode;
        }

        public ToastSignature(String r100, int r101, Integer r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.text = r100;
            this.iconDrawableRes = r101;
            this.yOffsetPx = r102;
            this.isDarkMode = r103;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\b\u0018\u0000 (2\u00020\u0001:\u0001(BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003Jc\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006)"}, d2 = {"Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$WindowParamsSignature;", "", "type", "", "width", "height", SubInfo.KEY_FORMAT, "flags", GXTemplateKey.GAIAX_LAYER_GRAVITY, "x", "y", "windowAnimations", "<init>", "(IIIIIIIII)V", "getType", "()I", "getWidth", "getHeight", "getFormat", "getFlags", "getGravity", "getX", "getY", "getWindowAnimations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WindowParamsSignature {
        public static final Companion Companion = null;
        private final int flags;
        private final int format;
        private final int gravity;
        private final int height;
        private final int type;
        private final int width;
        private final int windowAnimations;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final int f389719x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final int f389720y;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$WindowParamsSignature$Companion;", "", "<init>", "()V", "from", "Lcom/obric/assistant/interaction/impl/toast/WindowToastHolder$WindowParamsSignature;", "params", "Landroid/view/WindowManager$LayoutParams;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final WindowParamsSignature from(WindowManager.LayoutParams r110) {
                Intrinsics.checkNotNullParameter(r110, "params");
                return new WindowParamsSignature(r110.type, r110.width, r110.height, r110.format, r110.flags, r110.gravity, r110.x, r110.y, r110.windowAnimations);
            }
        }

        static {
            Companion = new Companion(null);
        }

        public static /* synthetic */ WindowParamsSignature copy$default(WindowParamsSignature r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, int r119, int r210, Object r211) {
            if ((r210 & 1) == 0) goto L5;
            int r100 = r110.type;
        L7:
            if ((r210 & 2) == 0) goto L9;
            int r101 = r110.width;
        L11:
            if ((r210 & 4) == 0) goto L13;
            int r102 = r110.height;
        L15:
            if ((r210 & 8) == 0) goto L17;
            int r103 = r110.format;
        L19:
            if ((r210 & 16) == 0) goto L21;
            int r104 = r110.flags;
        L23:
            if ((r210 & 32) == 0) goto L25;
            int r105 = r110.gravity;
        L27:
            if ((r210 & 64) == 0) goto L29;
            int r106 = r110.f389719x;
        L31:
            if ((r210 & 128) == 0) goto L33;
            int r107 = r110.f389720y;
        L35:
            if ((r210 & 256) == 0) goto L37;
            int r108 = r110.windowAnimations;
        L39:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
        L37:
            r108 = r119;
            goto L39
        L33:
            r107 = r118;
            goto L35
        L29:
            r106 = r117;
            goto L31
        L25:
            r105 = r116;
            goto L27
        L21:
            r104 = r115;
            goto L23
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final int component1() {
            return this.type;
        }

        public final int component2() {
            return this.width;
        }

        public final int component3() {
            return this.height;
        }

        public final int component4() {
            return this.format;
        }

        public final int component5() {
            return this.flags;
        }

        public final int component6() {
            return this.gravity;
        }

        public final int component7() {
            return this.f389719x;
        }

        public final int component8() {
            return this.f389720y;
        }

        public final int component9() {
            return this.windowAnimations;
        }

        public final WindowParamsSignature copy(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r210) {
            return new WindowParamsSignature(r110, r111, r112, r113, r114, r115, r116, r117, r210);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof WindowParamsSignature) == true) goto L8;
            return false;
        L8:
            WindowParamsSignature r101 = (WindowParamsSignature) r100;
            if (this.type == r101.type) goto L12;
            return false;
        L12:
            if (this.width == r101.width) goto L15;
            return false;
        L15:
            if (this.height == r101.height) goto L18;
            return false;
        L18:
            if (this.format == r101.format) goto L21;
            return false;
        L21:
            if (this.flags == r101.flags) goto L24;
            return false;
        L24:
            if (this.gravity == r101.gravity) goto L27;
            return false;
        L27:
            if (this.f389719x == r101.f389719x) goto L30;
            return false;
        L30:
            if (this.f389720y == r101.f389720y) goto L33;
            return false;
        L33:
            if (this.windowAnimations == r101.windowAnimations) goto L35;
            return false;
        L35:
            return true;
        }

        public int hashCode() {
            return (((((((((((((((this.type * 31) + this.width) * 31) + this.height) * 31) + this.format) * 31) + this.flags) * 31) + this.gravity) * 31) + this.f389719x) * 31) + this.f389720y) * 31) + this.windowAnimations;
        }

        public String toString() {
            return "WindowParamsSignature(type=" + this.type + ", width=" + this.width + ", height=" + this.height + ", format=" + this.format + ", flags=" + this.flags + ", gravity=" + this.gravity + ", x=" + this.f389719x + ", y=" + this.f389720y + ", windowAnimations=" + this.windowAnimations + ')';
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getFormat() {
            return this.format;
        }

        public final int getGravity() {
            return this.gravity;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getType() {
            return this.type;
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getWindowAnimations() {
            return this.windowAnimations;
        }

        public final int getX() {
            return this.f389719x;
        }

        public final int getY() {
            return this.f389720y;
        }

        public WindowParamsSignature(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            this.type = r100;
            this.width = r101;
            this.height = r102;
            this.format = r103;
            this.flags = r104;
            this.gravity = r105;
            this.f389719x = r106;
            this.f389720y = r107;
            this.windowAnimations = r108;
        }
    }

    public static /* synthetic */ void a(WindowToastHolder r100, View r101, WindowManager r102) {
        scheduleAutoRemove$lambda$7(r100, r101, r102);
    }

    public static /* synthetic */ Unit b(WindowManager.LayoutParams r100) {
        return layoutParamsAdapter$lambda$17(r100);
    }

    public static /* synthetic */ WindowManager c(Context r100) {
        return windowManagerProvider$lambda$18(r100);
    }

    public static /* synthetic */ void d(WindowToastHolder r100, View r101, WindowManager r102) {
        removeViewIfNeeded$lambda$16(r100, r101, r102);
    }

    public static /* synthetic */ void e(PendingToast r100, WindowToastHolder r101, View r102, WindowManager r103) {
        schedulePendingRemove$lambda$5(r100, r101, r102, r103);
    }

    static {
        Companion = new Companion(null);
        WARNING_ICON_DRAWABLE_RES = SetsKt.setOf(new Integer[]{Integer.valueOf(R.drawable.larus_toast_warning_icon), Integer.valueOf(R.drawable.larus_toast_warning_icon_day), Integer.valueOf(R.drawable.larus_toast_warning_icon_night)});
        layoutParamsAdapter = new b();
        windowManagerProvider = new c();
    }

    private final void flushPendingToast() {
        PendingToast r100 = pendingToast;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.getOwner().mainHandler.removeCallbacks(r100.getRemoveRunnable());
        pendingToast = null;
        removeViewIfNeeded$default(r100.getOwner(), r100.getView(), r100.getWindowManager(), false, 4, null);
    }

    @Override // u19.a, u19.f
    public void dismiss() {
        Runnable r100 = this.removeRunnable;
        if (r100 == null) goto L5;
        this.mainHandler.removeCallbacks(r100);
    L5:
        View r101 = getInstance();
        if (r101 != null) goto L8;
        r101 = this.toastView;
    L8:
        if (r101 == null) goto L10;
        schedulePendingRemove(r101, this.windowManager);
    L10:
        setInstance(null);
        this.toastView = null;
        this.windowManager = null;
        this.removeRunnable = null;
        this.currentToastSignature = null;
        this.currentParamsSignature = null;
        super.dismiss();
    }

    public WindowToastHolder() {
        this.displayDuration = 2000;
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    private final boolean shouldShowIconDrawableRes() {
        if (getIconDrawableRes() != 0) goto L5;
    L7:
        return false;
    L5:
        if (WARNING_ICON_DRAWABLE_RES.contains(Integer.valueOf(getIconDrawableRes())) == true) goto L7;
        return true;
    }

    public static final /* synthetic */ Function1 access$getLayoutParamsAdapter$cp() {
        return layoutParamsAdapter;
    }

    public static final /* synthetic */ Function1 access$getWindowManagerProvider$cp() {
        return windowManagerProvider;
    }

    @Override // u19.a
    public int getDisplayDuration() {
        return this.displayDuration;
    }

    @Override // u19.a
    public boolean getSupportLottie() {
        return this.supportLottie;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_obric_assistant_interaction_impl_toast_WindowToastHolder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static final /* synthetic */ void access$setLayoutParamsAdapter$cp(Function1 r100) {
        layoutParamsAdapter = r100;
    }

    public static final /* synthetic */ void access$setWindowManagerProvider$cp(Function1 r100) {
        windowManagerProvider = r100;
    }

    private final ToastSignature buildToastSignature(boolean r100) {
        if (getIconDrawable() == null) goto L5;
        return null;
    L5:
        if (getLottieConfig() == null) goto L8;
        return null;
    L8:
        return new ToastSignature(getText().toString(), normalizeIconDrawableRes(getIconDrawableRes()), getToastYOffsetPx(), r100);
    }

    private final WindowManager.LayoutParams createLayoutParams(Context r100) {
        WindowManager.LayoutParams r101 = new WindowManager.LayoutParams();
        r101.height = -2;
        r101.width = -1;
        r101.format = -3;
        r101.flags = 184;
        r101.type = WindowHost.INSTANCE.getWindowType(IKeyguardStateKt.getKeyguardState().isKeyguardLocked());
        r101.gravity = 87;
        r101.y = 0;
        r101.windowAnimations = R.style.OToastAnim;
        WindowUtils.INSTANCE.setTrustedOverlayReflectively(r101);
        return r101;
    }

    private final int getOToastShadowSpaceTop(Activity r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L19
        Iterator<T> r102 = l.g(r100, R.style.OUIShadow_3).iterator();     // Catch: Throwable -> L19
        if (r102.hasNext() == true) goto L6;
        Integer r103 = null;
    L13:
        Integer r104 = r103;     // Catch: Throwable -> L19
        if (r104 == null) goto L16;
        int r105 = r104.intValue();     // Catch: Throwable -> L19
    L17:
        Object r106 = Result.m9449constructorimpl(Integer.valueOf(r105));     // Catch: Throwable -> L19
    L21:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L26;
        FLogger.f375446a.d("ToastLogger", "WindowToastHolder get OToast shadow top skipped: " + r107.getMessage());
        r106 = 0;
    L26:
        return ((Number) r106).intValue();
    L16:
        r105 = 0;
        goto L17
    L6:
        q r108 = (q) r102.next();     // Catch: Throwable -> L19
        Integer r109 = Integer.valueOf(MathKt.roundToInt(r108.f399593b - r108.f399595d));     // Catch: Throwable -> L19
    L8:
        if (r102.hasNext() == false) goto L12;
        q r110 = (q) r102.next();     // Catch: Throwable -> L19
        Integer r111 = Integer.valueOf(MathKt.roundToInt(r110.f399593b - r110.f399595d));     // Catch: Throwable -> L19
        if (r109.compareTo(r111) >= 0) goto L8;
        r109 = r111;
        goto L8
    L12:
        r103 = r109;
    L19:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    private final int getToastCornerRadius(View r100) {
        return WindowOuiToastCompat.getCornerRadius(r100, dp(r100.getContext(), 24));
    }

    private final boolean isAppDarkMode(Context r100) {
        Lazy r101 = j.f559406a;
        int r102 = j.f559408c;
        if (r102 == (-1)) goto L10;
        if (r102 != 1) goto L6;
        return false;
    L6:
        if (r102 != 2) goto L15;
    L8:
        return true;
    L15:
        return false;
    L10:
        if ((r100.getResources().getConfiguration().uiMode & 48) == 32) goto L8;
        return false;
    }

    private final boolean isAttachedForToast(View r100) {
        if (r100.getParent() == null) goto L5;
    L8:
        return true;
    L5:
        if (r100.isAttachedToWindow() == true) goto L8;
        return false;
    }

    private static final Unit layoutParamsAdapter$lambda$17(WindowManager.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        LandscapeWindowToastBoundsAdapter.INSTANCE.applyIfNeeded$impl_mainlandRelease(r100);
        return Unit.INSTANCE;
    }

    private final int normalizeIconDrawableRes(int r100) {
        if (WARNING_ICON_DRAWABLE_RES.contains(Integer.valueOf(r100)) == false) goto L6;
        return 0;
    L6:
        return r100;
    }

    private final Activity resolveToastActivity(Context r100) {
        if ((r100 instanceof Activity) == false) goto L5;
        Activity r101 = (Activity) r100;
    L6:
        boolean r102 = true;
        if (r101 != null) goto L9;
    L18:
        r101 = AppHost.f326268a.a().getCurrentActivity();
        if (r101 != null) goto L21;
        return null;
    L21:
        if (r101.isFinishing() == false) goto L23;
    L25:
        r102 = false;
    L26:
        if (r102 == true) goto L28;
        return null;
    L28:
        return r101;
    L23:
        if (r101.isDestroyed() == true) goto L25;
    L9:
        if (r101.isFinishing() == false) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == true) goto L17;
        r101 = null;
    L17:
        if (r101 != null) goto L28;
    L11:
        if (r101.isDestroyed() == true) goto L13;
        r103 = true;
        goto L14
    L5:
        r101 = null;
        goto L6
    }

    private final void setupOuiToastBackground(View r100) {
        WindowOuiToastCompat.setupBackground(r100);
    }

    private static final WindowManager windowManagerProvider$lambda$18(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getApplicationContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.WindowManager");
        return (WindowManager) r101;
    }

    @Override // u19.a
    public void setDisplayDuration(int r100) {
        this.displayDuration = r100;
    }

    @Override // u19.f
    public void setDuration(int r100) {
        boolean r101 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r101 == false) goto L9;
        int r102 = 2000;
    L10:
        setDisplayDuration(r102);
        return;
    L9:
        r102 = 3500;
        goto L10
    L5:
        if (r100 >= 1501) goto L7;
        r101 = true;
        goto L7
    }

    private final View buildOuiToastLayout(Context r110, boolean r111) {
        Activity r100 = resolveToastActivity(r110);
        if (r100 != null) goto L6;
        FLogger.f375446a.e("ToastLogger", "WindowToastHolder build OToast failed: activity is null");
        return new FrameLayout(r110);
    L6:
        String r101 = getText().toString();
        int r112 = 0;
        if (r111 == false) goto L9;
        int r102 = 2;
    L10:
        f r103 = new f(r100, r101, 80, true, null, r102, 16);
        r103.f403704g.f403716f = getDisplayDuration();
        if (getIconDrawable() == null) goto L18;
        Drawable r113 = getIconDrawable();
        ImageView r104 = (ImageView) r103.f403709l.findViewById(R.id.iv_icon);
        if (r113 == null) goto L15;
        r104.setImageDrawable(r113);
        pla.j.f(r104);
    L16:
        r103.a();
    L21:
        View r114 = r103.f403709l;
        setupOuiToastBackground(r114);
        int r115 = dp(r110, 144);
        Integer r105 = getToastYOffsetPx();
        if (r105 == null) goto L25;
        r112 = r105.intValue();
    L25:
        return wrapWithOToastShadowFrame(r100, r114, r115 + r112);
    L15:
        pla.j.e(r104);
        goto L16
    L18:
        if (shouldShowIconDrawableRes() == false) goto L20;
        r103.b(Integer.valueOf(getIconDrawableRes()));
        goto L21
    L20:
        r103.b(null);
        goto L21
    L9:
        r102 = 0;
        goto L10
    }

    private final int dp(Context r100, int r101) {
        return (int) ((r101 * INVOKEVIRTUAL_com_obric_assistant_interaction_impl_toast_WindowToastHolder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f);
    }

    private final void scheduleAutoRemove(final View r100, final WindowManager r101) {
        Runnable r102 = this.removeRunnable;
        if (r102 == null) goto L6;
        this.mainHandler.removeCallbacks(r102);
    L6:
        if (getShouldAutoDisappear() == false) goto L9;
        long r103 = getDisplayDuration();
        Runnable r104 = new d(this, r100, r101);
        this.removeRunnable = r104;
        this.mainHandler.postDelayed(r104, r103);
        return;
    }

    private final void schedulePendingRemove(final View r100, final WindowManager r101) {
        flushPendingToast();
        final PendingToast r102 = new PendingToast(r100, r101, this.currentToastSignature, this.currentParamsSignature, this);
        Runnable r103 = new a(r102, this, r100, r101);
        r102.setRemoveRunnable(r103);
        pendingToast = r102;
        this.mainHandler.post(r103);
    }

    private final void showInternal(Context r110, boolean r111) {
        FLogger r100 = FLogger.f375446a;
        r100.d("ToastLogger", "WindowToastHolder showInternal start");
        if (r111 == false) goto L5;
    L8:
        boolean r112 = true;
    L9:
        WindowManager.LayoutParams r101 = createLayoutParams(r110);
        layoutParamsAdapter.invoke(r101);
        ToastSignature r102 = buildToastSignature(r112);
        WindowParamsSignature r103 = WindowParamsSignature.Companion.from(r101);
        if (tryAdoptPendingToast(r102, r103) == false) goto L12;
        return;
    L12:
        View r113 = ensureInstance(r110, null, getDisplayDuration(), r112);
        r113.setVisibility(0);
        flushPendingToast();     // Catch: Exception -> L15
        WindowManager r114 = windowManagerProvider.invoke(r110);     // Catch: Exception -> L15
        this.windowManager = r114;     // Catch: Exception -> L15
        r100.d("ToastLogger", "WindowToastHolder adding view to WM: " + r113);     // Catch: Exception -> L15
        INVOKEINTERFACE_com_obric_assistant_interaction_impl_toast_WindowToastHolder_com_obric_assistant_interaction_impl_window_helpers_WindowManagerLancet_addView(r114, r113, r101);     // Catch: Exception -> L15
        set_isShown(true);     // Catch: Exception -> L15
        this.currentToastSignature = r102;     // Catch: Exception -> L15
        this.currentParamsSignature = r103;     // Catch: Exception -> L15
        r100.d("ToastLogger", "WindowToastHolder addView success");     // Catch: Exception -> L15
        scheduleAutoRemove(r113, r114);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        FLogger.f375446a.e("ToastLogger", "WindowToastHolder addView failed", e);
        e.printStackTrace();
        setInstance(null);
        this.toastView = null;
        this.windowManager = null;
        this.removeRunnable = null;
        this.currentToastSignature = null;
        this.currentParamsSignature = null;
        set_isShown(false);
        clear();
        return;
    L5:
        if (isAppDarkMode(r110) == true) goto L8;
        r112 = false;
        goto L9
    }

    private final boolean tryAdoptPendingToast(ToastSignature r100, WindowParamsSignature r101) {
        PendingToast r102 = pendingToast;
        if (r102 != null) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
    L15:
        return false;
    L7:
        if (Intrinsics.areEqual(r102.getToastSignature(), r100) == false) goto L15;
        if (Intrinsics.areEqual(r102.getParamsSignature(), r101) == false) goto L15;
        if (isAttachedForToast(r102.getView()) == false) goto L15;
        r102.getOwner().mainHandler.removeCallbacks(r102.getRemoveRunnable());
        pendingToast = null;
        setInstance(r102.getView());
        this.toastView = r102.getView();
        this.windowManager = r102.getWindowManager();
        this.currentToastSignature = r100;
        this.currentParamsSignature = r101;
        set_isShown(true);
        scheduleAutoRemove(r102.getView(), r102.getWindowManager());
        FLogger.f375446a.d("ToastLogger", "WindowToastHolder adopt pending same toast");
        return true;
    }

    @Override // u19.a, u19.f
    public void show(Fragment r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Context r102 = r100.getContext();
        if (r102 == null) goto L6;
        super.show(r100, r101);
        showInternal(r102, r101);
        return;
    }

    @Override // u19.a
    public void show(Activity r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        super.show(r100, r101);
        showInternal(r100, r101);
    }

    @Override // u19.a, u19.f
    public void show(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.show(r100, r101);
        showInternal(r100, r101);
    }

    public static void INVOKEINTERFACE_com_obric_assistant_interaction_impl_toast_WindowToastHolder_com_obric_assistant_interaction_impl_window_helpers_WindowManagerLancet_addView(WindowManager r100, View r101, ViewGroup.LayoutParams r102) {
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r101, r102);
        r100.addView(r101, r102);
    }

    private final void removeViewIfNeeded(final View r100, final WindowManager r101, boolean r102) {
        if (r100.getParent() == null) goto L5;
    L8:
        if (r101 != null) goto L13;
        Object r103 = r100.getContext().getApplicationContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        if ((r103 instanceof WindowManager) == false) goto L12;
        r101 = (WindowManager) r103;
        goto L13
    L12:
        r101 = null;
    L13:
        if (r101 != null) goto L24;
        FLogger.f375446a.d("ToastLogger", "WindowToastHolder skip remove, windowManager is null");
        return;
    L24:
        r101.removeView(r100);     // Catch: Exception -> L18
        FLogger.f375446a.d("ToastLogger", "WindowToastHolder view removed");     // Catch: Exception -> L18
    L22:
        set_isShown(false);
        return;
    L18:
        e = move-exception;
        FLogger.f375446a.e("ToastLogger", "WindowToastHolder removeView failed", e);
        if (r102 == false) goto L22;
        this.mainHandler.postDelayed(new e(this, r100, r101), 16);
        goto L22
    L5:
        if (r100.isAttachedToWindow() == true) goto L8;
        FLogger.f375446a.d("ToastLogger", "WindowToastHolder skip remove, view not attached");
    }

    private static final void removeViewIfNeeded$lambda$16(WindowToastHolder r100, View r101, WindowManager r102) {
        r100.removeViewIfNeeded(r101, r102, false);
    }

    private static final void scheduleAutoRemove$lambda$7(WindowToastHolder r100, View r101, WindowManager r102) {
        removeViewIfNeeded$default(r100, r101, r102, false, 4, null);
        if (r100.getInstance() != r101) goto L5;
    L6:
        r100.setInstance(null);
        r100.toastView = null;
        r100.windowManager = null;
        r100.removeRunnable = null;
        r100.currentToastSignature = null;
        r100.currentParamsSignature = null;
        r100.set_isShown(false);
        r100.clear();
        return;
    L5:
        if (r100.toastView == r101) goto L6;
    }

    private final View wrapWithOToastShadowFrame(Activity r100, View r101, int r102) {
        View r103 = LayoutInflater.from(r100).inflate(R.layout.o_layout_popover_shadow_frame, null);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r104 = (ViewGroup) r103;
        r104.addView(r101, new FrameLayout.LayoutParams(-2, -2));
        WindowOuiToastCompat.setShadowCornerRadius(r104, getToastCornerRadius(r101));
        FrameLayout r105 = new FrameLayout(r100);
        r105.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        r105.setClipChildren(false);
        r105.setClipToPadding(false);
        r105.addView(r104, new FrameLayout.LayoutParams(-2, -2, 1));
        r105.setPadding(0, getOToastShadowSpaceTop(r100), 0, r102);
        return r105;
    }

    private static final void schedulePendingRemove$lambda$5(PendingToast r100, WindowToastHolder r101, View r102, WindowManager r103) {
        if (pendingToast != r100) goto L6;
        pendingToast = null;
        removeViewIfNeeded$default(r101, r102, r103, false, 4, null);
        return;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // u19.a
    public View newInstance(Context r100, LifecycleOwner r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r103 == false) goto L5;
    L8:
        boolean r104 = true;
    L9:
        View r105 = buildOuiToastLayout(r100, r104);
        this.toastView = r105;
        r105.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return r105;
    L5:
        if (isAppDarkMode(r100) == true) goto L8;
        r104 = false;
        goto L9
    }

    @Override // u19.a
    public /* bridge */ /* synthetic */ View newInstance(Context r100, LifecycleOwner r101, int r102, boolean r103) {
        return newInstance(r100, r101, r102, r103);
    }

    public static /* synthetic */ void removeViewIfNeeded$default(WindowToastHolder r100, View r101, WindowManager r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = true;
    L5:
        r100.removeViewIfNeeded(r101, r102, r103);
    }
}
