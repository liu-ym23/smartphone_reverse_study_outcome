package com.ss.android.ugc.aweme.search.dynamic.core.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/data/SchemaRenderOption;", "", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class SchemaRenderOption {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f452715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f452716b;

    public SchemaRenderOption() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SchemaRenderOption) == true) goto L8;
        return false;
    L8:
        SchemaRenderOption r101 = (SchemaRenderOption) r100;
        if (Intrinsics.areEqual(this.f452715a, r101.f452715a) == true) goto L12;
        return false;
    L12:
        if (this.f452716b == r101.f452716b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f452715a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.f452716b == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SchemaRenderOption(customReloadMethod=" + this.f452715a + ", startJSAfterProcessRender=" + this.f452716b + ')';
    }

    public /* synthetic */ SchemaRenderOption(int r100) {
        this(null, false);
    }

    public SchemaRenderOption(Integer r100, boolean r101) {
        this.f452715a = r100;
        this.f452716b = r101;
    }
}
