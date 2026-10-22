package rs4;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/HomepageAddBitable;", "", "<init>", "()V", "dashboards", "", "Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/HomepageAddDashboard;", "getDashboards", "()Ljava/util/List;", "isTemplate", "", "()Z", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("dashboards")
    private final List<b> dashboards;

    @SerializedName("is_template")
    private final boolean isTemplate;

    public a() {
        this.dashboards = CollectionsKt.emptyList();
    }

    public final List<b> a() {
        return this.dashboards;
    }

    public final boolean b() {
        return this.isTemplate;
    }
}
