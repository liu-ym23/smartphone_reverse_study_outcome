package com.ss.android.lark.biz.im.api;

import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public interface m0 {
    void onPushDisableAutoTranslateLanguages(List<String> r100);

    void onPushGlobalAutoTranslateScope(int r100);

    void onPushSpecificAutoTranslateScopeChanged(Map<String, Integer> r100);

    void onPushSpecificDisplayChanged(Map<String, Integer> r100);

    void onPushTranslateDisplayRules(TranslateLanguageSetting r100);

    void onPushTranslateLanguageSetting(TranslateLanguageSetting r100);
}
