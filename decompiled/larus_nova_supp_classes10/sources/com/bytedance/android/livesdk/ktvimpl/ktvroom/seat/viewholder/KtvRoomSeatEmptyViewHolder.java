package com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.viewholder;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.adapter.KtvRoomSeatListAdapter;
import hg0.b;
import jg0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/seat/viewholder/KtvRoomSeatEmptyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lhg0/b;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkNormalEmptyViewBinder$a;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomSeatEmptyViewHolder extends RecyclerView.ViewHolder implements b<MultiLinkNormalEmptyViewBinder.a> {
    public final g<MultiLinkNormalEmptyViewBinder.a> a;

    public static final class a {
    }

    static {
    }

    public final g<MultiLinkNormalEmptyViewBinder.a> l() {
        return this.a;
    }

    public KtvRoomSeatEmptyViewHolder(g<MultiLinkNormalEmptyViewBinder.a> r5) {
        Intrinsics.checkNotNullParameter(r5, "layer");
        super(r5.l());
        this.a = r5;
        ViewGroup r0 = r5.b;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
    L6:
        if (r1 == null) goto L17;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        int r3 = KtvRoomSeatListAdapter.f;
        int r4 = s1.y();
        int r6 = KtvRoomSeatListAdapter.f;
        if (((r4 - r6) - (KtvRoomSeatListAdapter.i * 5)) <= KtvRoomSeatListAdapter.g) goto L10;
        boolean r7 = true;
    L11:
        if (r7 == false) goto L13;
        r2.width = ((s1.y() - r6) - KtvRoomSeatListAdapter.h) / 5;
    L14:
        r5.j(r5.c.getContext());
        return;
    L13:
        int r8 = s1.f(52.0f);
        r2.width = r8;
        r2.height = r8;
        goto L14
    L10:
        r7 = false;
        goto L11
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L5:
        r1 = null;
        goto L6
    }
}
