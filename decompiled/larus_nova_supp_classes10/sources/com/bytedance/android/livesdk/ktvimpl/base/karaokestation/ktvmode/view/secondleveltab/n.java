package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n extends me.drakeet.multitype.b<MusicPanel, SungSongItemViewHolder> {
    public final e b;

    public n(j r2) {
        Intrinsics.checkNotNullParameter(r2, "songListViewCallback");
        this.b = r2;
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        SungSongItemViewHolder r4 = (SungSongItemViewHolder) r2;
        MusicPanel r5 = (MusicPanel) r3;
        Intrinsics.checkNotNullParameter(r4, "viewHolder");
        Intrinsics.checkNotNullParameter(r5, "data");
        f.a.a(r4, r5);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        Intrinsics.checkNotNullParameter(r6, "parent");
        return new SungSongItemViewHolder(this.b, r5.inflate(2131566509, r6, false));
    }
}
