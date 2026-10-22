package y38;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.account.saas.jsb.core.FlowAccountCommonAlertCore;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@XBridgeMethod(name = "doubaoAccount.commonAlert", owner = "fengjingzhe")
public final class a extends XCoreIDLBridgeMethod<InterfaceC8303a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "doubaoAccount.commonAlert")
    public final String f565868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f565869b;

    /* JADX INFO: renamed from: y38.a$a, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC8303a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = SlcCommonAction.KEY_ACTIONS, required = false)
        List<Map<String, Object>> getActions();

        @XBridgeParamField(isGetter = true, keyPath = SocialConstants.PARAM_APP_DESC, required = false)
        String getDescription();

        @XBridgeParamField(isGetter = true, keyPath = "title", required = false)
        String getTitle();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "id", required = false)
        String getId();

        @XBridgeParamField(isGetter = true, keyPath = "style", required = false)
        Number getStyle();

        @XBridgeParamField(isGetter = true, keyPath = "title", required = false)
        String getTitle();

        @XBridgeParamField(isGetter = false, keyPath = "id", required = false)
        void setId(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "style", required = false)
        void setStyle(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "title", required = false)
        void setTitle(String r100);
    }

    public a() {
        this.f565868a = "doubaoAccount.commonAlert";
        this.f565869b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f565869b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f565868a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r110, CompletionBlock r111) {
        InterfaceC8303a r112 = (InterfaceC8303a) r110;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        List<Map<String, Object>> r101 = r112.getActions();
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L28;
        Map r104 = (Map) r103.next();
        FlowAccountCommonAlertCore.a r105 = null;
        Integer r106 = null;
        if (r104 == null) goto L26;
        Object r107 = r104.get("id");
        if ((r107 instanceof String) == false) goto L14;
        String r108 = (String) r107;
    L15:
        Object r109 = r104.get("title");
        if ((r109 instanceof String) == false) goto L18;
        String r113 = (String) r109;
    L19:
        Object r114 = r104.get("style");
        if ((r114 instanceof Number) == false) goto L22;
        Number r115 = (Number) r114;
    L23:
        if (r115 == null) goto L25;
        r106 = Integer.valueOf(r115.intValue());
    L25:
        r105 = new FlowAccountCommonAlertCore.a(r108, r113, r106);
        goto L26
    L22:
        r115 = null;
        goto L23
    L18:
        r113 = null;
        goto L19
    L14:
        r108 = null;
    L26:
        if (r105 == null) goto L7;
        r102.add(r105);
        goto L7
    L28:
        int r116 = FlowAccountCommonAlertCore.f286331a;
        FlowAccountCommonAlertCore.a(r100.getOwnerActivity(), r112.getTitle(), r112.getDescription(), r102, new y38.b(r111));
    }
}
