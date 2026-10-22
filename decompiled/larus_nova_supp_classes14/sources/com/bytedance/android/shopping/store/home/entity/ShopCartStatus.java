package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.shopping.yata.business.function.ScrollPosition;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ShopCartStatus;", "", "", "status", "I", "getStatus", "()I", "Companion", "a", "ICON", "BOTTOM", "SLIDE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShopCartStatus extends Enum<ShopCartStatus> {
    public static final ShopCartStatus BOTTOM = null;
    public static final a Companion = null;
    public static final ShopCartStatus ICON = null;
    public static final ShopCartStatus SLIDE = null;
    public static final /* synthetic */ ShopCartStatus[] a = null;
    private final int status;

    public static final class a {
        public a() {
        }

        public static String a(Integer r2) {
            if (r2 != null) goto L5;
        L7:
            if (r2 != null) goto L10;
        L12:
            if (r2 != null) goto L15;
        L17:
            return "";
        L15:
            if (r2.intValue() != 3) goto L17;
            return "slide";
        L10:
            if (r2.intValue() != 2) goto L12;
            return ScrollPosition.POSITION_BOTTOM;
        L5:
            if (r2.intValue() != 1) goto L7;
            return "icon";
        }
    }

    static {
        ShopCartStatus r2 = new ShopCartStatus("ICON", 0, 1);
        ICON = r2;
        ShopCartStatus r3 = new ShopCartStatus("BOTTOM", 1, 2);
        BOTTOM = r3;
        ShopCartStatus r4 = new ShopCartStatus("SLIDE", 2, 3);
        SLIDE = r4;
        a = new ShopCartStatus[]{r2, r3, r4};
        Companion = new a();
    }

    public static ShopCartStatus valueOf(String r1) {
        return (ShopCartStatus) r27.a.a(ShopCartStatus.class, r1);
    }

    public static ShopCartStatus[] values() {
        return (ShopCartStatus[]) a.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    public ShopCartStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.status = r3;
    }
}
