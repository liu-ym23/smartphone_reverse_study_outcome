package oo;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R.\u0010\u000b\u001a\u0016\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Loo/d;", "", "", "Loo/a;", "constraints", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "", "", "Lcom/bytedance/android/ec/window/base/dynamicview/dto/DynamicViewId;", "dynamicOptions", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("constraints")
    private final List<a> constraints;

    @SerializedName("constraint_options")
    private final Map<String, Object> dynamicOptions;

    public final List<a> a() {
        return this.constraints;
    }

    public final Map<String, Object> b() {
        return this.dynamicOptions;
    }
}
