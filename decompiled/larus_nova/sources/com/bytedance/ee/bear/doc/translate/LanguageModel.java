package com.bytedance.ee.bear.doc.translate;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
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

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L17;
        LanguageModel r101 = (LanguageModel) r100;
        if (Objects.equals(this.displayText, r101.displayText) == true) goto L13;
    L15:
        return false;
    L13:
        if (Objects.equals(this.tag, r101.tag) == false) goto L15;
        return true;
    }

    public void setDisplayText(String r100) {
        this.displayText = r100;
    }

    public void setTag(String r100) {
        this.tag = r100;
    }

    public LanguageModel(String r100, String r101) {
        this.displayText = r100;
        this.tag = r101;
    }

    public static LanguageModel buildLanguageModel(String r100, String r101) {
        return new LanguageModel(r101, r100);
    }

    public static List<LanguageModel> buildLanguageModelList(String[] r100, String[] r101) {
        ArrayList r102 = new ArrayList();
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L6;
        r102.add(new LanguageModel(r101[r103], r100[r103]));
        r103 = r103 + 1;
        goto L4
    L6:
        return r102;
    }
}
