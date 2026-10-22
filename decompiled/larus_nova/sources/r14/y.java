package r14;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR*\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000f¨\u0006#"}, d2 = {"Lr14/y;", "", "", "uri", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "", "urlList", "Ljava/util/List;", "c", "()Ljava/util/List;", "setUrlList", "(Ljava/util/List;)V", "", "downloadUrlList", "getDownloadUrlList", "setDownloadUrlList", "", "height", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setHeight", "(I)V", "width", "d", "setWidth", "maskUrlList", "getMaskUrlList", "setMaskUrlList", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class y {

    @SerializedName("download_url_list")
    private List<String> downloadUrlList;

    @SerializedName("height")
    private int height;

    @SerializedName("mask_url_list")
    private List<String> maskUrlList;

    @SerializedName("uri")
    private String uri;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    private List<String> urlList;

    @SerializedName("width")
    private int width;

    public y() {
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.uri == null) goto L5;
        r100.append(", uri=");
        r100.append(this.uri);
    L5:
        List<String> r101 = this.urlList;
        if (r101 == null) goto L10;
        Intrinsics.checkNotNull(r101);
        if (r101.isEmpty() == true) goto L10;
        r100.append(", url_list=");
        r100.append(this.urlList);
    L10:
        List<String> r102 = this.downloadUrlList;
        if (r102 == null) goto L15;
        Intrinsics.checkNotNull(r102);
        if (r102.isEmpty() == true) goto L15;
        r100.append(", download_url_list=");
        r100.append(this.downloadUrlList);
    L15:
        r100.append(", height=");
        r100.append(this.height);
        r100.append(", width=");
        r100.append(this.width);
        List<String> r103 = this.maskUrlList;
        if (r103 == null) goto L20;
        Intrinsics.checkNotNull(r103);
        if (r103.isEmpty() == true) goto L20;
        r100.append(", mask_url_list=");
        r100.append(this.maskUrlList);
    L20:
        StringBuilder r104 = r100.replace(0, 2, "ImageUrlStruct{");
        r104.append('}');
        return r104.toString();
    }

    public final int a() {
        return this.height;
    }

    public final String b() {
        return this.uri;
    }

    public final List<String> c() {
        return this.urlList;
    }

    public final int d() {
        return this.width;
    }
}
