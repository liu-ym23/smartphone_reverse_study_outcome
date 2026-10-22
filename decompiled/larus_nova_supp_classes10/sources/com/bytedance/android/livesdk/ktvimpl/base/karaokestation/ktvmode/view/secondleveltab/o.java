package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import android.view.View;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ SungSongItemViewHolder a;

    public o(SungSongItemViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        MusicPanel r4 = this.a.o;
        if (r4 == null) goto L11;
        KtvMusic r5 = r4.a;
        if (r5 == null) goto L11;
        if (r5.isFavorite() != true) goto L11;
        SungSongItemViewHolder r6 = this.a;
        MusicPanel r0 = r6.o;
        if (r0 == null) goto L15;
        r6.y.delFavorite(r0, r6.p);
        return;
    L15:
        return;
    L11:
        SungSongItemViewHolder r7 = this.a;
        MusicPanel r1 = r7.o;
        if (r1 == null) goto L17;
        r7.y.addFavorite(r1, r7.p);
        return;
    }
}
