package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.material3.internal.Strings_androidKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\n\u0010 \u001a\u00060!j\u0002`\"¢\u0006\u0004\b#\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016¨\u0006%"}, d2 = {"Landroidx/compose/material3/DateInputValidator;", "", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "dateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "errorDatePattern", "", "errorDateOutOfYearRange", "errorInvalidNotAllowed", "errorInvalidRangeInput", "<init>", "(Lkotlin/ranges/IntRange;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/internal/DateInputFormat;Landroidx/compose/material3/DatePickerFormatter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "currentStartDateMillis", "", "getCurrentStartDateMillis", "()Ljava/lang/Long;", "setCurrentStartDateMillis", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "currentEndDateMillis", "getCurrentEndDateMillis", "setCurrentEndDateMillis", "validate", "dateToValidate", "Landroidx/compose/material3/internal/CalendarDate;", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "validate-XivgLIo", "(Landroidx/compose/material3/internal/CalendarDate;ILjava/util/Locale;)Ljava/lang/String;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DateInputValidator {
    public static final int $stable = 0;
    private Long currentEndDateMillis;
    private Long currentStartDateMillis;
    private final DatePickerFormatter dateFormatter;
    private final DateInputFormat dateInputFormat;
    private final String errorDateOutOfYearRange;
    private final String errorDatePattern;
    private final String errorInvalidNotAllowed;
    private final String errorInvalidRangeInput;
    private final SelectableDates selectableDates;
    private final IntRange yearRange;

    public final Long getCurrentEndDateMillis() {
        return this.currentEndDateMillis;
    }

    public final Long getCurrentStartDateMillis() {
        return this.currentStartDateMillis;
    }

    public final void setCurrentEndDateMillis(Long r1) {
        this.currentEndDateMillis = r1;
    }

    public final void setCurrentStartDateMillis(Long r1) {
        this.currentStartDateMillis = r1;
    }

    /* JADX INFO: renamed from: validate-XivgLIo, reason: not valid java name */
    public final String m2549validateXivgLIo(CalendarDate r11, int r12, Locale r13) {
        if (r11 != null) goto L7;
        return Strings_androidKt.formatString(this.errorDatePattern, new Object[]{this.dateInputFormat.getPatternWithDelimiters().toUpperCase(Locale.ROOT)});
    L7:
        if (this.yearRange.contains(r11.getYear()) == false) goto L9;
        SelectableDates r2 = this.selectableDates;
        if (r2.isSelectableYear(r11.getYear()) == false) goto L36;
        if (r2.isSelectableDate(r11.getUtcTimeMillis()) == false) goto L36;
        InputIdentifier.Companion r14 = InputIdentifier.Companion;
        if (InputIdentifier.m2802equalsimpl0(r12, r14.m2808getStartDateInputJ2x2o4M()) == false) goto L24;
        long r0 = r11.getUtcTimeMillis();
        Long r3 = this.currentEndDateMillis;
        if (r3 == null) goto L20;
        long r4 = r3.longValue();
    L22:
        if (r0 <= r4) goto L24;
    L32:
        return this.errorInvalidRangeInput;
    L20:
        r4 = Long.MAX_VALUE;
    L24:
        if (InputIdentifier.m2802equalsimpl0(r12, r14.m2806getEndDateInputJ2x2o4M()) == false) goto L33;
        long r15 = r11.getUtcTimeMillis();
        Long r16 = this.currentStartDateMillis;
        if (r16 == null) goto L28;
        long r1 = r16.longValue();
    L30:
        if (r15 < r1) goto L32;
        return "";
    L28:
        r1 = Long.MIN_VALUE;
        goto L30
    L33:
        return "";
    L36:
        return Strings_androidKt.formatString(this.errorInvalidNotAllowed, new Object[]{DatePickerFormatter.CC.formatDate$default(this.dateFormatter, Long.valueOf(r11.getUtcTimeMillis()), r13, false, 4, null)});
    L9:
        return Strings_androidKt.formatString(this.errorDateOutOfYearRange, new Object[]{CalendarLocale_jvmKt.toLocalString$default(this.yearRange.getFirst(), 0, 0, false, r13, 7, null), CalendarLocale_jvmKt.toLocalString$default(this.yearRange.getLast(), 0, 0, false, r13, 7, null)});
    }

    public DateInputValidator(IntRange r1, SelectableDates r2, DateInputFormat r3, DatePickerFormatter r4, String r5, String r6, String r7, String r8) {
        this.yearRange = r1;
        this.selectableDates = r2;
        this.dateInputFormat = r3;
        this.dateFormatter = r4;
        this.errorDatePattern = r5;
        this.errorDateOutOfYearRange = r6;
        this.errorInvalidNotAllowed = r7;
        this.errorInvalidRangeInput = r8;
    }
}
