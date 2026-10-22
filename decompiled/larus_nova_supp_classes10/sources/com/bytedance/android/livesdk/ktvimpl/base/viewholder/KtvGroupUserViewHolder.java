package com.bytedance.android.livesdk.ktvimpl.base.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.ktv.common.model.api.m0;
import com.bytedance.android.live.ktv.common.model.api.r;
import com.bytedance.android.live.ktv.common.view.LiveOnlineAvatarView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/viewholder/KtvGroupUserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvGroupUserViewHolder extends RecyclerView.ViewHolder {
    public final LiveOnlineAvatarView a;
    public final TextView b;
    public final TextView c;

    public KtvGroupUserViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = r2.findViewById(2131376959);
        this.b = (TextView) r2.findViewById(2131376961);
        this.c = (TextView) r2.findViewById(2131376960);
    }

    public final void T3(r r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        String r0 = r4.b();
        if (r0 == null) goto L5;
        this.b.setText(r0);
    L5:
        String r1 = r4.d();
        if (r1 == null) goto L8;
        this.c.setText(r1);
    L8:
        k r2 = r4.a();
        if (r2 == null) goto L11;
        LiveOnlineAvatarView r3 = this.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r2, "model");
        ImageUtil.loadRoundImage(r3.a, r2);
    L11:
        m0 r5 = r4.c();
        if (r5 == null) goto L20;
        List r6 = r5.a();
        if (r6 != null) goto L16;
        return;
    L16:
        if (r6.size() != 0) goto L18;
        return;
    L18:
        final String r7 = (String) ListProtector.get(r6, 0);
        this.a.setRoomId(r7);
        this.a.setOnClickAvatarCb(new KtvGroupUserViewHolder$onBind$4$1(r7));
        return;
    }
}
