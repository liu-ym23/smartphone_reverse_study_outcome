package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes42.dex */
public class CharSet implements Serializable {
    public static final CharSet ASCII_ALPHA = null;
    public static final CharSet ASCII_ALPHA_LOWER = null;
    public static final CharSet ASCII_ALPHA_UPPER = null;
    public static final CharSet ASCII_NUMERIC = null;
    protected static final Map<String, CharSet> COMMON = null;
    public static final CharSet EMPTY = null;
    private static final long serialVersionUID = 5947847346149275958L;
    private final Set<CharRange> set;

    static {
        CharSet r100 = new CharSet(new String[]{null});
        EMPTY = r100;
        CharSet r101 = new CharSet(new String[]{"a-zA-Z"});
        ASCII_ALPHA = r101;
        CharSet r102 = new CharSet(new String[]{"a-z"});
        ASCII_ALPHA_LOWER = r102;
        CharSet r103 = new CharSet(new String[]{"A-Z"});
        ASCII_ALPHA_UPPER = r103;
        CharSet r104 = new CharSet(new String[]{"0-9"});
        ASCII_NUMERIC = r104;
        Map<String, CharSet> r110 = Collections.synchronizedMap(new HashMap());
        COMMON = r110;
        r110.put(null, r100);
        r110.put("", r100);
        r110.put("a-zA-Z", r101);
        r110.put("A-Za-z", r101);
        r110.put("a-z", r102);
        r110.put("A-Z", r103);
        r110.put("0-9", r104);
    }

    public CharRange[] getCharRanges() {
        Set<CharRange> r100 = this.set;
        return (CharRange[]) r100.toArray(new CharRange[r100.size()]);
    }

    public int hashCode() {
        return this.set.hashCode() + 89;
    }

    public String toString() {
        return this.set.toString();
    }

    public CharSet(String... r100) {
        this.set = Collections.synchronizedSet(new HashSet());
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        add(r100[r102]);
        r102 = r102 + 1;
        goto L3
    }

    public static CharSet getInstance(String... r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.length != 1) goto L11;
        CharSet r101 = COMMON.get(r100[0]);
        if (r101 == null) goto L11;
        return r101;
    L11:
        return new CharSet(r100);
    }

    public void add(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.length();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L24;
        int r103 = r101 - r102;
        if (r103 < 4) goto L14;
        if (r100.charAt(r102) != '^') goto L14;
        if (r100.charAt(r102 + 2) != '-') goto L14;
        this.set.add(CharRange.isNotIn(r100.charAt(r102 + 1), r100.charAt(r102 + 3)));
        r102 = r102 + 4;
    L14:
        if (r103 < 3) goto L19;
        if (r100.charAt(r102 + 1) != '-') goto L19;
        this.set.add(CharRange.isIn(r100.charAt(r102), r100.charAt(r102 + 2)));
        r102 = r102 + 3;
    L19:
        if (r103 < 2) goto L23;
        if (r100.charAt(r102) != '^') goto L23;
        this.set.add(CharRange.isNot(r100.charAt(r102 + 1)));
        r102 = r102 + 2;
    L23:
        this.set.add(CharRange.is(r100.charAt(r102)));
        r102 = r102 + 1;
        goto L5
    }

    public boolean contains(char r100) {
        Iterator<CharRange> r101 = this.set.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r101.next().contains(r100) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof CharSet) == true) goto L10;
        return false;
    L10:
        return this.set.equals(((CharSet) r100).set);
    }
}
