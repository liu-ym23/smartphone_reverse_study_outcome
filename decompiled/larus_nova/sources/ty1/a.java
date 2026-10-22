package ty1;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lty1/a;", "", "", "name", "Ljava/lang/String;", "b", "()Ljava/lang/String;", ce.f26391f, "(Ljava/lang/String;)V", "", "standardWidth", "I", "d", "()I", RXScreenCaptureService.KEY_INDEX, "(I)V", "standardHeight", "c", "h", NameKeys.LoadStrategy_Use, "e", ce.f26395j, "Lty1/c;", "layout", "Lty1/c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lty1/c;", "f", "(Lty1/c;)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("layout")
    private c layout;

    @SerializedName("name")
    private String name;

    @SerializedName("height")
    private int standardHeight;

    @SerializedName("width")
    private int standardWidth;

    @SerializedName(NameKeys.LoadStrategy_Use)
    private String use;

    public a() {
        this.name = "";
        this.use = "default";
    }

    public final c a() {
        return this.layout;
    }

    public final String b() {
        return this.name;
    }

    public final int c() {
        return this.standardHeight;
    }

    public final int d() {
        return this.standardWidth;
    }

    public final String e() {
        return this.use;
    }

    public final void f(c r100) {
        this.layout = r100;
    }

    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void h(int r100) {
        this.standardHeight = r100;
    }

    public final void i(int r100) {
        this.standardWidth = r100;
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.use = r100;
    }
}
