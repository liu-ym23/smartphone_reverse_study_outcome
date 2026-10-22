package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.SongListItemViewHolder;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e {
    public final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b a;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final String b() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final boolean c() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final boolean f() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final void i(Context r2, MusicPanel r3, SongListItemViewHolder r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "musicPanel");
        Intrinsics.checkNotNullParameter(r4, "viewHolder");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final boolean e() {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.b;
        if (r0 == null) goto L9;
        MutableLiveData<vb0.a> r1 = r0.getOrderSongUiState();
        if (r1 == null) goto L9;
        vb0.a r2 = (vb0.a) r1.getValue();
        if (r2 == null) goto L9;
        Boolean r3 = r2.i;
    L11:
        return Intrinsics.areEqual(r3, Boolean.TRUE);
    L9:
        r3 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final int a() {
        return s1.h(2131108256);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final String g() {
        return s1.B(2131918644);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final boolean d(MusicPanel r3) {
        bb0.a r0 = bb0.b.a;
        if (r3 == null) goto L7;
        KtvMusic r4 = r3.a;
        if (r4 == null) goto L7;
        long r1 = r4.getMId();
    L8:
        bb0.a r5 = bb0.b.a;
        if (r5 == null) goto L11;
        boolean r6 = r5.i(r1);
    L13:
        return !r6;
    L11:
        r6 = false;
    L7:
        r1 = 0;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final void jumpToChorusRoom(MusicPanel r2) {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.b;
        if (r0 == null) goto L6;
        r0.jumpToChorusRoom(r2);
        return;
    }

    public j(com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r1, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final void addFavorite(MusicPanel r2, ic0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "music");
        Intrinsics.checkNotNullParameter(r3, "favoriteCallback");
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.addFavorite(r2, r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final void delFavorite(MusicPanel r2, ic0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "music");
        Intrinsics.checkNotNullParameter(r3, "favoriteCallback");
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.delFavorite(r2, r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e
    public final void h(Context r2, MusicPanel r3, RecyclerView.ViewHolder r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "musicPanel");
        Intrinsics.checkNotNullParameter(r4, "viewHolder");
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.b;
        if (r0 == null) goto L6;
        r0.applyWantListen(r2, r3, r4);
        return;
    }
}
