package com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/pendant/TabClickType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "TYPE_DRAW", "TYPE_CLICK", "TYPE_EXPAND", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TabClickType extends Enum<TabClickType> {
    public static final TabClickType TYPE_CLICK = null;
    public static final TabClickType TYPE_DRAW = null;
    public static final TabClickType TYPE_EXPAND = null;
    public static final /* synthetic */ TabClickType[] a = null;
    private final String type;

    static {
        TabClickType r1 = new TabClickType("TYPE_DRAW", 0, "draw");
        TYPE_DRAW = r1;
        TabClickType r2 = new TabClickType("TYPE_CLICK", 1, "click");
        TYPE_CLICK = r2;
        TabClickType r3 = new TabClickType("TYPE_EXPAND", 2, "expand");
        TYPE_EXPAND = r3;
        a = new TabClickType[]{r1, r2, r3};
    }

    public static TabClickType valueOf(String r1) {
        return (TabClickType) r27.a.a(TabClickType.class, r1);
    }

    public static TabClickType[] values() {
        return (TabClickType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public TabClickType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
