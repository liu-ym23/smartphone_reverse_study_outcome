package com.bytedance.locallife.poi.media.list;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.locallife.poi.media.layer.b;
import com.google.gson.JsonObject;
import hy6.a;
import hy6.d;
import iy6.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/poi/media/list/AbsInnerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public abstract class AbsInnerViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f262678a;

    public abstract void T3(int r100, c r101, int r102, String r103, JsonObject r104, JsonObject r105);

    public abstract void U3();

    public abstract void onCreate();

    public AbsInnerViewHolder(View r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        if (r101 == null) goto L5;
        b r102 = r101.d();
    L6:
        this.f262678a = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }
}
