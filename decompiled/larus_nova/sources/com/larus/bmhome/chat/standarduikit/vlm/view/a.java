package com.larus.bmhome.chat.standarduikit.vlm.view;

import com.larus.bmhome.chat.markdown.vlm.FlowVLMContainerViewType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f309899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowVLMContainerViewType f309900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<l> f309901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final do8.j f309902d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f309899a, r101.f309899a) == true) goto L12;
        return false;
    L12:
        if (this.f309900b == r101.f309900b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f309901c, r101.f309901c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f309902d, r101.f309902d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f309899a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((r101 * 31) + this.f309900b.hashCode()) * 31) + this.f309901c.hashCode()) * 31) + this.f309902d.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "FlowVLMContainerViewInput(enableShimmer=" + this.f309899a + ", flowVLMContainerViewType=" + this.f309900b + ", mediaList=" + this.f309901c + ", uiConfig=" + this.f309902d + ')';
    }

    public a(Boolean r100, FlowVLMContainerViewType r101, List<l> r102, do8.j r103) {
        Intrinsics.checkNotNullParameter(r101, "flowVLMContainerViewType");
        Intrinsics.checkNotNullParameter(r102, "mediaList");
        Intrinsics.checkNotNullParameter(r103, "uiConfig");
        this.f309899a = r100;
        this.f309900b = r101;
        this.f309901c = r102;
        this.f309902d = r103;
    }
}
