package androidx.compose.foundation.internal;

import android.text.Annotation;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\r\u001a\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0003H\u0080@¢\u0006\u0002\u0010\u0004\u001a\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0003H\u0080@¢\u0006\u0002\u0010\u0004\u001a\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u0006H\u0000\u001a\u000e\u0010\b\u001a\u00020\t*\u0004\u0018\u00010\u0003H\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\u0006H\u0000\u001a\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u000bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010-\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010.\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010/\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00100\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"PLAIN_TEXT_LABEL", "", "readText", "Landroidx/compose/ui/platform/ClipEntry;", "(Landroidx/compose/ui/platform/ClipEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAnnotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "toClipEntry", "hasText", "", "convertToCharSequence", "", "convertToAnnotatedString", "UNIT_TYPE_UNSPECIFIED", "", "UNIT_TYPE_SP", "UNIT_TYPE_EM", "FONT_STYLE_NORMAL", "FONT_STYLE_ITALIC", "FONT_SYNTHESIS_NONE", "FONT_SYNTHESIS_ALL", "FONT_SYNTHESIS_WEIGHT", "FONT_SYNTHESIS_STYLE", "COLOR_ID", "FONT_SIZE_ID", "FONT_WEIGHT_ID", "FONT_STYLE_ID", "FONT_SYNTHESIS_ID", "FONT_FEATURE_SETTINGS_ID", "LETTER_SPACING_ID", "BASELINE_SHIFT_ID", "TEXT_GEOMETRIC_TRANSFORM_ID", "BACKGROUND_ID", "TEXT_DECORATION_ID", "SHADOW_ID", "BYTE_SIZE", "", "INT_SIZE", "FLOAT_SIZE", "LONG_SIZE", "COLOR_SIZE", "TEXT_UNIT_SIZE", "FONT_WEIGHT_SIZE", "FONT_STYLE_SIZE", "FONT_SYNTHESIS_SIZE", "BASELINE_SHIFT_SIZE", "TEXT_GEOMETRIC_TRANSFORM_SIZE", "TEXT_DECORATION_SIZE", "SHADOW_SIZE", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ClipboardUtils_androidKt {
    private static final byte BACKGROUND_ID = 10;
    private static final byte BASELINE_SHIFT_ID = 8;
    private static final int BASELINE_SHIFT_SIZE = 4;
    private static final int BYTE_SIZE = 1;
    private static final byte COLOR_ID = 1;
    private static final int COLOR_SIZE = 8;
    private static final int FLOAT_SIZE = 4;
    private static final byte FONT_FEATURE_SETTINGS_ID = 6;
    private static final byte FONT_SIZE_ID = 2;
    private static final byte FONT_STYLE_ID = 4;
    private static final byte FONT_STYLE_ITALIC = 1;
    private static final byte FONT_STYLE_NORMAL = 0;
    private static final int FONT_STYLE_SIZE = 1;
    private static final byte FONT_SYNTHESIS_ALL = 1;
    private static final byte FONT_SYNTHESIS_ID = 5;
    private static final byte FONT_SYNTHESIS_NONE = 0;
    private static final int FONT_SYNTHESIS_SIZE = 1;
    private static final byte FONT_SYNTHESIS_STYLE = 3;
    private static final byte FONT_SYNTHESIS_WEIGHT = 2;
    private static final byte FONT_WEIGHT_ID = 3;
    private static final int FONT_WEIGHT_SIZE = 4;
    private static final int INT_SIZE = 4;
    private static final byte LETTER_SPACING_ID = 7;
    private static final int LONG_SIZE = 8;
    private static final String PLAIN_TEXT_LABEL = "plain text";
    private static final byte SHADOW_ID = 12;
    private static final int SHADOW_SIZE = 20;
    private static final byte TEXT_DECORATION_ID = 11;
    private static final int TEXT_DECORATION_SIZE = 4;
    private static final byte TEXT_GEOMETRIC_TRANSFORM_ID = 9;
    private static final int TEXT_GEOMETRIC_TRANSFORM_SIZE = 8;
    private static final int TEXT_UNIT_SIZE = 5;
    private static final byte UNIT_TYPE_EM = 2;
    private static final byte UNIT_TYPE_SP = 1;
    private static final byte UNIT_TYPE_UNSPECIFIED = 0;

    public static final AnnotatedString convertToAnnotatedString(CharSequence r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof Spanned) == false) goto L8;
        Spanned r0 = (Spanned) r10;
        int r3 = 0;
        Annotation[] r1 = (Annotation[]) r0.getSpans(0, r0.length(), Annotation.class);
        ArrayList r6 = new ArrayList();
        int r2 = ArraysKt.getLastIndex(r1);
        if (r2 < 0) goto L18;
    L11:
        Annotation r4 = r1[r3];
        if (Intrinsics.areEqual(r4.getKey(), "androidx.compose.text.SpanStyle") == false) goto L15;
        int r5 = r0.getSpanStart(r4);
        int r7 = r0.getSpanEnd(r4);
        r6.add(new AnnotatedString.Range(new DecodeHelper(r4.getValue()).decodeSpanStyle(), r5, r7));
    L15:
        if (r3 == r2) goto L18;
        r3 = r3 + 1;
    L18:
        return new AnnotatedString(r10.toString(), r6, null, 4, null);
    L8:
        return new AnnotatedString(r10.toString(), null, 2, null);
    }

    public static final CharSequence convertToCharSequence(AnnotatedString r9) {
        if (r9.getSpanStyles().isEmpty() == true) goto L5;
        SpannableString r0 = new SpannableString(r9.getText());
        EncodeHelper r1 = new EncodeHelper();
        List r10 = r9.getSpanStyles();
        int r2 = r10.size();
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        AnnotatedString.Range r4 = (AnnotatedString.Range) ListProtector.get(r10, r3);
        SpanStyle r5 = (SpanStyle) r4.component1();
        int r6 = r4.component2();
        int r7 = r4.component3();
        r1.reset();
        r1.encode(r5);
        r0.setSpan(new Annotation("androidx.compose.text.SpanStyle", r1.encodedString()), r6, r7, 33);
        r3 = r3 + 1;
        goto L7
    L9:
        return r0;
    L5:
        return r9.getText();
    }

    public static final boolean hasText(ClipEntry r0) {
        return ClipboardUtils.hasText(r0);
    }

    public static final ClipEntry toClipEntry(AnnotatedString r0) {
        return ClipboardUtils.toClipEntry(r0);
    }

    public static final Object readAnnotatedString(ClipEntry r0, Continuation<? super AnnotatedString> r1) {
        return ClipboardUtils.readAnnotatedString(r0);
    }

    public static final Object readText(ClipEntry r0, Continuation<? super String> r1) {
        return ClipboardUtils.readText(r0);
    }
}
