package com.larus.login.api.ecommerce;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/login/api/ecommerce/ECommerceApiPath$EcommerceDialogScene;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AuthPanel", "Notify", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ECommerceApiPath$EcommerceDialogScene extends Enum<ECommerceApiPath$EcommerceDialogScene> {
    public static final ECommerceApiPath$EcommerceDialogScene AuthPanel = null;
    public static final ECommerceApiPath$EcommerceDialogScene Notify = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECommerceApiPath$EcommerceDialogScene[] f357011a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f357012b = null;
    private final String value;

    public static EnumEntries<ECommerceApiPath$EcommerceDialogScene> getEntries() {
        return f357012b;
    }

    static {
        ECommerceApiPath$EcommerceDialogScene r100 = new ECommerceApiPath$EcommerceDialogScene("AuthPanel", 0, "auth_panel");
        AuthPanel = r100;
        ECommerceApiPath$EcommerceDialogScene r101 = new ECommerceApiPath$EcommerceDialogScene("Notify", 1, "ecom_notify");
        Notify = r101;
        ECommerceApiPath$EcommerceDialogScene[] r102 = {r100, r101};
        f357011a = r102;
        f357012b = EnumEntriesKt.enumEntries(r102);
    }

    public static ECommerceApiPath$EcommerceDialogScene[] values() {
        return (ECommerceApiPath$EcommerceDialogScene[]) f357011a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ECommerceApiPath$EcommerceDialogScene valueOf(String r100) {
        return (ECommerceApiPath$EcommerceDialogScene) r27.a.a(ECommerceApiPath$EcommerceDialogScene.class, r100);
    }

    public ECommerceApiPath$EcommerceDialogScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
