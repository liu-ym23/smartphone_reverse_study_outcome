package org.apache.commons.lang3.time;

import com.ss.android.download.api.constant.BaseConstants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.exception.ExceptionUtils;

/* JADX INFO: loaded from: classes42.dex */
public class FastDatePrinter implements Serializable {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final ConcurrentMap<TimeZoneDisplayKey, String> cTimeZoneDisplayCache = null;
    private static final long serialVersionUID = 1;
    private final Locale mLocale;
    private transient int mMaxLengthEstimate;
    private final String mPattern;
    private transient Rule[] mRules;
    private final TimeZone mTimeZone;

    public static class CharacterLiteral implements Rule {
        private final char mValue;

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 1;
        }

        public CharacterLiteral(char r100) {
            this.mValue = r100;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable r100, Calendar r101) throws IOException {
            r100.append(this.mValue);
        }
    }

    public static class DayInWeekField implements NumberRule {
        private final NumberRule mRule;

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public DayInWeekField(NumberRule r100) {
            this.mRule = r100;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable r100, Calendar r101) throws IOException {
            int r102 = 7;
            int r103 = r101.get(7);
            NumberRule r104 = this.mRule;
            if (r103 == 1) goto L6;
            r102 = r103 - 1;
        L6:
            r104.appendTo(r100, r102);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable r100, int r101) throws IOException {
            this.mRule.appendTo(r100, r101);
        }
    }

    public static class Iso8601_Rule implements Rule {
        static final Iso8601_Rule ISO8601_HOURS = null;
        static final Iso8601_Rule ISO8601_HOURS_COLON_MINUTES = null;
        static final Iso8601_Rule ISO8601_HOURS_MINUTES = null;
        final int length;

        static {
            ISO8601_HOURS = new Iso8601_Rule(3);
            ISO8601_HOURS_MINUTES = new Iso8601_Rule(5);
            ISO8601_HOURS_COLON_MINUTES = new Iso8601_Rule(6);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.length;
        }

        public Iso8601_Rule(int r100) {
            this.length = r100;
        }

        public static Iso8601_Rule getRule(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 != 3) goto L11;
            return ISO8601_HOURS_COLON_MINUTES;
        L11:
            throw new IllegalArgumentException("invalid number of X");
        L13:
            return ISO8601_HOURS_MINUTES;
        L15:
            return ISO8601_HOURS;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable r100, Calendar r101) throws IOException {
            int r102 = r101.get(15) + r101.get(16);
            if (r102 != 0) goto L6;
            r100.append("Z");
            return;
        L6:
            if (r102 >= 0) goto L8;
            r100.append('-');
            r102 = -r102;
        L9:
            int r103 = r102 / BaseConstants.Time.HOUR;
            FastDatePrinter.access$000(r100, r103);
            int r104 = this.length;
            if (r104 >= 5) goto L13;
            return;
        L13:
            if (r104 != 6) goto L15;
            r100.append(':');
        L15:
            FastDatePrinter.access$000(r100, (r102 / 60000) - (r103 * 60));
            return;
        L8:
            r100.append('+');
            goto L9
        }
    }

    public interface NumberRule extends Rule {
        void appendTo(Appendable r100, int r101) throws IOException;
    }

    public static class PaddedNumberField implements NumberRule {
        private final int mField;
        private final int mSize;

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mSize;
        }

        public PaddedNumberField(int r100, int r101) {
            if (r101 < 3) goto L7;
            this.mField = r100;
            this.mSize = r101;
            return;
        L7:
            throw new IllegalArgumentException();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable r100, Calendar r101) throws IOException {
            appendTo(r100, r101.get(this.mField));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable r100, int r101) throws IOException {
            FastDatePrinter.access$100(r100, r101, this.mSize);
        }
    }

    public interface Rule {
        void appendTo(Appendable r100, Calendar r101) throws IOException;

        int estimateLength();
    }

    public static class StringLiteral implements Rule {
        private final String mValue;

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mValue.length();
        }

        public StringLiteral(String r100) {
            this.mValue = r100;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable r100, Calendar r101) throws IOException {
            r100.append(this.mValue);
        }
    }

    public static class TextField implements Rule {
        private final int mField;
        private final String[] mValues;

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            int r100 = this.mValues.length;
            int r101 = 0;
        L3:
            r100 = r100 - 1;
            if (r100 < 0) goto L8;
            int r102 = this.mValues[r100].length();
            if (r102 <= r101) goto L3;
            r101 = r102;
            goto L3
        L8:
            return r101;
        }

        public TextField(int r100, String[] r101) {
            this.mField = r100;
            this.mValues = r101;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable r100, Calendar r101) throws IOException {
            r100.append(this.mValues[r101.get(this.mField)]);
        }
    }

    public static class TimeZoneDisplayKey {
        private final Locale mLocale;
        private final int mStyle;
        private final TimeZone mTimeZone;

        public int hashCode() {
            return (((this.mStyle * 31) + this.mLocale.hashCode()) * 31) + this.mTimeZone.hashCode();
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof TimeZoneDisplayKey) == false) goto L16;
            TimeZoneDisplayKey r101 = (TimeZoneDisplayKey) r100;
            if (this.mTimeZone.equals(r101.mTimeZone) == true) goto L10;
        L14:
            return false;
        L10:
            if (this.mStyle != r101.mStyle) goto L14;
            if (this.mLocale.equals(r101.mLocale) == false) goto L14;
            return true;
        L16:
            return false;
        }

        public TimeZoneDisplayKey(TimeZone r100, boolean r101, int r102, Locale r103) {
            this.mTimeZone = r100;
            if (r101 == false) goto L5;
            this.mStyle = Integer.MIN_VALUE | r102;
        L6:
            this.mLocale = r103;
            return;
        L5:
            this.mStyle = r102;
            goto L6
        }
    }

    public static class TimeZoneNameRule implements Rule {
        private final String mDaylight;
        private final Locale mLocale;
        private final String mStandard;
        private final int mStyle;

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return Math.max(this.mStandard.length(), this.mDaylight.length());
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable r100, Calendar r101) throws IOException {
            TimeZone r102 = r101.getTimeZone();
            if (r101.get(16) != 0) goto L5;
            r100.append(FastDatePrinter.getTimeZoneDisplay(r102, false, this.mStyle, this.mLocale));
            return;
        L5:
            r100.append(FastDatePrinter.getTimeZoneDisplay(r102, true, this.mStyle, this.mLocale));
        }

        public TimeZoneNameRule(TimeZone r100, Locale r101, int r102) {
            this.mLocale = r101;
            this.mStyle = r102;
            this.mStandard = FastDatePrinter.getTimeZoneDisplay(r100, false, r102, r101);
            this.mDaylight = FastDatePrinter.getTimeZoneDisplay(r100, true, r102, r101);
        }
    }

    public static class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule INSTANCE_COLON = null;
        static final TimeZoneNumberRule INSTANCE_NO_COLON = null;
        final boolean mColon;

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 5;
        }

        static {
            INSTANCE_COLON = new TimeZoneNumberRule(true);
            INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        }

        public TimeZoneNumberRule(boolean r100) {
            this.mColon = r100;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable r100, Calendar r101) throws IOException {
            int r102 = r101.get(15) + r101.get(16);
            if (r102 >= 0) goto L5;
            r100.append('-');
            r102 = -r102;
        L6:
            int r103 = r102 / BaseConstants.Time.HOUR;
            FastDatePrinter.access$000(r100, r103);
            if (this.mColon == false) goto L9;
            r100.append(':');
        L9:
            FastDatePrinter.access$000(r100, (r102 / 60000) - (r103 * 60));
            return;
        L5:
            r100.append('+');
            goto L6
        }
    }

    public static class TwelveHourField implements NumberRule {
        private final NumberRule mRule;

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public TwelveHourField(NumberRule r100) {
            this.mRule = r100;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable r100, Calendar r101) throws IOException {
            int r102 = r101.get(10);
            if (r102 != 0) goto L5;
            r102 = r101.getLeastMaximum(10) + 1;
        L5:
            this.mRule.appendTo(r100, r102);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable r100, int r101) throws IOException {
            this.mRule.appendTo(r100, r101);
        }
    }

    public static class TwentyFourHourField implements NumberRule {
        private final NumberRule mRule;

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public TwentyFourHourField(NumberRule r100) {
            this.mRule = r100;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable r100, Calendar r101) throws IOException {
            int r102 = r101.get(11);
            if (r102 != 0) goto L5;
            r102 = r101.getMaximum(11) + 1;
        L5:
            this.mRule.appendTo(r100, r102);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable r100, int r101) throws IOException {
            this.mRule.appendTo(r100, r101);
        }
    }

    public static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField INSTANCE = null;

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        static {
            INSTANCE = new TwoDigitMonthField();
        }

        public TwoDigitMonthField() {
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable r100, Calendar r101) throws IOException {
            appendTo(r100, r101.get(2) + 1);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable r100, int r101) throws IOException {
            FastDatePrinter.access$000(r100, r101);
        }
    }

    public static class TwoDigitNumberField implements NumberRule {
        private final int mField;

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        public TwoDigitNumberField(int r100) {
            this.mField = r100;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable r100, int r101) throws IOException {
            if (r101 >= 100) goto L5;
            FastDatePrinter.access$000(r100, r101);
            return;
        L5:
            FastDatePrinter.access$100(r100, r101, 2);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable r100, Calendar r101) throws IOException {
            appendTo(r100, r101.get(this.mField));
        }
    }

    public static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField INSTANCE = null;

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        static {
            INSTANCE = new TwoDigitYearField();
        }

        public TwoDigitYearField() {
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable r100, Calendar r101) throws IOException {
            appendTo(r100, r101.get(1) % 100);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable r100, int r101) throws IOException {
            FastDatePrinter.access$000(r100, r101);
        }
    }

    public static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField INSTANCE = null;

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        static {
            INSTANCE = new UnpaddedMonthField();
        }

        public UnpaddedMonthField() {
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable r100, int r101) throws IOException {
            if (r101 >= 10) goto L5;
            r100.append((char) (r101 + 48));
            return;
        L5:
            FastDatePrinter.access$000(r100, r101);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable r100, Calendar r101) throws IOException {
            appendTo(r100, r101.get(2) + 1);
        }
    }

    public static class UnpaddedNumberField implements NumberRule {
        private final int mField;

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 4;
        }

        public UnpaddedNumberField(int r100) {
            this.mField = r100;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable r100, int r101) throws IOException {
            if (r101 >= 10) goto L6;
            r100.append((char) (r101 + 48));
            return;
        L6:
            if (r101 >= 100) goto L8;
            FastDatePrinter.access$000(r100, r101);
            return;
        L8:
            FastDatePrinter.access$100(r100, r101, 1);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable r100, Calendar r101) throws IOException {
            appendTo(r100, r101.get(this.mField));
        }
    }

    public static class WeekYear implements NumberRule {
        private final NumberRule mRule;

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public WeekYear(NumberRule r100) {
            this.mRule = r100;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable r100, Calendar r101) throws IOException {
            this.mRule.appendTo(r100, r101.getWeekYear());
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable r100, int r101) throws IOException {
            this.mRule.appendTo(r100, r101);
        }
    }

    static {
        cTimeZoneDisplayCache = new ConcurrentHashMap(7);
    }

    private Calendar newCalendar() {
        return Calendar.getInstance(this.mTimeZone, this.mLocale);
    }

    public int hashCode() {
        return this.mPattern.hashCode() + ((this.mTimeZone.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v6, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.lang.Object] */
    public List<Rule> parsePattern() {
        DateFormatSymbols r100 = new DateFormatSymbols(this.mLocale);
        ArrayList r101 = new ArrayList();
        String[] r102 = r100.getEras();
        String[] r103 = r100.getMonths();
        String[] r104 = r100.getShortMonths();
        String[] r105 = r100.getWeekdays();
        String[] r106 = r100.getShortWeekdays();
        String[] r107 = r100.getAmPmStrings();
        int r108 = this.mPattern.length();
        int[] r110 = new int[1];
        int r111 = 0;
        int r112 = 0;
    L3:
        if (r112 >= r108) goto L73;
        r110[r111] = r112;
        String r113 = parseToken(this.mPattern, r110);
        int r114 = r110[r111];
        int r115 = r113.length();
        if (r115 == 0) goto L73;
        char r116 = r113.charAt(r111);
        if (r116 != 'y') goto L10;
    L24:
        r111 = 0;
        if (r115 != 2) goto L65;
        ?? r117 = TwoDigitYearField.INSTANCE;
    L70:
        if (r116 != 'Y') goto L72;
        r117 = new WeekYear(r117);
    L72:
        r101.add(r117);
        r112 = r114 + 1;
        goto L3
    L65:
        if (r115 >= 4) goto L67;
        int r109 = 1;
        r115 = 4;
    L68:
        r117 = selectNumberRule(r109, r115);
        goto L70
    L67:
        r109 = 1;
        goto L68
    L10:
        if (r116 != 'z') goto L12;
        if (r115 < 4) goto L62;
        Object r118 = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 1);
    L36:
        r117 = r118;
    L37:
        r111 = 0;
        goto L72
    L62:
        r118 = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 0);
        goto L36
    L12:
        switch(r116) {
            case 39: goto L56;
            case 75: goto L55;
            case 77: goto L47;
            case 83: goto L46;
            case 97: goto L45;
            case 100: goto L44;
            case 104: goto L43;
            case 107: goto L42;
            case 109: goto L41;
            case 115: goto L40;
            case 117: goto L39;
            case 119: goto L38;
            default: goto L13;
        };
    L13:
        switch(r116) {
            case 68: goto L35;
            case 69: goto L31;
            case 70: goto L29;
            case 71: goto L28;
            case 72: goto L27;
            default: goto L14;
        };
    L14:
        switch(r116) {
            case 87: goto L26;
            case 88: goto L25;
            case 89: goto L24;
            case 90: goto L18;
            default: goto L16;
        };
    L25:
        r118 = Iso8601_Rule.getRule(r115);
        goto L36
    L26:
        r118 = selectNumberRule(4, r115);
        goto L36
    L18:
        if (r115 != 1) goto L21;
        r118 = TimeZoneNumberRule.INSTANCE_NO_COLON;
        goto L36
    L21:
        if (r115 != 2) goto L23;
        r118 = Iso8601_Rule.ISO8601_HOURS_COLON_MINUTES;
        goto L36
    L23:
        r118 = TimeZoneNumberRule.INSTANCE_COLON;
        goto L36
    L16:
        throw new IllegalArgumentException("Illegal pattern component: ".concat(r113));
    L27:
        r118 = selectNumberRule(11, r115);
        goto L36
    L28:
        r111 = 0;
        r117 = new TextField(0, r102);
        goto L72
    L29:
        r118 = selectNumberRule(8, r115);
        goto L36
    L35:
        r118 = selectNumberRule(6, r115);
        goto L36
    L31:
        if (r115 >= 4) goto L33;
        String[] r119 = r106;
    L34:
        r117 = new TextField(7, r119);
        goto L37
    L33:
        r119 = r105;
        goto L34
    L38:
        r118 = selectNumberRule(3, r115);
        goto L36
    L39:
        r118 = new DayInWeekField(selectNumberRule(7, r115));
        goto L36
    L40:
        r118 = selectNumberRule(13, r115);
        goto L36
    L41:
        r118 = selectNumberRule(12, r115);
        goto L36
    L42:
        r118 = new TwentyFourHourField(selectNumberRule(11, r115));
        goto L36
    L43:
        r118 = new TwelveHourField(selectNumberRule(10, r115));
        goto L36
    L44:
        r118 = selectNumberRule(5, r115);
        goto L36
    L45:
        r118 = new TextField(9, r107);
        goto L36
    L46:
        r118 = selectNumberRule(14, r115);
        goto L36
    L47:
        if (r115 < 4) goto L50;
        r118 = new TextField(2, r103);
        goto L36
    L50:
        if (r115 != 3) goto L52;
        r118 = new TextField(2, r104);
        goto L36
    L52:
        if (r115 != 2) goto L54;
        r118 = TwoDigitMonthField.INSTANCE;
        goto L36
    L54:
        r118 = UnpaddedMonthField.INSTANCE;
        goto L36
    L55:
        r118 = selectNumberRule(10, r115);
        goto L36
    L56:
        String r120 = r113.substring(1);
        if (r120.length() != 1) goto L59;
        r118 = new CharacterLiteral(r120.charAt(0));
        goto L36
    L59:
        r118 = new StringLiteral(r120);
    L73:
        return r101;
    }

    public String toString() {
        return "FastDatePrinter[" + this.mPattern + "," + this.mLocale + "," + this.mTimeZone.getID() + "]";
    }

    private void init() {
        List<Rule> r100 = parsePattern();
        Rule[] r101 = (Rule[]) r100.toArray(new Rule[r100.size()]);
        this.mRules = r101;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        r102 = r102 - 1;
        if (r102 < 0) goto L6;
        r103 = r103 + this.mRules[r102].estimateLength();
        goto L3
    L6:
        this.mMaxLengthEstimate = r103;
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    public String getPattern() {
        return this.mPattern;
    }

    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    private String applyRulesToString(Calendar r100) {
        return ((StringBuilder) applyRules(r100, new StringBuilder(this.mMaxLengthEstimate))).toString();
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        init();
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof FastDatePrinter) == true) goto L5;
        return false;
    L5:
        FastDatePrinter r101 = (FastDatePrinter) r100;
        if (this.mPattern.equals(r101.mPattern) == true) goto L8;
        return false;
    L8:
        if (this.mTimeZone.equals(r101.mTimeZone) == true) goto L10;
        return false;
    L10:
        if (this.mLocale.equals(r101.mLocale) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public String format(Object r100) {
        if ((r100 instanceof Date) == false) goto L7;
        return format((Date) r100);
    L7:
        if ((r100 instanceof Calendar) == false) goto L11;
        return format((Calendar) r100);
    L11:
        if ((r100 instanceof Long) == false) goto L15;
        return format(((Long) r100).longValue());
    L15:
        if (r100 != null) goto L17;
        String r101 = "<null>";
    L19:
        throw new IllegalArgumentException("Unknown class: ".concat(r101));
    L17:
        r101 = r100.getClass().getName();
        goto L19
    }

    public String format(Calendar r100) {
        return ((StringBuilder) format(r100, new StringBuilder(this.mMaxLengthEstimate))).toString();
    }

    public String format(long r100) {
        Calendar r101 = newCalendar();
        r101.setTimeInMillis(r100);
        return applyRulesToString(r101);
    }

    public String format(Date r100) {
        Calendar r101 = newCalendar();
        r101.setTime(r100);
        return applyRulesToString(r101);
    }

    public static /* synthetic */ void access$000(Appendable r100, int r101) throws IOException {
        appendDigits(r100, r101);
    }

    private static void appendDigits(Appendable r100, int r101) throws IOException {
        r100.append((char) ((r101 / 10) + 48));
        r100.append((char) ((r101 % 10) + 48));
    }

    private <B extends Appendable> B applyRules(Calendar r100, B r101) {
        Rule[] r102 = this.mRules;     // Catch: IOException -> L6
        int r103 = r102.length;     // Catch: IOException -> L6
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        r102[r104].appendTo(r101, r100);     // Catch: IOException -> L6
        r104 = r104 + 1;
    L8:
        return r101;
    L6:
        e = move-exception;
        ExceptionUtils.rethrow(e);
        goto L8
    }

    public <B extends Appendable> B format(Calendar r100, B r101) {
        if (r100.getTimeZone().equals(this.mTimeZone) == true) goto L6;
        r100 = (Calendar) r100.clone();
        r100.setTimeZone(this.mTimeZone);
    L6:
        return (B) applyRules(r100, r101);
    }

    public String parseToken(String r110, int[] r111) {
        StringBuilder r100 = new StringBuilder();
        int r101 = r111[0];
        int r102 = r110.length();
        char r103 = r110.charAt(r101);
        if (r103 < 'A') goto L6;
        if (r103 > 'Z') goto L6;
    L8:
        r100.append(r103);
    L9:
        int r104 = r101 + 1;
        if (r104 >= r102) goto L32;
        if (r110.charAt(r104) != r103) goto L32;
        r100.append(r103);
        r101 = r104;
    L32:
        r111[0] = r101;
        return r100.toString();
    L6:
        if (r103 < 'a') goto L14;
        if (r103 <= 'z') goto L8;
    L14:
        r100.append('\'');
        boolean r105 = false;
    L15:
        if (r101 >= r102) goto L32;
        char r112 = r110.charAt(r101);
        if (r112 != '\'') goto L24;
        int r113 = r101 + 1;
        if (r113 < r102) goto L21;
    L23:
        r105 = !r105;
    L31:
        r101 = r101 + 1;
        goto L15
    L21:
        if (r110.charAt(r113) != '\'') goto L23;
        r100.append(r112);
        r101 = r113;
        goto L31
    L24:
        if (r105 == true) goto L30;
        if (r112 < 'A') goto L27;
        if (r112 > 'Z') goto L27;
    L29:
        r101 = r101 - 1;
    L27:
        if (r112 < 'a') goto L30;
        if (r112 <= 'z') goto L29;
    L30:
        r100.append(r112);
        goto L31
    }

    public NumberRule selectNumberRule(int r100, int r101) {
        if (r101 == 1) goto L11;
        if (r101 == 2) goto L9;
        return new PaddedNumberField(r100, r101);
    L9:
        return new TwoDigitNumberField(r100);
    L11:
        return new UnpaddedNumberField(r100);
    }

    public StringBuffer applyRules(Calendar r100, StringBuffer r101) {
        return (StringBuffer) applyRules(r100, r101);
    }

    public StringBuffer format(long r100, StringBuffer r101) {
        Calendar r102 = newCalendar();
        r102.setTimeInMillis(r100);
        return (StringBuffer) applyRules(r102, r101);
    }

    public StringBuffer format(Date r100, StringBuffer r101) {
        Calendar r102 = newCalendar();
        r102.setTime(r100);
        return (StringBuffer) applyRules(r102, r101);
    }

    public <B extends Appendable> B format(long r100, B r101) {
        Calendar r102 = newCalendar();
        r102.setTimeInMillis(r100);
        return (B) applyRules(r102, r101);
    }

    public <B extends Appendable> B format(Date r100, B r101) {
        Calendar r102 = newCalendar();
        r102.setTime(r100);
        return (B) applyRules(r102, r101);
    }

    public StringBuffer format(Calendar r100, StringBuffer r101) {
        return format(r100.getTime(), r101);
    }

    public FastDatePrinter(String r100, TimeZone r101, Locale r102) {
        this.mPattern = r100;
        this.mTimeZone = r101;
        this.mLocale = r102;
        init();
    }

    public static /* synthetic */ void access$100(Appendable r100, int r101, int r102) throws IOException {
        appendFullDigits(r100, r101, r102);
    }

    private static void appendFullDigits(Appendable r100, int r101, int r110) throws IOException {
        if (r101 < 10000) goto L5;
        char[] r102 = new char[10];
        int r103 = 0;
    L29:
        if (r101 == 0) goto L31;
        r102[r103] = (char) ((r101 % 10) + 48);
        r101 = r101 / 10;
        r103 = r103 + 1;
    L31:
        if (r103 >= r110) goto L33;
        r100.append('0');
        r110 = r110 - 1;
    L33:
        r103 = r103 - 1;
        if (r103 < 0) goto L42;
        r100.append(r102[r103]);
        goto L33
    L42:
        return;
    L5:
        if (r101 >= 1000) goto L11;
        if (r101 >= 100) goto L10;
        if (r101 >= 10) goto L9;
        int r104 = 1;
    L12:
        int r111 = r110 - r104;
    L13:
        if (r111 <= 0) goto L15;
        r100.append('0');
        r111 = r111 - 1;
        goto L13
    L15:
        if (r104 == 1) goto L27;
        if (r104 == 2) goto L24;
        if (r104 == 3) goto L21;
        if (r104 != 4) goto L41;
        r100.append((char) ((r101 / 1000) + 48));
        r101 = r101 % 1000;
        goto L21
    L41:
        return;
    L21:
        if (r101 < 100) goto L23;
        r100.append((char) ((r101 / 100) + 48));
        r101 = r101 % 100;
        goto L24
    L23:
        r100.append('0');
    L24:
        if (r101 < 10) goto L26;
        r100.append((char) ((r101 / 10) + 48));
        r101 = r101 % 10;
        goto L27
    L26:
        r100.append('0');
    L27:
        r100.append((char) (r101 + 48));
        return;
    L9:
        r104 = 2;
        goto L12
    L10:
        r104 = 3;
        goto L12
    L11:
        r104 = 4;
        goto L12
    }

    public StringBuffer format(Object r100, StringBuffer r101, FieldPosition r102) {
        if ((r100 instanceof Date) == false) goto L7;
        return format((Date) r100, r101);
    L7:
        if ((r100 instanceof Calendar) == false) goto L11;
        return format((Calendar) r100, r101);
    L11:
        if ((r100 instanceof Long) == false) goto L15;
        return format(((Long) r100).longValue(), r101);
    L15:
        if (r100 != null) goto L17;
        String r103 = "<null>";
    L19:
        throw new IllegalArgumentException("Unknown class: ".concat(r103));
    L17:
        r103 = r100.getClass().getName();
        goto L19
    }

    public static String getTimeZoneDisplay(TimeZone r100, boolean r101, int r102, Locale r103) {
        TimeZoneDisplayKey r104 = new TimeZoneDisplayKey(r100, r101, r102, r103);
        ConcurrentMap<TimeZoneDisplayKey, String> r105 = cTimeZoneDisplayCache;
        String r106 = r105.get(r104);
        if (r106 != null) goto L8;
        String r107 = r100.getDisplayName(r101, r102, r103);
        String r108 = r105.putIfAbsent(r104, r107);
        if (r108 != null) goto L7;
        return r107;
    L7:
        return r108;
    L8:
        return r106;
    }
}
