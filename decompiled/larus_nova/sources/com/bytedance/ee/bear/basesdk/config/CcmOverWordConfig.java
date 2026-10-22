package com.bytedance.ee.bear.basesdk.config;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@AppConfig(key = "ccm_mobile_menu_controlled_config")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/basesdk/config/CcmOverWordConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "enWordCount", "", "getEnWordCount", "()I", "setEnWordCount", "(I)V", "wordCount", "getWordCount", "setWordCount", "maxCharCount", "getMaxCharCount", "setMaxCharCount", "maxCharWithSpaceCount", "getMaxCharWithSpaceCount", "setMaxCharWithSpaceCount", "toString", "", "Companion", "basesdk_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CcmOverWordConfig implements NonProguard {
    public static final a Companion = null;
    public static final String KEY = "ccm_mobile_menu_controlled_config";

    @SerializedName("cjk_count")
    private int enWordCount;

    @SerializedName("max_char_count")
    private int maxCharCount;

    @SerializedName("max_char_with_space")
    private int maxCharWithSpaceCount;

    @SerializedName("latin_count")
    private int wordCount;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public String toString() {
        return "CcmOverWordConfig{enWordCount=" + this.enWordCount + ", wordCount=" + this.wordCount + ", maxCharCount=" + this.maxCharCount + ", maxCharWithSpaceCount=" + this.maxCharWithSpaceCount + '}';
    }

    public CcmOverWordConfig() {
        this.enWordCount = 4;
        this.wordCount = 2;
        this.maxCharCount = 24;
        this.maxCharWithSpaceCount = 100;
    }

    public final int getEnWordCount() {
        return this.enWordCount;
    }

    public final int getMaxCharCount() {
        return this.maxCharCount;
    }

    public final int getMaxCharWithSpaceCount() {
        return this.maxCharWithSpaceCount;
    }

    public final int getWordCount() {
        return this.wordCount;
    }

    public final void setEnWordCount(int r100) {
        this.enWordCount = r100;
    }

    public final void setMaxCharCount(int r100) {
        this.maxCharCount = r100;
    }

    public final void setMaxCharWithSpaceCount(int r100) {
        this.maxCharWithSpaceCount = r100;
    }

    public final void setWordCount(int r100) {
        this.wordCount = r100;
    }
}
