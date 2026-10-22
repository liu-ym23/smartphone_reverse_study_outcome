package com.larus.chat.job.impl.page;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.chat.job.impl.component.ChatJobLynxItemComponent;
import com.larus.platform.api.e4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f0 extends RecyclerView.RecycledViewPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f325367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f325368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f325369c;

    public f0(e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reuseController");
        this.f325367a = r100;
        this.f325368b = 2;
        this.f325369c = 5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public final void putRecycledView(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "scrap");
        int r101 = r100.getItemViewType();
        int r102 = this.f325368b;
        if (r101 == r102) goto L5;
    L19:
        super.putRecycledView(r100);
        return;
    L5:
        if (getRecycledViewCount(r102) < this.f325369c) goto L19;
        e0 r103 = this.f325367a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof JobViewHolder) == false) goto L9;
        JobViewHolder r104 = (JobViewHolder) r100;
    L10:
        if (r104 == null) goto L21;
        r104.unbind();
        ChatJobLynxItemComponent r105 = r104.f325140b;
        if (r105 == null) goto L17;
        e4 r106 = r105.f324957m;
        if (r106 == null) goto L16;
        r106.destroy();
    L16:
        r105.f324957m = null;
        r105.f324958n = null;
        r105.f324959o = null;
        r105.f324961q = null;
        r105.f324956l.removeAllViews();
    L17:
        r104.f325140b = null;
        r103.f325149a.remove(r104);
        return;
    L21:
        return;
    L9:
        r104 = null;
        goto L10
    }
}
