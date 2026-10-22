package org.apache.commons.lang3.time;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes42.dex */
abstract class FormatCache<F extends Format> {
    private static final ConcurrentMap<MultipartKey, String> cDateTimeInstanceCache = null;
    private final ConcurrentMap<MultipartKey, F> cInstanceCache;

    public static class MultipartKey {
        private int hashCode;
        private final Object[] keys;

        public int hashCode() {
            if (this.hashCode != 0) goto L12;
            Object[] r100 = this.keys;
            int r101 = r100.length;
            int r102 = 0;
            int r103 = 0;
        L5:
            if (r102 >= r101) goto L10;
            Object r104 = r100[r102];
            if (r104 == null) goto L9;
            r103 = (r103 * 7) + r104.hashCode();
        L9:
            r102 = r102 + 1;
            goto L5
        L10:
            this.hashCode = r103;
        L12:
            return this.hashCode;
        }

        public MultipartKey(Object... r100) {
            this.keys = r100;
        }

        public boolean equals(Object r100) {
            return Arrays.equals(this.keys, ((MultipartKey) r100).keys);
        }
    }

    public abstract F createInstance(String r100, TimeZone r101, Locale r102);

    static {
        cDateTimeInstanceCache = new ConcurrentHashMap(7);
    }

    public FormatCache() {
        this.cInstanceCache = new ConcurrentHashMap(7);
    }

    public F getInstance() {
        return (F) getDateTimeInstance(3, 3, TimeZone.getDefault(), Locale.getDefault());
    }

    public static String getPatternForStyle(Integer r100, Integer r101, Locale r102) {
        MultipartKey r103 = new MultipartKey(new Object[]{r100, r101, r102});
        ConcurrentMap<MultipartKey, String> r104 = cDateTimeInstanceCache;
        String r105 = r104.get(r103);
        if (r105 == null) goto L16;
        return r105;
    L16:
        if (r100 != null) goto L6;
        DateFormat r106 = DateFormat.getTimeInstance(r101.intValue(), r102);     // Catch: ClassCastException -> L13
    L9:
        String r107 = ((SimpleDateFormat) r106).toPattern();     // Catch: ClassCastException -> L13
        String r108 = r104.putIfAbsent(r103, r107);     // Catch: ClassCastException -> L13
        if (r108 == null) goto L19;
        return r108;
    L19:
        return r107;
    L6:
        if (r101 != null) goto L8;
        r106 = DateFormat.getDateInstance(r100.intValue(), r102);     // Catch: ClassCastException -> L13
        goto L9
    L8:
        r106 = DateFormat.getDateTimeInstance(r100.intValue(), r101.intValue(), r102);     // Catch: ClassCastException -> L13
    L14:
        throw new IllegalArgumentException("No date time pattern for locale: " + r102);
    }

    public F getDateInstance(int r100, TimeZone r101, Locale r102) {
        return (F) getDateTimeInstance(Integer.valueOf(r100), null, r101, r102);
    }

    public F getInstance(String r100, TimeZone r101, Locale r102) {
        Validate.notNull(r100, "pattern must not be null", new Object[0]);
        if (r101 != null) goto L5;
        r101 = TimeZone.getDefault();
    L5:
        if (r102 != null) goto L7;
        r102 = Locale.getDefault();
    L7:
        MultipartKey r103 = new MultipartKey(new Object[]{r100, r101, r102});
        F r104 = this.cInstanceCache.get(r103);
        if (r104 != null) goto L13;
        F r105 = (F) createInstance(r100, r101, r102);
        F r106 = this.cInstanceCache.putIfAbsent(r103, r105);
        if (r106 != null) goto L12;
        return r105;
    L12:
        return r106;
    L13:
        return r104;
    }

    public F getTimeInstance(int r100, TimeZone r101, Locale r102) {
        return (F) getDateTimeInstance(null, Integer.valueOf(r100), r101, r102);
    }

    private F getDateTimeInstance(Integer r100, Integer r101, TimeZone r102, Locale r103) {
        if (r103 != null) goto L5;
        r103 = Locale.getDefault();
    L5:
        return (F) getInstance(getPatternForStyle(r100, r101, r103), r102, r103);
    }

    public F getDateTimeInstance(int r100, int r101, TimeZone r102, Locale r103) {
        return (F) getDateTimeInstance(Integer.valueOf(r100), Integer.valueOf(r101), r102, r103);
    }
}
