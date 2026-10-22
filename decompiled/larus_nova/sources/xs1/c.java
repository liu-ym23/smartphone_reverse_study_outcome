package xs1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lxs1/c;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "", "defaultSuggestSchema", "Ljava/lang/String;", "getDefaultSuggestSchema", "()Ljava/lang/String;", "setDefaultSuggestSchema", "(Ljava/lang/String;)V", "defaultSuggestDescription", "getDefaultSuggestDescription", "setDefaultSuggestDescription", "enableStatusPanelGuide", "getEnableStatusPanelGuide", "setEnableStatusPanelGuide", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("default_suggest_description")
    private String defaultSuggestDescription;

    @SerializedName("default_suggest_schema")
    private String defaultSuggestSchema;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_status_panel_guide")
    private boolean enableStatusPanelGuide;

    public c() {
        this.defaultSuggestSchema = "sslocal://webcast_redirect?entry=live_suggestions";
        this.defaultSuggestDescription = "查看本场全部建议";
        this.enableStatusPanelGuide = true;
    }

    public final boolean a() {
        return this.enable;
    }
}
