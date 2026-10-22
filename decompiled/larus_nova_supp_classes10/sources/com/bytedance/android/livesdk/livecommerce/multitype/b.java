package com.bytedance.android.livesdk.livecommerce.multitype;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bytedance.android.livesdk.livecommerce.broadcast.viewbinder.LiveRoomNewCouponViewBinder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class b<T, VH extends RecyclerView.ViewHolder> {
    public b() {
    }

    public abstract void a(RecyclerView.ViewHolder r1, Object r2);

    public abstract LiveRoomNewCouponViewBinder.ItemViewHolder b(LayoutInflater r1, ViewGroup r2);
}
