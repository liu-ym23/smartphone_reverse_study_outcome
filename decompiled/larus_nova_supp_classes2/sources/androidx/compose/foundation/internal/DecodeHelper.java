package androidx.compose.foundation.internal;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidColor_androidKt;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\r\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\rJ\u0006\u0010\u0011\u001a\u00020\u0012J\r\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u0016J\u000f\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020'H\u0002J\u000f\u0010(\u001a\u00020)H\u0002¢\u0006\u0004\b*\u0010\rJ\b\u0010+\u001a\u00020,H\u0002J\n\u0010-\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010.\u001a\u00020'H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Landroidx/compose/foundation/internal/DecodeHelper;", "", "string", "", "<init>", "(Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "decodeSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "decodeColor", "Landroidx/compose/ui/graphics/Color;", "decodeColor-0d7_KjU", "()J", "decodeTextUnit", "Landroidx/compose/ui/unit/TextUnit;", "decodeTextUnit-XSAIIZE", "decodeFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "decodeFontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "decodeFontStyle-_-LCdwA", "()I", "decodeFontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "decodeFontSynthesis-GVVA2EU", "decodeBaselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "decodeBaselineShift-y9eOQZs", "()F", "decodeTextGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "decodeTextDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "decodeShadow", "Landroidx/compose/ui/graphics/Shadow;", "decodeByte", "", "decodeInt", "", "decodeULong", "Lkotlin/ULong;", "decodeULong-s-VKNKU", "decodeFloat", "", "decodeString", "dataAvailable", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DecodeHelper {
    public static final int $stable = 8;
    private final Parcel parcel;

    private final int dataAvailable() {
        return this.parcel.dataAvail();
    }

    private final byte decodeByte() {
        return this.parcel.readByte();
    }

    private final float decodeFloat() {
        return this.parcel.readFloat();
    }

    private final int decodeInt() {
        return this.parcel.readInt();
    }

    private final Shadow decodeShadow() {
        long r1 = m746decodeColor0d7_KjU();
        float r0 = decodeFloat();
        float r3 = decodeFloat();
        return new Shadow(r1, Offset.constructor-impl((Float.floatToRawIntBits(r0) << 32) | (4294967295L & Float.floatToRawIntBits(r3))), decodeFloat(), null);
    }

    private final String decodeString() {
        return this.parcel.readString();
    }

    private final TextGeometricTransform decodeTextGeometricTransform() {
        return new TextGeometricTransform(decodeFloat(), decodeFloat());
    }

    /* JADX INFO: renamed from: decodeULong-s-VKNKU, reason: not valid java name */
    private final long m745decodeULongsVKNKU() {
        return ULong.constructor-impl(this.parcel.readLong());
    }

    /* JADX INFO: renamed from: decodeColor-0d7_KjU, reason: not valid java name */
    public final long m746decodeColor0d7_KjU() {
        return AndroidColor_androidKt.fromColorLong(Color.Companion, this.parcel.readLong());
    }

    public final FontWeight decodeFontWeight() {
        return new FontWeight(decodeInt());
    }

    public final SpanStyle decodeSpanStyle() {
        MutableSpanStyle r21 = r15;
        MutableSpanStyle r15 = new MutableSpanStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, 16383, null);
    L4:
        if (this.parcel.dataAvail() <= 1) goto L61;
        byte r1 = decodeByte();
        if (r1 == 1) goto L8;
        MutableSpanStyle r4 = r21;
        if (r1 != 2) goto L17;
        if (dataAvailable() < 5) goto L63;
        r4.m766setFontSizeR2X_6o(m749decodeTextUnitXSAIIZE());
    L15:
        r21 = r4;
    L63:
        return r4.toSpanStyle();
    L17:
        if (r1 == 3) goto L19;
        if (r1 == 4) goto L23;
        if (r1 != 5) goto L30;
        if (dataAvailable() < 1) goto L63;
        r4.m768setFontSynthesistDdu0R4(FontSynthesis.box-impl(m748decodeFontSynthesisGVVA2EU()));
        goto L15
    L30:
        if (r1 != 6) goto L33;
        r4.setFontFeatureSettings(decodeString());
        goto L15
    L33:
        if (r1 == 7) goto L35;
        if (r1 != 8) goto L42;
        if (dataAvailable() < 4) goto L63;
        r4.m764setBaselineShift_isdbwI(BaselineShift.box-impl(m744decodeBaselineShifty9eOQZs()));
        goto L15
    L42:
        if (r1 != 9) goto L47;
        if (dataAvailable() < 8) goto L63;
        r4.setTextGeometricTransform(decodeTextGeometricTransform());
        goto L15
    L47:
        if (r1 != 10) goto L52;
        if (dataAvailable() < 8) goto L63;
        r4.m763setBackground8_81llA(m746decodeColor0d7_KjU());
        goto L15
    L52:
        if (r1 != 11) goto L57;
        if (dataAvailable() < 4) goto L63;
        r4.setTextDecoration(decodeTextDecoration());
        goto L15
    L57:
        if (r1 != 12) goto L15;
        if (dataAvailable() < 20) goto L63;
        r4.setShadow(decodeShadow());
        goto L15
    L35:
        if (dataAvailable() < 5) goto L63;
        r4.m769setLetterSpacingR2X_6o(m749decodeTextUnitXSAIIZE());
        goto L15
    L23:
        if (dataAvailable() < 1) goto L63;
        r4.m767setFontStylemLjRB2g(FontStyle.box-impl(m747decodeFontStyle_LCdwA()));
        goto L15
    L19:
        if (dataAvailable() < 4) goto L63;
        r4.setFontWeight(decodeFontWeight());
        goto L15
    L8:
        if (dataAvailable() < 8) goto L61;
        MutableSpanStyle r5 = r21;
        r5.m765setColor8_81llA(m746decodeColor0d7_KjU());
    L61:
        r4 = r21;
        goto L63
    }

    /* JADX INFO: renamed from: decodeBaselineShift-y9eOQZs, reason: not valid java name */
    private final float m744decodeBaselineShifty9eOQZs() {
        return BaselineShift.constructor-impl(decodeFloat());
    }

    private final TextDecoration decodeTextDecoration() {
        int r0 = decodeInt();
        TextDecoration.Companion r1 = TextDecoration.Companion;
        if ((r1.getLineThrough().getMask() & r0) == 0) goto L5;
        boolean r2 = true;
    L7:
        if ((r0 & r1.getUnderline().getMask()) == 0) goto L9;
        boolean r3 = true;
    L10:
        if (r2 == false) goto L13;
        if (r3 == false) goto L13;
        return r1.combine(CollectionsKt.listOf(new TextDecoration[]{r1.getLineThrough(), r1.getUnderline()}));
    L13:
        if (r2 == true) goto L20;
        if (r3 == false) goto L18;
        return r1.getUnderline();
    L18:
        return r1.getNone();
    L20:
        return r1.getLineThrough();
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L7
    }

    /* JADX INFO: renamed from: decodeFontStyle-_-LCdwA, reason: not valid java name */
    public final int m747decodeFontStyle_LCdwA() {
        byte r0 = decodeByte();
        if (r0 != 0) goto L6;
        return FontStyle.Companion.getNormal-_-LCdwA();
    L6:
        if (r0 != 1) goto L9;
        return FontStyle.Companion.getItalic-_-LCdwA();
    L9:
        return FontStyle.Companion.getNormal-_-LCdwA();
    }

    /* JADX INFO: renamed from: decodeFontSynthesis-GVVA2EU, reason: not valid java name */
    public final int m748decodeFontSynthesisGVVA2EU() {
        byte r0 = decodeByte();
        if (r0 != 0) goto L6;
        return FontSynthesis.Companion.getNone-GVVA2EU();
    L6:
        if (r0 != 1) goto L9;
        return FontSynthesis.Companion.getAll-GVVA2EU();
    L9:
        if (r0 != 3) goto L12;
        return FontSynthesis.Companion.getStyle-GVVA2EU();
    L12:
        if (r0 != 2) goto L15;
        return FontSynthesis.Companion.getWeight-GVVA2EU();
    L15:
        return FontSynthesis.Companion.getNone-GVVA2EU();
    }

    /* JADX INFO: renamed from: decodeTextUnit-XSAIIZE, reason: not valid java name */
    public final long m749decodeTextUnitXSAIIZE() {
        byte r0 = decodeByte();
        if (r0 != 1) goto L6;
        long r1 = TextUnitType.Companion.getSp-UIouoOA();
    L10:
        if (TextUnitType.equals-impl0(r1, TextUnitType.Companion.getUnspecified-UIouoOA()) == false) goto L14;
        return TextUnit.Companion.getUnspecified-XSAIIZE();
    L14:
        return TextUnitKt.TextUnit-anM5pPY(decodeFloat(), r1);
    L6:
        if (r0 != 2) goto L8;
        r1 = TextUnitType.Companion.getEm-UIouoOA();
        goto L10
    L8:
        r1 = TextUnitType.Companion.getUnspecified-UIouoOA();
        goto L10
    }

    public DecodeHelper(String r4) {
        Parcel r0 = Parcel.obtain();
        this.parcel = r0;
        byte[] r5 = Base64.decode(r4, 0);
        r0.unmarshall(r5, 0, r5.length);
        r0.setDataPosition(0);
    }
}
