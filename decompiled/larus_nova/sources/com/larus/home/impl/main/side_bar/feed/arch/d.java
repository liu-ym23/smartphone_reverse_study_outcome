package com.larus.home.impl.main.side_bar.feed.arch;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d implements eb9.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f344604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView.Adapter<? extends RecyclerView.ViewHolder> f344605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<fb9.a> f344606c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f344604a, r101.f344604a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f344605b, r101.f344605b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f344606c, r101.f344606c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f344604a.hashCode() * 31) + this.f344605b.hashCode()) * 31) + this.f344606c.hashCode();
    }

    @Override // eb9.s
    public final void release() {
    }

    public final String toString() {
        return "FeedSlot(id=" + this.f344604a + ", adapter=" + this.f344605b + ", abilities=" + this.f344606c + ')';
    }

    @Override // eb9.s
    public final List<fb9.a> getAbilities() {
        return this.f344606c;
    }

    @Override // eb9.s
    public final RecyclerView.Adapter<? extends RecyclerView.ViewHolder> getAdapter() {
        return this.f344605b;
    }

    @Override // eb9.s
    public final String getId() {
        return this.f344604a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(String r100, RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r101, List<? extends fb9.a> r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "adapter");
        Intrinsics.checkNotNullParameter(r102, "abilities");
        this.f344604a = r100;
        this.f344605b = r101;
        this.f344606c = r102;
    }
}
