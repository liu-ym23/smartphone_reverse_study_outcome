package com.bytedance.ee.bear.document.toast;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import com.bytedance.ee.bear.document.y5;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0003\u0012\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\tH\u0016J\u001c\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/document/toast/OfficeToastPlugin;", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "<init>", "()V", "showLoading", "", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onDetachFromUIContainer", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "getPluginId", "Companion", "ShowToastHandler", "HideToastHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeToastPlugin extends AbsChameleonPlugin {
    public static final a Companion = null;
    public static final String TAG = "ToastWebService";
    private boolean showLoading;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<String> {
        public final /* synthetic */ OfficeToastPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OfficeToastPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            tt5.a.h(OfficeToastPlugin.TAG, "Hide toast");
            Toast.cancelLoading();
            Toast.cancel();
            OfficeToastPlugin.access$setShowLoading$p(this.a, false);
        }
    }

    public final class c implements i<ToastModel> {
        public final /* synthetic */ OfficeToastPlugin a;

        public static final class a implements UDToast.b {
            public final /* synthetic */ m a;

            public a(m r1) {
                this.a = r1;
            }

            public final void a(com.ss.android.lark.compose.foundation.toast.b r3) {
                Intrinsics.checkNotNullParameter(r3, "udToast");
                this.a.b(new JSONObject());
                r3.cancel();
            }
        }

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(OfficeToastPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r8, m r9) {
            ToastModel r10 = (ToastModel) r8;
            Intrinsics.checkNotNullParameter(r9, "callback");
            tt5.a.h(OfficeToastPlugin.TAG, "Show toast:" + r10);
            if (this.a.getHost().getWeb().getWebView().getWindowVisibility() == 0) goto L5;
            boolean r0 = true;
        L7:
            if (OfficeToastPlugin.access$isVisibleToUser(this.a) == false) goto L39;
            if (r0 == true) goto L39;
            if (r10 != null) goto L12;
            return;
        L12:
            if (TextUtils.isEmpty(r10.message) == false) goto L14;
            return;
        L14:
            if (r10.duration >= 3) goto L16;
            int r1 = -1;
        L18:
            switch(r10.type) {
                case 0: goto L38;
                case 1: goto L37;
                case 2: goto L36;
                case 3: goto L36;
                case 4: goto L36;
                case 5: goto L35;
                case 6: goto L34;
                case 7: goto L33;
                case 8: goto L41;
                case 9: goto L20;
                default: goto L53;
            };
        L20:
            a(r10, Toast.getWarningIcon(), r9);
            return;
        L33:
            Toast.showWarningText(OfficeToastPlugin.access$getContext(this.a), r10.message, r1);
            return;
        L34:
            a(r10, -1, r9);
            return;
        L35:
            a(r10, Toast.getSuccessIcon(), r9);
            return;
        L36:
            Toast.showText(OfficeToastPlugin.access$getContext(this.a), r10.message, r1);
            return;
        L37:
            Toast.showFailureText(OfficeToastPlugin.access$getContext(this.a), r10.message, r1);
            return;
        L38:
            Toast.showSuccessText(OfficeToastPlugin.access$getContext(this.a), r10.message, r1);
            return;
        L41:
            Activity r11 = ((h) org.koin.java.a.c(h.class, null, null, 6)).getCurrentActivity();     // Catch: Exception -> L32
            if (r11 != null) goto L24;
        L30:
            tt5.a.d(OfficeToastPlugin.TAG, "show loading toast activity null");     // Catch: Exception -> L32
            return;
        L24:
            if (n.A(r11) == false) goto L30;
            int r2 = r10.duration;     // Catch: Exception -> L32
            if (r2 <= 0) goto L28;
            Toast.showLoading(r11, r10.message, ((long) r2) * 1000);     // Catch: Exception -> L32
        L29:
            OfficeToastPlugin.access$setShowLoading$p(this.a, true);     // Catch: Exception -> L32
            return;
        L28:
            Toast.showLoading(r11, r10.message);     // Catch: Exception -> L32
        L32:
            tt5.a.d(OfficeToastPlugin.TAG, "show loading toast exception");
            return;
        L53:
            return;
        L16:
            r1 = -2;
        L39:
            tt5.a.k(OfficeToastPlugin.TAG, "Ignore show toast because not visible ");
            return;
        L5:
            r0 = false;
            goto L7
        }

        public final void a(ToastModel r7, int r8, m r9) {
            Intrinsics.checkNotNullParameter(r7, "data");
            Intrinsics.checkNotNullParameter(r9, "callback");
            Context r0 = OfficeToastPlugin.access$getContext(this.a);
            if ((r0 instanceof Activity) == false) goto L5;
            Activity r1 = (Activity) r0;
        L7:
            if (n.A(r1) == true) goto L10;
            tt5.a.k(OfficeToastPlugin.TAG, "Activity is not running.");
            return;
        L10:
            Intrinsics.checkNotNull(r1);
            tt5.a.k(OfficeToastPlugin.TAG, "Activity : ".concat(r1.getClass().getSimpleName()));
            View r2 = r1.getWindow().getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L16;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r3 = ThreadMethodProxy.currentThread();
            if (r3 == com.larus.home.impl.utils.c.a) goto L16;
            com.larus.home.impl.utils.c.a(r3, "getDecorView");
        L16:
            if (r2.findViewById(2131382479) != null) goto L19;
            tt5.a.k(OfficeToastPlugin.TAG, "DocumentFragment is not found.");
            return;
        L19:
            UDToast.a r4 = UDToast.build(r1);
            if (r8 == (-1)) goto L23;
            r4.d(r8);
        L23:
            if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mention.optimizing_authorizaiton") == false) goto L36;
            int r10 = r7.duration;
            if (r10 != 0) goto L27;
        L29:
            pcb.a r11 = pcb.a.a.b(r1);
            if (r11.isKeyboardShowing() == false) goto L36;
            if (n.D(r1) == false) goto L36;
            if (cu5.c.e(r1) == false) goto L36;
            int r12 = r11.getVisibleKeyboardHeight();
            r4.b.c(80, 0, r12);
            goto L36
        L27:
            if (r10 >= 10) goto L29;
            r4.b.d = ((long) r10) * ((long) UploadResult.UPLOAD_CACELL);
        L36:
            String r13 = r7.message;
            if (r13 != null) goto L39;
            return;
        L39:
            if (r7.buttonMessage == null) goto L43;
            r4.g(r13);
            r4.c(r7.buttonMessage, new a(r9));
            r4.h();
            return;
        L43:
            return;
        L5:
            r1 = AppLifecycle.a.a.f();
            goto L7
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public String getPluginId() {
        String r0 = y5.a;
        return y5.d;
    }

    public OfficeToastPlugin() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ Context access$getContext(OfficeToastPlugin r0) {
        return r0.getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ boolean access$isVisibleToUser(OfficeToastPlugin r0) {
        return r0.isVisibleToUser();
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        r3.put("biz.util.showToast", new c(this));
        r3.put("biz.util.hideToast", new b(this));
    }

    public static final /* synthetic */ void access$setShowLoading$p(OfficeToastPlugin r0, boolean r1) {
        r0.showLoading = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
        if (this.showLoading == false) goto L6;
        Toast.cancelLoading();
        return;
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
