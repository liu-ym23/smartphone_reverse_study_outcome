package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ SongListItemViewHolder a;

    public l(SongListItemViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        SongListItemViewHolder r5 = this.a;
        MusicPanel r0 = r5.a;
        if (r0 == null) goto L9;
        Intrinsics.checkNotNullParameter(r0, "music");
        Context r1 = ((RecyclerView.ViewHolder) r5).itemView.getContext();
        MusicPanel r2 = r5.a;
        if (r1 == null) goto L10;
        if (r2 == null) goto L11;
        r5.A.i(r1, r2, r5);
        return;
    L11:
        return;
    L10:
        return;
    }
}
