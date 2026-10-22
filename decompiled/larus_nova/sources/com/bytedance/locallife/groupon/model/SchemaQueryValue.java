package com.bytedance.locallife.groupon.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/locallife/groupon/model/SchemaQueryValue;", "", "queryKey", "", "queryValue", "(Ljava/lang/String;Ljava/lang/String;)V", "getQueryKey", "()Ljava/lang/String;", "getQueryValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SchemaQueryValue {

    @SerializedName("query_key")
    private final String queryKey;

    @SerializedName("query_value")
    private final String queryValue;

    /* JADX WARN: Multi-variable type inference failed */
    public SchemaQueryValue() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SchemaQueryValue copy$default(SchemaQueryValue r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.queryKey;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.queryValue;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.queryKey;
    }

    public final String component2() {
        return this.queryValue;
    }

    public final SchemaQueryValue copy(String r100, String r101) {
        return new SchemaQueryValue(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SchemaQueryValue) == true) goto L8;
        return false;
    L8:
        SchemaQueryValue r101 = (SchemaQueryValue) r100;
        if (Intrinsics.areEqual(this.queryKey, r101.queryKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.queryValue, r101.queryValue) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.queryKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.queryValue;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SchemaQueryValue(queryKey=" + this.queryKey + ", queryValue=" + this.queryValue + ')';
    }

    public final String getQueryKey() {
        return this.queryKey;
    }

    public final String getQueryValue() {
        return this.queryValue;
    }

    public SchemaQueryValue(String r100, String r101) {
        this.queryKey = r100;
        this.queryValue = r101;
    }

    public /* synthetic */ SchemaQueryValue(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
