package com.bytedance.android.shopping.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/api/ClickArea;", "", "ENTER_SHOP", "COMMENT", "SHARE", "COLLECT", "ADD_CART", "BUY", "OTHER", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final enum ClickArea extends Enum<ClickArea> {
    public static final ClickArea ADD_CART = null;
    public static final ClickArea BUY = null;
    public static final ClickArea COLLECT = null;
    public static final ClickArea COMMENT = null;
    public static final ClickArea ENTER_SHOP = null;
    public static final ClickArea OTHER = null;
    public static final ClickArea SHARE = null;
    public static final /* synthetic */ ClickArea[] a = null;

    static {
        ClickArea r1 = new ClickArea("ENTER_SHOP", 0);
        ENTER_SHOP = r1;
        ClickArea r2 = new ClickArea("COMMENT", 1);
        COMMENT = r2;
        ClickArea r3 = new ClickArea("SHARE", 2);
        SHARE = r3;
        ClickArea r4 = new ClickArea("COLLECT", 3);
        COLLECT = r4;
        ClickArea r5 = new ClickArea("ADD_CART", 4);
        ADD_CART = r5;
        ClickArea r6 = new ClickArea("BUY", 5);
        BUY = r6;
        ClickArea r7 = new ClickArea("OTHER", 6);
        OTHER = r7;
        a = new ClickArea[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static ClickArea valueOf(String r1) {
        return (ClickArea) a.a(ClickArea.class, r1);
    }

    public static ClickArea[] values() {
        return (ClickArea[]) a.clone();
    }

    public ClickArea(String r1, int r2) {
        super(r1, r2);
    }
}
