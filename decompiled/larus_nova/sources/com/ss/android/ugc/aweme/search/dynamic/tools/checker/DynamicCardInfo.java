package com.ss.android.ugc.aweme.search.dynamic.tools.checker;

import com.ss.android.ugc.aweme.search.dynamic.core.data.RenderEngineOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/tools/checker/DynamicCardInfo;", "", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class DynamicCardInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f452746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f452747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RenderEngineOption f452748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f452749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f452750e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DynamicCardInfo) == true) goto L8;
        return false;
    L8:
        DynamicCardInfo r101 = (DynamicCardInfo) r100;
        if (this.f452746a == r101.f452746a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f452747b, r101.f452747b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f452748c, r101.f452748c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f452749d, r101.f452749d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f452750e, r101.f452750e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f452746a * 31) + this.f452747b.hashCode()) * 31) + this.f452748c.hashCode()) * 31;
        String r101 = this.f452749d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f452750e.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CardInfo(position=" + this.f452746a + ", scene='" + this.f452747b + "', threadName='" + this.f452750e + "', renderOption=" + this.f452748c + ", schema=" + this.f452749d + ')';
    }

    public DynamicCardInfo(int r100, String r101, RenderEngineOption r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "renderOption");
        Intrinsics.checkNotNullParameter(r104, "threadName");
        this.f452746a = r100;
        this.f452747b = r101;
        this.f452748c = r102;
        this.f452749d = r103;
        this.f452750e = r104;
    }
}
