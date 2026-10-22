package com.bytedance.android.livesdk.livecommerce.multitype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import fh2.q;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class BaseMultiTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final ui2.a a;
    public final f b;
    public View c;
    public boolean d;
    public b e;
    public c f;

    public class a extends RecyclerView.ViewHolder {
        public a(View r1) {
            super(r1);
        }
    }

    public interface b {
    }

    public interface c {
    }

    public final int getItemCount() {
        return (((ui2.c) this.a).b() + 0) + (this.d ? 1 : 0);
    }

    public final long getItemId(int r3) {
        int r4 = r3 + 0;
        ((ui2.c) this.a).a(r4);
        int r5 = getItemViewType(r4);
        ((com.bytedance.android.livesdk.livecommerce.multitype.b) ListProtector.get(((d) this.b).b, r5)).getClass();
        return -1;
    }

    public final int getItemViewType(int r7) {
        if (this.d == true) goto L5;
    L8:
        Object r8 = ((ui2.c) this.a).a(r7 - 0);
        f r0 = this.b;
        Class<?> r3 = r8.getClass();
        d r1 = (d) r0;
        r1.getClass();
        int r4 = ((ArrayList) r1.a).indexOf(r3);
        if (r4 != (-1)) goto L19;
        r4 = 0;
    L13:
        if (r4 >= ((ArrayList) r1.a).size()) goto L18;
        if (((Class) ListProtector.get(r1.a, r4)).isAssignableFrom(r3) == true) goto L19;
        r4 = r4 + 1;
        goto L13
    L18:
        r4 = -1;
    L19:
        if (r4 == (-1)) goto L23;
        ((com.bytedance.android.livesdk.livecommerce.multitype.c) ListProtector.get(((d) this.b).c, r4)).index();
        return r4 + 0;
    L23:
        throw new BinderNotFoundException(r8.getClass());
    L5:
        if (r7 != (getItemCount() - 1)) goto L8;
        return -2;
    }

    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder r4) {
        if (r4.getItemViewType() != (-1)) goto L6;
        return false;
    L6:
        if (r4.getItemViewType() != (-2)) goto L8;
        return false;
    L8:
        y2(r4);
        return false;
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r3) {
        if (r3.getItemViewType() != (-1)) goto L6;
        return;
    L6:
        if (r3.getItemViewType() != (-2)) goto L8;
        return;
    L8:
        y2(r3);
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r3) {
        if (r3.getItemViewType() != (-1)) goto L6;
        return;
    L6:
        if (r3.getItemViewType() != (-2)) goto L8;
        return;
    L8:
        y2(r3);
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r3) {
        if (r3.getItemViewType() != (-1)) goto L6;
        return;
    L6:
        if (r3.getItemViewType() != (-2)) goto L8;
        return;
    L8:
        y2(r3);
    }

    public final void y2(RecyclerView.ViewHolder r2) {
        if (r2.getItemViewType() >= 0) goto L5;
        return;
    L5:
        f r0 = this.b;
        int r3 = r2.getItemViewType();
        com.bytedance.android.livesdk.livecommerce.multitype.b r4 = (com.bytedance.android.livesdk.livecommerce.multitype.b) ListProtector.get(((d) r0).b, r3);
    }

    public BaseMultiTypeAdapter(ui2.c r1, d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        throw new IllegalAccessError("You should not call this method. Call RecyclerView.Adapter#onBindViewHolder(holder, position, payloads) instead.");
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        if (r4 == (-2)) goto L5;
    L8:
        LayoutInflater r0 = LayoutInflater.from(r3.getContext());
        com.bytedance.android.livesdk.livecommerce.multitype.b r5 = (com.bytedance.android.livesdk.livecommerce.multitype.b) ListProtector.get(((d) this.b).b, r4);
        r5.getClass();
        return r5.b(r0, r3);
    L5:
        if (this.e == null) goto L8;
        return new a(((q) this.e).a.r);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4, List<Object> r5) {
        if (getItemViewType(r4) != (-1)) goto L6;
        return;
    L6:
        if (getItemViewType(r4) != (-2)) goto L18;
        c r6 = this.f;
        if (r6 == null) goto L16;
        com.bytedance.android.livesdk.livecommerce.broadcast.ui.b r7 = (com.bytedance.android.livesdk.livecommerce.broadcast.ui.b) r6;
        if (r7.a.getContext() == null) goto L16;
        LiveRoomCouponListFragment r8 = r7.a;
        int r0 = LiveRoomCouponListFragment.x;
        if (((LiveRoomCouponListViewModel) r8.g).hasMore() == false) goto L15;
        LiveRoomCouponListFragment r9 = r7.a;
        r9.r.setText(th.a.g(r9.getContext(), 2131896639));
        LiveRoomCouponListFragment r10 = r7.a;
        ((LiveRoomCouponListViewModel) r10.g).requestMore(r10.u, new com.bytedance.android.livesdk.livecommerce.broadcast.ui.a(r7));
        goto L16
    L15:
        LiveRoomCouponListFragment r11 = r7.a;
        r11.r.setText(th.a.g(r11.getContext(), 2131896731));
    L16:
        this.c = r3.itemView;
        return;
    L18:
        ui2.c r12 = (ui2.c) this.a;
        Object r13 = r12.a(r4 + 0);
        int r14 = r3.getItemViewType();
        com.bytedance.android.livesdk.livecommerce.multitype.b r15 = (com.bytedance.android.livesdk.livecommerce.multitype.b) ListProtector.get(((d) this.b).b, r14);
        ((ui2.c) this.a).b();
        r15.a(r3, r13);
    }
}
