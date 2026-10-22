package com.ss.android.lark.chat.entity.translate;

import android.text.TextUtils;
import com.bytedance.lark.pb.im.v1.SrcLanguageConfig;
import com.ss.android.lark.utils.LarkContext;
import java.io.Serializable;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes35.dex */
public class LanguageInfo implements Serializable {
    private String curLanguageDisplayName;
    private String displayName;
    private String key;

    public int hashCode() {
        return Objects.hash(new Object[]{this.key, this.displayName, this.curLanguageDisplayName});
    }

    public String getCurLanguageDisplayName() {
        if (TextUtils.isEmpty(this.curLanguageDisplayName) == false) goto L7;
        return this.displayName;
    L7:
        return this.curLanguageDisplayName;
    }

    public String toString() {
        return "LanguageInfo { " + this.key + " , " + this.displayName + " , " + this.curLanguageDisplayName + " }";
    }

    private LanguageInfo() {
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getKey() {
        return this.key;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L19;
        LanguageInfo r101 = (LanguageInfo) r100;
        if (Objects.equals(this.key, r101.key) == true) goto L13;
    L17:
        return false;
    L13:
        if (Objects.equals(this.displayName, r101.displayName) == false) goto L17;
        if (Objects.equals(this.curLanguageDisplayName, r101.curLanguageDisplayName) == false) goto L17;
        return true;
    }

    public void setCurLanguageDisplayName(Map<String, SrcLanguageConfig> r100) {
        SrcLanguageConfig r101 = r100.get(this.key);
        if (r101 == null) goto L6;
        Locale r102 = LarkContext.getApplication().getApplicationContext().getResources().getConfiguration().locale;
        this.curLanguageDisplayName = r101.i18n_language.get((r102.getLanguage() + "_" + r102.getCountry()).toLowerCase());
        return;
    }

    public LanguageInfo(String r100, String r101) {
        this.key = r100;
        this.displayName = r101;
    }
}
