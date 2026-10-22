package io.noties.markwon.html.jsoup.parser;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes41.dex */
public class ParseErrorList extends ArrayList<b> {
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

    public int getMaxSize() {
        return this.maxSize;
    }

    public static ParseErrorList tracking(int r100) {
        return new ParseErrorList(16, r100);
    }

    public ParseErrorList(int r100, int r101) {
        super(r100);
        this.maxSize = r101;
    }
}
