package lo;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.window.base.dynamicview.common.e;
import com.bytedance.android.ec.window.base.dynamicview.common.f;
import com.bytedance.android.ec.window.base.dynamicview.virtualview.j;
import com.bytedance.android.ec.window.base.dynamicview.virtualview.k;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Llo/a;", "", "", "viewType", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "scene", "b", "uniqueId", "d", "Llo/d;", "uiParams", "Llo/d;", "c", "()Llo/d;", "Lcom/google/gson/JsonObject;", "layoutParams", "Lcom/google/gson/JsonObject;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/google/gson/JsonObject;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class a {

    @SerializedName("layout_params")
    private final JsonObject layoutParams;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("ui_params")
    private final d uiParams;

    @SerializedName(BdpAppEventConstant.PARAMS_UNIQUEID)
    private final String uniqueId;

    @SerializedName(BytedCertConstant.IntentKey.VIEW_TYPE)
    private final String viewType;

    /* JADX INFO: renamed from: lo.a$a, reason: collision with other inner class name */
    public static final class C6718a {
    }

    static {
    }

    public final JsonObject a() {
        return this.layoutParams;
    }

    public final String b() {
        return this.scene;
    }

    public final d c() {
        return this.uiParams;
    }

    public final String d() {
        return this.uniqueId;
    }

    public final String e() {
        return this.viewType;
    }

    public k<? extends View, ? extends ViewGroup.LayoutParams> f(a r100, List<? extends a> r101) {
        Intrinsics.checkNotNullParameter(r101, "siblings");
        int r102 = com.bytedance.android.ec.window.base.dynamicview.common.d.f49251a;
        Intrinsics.checkNotNullParameter(this, "dto");
        Intrinsics.checkNotNullParameter(r101, "siblings");
        String r103 = this.viewType;
        if (r103 == null) goto L32;
        String r104 = this.uniqueId;
        if (r104 == null) goto L33;
        d r105 = this.uiParams;
        if (r105 == null) goto L30;
        j r106 = r105.b();
        if (r100 == null) goto L16;
        f r107 = com.bytedance.android.ec.window.base.dynamicview.common.b.f49249c.c(r100.e());
        if (r107 == null) goto L16;
        e r108 = r107.a(this, r101);
    L17:
        if (r108 == null) goto L34;
        com.bytedance.android.ec.window.base.dynamicview.common.b r109 = com.bytedance.android.ec.window.base.dynamicview.common.b.f49249c;
        String r110 = this.scene;
        if (r110 != null) goto L22;
        r110 = "";
    L22:
        r109.getClass();
        Intrinsics.checkNotNullParameter(r103, "viewType");
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter(r104, "uniqueId");
        Intrinsics.checkNotNullParameter(r106, "uiParam");
        Intrinsics.checkNotNullParameter(r108, "layoutParams");
        Function4 r111 = (Function4) ((Map) r109.f49260a.getValue()).get(r103);
        if (r111 != null) goto L29;
        if (com.bytedance.android.ec.window.base.dynamicview.common.c.f49250a == false) goto L31;
        return null;
    L31:
        return null;
    L29:
        return (k) r111.invoke(r104, r110, r106, r108);
    L34:
        return null;
    L16:
        r108 = null;
        goto L17
    L30:
        return null;
    L33:
        return null;
    L32:
        return null;
    }
}
