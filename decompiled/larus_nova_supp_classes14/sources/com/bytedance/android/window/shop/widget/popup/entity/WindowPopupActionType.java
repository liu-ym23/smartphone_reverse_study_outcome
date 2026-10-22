package com.bytedance.android.window.shop.widget.popup.entity;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/window/shop/widget/popup/entity/WindowPopupActionType;", "", "", "desc", "Ljava/lang/String;", "Companion", "a", "OPEN_SCHEMA", "CLOSE_SELF", "DELAYED_CLOSE_SELF", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowPopupActionType extends Enum<WindowPopupActionType> {
    public static final WindowPopupActionType CLOSE_SELF = null;
    public static final a Companion = null;
    public static final WindowPopupActionType DELAYED_CLOSE_SELF = null;
    public static final WindowPopupActionType OPEN_SCHEMA = null;
    public static final /* synthetic */ WindowPopupActionType[] a = null;
    public static final Map<String, WindowPopupActionType> b = null;
    private final String desc;

    public static final class a {
        public a() {
        }
    }

    static {
        int r3 = 0;
        WindowPopupActionType r1 = new WindowPopupActionType("OPEN_SCHEMA", 0, "open_schema");
        OPEN_SCHEMA = r1;
        WindowPopupActionType r2 = new WindowPopupActionType("CLOSE_SELF", 1, "close_self");
        CLOSE_SELF = r2;
        WindowPopupActionType r4 = new WindowPopupActionType("DELAYED_CLOSE_SELF", 2, "delayed_close_self");
        DELAYED_CLOSE_SELF = r4;
        a = new WindowPopupActionType[]{r1, r2, r4};
        Companion = new a();
        WindowPopupActionType[] r0 = values();
        LinkedHashMap r5 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r0.length), 16));
        int r6 = r0.length;
    L3:
        if (r3 >= r6) goto L5;
        WindowPopupActionType r7 = r0[r3];
        r5.put(r7.desc, r7);
        r3 = r3 + 1;
        goto L3
    L5:
        b = r5;
    }

    public static WindowPopupActionType valueOf(String r1) {
        return (WindowPopupActionType) r27.a.a(WindowPopupActionType.class, r1);
    }

    public static WindowPopupActionType[] values() {
        return (WindowPopupActionType[]) a.clone();
    }

    public static final /* synthetic */ Map access$getMapping$cp() {
        return b;
    }

    public WindowPopupActionType(String r1, int r2, String r3) {
        super(r1, r2);
        this.desc = r3;
    }
}
