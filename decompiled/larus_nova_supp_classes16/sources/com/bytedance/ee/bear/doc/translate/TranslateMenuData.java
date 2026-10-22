package com.bytedance.ee.bear.doc.translate;

import com.bytedance.ee.bear.document.menu.MenuData;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TranslateMenuData extends MenuData {
    private int display_language_index;
    private List<String> display_languages;
    private List<String> languages;

    @Override // com.bytedance.ee.bear.document.menu.MenuData
    public String toString() {
        return "TranslateMenuData{languages=" + this.languages + ", display_language_index=" + this.display_language_index + ", display_languages=" + this.display_languages + '}';
    }

    public TranslateMenuData() {
    }

    public int getDisplay_language_index() {
        return this.display_language_index;
    }

    public List<String> getDisplay_languages() {
        return this.display_languages;
    }

    public List<String> getLanguages() {
        return this.languages;
    }

    public void setDisplay_language_index(int r1) {
        this.display_language_index = r1;
    }

    public void setDisplay_languages(List<String> r1) {
        this.display_languages = r1;
    }

    public void setLanguages(List<String> r1) {
        this.languages = r1;
    }
}
