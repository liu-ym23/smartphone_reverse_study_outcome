package s14;

import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001a\u0010\u001e\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001a\u0010 \u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001a\u0010\"\u001a\u00020\u00128\u0006X\u0087D¢\u0006\f\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016R\u001a\u0010$\u001a\u00020\u00128\u0006X\u0087D¢\u0006\f\n\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010\u0016R\u001c\u0010&\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006¨\u0006*"}, d2 = {"Ls14/b;", "", "", "keyword", "Ljava/lang/String;", "getKeyword", "()Ljava/lang/String;", "setKeyword", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "language", "getLanguage", "schema", "getSchema", "id", "getId", "", "type", "I", "getType", "()I", "Lt14/a;", "icon", "Lt14/a;", "getIcon", "()Lt14/a;", "extra", "getExtra", "deepLink", "getDeepLink", "universalLink", "getUniversalLink", "generalType", "getGeneralType", "showType", "getShowType", "logExtra", "getLogExtra", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class b {

    @SerializedName(ComplianceResult.JsonKey.MARKET_DEEP_LINK)
    private final String deepLink;

    @SerializedName("extra")
    private final String extra;

    @SerializedName("general_type")
    private final int generalType;

    @SerializedName("icon")
    private final t14.a icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f540152id;

    @SerializedName("keyword")
    private String keyword;

    @SerializedName("language")
    private final String language;

    @SerializedName("log_extra")
    private final String logExtra;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("show_type")
    private final int showType;

    @SerializedName("type")
    private final int type;

    @SerializedName("universal_link")
    private final String universalLink;

    @SerializedName("url")
    private String url;

    public b() {
        this.language = "";
        this.schema = "";
        this.f540152id = "";
        this.extra = "";
        this.deepLink = "";
        this.universalLink = "";
        this.showType = 1;
    }

    public final int getType() {
        return this.type;
    }
}
