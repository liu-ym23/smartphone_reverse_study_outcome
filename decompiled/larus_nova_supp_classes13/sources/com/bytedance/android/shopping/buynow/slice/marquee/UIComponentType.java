package com.bytedance.android.shopping.buynow.slice.marquee;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/buynow/slice/marquee/UIComponentType;", "", "", "value", "I", "getValue", "()I", "TEXT", "ICON", "LINK", "COUNTDOWN", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum UIComponentType extends Enum<UIComponentType> {
    public static final UIComponentType COUNTDOWN = null;
    public static final UIComponentType ICON = null;
    public static final UIComponentType LINK = null;
    public static final UIComponentType TEXT = null;
    public static final /* synthetic */ UIComponentType[] a = null;
    private final int value;

    static {
        UIComponentType r2 = new UIComponentType("TEXT", 0, 1);
        TEXT = r2;
        UIComponentType r3 = new UIComponentType("ICON", 1, 2);
        ICON = r3;
        UIComponentType r4 = new UIComponentType("LINK", 2, 3);
        LINK = r4;
        UIComponentType r5 = new UIComponentType("COUNTDOWN", 3, 4);
        COUNTDOWN = r5;
        a = new UIComponentType[]{r2, r3, r4, r5};
    }

    public static UIComponentType valueOf(String r1) {
        return (UIComponentType) a.a(UIComponentType.class, r1);
    }

    public static UIComponentType[] values() {
        return (UIComponentType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public UIComponentType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
