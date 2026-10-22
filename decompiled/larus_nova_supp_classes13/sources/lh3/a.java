package lh3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Llh3/a;", "", "", "servicePanelSchema", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "taxPanelSchema", "c", "ruleDescriptionPanel", "a", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("rule_description_panel")
    private final String ruleDescriptionPanel;

    @SerializedName("service_panel")
    private final String servicePanelSchema;

    @SerializedName("tax_panel")
    private final String taxPanelSchema;

    public a() {
        this.servicePanelSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_reactlynx_ecommerce_service_panel%2Fapp%2Ftemplate.js&type=popup&gravity=bottom&add_safe_area_height=0&height_percent=73&top_level=1&mask_alpha=0.5&use_real_screen_height=1";
        this.taxPanelSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_reactlynx_ecommerce_tax_description_panel%2Fapp%2Ftemplate.js&type=popup&gravity=bottom&add_safe_area_height=0&height_percent=50&top_level=1&mask_alpha=0.5&use_real_screen_height=1";
        this.ruleDescriptionPanel = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_reactlynx_ecommerce_groupbuy_panel%2Fapp%2Ftemplate.js&type=popup&gravity=bottom&add_safe_area_height=0&height_percent=73&top_level=1&mask_alpha=0.5&use_real_screen_height=1";
    }

    public final String a() {
        return this.ruleDescriptionPanel;
    }

    public final String b() {
        return this.servicePanelSchema;
    }

    public final String c() {
        return this.taxPanelSchema;
    }
}
