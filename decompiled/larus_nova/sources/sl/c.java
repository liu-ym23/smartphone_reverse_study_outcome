package sl;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR2\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lsl/c;", "", "", "successToast", "Ljava/lang/String;", "getSuccessToast", "()Ljava/lang/String;", "failureToast", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "needHideDefaultToast", "Z", "getNeedHideDefaultToast", "()Z", "addCartFrom", "getAddCartFrom", "jumpSchema", "b", "orderToAddCart", "getOrderToAddCart", "Lql/a;", "promotion", "Lql/a;", "getPromotion", "()Lql/a;", "setPromotion", "(Lql/a;)V", "", "extraInfo", "Ljava/util/Map;", "getExtraInfo", "()Ljava/util/Map;", "setExtraInfo", "(Ljava/util/Map;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Object f542440a;

    @SerializedName("add_cart_from")
    private final String addCartFrom;

    @SerializedName("extra_info")
    private Map<String, String> extraInfo;

    @SerializedName("failure_toast")
    private final String failureToast;

    @SerializedName("jump_schema")
    private final String jumpSchema;

    @SerializedName("hide_default_toast")
    private final boolean needHideDefaultToast;

    @SerializedName("order_to_add_cart")
    private final boolean orderToAddCart;

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
        if ((r100 instanceof c) == false) goto L24;
        c r101 = (c) r100;
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
        if (Intrinsics.areEqual(this.jumpSchema, r101.jumpSchema) == true) goto L16;
        return false;
    L16:
        if (this.orderToAddCart == r101.orderToAddCart) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.promotion, r101.promotion) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.extraInfo, r101.extraInfo) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f542440a, r101.f542440a) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
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
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        String r111 = this.addCartFrom;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        String r114 = this.jumpSchema;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (r113 + r115) * 31;
        boolean r117 = this.orderToAddCart;
        if (r117 == true) goto L25;
        r108 = r117;
    L25:
        int r118 = (r116 + r108) * 31;
        ql.a r119 = this.promotion;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        Map<String, String> r122 = this.extraInfo;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        Object r125 = this.f542440a;
        if (r125 == null) goto L37;
        r101 = r125.hashCode();
    L37:
        return r124 + r101;
    L32:
        r123 = 0;
        goto L33
    L28:
        r120 = 0;
        goto L29
    L20:
        r115 = 0;
        goto L21
    L16:
        r112 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECBizParamsAddCartJump(successToast=" + this.successToast + ", failureToast=" + this.failureToast + ", needHideDefaultToast=" + this.needHideDefaultToast + ", addCartFrom=" + this.addCartFrom + ", jumpSchema=" + this.jumpSchema + ", orderToAddCart=" + this.orderToAddCart + ", promotion=" + this.promotion + ", extraInfo=" + this.extraInfo + ", btmModel=" + this.f542440a + ")";
    }

    public c() {
        this.successToast = null;
        this.failureToast = null;
        this.needHideDefaultToast = true;
        this.addCartFrom = "";
        this.jumpSchema = "";
        this.orderToAddCart = false;
        this.promotion = null;
        this.extraInfo = null;
        this.f542440a = null;
    }

    public final String a() {
        return this.failureToast;
    }

    public final String b() {
        return this.jumpSchema;
    }
}
