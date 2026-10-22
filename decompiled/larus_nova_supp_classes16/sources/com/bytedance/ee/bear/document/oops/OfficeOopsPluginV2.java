package com.bytedance.ee.bear.document.oops;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.y5;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.List;
import java.util.Map;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeOopsPluginV2 extends DocumentPluginV3 {
    private static final String HIDE_OOPS = "biz.util.hideOops";
    private static final String SHOW_OOPS = "biz.util.showOops";
    private static final String TAG = "OopsPluginV2";
    private int clickId;
    private UDDialog dialog;
    private MutableLiveData<Boolean> mIsClickRefresh;

    public class a implements i<Void> {
        public final /* synthetic */ OfficeOopsPluginV2 a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(OfficeOopsPluginV2 r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            Void r6 = (Void) r4;
            if (OfficeOopsPluginV2.access$200(this.a) != null) goto L5;
            return;
        L5:
            if (OfficeOopsPluginV2.access$200(this.a).isShowing() == false) goto L30;
            UDDialog r7 = OfficeOopsPluginV2.access$200(this.a);
            Handler r0 = DialogLancet.resolveDialogHandler(r7);
            if (r0 != null) goto L9;
        L11:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L14 Exception -> L16
        L20:
            DialogLancet.afterDialogDismiss(r7);
        L21:
            r5.b(new JSONObject());
            if (OfficeOopsPluginV2.access$600(this.a) != 0) goto L31;
            this.a.getIsClickRefresh().setValue(Boolean.TRUE);
            return;
        L31:
            return;
        L16:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
            if (r1 == null) goto L20;
            d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L9:
            if (Looper.myLooper() == r0.getLooper()) goto L11;
            r0.post(DialogLancet.createDismissRunnable(r7));
            goto L21
        }
    }

    public class b implements i<OopsModel> {
        public final int[] a;
        public final /* synthetic */ OfficeOopsPluginV2 b;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OfficeOopsPluginV2 r1) {
            this.b = r1;
            this.a = new int[]{2131391777, 2131391778, 2131391779, 2131391780};
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r9, final m r10) {
            OopsModel r11 = (OopsModel) r9;
            if (OfficeOopsPluginV2.access$200(this.b) != null) goto L5;
        L23:
            UDBaseDialogBuilder.ActionBottomOrientation r0 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
            List<OopsModel.Button> r1 = r11.getButtons();
            c r2 = c.a.a;
            if (r2.f("ccm.newerror.optimization") == false) goto L30;
            if (r1 != null) goto L27;
        L29:
            UDBaseDialogBuilder.ActionBottomOrientation r4 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
        L31:
            d35.a r5 = (d35.a) ((d35.a) new d35.a(OfficeOopsPluginV2.access$400(this.b)).controller(new d35.b(OfficeOopsPluginV2.access$300(this.b)))).contentLayoutRes(2131559991);
            if (r2.f("ccm.newerror.optimization") == false) goto L34;
            if (r4 == r0) goto L34;
        L35:
            tt5.a.h(OfficeOopsPluginV2.TAG, "handle oops data code:" + r11.getCode());
            d35.a r3 = (d35.a) ((d35.a) ((d35.a) r5.actionButtonOrientation(r4)).title(r11.getTitle())).message(r11.getContent());
            if (r11.isHideCode() == false) goto L38;
            String r12 = "";
        L39:
            r3.a = r12;
            d35.a r13 = (d35.a) r3.marginInDp(36);
            int r6 = 0;
            ((d35.a) r13.cancelOnTouchOutside(false)).autoDismiss(false);
            if (r1 != null) goto L42;
        L46:
            OfficeOopsPluginV2.access$202(this.b, r5.show());
            int r14 = h35.a.a;
            h35.a.a(this.b.getHost()).requestNotFocus(OfficeOopsPluginV2.access$500(this.b));
            return;
        L42:
            if (r6 >= r1.size()) goto L46;
            if (r6 >= this.a.length) goto L46;
            final OopsModel.Button r16 = (OopsModel.Button) ListProtector.get(r1, r6);
            r5.addActionButton(this.a[r6], r16.getText(), new d35.c(this, r16, r10));
            r6 = r6 + 1;
            goto L42
        L38:
            r12 = r11.getCode();
        L34:
            r5.footerLayoutRes(2131559992);
            goto L35
        L27:
            if (r1.size() <= 2) goto L29;
        L30:
            r4 = r0;
            goto L31
        L5:
            if (OfficeOopsPluginV2.access$200(this.b).isShowing() == false) goto L23;
            UDDialog r7 = OfficeOopsPluginV2.access$200(this.b);
            Handler r8 = DialogLancet.resolveDialogHandler(r7);
            if (r8 != null) goto L9;
        L11:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L14 Exception -> L16
        L20:
            DialogLancet.afterDialogDismiss(r7);
            goto L23
        L16:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
            Throwable r17 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
            if (r17 == null) goto L20;
            d.d(r17, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L9:
            if (Looper.myLooper() == r8.getLooper()) goto L11;
            r8.post(DialogLancet.createDismissRunnable(r7));
            goto L23
        }
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public MutableLiveData<Boolean> getIsClickRefresh() {
        if (this.mIsClickRefresh != null) goto L6;
        this.mIsClickRefresh = new MutableLiveData(Boolean.FALSE);
    L6:
        return this.mIsClickRefresh;
    }

    public OfficeOopsPluginV2() {
        this.clickId = -1;
    }

    public String getPluginId() {
        return y5.h;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_oops_OfficeOopsPluginV2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(UDDialog r3) {
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
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static /* synthetic */ UDDialog access$200(OfficeOopsPluginV2 r0) {
        return r0.dialog;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Context access$300(OfficeOopsPluginV2 r0) {
        return r0.getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Context access$400(OfficeOopsPluginV2 r0) {
        return r0.getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FragmentActivity access$500(OfficeOopsPluginV2 r0) {
        return r0.getActivity();
    }

    public static /* synthetic */ int access$600(OfficeOopsPluginV2 r0) {
        return r0.clickId;
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put(SHOW_OOPS, new b(this));
        r3.put(HIDE_OOPS, new a(this));
    }

    public static /* synthetic */ UDDialog access$202(OfficeOopsPluginV2 r0, UDDialog r1) {
        r0.dialog = r1;
        return r1;
    }

    public static /* synthetic */ int access$602(OfficeOopsPluginV2 r0, int r1) {
        r0.clickId = r1;
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
        UDDialog r3 = this.dialog;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isShowing() == false) goto L9;
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_oops_OfficeOopsPluginV2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.dialog);
        return;
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
