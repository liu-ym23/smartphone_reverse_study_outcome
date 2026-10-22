package io6;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.annotation.XBridgeMethodName;
import com.bytedance.ies.xbridge.annotation.XBridgeModelExtension;
import com.bytedance.ies.xbridge.annotation.XBridgeParamField;
import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.annotation.XBridgePermission;
import com.bytedance.ies.xbridge.annotation.XBridgeResultModel;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class b extends v56.c<InterfaceC6338b, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f495201d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "localLife.getBcmChain", params = {"chainLength", "isDomainStandard", "autoFind"}, results = {"chain"})
    public final String f495202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f495203c;

    public static final class a {
    }

    /* JADX INFO: renamed from: io6.b$b, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC6338b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "autoFind", required = false)
        Boolean getAutoFind();

        @XBridgeParamField(isGetter = true, keyPath = "chainLength", required = false)
        Number getChainLength();

        @XBridgeParamField(isGetter = true, keyPath = "isDomainStandard", required = false)
        Boolean isDomainStandard();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "chain", required = true)
        Map<String, Object> getChain();

        @XBridgeParamField(isGetter = false, keyPath = "chain", required = true)
        void setChain(Map<String, ? extends Object> r100);
    }

    static {
        f495201d = MapsKt.mapOf(TuplesKt.to("TicketID", "36869"));
    }

    public b() {
        this.f495202b = "localLife.getBcmChain";
        this.f495203c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f495203c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f495202b;
    }
}
