package com.bytedance.ee.bear.document.plugin.permission;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0002\u000b\fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/document/plugin/permission/ApplyEditPermissionPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePluginV2;", "Lcom/bytedance/ee/bear/browser/plugin/lazy/BridgeInteractivePlugin;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Companion", "ApplyEditPermissionHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplyEditPermissionPlugin extends BasePluginV2 implements yv4.a {
    public static final b Companion = null;
    private static final String TAG = "ApplyEditPermissionPlugin";

    public final class a implements i<ApplyEditPermissionModel> {
        public final /* synthetic */ ApplyEditPermissionPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(ApplyEditPermissionPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r13, m r14) {
            ApplyEditPermissionModel r16 = (ApplyEditPermissionModel) r13;
            if (r16 != null) goto L5;
            tt5.a.d(ApplyEditPermissionPlugin.TAG, "handle failed: request data is null");
            return;
        L5:
            String r0 = r16.getToken();
            boolean r1 = true;
            if (r0 != null) goto L8;
        L17:
            String r7 = "";
        L18:
            Integer r2 = Integer.valueOf(r16.getType());
            if (r2.intValue() <= 0) goto L21;
            boolean r5 = true;
        L22:
            if (r5 == true) goto L25;
            r2 = null;
        L25:
            if (r2 == null) goto L27;
            int r8 = r2.intValue();
        L29:
            if (r7.length() == 0) goto L32;
            r1 = false;
        L32:
            if (r1 == false) goto L34;
            tt5.a.d(ApplyEditPermissionPlugin.TAG, "handle failed: token is empty");
            return;
        L34:
            if (r8 > 0) goto L36;
            tt5.a.d(ApplyEditPermissionPlugin.TAG, "handle failed: unsupported type=" + r16.getType() + ", token=" + StringsKt.take(r7, 4) + "***");
            return;
        L36:
            PluginHost r3 = this.a.getHost();
            if (r3 == null) goto L50;
            FragmentActivity r6 = r3.getActivity();
            if (r6 == null) goto L50;
            zt5.a r9 = (zt5.a) org.koin.java.a.c(zt5.a.class, null, null, 6);
            String r17 = r16.getOwnerId();
            if (r17 != null) goto L44;
            String r10 = "";
        L45:
            String r18 = r16.getOwnerName();
            if (r18 != null) goto L48;
            String r11 = "";
        L49:
            r9.F0(r6, r7, r8, r10, r11, sbb.e.c(r8));
            return;
        L48:
            r11 = r18;
            goto L49
        L44:
            r10 = r17;
        L50:
            tt5.a.d(ApplyEditPermissionPlugin.TAG, "handle failed: activity is null");
            return;
        L27:
            r8 = -1;
            goto L29
        L21:
            r5 = false;
            goto L22
        L8:
            if (r0.length() <= 0) goto L10;
            boolean r12 = true;
        L11:
            if (r12 == true) goto L14;
            r0 = null;
        L14:
            if (r0 == null) goto L17;
            r7 = r0;
            goto L18
        L10:
            r12 = false;
            goto L11
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public ApplyEditPermissionPlugin() {
    }

    @Override // yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.util.applyEditPermission", new a(this));
    }
}
