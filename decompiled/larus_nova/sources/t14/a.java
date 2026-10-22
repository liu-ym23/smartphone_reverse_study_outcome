package t14;

import android.text.TextUtils;
import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import com.ss.ttvideoengine.model.BarrageMaskInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b2\u00103R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R*\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0085\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0018\"\u0004\b'\u0010\u001aR$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR*\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010+8\u0004@\u0004X\u0085\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0007\u001a\u0004\b-\u0010\t\"\u0004\b.\u0010\u000bR$\u0010/\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u0010\u001a¨\u00064"}, d2 = {"Lt14/a;", "", "", "uri", "Ljava/lang/String;", "", "urlList", "Ljava/util/List;", ce.f26391f, "()Ljava/util/List;", "setUrlList", "(Ljava/util/List;)V", "", "width", "I", "h", "()I", "setWidth", "(I)V", "height", "c", "setHeight", "urlKey", "f", "()Ljava/lang/String;", "setUrlKey", "(Ljava/lang/String;)V", "", "size", "J", "d", "()J", "setSize", "(J)V", "fileHash", "b", "setFileHash", "aK", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAK", "fileCheckSum", "getFileCheckSum", "setFileCheckSum", "", "downUrlList", "getDownUrlList", "setDownUrlList", "bgimgUrl", "getBgimgUrl", "setBgimgUrl", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public class a {

    @SerializedName("player_access_key")
    private String aK;

    @SerializedName("bgimg_url")
    private String bgimgUrl;

    @SerializedName("download_url_list")
    private List<String> downUrlList;

    @SerializedName("file_cs")
    private String fileCheckSum;

    @SerializedName(BarrageMaskInfo.KEY_MASK_FILE_HASH)
    private String fileHash;

    @SerializedName("height")
    private int height;

    @SerializedName("data_size")
    private long size;

    @SerializedName("uri")
    private String uri;

    @SerializedName("url_key")
    private String urlKey;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    private List<String> urlList;

    @SerializedName("width")
    private int width;

    public final int hashCode() {
        if (TextUtils.isEmpty(this.urlKey) == false) goto L5;
        String r100 = this.uri;
    L6:
        int r101 = 0;
        if (r100 == null) goto L9;
        int r102 = r100.hashCode();
    L10:
        int r103 = r102 * 31;
        List<String> r104 = this.urlList;
        if (r104 == null) goto L15;
        if (r104 == null) goto L15;
        r101 = r104.hashCode();
    L15:
        return r103 + r101;
    L9:
        r102 = 0;
        goto L10
    L5:
        r100 = this.urlKey;
        goto L6
    }

    public a() {
        this.uri = "";
        this.fileHash = "";
    }

    public final String a() {
        return this.aK;
    }

    public final String b() {
        return this.fileHash;
    }

    public final int c() {
        return this.height;
    }

    public final long d() {
        return this.size;
    }

    public final String e() {
        return this.uri;
    }

    public final String f() {
        return this.urlKey;
    }

    public final List<String> g() {
        return this.urlList;
    }

    public final int h() {
        return this.width;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        String r101 = this.uri;
        if (r101 == null) goto L14;
        if (Intrinsics.areEqual(r101, ((a) r100).uri) == false) goto L15;
    L16:
        boolean r102 = false;
    L17:
        if (r102 == false) goto L19;
        return false;
    L19:
        String r103 = this.urlKey;
        if (r103 == null) goto L25;
        if (Intrinsics.areEqual(r103, ((a) r100).urlKey) == false) goto L26;
    L27:
        boolean r104 = false;
    L28:
        if (r104 == false) goto L30;
        return false;
    L30:
        List<String> r105 = this.urlList;
        List<String> r106 = ((a) r100).urlList;
        if (r105 != null) goto L37;
        if (r106 == null) goto L38;
        return false;
    L38:
        return true;
    L37:
        return Intrinsics.areEqual(r105, r106);
    L26:
        r104 = true;
        goto L28
    L25:
        if (((a) r100).urlKey == null) goto L27;
    L15:
        r102 = true;
        goto L17
    L14:
        if (((a) r100).uri == null) goto L16;
        goto L15
    }
}
