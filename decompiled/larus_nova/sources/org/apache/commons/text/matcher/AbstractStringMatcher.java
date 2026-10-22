package org.apache.commons.text.matcher;

import java.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
abstract class AbstractStringMatcher implements StringMatcher {

    public static final class CharMatcher extends AbstractStringMatcher {

        /* JADX INFO: renamed from: ch, reason: collision with root package name */
        private final char f525016ch;

        public CharMatcher(char r100) {
            this.f525016ch = r100;
        }

        @Override // org.apache.commons.text.matcher.StringMatcher
        public int isMatch(char[] r100, int r101, int r102, int r103) {
            if (this.f525016ch != r100[r101]) goto L5;
            return 1;
        L5:
            return 0;
        }
    }

    public static final class CharSetMatcher extends AbstractStringMatcher {
        private final char[] chars;

        public CharSetMatcher(char[] r100) {
            char[] r101 = (char[]) r100.clone();
            this.chars = r101;
            Arrays.sort(r101);
        }

        @Override // org.apache.commons.text.matcher.StringMatcher
        public int isMatch(char[] r100, int r101, int r102, int r103) {
            if (Arrays.binarySearch(this.chars, r100[r101]) < 0) goto L5;
            return 1;
        L5:
            return 0;
        }
    }

    public static final class NoMatcher extends AbstractStringMatcher {
        @Override // org.apache.commons.text.matcher.StringMatcher
        public int isMatch(char[] r100, int r101, int r102, int r103) {
            return 0;
        }

        public NoMatcher() {
        }
    }

    public static final class TrimMatcher extends AbstractStringMatcher {
        public TrimMatcher() {
        }

        @Override // org.apache.commons.text.matcher.StringMatcher
        public int isMatch(char[] r100, int r101, int r102, int r103) {
            if (r100[r101] > ' ') goto L5;
            return 1;
        L5:
            return 0;
        }
    }

    public AbstractStringMatcher() {
    }
}
