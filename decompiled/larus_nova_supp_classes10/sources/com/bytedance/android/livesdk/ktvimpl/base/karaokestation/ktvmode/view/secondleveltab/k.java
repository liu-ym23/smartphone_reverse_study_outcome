package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k extends me.drakeet.multitype.b<MusicPanel, SongListItemViewHolder> {
    public final e b;

    public k(j r2) {
        Intrinsics.checkNotNullParameter(r2, "songListViewCallback");
        this.b = r2;
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        SongListItemViewHolder r4 = (SongListItemViewHolder) r2;
        MusicPanel r5 = (MusicPanel) r3;
        Intrinsics.checkNotNullParameter(r4, "viewHolder");
        Intrinsics.checkNotNullParameter(r5, "data");
        f.a.a(r4, r5);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new SongListItemViewHolder(r4.inflate(2131566507, r5, false), this.b);
    }
}
