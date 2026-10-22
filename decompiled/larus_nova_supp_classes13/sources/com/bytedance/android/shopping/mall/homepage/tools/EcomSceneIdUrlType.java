package com.bytedance.android.shopping.mall.homepage.tools;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/tools/EcomSceneIdUrlType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "URL", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EcomSceneIdUrlType extends Enum<EcomSceneIdUrlType> {
    public static final EcomSceneIdUrlType URL = null;
    public static final /* synthetic */ EcomSceneIdUrlType[] a = null;
    private final String value;

    static {
        EcomSceneIdUrlType r1 = new EcomSceneIdUrlType();
        URL = r1;
        a = new EcomSceneIdUrlType[]{r1};
    }

    public static EcomSceneIdUrlType valueOf(String r1) {
        return (EcomSceneIdUrlType) r27.a.a(EcomSceneIdUrlType.class, r1);
    }

    public static EcomSceneIdUrlType[] values() {
        return (EcomSceneIdUrlType[]) a.clone();
    }

    public EcomSceneIdUrlType() {
        super("URL", 0);
        this.value = "url";
    }

    public final String getValue() {
        return this.value;
    }
}
