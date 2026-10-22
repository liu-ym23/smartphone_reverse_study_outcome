package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends me.drakeet.multitype.b<a, KtvRoomSelectedMusicViewHolder> {
    public final wb0.a b;

    public static final class a {
        public final MusicPanel a;
        public final com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.a b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            MusicPanel r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.a r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "KtvRoomPendingMusicData(musicPanel=" + this.a + ", extraMusicData=" + this.b + ")";
        }

        public a(MusicPanel r2, com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.a r3) {
            Intrinsics.checkNotNullParameter(r2, "musicPanel");
            Intrinsics.checkNotNullParameter(r3, "extraMusicData");
            this.a = r2;
            this.b = r3;
        }
    }

    public b(wb0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.b = r2;
    }

    public final void e(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter((KtvRoomSelectedMusicViewHolder) r2, "holder");
    }

    public final void b(RecyclerView.ViewHolder r4, Object r5) {
        KtvRoomSelectedMusicViewHolder r6 = (KtvRoomSelectedMusicViewHolder) r4;
        a r7 = (a) r5;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "item");
        r6.T3(r7.a, true, r6.getAdapterPosition(), this.b);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new KtvRoomSelectedMusicViewHolder(r4.inflate(2131566530, r5, false));
    }
}
