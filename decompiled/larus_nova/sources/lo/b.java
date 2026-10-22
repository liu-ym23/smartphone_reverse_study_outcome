package lo;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.window.base.dynamicview.virtualview.k;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Llo/b;", "Llo/a;", "Lcom/google/gson/JsonArray;", "children", "Lcom/google/gson/JsonArray;", ce.f26391f, "()Lcom/google/gson/JsonArray;", "Lcom/google/gson/JsonObject;", "options", "Lcom/google/gson/JsonObject;", "h", "()Lcom/google/gson/JsonObject;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b extends a {

    @SerializedName("children")
    private final JsonArray children;

    @SerializedName("group_options")
    private final JsonObject options;

    public final JsonArray g() {
        return this.children;
    }

    public final JsonObject h() {
        return this.options;
    }

    @Override // lo.a
    public final k f(a r100, List r101) {
        Intrinsics.checkNotNullParameter(r101, "siblings");
        return com.bytedance.android.ec.window.base.dynamicview.common.d.a(r100, this, r101);
    }
}
