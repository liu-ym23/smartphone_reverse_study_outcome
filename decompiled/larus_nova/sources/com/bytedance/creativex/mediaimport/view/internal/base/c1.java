package com.bytedance.creativex.mediaimport.view.internal.base;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.views.DebounceOnClickListener;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes15.dex */
public final class c1 extends DebounceOnClickListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f203826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BaseSelectorViewHolder f203827e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Function3 f203828f;

    @Override // com.ss.android.ugc.aweme.views.DebounceOnClickListener
    public final void a() {
        int r100 = this.f203826d.getAdapterPosition();
        if (r100 != (-1)) goto L5;
        return;
    L5:
        DATA r101 = this.f203827e.f203809a;
        if (r101 == 0) goto L9;
        this.f203828f.invoke(r101, Integer.valueOf(r100), this.f203827e.f203810b);
        return;
    }

    public c1(RecyclerView.ViewHolder r100, BaseSelectorViewHolder r101, k r102) {
        this.f203826d = r100;
        this.f203827e = r101;
        this.f203828f = r102;
        super(400);
    }
}
