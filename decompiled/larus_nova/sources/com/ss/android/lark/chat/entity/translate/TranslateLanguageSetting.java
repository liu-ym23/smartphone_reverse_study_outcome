package com.ss.android.lark.chat.entity.translate;

import android.text.TextUtils;
import com.bytedance.lark.pb.im.v1.LanguagesConfiguration;
import com.bytedance.lark.pb.im.v1.SrcLanguageConfig;
import com.bytedance.lark.pb.im.v1.TranslateScopeMask;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes35.dex */
public class TranslateLanguageSetting implements Serializable {
    private Set<String> disAutoTranslateKeySet;
    private Map<String, Integer> displayConfigMap;
    private int globalAutoTranslateScope;
    private int globalAutoTranslateVisibleScope;
    private int globalDisplayConfig;
    private List<LanguageInfo> supportedLanguageList;
    private String targetLanguageKey;

    public String getTargetLanguageDisplayName() {
        List<LanguageInfo> r100 = this.supportedLanguageList;
        if (r100 != null) goto L5;
        return "";
    L5:
        if (this.targetLanguageKey == null) goto L18;
        Iterator<LanguageInfo> r101 = r100.iterator();
    L8:
        if (r101.hasNext() == false) goto L19;
        LanguageInfo r102 = r101.next();
        if (TextUtils.equals(this.targetLanguageKey, r102.getKey()) == false) goto L8;
        return r102.getCurLanguageDisplayName();
    L19:
        return "";
    L18:
        return "";
    }

    public String getTargetLanguageName() {
        List<LanguageInfo> r100 = this.supportedLanguageList;
        if (r100 != null) goto L5;
        return "";
    L5:
        if (this.targetLanguageKey == null) goto L18;
        Iterator<LanguageInfo> r101 = r100.iterator();
    L8:
        if (r101.hasNext() == false) goto L19;
        LanguageInfo r102 = r101.next();
        if (this.targetLanguageKey.equals(r102.getKey()) == false) goto L8;
        return r102.getDisplayName();
    L19:
        return "";
    L18:
        return "";
    }

    public boolean isDocAutoTranslate() {
        if ((this.globalAutoTranslateScope & TranslateScopeMask.DOC_MASK.getValue()) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isGlobalAutoTranslate() {
        if ((this.globalAutoTranslateScope & TranslateScopeMask.LARK_MESSAGE_MASK.getValue()) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Set<String> getDisAutoTranslateKeySet() {
        return this.disAutoTranslateKeySet;
    }

    public Map<String, Integer> getDisplayConfigMap() {
        return this.displayConfigMap;
    }

    public int getGlobalAutoTranslateScope() {
        return this.globalAutoTranslateScope;
    }

    public int getGlobalAutoTranslateVisibleScope() {
        return this.globalAutoTranslateVisibleScope;
    }

    public int getGlobalDisplayConfig() {
        return this.globalDisplayConfig;
    }

    public List<LanguageInfo> getSupportedLanguageList() {
        return this.supportedLanguageList;
    }

    public String getTargetLanguageKey() {
        return this.targetLanguageKey;
    }

    public int getDisplayRule(String r100) {
        Integer r101 = 0;
        Map<String, Integer> r102 = this.displayConfigMap;
        if (r102 == null) goto L5;
        r101 = r102.get(r100);
    L5:
        if (r101 != null) goto L7;
    L8:
        r101 = Integer.valueOf(this.globalDisplayConfig);
    L10:
        return r101.intValue();
    L7:
        if (r101.intValue() != 0) goto L10;
        goto L8
    }

    public boolean needTranslate(String r100) {
        if (TextUtils.equals(r100, "not_lang") == false) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.equals(r100, getTargetLanguageKey()) == true) goto L9;
        if (getDisAutoTranslateKeySet().contains(r100) == true) goto L9;
        return true;
    }

    public void setDisAutoTranslateKeySet(Set<String> r100) {
        this.disAutoTranslateKeySet = r100;
    }

    public void setDisplayConfigMap(Map<String, Integer> r100) {
        this.displayConfigMap = r100;
    }

    public void setGlobalAutoTranslateScope(int r100) {
        this.globalAutoTranslateScope = r100;
    }

    public void setGlobalAutoTranslateVisibleScope(int r100) {
        this.globalAutoTranslateVisibleScope = r100;
    }

    public void setGlobalDisplayConfig(int r100) {
        this.globalDisplayConfig = r100;
    }

    public void setSupportedLanguageList(List<LanguageInfo> r100) {
        this.supportedLanguageList = r100;
    }

    public void setTargetLanguageKey(String r100) {
        this.targetLanguageKey = r100;
    }

    public TranslateLanguageSetting(LanguagesConfiguration r100, Map<String, LanguagesConfiguration> r101) {
        setDisplayRule(r100, r101);
    }

    public void setDisplayRule(LanguagesConfiguration r100, Map<String, LanguagesConfiguration> r101) {
        if (r100 == null) goto L4;
        int r102 = r100.rule.getValue();
    L5:
        this.globalDisplayConfig = r102;
        this.displayConfigMap = new HashMap();
        Iterator<Map.Entry<String, LanguagesConfiguration>> r103 = r101.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        Map.Entry<String, LanguagesConfiguration> r104 = r103.next();
        this.displayConfigMap.put(r104.getKey(), Integer.valueOf(r104.getValue().rule.getValue()));
        goto L7
    L9:
        return;
    L4:
        r102 = 0;
        goto L5
    }

    public TranslateLanguageSetting(String r100, List<String> r101, Map<String, String> r102) {
        this(r100, r101, r102, new HashMap());
    }

    public TranslateLanguageSetting(String r100, List<String> r101, Map<String, String> r102, Map<String, SrcLanguageConfig> r103) {
        this.targetLanguageKey = r100;
        if (r101 == null) goto L11;
        if (r102 == null) goto L17;
        this.supportedLanguageList = new ArrayList();
        Iterator<String> r104 = r101.iterator();
    L7:
        if (r104.hasNext() == false) goto L18;
        String r105 = r104.next();
        if (r102.containsKey(r105) == false) goto L7;
        LanguageInfo r106 = new LanguageInfo(r105, r102.get(r105));
        r106.setCurLanguageDisplayName(r103);
        this.supportedLanguageList.add(r106);
        goto L7
    L18:
        return;
    L17:
        return;
    }

    public TranslateLanguageSetting(Map<Integer, Boolean> r100, String r101, List<String> r102, Map<String, String> r103, List<String> r104, LanguagesConfiguration r105, Map<String, LanguagesConfiguration> r106, Map<String, SrcLanguageConfig> r107) {
        this(r101, r102, r103, r107);
        int r108 = 0;
        if (r100 == null) goto L10;
        Iterator<Map.Entry<Integer, Boolean>> r109 = r100.entrySet().iterator();
        int r110 = 0;
    L6:
        if (r109.hasNext() == false) goto L11;
        Map.Entry<Integer, Boolean> r111 = r109.next();
        if (r111.getValue().booleanValue() == false) goto L6;
        r110 = r110 | r111.getKey().intValue();
    L11:
        this.globalAutoTranslateScope = r110;
        if (r100 == null) goto L17;
        Iterator<Map.Entry<Integer, Boolean>> r112 = r100.entrySet().iterator();
    L15:
        if (r112.hasNext() == false) goto L17;
        r108 = r108 | r112.next().getKey().intValue();
    L17:
        this.globalAutoTranslateVisibleScope = r108;
        this.disAutoTranslateKeySet = new HashSet(r104);
        setDisplayRule(r105, r106);
        return;
    L10:
        r110 = 0;
        goto L11
    }
}
