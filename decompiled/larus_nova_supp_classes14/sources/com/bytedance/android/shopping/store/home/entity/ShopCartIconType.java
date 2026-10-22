package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ShopCartIconType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "RED", "DEFAULT", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShopCartIconType extends Enum<ShopCartIconType> {
    public static final ShopCartIconType DEFAULT = null;
    public static final ShopCartIconType RED = null;
    public static final /* synthetic */ ShopCartIconType[] a = null;
    private final String type;

    static {
        ShopCartIconType r1 = new ShopCartIconType("RED", 0, "red");
        RED = r1;
        ShopCartIconType r2 = new ShopCartIconType("DEFAULT", 1, CommentConstants$CmtLongPanelStrategy.DEFAULT);
        DEFAULT = r2;
        a = new ShopCartIconType[]{r1, r2};
    }

    public static ShopCartIconType valueOf(String r1) {
        return (ShopCartIconType) r27.a.a(ShopCartIconType.class, r1);
    }

    public static ShopCartIconType[] values() {
        return (ShopCartIconType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public ShopCartIconType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
