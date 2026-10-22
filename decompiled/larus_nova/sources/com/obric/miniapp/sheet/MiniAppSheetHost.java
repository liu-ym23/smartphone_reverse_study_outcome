package com.obric.miniapp.sheet;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.RenderType;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.miniapp.utils.c1;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import java.util.concurrent.atomic.AtomicBoolean;
import k2.n;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ.\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00190\u001b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00190\u001bJ\u0006\u0010\u001e\u001a\u00020\u0019J\u0010\u0010\u001f\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010\u0003J\b\u0010!\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/miniapp/sheet/MiniAppSheetHost;", "", "activity", "Landroid/app/Activity;", "appletRuntime", "Lcom/bytedance/ai/model/AppletRuntime;", "pageInfo", "Lcom/bytedance/ai/model/objects/PageInfo;", "config", "Lcom/obric/miniapp/sheet/MiniAppSheetHostConfig;", "<init>", "(Landroid/app/Activity;Lcom/bytedance/ai/model/AppletRuntime;Lcom/bytedance/ai/model/objects/PageInfo;Lcom/obric/miniapp/sheet/MiniAppSheetHostConfig;)V", "bodyContainer", "Landroid/widget/FrameLayout;", DocumentType.SHEET_NAME, "Lcom/obric/oui/sheet/v2/OSheet;", "destroyed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pageVisible", "", "page", "Lcom/obric/miniapp/sheet/MiniAppLynxSheetPage;", "closeMethodImpl", "Lcom/obric/miniapp/sheet/MiniAppSheetCloseMethodImpl;", "show", "", "onSuccess", "Lkotlin/Function1;", "", "onFailure", "dismiss", "activityMatches", "targetActivity", "viewId", "updateBodyHeight", "heightPx", "", "handleDismiss", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniAppSheetHost {
    public static final Companion Companion = null;
    private final Activity activity;
    private final AppletRuntime appletRuntime;
    private final FrameLayout bodyContainer;
    private MiniAppSheetCloseMethodImpl closeMethodImpl;
    private final MiniAppSheetHostConfig config;
    private final AtomicBoolean destroyed;
    private MiniAppLynxSheetPage page;
    private final PageInfo pageInfo;
    private boolean pageVisible;
    private final OSheet sheet;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JZ\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0010¨\u0006\u0013"}, d2 = {"Lcom/obric/miniapp/sheet/MiniAppSheetHost$Companion;", "", "<init>", "()V", "open", "", "activity", "Landroid/app/Activity;", "appletRuntime", "Lcom/bytedance/ai/model/AppletRuntime;", "pageInfo", "Lcom/bytedance/ai/model/objects/PageInfo;", "pageSettings", "Lcom/google/gson/JsonObject;", "sheetSettings", "onSuccess", "Lkotlin/Function1;", "", "onFailure", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void open(Activity r100, AppletRuntime r101, PageInfo r110, JsonObject r111, JsonObject r112, Function1<? super String, Unit> r113, Function1<? super String, Unit> r114) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "appletRuntime");
            Intrinsics.checkNotNullParameter(r110, "pageInfo");
            Intrinsics.checkNotNullParameter(r113, "onSuccess");
            Intrinsics.checkNotNullParameter(r114, "onFailure");
            if (Intrinsics.areEqual(n.b(r101.f36719h, r110), RenderType.LYNX.getTypeName()) == true) goto L6;
            r114.invoke("openSheetPage only supports Lynx pages");
            return;
        L6:
            new MiniAppSheetHost(r100, r101, r110, MiniAppSheetHostConfig.Companion.from(r111, r112), null).show(r113, r114);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[MiniAppSheetHeightMode.values().length];
            r100[MiniAppSheetHeightMode.WRAP_CONTENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ MiniAppSheetHost(Activity r100, AppletRuntime r101, PageInfo r102, MiniAppSheetHostConfig r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    public static /* synthetic */ void a(MiniAppSheetHost r100, DialogInterface r101) {
        show$lambda$1(r100, r101);
    }

    public static /* synthetic */ Unit b(MiniAppSheetHost r100, int r101) {
        return show$lambda$2(r100, r101);
    }

    public static /* synthetic */ Unit c(Function1 r100, MiniAppSheetHost r101, String r102) {
        return show$startCreatePageIfNeeded$lambda$6$lambda$5(r100, r101, r102);
    }

    public static /* synthetic */ Unit d(AtomicBoolean r100, MiniAppSheetHost r101, AtomicBoolean r102, AtomicBoolean r103, MiniAppLynxSheetPage r104, Function1 r105, Integer r106) {
        return show$startCreatePageIfNeeded$lambda$6$lambda$4(r100, r101, r102, r103, r104, r105, r106);
    }

    private final void handleDismiss() {
        if (this.destroyed.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        FLogger.f375446a.i("MiniAppSheetHost", "handleDismiss, page=" + this.pageInfo.getPageName());
        View r100 = this.bodyContainer.findFocus();
        if (r100 == null) goto L8;
        r100.clearFocus();
    L8:
        this.bodyContainer.clearFocus();
        MiniAppLynxSheetPage r101 = this.page;
        MiniAppSheetRegistry r102 = MiniAppSheetRegistry.INSTANCE;
        if (r101 == null) goto L11;
        String r103 = r101.getPageID();
    L12:
        r102.unregister(r103);
        MiniAppSheetCloseMethodImpl r104 = this.closeMethodImpl;
        if (r104 == null) goto L16;
        r104.restore();
    L16:
        if (this.pageVisible == false) goto L19;
        if (r101 == null) goto L19;
        r101.onHide();
    L19:
        if (r101 == null) goto L21;
        r101.onHostDestroy();
    L21:
        if (r101 == null) goto L23;
        r101.onDestroy();
    L23:
        this.page = null;
        this.closeMethodImpl = null;
        return;
    L11:
        r103 = null;
        goto L12
    }

    public final void dismiss() {
        if (this.destroyed.get() == false) goto L5;
        return;
    L5:
        FLogger.f375446a.i("MiniAppSheetHost", "dismiss requested, page=" + this.pageInfo.getPageName());
        View r100 = this.bodyContainer.findFocus();
        if (r100 == null) goto L8;
        r100.clearFocus();
    L8:
        this.bodyContainer.clearFocus();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        INVOKEVIRTUAL_com_obric_miniapp_sheet_MiniAppSheetHost_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.sheet);     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final String viewId() {
        MiniAppLynxSheetPage r100 = this.page;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPageID();
    }

    public static void INVOKEVIRTUAL_com_obric_miniapp_sheet_MiniAppSheetHost_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(OSheet r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void INVOKEVIRTUAL_com_obric_miniapp_sheet_MiniAppSheetHost_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(OSheet r100) {
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

    private final void updateBodyHeight(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        MiniAppSheetHeightMode r101 = this.config.getHeightMode();
        if (r101 != null) goto L7;
        int r102 = -1;
    L9:
        if (r102 != 1) goto L11;
        int r103 = RangesKt.coerceAtMost(r100, this.config.maxHeightPx(this.activity));
    L12:
        ViewGroup.LayoutParams r104 = this.bodyContainer.getLayoutParams();
        if (r104 != null) goto L16;
        return;
    L16:
        if (r104.height != r103) goto L18;
        return;
    L18:
        r104.height = r103;
        this.bodyContainer.setLayoutParams(r104);
        this.bodyContainer.requestLayout();
        return;
    L11:
        r103 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r100, this.config.minHeightPx(this.activity)), this.config.maxHeightPx(this.activity));
        goto L12
    L7:
        r102 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
        goto L9
    }

    public final boolean activityMatches(Activity r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100 == this.activity) goto L7;
        return false;
    }

    private static final void show$lambda$1(MiniAppSheetHost r100, DialogInterface r101) {
        r100.handleDismiss();
    }

    private static final Unit show$lambda$2(MiniAppSheetHost r100, int r101) {
        if (r100.config.shouldTrackContentHeight() == false) goto L6;
        r100.updateBodyHeight(r101);
    L6:
        return Unit.INSTANCE;
    }

    public final void show(final Function1<? super String, Unit> r110, final Function1<? super String, Unit> r210) {
        Intrinsics.checkNotNullParameter(r110, "onSuccess");
        Intrinsics.checkNotNullParameter(r210, "onFailure");
        this.config.applyTo(this.sheet, this.bodyContainer, this.activity);
        OSheet r100 = this.sheet;
        FrameLayout r101 = this.bodyContainer;
        r100.getClass();
        OSheetBase.DefaultImpls.j(r100, r101);
        this.sheet.setOnDismissListener(new h(this));
        final MiniAppLynxSheetPage r111 = new MiniAppLynxSheetPage(this.appletRuntime, this.pageInfo, this.bodyContainer, this.config.contentLayoutHeight(), new i(this));
        this.page = r111;
        MiniAppSheetCloseMethodImpl r102 = new MiniAppSheetCloseMethodImpl(this);
        r102.install();
        this.closeMethodImpl = r102;
        r111.warmUp();
        final AtomicBoolean r112 = new AtomicBoolean(false);
        final AtomicBoolean r113 = new AtomicBoolean(false);
        final AtomicBoolean r103 = new AtomicBoolean(false);
        final AtomicBoolean r104 = new AtomicBoolean(false);
        OSheet r105 = this.sheet;
        r105.f402893t = new AnonymousClass3(this, r112, r111, r113, r103, r104, r110, r210);
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L5
        INVOKEVIRTUAL_com_obric_miniapp_sheet_MiniAppSheetHost_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this.sheet);     // Catch: Throwable -> L5
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r107) == false) goto L19;
        this.page = null;
        MiniAppSheetCloseMethodImpl r108 = this.closeMethodImpl;
        if (r108 == null) goto L12;
        r108.restore();
    L12:
        this.closeMethodImpl = null;
        r111.onHostDestroy();
        r111.onDestroy();
        Throwable r109 = Result.m9452exceptionOrNullimpl(r107);
        if (r109 == null) goto L16;
        String r114 = r109.getMessage();
        if (r114 == null) goto L16;
    L17:
        r210.invoke(r114);
        return;
    L16:
        r114 = "show sheet failed";
        goto L17
    L19:
        this.config.applyWindowTo(this.sheet, this.activity);
        show$startCreatePageIfNeeded(this, r112, r111, r113, r103, r104, r110, r210);
        return;
    L5:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private static final Unit show$startCreatePageIfNeeded$lambda$6$lambda$5(Function1 r100, MiniAppSheetHost r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "message");
        r100.invoke(r102);
        r101.dismiss();
        return Unit.INSTANCE;
    }

    private MiniAppSheetHost(Activity r100, AppletRuntime r101, PageInfo r102, MiniAppSheetHostConfig r103) {
        this.activity = r100;
        this.appletRuntime = r101;
        this.pageInfo = r102;
        this.config = r103;
        FrameLayout r104 = new FrameLayout(r100);
        r104.setLayoutParams(new ViewGroup.LayoutParams(-1, r103.initialBodyHeight(r100)));
        this.bodyContainer = r104;
        this.sheet = c1.a(r100, 0);
        this.destroyed = new AtomicBoolean(false);
    }

    public static final /* synthetic */ void access$show$dispatchReadyIfNeeded(MiniAppSheetHost r100, AtomicBoolean r101, AtomicBoolean r102, AtomicBoolean r103, MiniAppLynxSheetPage r104, Function1 r105) {
        show$dispatchReadyIfNeeded(r100, r101, r102, r103, r104, r105);
    }

    private static final void show$dispatchReadyIfNeeded(MiniAppSheetHost r100, AtomicBoolean r101, AtomicBoolean r102, AtomicBoolean r103, MiniAppLynxSheetPage r104, Function1<? super String, Unit> r105) {
        if (r100.destroyed.get() == false) goto L5;
        return;
    L5:
        if (r101.get() == true) goto L7;
        return;
    L7:
        if (r102.get() == true) goto L10;
        return;
    L10:
        if (r103.compareAndSet(false, true) == true) goto L12;
        return;
    L12:
        r100.pageVisible = true;
        MiniAppSheetRegistry.INSTANCE.register(r100);
        r104.onShow();
        r105.invoke(r104.getPageID());
    }

    private static final Unit show$startCreatePageIfNeeded$lambda$6$lambda$4(AtomicBoolean r100, MiniAppSheetHost r101, AtomicBoolean r102, AtomicBoolean r103, MiniAppLynxSheetPage r110, Function1 r111, Integer r112) {
        r100.set(true);
        show$dispatchReadyIfNeeded(r101, r100, r102, r103, r110, r111);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$show$startCreatePageIfNeeded(MiniAppSheetHost r100, AtomicBoolean r101, MiniAppLynxSheetPage r102, AtomicBoolean r103, AtomicBoolean r104, AtomicBoolean r105, Function1 r106, Function1 r107) {
        show$startCreatePageIfNeeded(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    private static final void show$startCreatePageIfNeeded(final MiniAppSheetHost r110, AtomicBoolean r111, final MiniAppLynxSheetPage r112, final AtomicBoolean r113, final AtomicBoolean r114, final AtomicBoolean r115, final Function1<? super String, Unit> r116, final Function1<? super String, Unit> r117) {
        if (r110.destroyed.get() == false) goto L5;
        return;
    L5:
        if (r111.compareAndSet(false, true) == false) goto L22;
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
        Object r101 = Result.m9449constructorimpl(r112.createPage(r110.pageInfo, r110.activity, new j(r113, r110, r114, r115, r112, r116), new k(r117, r110)));     // Catch: Throwable -> L9
    L11:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L21;
        String r103 = r102.getMessage();
        if (r103 != null) goto L16;
        r103 = "create sheet page failed";
    L16:
        r117.invoke(r103);
        r110.dismiss();
        return;
    L21:
        return;
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
