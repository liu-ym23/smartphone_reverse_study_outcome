package qe3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0018"}, d2 = {"Lqe3/a;", "", "", "vid", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "src", "b", "f", "", "width", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "h", "(Ljava/lang/Integer;)V", "height", "a", "e", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("height")
    private Integer height;

    @SerializedName("link")
    private String src;

    @SerializedName("id")
    private String vid;

    @SerializedName("width")
    private Integer width;

    public a() {
    }

    public final Integer a() {
        return this.height;
    }

    public final String b() {
        return this.src;
    }

    public final String c() {
        return this.vid;
    }

    public final Integer d() {
        return this.width;
    }

    public final void e(Integer r1) {
        this.height = r1;
    }

    public final void f(String r1) {
        this.src = r1;
    }

    public final void g(String r1) {
        this.vid = r1;
    }

    public final void h(Integer r1) {
        this.width = r1;
    }
}
