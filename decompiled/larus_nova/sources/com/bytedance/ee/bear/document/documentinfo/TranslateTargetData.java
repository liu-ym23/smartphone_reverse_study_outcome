package com.bytedance.ee.bear.document.documentinfo;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/document/documentinfo/TranslateTargetData;", "Lcom/bytedance/ee/util/io/NonProguard;", "language", "", "languageText", "srcLang", "userDefaultTargetLang", "userMainLang", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "getLanguageText", "setLanguageText", "getSrcLang", "setSrcLang", "getUserDefaultTargetLang", "setUserDefaultTargetLang", "getUserMainLang", "setUserMainLang", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TranslateTargetData implements NonProguard {
    private String language;
    private String languageText;
    private String srcLang;
    private String userDefaultTargetLang;
    private String userMainLang;

    public static /* synthetic */ TranslateTargetData copy$default(TranslateTargetData r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.language;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.languageText;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.srcLang;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.userDefaultTargetLang;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.userMainLang;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.language;
    }

    public final String component2() {
        return this.languageText;
    }

    public final String component3() {
        return this.srcLang;
    }

    public final String component4() {
        return this.userDefaultTargetLang;
    }

    public final String component5() {
        return this.userMainLang;
    }

    public final TranslateTargetData copy(String r100, String r101, String r110, String r111, String r112) {
        return new TranslateTargetData(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TranslateTargetData) == true) goto L8;
        return false;
    L8:
        TranslateTargetData r101 = (TranslateTargetData) r100;
        if (Intrinsics.areEqual(this.language, r101.language) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.languageText, r101.languageText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.srcLang, r101.srcLang) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.userDefaultTargetLang, r101.userDefaultTargetLang) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.userMainLang, r101.userMainLang) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.language;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.languageText;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.srcLang;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.userDefaultTargetLang;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.userMainLang;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "TranslateTargetData(language=" + this.language + ", languageText=" + this.languageText + ", srcLang=" + this.srcLang + ", userDefaultTargetLang=" + this.userDefaultTargetLang + ", userMainLang=" + this.userMainLang + ')';
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getLanguageText() {
        return this.languageText;
    }

    public final String getSrcLang() {
        return this.srcLang;
    }

    public final String getUserDefaultTargetLang() {
        return this.userDefaultTargetLang;
    }

    public final String getUserMainLang() {
        return this.userMainLang;
    }

    public final void setLanguage(String r100) {
        this.language = r100;
    }

    public final void setLanguageText(String r100) {
        this.languageText = r100;
    }

    public final void setSrcLang(String r100) {
        this.srcLang = r100;
    }

    public final void setUserDefaultTargetLang(String r100) {
        this.userDefaultTargetLang = r100;
    }

    public final void setUserMainLang(String r100) {
        this.userMainLang = r100;
    }

    public TranslateTargetData(String r100, String r101, String r102, String r103, String r104) {
        this.language = r100;
        this.languageText = r101;
        this.srcLang = r102;
        this.userDefaultTargetLang = r103;
        this.userMainLang = r104;
    }
}
