package os5;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020!2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\b\u0010#\u001a\u00020\u0003H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00138\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u001a8\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u001a8\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001d¨\u0006$"}, d2 = {"Lcom/bytedance/ee/lark/nativecomponent/core/model/NativeComponentModel;", "", "id", "", "type", "data", "Lorg/json/JSONObject;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "getId", "()Ljava/lang/String;", "getType", "getData", "()Lorg/json/JSONObject;", "setData", "(Lorg/json/JSONObject;)V", "value", "backgroundColor", "getBackgroundColor", "", "zIndex", "getZIndex", "()I", "dataExtra", "getDataExtra", "setDataExtra", "", "width", "getWidth", "()F", "height", "getHeight", "init", "", "updateData", "toString", "native-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("background_color")
    private String backgroundColor;

    @SerializedName("data")
    private JSONObject data;

    @SerializedName(b.f276363m)
    private JSONObject dataExtra;

    @SerializedName("height")
    private float height;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f526496id;

    @SerializedName("type")
    private final String type;

    @SerializedName("width")
    private float width;

    @SerializedName("z_index")
    private int zIndex;

    public final String toString() {
        return "id:" + this.f526496id + ",type:" + this.type + ",data:" + this.data;
    }

    public final JSONObject a() {
        return this.data;
    }

    public final String getType() {
        return this.type;
    }

    public final void b(JSONObject r100) {
        this.data = r100;
    }

    public a(String r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f526496id = r100;
        this.type = r101;
        this.data = r102;
        JSONObject r103 = r102.optJSONObject("style");
        if (r103 != null) goto L6;
        return;
    L6:
        if (r103.isNull("backgroundColor") == false) goto L9;
        this.backgroundColor = JSONObjectProtectorUtils.getString(r103, "backgroundColor");
    L9:
        if (r103.isNull("zIndex") == false) goto L12;
        this.zIndex = JSONObjectProtectorUtils.getInt(r103, "zIndex");
    L12:
        if (r103.isNull("width") == false) goto L15;
        this.width = (float) JSONObjectProtectorUtils.getDouble(r103, "width");
    L15:
        if (r103.isNull("height") == false) goto L18;
        this.height = (float) JSONObjectProtectorUtils.getDouble(r103, "height");
        return;
    }
}
