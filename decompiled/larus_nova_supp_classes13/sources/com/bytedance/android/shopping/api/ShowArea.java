package com.bytedance.android.shopping.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/api/ShowArea;", "", "SHOP", "COMMENT", "SHARE", "COLLECT", "ADD_CART", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final enum ShowArea extends Enum<ShowArea> {
    public static final ShowArea ADD_CART = null;
    public static final ShowArea COLLECT = null;
    public static final ShowArea COMMENT = null;
    public static final ShowArea SHARE = null;
    public static final ShowArea SHOP = null;
    public static final /* synthetic */ ShowArea[] a = null;

    static {
        ShowArea r1 = new ShowArea("SHOP", 0);
        SHOP = r1;
        ShowArea r2 = new ShowArea("COMMENT", 1);
        COMMENT = r2;
        ShowArea r3 = new ShowArea("SHARE", 2);
        SHARE = r3;
        ShowArea r4 = new ShowArea("COLLECT", 3);
        COLLECT = r4;
        ShowArea r5 = new ShowArea("ADD_CART", 4);
        ADD_CART = r5;
        a = new ShowArea[]{r1, r2, r3, r4, r5};
    }

    public static ShowArea valueOf(String r1) {
        return (ShowArea) a.a(ShowArea.class, r1);
    }

    public static ShowArea[] values() {
        return (ShowArea[]) a.clone();
    }

    public ShowArea(String r1, int r2) {
        super(r1, r2);
    }
}
