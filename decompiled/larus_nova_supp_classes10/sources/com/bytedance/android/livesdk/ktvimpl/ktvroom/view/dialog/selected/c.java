package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends me.drakeet.multitype.b<d, KtvRoomSelectedMusicViewHolder> {
    public final wb0.a b;

    public c(wb0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.b = r2;
    }

    public final void e(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter((KtvRoomSelectedMusicViewHolder) r2, "holder");
    }

    public final void b(RecyclerView.ViewHolder r7, Object r8) {
        KtvRoomSelectedMusicViewHolder r9 = (KtvRoomSelectedMusicViewHolder) r7;
        d r10 = (d) r8;
        Intrinsics.checkNotNullParameter(r9, "holder");
        Intrinsics.checkNotNullParameter(r10, "item");
        MusicPanel r11 = r10.a;
        int r0 = r9.getAdapterPosition();
        List r1 = ((me.drakeet.multitype.b) this).a.a;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r0) goto L11;
        if (r3 >= r1.size()) goto L10;
        if ((ListProtector.get(r1, r3) instanceof d) == true) goto L11;
        r4 = r4 + 1;
    L10:
        r3 = r3 + 1;
    L11:
        r9.T3(r11, false, r0 - r4, this.b);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, final ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        final View r6 = r4.inflate(2131566530, r5, false);
        return new KtvRoomSelectedListViewBinder$onCreateViewHolder$1(r5, r6);
    }
}
