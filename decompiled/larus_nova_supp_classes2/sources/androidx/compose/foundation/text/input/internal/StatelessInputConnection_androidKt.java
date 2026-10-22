package androidx.compose.foundation.text.input.internal;

import android.content.ClipData;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.view.inputmethod.ExtractedText;
import androidx.compose.foundation.content.PlatformTransferableContent;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.AndroidTypeface_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002\u001a\u0016\u0010\u000b\u001a\u00020\f*\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000\u001a\u001e\u0010\u0010\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00130\u0012j\u0002`\u0014\u0018\u00010\u0011*\u00020\u0015H\u0001\u001a\u000e\u0010\u0016\u001a\u0004\u0018\u00010\u0013*\u00020\u0017H\u0002\u001a\u000e\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\u00020\u001aH\u0002\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\u001bH\u0002\u001a\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0002\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"SIC_DEBUG", "", "getSIC_DEBUG$annotations", "()V", "STATELESS_TAG", "", "DEBUG_CLASS", StatelessInputConnection_androidKt.EXTRA_INPUT_CONTENT_INFO, "toExtractedText", "Landroid/view/inputmethod/ExtractedText;", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "toTransferableContent", "Landroidx/compose/foundation/content/TransferableContent;", "Landroidx/core/view/inputmethod/InputContentInfoCompat;", "extras", "Landroid/os/Bundle;", "toAnnotationList", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "Landroid/text/Spanned;", "toAnnotation", "", "toSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "Landroid/text/style/StyleSpan;", "Landroid/text/style/TypefaceSpan;", "optionalFontFamilyFromName", "Landroidx/compose/ui/text/font/FontFamily;", "familyName", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class StatelessInputConnection_androidKt {
    private static final String DEBUG_CLASS = "StatelessInputConnection";
    private static final String EXTRA_INPUT_CONTENT_INFO = "EXTRA_INPUT_CONTENT_INFO";
    public static final boolean SIC_DEBUG = false;
    private static final String STATELESS_TAG = "StatelessIC";

    public static /* synthetic */ void getSIC_DEBUG$annotations() {
    }

    public static final /* synthetic */ ExtractedText access$toExtractedText(TextFieldCharSequence r0) {
        return toExtractedText(r0);
    }

    private static final FontFamily optionalFontFamilyFromName(String r4) {
        boolean r0 = true;
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        return null;
    L12:
        Typeface r5 = Typeface.create(r4, 0);
        if (Intrinsics.areEqual(r5, Typeface.DEFAULT) == false) goto L15;
    L17:
        r0 = false;
    L18:
        if (r0 == true) goto L21;
        r5 = null;
    L21:
        if (r5 != null) goto L23;
        return null;
    L23:
        return AndroidTypeface_androidKt.FontFamily(r5);
    L15:
        if (Intrinsics.areEqual(r5, Typeface.create(Typeface.DEFAULT, 0)) == true) goto L17;
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    private static final AnnotatedString.Annotation toAnnotation(Object r25) {
        if ((r25 instanceof BackgroundColorSpan) == false) goto L6;
        return new SpanStyle(0, 0, null, null, null, null, null, 0, null, null, null, ColorKt.Color(((BackgroundColorSpan) r25).getBackgroundColor()), null, null, null, null, 63487, null);
    L6:
        if ((r25 instanceof ForegroundColorSpan) == false) goto L9;
        return new SpanStyle(ColorKt.Color(((ForegroundColorSpan) r25).getForegroundColor()), 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, null, 65534, null);
    L9:
        if ((r25 instanceof StrikethroughSpan) == false) goto L12;
        return new SpanStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, TextDecoration.Companion.getLineThrough(), null, null, null, 61439, null);
    L12:
        if ((r25 instanceof StyleSpan) == false) goto L15;
        return toSpanStyle((StyleSpan) r25);
    L15:
        if ((r25 instanceof TypefaceSpan) == false) goto L18;
        return toSpanStyle((TypefaceSpan) r25);
    L18:
        if ((r25 instanceof UnderlineSpan) == true) goto L27;
        return null;
    L27:
        return new SpanStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, TextDecoration.Companion.getUnderline(), null, null, null, 61439, null);
    }

    public static final List<AnnotatedString.Range<AnnotatedString.Annotation>> toAnnotationList(Spanned r8) {
        int r2 = 0;
        Object[] r0 = r8.getSpans(0, r8.length(), Object.class);
        int r1 = r0.length;
        ArrayList r3 = null;
    L3:
        if (r2 >= r1) goto L10;
        Object r4 = r0[r2];
        AnnotatedString.Annotation r5 = toAnnotation(r4);
        if (r5 == null) goto L9;
        if (r3 != null) goto L8;
        r3 = new ArrayList();
    L8:
        r3.add(new AnnotatedString.Range(r5, r8.getSpanStart(r4), r8.getSpanEnd(r4)));
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return r3;
    }

    private static final ExtractedText toExtractedText(TextFieldCharSequence r5) {
        ExtractedText r0 = new ExtractedText();
        r0.text = r5;
        r0.startOffset = 0;
        r0.partialEndOffset = r5.length();
        r0.partialStartOffset = -1;
        r0.selectionStart = TextRange.getMin-impl(r5.m1535getSelectiond9O1mEE());
        r0.selectionEnd = TextRange.getMax-impl(r5.m1535getSelectiond9O1mEE());
        r0.flags = !StringsKt.contains$default(r5, '\n', false, 2, null) ? 1 : 0;
        return r0;
    }

    private static final SpanStyle toSpanStyle(StyleSpan r47) {
        int r0 = r47.getStyle();
        if (r0 == 1) goto L12;
        if (r0 == 2) goto L15;
        if (r0 == 3) goto L14;
        return null;
    L14:
        return new SpanStyle(0, 0, FontWeight.Companion.getBold(), FontStyle.box-impl(FontStyle.Companion.getItalic-_-LCdwA()), null, null, null, 0, null, null, null, 0, null, null, null, null, 65523, null);
    L15:
        return new SpanStyle(0, 0, null, FontStyle.box-impl(FontStyle.Companion.getItalic-_-LCdwA()), null, null, null, 0, null, null, null, 0, null, null, null, null, 65527, null);
    L12:
        return new SpanStyle(0, 0, FontWeight.Companion.getBold(), null, null, null, null, 0, null, null, null, 0, null, null, null, null, 65531, null);
    }

    private static final SpanStyle toSpanStyle(TypefaceSpan r24) {
        String r0 = r24.getFamily();
        FontFamily.Companion r1 = FontFamily.Companion;
        if (Intrinsics.areEqual(r0, r1.getCursive().getName()) == false) goto L7;
        GenericFontFamily r2 = r1.getCursive();
    L17:
        return new SpanStyle(0, 0, null, null, null, r2, null, 0, null, null, null, 0, null, null, null, null, 65503, null);
    L7:
        if (Intrinsics.areEqual(r0, r1.getMonospace().getName()) == false) goto L10;
        r2 = r1.getMonospace();
        goto L17
    L10:
        if (Intrinsics.areEqual(r0, r1.getSansSerif().getName()) == false) goto L13;
        r2 = r1.getSansSerif();
        goto L17
    L13:
        if (Intrinsics.areEqual(r0, r1.getSerif().getName()) == false) goto L15;
        r2 = r1.getSerif();
        goto L17
    L15:
        r2 = optionalFontFamilyFromName(r24.getFamily());
        goto L17
    }

    public static final TransferableContent toTransferableContent(InputContentInfoCompat r10, Bundle r11) {
        ClipEntry r5 = AndroidClipboardManager_androidKt.toClipEntry(new ClipData(r10.getDescription(), new ClipData.Item(r10.getContentUri())));
        int r7 = TransferableContent.Source.Companion.m466getKeyboardkB6V9T0();
        ClipMetadata r6 = AndroidClipboardManager_androidKt.toClipMetadata(r10.getDescription());
        Uri r12 = r10.getLinkUri();
        if (r11 != null) goto L6;
        r11 = Bundle.EMPTY;
    L6:
        return new TransferableContent(r5, r6, r7, new PlatformTransferableContent(r12, r11), null);
    }
}
