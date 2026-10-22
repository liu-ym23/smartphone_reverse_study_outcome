package com.bytedance.ee.bear.doc.translate;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RecentUsedLanguageModel implements NonProguard {
    private static final int RECENT_LIST_SIZE = 3;

    @JSONField(name = "languages")
    private List<LanguageModel> languages;

    public List<LanguageModel> getLanguages() {
        return Collections.unmodifiableList(this.languages);
    }

    public String toString() {
        return "RecentUsedLanguageModel{languages=" + this.languages + '}';
    }

    public RecentUsedLanguageModel() {
        this.languages = new ArrayList();
    }

    public void insert(LanguageModel r3) {
        this.languages.remove(r3);
        ListProtector.add(this.languages, 0, r3);
        if (this.languages.size() <= 3) goto L6;
        List<LanguageModel> r4 = this.languages;
        ListProtector.remove(r4, r4.size() - 1);
        return;
    }

    public void setLanguages(List<LanguageModel> r1) {
        this.languages = r1;
    }
}
