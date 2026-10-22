package f45;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.toast.OfficeToastPlugin;
import com.bytedance.ee.bear.document.toast.ToastModel;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends vv4.a {
    public boolean a;

    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ d a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r1) {
        }

        public a(d r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
            if (this.a.a == false) goto L6;
            Toast.cancelLoading();
            return;
        }
    }

    public class b implements i<String> {
        public final /* synthetic */ d a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(d r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            tt5.a.h(OfficeToastPlugin.TAG, "Hide toast");
            Toast.cancelLoading();
            Toast.cancel();
            this.a.a = false;
        }
    }

    public class c implements i<ToastModel> {
        public final /* synthetic */ d a;

        public class a implements UDToast.b {
            public final /* synthetic */ m a;

            public a(m r1) {
                this.a = r1;
            }

            public final void a(com.ss.android.lark.compose.foundation.toast.b r3) {
                this.a.b(new JSONObject());
                r3.cancel();
            }
        }

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(d r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r8, m r9) {
            ToastModel r10 = (ToastModel) r8;
            tt5.a.h(OfficeToastPlugin.TAG, "Show toast:" + r10);
            if (this.a.getWeb() != null) goto L5;
        L9:
            boolean r0 = false;
        L11:
            if (this.a.isVisibleToUser() == false) goto L43;
            if (r0 == true) goto L43;
            if (r10 != null) goto L16;
            return;
        L16:
            if (TextUtils.isEmpty(r10.message) == false) goto L18;
            return;
        L18:
            if (r10.duration >= 3) goto L20;
            int r1 = -1;
        L22:
            switch(r10.type) {
                case 0: goto L42;
                case 1: goto L41;
                case 2: goto L40;
                case 3: goto L40;
                case 4: goto L40;
                case 5: goto L39;
                case 6: goto L38;
                case 7: goto L37;
                case 8: goto L45;
                case 9: goto L24;
                default: goto L57;
            };
        L24:
            a(r10, Toast.getWarningIcon(), r9);
            return;
        L37:
            Toast.showWarningText(this.a.getContext(), r10.message, r1);
            return;
        L38:
            a(r10, -1, r9);
            return;
        L39:
            a(r10, Toast.getSuccessIcon(), r9);
            return;
        L40:
            Toast.showText(this.a.getContext(), r10.message, r1);
            return;
        L41:
            Toast.showFailureText(this.a.getContext(), r10.message, r1);
            return;
        L42:
            Toast.showSuccessText(this.a.getContext(), r10.message, r1);
            return;
        L45:
            Activity r11 = ((h) org.koin.java.a.a(h.class)).getCurrentActivity();     // Catch: Exception -> L36
            if (r11 != null) goto L28;
        L34:
            tt5.a.d(OfficeToastPlugin.TAG, "show loading toast activity null");     // Catch: Exception -> L36
            return;
        L28:
            if (n.A(r11) == false) goto L34;
            int r2 = r10.duration;     // Catch: Exception -> L36
            if (r2 <= 0) goto L32;
            Toast.showLoading(r11, r10.message, ((long) r2) * 1000);     // Catch: Exception -> L36
        L33:
            this.a.a = true;     // Catch: Exception -> L36
            return;
        L32:
            Toast.showLoading(r11, r10.message);     // Catch: Exception -> L36
        L36:
            tt5.a.d(OfficeToastPlugin.TAG, "show loading toast exception");
            return;
        L57:
            return;
        L20:
            r1 = -2;
        L43:
            tt5.a.k(OfficeToastPlugin.TAG, "Ignore show toast because not visible ");
            return;
        L5:
            if (this.a.getWeb().getWebView() == null) goto L9;
            if (this.a.getWeb().getWebView().getWindowVisibility() == 0) goto L9;
            r0 = true;
            goto L11
        }

        public final void a(ToastModel r7, int r8, m r9) {
            Activity r0 = AppLifecycle.a.a.f();
            if (n.A(r0) == true) goto L6;
            tt5.a.k(OfficeToastPlugin.TAG, "Activity is not running.");
            return;
        L6:
            tt5.a.k(OfficeToastPlugin.TAG, "Activity : ".concat(r0.getClass().getSimpleName()));
            View r1 = r0.getWindow().getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L12;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r3 = ThreadMethodProxy.currentThread();
            if (r3 == com.larus.home.impl.utils.c.a) goto L12;
            com.larus.home.impl.utils.c.a(r3, "getDecorView");
        L12:
            if (r1.findViewById(2131382479) != null) goto L15;
            tt5.a.k(OfficeToastPlugin.TAG, "DocumentFragment is not found.");
            return;
        L15:
            UDToast.a r2 = UDToast.build(r0);
            if (r8 == (-1)) goto L19;
            r2.d(r8);
        L19:
            if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mention.optimizing_authorizaiton") == false) goto L32;
            int r10 = r7.duration;
            if (r10 != 0) goto L23;
        L25:
            pcb.a r11 = pcb.a.a.b(r0);
            if (r11.isKeyboardShowing() == false) goto L32;
            if (n.D(r0) == false) goto L32;
            if (cu5.c.e(r0) == false) goto L32;
            int r12 = r11.getVisibleKeyboardHeight();
            r2.b.c(80, 0, r12);
            goto L32
        L23:
            if (r10 >= 10) goto L25;
            r2.b.d = ((long) r10) * 1000;
        L32:
            String r13 = r7.message;
            if (r13 != null) goto L35;
            return;
        L35:
            if (r7.buttonMessage == null) goto L39;
            r2.g(r13);
            r2.c(r7.buttonMessage, new a(r9));
            r2.h();
            return;
        }
    }

    public d() {
        this.a = false;
    }

    @Override // vv4.a
    public final void onAttachToWeb(k r4) {
        super.onAttachToWeb(r4);
        r4.getWebView().addOnAttachStateChangeListener(new a(this));
        bindBridgeHandlerAutoUnbind("biz.util.showToast", new c(this));
        bindBridgeHandlerAutoUnbind("biz.util.hideToast", new b(this));
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.storage.edit_limit_popup") == true) goto L6;
        bindBridgeHandlerAutoUnbind("biz.util.showFullQuoteDialog", new com.bytedance.ee.bear.document.alert.a("webview", -1, null, null));
        return;
    }

    @Override // vv4.a, vv4.m
    public final void onDetachFromWeb(k r1) {
        super.onDetachFromWeb(r1);
    }
}
