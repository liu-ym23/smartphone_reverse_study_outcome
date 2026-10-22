package com.bytedance.ee.bear;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes15.dex */
public class PageviewResult implements NonProguard {
    private int characterCount;
    private int wordCount;

    public PageviewResult() {
    }

    public int getCharacterCount() {
        return this.characterCount;
    }

    public int getWordCount() {
        return this.wordCount;
    }

    public void setCharacterCount(int r100) {
        this.characterCount = r100;
    }

    public void setWordCount(int r100) {
        this.wordCount = r100;
    }
}
