package androidx.compose.material3;

import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u000b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/DateVisualTransformation;", "Landroidx/compose/ui/text/input/VisualTransformation;", "dateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "<init>", "(Landroidx/compose/material3/internal/DateInputFormat;)V", "firstDelimiterOffset", "", "secondDelimiterOffset", "dateFormatLength", "dateOffsetTranslator", "androidx/compose/material3/DateVisualTransformation$dateOffsetTranslator$1", "Landroidx/compose/material3/DateVisualTransformation$dateOffsetTranslator$1;", "filter", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DateVisualTransformation implements VisualTransformation {
    private final int dateFormatLength;
    private final DateInputFormat dateInputFormat;
    private final DateVisualTransformation$dateOffsetTranslator$1 dateOffsetTranslator;
    private final int firstDelimiterOffset;
    private final int secondDelimiterOffset;

    /* JADX WARN: Type inference failed for: r8v3, types: [androidx.compose.material3.DateVisualTransformation$dateOffsetTranslator$1] */
    public DateVisualTransformation(DateInputFormat r8) {
        this.dateInputFormat = r8;
        this.firstDelimiterOffset = StringsKt.indexOf$default(r8.getPatternWithDelimiters(), r8.getDelimiter(), 0, false, 6, null);
        this.secondDelimiterOffset = StringsKt.lastIndexOf$default(r8.getPatternWithDelimiters(), r8.getDelimiter(), 0, false, 6, null);
        this.dateFormatLength = r8.getPatternWithoutDelimiters().length();
        this.dateOffsetTranslator = new DateVisualTransformation$dateOffsetTranslator$1(this);
    }

    public static final /* synthetic */ int access$getDateFormatLength$p(DateVisualTransformation r0) {
        return r0.dateFormatLength;
    }

    public static final /* synthetic */ int access$getFirstDelimiterOffset$p(DateVisualTransformation r0) {
        return r0.firstDelimiterOffset;
    }

    public static final /* synthetic */ int access$getSecondDelimiterOffset$p(DateVisualTransformation r0) {
        return r0.secondDelimiterOffset;
    }

    public TransformedText filter(AnnotatedString r7) {
        int r2 = 0;
        if (r7.getText().length() <= this.dateFormatLength) goto L5;
        String r8 = StringsKt.substring(r7.getText(), RangesKt.until(0, this.dateFormatLength));
    L6:
        String r0 = "";
        int r1 = 0;
    L8:
        if (r2 >= r8.length()) goto L16;
        int r4 = r1 + 1;
        r0 = r0 + r8.charAt(r2);
        if (r4 != this.firstDelimiterOffset) goto L12;
    L13:
        r0 = r0 + this.dateInputFormat.getDelimiter();
    L14:
        r2 = r2 + 1;
        r1 = r4;
        goto L8
    L12:
        if ((r1 + 2) != this.secondDelimiterOffset) goto L14;
    L16:
        return new TransformedText(new AnnotatedString(r0, null, 2, null), this.dateOffsetTranslator);
    L5:
        r8 = r7.getText();
        goto L6
    }
}
