package com.larus.bmhome.chat.bean;

import com.google.gson.annotations.SerializedName;
import ic8.r0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R(\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/bean/IsSuggestWordsHitRulesResponse;", "", "rulesData", "", "Lcom/larus/bmhome/chat/bean/RuleRequestParamResponse;", "<init>", "(Ljava/util/List;)V", "getRulesData", "()Ljava/util/List;", "setRulesData", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IsSuggestWordsHitRulesResponse {

    @SerializedName("result")
    private List<r0> rulesData;

    /* JADX WARN: Multi-variable type inference failed */
    public IsSuggestWordsHitRulesResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IsSuggestWordsHitRulesResponse copy$default(IsSuggestWordsHitRulesResponse r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.rulesData;
    L6:
        return r100.copy(r101);
    }

    public final List<r0> component1() {
        return this.rulesData;
    }

    public final IsSuggestWordsHitRulesResponse copy(List<r0> r100) {
        return new IsSuggestWordsHitRulesResponse(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IsSuggestWordsHitRulesResponse) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.rulesData, ((IsSuggestWordsHitRulesResponse) r100).rulesData) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<r0> r100 = this.rulesData;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "IsSuggestWordsHitRulesResponse(rulesData=" + this.rulesData + ')';
    }

    public final List<r0> getRulesData() {
        return this.rulesData;
    }

    public IsSuggestWordsHitRulesResponse(List<r0> r100) {
        this.rulesData = r100;
    }

    public final void setRulesData(List<r0> r100) {
        this.rulesData = r100;
    }

    public /* synthetic */ IsSuggestWordsHitRulesResponse(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new ArrayList();
    L5:
        this(r100);
    }
}
