package org.jsoup.parser;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes42.dex */
public class ParseErrorList extends ArrayList<c> {
    private final int initialCapacity;
    private final int maxSize;

    public static ParseErrorList noTracking() {
        return new ParseErrorList(0, 0);
    }

    public boolean canAddError() {
        if (size() >= this.maxSize) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.ArrayList
    public Object clone() {
        return super.clone();
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public ParseErrorList(ParseErrorList r100) {
        this(r100.initialCapacity, r100.maxSize);
    }

    public static ParseErrorList tracking(int r100) {
        return new ParseErrorList(16, r100);
    }

    public ParseErrorList(int r100, int r101) {
        super(r100);
        this.initialCapacity = r100;
        this.maxSize = r101;
    }
}
