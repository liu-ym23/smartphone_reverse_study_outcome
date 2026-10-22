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
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class e extends v56.c<b, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504452d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "get_bounding_rect_to_window", results = {"left", "right", "top", "bottom", "width", "height"})
    public final String f504453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504454c;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "bottom", required = false)
        Number getBottom();

        @XBridgeParamField(isGetter = true, keyPath = "height", required = false)
        Number getHeight();

        @XBridgeParamField(isGetter = true, keyPath = "left", required = false)
        Number getLeft();

        @XBridgeParamField(isGetter = true, keyPath = "right", required = false)
        Number getRight();

        @XBridgeParamField(isGetter = true, keyPath = "top", required = false)
        Number getTop();

        @XBridgeParamField(isGetter = true, keyPath = "width", required = false)
        Number getWidth();

        @XBridgeParamField(isGetter = false, keyPath = "bottom", required = false)
        void setBottom(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "height", required = false)
        void setHeight(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "left", required = false)
        void setLeft(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "right", required = false)
        void setRight(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "top", required = false)
        void setTop(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "width", required = false)
        void setWidth(Number r100);
    }

    static {
        f504452d = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", "1000"), TuplesKt.to("UID", "61b303403d41ce00544f4840"), TuplesKt.to("TicketID", "16433")});
    }

    public e() {
        this.f504453b = "get_bounding_rect_to_window";
        this.f504454c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504454c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f504453b;
    }
}
