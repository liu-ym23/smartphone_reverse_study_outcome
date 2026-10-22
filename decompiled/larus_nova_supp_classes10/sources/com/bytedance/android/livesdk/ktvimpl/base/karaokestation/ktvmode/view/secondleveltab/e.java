package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.message.model.MusicPanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface e {
    int a();

    void addFavorite(MusicPanel r1, ic0.a r2);

    String b();

    boolean c();

    boolean d(MusicPanel r1);

    void delFavorite(MusicPanel r1, ic0.a r2);

    boolean e();

    boolean f();

    String g();

    void h(Context r1, MusicPanel r2, RecyclerView.ViewHolder r3);

    void i(Context r1, MusicPanel r2, SongListItemViewHolder r3);

    void jumpToChorusRoom(MusicPanel r1);
}
