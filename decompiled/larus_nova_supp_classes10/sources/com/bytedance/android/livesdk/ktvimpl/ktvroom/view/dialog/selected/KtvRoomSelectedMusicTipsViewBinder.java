package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvRoomSelectedMusicTipsViewBinder extends me.drakeet.multitype.b<a, KtvRoomSelectedMusicTipsViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/dialog/selected/KtvRoomSelectedMusicTipsViewBinder$KtvRoomSelectedMusicTipsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class KtvRoomSelectedMusicTipsViewHolder extends RecyclerView.ViewHolder {
        public final Lazy a;

        public KtvRoomSelectedMusicTipsViewHolder(final View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = LazyKt.lazy(new KtvRoomSelectedMusicTipsViewBinder$KtvRoomSelectedMusicTipsViewHolder$selectedSongListTips$2(r2));
        }
    }

    public static final class a {
        public final int a;
        public final boolean b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public final int hashCode() {
            int r0 = this.a * 31;
            boolean r1 = this.b;
            ?? r2 = r1;
            if (r1 == false) goto L6;
            r2 = 1;
        L6:
            return r0 + r2;
        }

        public final String toString() {
            return "KtvRoomSelectedMusicTipsData(count=" + this.a + ", isBottomThresholdTips=" + this.b + ")";
        }

        public a(int r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public KtvRoomSelectedMusicTipsViewBinder() {
    }

    public final void b(RecyclerView.ViewHolder r5, Object r6) {
        KtvRoomSelectedMusicTipsViewHolder r7 = (KtvRoomSelectedMusicTipsViewHolder) r5;
        a r8 = (a) r6;
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "item");
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "data");
        if (r8.b == false) goto L5;
        ((TextView) r7.a.getValue()).setText(s1.C(2131918549, new Object[]{Integer.valueOf(r8.a)}));
        return;
    L5:
        Boolean r0 = o3.f().isAnchor();
        if (r0 == null) goto L8;
        boolean r1 = r0.booleanValue();
    L10:
        if (KtvUtilsKt.j() == true) goto L18;
        if (r1 == true) goto L18;
        int r9 = r8.a;
        if (r9 != 0) goto L16;
        String r10 = s1.B(2131918545);
    L17:
        ((TextView) r7.a.getValue()).setText(r10);
        return;
    L16:
        r10 = s1.C(2131918547, new Object[]{Integer.valueOf(r9)});
    L18:
        ((TextView) r7.a.getValue()).setText(s1.C(2131918546, new Object[]{Integer.valueOf(r8.a)}));
        return;
    L8:
        r1 = false;
        goto L10
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new KtvRoomSelectedMusicTipsViewHolder(r4.inflate(2131566527, r5, false));
    }
}
