package org.apache.commons.lang3.text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes42.dex */
public class StrTokenizer implements ListIterator<String>, Cloneable {
    private static final StrTokenizer CSV_TOKENIZER_PROTOTYPE = null;
    private static final StrTokenizer TSV_TOKENIZER_PROTOTYPE = null;
    private char[] chars;
    private StrMatcher delimMatcher;
    private boolean emptyAsNull;
    private boolean ignoreEmptyTokens;
    private StrMatcher ignoredMatcher;
    private StrMatcher quoteMatcher;
    private int tokenPos;
    private String[] tokens;
    private StrMatcher trimmerMatcher;

    public StrTokenizer reset() {
        this.tokenPos = 0;
        this.tokens = null;
        return this;
    }

    static {
        StrTokenizer r100 = new StrTokenizer();
        CSV_TOKENIZER_PROTOTYPE = r100;
        r100.setDelimiterMatcher(StrMatcher.commaMatcher());
        r100.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
        r100.setIgnoredMatcher(StrMatcher.noneMatcher());
        r100.setTrimmerMatcher(StrMatcher.trimMatcher());
        r100.setEmptyTokenAsNull(false);
        r100.setIgnoreEmptyTokens(false);
        StrTokenizer r101 = new StrTokenizer();
        TSV_TOKENIZER_PROTOTYPE = r101;
        r101.setDelimiterMatcher(StrMatcher.tabMatcher());
        r101.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
        r101.setIgnoredMatcher(StrMatcher.noneMatcher());
        r101.setTrimmerMatcher(StrMatcher.trimMatcher());
        r101.setEmptyTokenAsNull(false);
        r101.setIgnoreEmptyTokens(false);
    }

    private void checkTokenized() {
        if (this.tokens != null) goto L9;
        char[] r100 = this.chars;
        if (r100 != null) goto L7;
        List<String> r101 = tokenize(null, 0, 0);
        this.tokens = (String[]) r101.toArray(new String[r101.size()]);
        return;
    L7:
        List<String> r102 = tokenize(r100, 0, r100.length);
        this.tokens = (String[]) r102.toArray(new String[r102.size()]);
        return;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.tokenPos - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is unsupported");
    }

    public String toString() {
        if (this.tokens != null) goto L7;
        return "StrTokenizer[not tokenized yet]";
    L7:
        return "StrTokenizer" + getTokenList();
    }

    public StrTokenizer() {
        this.delimMatcher = StrMatcher.splitMatcher();
        this.quoteMatcher = StrMatcher.noneMatcher();
        this.ignoredMatcher = StrMatcher.noneMatcher();
        this.trimmerMatcher = StrMatcher.noneMatcher();
        this.emptyAsNull = false;
        this.ignoreEmptyTokens = true;
        this.chars = null;
    }

    public Object clone() {
        return cloneReset();
    L4:
        return null;
    }

    public Object cloneReset() throws CloneNotSupportedException {
        StrTokenizer r100 = (StrTokenizer) super.clone();
        char[] r101 = r100.chars;
        if (r101 == null) goto L5;
        r100.chars = (char[]) r101.clone();
    L5:
        r100.reset();
        return r100;
    }

    public List<String> getTokenList() {
        checkTokenized();
        ArrayList r100 = new ArrayList(this.tokens.length);
        r100.addAll(Arrays.asList(this.tokens));
        return r100;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        checkTokenized();
        if (this.tokenPos >= this.tokens.length) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        checkTokenized();
        if (this.tokenPos <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public String next() {
        if (hasNext() == false) goto L7;
        String[] r100 = this.tokens;
        int r101 = this.tokenPos;
        this.tokenPos = r101 + 1;
        return r100[r101];
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    /* JADX INFO: renamed from: previous, reason: avoid collision after fix types in other method */
    public String previous2() {
        if (hasPrevious() == false) goto L7;
        String[] r100 = this.tokens;
        int r101 = this.tokenPos - 1;
        this.tokenPos = r101;
        return r100[r101];
    L7:
        throw new NoSuchElementException();
    }

    public StrMatcher getDelimiterMatcher() {
        return this.delimMatcher;
    }

    public StrMatcher getIgnoredMatcher() {
        return this.ignoredMatcher;
    }

    public StrMatcher getQuoteMatcher() {
        return this.quoteMatcher;
    }

    public StrMatcher getTrimmerMatcher() {
        return this.trimmerMatcher;
    }

    public boolean isEmptyTokenAsNull() {
        return this.emptyAsNull;
    }

    public boolean isIgnoreEmptyTokens() {
        return this.ignoreEmptyTokens;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.tokenPos;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // java.util.ListIterator
    public /* bridge */ /* synthetic */ String previous() {
        return previous2();
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public void add2(String r100) {
        throw new UnsupportedOperationException("add() is unsupported");
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(String r100) {
        throw new UnsupportedOperationException("set() is unsupported");
    }

    public StrTokenizer setDelimiterMatcher(StrMatcher r100) {
        if (r100 != null) goto L4;
        this.delimMatcher = StrMatcher.noneMatcher();
    L5:
        return this;
    L4:
        this.delimMatcher = r100;
        goto L5
    }

    public StrTokenizer setEmptyTokenAsNull(boolean r100) {
        this.emptyAsNull = r100;
        return this;
    }

    public StrTokenizer setIgnoreEmptyTokens(boolean r100) {
        this.ignoreEmptyTokens = r100;
        return this;
    }

    public StrTokenizer setIgnoredMatcher(StrMatcher r100) {
        if (r100 == null) goto L4;
        this.ignoredMatcher = r100;
    L4:
        return this;
    }

    public StrTokenizer setQuoteMatcher(StrMatcher r100) {
        if (r100 == null) goto L4;
        this.quoteMatcher = r100;
    L4:
        return this;
    }

    public StrTokenizer setTrimmerMatcher(StrMatcher r100) {
        if (r100 == null) goto L4;
        this.trimmerMatcher = r100;
    L4:
        return this;
    }

    @Override // java.util.ListIterator
    public /* bridge */ /* synthetic */ void add(String r100) {
        add2(r100);
    }

    @Override // java.util.ListIterator
    public /* bridge */ /* synthetic */ void set(String r100) {
        set2(r100);
    }

    private void addToken(List<String> r100, String r101) {
        if (StringUtils.isEmpty(r101) == true) goto L5;
    L10:
        r100.add(r101);
        return;
    L5:
        if (isIgnoreEmptyTokens() == false) goto L8;
        return;
    L8:
        if (isEmptyTokenAsNull() == false) goto L10;
        r101 = null;
        goto L10
    }

    public List<String> tokenize(char[] r100, int r110, int r111) {
        if (r100 == null) goto L13;
        if (r111 == 0) goto L13;
        StrBuilder r101 = new StrBuilder();
        ArrayList r102 = new ArrayList();
        int r103 = r110;
    L6:
        if (r103 < 0) goto L11;
        if (r103 >= r111) goto L11;
        r103 = readNextToken(r100, r103, r111, r101, r102);
        if (r103 < r111) goto L6;
        addToken(r102, "");
    L11:
        return r102;
    L13:
        return Collections.emptyList();
    }

    private boolean isQuote(char[] r100, int r101, int r102, int r103, int r104) {
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L11;
        int r106 = r101 + r105;
        if (r106 >= r102) goto L10;
        if (r100[r106] != r100[r103 + r105]) goto L10;
        r105 = r105 + 1;
    L10:
        return false;
    L11:
        return true;
    }

    private int readNextToken(char[] r100, int r110, int r111, StrBuilder r112, List<String> r113) {
    L2:
        if (r110 >= r111) goto L12;
        int r101 = Math.max(getIgnoredMatcher().isMatch(r100, r110, r110, r111), getTrimmerMatcher().isMatch(r100, r110, r110, r111));
        if (r101 == 0) goto L12;
        if (getDelimiterMatcher().isMatch(r100, r110, r110, r111) > 0) goto L12;
        if (getQuoteMatcher().isMatch(r100, r110, r110, r111) > 0) goto L12;
        r110 = r110 + r101;
    L12:
        if (r110 < r111) goto L15;
        addToken(r113, "");
        return -1;
    L15:
        int r102 = getDelimiterMatcher().isMatch(r100, r110, r110, r111);
        if (r102 <= 0) goto L19;
        addToken(r113, "");
        return r110 + r102;
    L19:
        int r103 = getQuoteMatcher().isMatch(r100, r110, r110, r111);
        if (r103 <= 0) goto L24;
        return readWithQuotes(r100, r110 + r103, r111, r112, r113, r110, r103);
    L24:
        return readWithQuotes(r100, r110, r111, r112, r113, 0, 0);
    }

    private int readWithQuotes(char[] r110, int r111, int r210, StrBuilder r211, List<String> r212, int r213, int r214) {
        r211.clear();
        if (r214 <= 0) goto L5;
        boolean r100 = true;
    L6:
        boolean r112 = r100;
        int r101 = r111;
        int r102 = 0;
    L7:
        if (r101 >= r210) goto L31;
        if (r112 == true) goto L9;
        int r113 = r102;
        int r114 = r101;
        int r103 = getDelimiterMatcher().isMatch(r110, r114, r111, r210);
        if (r103 > 0) goto L18;
        if (r214 <= 0) goto L24;
        if (isQuote(r110, r114, r210, r213, r214) == false) goto L24;
        r101 = r114 + r214;
        r102 = r113;
        r112 = true;
    L24:
        int r104 = getIgnoredMatcher().isMatch(r110, r114, r111, r210);
        if (r104 > 0) goto L26;
        r104 = getTrimmerMatcher().isMatch(r110, r114, r111, r210);
        if (r104 > 0) goto L29;
        r101 = r114 + 1;
        r211.append(r110[r114]);
        r102 = r211.size();
        goto L7
    L29:
        r211.append(r110, r114, r104);
    L26:
        r101 = r114 + r104;
        r102 = r113;
        goto L7
    L18:
        addToken(r212, r211.substring(0, r113));
        return r114 + r103;
    L9:
        int r115 = r102;
        int r116 = r101;
        if (isQuote(r110, r101, r210, r213, r214) == true) goto L11;
        r101 = r116 + 1;
        r211.append(r110[r116]);
        r102 = r211.size();
        goto L7
    L11:
        int r117 = r116 + r214;
        if (isQuote(r110, r117, r210, r213, r214) == true) goto L13;
        r102 = r115;
        r101 = r117;
        r112 = false;
        goto L7
    L13:
        r211.append(r110, r116, r214);
        r101 = r116 + (r214 * 2);
        r102 = r211.size();
        goto L7
    L31:
        addToken(r212, r211.substring(0, r102));
        return -1;
    L5:
        r100 = false;
        goto L6
    }
}
