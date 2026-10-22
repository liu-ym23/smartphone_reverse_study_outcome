package org.checkerframework.checker.formatter.qual;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import org.checkerframework.dataflow.qual.Pure;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum ConversionCategory extends Enum<ConversionCategory> {
    public static final ConversionCategory CHAR = null;
    public static final ConversionCategory CHAR_AND_INT = null;
    public static final ConversionCategory FLOAT = null;
    public static final ConversionCategory GENERAL = null;
    public static final ConversionCategory INT = null;
    public static final ConversionCategory INT_AND_TIME = null;
    public static final ConversionCategory NULL = null;
    public static final ConversionCategory TIME = null;
    public static final ConversionCategory UNUSED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConversionCategory[] f525617a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConversionCategory[] f525618b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConversionCategory[] f525619c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ ConversionCategory[] f525620d = null;
    public final String chars;
    public final Class<?>[] types;

    static {
        ConversionCategory r100 = new ConversionCategory("GENERAL", 0, "bBhHsS", null);
        GENERAL = r100;
        ConversionCategory r101 = new ConversionCategory("CHAR", 1, "cC", new Class[]{Character.class, Byte.class, Short.class, Integer.class});
        CHAR = r101;
        ConversionCategory r102 = new ConversionCategory("INT", 2, "doxX", new Class[]{Byte.class, Short.class, Integer.class, Long.class, BigInteger.class});
        INT = r102;
        ConversionCategory r110 = new ConversionCategory("FLOAT", 3, "eEfgGaA", new Class[]{Float.class, Double.class, BigDecimal.class});
        FLOAT = r110;
        ConversionCategory r111 = new ConversionCategory("TIME", 4, "tT", new Class[]{Long.class, Calendar.class, Date.class});
        TIME = r111;
        ConversionCategory r112 = new ConversionCategory("CHAR_AND_INT", 5, null, new Class[]{Byte.class, Short.class, Integer.class});
        CHAR_AND_INT = r112;
        ConversionCategory r113 = new ConversionCategory("INT_AND_TIME", 6, null, new Class[]{Long.class});
        INT_AND_TIME = r113;
        ConversionCategory r114 = new ConversionCategory("NULL", 7, null, new Class[0]);
        NULL = r114;
        ConversionCategory r103 = new ConversionCategory("UNUSED", 8, null, null);
        UNUSED = r103;
        f525620d = new ConversionCategory[]{r100, r101, r102, r110, r111, r112, r113, r114, r103};
        f525617a = new ConversionCategory[]{r100, r101, r102, r110, r111};
        f525618b = new ConversionCategory[]{r101, r102, r110, r111, r112, r113, r114};
        f525619c = new ConversionCategory[]{r114, r112, r113, r101, r102, r110, r111};
    }

    public static ConversionCategory[] values() {
        return (ConversionCategory[]) f525620d.clone();
    }

    @Override // java.lang.Enum
    @Pure
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(name());
        r100.append(" conversion category");
        Class<?>[] r101 = this.types;
        if (r101 == null) goto L13;
        if (r101.length == 0) goto L13;
        StringJoiner r102 = new StringJoiner(", ", "(one of: ", ")");
        Class<?>[] r103 = this.types;
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L10;
        r102.add(r103[r105].getSimpleName());
        r105 = r105 + 1;
        goto L8
    L10:
        r100.append(" ");
        r100.append(r102);
        return r100.toString();
    L13:
        return r100.toString();
    }

    public static <E> Set<E> a(E[] r100) {
        return new HashSet(Arrays.asList(r100));
    }

    public static ConversionCategory fromConversionChar(char r100) {
        ConversionCategory[] r101 = f525617a;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        ConversionCategory r104 = r101[r103];
        if (r104.chars.contains(String.valueOf(r100)) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        throw new IllegalArgumentException("Bad conversion character " + r100);
    }

    public static ConversionCategory valueOf(String r100) {
        return (ConversionCategory) a.a(ConversionCategory.class, r100);
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

    public static ConversionCategory intersect(ConversionCategory r100, ConversionCategory r101) {
        ConversionCategory r102 = UNUSED;
        if (r100 != r102) goto L5;
        return r101;
    L5:
        if (r101 != r102) goto L7;
        return r100;
    L7:
        ConversionCategory r103 = GENERAL;
        if (r100 != r103) goto L10;
        return r101;
    L10:
        if (r101 != r103) goto L12;
        return r100;
    L12:
        Set r104 = a(r100.types);
        r104.retainAll(a(r101.types));
        ConversionCategory[] r105 = f525618b;
        int r106 = r105.length;
        int r107 = 0;
    L13:
        if (r107 >= r106) goto L19;
        ConversionCategory r108 = r105[r107];
        if (a(r108.types).equals(r104) == true) goto L16;
        r107 = r107 + 1;
        goto L13
    L16:
        return r108;
    L19:
        throw new RuntimeException();
    }

    public static boolean isSubsetOf(ConversionCategory r100, ConversionCategory r101) {
        if (intersect(r100, r101) != r100) goto L5;
        return true;
    L5:
        return false;
    }

    public static ConversionCategory union(ConversionCategory r100, ConversionCategory r101) {
        ConversionCategory r102 = UNUSED;
        if (r100 == r102) goto L27;
        if (r101 == r102) goto L27;
        r102 = GENERAL;
        if (r100 == r102) goto L27;
        if (r101 == r102) goto L27;
        ConversionCategory r103 = CHAR_AND_INT;
        if (r100 != r103) goto L15;
        if (r101 != INT_AND_TIME) goto L15;
    L18:
        return INT;
    L15:
        if (r100 != INT_AND_TIME) goto L19;
        if (r101 == r103) goto L18;
    L19:
        Set r104 = a(r100.types);
        r104.addAll(a(r101.types));
        ConversionCategory[] r105 = f525619c;
        int r106 = r105.length;
        int r107 = 0;
    L20:
        if (r107 >= r106) goto L26;
        ConversionCategory r108 = r105[r107];
        if (a(r108.types).equals(r104) == true) goto L23;
        r107 = r107 + 1;
        goto L20
    L23:
        return r108;
    L26:
        return GENERAL;
    L27:
        return r102;
    }

    public ConversionCategory(String r100, int r101, String r102, Class... r103) {
        super(r100, r101);
        this.chars = r102;
        if (r103 != null) goto L5;
        this.types = r103;
        return;
    L5:
        ArrayList r104 = new ArrayList(r103.length);
        int r105 = r103.length;
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L35;
        Class r107 = r103[r106];
        r104.add(r107);
        if (r107 != Byte.class) goto L11;
        Class r108 = Byte.TYPE;
    L32:
        if (r108 == null) goto L34;
        r104.add(r108);
    L34:
        r106 = r106 + 1;
        goto L6
    L11:
        if (r107 != Character.class) goto L14;
        r108 = Character.TYPE;
        goto L32
    L14:
        if (r107 != Short.class) goto L17;
        r108 = Short.TYPE;
        goto L32
    L17:
        if (r107 != Integer.class) goto L20;
        r108 = Integer.TYPE;
        goto L32
    L20:
        if (r107 != Long.class) goto L23;
        r108 = Long.TYPE;
        goto L32
    L23:
        if (r107 != Float.class) goto L26;
        r108 = Float.TYPE;
        goto L32
    L26:
        if (r107 != Double.class) goto L29;
        r108 = Double.TYPE;
        goto L32
    L29:
        if (r107 != Boolean.class) goto L31;
        r108 = Boolean.TYPE;
        goto L32
    L31:
        r108 = null;
        goto L32
    L35:
        this.types = (Class[]) r104.toArray(new Class[r104.size()]);
    }
}
