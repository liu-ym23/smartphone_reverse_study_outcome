package com.bytedance.ee.bear.document.loading;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import androidx.core.graphics.ColorUtils;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionPayLoadData;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Map;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SmallLoadingPlugin extends DocumentPlugin {
    public static final int DURATION_MAX = Integer.MAX_VALUE;
    private static final String HIDE_SMALL_LOADING = "biz.util.hideSmallLoading";
    private static final String SHOW_SMALL_LOADING = "biz.util.showSmallLoading";
    private static final String TAG = "SmallLoadingPlugin";
    private Dialog overlayDialog;
    public com.larksuite.component.universe_design.toast.c udToast;

    public static final enum Gravity extends Enum<Gravity> {
        public static final /* synthetic */ Gravity[] a = null;
        public static final Gravity bottom = null;
        public static final Gravity center = null;
        public static final Gravity top = null;

        static {
            Gravity r0 = new Gravity("top", 0);
            top = r0;
            Gravity r1 = new Gravity(CustomHeaderConfig.TitleConfig.Position.CENTER, 1);
            center = r1;
            Gravity r3 = new Gravity("bottom", 2);
            bottom = r3;
            a = new Gravity[]{r0, r1, r3};
        }

        public static Gravity[] values() {
            return (Gravity[]) a.clone();
        }

        public static Gravity valueOf(String r1) {
            return (Gravity) r27.a.a(Gravity.class, r1);
        }

        public Gravity(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static class LoadingParam implements BaseJSModel {
        public Boolean disableUserInteraction;
        public Gravity gravity;
        public String msg;

        public LoadingParam() {
            this.disableUserInteraction = Boolean.FALSE;
        }
    }

    public class a implements i<Void> {
        public final /* synthetic */ SmallLoadingPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(SmallLoadingPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            Void r3 = (Void) r1;
            SmallLoadingPlugin.access$400(this.a);
        }
    }

    public class b implements i<LoadingParam> {
        public final /* synthetic */ SmallLoadingPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(SmallLoadingPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            LoadingParam r6 = (LoadingParam) r4;
            if (r6 != null) goto L5;
        L11:
            tt5.a.f(SmallLoadingPlugin.TAG, new IllegalArgumentException("Bad show loading param"), false);
            return;
        L5:
            if (TextUtils.isEmpty(r6.msg) == true) goto L11;
            SmallLoadingPlugin r7 = this.a;
            Context r0 = SmallLoadingPlugin.access$200(r7);
            String r1 = r6.msg;
            Gravity r2 = r6.gravity;
            if (r2 != null) goto L10;
            r2 = Gravity.bottom;
        L10:
            SmallLoadingPlugin.access$300(r7, r0, r1, r2, r6.disableUserInteraction);
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void hideLoading() {
        com.larksuite.component.universe_design.toast.c r0 = this.udToast;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.cancel();
        this.udToast = null;
        Dialog r1 = this.overlayDialog;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.isShowing() == false) goto L12;
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_loading_SmallLoadingPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.overlayDialog);
        return;
    }

    public SmallLoadingPlugin() {
        this.udToast = null;
        this.overlayDialog = null;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_loading_SmallLoadingPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(Dialog r3) {
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
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_loading_SmallLoadingPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(Dialog r1) {
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

    public static /* synthetic */ Context access$200(SmallLoadingPlugin r0) {
        return r0.getContext();
    }

    public static /* synthetic */ void access$400(SmallLoadingPlugin r0) {
        r0.hideLoading();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put(SHOW_SMALL_LOADING, new b(this));
        r3.put(HIDE_SMALL_LOADING, new a(this));
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        hideLoading();
        this.overlayDialog = null;
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    private void showLoading(Context r3, String r4, Gravity r5, Boolean r6) {
        if (com.bytedance.ee.util.ui.b.b(r3) == true) goto L6;
        tt5.a.d(TAG, "Bad show loading param , context is not active");
        return;
    L6:
        if (r6 != null) goto L8;
    L13:
        com.larksuite.component.universe_design.toast.c r7 = this.udToast;
        if (r7 == null) goto L16;
        r7.cancel();
        this.udToast = null;
    L16:
        CircularProgressDrawable r8 = new CircularProgressDrawable(r3);
        r8.setStyle(1);
        int[] r9 = new int[1];
        if (en4.a.l() == false) goto L19;
        int r0 = 2131102418;
    L20:
        r9[0] = UDColorUtils.getColor(r3, r0);
        r8.setColorSchemeColors(r9);
        r8.setStrokeCap(Paint.Cap.ROUND);
        if (TextUtils.isEmpty(r4) == false) goto L23;
        r4 = "";
    L23:
        UDToast.a r10 = UDToast.build(r3);
        r10.g(r4);
        r10.e(r8);
        r10.b.d = 2147483647L;
        com.ss.android.lark.compose.foundation.toast.g r11 = r10.a();
        this.udToast = r11;
        r11.show();
        return;
    L19:
        r0 = 2131106521;
        goto L20
    L8:
        if (r6.booleanValue() == false) goto L13;
        Dialog r12 = new Dialog(r3, R.style.Theme.Translucent.NoTitleBar);
        this.overlayDialog = r12;
        Window r13 = r12.getWindow();
        if (r13 == null) goto L12;
        r13.setLayout(-1, -1);
        r13.setFlags(8, 8);
        r13.setBackgroundDrawable(new ColorDrawable(ColorUtils.setAlphaComponent(getContext().getResources().getColor(2131100548), VersionPayLoadData.OPERATION_DELETE)));
    L12:
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_loading_SmallLoadingPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this.overlayDialog);
        goto L13
    }

    public static /* synthetic */ void access$300(SmallLoadingPlugin r0, Context r1, String r2, Gravity r3, Boolean r4) {
        r0.showLoading(r1, r2, r3, r4);
    }
}
