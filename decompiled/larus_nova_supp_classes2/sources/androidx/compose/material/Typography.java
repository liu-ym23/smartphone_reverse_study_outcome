package androidx.compose.material;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bq\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011B\u0095\u0001\b\u0016\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0014J\u0088\u0001\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016¨\u0006+"}, d2 = {"Landroidx/compose/material/Typography;", "", "h1", "Landroidx/compose/ui/text/TextStyle;", "h2", "h3", "h4", "h5", "h6", "subtitle1", "subtitle2", "body1", "body2", "button", "caption", "overline", "<init>", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "defaultFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "getH1", "()Landroidx/compose/ui/text/TextStyle;", "getH2", "getH3", "getH4", "getH5", "getH6", "getSubtitle1", "getSubtitle2", "getBody1", "getBody2", "getButton", "getCaption", "getOverline", "copy", "equals", "", "other", "hashCode", "", "toString", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Typography {
    public static final int $stable = 0;
    private final TextStyle body1;
    private final TextStyle body2;
    private final TextStyle button;
    private final TextStyle caption;
    private final TextStyle h1;
    private final TextStyle h2;
    private final TextStyle h3;
    private final TextStyle h4;
    private final TextStyle h5;
    private final TextStyle h6;
    private final TextStyle overline;
    private final TextStyle subtitle1;
    private final TextStyle subtitle2;

    public int hashCode() {
        return (((((((((((((((((((((((this.h1.hashCode() * 31) + this.h2.hashCode()) * 31) + this.h3.hashCode()) * 31) + this.h4.hashCode()) * 31) + this.h5.hashCode()) * 31) + this.h6.hashCode()) * 31) + this.subtitle1.hashCode()) * 31) + this.subtitle2.hashCode()) * 31) + this.body1.hashCode()) * 31) + this.body2.hashCode()) * 31) + this.button.hashCode()) * 31) + this.caption.hashCode()) * 31) + this.overline.hashCode();
    }

    public String toString() {
        return "Typography(h1=" + this.h1 + ", h2=" + this.h2 + ", h3=" + this.h3 + ", h4=" + this.h4 + ", h5=" + this.h5 + ", h6=" + this.h6 + ", subtitle1=" + this.subtitle1 + ", subtitle2=" + this.subtitle2 + ", body1=" + this.body1 + ", body2=" + this.body2 + ", button=" + this.button + ", caption=" + this.caption + ", overline=" + this.overline + ')';
    }

    public final TextStyle getBody1() {
        return this.body1;
    }

    public final TextStyle getBody2() {
        return this.body2;
    }

    public final TextStyle getButton() {
        return this.button;
    }

    public final TextStyle getCaption() {
        return this.caption;
    }

    public final TextStyle getH1() {
        return this.h1;
    }

    public final TextStyle getH2() {
        return this.h2;
    }

    public final TextStyle getH3() {
        return this.h3;
    }

    public final TextStyle getH4() {
        return this.h4;
    }

    public final TextStyle getH5() {
        return this.h5;
    }

    public final TextStyle getH6() {
        return this.h6;
    }

    public final TextStyle getOverline() {
        return this.overline;
    }

    public final TextStyle getSubtitle1() {
        return this.subtitle1;
    }

    public final TextStyle getSubtitle2() {
        return this.subtitle2;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Typography) == true) goto L8;
        return false;
    L8:
        Typography r6 = (Typography) r5;
        if (Intrinsics.areEqual(this.h1, r6.h1) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.h2, r6.h2) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.h3, r6.h3) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.h4, r6.h4) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.h5, r6.h5) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.h6, r6.h6) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.subtitle1, r6.subtitle1) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.subtitle2, r6.subtitle2) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.body1, r6.body1) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.body2, r6.body2) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.button, r6.button) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.caption, r6.caption) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.overline, r6.overline) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public Typography(TextStyle r1, TextStyle r2, TextStyle r3, TextStyle r4, TextStyle r5, TextStyle r6, TextStyle r7, TextStyle r8, TextStyle r9, TextStyle r10, TextStyle r11, TextStyle r12, TextStyle r13) {
        this.h1 = r1;
        this.h2 = r2;
        this.h3 = r3;
        this.h4 = r4;
        this.h5 = r5;
        this.h6 = r6;
        this.subtitle1 = r7;
        this.subtitle2 = r8;
        this.body1 = r9;
        this.body2 = r10;
        this.button = r11;
        this.caption = r12;
        this.overline = r13;
    }

    public final Typography copy(TextStyle r16, TextStyle r17, TextStyle r18, TextStyle r19, TextStyle r20, TextStyle r21, TextStyle r22, TextStyle r23, TextStyle r24, TextStyle r25, TextStyle r26, TextStyle r27, TextStyle r28) {
        return new Typography(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public Typography(FontFamily r1, TextStyle r2, TextStyle r3, TextStyle r4, TextStyle r5, TextStyle r6, TextStyle r7, TextStyle r8, TextStyle r9, TextStyle r10, TextStyle r11, TextStyle r12, TextStyle r13, TextStyle r14) {
        this(TypographyKt.access$withDefaultFontFamily(r2, r1), TypographyKt.access$withDefaultFontFamily(r3, r1), TypographyKt.access$withDefaultFontFamily(r4, r1), TypographyKt.access$withDefaultFontFamily(r5, r1), TypographyKt.access$withDefaultFontFamily(r6, r1), TypographyKt.access$withDefaultFontFamily(r7, r1), TypographyKt.access$withDefaultFontFamily(r8, r1), TypographyKt.access$withDefaultFontFamily(r9, r1), TypographyKt.access$withDefaultFontFamily(r10, r1), TypographyKt.access$withDefaultFontFamily(r11, r1), TypographyKt.access$withDefaultFontFamily(r12, r1), TypographyKt.access$withDefaultFontFamily(r13, r1), TypographyKt.access$withDefaultFontFamily(r14, r1));
    }

    public /* synthetic */ Typography(FontFamily r49, TextStyle r50, TextStyle r51, TextStyle r52, TextStyle r53, TextStyle r54, TextStyle r55, TextStyle r56, TextStyle r57, TextStyle r58, TextStyle r59, TextStyle r60, TextStyle r61, TextStyle r62, int r63, DefaultConstructorMarker r64) {
        if ((r63 & 1) == 0) goto L5;
        FontFamily r1 = FontFamily.Companion.getDefault();
    L7:
        if ((r63 & 2) == 0) goto L9;
        TextStyle r3 = TypographyKt.getDefaultTextStyle();
        FontWeight r8 = FontWeight.Companion.getLight();
        long r6 = TextUnitKt.getSp(96);
        long r25 = TextUnitKt.getSp(112);
        TextStyle r2 = TextStyle.copy-p1EtxEg$default(r3, 0, r6, r8, null, null, null, null, TextUnitKt.getSp(-1.5d), null, null, null, 0, null, null, null, 0, 0, r25, null, null, null, 0, 0, null, 16646009, null);
    L11:
        if ((r63 & 4) == 0) goto L13;
        TextStyle r4 = TypographyKt.getDefaultTextStyle();
        FontWeight r9 = FontWeight.Companion.getLight();
        long r7 = TextUnitKt.getSp(60);
        long r26 = TextUnitKt.getSp(72);
        TextStyle r5 = TextStyle.copy-p1EtxEg$default(r4, 0, r7, r9, null, null, null, null, TextUnitKt.getSp(-0.5d), null, null, null, 0, null, null, null, 0, 0, r26, null, null, null, 0, 0, null, 16646009, null);
    L15:
        if ((r63 & 8) == 0) goto L17;
        TextStyle r10 = TypographyKt.getDefaultTextStyle();
        FontWeight r11 = FontWeight.Companion.getNormal();
        long r12 = TextUnitKt.getSp(48);
        long r28 = TextUnitKt.getSp(56);
        TextStyle r13 = TextStyle.copy-p1EtxEg$default(r10, 0, r12, r11, null, null, null, null, TextUnitKt.getSp(0), null, null, null, 0, null, null, null, 0, 0, r28, null, null, null, 0, 0, null, 16646009, null);
    L19:
        if ((r63 & 16) == 0) goto L21;
        TextStyle r14 = TypographyKt.getDefaultTextStyle();
        FontWeight r15 = FontWeight.Companion.getNormal();
        long r16 = TextUnitKt.getSp(34);
        long r31 = TextUnitKt.getSp(36);
        TextStyle r17 = TextStyle.copy-p1EtxEg$default(r14, 0, r16, r15, null, null, null, null, TextUnitKt.getSp(0.25d), null, null, null, 0, null, null, null, 0, 0, r31, null, null, null, 0, 0, null, 16646009, null);
    L23:
        if ((r63 & 32) == 0) goto L25;
        TextStyle r18 = TypographyKt.getDefaultTextStyle();
        FontWeight r19 = FontWeight.Companion.getNormal();
        long r110 = TextUnitKt.getSp(24);
        long r33 = TextUnitKt.getSp(24);
        TextStyle r20 = TextStyle.copy-p1EtxEg$default(r18, 0, r110, r19, null, null, null, null, TextUnitKt.getSp(0), null, null, null, 0, null, null, null, 0, 0, r33, null, null, null, 0, 0, null, 16646009, null);
    L27:
        if ((r63 & 64) == 0) goto L29;
        TextStyle r111 = TypographyKt.getDefaultTextStyle();
        FontWeight r112 = FontWeight.Companion.getMedium();
        long r113 = TextUnitKt.getSp(20);
        long r36 = TextUnitKt.getSp(24);
        TextStyle r21 = TextStyle.copy-p1EtxEg$default(r111, 0, r113, r112, null, null, null, null, TextUnitKt.getSp(0.15d), null, null, null, 0, null, null, null, 0, 0, r36, null, null, null, 0, 0, null, 16646009, null);
    L31:
        if ((r63 & 128) == 0) goto L33;
        TextStyle r114 = TypographyKt.getDefaultTextStyle();
        FontWeight r22 = FontWeight.Companion.getNormal();
        long r115 = TextUnitKt.getSp(16);
        long r38 = TextUnitKt.getSp(24);
        TextStyle r116 = TextStyle.copy-p1EtxEg$default(r114, 0, r115, r22, null, null, null, null, TextUnitKt.getSp(0.15d), null, null, null, 0, null, null, null, 0, 0, r38, null, null, null, 0, 0, null, 16646009, null);
    L35:
        if ((r63 & 256) == 0) goto L37;
        TextStyle r117 = TypographyKt.getDefaultTextStyle();
        FontWeight r23 = FontWeight.Companion.getMedium();
        long r118 = TextUnitKt.getSp(14);
        long r39 = TextUnitKt.getSp(24);
        TextStyle r119 = TextStyle.copy-p1EtxEg$default(r117, 0, r118, r23, null, null, null, null, TextUnitKt.getSp(0.1d), null, null, null, 0, null, null, null, 0, 0, r39, null, null, null, 0, 0, null, 16646009, null);
    L39:
        if ((r63 & 512) == 0) goto L41;
        TextStyle r120 = TypographyKt.getDefaultTextStyle();
        FontWeight r24 = FontWeight.Companion.getNormal();
        long r121 = TextUnitKt.getSp(16);
        long r310 = TextUnitKt.getSp(24);
        TextStyle r27 = TextStyle.copy-p1EtxEg$default(r120, 0, r121, r24, null, null, null, null, TextUnitKt.getSp(0.5d), null, null, null, 0, null, null, null, 0, 0, r310, null, null, null, 0, 0, null, 16646009, null);
    L43:
        if ((r63 & 1024) == 0) goto L45;
        TextStyle r122 = TypographyKt.getDefaultTextStyle();
        FontWeight r29 = FontWeight.Companion.getNormal();
        long r123 = TextUnitKt.getSp(14);
        long r311 = TextUnitKt.getSp(20);
        TextStyle r30 = TextStyle.copy-p1EtxEg$default(r122, 0, r123, r29, null, null, null, null, TextUnitKt.getSp(0.25d), null, null, null, 0, null, null, null, 0, 0, r311, null, null, null, 0, 0, null, 16646009, null);
    L47:
        if ((r63 & 2048) == 0) goto L49;
        TextStyle r124 = TypographyKt.getDefaultTextStyle();
        FontWeight r210 = FontWeight.Companion.getMedium();
        long r125 = TextUnitKt.getSp(14);
        long r312 = TextUnitKt.getSp(16);
        TextStyle r126 = TextStyle.copy-p1EtxEg$default(r124, 0, r125, r210, null, null, null, null, TextUnitKt.getSp(1.25d), null, null, null, 0, null, null, null, 0, 0, r312, null, null, null, 0, 0, null, 16646009, null);
    L51:
        if ((r63 & 4096) == 0) goto L53;
        TextStyle r127 = TypographyKt.getDefaultTextStyle();
        FontWeight r211 = FontWeight.Companion.getNormal();
        long r128 = TextUnitKt.getSp(12);
        long r313 = TextUnitKt.getSp(16);
        TextStyle r129 = TextStyle.copy-p1EtxEg$default(r127, 0, r128, r211, null, null, null, null, TextUnitKt.getSp(0.4d), null, null, null, 0, null, null, null, 0, 0, r313, null, null, null, 0, 0, null, 16646009, null);
    L55:
        if ((r63 & 8192) == 0) goto L57;
        TextStyle r130 = TypographyKt.getDefaultTextStyle();
        FontWeight r212 = FontWeight.Companion.getNormal();
        long r131 = TextUnitKt.getSp(10);
        long r314 = TextUnitKt.getSp(16);
        TextStyle r0 = TextStyle.copy-p1EtxEg$default(r130, 0, r131, r212, null, null, null, null, TextUnitKt.getSp(1.5d), null, null, null, 0, null, null, null, 0, 0, r314, null, null, null, 0, 0, null, 16646009, null);
    L58:
        this(r1, r2, r5, r13, r17, r20, r21, r116, r119, r27, r30, r126, r129, r0);
        return;
    L57:
        r0 = r62;
        goto L58
    L53:
        r129 = r61;
        goto L55
    L49:
        r126 = r60;
        goto L51
    L45:
        r30 = r59;
        goto L47
    L41:
        r27 = r58;
        goto L43
    L37:
        r119 = r57;
        goto L39
    L33:
        r116 = r56;
        goto L35
    L29:
        r21 = r55;
        goto L31
    L25:
        r20 = r54;
        goto L27
    L21:
        r17 = r53;
        goto L23
    L17:
        r13 = r52;
        goto L19
    L13:
        r5 = r51;
        goto L15
    L9:
        r2 = r50;
        goto L11
    L5:
        r1 = r49;
        goto L7
    }

    public static /* synthetic */ Typography copy$default(Typography r14, TextStyle r15, TextStyle r16, TextStyle r17, TextStyle r18, TextStyle r19, TextStyle r20, TextStyle r21, TextStyle r22, TextStyle r23, TextStyle r24, TextStyle r25, TextStyle r26, TextStyle r27, int r28, Object r29) {
        if ((r28 & 1) == 0) goto L5;
        TextStyle r2 = r14.h1;
    L7:
        if ((r28 & 2) == 0) goto L9;
        TextStyle r3 = r14.h2;
    L11:
        if ((r28 & 4) == 0) goto L13;
        TextStyle r4 = r14.h3;
    L15:
        if ((r28 & 8) == 0) goto L17;
        TextStyle r5 = r14.h4;
    L19:
        if ((r28 & 16) == 0) goto L21;
        TextStyle r6 = r14.h5;
    L23:
        if ((r28 & 32) == 0) goto L25;
        TextStyle r7 = r14.h6;
    L27:
        if ((r28 & 64) == 0) goto L29;
        TextStyle r8 = r14.subtitle1;
    L31:
        if ((r28 & 128) == 0) goto L33;
        TextStyle r9 = r14.subtitle2;
    L35:
        if ((r28 & 256) == 0) goto L37;
        TextStyle r10 = r14.body1;
    L39:
        if ((r28 & 512) == 0) goto L41;
        TextStyle r11 = r14.body2;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        TextStyle r12 = r14.button;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        TextStyle r13 = r14.caption;
    L51:
        if ((r28 & 4096) == 0) goto L53;
        TextStyle r1 = r14.overline;
    L55:
        return r14.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r1);
    L53:
        r1 = r27;
        goto L55
    L49:
        r13 = r26;
        goto L51
    L45:
        r12 = r25;
        goto L47
    L41:
        r11 = r24;
        goto L43
    L37:
        r10 = r23;
        goto L39
    L33:
        r9 = r22;
        goto L35
    L29:
        r8 = r21;
        goto L31
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }
}
