package com.bytedance.android.window.shop.repository.tab.entity;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;", "", "", "isSingleColumn", "isDoubleColumn", "isNewLayout", "", "type", "I", "getType", "()I", "Companion", "a", "SINGLECOLUMN", "DOUBLECOLUMN", "SINGLECOLUMN_V2", "DOUBLECOLUMN_V2", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowLayoutType extends Enum<WindowLayoutType> {
    public static final a Companion = null;
    public static final WindowLayoutType DOUBLECOLUMN = null;
    public static final WindowLayoutType DOUBLECOLUMN_V2 = null;
    public static final WindowLayoutType SINGLECOLUMN = null;
    public static final WindowLayoutType SINGLECOLUMN_V2 = null;
    public static final /* synthetic */ WindowLayoutType[] a = null;
    private final int type;

    public static final class a {
        public a() {
        }

        public static WindowLayoutType a(Integer r2) {
            if (r2 != null) goto L5;
        L7:
            if (r2 != null) goto L10;
        L12:
            return null;
        L10:
            if (r2.intValue() != 2) goto L12;
            return WindowLayoutType.DOUBLECOLUMN;
        L5:
            if (r2.intValue() != 1) goto L7;
            return WindowLayoutType.SINGLECOLUMN;
        }

        public static WindowLayoutType b(Integer r3) {
            WindowLayoutType r0 = WindowLayoutType.SINGLECOLUMN;
            int r1 = r0.getType();
            if (r3 != null) goto L6;
        L8:
            WindowLayoutType r2 = WindowLayoutType.DOUBLECOLUMN;
            int r4 = r2.getType();
            if (r3 != null) goto L12;
        L14:
            WindowLayoutType r5 = WindowLayoutType.SINGLECOLUMN_V2;
            int r6 = r5.getType();
            if (r3 != null) goto L18;
        L20:
            WindowLayoutType r7 = WindowLayoutType.DOUBLECOLUMN_V2;
            int r8 = r7.getType();
            if (r3 != null) goto L24;
        L26:
            return null;
        L24:
            if (r3.intValue() != r8) goto L26;
            return r7;
        L18:
            if (r3.intValue() != r6) goto L20;
            return r5;
        L12:
            if (r3.intValue() != r4) goto L14;
            return r2;
        L6:
            if (r3.intValue() != r1) goto L8;
            return r0;
        }
    }

    static {
        WindowLayoutType r1 = new WindowLayoutType("SINGLECOLUMN", 0, 0);
        SINGLECOLUMN = r1;
        WindowLayoutType r2 = new WindowLayoutType("DOUBLECOLUMN", 1, 1);
        DOUBLECOLUMN = r2;
        WindowLayoutType r3 = new WindowLayoutType("SINGLECOLUMN_V2", 2, 2);
        SINGLECOLUMN_V2 = r3;
        WindowLayoutType r4 = new WindowLayoutType("DOUBLECOLUMN_V2", 3, 3);
        DOUBLECOLUMN_V2 = r4;
        a = new WindowLayoutType[]{r1, r2, r3, r4};
        Companion = new a();
    }

    public static WindowLayoutType valueOf(String r1) {
        return (WindowLayoutType) r27.a.a(WindowLayoutType.class, r1);
    }

    public static WindowLayoutType[] values() {
        return (WindowLayoutType[]) a.clone();
    }

    public final boolean isDoubleColumn() {
        if (this != DOUBLECOLUMN) goto L5;
    L8:
        return true;
    L5:
        if (this == DOUBLECOLUMN_V2) goto L8;
        return false;
    }

    public final boolean isNewLayout() {
        if (this != SINGLECOLUMN_V2) goto L5;
    L8:
        return true;
    L5:
        if (this == DOUBLECOLUMN_V2) goto L8;
        return false;
    }

    public final boolean isSingleColumn() {
        if (this != SINGLECOLUMN) goto L5;
    L8:
        return true;
    L5:
        if (this == SINGLECOLUMN_V2) goto L8;
        return false;
    }

    public final int getType() {
        return this.type;
    }

    public WindowLayoutType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
