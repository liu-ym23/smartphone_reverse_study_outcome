package com.bytedance.ee.bear.doc.translate;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ChooseLanguageData implements NonProguard {
    public String[] display_languages;
    public String[] languages;
    public String title;

    public ChooseLanguageData() {
    }

    public String toString() {
        return "ChooseLanguageData{title='" + this.title + "', languages=" + Arrays.toString(this.languages) + ", displayLanguages=" + Arrays.toString(this.display_languages) + '}';
    }

    public static boolean validate(ChooseLanguageData r2) {
        if (r2 == null) goto L12;
        String[] r0 = r2.languages;
        if (r0 == null) goto L12;
        String[] r3 = r2.display_languages;
        if (r3 == null) goto L12;
        if (r0.length <= 0) goto L12;
        if (r0.length != r3.length) goto L12;
        return true;
    L12:
        return false;
    }
}
