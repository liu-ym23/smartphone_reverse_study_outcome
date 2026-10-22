package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes32.dex */
public final enum BorderStyle extends Enum<BorderStyle> {
    public static final BorderStyle DASHED = null;
    public static final BorderStyle DOTTED = null;
    public static final BorderStyle DOUBLE = null;
    public static final BorderStyle GROOVE = null;
    public static final BorderStyle HIDDEN = null;
    public static final BorderStyle INSET = null;
    public static final BorderStyle NONE = null;
    public static final BorderStyle OUTSET = null;
    public static final BorderStyle RIDGE = null;
    public static final BorderStyle SOLID = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BorderStyle[] f383125a = null;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f383126a = null;

        static {
            int[] r100 = new int[BorderStyle.values().length];
            f383126a = r100;
            r100[BorderStyle.DASHED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L26:
            f383126a[BorderStyle.DOTTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L32:
            f383126a[BorderStyle.SOLID.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L42:
            f383126a[BorderStyle.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            f383126a[BorderStyle.HIDDEN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L34:
            f383126a[BorderStyle.INSET.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L36:
            f383126a[BorderStyle.OUTSET.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L38:
            f383126a[BorderStyle.DOUBLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L24:
            f383126a[BorderStyle.GROOVE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L30:
            f383126a[BorderStyle.RIDGE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    public static int darkenColor(int r100) {
        int r101 = (16711422 & r100) >> 1;
        return (r100 & (-16777216)) | r101;
    }

    static {
        BorderStyle r100 = new BorderStyle("SOLID", 0);
        SOLID = r100;
        BorderStyle r101 = new BorderStyle("DASHED", 1);
        DASHED = r101;
        BorderStyle r102 = new BorderStyle("DOTTED", 2);
        DOTTED = r102;
        BorderStyle r103 = new BorderStyle("DOUBLE", 3);
        DOUBLE = r103;
        BorderStyle r104 = new BorderStyle("GROOVE", 4);
        GROOVE = r104;
        BorderStyle r105 = new BorderStyle("RIDGE", 5);
        RIDGE = r105;
        BorderStyle r110 = new BorderStyle("INSET", 6);
        INSET = r110;
        BorderStyle r111 = new BorderStyle("OUTSET", 7);
        OUTSET = r111;
        BorderStyle r112 = new BorderStyle("HIDDEN", 8);
        HIDDEN = r112;
        BorderStyle r113 = new BorderStyle(UserProfileEvent.POSITION_NONE, 9);
        NONE = r113;
        f383125a = new BorderStyle[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static BorderStyle[] values() {
        return (BorderStyle[]) f383125a.clone();
    }

    public boolean isSolidDashedOrDotted() {
        int r100 = a.f383126a[ordinal()];
        if (r100 != 1) goto L5;
    L10:
        return true;
    L5:
        if (r100 == 2) goto L10;
        if (r100 == 3) goto L10;
        return false;
    }

    public static BorderStyle parse(int r100) {
        if (r100 >= 0) goto L4;
        return null;
    L4:
        if (r100 <= NONE.ordinal()) goto L7;
        return null;
    L7:
        return values()[r100];
    }

    public static BorderStyle valueOf(String r100) {
        return (BorderStyle) r27.a.a(BorderStyle.class, r100);
    }

    public PathEffect getPathEffect(float r100) {
        int r101 = a.f383126a[ordinal()];
        if (r101 == 1) goto L9;
        if (r101 == 2) goto L8;
        return null;
    L8:
        return new DashPathEffect(new float[]{r100, r100, r100, r100}, 0.0f);
    L9:
        float r102 = r100 * 3.0f;
        return new DashPathEffect(new float[]{r102, r102, r102, r102}, 0.0f);
    }

    public BorderStyle(String r100, int r101) {
        super(r100, r101);
    }

    public PathEffect getPathEffectAutoAdjust(float r100, float r101) {
        if (this == DASHED) goto L8;
        if (this == DOTTED) goto L8;
        return null;
    L8:
        if (r100 >= 1.0f) goto L12;
        r100 = 1.0f;
    L12:
        if (this != DOTTED) goto L14;
        int r102 = 2;
    L15:
        int r103 = (((int) (((r101 / ((r100 * r102) * 0.5f)) - 0.5f) * 0.5f)) * 2) + 1;
        if (r103 > 1) goto L18;
        return null;
    L18:
        float r104 = r101 / r103;
        return new DashPathEffect(new float[]{r104, r104}, 0.0f);
    L14:
        r102 = 6;
        goto L15
    }

    public static void a(Canvas r110, Paint r111, int r112, float r113, float r114, int r115, int r116, float r117, float r118, float r210, float r211) {
        r111.setPathEffect(null);
        r111.setStrokeWidth(r113);
        int r100 = -1;
    L4:
        if (r100 > 1) goto L29;
        float r101 = 0.0f;
        if (r112 == 0) goto L23;
        if (r112 != 1) goto L9;
        float r102 = r100 * r114;
        if (r100 != 1) goto L22;
    L21:
        int r103 = r115;
    L28:
        r111.setColor(r103);
        r110.drawLine(r117 + r101, r118 + r102, r210 + r101, r211 + r102, r111);
        r100 = r100 + 2;
    L22:
        r103 = r116;
        goto L28
    L9:
        if (r112 != 2) goto L11;
        float r104 = (-r114) * r100;
        if (r100 == 1) goto L26;
    L25:
        r103 = r115;
    L27:
        r101 = r104;
        r102 = 0.0f;
    L26:
        r103 = r116;
        goto L27
    L11:
        if (r112 == 3) goto L13;
        r103 = 0;
        r104 = 0.0f;
        goto L27
    L13:
        r102 = (-r114) * r100;
        if (r100 != 1) goto L21;
    L23:
        r104 = r100 * r114;
        if (r100 != 1) goto L26;
    }

    public void strokeBorderLine(Canvas r110, Paint r111, int r112, float r113, int r114, float r210, float r211, float r212, float r213, float r214, float r215) {
        boolean r100 = false;
        switch(a.f383126a[ordinal()]) {
            case 1: goto L43;
            case 2: goto L43;
            case 3: goto L44;
            case 4: goto L42;
            case 5: goto L42;
            case 6: goto L32;
            case 7: goto L22;
            case 8: goto L19;
            case 9: goto L13;
            case 10: goto L6;
            default: goto L44;
        };
    L19:
        a(r110, r111, r112, r113 / 3.0f, r215 / 3.0f, r114, r114, r210, r211, r212, r213);
        return;
    L42:
        return;
    L43:
        PathEffect r101 = getPathEffectAutoAdjust(r215, r214);
        int r102 = r114;
    L46:
        r111.setStyle(Paint.Style.STROKE);
        r111.setColor(r102);
        r111.setPathEffect(r101);
        r111.setStrokeWidth(r113);
        r110.drawLine(r210, r211, r212, r213, r111);
        r111.setPathEffect(null);
        return;
    L44:
        r102 = r114;
    L45:
        r101 = null;
        goto L46
    L6:
        if ((r114 & 15790320) != 0) goto L8;
        r100 = true;
    L8:
        if (r100 == false) goto L10;
        a(r110, r111, r112, r113 / 2.0f, r215 / 4.0f, r114, r114 | 8421504, r210, r211, r212, r213);
        return;
    L10:
        a(r110, r111, r112, r113 / 2.0f, r215 / 4.0f, darkenColor(r114), r114, r210, r211, r212, r213);
        return;
    L13:
        if ((r114 & 15790320) != 0) goto L15;
        r100 = true;
    L15:
        if (r100 == false) goto L17;
        a(r110, r111, r112, r113 / 2.0f, r215 / 4.0f, r114 | 8421504, r114, r210, r211, r212, r213);
        return;
    L17:
        a(r110, r111, r112, r113 / 2.0f, r215 / 4.0f, r114, darkenColor(r114), r210, r211, r212, r213);
        return;
    L22:
        if ((r114 & 15790320) != 0) goto L24;
        r100 = true;
    L24:
        if (r100 == false) goto L28;
        if (r112 == 1) goto L37;
        if (r112 != 0) goto L44;
    L37:
        r102 = r114 | 8421504;
        goto L45
    L28:
        if (r112 == 3) goto L30;
        if (r112 != 2) goto L44;
    L30:
        r102 = darkenColor(r114);
        goto L45
    L32:
        if ((r114 & 15790320) != 0) goto L34;
        r100 = true;
    L34:
        if (r100 == false) goto L38;
        if (r112 == 3) goto L37;
        if (r112 != 2) goto L44;
    L38:
        if (r112 == 1) goto L40;
        if (r112 != 0) goto L44;
    L40:
        r102 = darkenColor(r114);
        goto L45
    }
}
