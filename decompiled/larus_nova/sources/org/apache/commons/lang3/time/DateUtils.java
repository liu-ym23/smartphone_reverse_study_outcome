package org.apache.commons.lang3.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public class DateUtils {
    private static final int[][] fields = null;

    public static final enum ModifyType extends Enum<ModifyType> {
        private static final /* synthetic */ ModifyType[] $VALUES = null;
        public static final ModifyType CEILING = null;
        public static final ModifyType ROUND = null;
        public static final ModifyType TRUNCATE = null;

        static {
            ModifyType r100 = new ModifyType("TRUNCATE", 0);
            TRUNCATE = r100;
            ModifyType r101 = new ModifyType("ROUND", 1);
            ROUND = r101;
            ModifyType r102 = new ModifyType("CEILING", 2);
            CEILING = r102;
            $VALUES = new ModifyType[]{r100, r101, r102};
        }

        public static ModifyType[] values() {
            return (ModifyType[]) $VALUES.clone();
        }

        public static ModifyType valueOf(String r100) {
            return (ModifyType) a.a(ModifyType.class, r100);
        }

        private ModifyType(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        fields = new int[][]{new int[]{14}, new int[]{13}, new int[]{12}, new int[]{11, 10}, new int[]{5, 5, 9}, new int[]{2, 1001}, new int[]{1}, new int[]{0}};
    }

    public static Date parseDate(String r100, Locale r101, String... r102) throws ParseException {
        return parseDateWithLeniency(r100, r101, r102, true);
    }

    private static Date parseDateWithLeniency(String r100, Locale r101, String[] r102, boolean r110) throws ParseException {
        if (r100 == null) goto L20;
        if (r102 == null) goto L20;
        TimeZone r103 = TimeZone.getDefault();
        if (r101 != null) goto L7;
        r101 = Locale.getDefault();
    L7:
        ParsePosition r104 = new ParsePosition(0);
        Calendar r105 = Calendar.getInstance(r103, r101);
        r105.setLenient(r110);
        int r111 = r102.length;
        int r106 = 0;
    L8:
        if (r106 >= r111) goto L18;
        FastDateParser r107 = new FastDateParser(r102[r106], r103, r101);
        r105.clear();
        if (r107.parse(r100, r104, r105) == false) goto L16;
        if (r104.getIndex() != r100.length()) goto L16;
        return r105.getTime();
    L16:
        r104.setIndex(0);
        r106 = r106 + 1;
        goto L8
    L18:
        throw new ParseException("Unable to parse the date: ".concat(r100), -1);
    L20:
        throw new IllegalArgumentException("Date and Patterns must not be null");
    }
}
