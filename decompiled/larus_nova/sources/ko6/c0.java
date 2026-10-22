package ko6;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.annotation.XBridgeMethodName;
import com.bytedance.ies.xbridge.annotation.XBridgeModelExtension;
import com.bytedance.ies.xbridge.annotation.XBridgeParamField;
import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.annotation.XBridgePermission;
import com.bytedance.ies.xbridge.annotation.XBridgeResultModel;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class c0 extends v56.c<b, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504444d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "preview_picture", params = {"image_url_list", "enable_download", "position", "enable_loop", "enable_drag_dismiss", "title_list", "size"})
    public final String f504445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504446c;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "enable_download", required = false)
        Boolean getEnable_download();

        @XBridgeParamField(isGetter = true, keyPath = "enable_drag_dismiss", required = false)
        Boolean getEnable_drag_dismiss();

        @XBridgeParamField(isGetter = true, keyPath = "enable_loop", required = false)
        Boolean getEnable_loop();

        @XBridgeParamField(isGetter = true, keyPath = "image_url_list", primitiveClassType = String.class, required = true)
        List<String> getImage_url_list();

        @XBridgeParamField(isGetter = true, keyPath = "position", required = false)
        Number getPosition();

        @XBridgeParamField(isGetter = true, keyPath = "size", required = false)
        Number getSize();

        @XBridgeParamField(isGetter = true, keyPath = "title_list", primitiveClassType = String.class, required = false)
        List<String> getTitle_list();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
        f504444d = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", "1006"), TuplesKt.to("UID", "61386193246f1a0056c4c2e8")});
    }

    public c0() {
        this.f504445b = "preview_picture";
        this.f504446c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504446c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f504445b;
    }
}
