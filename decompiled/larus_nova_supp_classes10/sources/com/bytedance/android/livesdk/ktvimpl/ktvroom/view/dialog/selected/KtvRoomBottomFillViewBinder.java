package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvRoomBottomFillViewBinder extends me.drakeet.multitype.b<Object, KtvRoomBottomFillViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/dialog/selected/KtvRoomBottomFillViewBinder$KtvRoomBottomFillViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class KtvRoomBottomFillViewHolder extends RecyclerView.ViewHolder {
        public KtvRoomBottomFillViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public KtvRoomBottomFillViewBinder() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        Intrinsics.checkNotNullParameter((KtvRoomBottomFillViewHolder) r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "item");
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new KtvRoomBottomFillViewHolder(r4.inflate(2131566528, r5, false));
    }
}
