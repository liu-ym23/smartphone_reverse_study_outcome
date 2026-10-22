package com.larus.io;

import com.larus.utils.r;
import java.io.Serializable;

/* JADX INFO: loaded from: classes30.dex */
public final class IOCase implements Serializable {
    public static final IOCase INSENSITIVE = null;
    public static final IOCase SENSITIVE = null;
    public static final IOCase SYSTEM = null;
    private static final long serialVersionUID = -6343169151696340687L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient boolean f351611a;
    private final String name;

    static {
        SENSITIVE = new IOCase("Sensitive", true);
        boolean r100 = false;
        INSENSITIVE = new IOCase("Insensitive", false);
        if (r.f375457a != '\\') goto L5;
        r100 = true;
    L5:
        SYSTEM = new IOCase("System", !r100);
    }

    private Object readResolve() {
        return forName(this.name);
    }

    public String getName() {
        return this.name;
    }

    public boolean isCaseSensitive() {
        return this.f351611a;
    }

    public String toString() {
        return this.name;
    }

    public static IOCase forName(String r100) {
        IOCase r101 = SENSITIVE;
        if (r101.name.equals(r100) == false) goto L5;
        return r101;
    L5:
        IOCase r102 = INSENSITIVE;
        if (r102.name.equals(r100) == false) goto L8;
        return r102;
    L8:
        IOCase r103 = SYSTEM;
        if (r103.name.equals(r100) == false) goto L12;
        return r103;
    L12:
        throw new IllegalArgumentException("Invalid IOCase name: " + r100);
    }

    public IOCase(String r100, boolean r101) {
        this.name = r100;
        this.f351611a = r101;
    }

    public int checkCompareTo(String r100, String r101) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L10;
        if (this.f351611a == false) goto L8;
        return r100.compareTo(r101);
    L8:
        return r100.compareToIgnoreCase(r101);
    L10:
        throw new NullPointerException("The strings must not be null");
    }

    public boolean checkEndsWith(String r100, String r101) {
        int r102 = r101.length();
        return r100.regionMatches(!this.f351611a, r100.length() - r102, r101, 0, r102);
    }

    public boolean checkEquals(String r100, String r101) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L10;
        if (this.f351611a == false) goto L8;
        return r100.equals(r101);
    L8:
        return r100.equalsIgnoreCase(r101);
    L10:
        throw new NullPointerException("The strings must not be null");
    }

    public boolean checkStartsWith(String r100, String r101) {
        return r100.regionMatches(!this.f351611a, 0, r101, 0, r101.length());
    }

    public int checkIndexOf(String r100, int r101, String r102) {
        int r103 = r100.length() - r102.length();
        if (r103 < r101) goto L9;
    L4:
        if (r101 > r103) goto L13;
        if (checkRegionMatches(r100, r101, r102) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r101;
    L13:
        return -1;
    L9:
        return -1;
    }

    public boolean checkRegionMatches(String r100, int r101, String r110) {
        return r100.regionMatches(!this.f351611a, r101, r110, 0, r110.length());
    }
}
