package com.ss.android.ugc.tools.view.widget.adapter;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/tools/view/widget/adapter/MvChooseCoverAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VideoCoverHolder", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class MvChooseCoverAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/tools/view/widget/adapter/MvChooseCoverAdapter$VideoCoverHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
    public static final class VideoCoverHolder extends RecyclerView.ViewHolder {
        public VideoCoverHolder(ImageView r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Bitmap r102 = (Bitmap) ListProtector.get(null, r101);
        View r103 = r100.itemView;
        if (r103 == null) goto L7;
        ImageView r104 = (ImageView) r103;
        r104.setImageBitmap(r102);
        r104.setFocusable(true);
        StringBuilder r105 = new StringBuilder();
        r105.append(r104.getContext().getString(R.string.tools_a11y_choose_cover_position_desc, new Object[]{Integer.valueOf(r101 + 1)}));
        r104.getContext();
        r100.getAdapterPosition();
        r105.append("");
        r104.setContentDescription(r105.toString());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.tools_mv_choose_frame_item, r100, false);
        if (r102 == null) goto L7;
        ImageView r103 = (ImageView) r102;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        r104.height = 0;
        r104.width = 0;
        r103.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r103.setLayoutParams(r104);
        return new VideoCoverHolder(r103);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    }
}
