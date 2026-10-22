package com.bytedance.ee.bear.doc.translate;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;

/* JADX INFO: loaded from: classes16.dex */
public class ChooseLanguageData implements NonProguard {
    public String[] display_languages;
    public String[] languages;
    public String title;

    public ChooseLanguageData() {
    }

    public String toString() {
        return "ChooseLanguageData{title='" + this.title + "', languages=" + Arrays.toString(this.languages) + ", displayLanguages=" + Arrays.toString(this.display_languages) + '}';
    }

    public static boolean validate(ChooseLanguageData r100) {
        if (r100 == null) goto L12;
        String[] r101 = r100.languages;
        if (r101 == null) goto L12;
        String[] r102 = r100.display_languages;
        if (r102 == null) goto L12;
        if (r101.length <= 0) goto L12;
        if (r101.length != r102.length) goto L12;
        return true;
    L12:
        return false;
    }
}
