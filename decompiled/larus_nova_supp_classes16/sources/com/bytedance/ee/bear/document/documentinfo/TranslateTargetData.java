package com.bytedance.ee.bear.document.documentinfo;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/document/documentinfo/TranslateTargetData;", "Lcom/bytedance/ee/util/io/NonProguard;", "language", "", "languageText", "srcLang", "userDefaultTargetLang", "userMainLang", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "getLanguageText", "setLanguageText", "getSrcLang", "setSrcLang", "getUserDefaultTargetLang", "setUserDefaultTargetLang", "getUserMainLang", "setUserMainLang", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TranslateTargetData implements NonProguard {
    private String language;
    private String languageText;
    private String srcLang;
    private String userDefaultTargetLang;
    private String userMainLang;

    public static /* synthetic */ TranslateTargetData copy$default(TranslateTargetData r3, String r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.language;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.languageText;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.srcLang;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.userDefaultTargetLang;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.userMainLang;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
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

    public final TranslateTargetData copy(String r8, String r9, String r10, String r11, String r12) {
        return new TranslateTargetData(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TranslateTargetData) == true) goto L8;
        return false;
    L8:
        TranslateTargetData r6 = (TranslateTargetData) r5;
        if (Intrinsics.areEqual(this.language, r6.language) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.languageText, r6.languageText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.srcLang, r6.srcLang) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.userDefaultTargetLang, r6.userDefaultTargetLang) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.userMainLang, r6.userMainLang) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.language;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.languageText;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.srcLang;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.userDefaultTargetLang;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.userMainLang;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
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

    public final void setLanguage(String r1) {
        this.language = r1;
    }

    public final void setLanguageText(String r1) {
        this.languageText = r1;
    }

    public final void setSrcLang(String r1) {
        this.srcLang = r1;
    }

    public final void setUserDefaultTargetLang(String r1) {
        this.userDefaultTargetLang = r1;
    }

    public final void setUserMainLang(String r1) {
        this.userMainLang = r1;
    }

    public TranslateTargetData(String r1, String r2, String r3, String r4, String r5) {
        this.language = r1;
        this.languageText = r2;
        this.srcLang = r3;
        this.userDefaultTargetLang = r4;
        this.userMainLang = r5;
    }
}
