package com.larus.profile.impl;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.profile.impl.databinding.LarusItemProfileBotBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b extends ay7.a<fs9.n, ProfileBotViewHolder> {
    public b() {
    }

    @Override // com.ixigua.lib.list.c
    public final boolean accept(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return r100 instanceof fs9.n;
    }

    @Override // com.ixigua.lib.list.a
    public final RecyclerView.ViewHolder a(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new ProfileBotViewHolder(LarusItemProfileBotBinding.a(r100, r101).f366470a);
    }
}
