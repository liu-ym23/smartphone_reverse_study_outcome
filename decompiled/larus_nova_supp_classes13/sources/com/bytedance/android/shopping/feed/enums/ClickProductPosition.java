package com.bytedance.android.shopping.feed.enums;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/feed/enums/ClickProductPosition;", "", "", "position", "Ljava/lang/String;", "getPosition", "()Ljava/lang/String;", "CLICK_AREA_BUTTON", "CLICK_AREA_PIC", "CLICK_AREA_BLANK", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ClickProductPosition extends Enum<ClickProductPosition> {
    public static final ClickProductPosition CLICK_AREA_BLANK = null;
    public static final ClickProductPosition CLICK_AREA_BUTTON = null;
    public static final ClickProductPosition CLICK_AREA_PIC = null;
    public static final /* synthetic */ ClickProductPosition[] a = null;
    private final String position;

    static {
        ClickProductPosition r1 = new ClickProductPosition("CLICK_AREA_BUTTON", 0, "button");
        CLICK_AREA_BUTTON = r1;
        ClickProductPosition r2 = new ClickProductPosition("CLICK_AREA_PIC", 1, "pic");
        CLICK_AREA_PIC = r2;
        ClickProductPosition r3 = new ClickProductPosition("CLICK_AREA_BLANK", 2, "blank");
        CLICK_AREA_BLANK = r3;
        a = new ClickProductPosition[]{r1, r2, r3};
    }

    public static ClickProductPosition valueOf(String r1) {
        return (ClickProductPosition) a.a(ClickProductPosition.class, r1);
    }

    public static ClickProductPosition[] values() {
        return (ClickProductPosition[]) a.clone();
    }

    public final String getPosition() {
        return this.position;
    }

    public ClickProductPosition(String r1, int r2, String r3) {
        super(r1, r2);
        this.position = r3;
    }
}
