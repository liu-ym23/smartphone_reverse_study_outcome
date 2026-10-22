package com.larus.profile.impl.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.larus.profile.impl.databinding.LarusItemProfileBotListEmptyBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class g extends ay7.a<fs9.q, ProfileBotListEmptyViewHolder> {
    public g() {
    }

    @Override // com.ixigua.lib.list.c
    public final boolean accept(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return r100 instanceof fs9.q;
    }

    @Override // com.ixigua.lib.list.a
    public final RecyclerView.ViewHolder a(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new ProfileBotListEmptyViewHolder(LarusItemProfileBotListEmptyBinding.a(r100.inflate(R.layout.larus_item_profile_bot_list_empty, r101, false)).f366471a);
    }
}
