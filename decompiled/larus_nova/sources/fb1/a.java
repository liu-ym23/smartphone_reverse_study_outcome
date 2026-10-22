package fb1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\b¨\u0006\u001c"}, d2 = {"Lfb1/a;", "", "", "lyricFilePath", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "", "lyricType", "I", "b", "()I", "e", "(I)V", "", "offset", "Ljava/lang/Double;", "getOffset", "()Ljava/lang/Double;", "setOffset", "(Ljava/lang/Double;)V", "lyricsUrl", "c", "f", "<init>", "()V", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a {

    @SerializedName("path")
    private String lyricFilePath;

    @SerializedName("type")
    private int lyricType;

    @SerializedName("url")
    private String lyricsUrl;

    @SerializedName("offset")
    private Double offset;

    public a() {
        this.lyricType = 2;
    }

    public final String a() {
        return this.lyricFilePath;
    }

    public final int b() {
        return this.lyricType;
    }

    public final String c() {
        return this.lyricsUrl;
    }

    public final void d(String r100) {
        this.lyricFilePath = r100;
    }

    public final void e(int r100) {
        this.lyricType = r100;
    }

    public final void f(String r100) {
        this.lyricsUrl = r100;
    }
}
