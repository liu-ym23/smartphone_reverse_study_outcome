package com.bytedance.ee.bear.doc.translate;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class LanguageModel implements NonProguard {
    private String displayText;
    private String tag;

    public int hashCode() {
        return Objects.hash(new Object[]{this.displayText, this.tag});
    }

    public String toString() {
        return "LanguageItem{displayText='" + this.displayText + "', tag='" + this.tag + "'}";
    }

    public LanguageModel() {
    }

    public String getDisplayText() {
        return this.displayText;
    }

    public String getTag() {
        return this.tag;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        LanguageModel r6 = (LanguageModel) r5;
        if (Objects.equals(this.displayText, r6.displayText) == true) goto L13;
    L15:
        return false;
    L13:
        if (Objects.equals(this.tag, r6.tag) == false) goto L15;
        return true;
    }

    public void setDisplayText(String r1) {
        this.displayText = r1;
    }

    public void setTag(String r1) {
        this.tag = r1;
    }

    public LanguageModel(String r1, String r2) {
        this.displayText = r1;
        this.tag = r2;
    }

    public static LanguageModel buildLanguageModel(String r1, String r2) {
        return new LanguageModel(r2, r1);
    }

    public static List<LanguageModel> buildLanguageModelList(String[] r5, String[] r6) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L6;
        r0.add(new LanguageModel(r6[r1], r5[r1]));
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }
}
