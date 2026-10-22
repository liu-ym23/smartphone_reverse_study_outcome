package com.bytedance.pitaya.api.feature.store;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/PTYFeatureGroupQuery;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "groupName", "", "queries", "", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureQuery;", "(Ljava/lang/String;Ljava/util/List;)V", "getGroupName", "()Ljava/lang/String;", "getQueries", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PTYFeatureGroupQuery implements ReflectionCall {
    private final String groupName;
    private final List<PTYFeatureQuery> queries;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PTYFeatureGroupQuery copy$default(PTYFeatureGroupQuery r100, String r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.groupName;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.queries;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.groupName;
    }

    public final List<PTYFeatureQuery> component2() {
        return this.queries;
    }

    public final PTYFeatureGroupQuery copy(String r100, List<PTYFeatureQuery> r101) {
        Intrinsics.checkNotNullParameter(r100, "groupName");
        Intrinsics.checkNotNullParameter(r101, "queries");
        return new PTYFeatureGroupQuery(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PTYFeatureGroupQuery) == true) goto L8;
        return false;
    L8:
        PTYFeatureGroupQuery r101 = (PTYFeatureGroupQuery) r100;
        if (Intrinsics.areEqual(this.groupName, r101.groupName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.queries, r101.queries) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.groupName.hashCode() * 31) + this.queries.hashCode();
    }

    public String toString() {
        return "PTYFeatureGroupQuery(groupName=" + this.groupName + ", queries=" + this.queries + ')';
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final List<PTYFeatureQuery> getQueries() {
        return this.queries;
    }

    public PTYFeatureGroupQuery(String r100, List<PTYFeatureQuery> r101) {
        Intrinsics.checkNotNullParameter(r100, "groupName");
        Intrinsics.checkNotNullParameter(r101, "queries");
        this.groupName = r100;
        this.queries = r101;
    }
}
