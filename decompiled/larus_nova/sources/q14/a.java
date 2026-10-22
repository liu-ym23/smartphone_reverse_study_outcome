package q14;

import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import kotlin.Metadata;
import r14.b0;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\bE\u0010FR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R$\u0010'\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR$\u0010-\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0015\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019R\"\u00100\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u001f\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#R$\u00103\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0015\u001a\u0004\b4\u0010\u0017\"\u0004\b5\u0010\u0019RB\u00108\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u000106j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u0001`78\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006G"}, d2 = {"Lq14/a;", "", "", "id", "J", "getId", "()J", "setId", "(J)V", "Lt14/a;", "animateUrl", "Lt14/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lt14/a;", "setAnimateUrl", "(Lt14/a;)V", "staticUrl", "getStaticUrl", "setStaticUrl", "", "animateType", "Ljava/lang/String;", "getAnimateType", "()Ljava/lang/String;", "setAnimateType", "(Ljava/lang/String;)V", "staticType", "getStaticType", "setStaticType", "", "width", "I", "getWidth", "()I", "setWidth", "(I)V", "height", "getHeight", "setHeight", CommonConstant.KEY_DISPLAY_NAME, "getDisplayName", "setDisplayName", "resourcesId", "getResourcesId", "setResourcesId", "jokerId", "getJokerId", "setJokerId", "stickerType", "getStickerType", "setStickerType", "version", "getVersion", "setVersion", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "displayNameLangs", "Ljava/util/HashMap;", "getDisplayNameLangs", "()Ljava/util/HashMap;", "setDisplayNameLangs", "(Ljava/util/HashMap;)V", "Lr14/b0;", "mLogPb", "Lr14/b0;", "getMLogPb", "()Lr14/b0;", "setMLogPb", "(Lr14/b0;)V", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class a {

    @SerializedName("animate_type")
    private String animateType;

    @SerializedName("animate_url")
    private t14.a animateUrl;

    @SerializedName(IGoogleService.ResponseKey.DISPLAY_NAME)
    private String displayName;

    @SerializedName("display_name_lang")
    private HashMap<String, String> displayNameLangs;

    @SerializedName("height")
    private int height;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private long f531293id;

    @SerializedName("joker_sticker_id")
    private String jokerId;

    @SerializedName("log_pb")
    private b0 mLogPb;

    @SerializedName("origin_package_id")
    private long resourcesId;

    @SerializedName("static_type")
    private String staticType;

    @SerializedName("static_url")
    private t14.a staticUrl;

    @SerializedName("sticker_type")
    private int stickerType;

    @SerializedName("version")
    private String version;

    @SerializedName("width")
    private int width;

    /* JADX INFO: renamed from: q14.a$a, reason: collision with other inner class name */
    public static final class C7267a {
    }

    static {
    }

    public a() {
    }

    public final int hashCode() {
        return String.valueOf(this.f531293id).hashCode();
    }

    public final t14.a a() {
        return this.animateUrl;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof a) == true) goto L5;
        return false;
    L5:
        a r101 = (a) r100;
        long r102 = r101.f531293id;
        if (r102 > 0) goto L8;
    L11:
        t14.a r103 = r101.animateUrl;
        if (r103 == null) goto L23;
        String r104 = r103.e();
        if (r104 == null) goto L23;
        t14.a r105 = this.animateUrl;
        if (r105 == null) goto L23;
        String r106 = r105.e();
        if (r106 == null) goto L23;
        return TextUtils.equals(r104, r106);
    L23:
        return false;
    L8:
        if (r102 != this.f531293id) goto L11;
        return true;
    }
}
