package com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/receivingnotice/TabSelection;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "SELECTED", "UNSELECTED", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TabSelection extends Enum<TabSelection> {
    public static final TabSelection SELECTED = null;
    public static final TabSelection UNSELECTED = null;
    public static final /* synthetic */ TabSelection[] a = null;
    private final String value;

    static {
        TabSelection r1 = new TabSelection("SELECTED", 0, "selected");
        SELECTED = r1;
        TabSelection r2 = new TabSelection("UNSELECTED", 1, "unselected");
        UNSELECTED = r2;
        a = new TabSelection[]{r1, r2};
    }

    public static TabSelection valueOf(String r1) {
        return (TabSelection) r27.a.a(TabSelection.class, r1);
    }

    public static TabSelection[] values() {
        return (TabSelection[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public TabSelection(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
