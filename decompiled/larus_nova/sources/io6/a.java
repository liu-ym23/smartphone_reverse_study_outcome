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
public abstract class a extends v56.c<b, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f495198d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "localLife.createBtmSourceToken", params = {"btm", "bcm", "useVirtualToken", "enableOptPrefetch", "options"}, results = {"token"})
    public final String f495199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f495200c;

    /* JADX INFO: renamed from: io6.a$a, reason: collision with other inner class name */
    public static final class C6337a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "bcm", required = false)
        Map<String, Object> getBcm();

        @XBridgeParamField(isGetter = true, keyPath = "btm", required = true)
        String getBtm();

        @XBridgeParamField(isGetter = true, keyPath = "enableOptPrefetch", required = false)
        Boolean getEnableOptPrefetch();

        @XBridgeParamField(isGetter = true, keyPath = "options", required = false)
        Map<String, Object> getOptions();

        @XBridgeParamField(isGetter = true, keyPath = "useVirtualToken", required = false)
        Boolean getUseVirtualToken();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "token", required = true)
        String getToken();

        @XBridgeParamField(isGetter = false, keyPath = "token", required = true)
        void setToken(String r100);
    }

    static {
        f495198d = MapsKt.mapOf(TuplesKt.to("TicketID", "41088"));
    }

    public a() {
        this.f495199b = "localLife.createBtmSourceToken";
        this.f495200c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f495200c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f495199b;
    }
}
