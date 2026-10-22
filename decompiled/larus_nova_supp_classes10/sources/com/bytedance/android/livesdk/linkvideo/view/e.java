package com.bytedance.android.livesdk.linkvideo.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e extends me.drakeet.multitype.b<f, AnchorLinkVideoLoadingMoreViewHolder> {
    public e() {
    }

    public final void e(RecyclerView.ViewHolder r3) {
        AnchorLinkVideoLoadingMoreViewHolder r4 = (AnchorLinkVideoLoadingMoreViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        if (r4.c != 1) goto L8;
        LiveDoubleColorBallAnimationView r5 = r4.a;
        if (r5 == null) goto L9;
        r5.b();
        return;
    L9:
        return;
    }

    public final void f(RecyclerView.ViewHolder r3) {
        AnchorLinkVideoLoadingMoreViewHolder r4 = (AnchorLinkVideoLoadingMoreViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        if (r4.c != 1) goto L8;
        LiveDoubleColorBallAnimationView r5 = r4.a;
        if (r5 == null) goto L9;
        r5.c();
        return;
    L9:
        return;
    }

    public final void b(RecyclerView.ViewHolder r4, Object r5) {
        AnchorLinkVideoLoadingMoreViewHolder r6 = (AnchorLinkVideoLoadingMoreViewHolder) r4;
        f r7 = (f) r5;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "item");
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "data");
        int r8 = r7.a;
        r6.c = r8;
        if (r8 != 1) goto L10;
        LiveDoubleColorBallAnimationView r9 = r6.a;
        if (r9 == null) goto L7;
        r9.setVisibility(0);
    L7:
        TextView r10 = r6.b;
        if (r10 == null) goto L17;
        r10.setVisibility(8);
        return;
    L17:
        return;
    L10:
        LiveDoubleColorBallAnimationView r11 = r6.a;
        if (r11 == null) goto L13;
        r11.setVisibility(8);
    L13:
        TextView r12 = r6.b;
        if (r12 == null) goto L19;
        r12.setVisibility(0);
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new AnchorLinkVideoLoadingMoreViewHolder(r4.inflate(2131566694, r5, false));
    }
}
