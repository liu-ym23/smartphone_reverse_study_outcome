package com.bytedance.ee.bear.document.selection.translate;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u0003H\u0016J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/document/selection/translate/TranslationData;", "Lcom/bytedance/ee/util/io/NonProguard;", "originText", "", "token", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getOriginText", "()Ljava/lang/String;", "getToken", "toString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TranslationData implements NonProguard {
    private final String originText;
    private final String token;

    /* JADX WARN: Multi-variable type inference failed */
    public TranslationData() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TranslationData copy$default(TranslationData r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.originText;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.token;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.originText;
    }

    public final String component2() {
        return this.token;
    }

    public final TranslationData copy(String r100, String r101) {
        return new TranslationData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TranslationData) == true) goto L8;
        return false;
    L8:
        TranslationData r101 = (TranslationData) r100;
        if (Intrinsics.areEqual(this.originText, r101.originText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.originText;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.token;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "TranslationData(originText=" + this.originText + ')';
    }

    public final String getOriginText() {
        return this.originText;
    }

    public final String getToken() {
        return this.token;
    }

    public TranslationData(String r100, String r101) {
        this.originText = r100;
        this.token = r101;
    }

    public /* synthetic */ TranslationData(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
