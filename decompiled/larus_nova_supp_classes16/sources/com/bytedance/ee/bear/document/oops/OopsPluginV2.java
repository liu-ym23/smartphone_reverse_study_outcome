package com.bytedance.ee.bear.document.oops;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.j5;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import d35.e;
import d35.f;
import java.util.List;
import java.util.Map;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OopsPluginV2 extends DocumentPlugin {
    private static final String HIDE_OOPS = "biz.util.hideOops";
    private static final String SHOW_OOPS = "biz.util.showOops";
    private static final String TAG = "OopsPluginV2";
    private int clickId;
    private UDDialog dialog;
    private MutableLiveData<Boolean> mIsClickRefresh;

    public class a implements i<Void> {
        public final /* synthetic */ OopsPluginV2 a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(OopsPluginV2 r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            Void r6 = (Void) r4;
            if (OopsPluginV2.access$200(this.a) != null) goto L5;
            return;
        L5:
            if (OopsPluginV2.access$200(this.a).isShowing() == false) goto L30;
            UDDialog r7 = OopsPluginV2.access$200(this.a);
            Handler r0 = DialogLancet.resolveDialogHandler(r7);
            if (r0 != null) goto L9;
        L11:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L14 Exception -> L16
        L20:
            DialogLancet.afterDialogDismiss(r7);
        L21:
            r5.b(new JSONObject());
            if (OopsPluginV2.access$600(this.a) != 0) goto L31;
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
        public final /* synthetic */ OopsPluginV2 b;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OopsPluginV2 r1) {
            this.b = r1;
            this.a = new int[]{2131391777, 2131391778, 2131391779, 2131391780};
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // tb5.i, tb5.o
        public final void handle(Object r7, final m r8) {
            OopsModel r9 = (OopsModel) r7;
            if (OopsPluginV2.access$200(this.b) != null) goto L5;
        L23:
            UDBaseDialogBuilder.ActionBottomOrientation r0 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
            List<OopsModel.Button> r1 = r9.getButtons();
            if (j5.a() == false) goto L30;
            if (r1 != null) goto L27;
        L29:
            UDBaseDialogBuilder.ActionBottomOrientation r2 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
        L31:
            d35.d r3 = (d35.d) ((d35.d) new d35.d(OopsPluginV2.access$400(this.b)).controller(new e(OopsPluginV2.access$300(this.b)))).contentLayoutRes(2131568090);
            if (j5.a() == false) goto L34;
            if (r2 == r0) goto L34;
        L35:
            tt5.a.h(OopsPluginV2.TAG, "handle oops data code:" + r9.getCode());
            d35.d r4 = (d35.d) ((d35.d) ((d35.d) r3.actionButtonOrientation(r2)).title(r9.getTitle())).message(r9.getContent());
            if (r9.isHideCode() == false) goto L38;
            String r10 = "";
        L39:
            r4.a = r10;
            d35.d r11 = (d35.d) r4.marginInDp(36);
            int r5 = 0;
            ((d35.d) r11.cancelOnTouchOutside(false)).autoDismiss(false);
            if (r1 != null) goto L42;
        L46:
            OopsPluginV2.access$202(this.b, r3.show());
            ((DocumentPluginHost) this.b.getHost()).b().requestNotFocus(OopsPluginV2.access$500(this.b));
            return;
        L42:
            if (r5 >= r1.size()) goto L46;
            if (r5 >= this.a.length) goto L46;
            final OopsModel.Button r12 = (OopsModel.Button) ListProtector.get(r1, r5);
            r3.addActionButton(this.a[r5], r12.getText(), new f(this, r12, r8));
            r5 = r5 + 1;
            goto L42
        L38:
            r10 = r9.getCode();
        L34:
            r3.footerLayoutRes(2131568091);
            goto L35
        L27:
            if (r1.size() <= 2) goto L29;
        L30:
            r2 = r0;
            goto L31
        L5:
            if (OopsPluginV2.access$200(this.b).isShowing() == false) goto L23;
            UDDialog r6 = OopsPluginV2.access$200(this.b);
            Handler r13 = DialogLancet.resolveDialogHandler(r6);
            if (r13 != null) goto L9;
        L11:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L14 Exception -> L16
        L20:
            DialogLancet.afterDialogDismiss(r6);
            goto L23
        L16:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
            Throwable r14 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
            if (r14 == null) goto L20;
            d.d(r14, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L9:
            if (Looper.myLooper() == r13.getLooper()) goto L11;
            r13.post(DialogLancet.createDismissRunnable(r6));
            goto L23
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public MutableLiveData<Boolean> getIsClickRefresh() {
        if (this.mIsClickRefresh != null) goto L6;
        this.mIsClickRefresh = new MutableLiveData(Boolean.FALSE);
    L6:
        return this.mIsClickRefresh;
    }

    public OopsPluginV2() {
        this.clickId = -1;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_oops_OopsPluginV2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(UDDialog r3) {
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

    public static /* synthetic */ UDDialog access$200(OopsPluginV2 r0) {
        return r0.dialog;
    }

    public static /* synthetic */ Context access$300(OopsPluginV2 r0) {
        return r0.getContext();
    }

    public static /* synthetic */ Context access$400(OopsPluginV2 r0) {
        return r0.getContext();
    }

    public static /* synthetic */ FragmentActivity access$500(OopsPluginV2 r0) {
        return r0.getActivity();
    }

    public static /* synthetic */ int access$600(OopsPluginV2 r0) {
        return r0.clickId;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put(SHOW_OOPS, new b(this));
        r3.put(HIDE_OOPS, new a(this));
    }

    public static /* synthetic */ UDDialog access$202(OopsPluginV2 r0, UDDialog r1) {
        r0.dialog = r1;
        return r1;
    }

    public static /* synthetic */ int access$602(OopsPluginV2 r0, int r1) {
        r0.clickId = r1;
        return r1;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        UDDialog r3 = this.dialog;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isShowing() == false) goto L9;
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_oops_OopsPluginV2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.dialog);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
