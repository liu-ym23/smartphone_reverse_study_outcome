package com.bytedance.android.livesdk.linkvideo.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/linkvideo/view/AnchorLinkVideoListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorLinkVideoListViewHolder extends RecyclerView.ViewHolder {
    public final HSImageView a;
    public final ImageView b;
    public final View c;
    public final TextView d;
    public final boolean e;
    public final h f;

    public AnchorLinkVideoListViewHolder(View r2, boolean r3, h r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.e = r3;
        this.f = r4;
        this.a = r2.findViewById(2131375721);
        this.b = (ImageView) r2.findViewById(2131375839);
        this.c = r2.findViewById(2131392159);
        this.d = (TextView) r2.findViewById(2131375796);
    }

    public static final void T3(AnchorLinkVideoListViewHolder r2, gf2.a r3, gf2.a r4) {
        r2.getClass();
        if (r3 == null) goto L5;
        Long r5 = r3.b();
    L7:
        if (Intrinsics.areEqual(r5, r4.b()) == false) goto L11;
        h r6 = r2.f;
        if (r6 == null) goto L15;
        r6.Ao(null, false);
        return;
    L15:
        return;
    L11:
        h r7 = r2.f;
        if (r7 == null) goto L17;
        r7.Ao(r4, true);
        return;
    L17:
        return;
    L5:
        r5 = null;
        goto L7
    }
}
