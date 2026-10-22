package com.larus.profile.impl.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f extends ay7.a<fs9.m, ProfileBlockUserViewHolder> {
    public f() {
    }

    @Override // com.ixigua.lib.list.c
    public final boolean accept(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return r100 instanceof fs9.m;
    }

    @Override // com.ixigua.lib.list.a
    public final RecyclerView.ViewHolder a(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        View r102 = r100.inflate(R.layout.larus_item_profile_block_user, r101, false);
        if (r102 == null) goto L7;
        return new ProfileBlockUserViewHolder((LinearLayout) r102);
    L7:
        throw new NullPointerException("rootView");
    }
}
