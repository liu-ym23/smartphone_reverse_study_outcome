package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.model.api.z0;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.selected.view.MultiUserAvatarView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvcomponent/view/secondleveltab/WantSingItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class WantSingItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public final TextView a;
    public final HSImageView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final MultiUserAvatarView f;
    public final TextView g;
    public z0 h;
    public final View i;
    public final e j;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (r2 == null) goto L4;
        Integer r3 = Integer.valueOf(r2.getId());
    L5:
        if (r3 != null) goto L8;
        return;
    L8:
        if (r3.intValue() != 2131384274) goto L13;
        e r4 = this.j;
        if (r4 == null) goto L14;
        r4.a(this.h);
        return;
    L14:
        return;
    L13:
        return;
    L4:
        r3 = null;
        goto L5
    }

    public WantSingItemViewHolder(View r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.i = r2;
        this.j = r3;
        this.a = (TextView) r2.findViewById(2131385940);
        this.b = r2.findViewById(2131380486);
        this.c = (TextView) r2.findViewById(2131380500);
        this.d = (TextView) r2.findViewById(2131380490);
        this.e = (TextView) r2.findViewById(2131380482);
        TextView r4 = (TextView) r2.findViewById(2131384274);
        this.f = (MultiUserAvatarView) r2.findViewById(2131380429);
        this.g = (TextView) r2.findViewById(2131380463);
        if (r4 == null) goto L6;
        r4.setOnClickListener(this);
        return;
    }
}
