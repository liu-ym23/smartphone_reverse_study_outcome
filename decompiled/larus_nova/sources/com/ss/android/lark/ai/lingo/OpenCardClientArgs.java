package com.ss.android.lark.ai.lingo;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003JV\u0010\u001f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/ss/android/lark/ai/lingo/OpenCardClientArgs;", "", "page", "", "query", "abbrId", "showIgnore", "", "extra", "Lcom/ss/android/lark/ai/lingo/Extra;", "analysisParams", "Lcom/ss/android/lark/ai/lingo/AnalysisParams;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/ss/android/lark/ai/lingo/Extra;Lcom/ss/android/lark/ai/lingo/AnalysisParams;)V", "getPage", "()Ljava/lang/String;", "getQuery", "getAbbrId", "getShowIgnore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getExtra", "()Lcom/ss/android/lark/ai/lingo/Extra;", "getAnalysisParams", "()Lcom/ss/android/lark/ai/lingo/AnalysisParams;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/ss/android/lark/ai/lingo/Extra;Lcom/ss/android/lark/ai/lingo/AnalysisParams;)Lcom/ss/android/lark/ai/lingo/OpenCardClientArgs;", "equals", "other", "hashCode", "", "toString", "ai-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenCardClientArgs {
    private final String abbrId;
    private final AnalysisParams analysisParams;
    private final Extra extra;
    private final String page;
    private final String query;
    private final Boolean showIgnore;

    public static /* synthetic */ OpenCardClientArgs copy$default(OpenCardClientArgs r100, String r101, String r102, String r103, Boolean r104, Extra r105, AnalysisParams r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.page;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.query;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.abbrId;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.showIgnore;
    L14:
        Boolean r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.extra;
    L17:
        Extra r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.analysisParams;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.page;
    }

    public final String component2() {
        return this.query;
    }

    public final String component3() {
        return this.abbrId;
    }

    public final Boolean component4() {
        return this.showIgnore;
    }

    public final Extra component5() {
        return this.extra;
    }

    public final AnalysisParams component6() {
        return this.analysisParams;
    }

    public final OpenCardClientArgs copy(@JSONField(name = "page") String r100, @JSONField(name = "query") String r110, @JSONField(name = "abbrId") String r111, @JSONField(name = "showIgnore") Boolean r112, @JSONField(name = "extra") Extra r113, @JSONField(name = "analysisParams") AnalysisParams r114) {
        return new OpenCardClientArgs(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenCardClientArgs) == true) goto L8;
        return false;
    L8:
        OpenCardClientArgs r101 = (OpenCardClientArgs) r100;
        if (Intrinsics.areEqual(this.page, r101.page) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.query, r101.query) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.abbrId, r101.abbrId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showIgnore, r101.showIgnore) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.analysisParams, r101.analysisParams) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.page;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.query;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.abbrId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.showIgnore;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Extra r113 = this.extra;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        AnalysisParams r116 = this.analysisParams;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "OpenCardClientArgs(page=" + this.page + ", query=" + this.query + ", abbrId=" + this.abbrId + ", showIgnore=" + this.showIgnore + ", extra=" + this.extra + ", analysisParams=" + this.analysisParams + ')';
    }

    public final String getAbbrId() {
        return this.abbrId;
    }

    public final AnalysisParams getAnalysisParams() {
        return this.analysisParams;
    }

    public final Extra getExtra() {
        return this.extra;
    }

    public final String getPage() {
        return this.page;
    }

    public final String getQuery() {
        return this.query;
    }

    public final Boolean getShowIgnore() {
        return this.showIgnore;
    }

    public OpenCardClientArgs(@JSONField(name = "page") String r100, @JSONField(name = "query") String r101, @JSONField(name = "abbrId") String r102, @JSONField(name = "showIgnore") Boolean r103, @JSONField(name = "extra") Extra r104, @JSONField(name = "analysisParams") AnalysisParams r105) {
        this.page = r100;
        this.query = r101;
        this.abbrId = r102;
        this.showIgnore = r103;
        this.extra = r104;
        this.analysisParams = r105;
    }

    public /* synthetic */ OpenCardClientArgs(String r100, String r101, String r110, Boolean r111, Extra r112, AnalysisParams r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        r100 = Page.LingoCard.getValue();
    L5:
        this(r100, r101, r110, r111, r112, r113);
    }
}
