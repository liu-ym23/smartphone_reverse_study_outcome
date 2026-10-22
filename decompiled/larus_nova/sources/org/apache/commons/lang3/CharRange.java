package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes42.dex */
final class CharRange implements Iterable<Character>, Serializable {
    private static final long serialVersionUID = 8270183163158333422L;
    private final char end;
    private transient String iToString;
    private final boolean negated;
    private final char start;

    /* JADX INFO: renamed from: org.apache.commons.lang3.CharRange$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class CharacterIterator implements Iterator<Character> {
        private char current;
        private boolean hasNext;
        private final CharRange range;

        private void prepareNext() {
            if (CharRange.access$100(this.range) == false) goto L15;
            char r100 = this.current;
            if (r100 != 65535) goto L8;
            this.hasNext = false;
            return;
        L8:
            if ((r100 + 1) == CharRange.access$200(this.range)) goto L10;
            this.current = (char) (this.current + 1);
            return;
        L10:
            if (CharRange.access$300(this.range) != 65535) goto L12;
            this.hasNext = false;
            return;
        L12:
            this.current = (char) (CharRange.access$300(this.range) + 1);
            return;
        L15:
            if (this.current >= CharRange.access$300(this.range)) goto L17;
            this.current = (char) (this.current + 1);
            return;
        L17:
            this.hasNext = false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Character next() {
            if (this.hasNext == false) goto L7;
            char r100 = this.current;
            prepareNext();
            return Character.valueOf(r100);
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Character next() {
            return next();
        }

        private CharacterIterator(CharRange r100) {
            this.range = r100;
            this.hasNext = true;
            if (CharRange.access$100(r100) == true) goto L5;
            this.current = CharRange.access$200(r100);
            return;
        L5:
            if (CharRange.access$200(r100) == 0) goto L7;
            this.current = 0;
            return;
        L7:
            if (CharRange.access$300(r100) != 65535) goto L9;
            this.hasNext = false;
            return;
        L9:
            this.current = (char) (CharRange.access$300(r100) + 1);
        }

        public /* synthetic */ CharacterIterator(CharRange r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public int hashCode() {
        return ((this.start + 'S') + (this.end * 7)) + (this.negated ? 1 : 0);
    }

    @Override // java.lang.Iterable
    public Iterator<Character> iterator() {
        return new CharacterIterator(this, null);
    }

    public String toString() {
        if (this.iToString != null) goto L12;
        StringBuilder r100 = new StringBuilder(4);
        if (isNegated() == false) goto L7;
        r100.append('^');
    L7:
        r100.append(this.start);
        if (this.start == this.end) goto L10;
        r100.append('-');
        r100.append(this.end);
    L10:
        this.iToString = r100.toString();
    L12:
        return this.iToString;
    }

    public char getEnd() {
        return this.end;
    }

    public char getStart() {
        return this.start;
    }

    public boolean isNegated() {
        return this.negated;
    }

    public static /* synthetic */ boolean access$100(CharRange r100) {
        return r100.negated;
    }

    public static /* synthetic */ char access$200(CharRange r100) {
        return r100.start;
    }

    public static /* synthetic */ char access$300(CharRange r100) {
        return r100.end;
    }

    public static CharRange is(char r100) {
        return new CharRange(r100, r100, false);
    }

    public static CharRange isNot(char r100) {
        return new CharRange(r100, r100, true);
    }

    public boolean contains(CharRange r100) {
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        Validate.isTrue(r101, "The Range must not be null", new Object[0]);
        if (this.negated == false) goto L25;
        if (r100.negated == false) goto L18;
        if (this.start >= r100.start) goto L13;
    L15:
        return false;
    L13:
        if (this.end > r100.end) goto L15;
        return true;
    L18:
        if (r100.end >= this.start) goto L20;
        return true;
    L20:
        if (r100.start > this.end) goto L42;
        return false;
    L42:
        return true;
    L25:
        if (r100.negated == false) goto L34;
        if (this.start == 0) goto L29;
    L31:
        return false;
    L29:
        if (this.end != 65535) goto L31;
        return true;
    L34:
        if (this.start <= r100.start) goto L36;
    L38:
        return false;
    L36:
        if (this.end < r100.end) goto L38;
        return true;
    L5:
        r101 = false;
        goto L6
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof CharRange) == true) goto L8;
        return false;
    L8:
        CharRange r101 = (CharRange) r100;
        if (this.start == r101.start) goto L11;
    L15:
        return false;
    L11:
        if (this.end != r101.end) goto L15;
        if (this.negated != r101.negated) goto L15;
        return true;
    }

    public boolean contains(char r100) {
        if (r100 >= this.start) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 != this.negated) goto L13;
        return false;
    L13:
        return true;
    L5:
        if (r100 > this.end) goto L7;
        r101 = true;
        goto L9
    }

    public static CharRange isIn(char r100, char r101) {
        return new CharRange(r100, r101, false);
    }

    public static CharRange isNotIn(char r100, char r101) {
        return new CharRange(r100, r101, true);
    }

    private CharRange(char r100, char r101, boolean r102) {
        if (r100 <= r101) goto L5;
        r101 = r100;
        r100 = r101;
    L5:
        this.start = r100;
        this.end = r101;
        this.negated = r102;
    }
}
