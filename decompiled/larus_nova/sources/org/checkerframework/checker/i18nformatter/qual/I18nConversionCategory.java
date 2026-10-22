package org.checkerframework.checker.i18nformatter.qual;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.StringJoiner;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum I18nConversionCategory extends Enum<I18nConversionCategory> {
    public static final I18nConversionCategory DATE = null;
    public static final I18nConversionCategory GENERAL = null;
    public static final I18nConversionCategory NUMBER = null;
    public static final I18nConversionCategory UNUSED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final I18nConversionCategory[] f525621a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final I18nConversionCategory[] f525622b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ I18nConversionCategory[] f525623c = null;
    public final String[] strings;
    public final Class<?>[] types;

    static {
        I18nConversionCategory r100 = new I18nConversionCategory("UNUSED", 0, null, null);
        UNUSED = r100;
        I18nConversionCategory r101 = new I18nConversionCategory("GENERAL", 1, null, null);
        GENERAL = r101;
        I18nConversionCategory r102 = new I18nConversionCategory("DATE", 2, new Class[]{Date.class, Number.class}, new String[]{"date", "time"});
        DATE = r102;
        I18nConversionCategory r103 = new I18nConversionCategory("NUMBER", 3, new Class[]{Number.class}, new String[]{"number", "choice"});
        NUMBER = r103;
        f525623c = new I18nConversionCategory[]{r100, r101, r102, r103};
        f525621a = new I18nConversionCategory[]{r102, r103};
        f525622b = new I18nConversionCategory[]{r102, r103};
    }

    public static I18nConversionCategory[] values() {
        return (I18nConversionCategory[]) f525623c.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        StringBuilder r100 = new StringBuilder(name());
        if (this.types != null) goto L5;
        r100.append(" conversion category (all types)");
    L10:
        return r100.toString();
    L5:
        StringJoiner r101 = new StringJoiner(", ", " conversion category (one of: ", ")");
        Class<?>[] r102 = this.types;
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L8;
        r101.add(r102[r104].getCanonicalName());
        r104 = r104 + 1;
        goto L6
    L8:
        r100.append(r101);
        goto L10
    }

    public static I18nConversionCategory stringToI18nConversionCategory(String r100) {
        String r101 = r100.toLowerCase();
        I18nConversionCategory[] r102 = f525621a;
        int r103 = 0;
    L4:
        if (r103 >= 2) goto L13;
        I18nConversionCategory r104 = r102[r103];
        String[] r105 = r104.strings;
        int r106 = r105.length;
        int r107 = 0;
    L6:
        if (r107 >= r106) goto L11;
        if (r105[r107].equals(r101) == true) goto L9;
        r107 = r107 + 1;
        goto L6
    L9:
        return r104;
    L11:
        r103 = r103 + 1;
        goto L4
    L13:
        throw new IllegalArgumentException("Invalid format type " + r101);
    }

    public static I18nConversionCategory valueOf(String r100) {
        return (I18nConversionCategory) a.a(I18nConversionCategory.class, r100);
    }

    public boolean isAssignableFrom(Class<?> r100) {
        Class<?>[] r101 = this.types;
        if (r101 != null) goto L6;
        return true;
    L6:
        if (r100 != Void.TYPE) goto L8;
        return true;
    L8:
        int r102 = r101.length;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L14;
        if (r101[r103].isAssignableFrom(r100) == true) goto L12;
        r103 = r103 + 1;
        goto L9
    L12:
        return true;
    L14:
        return false;
    }

    public static I18nConversionCategory intersect(I18nConversionCategory r100, I18nConversionCategory r101) {
        I18nConversionCategory r102 = UNUSED;
        if (r100 != r102) goto L5;
        return r101;
    L5:
        if (r101 != r102) goto L7;
        return r100;
    L7:
        I18nConversionCategory r103 = GENERAL;
        if (r100 != r103) goto L10;
        return r101;
    L10:
        if (r101 != r103) goto L12;
        return r100;
    L12:
        HashSet r104 = new HashSet(Arrays.asList(r100.types));
        r104.retainAll(new HashSet(Arrays.asList(r101.types)));
        I18nConversionCategory[] r105 = f525622b;
        int r106 = 0;
    L14:
        if (r106 >= 2) goto L20;
        I18nConversionCategory r107 = r105[r106];
        if (new HashSet(Arrays.asList(r107.types)).equals(r104) == true) goto L17;
        r106 = r106 + 1;
        goto L14
    L17:
        return r107;
    L20:
        throw new RuntimeException();
    }

    public static boolean isSubsetOf(I18nConversionCategory r100, I18nConversionCategory r101) {
        if (intersect(r100, r101) != r100) goto L5;
        return true;
    L5:
        return false;
    }

    public static I18nConversionCategory union(I18nConversionCategory r100, I18nConversionCategory r101) {
        I18nConversionCategory r102 = UNUSED;
        if (r100 == r102) goto L16;
        if (r101 == r102) goto L16;
        r102 = GENERAL;
        if (r100 == r102) goto L16;
        if (r101 == r102) goto L16;
        r102 = DATE;
        if (r100 == r102) goto L16;
        if (r101 == r102) goto L16;
        return NUMBER;
    L16:
        return r102;
    }

    public I18nConversionCategory(String r100, int r101, Class[] r102, String[] r103) {
        super(r100, r101);
        this.types = r102;
        this.strings = r103;
    }
}
