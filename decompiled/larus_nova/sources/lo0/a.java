package lo0;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.tencent.open.SocialConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Llo0/a;", "", "", "text", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "nickName", "getNickName", SocialConstants.PARAM_APP_DESC, "c", "avatar", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, DownloadHelper.IDENTITY, "f", "schema", ce.f26391f, "enterText", "d", "", "bdpLogExtra", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "extra", "e", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("avatar")
    private final String avatar;

    @SerializedName("bdp_log_extra")
    private final Map<String, String> bdpLogExtra;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String desc;

    @SerializedName("enter_text")
    private final String enterText;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName(DownloadHelper.IDENTITY)
    private final String identity;

    @SerializedName("nick_name")
    private final String nickName;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("text")
    private final String text;

    public a() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L24;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.nickName, r101.nickName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.identity, r101.identity) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.enterText, r101.enterText) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.bdpLogExtra, r101.bdpLogExtra) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.nickName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.desc;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.avatar;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.identity;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.schema;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.enterText;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, String> r122 = this.bdpLogExtra;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Map<String, String> r125 = this.extra;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PrivateMsgEntranceInfo(text=" + this.text + ", nickName=" + this.nickName + ", desc=" + this.desc + ", avatar=" + this.avatar + ", identity=" + this.identity + ", schema=" + this.schema + ", enterText=" + this.enterText + ", bdpLogExtra=" + this.bdpLogExtra + ", extra=" + this.extra + ")";
    }

    public final String a() {
        return this.avatar;
    }

    public final Map<String, String> b() {
        return this.bdpLogExtra;
    }

    public final String c() {
        return this.desc;
    }

    public final String d() {
        return this.enterText;
    }

    public final Map<String, String> e() {
        return this.extra;
    }

    public final String f() {
        return this.identity;
    }

    public final String g() {
        return this.schema;
    }

    public final String h() {
        return this.text;
    }

    public a(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Map<String, String> r107, Map<String, String> r108) {
        this.text = r100;
        this.nickName = r101;
        this.desc = r102;
        this.avatar = r103;
        this.identity = r104;
        this.schema = r105;
        this.enterText = r106;
        this.bdpLogExtra = r107;
        this.extra = r108;
    }
}
