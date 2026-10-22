package com.obric.memorydata.sdk.entity.search;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/BertQUAction;", "", "actionName", "", "query", "inputParams", "", "Lcom/obric/memorydata/sdk/entity/search/ParamItem;", "isStandardQuery", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Z)V", "getActionName", "()Ljava/lang/String;", "getQuery", "getInputParams", "()Ljava/util/Map;", "()Z", "setStandardQuery", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BertQUAction {
    private final String actionName;
    private final Map<String, ParamItem> inputParams;
    private boolean isStandardQuery;
    private final String query;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BertQUAction copy$default(BertQUAction r100, String r101, String r102, Map r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.actionName;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.query;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.inputParams;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.isStandardQuery;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.actionName;
    }

    public final String component2() {
        return this.query;
    }

    public final Map<String, ParamItem> component3() {
        return this.inputParams;
    }

    public final boolean component4() {
        return this.isStandardQuery;
    }

    public final BertQUAction copy(String r100, String r101, Map<String, ParamItem> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "query");
        return new BertQUAction(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BertQUAction) == true) goto L8;
        return false;
    L8:
        BertQUAction r101 = (BertQUAction) r100;
        if (Intrinsics.areEqual(this.actionName, r101.actionName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.query, r101.query) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.inputParams, r101.inputParams) == true) goto L18;
        return false;
    L18:
        if (this.isStandardQuery == r101.isStandardQuery) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.actionName.hashCode() * 31) + this.query.hashCode()) * 31;
        Map<String, ParamItem> r101 = this.inputParams;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.isStandardQuery == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "BertQUAction(actionName=" + this.actionName + ", query=" + this.query + ", inputParams=" + this.inputParams + ", isStandardQuery=" + this.isStandardQuery + ')';
    }

    public final String getActionName() {
        return this.actionName;
    }

    public final Map<String, ParamItem> getInputParams() {
        return this.inputParams;
    }

    public final String getQuery() {
        return this.query;
    }

    public final boolean isStandardQuery() {
        return this.isStandardQuery;
    }

    public final void setStandardQuery(boolean r100) {
        this.isStandardQuery = r100;
    }

    public BertQUAction(String r100, String r101, Map<String, ParamItem> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "query");
        this.actionName = r100;
        this.query = r101;
        this.inputParams = r102;
        this.isStandardQuery = r103;
    }
}
