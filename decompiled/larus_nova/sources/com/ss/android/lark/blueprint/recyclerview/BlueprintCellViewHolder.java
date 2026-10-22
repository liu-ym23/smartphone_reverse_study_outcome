package com.ss.android.lark.blueprint.recyclerview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.ss.android.lark.blueprint.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xza.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0006\u0010\u0014\u001a\u00020\rR\u0019\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/blueprint/recyclerview/BlueprintCellViewHolder;", "Data", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL, "Lcom/ss/android/lark/blueprint/ICell;", "<init>", "(Landroid/view/View;Lcom/ss/android/lark/blueprint/ICell;)V", "getCell", "()Lcom/ss/android/lark/blueprint/ICell;", "onBind", "", "data", "(Ljava/lang/Object;)V", "onPatch", "patchList", "", "(Ljava/lang/Object;Ljava/util/List;)V", "onRecycled", "blueprint_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlueprintCellViewHolder<Data> extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m<? super Data> f410658a;

    public BlueprintCellViewHolder(View r100, m<? super Data> r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        super(r100);
        this.f410658a = r101;
        if ((r101 instanceof a) == false) goto L5;
        a r102 = (a) r101;
    L6:
        if (r102 == null) goto L9;
        r102.h(this);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
