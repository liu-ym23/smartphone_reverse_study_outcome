package org.apache.commons.lang3.time;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.dtf.face.api.IDTFacade;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes42.dex */
public class FastDateParser implements Serializable {
    private static final Strategy ABBREVIATED_YEAR_STRATEGY = null;
    private static final Strategy DAY_OF_MONTH_STRATEGY = null;
    private static final Strategy DAY_OF_WEEK_IN_MONTH_STRATEGY = null;
    private static final Strategy DAY_OF_WEEK_STRATEGY = null;
    private static final Strategy DAY_OF_YEAR_STRATEGY = null;
    private static final Strategy HOUR12_STRATEGY = null;
    private static final Strategy HOUR24_OF_DAY_STRATEGY = null;
    private static final Strategy HOUR_OF_DAY_STRATEGY = null;
    private static final Strategy HOUR_STRATEGY = null;
    static final Locale JAPANESE_IMPERIAL = null;
    private static final Strategy LITERAL_YEAR_STRATEGY = null;
    private static final Comparator<String> LONGER_FIRST_LOWERCASE = null;
    private static final Strategy MILLISECOND_STRATEGY = null;
    private static final Strategy MINUTE_STRATEGY = null;
    private static final Strategy NUMBER_MONTH_STRATEGY = null;
    private static final Strategy SECOND_STRATEGY = null;
    private static final Strategy WEEK_OF_MONTH_STRATEGY = null;
    private static final Strategy WEEK_OF_YEAR_STRATEGY = null;
    private static final ConcurrentMap<Locale, Strategy>[] caches = null;
    private static final long serialVersionUID = 3;
    private final int century;
    private final Locale locale;
    private final String pattern;
    private transient List<StrategyAndWidth> patterns;
    private final int startYear;
    private final TimeZone timeZone;

    public static class CaseInsensitiveTextStrategy extends PatternStrategy {
        private final int field;
        private final Map<String, Integer> lKeyValues;
        final Locale locale;

        public CaseInsensitiveTextStrategy(int r100, Calendar r101, Locale r102) {
            super(null);
            this.field = r100;
            this.locale = r102;
            StringBuilder r103 = new StringBuilder();
            r103.append("((?iu)");
            this.lKeyValues = FastDateParser.access$600(r101, r102, r100, r103);
            r103.setLength(r103.length() - 1);
            r103.append(")");
            createPattern(r103);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        public void setCalendar(FastDateParser r100, Calendar r101, String r102) {
            String r103 = r102.toLowerCase(this.locale);
            Integer r104 = this.lKeyValues.get(r103);
            if (r104 != null) goto L5;
            r104 = this.lKeyValues.get(r103 + '.');
        L5:
            r101.set(this.field, r104.intValue());
        }
    }

    public static class CopyQuotedStrategy extends Strategy {
        private final String formatField;

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean isNumber() {
            return false;
        }

        public CopyQuotedStrategy(String r100) {
            super(null);
            this.formatField = r100;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean parse(FastDateParser r100, Calendar r101, String r102, ParsePosition r103, int r104) {
            int r105 = 0;
        L4:
            if (r105 >= this.formatField.length()) goto L14;
            int r106 = r103.getIndex() + r105;
            if (r106 == r102.length()) goto L7;
            if (this.formatField.charAt(r105) != r102.charAt(r106)) goto L11;
            r105 = r105 + 1;
            goto L4
        L11:
            r103.setErrorIndex(r106);
            return false;
        L7:
            r103.setErrorIndex(r106);
            return false;
        L14:
            r103.setIndex(this.formatField.length() + r103.getIndex());
            return true;
        }
    }

    public static class ISO8601TimeZoneStrategy extends PatternStrategy {
        private static final Strategy ISO_8601_1_STRATEGY = null;
        private static final Strategy ISO_8601_2_STRATEGY = null;
        private static final Strategy ISO_8601_3_STRATEGY = null;

        static {
            ISO_8601_1_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}))");
            ISO_8601_2_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}\\d{2}))");
            ISO_8601_3_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}(?::)\\d{2}))");
        }

        public static /* synthetic */ Strategy access$400() {
            return ISO_8601_3_STRATEGY;
        }

        public ISO8601TimeZoneStrategy(String r100) {
            super(null);
            createPattern(r100);
        }

        public static Strategy getStrategy(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 != 3) goto L11;
            return ISO_8601_3_STRATEGY;
        L11:
            throw new IllegalArgumentException("invalid number of X");
        L13:
            return ISO_8601_2_STRATEGY;
        L15:
            return ISO_8601_1_STRATEGY;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        public void setCalendar(FastDateParser r100, Calendar r101, String r102) {
            r101.setTimeZone(FastTimeZone.getGmtTimeZone(r102));
        }
    }

    public static class NumberStrategy extends Strategy {
        private final int field;

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean isNumber() {
            return true;
        }

        public int modify(FastDateParser r100, int r101) {
            return r101;
        }

        public NumberStrategy(int r100) {
            super(null);
            this.field = r100;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean parse(FastDateParser r100, Calendar r101, String r102, ParsePosition r103, int r104) {
            int r105 = r103.getIndex();
            int r106 = r102.length();
            if (r104 != 0) goto L10;
        L4:
            if (r105 >= r106) goto L9;
            if (Character.isWhitespace(r102.charAt(r105)) == false) goto L9;
            r105 = r105 + 1;
        L9:
            r103.setIndex(r105);
        L13:
            if (r105 >= r106) goto L19;
            if (Character.isDigit(r102.charAt(r105)) == false) goto L19;
            r105 = r105 + 1;
        L19:
            if (r103.getIndex() != r105) goto L22;
            r103.setErrorIndex(r105);
            return false;
        L22:
            int r107 = CastIntegerProtector.parseInt(r102.substring(r103.getIndex(), r105));
            r103.setIndex(r105);
            r101.set(this.field, modify(r100, r107));
            return true;
        L10:
            int r108 = r104 + r105;
            if (r106 <= r108) goto L13;
            r106 = r108;
            goto L13
        }
    }

    public static abstract class PatternStrategy extends Strategy {
        private Pattern pattern;

        private PatternStrategy() {
            super(null);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean isNumber() {
            return false;
        }

        public abstract void setCalendar(FastDateParser r100, Calendar r101, String r102);

        public /* synthetic */ PatternStrategy(AnonymousClass1 r100) {
            this();
        }

        public void createPattern(StringBuilder r100) {
            createPattern(r100.toString());
        }

        public void createPattern(String r100) {
            this.pattern = PatternProtector.compile(r100);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean parse(FastDateParser r100, Calendar r101, String r102, ParsePosition r103, int r104) {
            Matcher r105 = this.pattern.matcher(r102.substring(r103.getIndex()));
            if (r105.lookingAt() == true) goto L6;
            r103.setErrorIndex(r103.getIndex());
            return false;
        L6:
            r103.setIndex(r103.getIndex() + r105.end(1));
            setCalendar(r100, r101, r105.group(1));
            return true;
        }
    }

    public static abstract class Strategy {
        private Strategy() {
        }

        public boolean isNumber() {
            return false;
        }

        public abstract boolean parse(FastDateParser r100, Calendar r101, String r102, ParsePosition r103, int r104);

        public /* synthetic */ Strategy(AnonymousClass1 r100) {
            this();
        }
    }

    public static class StrategyAndWidth {
        final Strategy strategy;
        final int width;

        public int getMaxWidth(ListIterator<StrategyAndWidth> r100) {
            if (this.strategy.isNumber() == true) goto L5;
            return 0;
        L5:
            if (r100.hasNext() == false) goto L13;
            Strategy r101 = r100.next().strategy;
            r100.previous();
            if (r101.isNumber() == true) goto L10;
            return 0;
        L10:
            return this.width;
        L13:
            return 0;
        }

        public StrategyAndWidth(Strategy r100, int r101) {
            this.strategy = r100;
            this.width = r101;
        }
    }

    public class StrategyParser {
        private int currentIdx;
        private final Calendar definingCalendar;
        final /* synthetic */ FastDateParser this$0;

        private StrategyAndWidth literal() {
            StringBuilder r100 = new StringBuilder();
            boolean r101 = false;
        L4:
            if (this.currentIdx >= FastDateParser.access$000(this.this$0).length()) goto L18;
            char r102 = FastDateParser.access$000(this.this$0).charAt(this.currentIdx);
            if (r101 == true) goto L11;
            if (FastDateParser.access$100(r102) == true) goto L18;
        L11:
            if (r102 != '\'') goto L17;
            int r103 = this.currentIdx + 1;
            this.currentIdx = r103;
            if (r103 == FastDateParser.access$000(this.this$0).length()) goto L16;
            if (FastDateParser.access$000(this.this$0).charAt(this.currentIdx) == '\'') goto L17;
        L16:
            r101 = !r101;
        L17:
            this.currentIdx++;
            r100.append(r102);
        L18:
            if (r101 == true) goto L22;
            String r104 = r100.toString();
            return new StrategyAndWidth(new CopyQuotedStrategy(r104), r104.length());
        L22:
            throw new IllegalArgumentException("Unterminated quote");
        }

        public StrategyAndWidth getNextStrategy() {
            if (this.currentIdx < FastDateParser.access$000(this.this$0).length()) goto L6;
            return null;
        L6:
            char r100 = FastDateParser.access$000(this.this$0).charAt(this.currentIdx);
            if (FastDateParser.access$100(r100) == false) goto L11;
            return letterPattern(r100);
        L11:
            return literal();
        }

        private StrategyAndWidth letterPattern(char r100) {
            int r101 = this.currentIdx;
        L3:
            int r102 = this.currentIdx + 1;
            this.currentIdx = r102;
            if (r102 >= FastDateParser.access$000(this.this$0).length()) goto L7;
            if (FastDateParser.access$000(this.this$0).charAt(this.currentIdx) == r100) goto L3;
        L7:
            int r103 = this.currentIdx - r101;
            return new StrategyAndWidth(FastDateParser.access$200(this.this$0, r100, r103, this.definingCalendar), r103);
        }

        public StrategyParser(FastDateParser r100, Calendar r101) {
            this.this$0 = r100;
            this.definingCalendar = r101;
        }
    }

    public static class TimeZoneStrategy extends PatternStrategy {
        private final Locale locale;
        private final Map<String, TzInfo> tzNames;

        public static class TzInfo {
            int dstOffset;
            TimeZone zone;

            public TzInfo(TimeZone r100, boolean r101) {
                this.zone = r100;
                if (r101 == false) goto L5;
                int r102 = r100.getDSTSavings();
            L6:
                this.dstOffset = r102;
                return;
            L5:
                r102 = 0;
                goto L6
            }
        }

        public TimeZoneStrategy(Locale r110) {
            super(null);
            this.tzNames = new HashMap();
            this.locale = r110;
            StringBuilder r100 = new StringBuilder();
            r100.append("((?iu)[+-]\\d{4}|GMT[+-]\\d{1,2}:\\d{2}");
            TreeSet r101 = new TreeSet(FastDateParser.access$800());
            String[][] r102 = DateFormatSymbols.getInstance(r110).getZoneStrings();
            int r103 = r102.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L24;
            String[] r105 = r102[r104];
            String r106 = r105[0];
            if (r106.equalsIgnoreCase("GMT") == true) goto L23;
            TimeZone r107 = TimeZone.getTimeZone(r106);
            TzInfo r108 = new TzInfo(r107, false);
            TzInfo r111 = r108;
            int r112 = 1;
        L9:
            if (r112 >= r105.length) goto L23;
            if (r112 != 3) goto L13;
            r111 = new TzInfo(r107, true);
        L17:
            String r113 = r105[r112];
            if (r113 == null) goto L22;
            String r114 = r113.toLowerCase(r110);
            if (r101.add(r114) == false) goto L22;
            this.tzNames.put(r114, r111);
        L22:
            r112 = r112 + 1;
            goto L9
        L13:
            if (r112 != 5) goto L17;
            r111 = r108;
        L23:
            r104 = r104 + 1;
            goto L3
        L24:
            Iterator r115 = r101.iterator();
        L26:
            if (r115.hasNext() == false) goto L28;
            String r109 = (String) r115.next();
            r100.append('|');
            FastDateParser.access$900(r100, r109);
            goto L26
        L28:
            r100.append(")");
            createPattern(r100);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        public void setCalendar(FastDateParser r100, Calendar r101, String r102) {
            TimeZone r103 = FastTimeZone.getGmtTimeZone(r102);
            if (r103 == null) goto L5;
            r101.setTimeZone(r103);
            return;
        L5:
            String r104 = r102.toLowerCase(this.locale);
            TzInfo r105 = this.tzNames.get(r104);
            if (r105 != null) goto L8;
            r105 = this.tzNames.get(r104 + '.');
        L8:
            r101.set(16, r105.dstOffset);
            r101.set(15, r105.zone.getRawOffset());
        }
    }

    private static boolean isFormatLetter(char r100) {
        if (r100 < 'A') goto L7;
        if (r100 > 'Z') goto L7;
    L10:
        return true;
    L7:
        if (r100 >= 'a') goto L9;
    L11:
        return false;
    L9:
        if (r100 > 'z') goto L11;
        goto L10
    }

    static {
        JAPANESE_IMPERIAL = new Locale(IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_JA, "JP", "JP");
        LONGER_FIRST_LOWERCASE = new AnonymousClass1();
        caches = new ConcurrentMap[17];
        final int r100 = 1;
        ABBREVIATED_YEAR_STRATEGY = new AnonymousClass2(r100);
        final int r101 = 2;
        NUMBER_MONTH_STRATEGY = new AnonymousClass3(r101);
        LITERAL_YEAR_STRATEGY = new NumberStrategy(1);
        WEEK_OF_YEAR_STRATEGY = new NumberStrategy(3);
        WEEK_OF_MONTH_STRATEGY = new NumberStrategy(4);
        DAY_OF_YEAR_STRATEGY = new NumberStrategy(6);
        DAY_OF_MONTH_STRATEGY = new NumberStrategy(5);
        final int r102 = 7;
        DAY_OF_WEEK_STRATEGY = new AnonymousClass4(r102);
        DAY_OF_WEEK_IN_MONTH_STRATEGY = new NumberStrategy(8);
        final int r103 = 11;
        HOUR_OF_DAY_STRATEGY = new NumberStrategy(11);
        HOUR24_OF_DAY_STRATEGY = new AnonymousClass5(r103);
        final int r104 = 10;
        HOUR12_STRATEGY = new AnonymousClass6(r104);
        HOUR_STRATEGY = new NumberStrategy(10);
        MINUTE_STRATEGY = new NumberStrategy(12);
        SECOND_STRATEGY = new NumberStrategy(13);
        MILLISECOND_STRATEGY = new NumberStrategy(14);
    }

    public int hashCode() {
        return this.pattern.hashCode() + ((this.timeZone.hashCode() + (this.locale.hashCode() * 13)) * 13);
    }

    public String toString() {
        return "FastDateParser[" + this.pattern + "," + this.locale + "," + this.timeZone.getID() + "]";
    }

    public static /* synthetic */ Comparator access$800() {
        return LONGER_FIRST_LOWERCASE;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String getPattern() {
        return this.pattern;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public static /* synthetic */ String access$000(FastDateParser r100) {
        return r100.pattern;
    }

    public static /* synthetic */ boolean access$100(char r100) {
        return isFormatLetter(r100);
    }

    private int adjustYear(int r100) {
        int r101 = this.century + r100;
        if (r100 < this.startYear) goto L6;
        return r101;
    L6:
        return r101 + 100;
    }

    private static ConcurrentMap<Locale, Strategy> getCache(int r100) {
        ConcurrentMap<Locale, Strategy>[] r101 = caches;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r101[r100] != null) goto L7;
        r101[r100] = new ConcurrentHashMap(3);     // Catch: Throwable -> L10
    L7:
        ConcurrentMap<Locale, Strategy> r102 = r101[r100];     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return r102;
    }

    private void init(Calendar r100) {
        this.patterns = new ArrayList();
        StrategyParser r101 = new StrategyParser(this, r100);
    L3:
        StrategyAndWidth r102 = r101.getNextStrategy();
        if (r102 == null) goto L5;
        this.patterns.add(r102);
        goto L3
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        init(Calendar.getInstance(this.timeZone, this.locale));
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof FastDateParser) == true) goto L5;
        return false;
    L5:
        FastDateParser r101 = (FastDateParser) r100;
        if (this.pattern.equals(r101.pattern) == true) goto L8;
        return false;
    L8:
        if (this.timeZone.equals(r101.timeZone) == true) goto L10;
        return false;
    L10:
        if (this.locale.equals(r101.locale) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public Date parse(String r100) throws ParseException {
        ParsePosition r101 = new ParsePosition(0);
        Date r102 = parse(r100, r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        if (this.locale.equals(JAPANESE_IMPERIAL) == false) goto L9;
        throw new ParseException("(The " + this.locale + " locale does not support dates before 1868 AD)\nUnparseable date: \"" + r100, r101.getErrorIndex());
    L9:
        throw new ParseException("Unparseable date: " + r100, r101.getErrorIndex());
    }

    public Object parseObject(String r100) throws ParseException {
        return parse(r100);
    }

    public static /* synthetic */ int access$700(FastDateParser r100, int r101) {
        return r100.adjustYear(r101);
    }

    public static /* synthetic */ StringBuilder access$900(StringBuilder r100, String r101) {
        return simpleQuote(r100, r101);
    }

    private Strategy getLocaleSpecificStrategy(int r100, Calendar r101) {
        ConcurrentMap<Locale, Strategy> r102 = getCache(r100);
        Strategy r103 = r102.get(this.locale);
        if (r103 == null) goto L5;
    L11:
        return r103;
    L5:
        if (r100 != 15) goto L7;
        r103 = new TimeZoneStrategy(this.locale);
    L8:
        Strategy r104 = r102.putIfAbsent(this.locale, r103);
        if (r104 == null) goto L11;
        return r104;
    L7:
        r103 = new CaseInsensitiveTextStrategy(r100, r101, this.locale);
        goto L8
    }

    private static StringBuilder simpleQuote(StringBuilder r100, String r101) {
        int r102 = 0;
    L4:
        if (r102 >= r101.length()) goto L23;
        char r103 = r101.charAt(r102);
        if (r103 == '$') goto L20;
        if (r103 == '.') goto L20;
        if (r103 == '?') goto L20;
        if (r103 == '^') goto L20;
        if (r103 == '[') goto L20;
        if (r103 == '\\') goto L20;
        if (r103 == '{') goto L20;
        if (r103 == '|') goto L20;
        switch(r103) {
            case 40: goto L20;
            case 41: goto L20;
            case 42: goto L20;
            case 43: goto L20;
            default: goto L21;
        };
    L21:
        r100.append(r103);
        r102 = r102 + 1;
    L20:
        r100.append('\\');
        goto L21
    L23:
        if (r100.charAt(r100.length() - 1) != '.') goto L25;
        r100.append('?');
    L25:
        return r100;
    }

    public Date parse(String r100, ParsePosition r101) {
        Calendar r102 = Calendar.getInstance(this.timeZone, this.locale);
        r102.clear();
        if (parse(r100, r101, r102) == true) goto L7;
        return null;
    L7:
        return r102.getTime();
    }

    public Object parseObject(String r100, ParsePosition r101) {
        return parse(r100, r101);
    }

    public FastDateParser(String r100, TimeZone r101, Locale r102) {
        this(r100, r101, r102, null);
    }

    private Strategy getStrategy(char r100, int r101, Calendar r102) {
        if (r100 != 'y') goto L5;
    L55:
        if (r101 <= 2) goto L58;
        return LITERAL_YEAR_STRATEGY;
    L58:
        return ABBREVIATED_YEAR_STRATEGY;
    L5:
        if (r100 == 'z') goto L54;
        switch(r100) {
            case 68: goto L52;
            case 69: goto L50;
            case 70: goto L48;
            case 71: goto L46;
            case 72: goto L44;
            default: goto L7;
        };
    L7:
        switch(r100) {
            case 75: goto L42;
            case 77: goto L37;
            case 83: goto L35;
            case 97: goto L33;
            case 100: goto L31;
            case 104: goto L29;
            case 107: goto L27;
            case 109: goto L25;
            case 115: goto L23;
            case 117: goto L21;
            case 119: goto L19;
            default: goto L8;
        };
    L8:
        switch(r100) {
            case 87: goto L17;
            case 88: goto L15;
            case 89: goto L55;
            case 90: goto L11;
            default: goto L10;
        };
    L11:
        if (r101 != 2) goto L54;
        return ISO8601TimeZoneStrategy.access$400();
    L10:
        throw new IllegalArgumentException("Format '" + r100 + "' not supported");
    L15:
        return ISO8601TimeZoneStrategy.getStrategy(r101);
    L17:
        return WEEK_OF_MONTH_STRATEGY;
    L19:
        return WEEK_OF_YEAR_STRATEGY;
    L21:
        return DAY_OF_WEEK_STRATEGY;
    L23:
        return SECOND_STRATEGY;
    L25:
        return MINUTE_STRATEGY;
    L27:
        return HOUR24_OF_DAY_STRATEGY;
    L29:
        return HOUR12_STRATEGY;
    L31:
        return DAY_OF_MONTH_STRATEGY;
    L33:
        return getLocaleSpecificStrategy(9, r102);
    L35:
        return MILLISECOND_STRATEGY;
    L37:
        if (r101 < 3) goto L40;
        return getLocaleSpecificStrategy(2, r102);
    L40:
        return NUMBER_MONTH_STRATEGY;
    L42:
        return HOUR_STRATEGY;
    L44:
        return HOUR_OF_DAY_STRATEGY;
    L46:
        return getLocaleSpecificStrategy(0, r102);
    L48:
        return DAY_OF_WEEK_IN_MONTH_STRATEGY;
    L50:
        return getLocaleSpecificStrategy(7, r102);
    L52:
        return DAY_OF_YEAR_STRATEGY;
    L54:
        return getLocaleSpecificStrategy(15, r102);
    }

    public boolean parse(String r100, ParsePosition r110, Calendar r111) {
        ListIterator<StrategyAndWidth> r101 = this.patterns.listIterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        StrategyAndWidth r102 = r101.next();
        int r103 = r102.getMaxWidth(r101);
        if (r102.strategy.parse(this, r111, r100, r110, r103) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public FastDateParser(String r100, TimeZone r101, Locale r102, Date r103) {
        this.pattern = r100;
        this.timeZone = r101;
        this.locale = r102;
        Calendar r104 = Calendar.getInstance(r101, r102);
        if (r103 == null) goto L6;
        r104.setTime(r103);
        int r105 = r104.get(1);
    L9:
        int r106 = (r105 / 100) * 100;
        this.century = r106;
        this.startYear = r105 - r106;
        init(r104);
        return;
    L6:
        if (r102.equals(JAPANESE_IMPERIAL) == false) goto L8;
        r105 = 0;
        goto L9
    L8:
        r104.setTime(new Date());
        r105 = r104.get(1) - 80;
        goto L9
    }

    public static /* synthetic */ Strategy access$200(FastDateParser r100, char r101, int r102, Calendar r103) {
        return r100.getStrategy(r101, r102, r103);
    }

    public static /* synthetic */ Map access$600(Calendar r100, Locale r101, int r102, StringBuilder r103) {
        return appendDisplayNames(r100, r101, r102, r103);
    }

    private static Map<String, Integer> appendDisplayNames(Calendar r100, Locale r101, int r102, StringBuilder r103) {
        HashMap r104 = new HashMap();
        Map<String, Integer> r105 = r100.getDisplayNames(r102, 0, r101);
        TreeSet r106 = new TreeSet(LONGER_FIRST_LOWERCASE);
        Iterator<Map.Entry<String, Integer>> r107 = r105.entrySet().iterator();
    L4:
        if (r107.hasNext() == false) goto L8;
        Map.Entry<String, Integer> r108 = r107.next();
        String r109 = r108.getKey().toLowerCase(r101);
        if (r106.add(r109) == false) goto L4;
        r104.put(r109, r108.getValue());
        goto L4
    L8:
        Iterator r110 = r106.iterator();
    L10:
        if (r110.hasNext() == false) goto L12;
        simpleQuote(r103, (String) r110.next()).append('|');
        goto L10
    L12:
        return r104;
    }
}
