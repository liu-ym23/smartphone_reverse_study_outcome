package com.ss.android.lark.passport.signinsdk_api.country;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes37.dex */
public class CountryBean implements Serializable {
    private String code;

    @JSONField(name = "full_pinyin")
    private String fullPinyin;

    @JSONField(name = "head_index")
    private String headIndex;

    @JSONField(name = "head_pinyin")
    private String headPinyin;
    private String key;
    private String name;
    private String pattern;

    @JSONField(name = "roma_word")
    private String romaWord;

    public CountryBean() {
    }

    public String getCode() {
        return this.code;
    }

    public String getFullPinyin() {
        return this.fullPinyin;
    }

    public String getHeadIndex() {
        return this.headIndex;
    }

    public String getHeadPinyin() {
        return this.headPinyin;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String getPattern() {
        return this.pattern;
    }

    public String getRomaWord() {
        return this.romaWord;
    }

    public CountryBean(CountryBean r100) {
        this.key = r100.key;
        this.name = r100.name;
        this.code = r100.code;
        this.fullPinyin = r100.fullPinyin;
        this.headPinyin = r100.headPinyin;
        this.headIndex = r100.headIndex;
        this.romaWord = r100.romaWord;
        this.pattern = r100.pattern;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (getClass() == r100.getClass()) goto L10;
        return false;
    L10:
        return Objects.equals(this.key, ((CountryBean) r100).key);
    }

    public void setCode(String r100) {
        this.code = r100;
    }

    public void setFullPinyin(String r100) {
        this.fullPinyin = r100;
    }

    public void setHeadIndex(String r100) {
        this.headIndex = r100;
    }

    public void setHeadPinyin(String r100) {
        this.headPinyin = r100;
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setPattern(String r100) {
        this.pattern = r100;
    }

    public void setRomaWord(String r100) {
        this.romaWord = r100;
    }
}
