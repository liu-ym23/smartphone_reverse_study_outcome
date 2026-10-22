package com.larus.login.api.ecommerce;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/login/api/ecommerce/ECommerceApiPath$EcommerceTextConfigScene;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AuthWithCoupon", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ECommerceApiPath$EcommerceTextConfigScene extends Enum<ECommerceApiPath$EcommerceTextConfigScene> {
    public static final ECommerceApiPath$EcommerceTextConfigScene AuthWithCoupon = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECommerceApiPath$EcommerceTextConfigScene[] f357013a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f357014b = null;
    private final String value;

    public static EnumEntries<ECommerceApiPath$EcommerceTextConfigScene> getEntries() {
        return f357014b;
    }

    static {
        ECommerceApiPath$EcommerceTextConfigScene r100 = new ECommerceApiPath$EcommerceTextConfigScene();
        AuthWithCoupon = r100;
        ECommerceApiPath$EcommerceTextConfigScene[] r101 = {r100};
        f357013a = r101;
        f357014b = EnumEntriesKt.enumEntries(r101);
    }

    public ECommerceApiPath$EcommerceTextConfigScene() {
        super("AuthWithCoupon", 0);
        this.value = "auth_with_coupon";
    }

    public static ECommerceApiPath$EcommerceTextConfigScene[] values() {
        return (ECommerceApiPath$EcommerceTextConfigScene[]) f357013a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ECommerceApiPath$EcommerceTextConfigScene valueOf(String r100) {
        return (ECommerceApiPath$EcommerceTextConfigScene) r27.a.a(ECommerceApiPath$EcommerceTextConfigScene.class, r100);
    }
}
