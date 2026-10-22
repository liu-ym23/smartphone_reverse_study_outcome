package com.ss.android.lark.chat.entity.translate;

import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes35.dex */
public class TranslateInfo implements Serializable, Cloneable {
    private String language;
    private int messageContentVersion;
    private String messageId;
    private HashMap<String, TranslateInfo> subTranslateInfoMap;
    private Content translateContent;

    public int hashCode() {
        String r100 = this.messageId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.language;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Content r107 = this.translateContent;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return ((r106 + r101) * 31) + this.messageContentVersion;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public TranslateInfo clone() {
        TranslateInfo r100 = (TranslateInfo) super.clone();     // Catch: CloneNotSupportedException -> L6
        if ((r100.getTranslateContent() instanceof MergeForwardContent) == false) goto L5;
        r100.setTranslateContent(((MergeForwardContent) r100.getTranslateContent()).clone());     // Catch: CloneNotSupportedException -> L6
    L5:
        return r100;
    L6:
        return null;
    }

    public TranslateInfo() {
    }

    public String getLanguage() {
        return this.language;
    }

    public int getMessageContentVersion() {
        return this.messageContentVersion;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public Map<String, TranslateInfo> getSubTranslateInfoMap() {
        return this.subTranslateInfoMap;
    }

    public <T extends Content> T getTranslateContent() {
        return (T) this.translateContent;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8615clone() throws CloneNotSupportedException {
        return clone();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L21;
        TranslateInfo r101 = (TranslateInfo) r100;
        if (Objects.equals(this.messageId, r101.messageId) == true) goto L14;
        return false;
    L14:
        if (Objects.equals(this.language, r101.language) == true) goto L17;
        return false;
    L17:
        if (this.messageContentVersion == r101.messageContentVersion) goto L20;
        return false;
    L20:
        return Objects.equals(this.translateContent, r101.translateContent);
    }

    public void setLanguage(String r100) {
        this.language = r100;
    }

    public void setMessageId(String r100) {
        this.messageId = r100;
    }

    public void setSubTranslateInfoMap(HashMap<String, TranslateInfo> r100) {
        this.subTranslateInfoMap = r100;
    }

    public void setTranslateContent(Content r100) {
        this.translateContent = r100;
    }

    public TranslateInfo(String r100, String r101, Content r102) {
        this.messageId = r100;
        this.language = r101;
        this.translateContent = r102;
    }

    public TranslateInfo(String r100, String r101, Content r102, int r103) {
        this.messageId = r100;
        this.language = r101;
        this.translateContent = r102;
        this.messageContentVersion = r103;
    }
}
