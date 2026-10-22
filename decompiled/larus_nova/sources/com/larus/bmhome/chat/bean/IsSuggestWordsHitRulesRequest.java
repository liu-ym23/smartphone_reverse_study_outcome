package com.larus.bmhome.chat.bean;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ:\u0010\u0018\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R(\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/bean/IsSuggestWordsHitRulesRequest;", "", "paramList", "", "Lcom/larus/bmhome/chat/bean/RuleRequestParamRequest;", "scene", "", "type", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getParamList", "()Ljava/util/List;", "setParamList", "(Ljava/util/List;)V", "getScene", "()Ljava/lang/Integer;", "setScene", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getType", "setType", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/bean/IsSuggestWordsHitRulesRequest;", "equals", "", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IsSuggestWordsHitRulesRequest {

    @SerializedName("text")
    private List<RuleRequestParamRequest> paramList;

    @SerializedName("scene")
    private Integer scene;

    @SerializedName("rule_type")
    private Integer type;

    public IsSuggestWordsHitRulesRequest() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IsSuggestWordsHitRulesRequest copy$default(IsSuggestWordsHitRulesRequest r100, List r101, Integer r102, Integer r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.paramList;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.scene;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.type;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final List<RuleRequestParamRequest> component1() {
        return this.paramList;
    }

    public final Integer component2() {
        return this.scene;
    }

    public final Integer component3() {
        return this.type;
    }

    public final IsSuggestWordsHitRulesRequest copy(List<RuleRequestParamRequest> r100, Integer r101, Integer r102) {
        return new IsSuggestWordsHitRulesRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IsSuggestWordsHitRulesRequest) == true) goto L8;
        return false;
    L8:
        IsSuggestWordsHitRulesRequest r101 = (IsSuggestWordsHitRulesRequest) r100;
        if (Intrinsics.areEqual(this.paramList, r101.paramList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<RuleRequestParamRequest> r100 = this.paramList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.scene;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.type;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "IsSuggestWordsHitRulesRequest(paramList=" + this.paramList + ", scene=" + this.scene + ", type=" + this.type + ')';
    }

    public final List<RuleRequestParamRequest> getParamList() {
        return this.paramList;
    }

    public final Integer getScene() {
        return this.scene;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setParamList(List<RuleRequestParamRequest> r100) {
        this.paramList = r100;
    }

    public final void setScene(Integer r100) {
        this.scene = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }

    public IsSuggestWordsHitRulesRequest(List<RuleRequestParamRequest> r100, Integer r101, Integer r102) {
        this.paramList = r100;
        this.scene = r101;
        this.type = r102;
    }

    public /* synthetic */ IsSuggestWordsHitRulesRequest(List r100, Integer r101, Integer r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
