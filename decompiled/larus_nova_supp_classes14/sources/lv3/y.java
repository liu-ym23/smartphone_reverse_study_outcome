package lv3;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.platform.api.f2;
import com.larus.platform.api.l2;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.i3;
import com.larus.platform.service.l0;
import com.larus.utils.o0;
import com.larus.utils.t0;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@XBridgeMethod(name = "flow.openECommerce")
public final class y extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeMethodName(name = "flow.openECommerce", params = {"eCommerceSchema", "defaultSchema", "btm", "bcm", "currentPage", "source"})
    public final String a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "bcm", required = true)
        Map<String, Object> getBcm();

        @XBridgeParamField(isGetter = true, keyPath = "btm", required = true)
        String getBtm();

        @XBridgeParamField(isGetter = true, keyPath = "currentPage", required = false)
        String getCurrentPage();

        @XBridgeParamField(isGetter = true, keyPath = "defaultSchema", required = true)
        String getDefaultSchema();

        @XBridgeParamField(isGetter = true, keyPath = "eCommerceSchema", required = true)
        String getECommerceSchema();

        @XBridgeParamField(isGetter = true, keyPath = "source", required = false)
        String getSource();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
    }

    public y() {
        this.a = "flow.openECommerce";
    }

    public final String getName() {
        return this.a;
    }

    public static void b(b r9, String r10, String r11) {
        Map<String, Object> r0 = r9.getBcm();
        String r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.get("doubao_message_id");
    L7:
        if ((r2 instanceof String) == false) goto L9;
        String r5 = (String) r2;
    L10:
        if (r0 == null) goto L12;
        Object r3 = r0.get("fpa_bcm_id");
    L14:
        if ((r3 instanceof String) == false) goto L16;
        String r4 = (String) r3;
    L17:
        if (r0 == null) goto L19;
        Object r6 = r0.get("product_id");
    L21:
        if ((r6 instanceof String) == false) goto L23;
        r1 = (String) r6;
    L23:
        n r7 = n.a;
        String r8 = r9.getCurrentPage();
        r7.getClass();
        n.b(r4, r1, r5, r8, r10, r11);
        return;
    L19:
        r6 = null;
        goto L21
    L16:
        r4 = null;
        goto L17
    L12:
        r3 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    public final void handle(IBDXBridgeContext r13, XBaseParamModel r14, final CompletionBlock r15) {
        final b r4 = (b) r14;
        Intrinsics.checkNotNullParameter(r13, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r15, "callback");
        i3 r0 = i3.a;
        if (r0.f() == false) goto L5;
        r0.g(TriggerLoginScene.TRIGGER_LOGIN_EC_SEARCH_SAAS_CARD);
        CompletionBlock.DefaultImpls.onSuccess$default(r15, ne7.e.b(c.class), null, 2, null);
        return;
    L5:
        Activity r1 = r13.getOwnerActivity();
        if ((r1 instanceof FragmentActivity) == false) goto L8;
        FragmentActivity r8 = (FragmentActivity) r1;
    L9:
        if (r8 != null) goto L11;
        CompletionBlock.DefaultImpls.onFailure$default(r15, 0, "Failed to get fragment activity", null, 4, null);
        return;
    L11:
        final View r5 = r13.getEngineView();
        final l2 r9 = l0.a();
        if (o0.d(r4.getECommerceSchema()) == false) goto L21;
        if (r9 == null) goto L21;
        if (r9.i() == false) goto L18;
        c(r8, r9, r4, r5, r15);
        return;
    L18:
        if (f2.a.m() == false) goto L20;
        n r10 = n.a;
        final FragmentActivity r2 = r8;
        Function1 r11 = new v(this, r2, r9, r4, r5, r15);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r9, "service");
        Intrinsics.checkNotNullParameter(r11, "callback");
        t0.e(new f(r8, r9, r11));
        return;
    L20:
        r9.f("XOpenECommerceMethod-loadInNotWait", new uq9.a());
        a(r8, r4, r15, "not_install_sdk");
        return;
    L21:
        a(r8, r4, r15, "not_install_sdk");
        return;
    L8:
        r8 = null;
        goto L9
    }

    public static void a(FragmentActivity r7, b r8, CompletionBlock r9, String r10) {
        b(r8, "douyinH5", r10);
        String r11 = r8.getDefaultSchema();
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L12;
        CompletionBlock.DefaultImpls.onFailure$default(r9, 0, "defaultSchema is null or empty. defaultSchema: " + r11, null, 4, null);
        return;
    L12:
        Boolean r13 = Boolean.FALSE;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L19
        Map r2 = com.ivy.ivykit.api.bridge.b.a;     // Catch: Throwable -> L19
        hx7.f r3 = (hx7.f) com.ivy.ivykit.api.bridge.b.a(hx7.f.class);     // Catch: Throwable -> L19
        if (r3 == null) goto L16;
        r13 = Boolean.valueOf(r3.openSchema(r11, MapsKt.emptyMap(), r7));     // Catch: Throwable -> L19
    L17:
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L22:
        if (Result.exceptionOrNull-impl(r4) == null) goto L24;
        r13 = Boolean.FALSE;
    L24:
        Uri r5 = UriProtector.parse(r11);
        Boolean r6 = Boolean.TRUE;
        if (Intrinsics.areEqual(r13, r6) == true) goto L28;
        boolean r14 = BulletSdk.a;
        Intrinsics.checkNotNull(r5);
        r13 = Boolean.valueOf(BulletSdk.h(r7, r5, null, 12));
    L28:
        if (Intrinsics.areEqual(r13, r6) == false) goto L30;
        CompletionBlock.DefaultImpls.onSuccess$default(r9, ne7.e.b(c.class), null, 2, null);
        return;
    L30:
        CompletionBlock.DefaultImpls.onFailure$default(r9, 0, "Failed to open schema: " + r11, null, 4, null);
        return;
    L16:
        r13 = null;
    L19:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L5:
        if (r11.length() == 0) goto L8;
        r12 = false;
        goto L9
    }

    public final void c(final FragmentActivity r10, l2 r11, final b r12, final View r13, final CompletionBlock<c> r14) {
        String r0 = r12.getCurrentPage();
        if (r0 != null) goto L5;
        String r2 = "";
    L6:
        String r1 = r12.getSource();
        if (r1 != null) goto L9;
        String r3 = "";
    L10:
        r11.e(new uq9.d(r10, r2, r3, !f2.a.u(), false, false, 48), new w(), new x(this, r10, r12, r13, r14));
        return;
    L9:
        r3 = r1;
        goto L10
    L5:
        r2 = r0;
        goto L6
    }
}
