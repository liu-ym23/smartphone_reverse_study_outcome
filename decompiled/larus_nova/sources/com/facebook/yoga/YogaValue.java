package com.facebook.yoga;

import com.alibaba.gaiax.template.GXTemplateKey;

/* JADX INFO: loaded from: classes23.dex */
public class YogaValue {
    static final YogaValue AUTO = null;
    static final YogaValue UNDEFINED = null;
    static final YogaValue ZERO = null;
    public final YogaUnit unit;
    public final float value;

    /* JADX INFO: renamed from: com.facebook.yoga.YogaValue$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$yoga$YogaUnit = null;

        static {
            int[] r100 = new int[YogaUnit.values().length];
            $SwitchMap$com$facebook$yoga$YogaUnit = r100;
            r100[YogaUnit.UNDEFINED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$facebook$yoga$YogaUnit[YogaUnit.POINT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$facebook$yoga$YogaUnit[YogaUnit.PERCENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$facebook$yoga$YogaUnit[YogaUnit.AUTO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        UNDEFINED = new YogaValue(Float.NaN, YogaUnit.UNDEFINED);
        ZERO = new YogaValue(0.0f, YogaUnit.POINT);
        AUTO = new YogaValue(Float.NaN, YogaUnit.AUTO);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value) + this.unit.intValue();
    }

    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.unit.ordinal()];
        if (r100 != 1) goto L5;
        return "undefined";
    L5:
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L15;
        if (r100 != 4) goto L13;
        return "auto";
    L13:
        throw new IllegalStateException();
    L15:
        return this.value + GXTemplateKey.GAIAX_PE;
    L17:
        return Float.toString(this.value);
    }

    public static YogaValue parse(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ("undefined".equals(r100) == false) goto L10;
        return UNDEFINED;
    L10:
        if ("auto".equals(r100) == false) goto L14;
        return AUTO;
    L14:
        if (r100.endsWith(GXTemplateKey.GAIAX_PE) == false) goto L18;
        return new YogaValue(Float.parseFloat(r100.substring(0, r100.length() - 1)), YogaUnit.PERCENT);
    L18:
        return new YogaValue(Float.parseFloat(r100), YogaUnit.POINT);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof YogaValue) == false) goto L14;
        YogaValue r101 = (YogaValue) r100;
        YogaUnit r102 = this.unit;
        if (r102 == r101.unit) goto L7;
        return false;
    L7:
        if (r102 != YogaUnit.UNDEFINED) goto L9;
    L12:
        return true;
    L9:
        if (r102 == YogaUnit.AUTO) goto L12;
        if (Float.compare(this.value, r101.value) == 0) goto L12;
        return false;
    L14:
        return false;
    }

    public YogaValue(float r100, int r101) {
        this(r100, YogaUnit.fromInt(r101));
    }

    public YogaValue(float r100, YogaUnit r101) {
        this.value = r100;
        this.unit = r101;
    }
}
