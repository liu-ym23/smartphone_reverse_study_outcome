package org.apache.commons.text.matcher;

import kotlin.text.Typography;

/* JADX INFO: loaded from: classes42.dex */
public final class StringMatcherFactory {
    private static final AbstractStringMatcher.CharMatcher COMMA_MATCHER = null;
    private static final AbstractStringMatcher.CharMatcher DOUBLE_QUOTE_MATCHER = null;
    public static final StringMatcherFactory INSTANCE = null;
    private static final AbstractStringMatcher.NoMatcher NONE_MATCHER = null;
    private static final AbstractStringMatcher.CharSetMatcher QUOTE_MATCHER = null;
    private static final AbstractStringMatcher.CharMatcher SINGLE_QUOTE_MATCHER = null;
    private static final AbstractStringMatcher.CharMatcher SPACE_MATCHER = null;
    private static final AbstractStringMatcher.CharSetMatcher SPLIT_MATCHER = null;
    private static final AbstractStringMatcher.CharMatcher TAB_MATCHER = null;
    private static final AbstractStringMatcher.TrimMatcher TRIM_MATCHER = null;

    static {
        INSTANCE = new StringMatcherFactory();
        SPLIT_MATCHER = new AbstractStringMatcher.CharSetMatcher(" \t\n\r\f".toCharArray());
        COMMA_MATCHER = new AbstractStringMatcher.CharMatcher(',');
        TAB_MATCHER = new AbstractStringMatcher.CharMatcher('\t');
        SPACE_MATCHER = new AbstractStringMatcher.CharMatcher(' ');
        TRIM_MATCHER = new AbstractStringMatcher.TrimMatcher();
        SINGLE_QUOTE_MATCHER = new AbstractStringMatcher.CharMatcher('\'');
        DOUBLE_QUOTE_MATCHER = new AbstractStringMatcher.CharMatcher(Typography.quote);
        QUOTE_MATCHER = new AbstractStringMatcher.CharSetMatcher("'\"".toCharArray());
        NONE_MATCHER = new AbstractStringMatcher.NoMatcher();
    }

    private StringMatcherFactory() {
    }

    public StringMatcher commaMatcher() {
        return COMMA_MATCHER;
    }

    public StringMatcher doubleQuoteMatcher() {
        return DOUBLE_QUOTE_MATCHER;
    }

    public StringMatcher noneMatcher() {
        return NONE_MATCHER;
    }

    public StringMatcher splitMatcher() {
        return SPLIT_MATCHER;
    }

    public StringMatcher tabMatcher() {
        return TAB_MATCHER;
    }

    public StringMatcher trimMatcher() {
        return TRIM_MATCHER;
    }
}
