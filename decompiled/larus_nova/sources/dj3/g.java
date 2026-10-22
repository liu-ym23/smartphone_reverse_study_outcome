package dj3;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.store.repository.dto.m;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\n8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000eR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR(\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Ldj3/g;", "", "", "Lcom/bytedance/android/ec/store/repository/dto/m;", "sortTypes", "Ljava/util/List;", "f", "()Ljava/util/List;", "filters", "b", "", "bigSaleMoveToTop", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setBigSaleMoveToTop", "(Z)V", "Lcom/bytedance/android/ec/store/repository/dto/c;", "selectButtons", "c", "showSelectPanel", "e", "", "selectPanelSchema", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "", "Ldj3/k;", "switchButtonConfigs", "Ljava/util/Map;", ce.f26391f, "()Ljava/util/Map;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("big_sale_move_to_top")
    private boolean bigSaleMoveToTop;

    @SerializedName("filters")
    private final List<m> filters;

    @SerializedName("select_buttons")
    private final List<com.bytedance.android.ec.store.repository.dto.c> selectButtons;

    @SerializedName("select_panel_schema")
    private final String selectPanelSchema;

    @SerializedName("show_select_panel_button")
    private final boolean showSelectPanel;

    @SerializedName("sort_types")
    private final List<m> sortTypes;

    @SerializedName("switch_button_configs")
    private final Map<String, k> switchButtonConfigs;

    public g() {
    }

    public final boolean a() {
        return this.bigSaleMoveToTop;
    }

    public final List<m> b() {
        return this.filters;
    }

    public final List<com.bytedance.android.ec.store.repository.dto.c> c() {
        return this.selectButtons;
    }

    public final String d() {
        return this.selectPanelSchema;
    }

    public final boolean e() {
        return this.showSelectPanel;
    }

    public final List<m> f() {
        return this.sortTypes;
    }

    public final Map<String, k> g() {
        return this.switchButtonConfigs;
    }
}
