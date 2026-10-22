package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import androidx.collection.SieveCacheKt;
import com.larus.im.internal.jni.bean.OmniProject;
import com.larus.platform.model.SlashMentionConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class u0 implements com.larus.home.impl.main.side_bar.data.i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OmniProject f345394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.larus.home.impl.main.side_bar.data.j0> f345395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f345396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f345397d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u0) == true) goto L8;
        return false;
    L8:
        u0 r101 = (u0) r100;
        if (Intrinsics.areEqual(this.f345394a, r101.f345394a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f345395b, r101.f345395b) == true) goto L15;
        return false;
    L15:
        if (this.f345396c == r101.f345396c) goto L18;
        return false;
    L18:
        if (this.f345397d == r101.f345397d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f345394a.hashCode() * 31) + this.f345395b.hashCode()) * 31;
        int r101 = 1231;
        if (this.f345396c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f345397d == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "SideBarProjectItemUiModel(project=" + this.f345394a + ", conversations=" + this.f345395b + ", isExpanded=" + this.f345396c + ", hasMoreConversations=" + this.f345397d + ')';
    }

    @Override // com.larus.home.impl.main.side_bar.data.i0
    public final int a() {
        Iterator<T> r100 = this.f345395b.iterator();
        long r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L7;
        r101 = r101 + ((long) RangesKt.coerceAtLeast(((com.larus.home.impl.main.side_bar.data.j0) r100.next()).a(), 0));
        goto L4
    L7:
        return (int) RangesKt.coerceAtMost(r101, SieveCacheKt.NodeLinkMask);
    }

    public final String b() {
        String r100 = this.f345394a.projectId;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public u0(OmniProject r100, List<com.larus.home.impl.main.side_bar.data.j0> r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, SlashMentionConfig.SLASH_CONTENT_PROJECT);
        Intrinsics.checkNotNullParameter(r101, "conversations");
        this.f345394a = r100;
        this.f345395b = r101;
        this.f345396c = r102;
        this.f345397d = r103;
    }
}
