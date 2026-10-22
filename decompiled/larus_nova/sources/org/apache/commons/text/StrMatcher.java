package org.apache.commons.text;

import java.util.Arrays;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes42.dex */
public abstract class StrMatcher {
    private static final StrMatcher COMMA_MATCHER = null;
    private static final StrMatcher DOUBLE_QUOTE_MATCHER = null;
    private static final StrMatcher NONE_MATCHER = null;
    private static final StrMatcher QUOTE_MATCHER = null;
    private static final StrMatcher SINGLE_QUOTE_MATCHER = null;
    private static final StrMatcher SPACE_MATCHER = null;
    private static final StrMatcher SPLIT_MATCHER = null;
    private static final StrMatcher TAB_MATCHER = null;
    private static final StrMatcher TRIM_MATCHER = null;

    public static final class CharMatcher extends StrMatcher {

        /* JADX INFO: renamed from: ch, reason: collision with root package name */
        private final char f525015ch;

        public CharMatcher(char r100) {
            this.f525015ch = r100;
        }

        @Override // org.apache.commons.text.StrMatcher
        public int isMatch(char[] r100, int r101, int r102, int r103) {
            if (this.f525015ch != r100[r101]) goto L5;
            return 1;
        L5:
            return 0;
        }
    }

    public static final class CharSetMatcher extends StrMatcher {
        private final char[] chars;

        public CharSetMatcher(char[] r100) {
            char[] r101 = (char[]) r100.clone();
            this.chars = r101;
            Arrays.sort(r101);
        }

        @Override // org.apache.commons.text.StrMatcher
        public int isMatch(char[] r100, int r101, int r102, int r103) {
            if (Arrays.binarySearch(this.chars, r100[r101]) < 0) goto L5;
            return 1;
        L5:
            return 0;
        }
    }

    public static final class NoMatcher extends StrMatcher {
        @Override // org.apache.commons.text.StrMatcher
        public int isMatch(char[] r100, int r101, int r102, int r103) {
            return 0;
        }

        public NoMatcher() {
        }
    }

    public static final class TrimMatcher extends StrMatcher {
        public TrimMatcher() {
        }

        @Override // org.apache.commons.text.StrMatcher
        public int isMatch(char[] r100, int r101, int r102, int r103) {
            if (r100[r101] > ' ') goto L5;
            return 1;
        L5:
            return 0;
        }
    }

    public abstract int isMatch(char[] r100, int r101, int r102, int r103);

    static {
        COMMA_MATCHER = new CharMatcher(',');
        TAB_MATCHER = new CharMatcher('\t');
        SPACE_MATCHER = new CharMatcher(' ');
        SPLIT_MATCHER = new CharSetMatcher(" \t\n\r\f".toCharArray());
        TRIM_MATCHER = new TrimMatcher();
        SINGLE_QUOTE_MATCHER = new CharMatcher('\'');
        DOUBLE_QUOTE_MATCHER = new CharMatcher(Typography.quote);
        QUOTE_MATCHER = new CharSetMatcher("'\"".toCharArray());
        NONE_MATCHER = new NoMatcher();
    }

    public StrMatcher() {
    }

    public static StrMatcher commaMatcher() {
        return COMMA_MATCHER;
    }

    public static StrMatcher doubleQuoteMatcher() {
        return DOUBLE_QUOTE_MATCHER;
    }

    public static StrMatcher noneMatcher() {
        return NONE_MATCHER;
    }

    public static StrMatcher splitMatcher() {
        return SPLIT_MATCHER;
    }

    public static StrMatcher tabMatcher() {
        return TAB_MATCHER;
    }

    public static StrMatcher trimMatcher() {
        return TRIM_MATCHER;
    }
}
