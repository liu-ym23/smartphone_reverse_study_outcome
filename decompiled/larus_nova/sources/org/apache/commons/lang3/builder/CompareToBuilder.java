package org.apache.commons.lang3.builder;

import java.util.Comparator;

/* JADX INFO: loaded from: classes42.dex */
public class CompareToBuilder {
    private int comparison;

    public CompareToBuilder() {
        this.comparison = 0;
    }

    public int toComparison() {
        return this.comparison;
    }

    public CompareToBuilder append(byte[] r100, byte[] r101) {
        if (this.comparison == 0) goto L5;
        return this;
    L5:
        if (r100 != r101) goto L7;
        return this;
    L7:
        int r102 = -1;
        if (r100 != null) goto L12;
        this.comparison = -1;
        return this;
    L12:
        if (r101 != null) goto L16;
        this.comparison = 1;
        return this;
    L16:
        if (r100.length != r101.length) goto L18;
        int r103 = 0;
    L25:
        if (r103 >= r100.length) goto L29;
        if (this.comparison != 0) goto L29;
        append(r100[r103], r101[r103]);
        r103 = r103 + 1;
    L29:
        return this;
    L18:
        if (r100.length < r101.length) goto L21;
        r102 = 1;
    L21:
        this.comparison = r102;
        return this;
    }

    public CompareToBuilder append(char[] r100, char[] r101) {
        if (this.comparison == 0) goto L5;
        return this;
    L5:
        if (r100 != r101) goto L7;
        return this;
    L7:
        int r102 = -1;
        if (r100 != null) goto L12;
        this.comparison = -1;
        return this;
    L12:
        if (r101 != null) goto L16;
        this.comparison = 1;
        return this;
    L16:
        if (r100.length != r101.length) goto L18;
        int r103 = 0;
    L25:
        if (r103 >= r100.length) goto L29;
        if (this.comparison != 0) goto L29;
        append(r100[r103], r101[r103]);
        r103 = r103 + 1;
    L29:
        return this;
    L18:
        if (r100.length < r101.length) goto L21;
        r102 = 1;
    L21:
        this.comparison = r102;
        return this;
    }

    public CompareToBuilder append(double[] r100, double[] r101) {
        if (this.comparison == 0) goto L5;
        return this;
    L5:
        if (r100 != r101) goto L7;
        return this;
    L7:
        int r102 = -1;
        if (r100 != null) goto L12;
        this.comparison = -1;
        return this;
    L12:
        if (r101 != null) goto L16;
        this.comparison = 1;
        return this;
    L16:
        if (r100.length != r101.length) goto L18;
        int r103 = 0;
    L25:
        if (r103 >= r100.length) goto L29;
        if (this.comparison != 0) goto L29;
        append(r100[r103], r101[r103]);
        r103 = r103 + 1;
    L29:
        return this;
    L18:
        if (r100.length < r101.length) goto L21;
        r102 = 1;
    L21:
        this.comparison = r102;
        return this;
    }

    public CompareToBuilder append(float[] r100, float[] r101) {
        if (this.comparison == 0) goto L5;
        return this;
    L5:
        if (r100 != r101) goto L7;
        return this;
    L7:
        int r102 = -1;
        if (r100 != null) goto L12;
        this.comparison = -1;
        return this;
    L12:
        if (r101 != null) goto L16;
        this.comparison = 1;
        return this;
    L16:
        if (r100.length != r101.length) goto L18;
        int r103 = 0;
    L25:
        if (r103 >= r100.length) goto L29;
        if (this.comparison != 0) goto L29;
        append(r100[r103], r101[r103]);
        r103 = r103 + 1;
    L29:
        return this;
    L18:
        if (r100.length < r101.length) goto L21;
        r102 = 1;
    L21:
        this.comparison = r102;
        return this;
    }

    public CompareToBuilder append(int[] r100, int[] r101) {
        if (this.comparison == 0) goto L5;
        return this;
    L5:
        if (r100 != r101) goto L7;
        return this;
    L7:
        int r102 = -1;
        if (r100 != null) goto L12;
        this.comparison = -1;
        return this;
    L12:
        if (r101 != null) goto L16;
        this.comparison = 1;
        return this;
    L16:
        if (r100.length != r101.length) goto L18;
        int r103 = 0;
    L25:
        if (r103 >= r100.length) goto L29;
        if (this.comparison != 0) goto L29;
        append(r100[r103], r101[r103]);
        r103 = r103 + 1;
    L29:
        return this;
    L18:
        if (r100.length < r101.length) goto L21;
        r102 = 1;
    L21:
        this.comparison = r102;
        return this;
    }

    public CompareToBuilder append(long[] r100, long[] r101) {
        if (this.comparison == 0) goto L5;
        return this;
    L5:
        if (r100 != r101) goto L7;
        return this;
    L7:
        int r102 = -1;
        if (r100 != null) goto L12;
        this.comparison = -1;
        return this;
    L12:
        if (r101 != null) goto L16;
        this.comparison = 1;
        return this;
    L16:
        if (r100.length != r101.length) goto L18;
        int r103 = 0;
    L25:
        if (r103 >= r100.length) goto L29;
        if (this.comparison != 0) goto L29;
        append(r100[r103], r101[r103]);
        r103 = r103 + 1;
    L29:
        return this;
    L18:
        if (r100.length < r101.length) goto L21;
        r102 = 1;
    L21:
        this.comparison = r102;
        return this;
    }

    public CompareToBuilder append(short[] r100, short[] r101) {
        if (this.comparison == 0) goto L5;
        return this;
    L5:
        if (r100 != r101) goto L7;
        return this;
    L7:
        int r102 = -1;
        if (r100 != null) goto L12;
        this.comparison = -1;
        return this;
    L12:
        if (r101 != null) goto L16;
        this.comparison = 1;
        return this;
    L16:
        if (r100.length != r101.length) goto L18;
        int r103 = 0;
    L25:
        if (r103 >= r100.length) goto L29;
        if (this.comparison != 0) goto L29;
        append(r100[r103], r101[r103]);
        r103 = r103 + 1;
    L29:
        return this;
    L18:
        if (r100.length < r101.length) goto L21;
        r102 = 1;
    L21:
        this.comparison = r102;
        return this;
    }

    public CompareToBuilder append(boolean[] r100, boolean[] r101) {
        if (this.comparison == 0) goto L5;
        return this;
    L5:
        if (r100 != r101) goto L7;
        return this;
    L7:
        int r102 = -1;
        if (r100 != null) goto L12;
        this.comparison = -1;
        return this;
    L12:
        if (r101 != null) goto L16;
        this.comparison = 1;
        return this;
    L16:
        if (r100.length != r101.length) goto L18;
        int r103 = 0;
    L25:
        if (r103 >= r100.length) goto L29;
        if (this.comparison != 0) goto L29;
        append(r100[r103], r101[r103]);
        r103 = r103 + 1;
    L29:
        return this;
    L18:
        if (r100.length < r101.length) goto L21;
        r102 = 1;
    L21:
        this.comparison = r102;
        return this;
    }

    public CompareToBuilder append(boolean r100, boolean r101) {
        if (this.comparison == 0) goto L5;
        return this;
    L5:
        if (r100 != r101) goto L7;
        return this;
    L7:
        if (r100 == false) goto L9;
        this.comparison = 1;
    L10:
        return this;
    L9:
        this.comparison = -1;
        goto L10
    }

    public CompareToBuilder append(byte r100, byte r101) {
        if (this.comparison == 0) goto L5;
        return this;
    L5:
        this.comparison = Byte.compare(r100, r101);
        return this;
    }

    public CompareToBuilder append(char r100, char r101) {
        if (this.comparison == 0) goto L5;
        return this;
    L5:
        this.comparison = Character.compare(r100, r101);
        return this;
    }

    public CompareToBuilder append(double r100, double r101) {
        if (this.comparison == 0) goto L5;
        return this;
    L5:
        this.comparison = Double.compare(r100, r101);
        return this;
    }

    public CompareToBuilder append(float r100, float r101) {
        if (this.comparison == 0) goto L5;
        return this;
    L5:
        this.comparison = Float.compare(r100, r101);
        return this;
    }

    public CompareToBuilder append(int r100, int r101) {
        if (this.comparison == 0) goto L5;
        return this;
    L5:
        this.comparison = Integer.compare(r100, r101);
        return this;
    }

    public CompareToBuilder append(long r100, long r101) {
        if (this.comparison == 0) goto L5;
        return this;
    L5:
        this.comparison = Long.compare(r100, r101);
        return this;
    }

    public CompareToBuilder append(short r100, short r101) {
        if (this.comparison == 0) goto L5;
        return this;
    L5:
        this.comparison = Short.compare(r100, r101);
        return this;
    }

    public CompareToBuilder append(Object r100, Object r101) {
        return append(r100, r101, null);
    }

    private void appendArray(Object r100, Object r101, Comparator<?> r102) {
        if ((r100 instanceof long[]) == false) goto L6;
        append((long[]) r100, (long[]) r101);
        return;
    L6:
        if ((r100 instanceof int[]) == false) goto L9;
        append((int[]) r100, (int[]) r101);
        return;
    L9:
        if ((r100 instanceof short[]) == false) goto L12;
        append((short[]) r100, (short[]) r101);
        return;
    L12:
        if ((r100 instanceof char[]) == false) goto L15;
        append((char[]) r100, (char[]) r101);
        return;
    L15:
        if ((r100 instanceof byte[]) == false) goto L18;
        append((byte[]) r100, (byte[]) r101);
        return;
    L18:
        if ((r100 instanceof double[]) == false) goto L21;
        append((double[]) r100, (double[]) r101);
        return;
    L21:
        if ((r100 instanceof float[]) == false) goto L24;
        append((float[]) r100, (float[]) r101);
        return;
    L24:
        if ((r100 instanceof boolean[]) == false) goto L26;
        append((boolean[]) r100, (boolean[]) r101);
        return;
    L26:
        append((Object[]) r100, (Object[]) r101, r102);
    }

    public CompareToBuilder append(Object r100, Object r101, Comparator<?> r102) {
        if (this.comparison == 0) goto L5;
        return this;
    L5:
        if (r100 != r101) goto L7;
        return this;
    L7:
        if (r100 != null) goto L10;
        this.comparison = -1;
        return this;
    L10:
        if (r101 != null) goto L14;
        this.comparison = 1;
        return this;
    L14:
        if (r100.getClass().isArray() == false) goto L16;
        appendArray(r100, r101, r102);
    L19:
        return this;
    L16:
        if (r102 != null) goto L18;
        this.comparison = ((Comparable) r100).compareTo(r101);
        goto L19
    L18:
        this.comparison = r102.compare(r100, r101);
        goto L19
    }

    public CompareToBuilder append(Object[] r100, Object[] r101, Comparator<?> r102) {
        if (this.comparison == 0) goto L5;
        return this;
    L5:
        if (r100 != r101) goto L7;
        return this;
    L7:
        int r103 = -1;
        if (r100 != null) goto L12;
        this.comparison = -1;
        return this;
    L12:
        if (r101 != null) goto L16;
        this.comparison = 1;
        return this;
    L16:
        if (r100.length != r101.length) goto L18;
        int r104 = 0;
    L25:
        if (r104 >= r100.length) goto L29;
        if (this.comparison != 0) goto L29;
        append(r100[r104], r101[r104], r102);
        r104 = r104 + 1;
    L29:
        return this;
    L18:
        if (r100.length < r101.length) goto L21;
        r103 = 1;
    L21:
        this.comparison = r103;
        return this;
    }
}
