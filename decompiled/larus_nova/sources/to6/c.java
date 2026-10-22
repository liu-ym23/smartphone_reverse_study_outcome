package to6;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.annotation.DefaultType;
import com.bytedance.ies.xbridge.annotation.XBridgeDefaultValue;
import com.bytedance.ies.xbridge.annotation.XBridgeMethodName;
import com.bytedance.ies.xbridge.annotation.XBridgeModelExtension;
import com.bytedance.ies.xbridge.annotation.XBridgeParamField;
import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.annotation.XBridgePermission;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class c extends v56.c<b, Object> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f546934d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "poiChooseImage", params = {"poiBundleKey", "enterMethod", "shootReward", "enterFrom"})
    public final String f546935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f546936c;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "enterFrom", required = false)
        String getEnterFrom();

        @XBridgeParamField(isGetter = true, keyPath = "enterMethod", required = true)
        String getEnterMethod();

        @XBridgeParamField(isGetter = true, keyPath = "poiBundleKey", required = true)
        String getPoiBundleKey();

        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(boolValue = false, type = DefaultType.BOOL), isGetter = true, keyPath = "shootReward", required = false)
        boolean getShootReward();
    }

    static {
        f546934d = MapsKt.mapOf(TuplesKt.to("TicketID", "30660"));
    }

    public c() {
        this.f546935b = "poiChooseImage";
        this.f546936c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f546936c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f546935b;
    }
}
