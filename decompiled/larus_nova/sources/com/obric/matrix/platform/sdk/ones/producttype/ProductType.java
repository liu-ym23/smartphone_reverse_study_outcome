package com.obric.matrix.platform.sdk.ones.producttype;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/producttype/ProductType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "PACIFIC", "NERIDA", "PIKE", "UNKNOWN", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
public final enum ProductType extends Enum<ProductType> {
    public static final a Companion = null;
    public static final ProductType NERIDA = null;
    public static final ProductType PACIFIC = null;
    public static final ProductType PIKE = null;
    public static final ProductType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProductType[] f397005a = null;
    private final String value;

    public static ProductType valueOf(String r100) {
        return (ProductType) r27.a.a(ProductType.class, r100);
    }

    public static ProductType[] values() {
        return (ProductType[]) f397005a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.matrix.platform.sdk.ones.producttype.ProductType$a] */
    static {
        ProductType r100 = new ProductType("PACIFIC", 0, "pacific");
        PACIFIC = r100;
        ProductType r101 = new ProductType("NERIDA", 1, "nerida");
        NERIDA = r101;
        ProductType r102 = new ProductType("PIKE", 2, "pike");
        PIKE = r102;
        ProductType r103 = new ProductType("UNKNOWN", 3, "");
        UNKNOWN = r103;
        f397005a = new ProductType[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public final String getValue() {
        return this.value;
    }

    public ProductType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
