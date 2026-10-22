package sl;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R2\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lsl/b;", "", "", "successToast", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "failureToast", "b", "", "needHideDefaultToast", "Z", "c", "()Z", "addCartFrom", "getAddCartFrom", "Lql/a;", "promotion", "Lql/a;", "d", "()Lql/a;", ce.f26391f, "(Lql/a;)V", "", "extraInfo", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "f", "(Ljava/util/Map;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Object f542439a;

    @SerializedName("add_cart_from")
    private final String addCartFrom;

    @SerializedName("extra_info")
    private Map<String, String> extraInfo;

    @SerializedName("failure_toast")
    private final String failureToast;

    @SerializedName("hide_default_toast")
    private final boolean needHideDefaultToast;

    @SerializedName("goods_model")
    private ql.a promotion;

    @SerializedName("success_toast")
    private final String successToast;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L20;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.successToast, r101.successToast) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.failureToast, r101.failureToast) == true) goto L10;
        return false;
    L10:
        if (this.needHideDefaultToast == r101.needHideDefaultToast) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.addCartFrom, r101.addCartFrom) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.promotion, r101.promotion) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.extraInfo, r101.extraInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f542439a, r101.f542439a) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public final int hashCode() {
        String r100 = this.successToast;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.failureToast;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.needHideDefaultToast;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.addCartFrom;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        ql.a r113 = this.promotion;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.extraInfo;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        Object r119 = this.f542439a;
        if (r119 == null) goto L29;
        r101 = r119.hashCode();
    L29:
        return r118 + r101;
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECBizParamsAddCart(successToast=" + this.successToast + ", failureToast=" + this.failureToast + ", needHideDefaultToast=" + this.needHideDefaultToast + ", addCartFrom=" + this.addCartFrom + ", promotion=" + this.promotion + ", extraInfo=" + this.extraInfo + ", btmModel=" + this.f542439a + ")";
    }

    public b() {
        this.successToast = null;
        this.failureToast = null;
        this.needHideDefaultToast = true;
        this.addCartFrom = "";
        this.promotion = null;
        this.extraInfo = null;
        this.f542439a = null;
    }

    public final Map<String, String> a() {
        return this.extraInfo;
    }

    public final String b() {
        return this.failureToast;
    }

    public final boolean c() {
        return this.needHideDefaultToast;
    }

    public final ql.a d() {
        return this.promotion;
    }

    public final String e() {
        return this.successToast;
    }

    public final void f(Map<String, String> r100) {
        this.extraInfo = r100;
    }

    public final void g(ql.a r100) {
        this.promotion = r100;
    }
}
