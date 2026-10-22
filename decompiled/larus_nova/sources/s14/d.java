package s14;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b3\u00104R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR$\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00065"}, d2 = {"Ls14/d;", "", "", "id", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "title", "f", com.alipay.sdk.m.x.d.f25925o, "extra", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setExtra", "Lt14/a;", "icon", "Lt14/a;", "b", "()Lt14/a;", "setIcon", "(Lt14/a;)V", RuleConditionBean.OPEN_URL_KEY, "e", "setOpenUrl", "mpUrl", "getMpUrl", "setMpUrl", NativeDownloadModel.JsonKey.WEB_URL, "getWebUrl", "setWebUrl", "logExtra", "d", "setLogExtra", "titleTag", ce.f26391f, "setTitleTag", "Ls14/c;", "displayInfo", "Ls14/c;", "getDisplayInfo", "()Ls14/c;", "setDisplayInfo", "(Ls14/c;)V", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class d {

    @SerializedName("display_info")
    private c displayInfo;

    @SerializedName("extra")
    private String extra;

    @SerializedName("icon")
    private t14.a icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f540153id;

    @SerializedName("log_extra")
    private String logExtra;

    @SerializedName("mp_url")
    private String mpUrl;

    @SerializedName("open_url")
    private String openUrl;

    @SerializedName("title")
    private String title;

    @SerializedName("title_tag")
    private String titleTag;

    @SerializedName("type")
    private Integer type;

    @SerializedName("web_url")
    private String webUrl;

    public static final class a {
    }

    static {
    }

    public d() {
        this.type = -1;
    }

    public final String a() {
        return this.extra;
    }

    public final t14.a b() {
        return this.icon;
    }

    public final String c() {
        return this.f540153id;
    }

    public final String d() {
        return this.logExtra;
    }

    public final String e() {
        return this.openUrl;
    }

    public final String f() {
        return this.title;
    }

    public final String g() {
        return this.titleTag;
    }

    public final Integer getType() {
        return this.type;
    }
}
