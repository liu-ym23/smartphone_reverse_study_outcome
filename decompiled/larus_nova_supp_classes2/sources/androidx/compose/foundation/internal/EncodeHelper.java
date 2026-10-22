package androidx.compose.foundation.internal;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0010J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u0019J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010-\u001a\u00020.¢\u0006\u0004\b/\u0010\u0010J\u000e\u0010\n\u001a\u00020\u00072\u0006\u00100\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Landroidx/compose/foundation/internal/EncodeHelper;", "", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "reset", "", "encodedString", "", "encode", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "encode-8_81llA", "(J)V", "textUnit", "Landroidx/compose/ui/unit/TextUnit;", "encode--R2X_6o", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "encode-nzbMABs", "(I)V", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "encode-6p3vJLY", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "encode-4Dl_Bck", "(F)V", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "byte", "", "int", "", "float", "", "uLong", "Lkotlin/ULong;", "encode-VKZWuLQ", "string", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EncodeHelper {
    public static final int $stable = 8;
    private Parcel parcel;

    public final String encodedString() {
        return Base64.encodeToString(this.parcel.marshall(), 0);
    }

    public final void reset() {
        this.parcel.recycle();
        this.parcel = Parcel.obtain();
    }

    public EncodeHelper() {
        this.parcel = Parcel.obtain();
    }

    public final void encode(SpanStyle r7) {
        long r0 = r7.getColor-0d7_KjU();
        Color.Companion r2 = Color.Companion;
        if (Color.equals-impl0(r0, r2.getUnspecified-0d7_KjU()) == true) goto L5;
        encode((byte) 1);
        m753encode8_81llA(r7.getColor-0d7_KjU());
    L5:
        long r1 = r7.getFontSize-XSAIIZE();
        TextUnit.Companion r3 = TextUnit.Companion;
        if (TextUnit.equals-impl0(r1, r3.getUnspecified-XSAIIZE()) == true) goto L8;
        encode((byte) 2);
        m750encodeR2X_6o(r7.getFontSize-XSAIIZE());
    L8:
        FontWeight r4 = r7.getFontWeight();
        if (r4 == null) goto L11;
        encode((byte) 3);
        encode(r4);
    L11:
        FontStyle r5 = r7.getFontStyle-4Lr2A7w();
        if (r5 == null) goto L14;
        int r6 = r5.unbox-impl();
        encode((byte) 4);
        m755encodenzbMABs(r6);
    L14:
        FontSynthesis r8 = r7.getFontSynthesis-ZQGJjVo();
        if (r8 == null) goto L17;
        int r9 = r8.unbox-impl();
        encode((byte) 5);
        m752encode6p3vJLY(r9);
    L17:
        String r10 = r7.getFontFeatureSettings();
        if (r10 == null) goto L21;
        encode((byte) 6);
        encode(r10);
    L21:
        if (TextUnit.equals-impl0(r7.getLetterSpacing-XSAIIZE(), r3.getUnspecified-XSAIIZE()) == true) goto L23;
        encode((byte) 7);
        m750encodeR2X_6o(r7.getLetterSpacing-XSAIIZE());
    L23:
        BaselineShift r11 = r7.getBaselineShift-5SSeXJ0();
        if (r11 == null) goto L26;
        float r12 = r11.unbox-impl();
        encode((byte) 8);
        m751encode4Dl_Bck(r12);
    L26:
        TextGeometricTransform r13 = r7.getTextGeometricTransform();
        if (r13 == null) goto L30;
        encode((byte) 9);
        encode(r13);
    L30:
        if (Color.equals-impl0(r7.getBackground-0d7_KjU(), r2.getUnspecified-0d7_KjU()) == true) goto L32;
        encode((byte) 10);
        m753encode8_81llA(r7.getBackground-0d7_KjU());
    L32:
        TextDecoration r14 = r7.getTextDecoration();
        if (r14 == null) goto L35;
        encode((byte) 11);
        encode(r14);
    L35:
        Shadow r15 = r7.getShadow();
        if (r15 == null) goto L39;
        encode((byte) 12);
        encode(r15);
        return;
    }

    /* JADX INFO: renamed from: encode--R2X_6o, reason: not valid java name */
    public final void m750encodeR2X_6o(long r8) {
        long r0 = TextUnit.getType-UIouoOA(r8);
        TextUnitType.Companion r2 = TextUnitType.Companion;
        byte r4 = 0;
        if (TextUnitType.equals-impl0(r0, r2.getUnspecified-UIouoOA()) == false) goto L6;
    L11:
        encode(r4);
        if (TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(r8), r2.getUnspecified-UIouoOA()) == true) goto L15;
        encode(TextUnit.getValue-impl(r8));
        return;
    L15:
        return;
    L6:
        if (TextUnitType.equals-impl0(r0, r2.getSp-UIouoOA()) == false) goto L9;
        r4 = 1;
        goto L11
    L9:
        if (TextUnitType.equals-impl0(r0, r2.getEm-UIouoOA()) == false) goto L11;
        r4 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: encode-4Dl_Bck, reason: not valid java name */
    public final void m751encode4Dl_Bck(float r1) {
        encode(r1);
    }

    /* JADX INFO: renamed from: encode-6p3vJLY, reason: not valid java name */
    public final void m752encode6p3vJLY(int r4) {
        FontSynthesis.Companion r0 = FontSynthesis.Companion;
        byte r2 = 0;
        if (FontSynthesis.equals-impl0(r4, r0.getNone-GVVA2EU()) == false) goto L6;
    L14:
        encode(r2);
        return;
    L6:
        if (FontSynthesis.equals-impl0(r4, r0.getAll-GVVA2EU()) == false) goto L9;
        r2 = 1;
        goto L14
    L9:
        if (FontSynthesis.equals-impl0(r4, r0.getWeight-GVVA2EU()) == false) goto L12;
        r2 = 2;
        goto L14
    L12:
        if (FontSynthesis.equals-impl0(r4, r0.getStyle-GVVA2EU()) == false) goto L14;
        r2 = 3;
        goto L14
    }

    /* JADX INFO: renamed from: encode-8_81llA, reason: not valid java name */
    public final void m753encode8_81llA(long r1) {
        m754encodeVKZWuLQ(r1);
    }

    /* JADX INFO: renamed from: encode-VKZWuLQ, reason: not valid java name */
    public final void m754encodeVKZWuLQ(long r2) {
        this.parcel.writeLong(r2);
    }

    /* JADX INFO: renamed from: encode-nzbMABs, reason: not valid java name */
    public final void m755encodenzbMABs(int r4) {
        FontStyle.Companion r0 = FontStyle.Companion;
        byte r2 = 0;
        if (FontStyle.equals-impl0(r4, r0.getNormal-_-LCdwA()) == false) goto L6;
    L8:
        encode(r2);
        return;
    L6:
        if (FontStyle.equals-impl0(r4, r0.getItalic-_-LCdwA()) == false) goto L8;
        r2 = 1;
        goto L8
    }

    public final void encode(Shadow r5) {
        m753encode8_81llA(r5.getColor-0d7_KjU());
        encode(Float.intBitsToFloat((int) (r5.getOffset-F1C5BW0() >> 32)));
        encode(Float.intBitsToFloat((int) (r5.getOffset-F1C5BW0() & 4294967295L)));
        encode(r5.getBlurRadius());
    }

    public final void encode(TextGeometricTransform r2) {
        encode(r2.getScaleX());
        encode(r2.getSkewX());
    }

    public final void encode(FontWeight r1) {
        encode(r1.getWeight());
    }

    public final void encode(TextDecoration r1) {
        encode(r1.getMask());
    }

    public final void encode(byte r2) {
        this.parcel.writeByte(r2);
    }

    public final void encode(float r2) {
        this.parcel.writeFloat(r2);
    }

    public final void encode(int r2) {
        this.parcel.writeInt(r2);
    }

    public final void encode(String r2) {
        this.parcel.writeString(r2);
    }
}
