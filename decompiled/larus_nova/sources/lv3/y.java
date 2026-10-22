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

/* JADX INFO: loaded from: classes14.dex */
@XBridgeMethod(name = "flow.openECommerce")
public final class y extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "flow.openECommerce", params = {"eCommerceSchema", "defaultSchema", "btm", "bcm", "currentPage", "source"})
    public final String f510960a;

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
        this.f510960a = "flow.openECommerce";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f510960a;
    }

    public static void b(b r100, String r110, String r111) {
        Map<String, Object> r101 = r100.getBcm();
        String r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get("doubao_message_id");
    L7:
        if ((r103 instanceof String) == false) goto L9;
        String r104 = (String) r103;
    L10:
        if (r101 == null) goto L12;
        Object r105 = r101.get("fpa_bcm_id");
    L14:
        if ((r105 instanceof String) == false) goto L16;
        String r106 = (String) r105;
    L17:
        if (r101 == null) goto L19;
        Object r107 = r101.get("product_id");
    L21:
        if ((r107 instanceof String) == false) goto L23;
        r102 = (String) r107;
    L23:
        n r108 = n.f510919a;
        String r109 = r100.getCurrentPage();
        r108.getClass();
        n.b(r106, r102, r104, r109, r110, r111);
        return;
    L19:
        r107 = null;
        goto L21
    L16:
        r106 = null;
        goto L17
    L12:
        r105 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, final CompletionBlock r112) {
        final b r100 = (b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        i3 r101 = i3.f365750a;
        if (r101.f() == false) goto L5;
        r101.g(TriggerLoginScene.TRIGGER_LOGIN_EC_SEARCH_SAAS_CARD);
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) ne7.e.b(c.class), null, 2, null);
        return;
    L5:
        Activity r102 = r110.getOwnerActivity();
        if ((r102 instanceof FragmentActivity) == false) goto L8;
        FragmentActivity r103 = (FragmentActivity) r102;
    L9:
        if (r103 != null) goto L11;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Failed to get fragment activity", null, 4, null);
        return;
    L11:
        final View r104 = r110.getEngineView();
        final l2 r105 = l0.a();
        if (o0.d(r100.getECommerceSchema()) == false) goto L21;
        if (r105 == null) goto L21;
        if (r105.i() == false) goto L18;
        c(r103, r105, r100, r104, r112);
        return;
    L18:
        if (f2.f365106a.m() == false) goto L20;
        n r113 = n.f510919a;
        final FragmentActivity r106 = r103;
        Function1 r114 = new v(this, r106, r105, r100, r104, r112);
        r113.getClass();
        Intrinsics.checkNotNullParameter(r103, "activity");
        Intrinsics.checkNotNullParameter(r105, "service");
        Intrinsics.checkNotNullParameter(r114, "callback");
        t0.e(new f(r103, r105, r114));
        return;
    L20:
        r105.f("XOpenECommerceMethod-loadInNotWait", new uq9.a());
        a(r103, r100, r112, "not_install_sdk");
        return;
    L21:
        a(r103, r100, r112, "not_install_sdk");
        return;
    L8:
        r103 = null;
        goto L9
    }

    public static void a(FragmentActivity r100, b r101, CompletionBlock r102, String r110) {
        b(r101, "douyinH5", r110);
        String r103 = r101.getDefaultSchema();
        if (r103 != null) goto L5;
    L8:
        boolean r111 = true;
    L9:
        if (r111 == false) goto L12;
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, "defaultSchema is null or empty. defaultSchema: " + r103, null, 4, null);
        return;
    L12:
        Boolean r112 = Boolean.FALSE;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L19
        Map<Class<?>, com.ivy.ivykit.api.bridge.d<?>> r105 = com.ivy.ivykit.api.bridge.b.f278301a;     // Catch: Throwable -> L19
        hx7.f r106 = (hx7.f) com.ivy.ivykit.api.bridge.b.a(hx7.f.class);     // Catch: Throwable -> L19
        if (r106 == null) goto L16;
        r112 = Boolean.valueOf(r106.openSchema(r103, MapsKt.emptyMap(), r100));     // Catch: Throwable -> L19
    L17:
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L22:
        if (Result.m9452exceptionOrNullimpl(r107) == null) goto L24;
        r112 = Boolean.FALSE;
    L24:
        Uri r108 = UriProtector.parse(r103);
        Boolean r109 = Boolean.TRUE;
        if (Intrinsics.areEqual(r112, r109) == true) goto L28;
        boolean r113 = BulletSdk.f246267a;
        Intrinsics.checkNotNull(r108);
        r112 = Boolean.valueOf(BulletSdk.h(r100, r108, null, 12));
    L28:
        if (Intrinsics.areEqual(r112, r109) == false) goto L30;
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) ne7.e.b(c.class), null, 2, null);
        return;
    L30:
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, "Failed to open schema: " + r103, null, 4, null);
        return;
    L16:
        r112 = null;
    L19:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L5:
        if (r103.length() == 0) goto L8;
        r111 = false;
        goto L9
    }

    public final void c(final FragmentActivity r110, l2 r111, final b r112, final View r113, final CompletionBlock<c> r114) {
        String r100 = r112.getCurrentPage();
        if (r100 != null) goto L5;
        String r101 = "";
    L6:
        String r102 = r112.getSource();
        if (r102 != null) goto L9;
        String r103 = "";
    L10:
        r111.e(new uq9.d(r110, r101, r103, !f2.f365106a.u(), false, false, 48), new w(), new x(this, r110, r112, r113, r114));
        return;
    L9:
        r103 = r102;
        goto L10
    L5:
        r101 = r100;
        goto L6
    }
}
