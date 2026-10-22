package com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.layer.KtvRoomEmptyMicSeatBasicLayer;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.layer.KtvRoomGuestMicSeatBasicLayer;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.viewholder.KtvRoomSeatEmptyViewHolder;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.viewholder.KtvRoomSeatGuestViewHolder;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import hd0.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jg0.f;
import kk0.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tf0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/seat/adapter/KtvRoomSeatListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkNormalEmptyViewBinder$b;", "Lhg0/a;", "a", "b", "SeatListType", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomSeatListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements MultiLinkNormalEmptyViewBinder.b, hg0.a {
    public static final int f = 0;
    public static final int g = 0;
    public static final int h = 0;
    public static final int i = 0;
    public final ArrayList<f<?>> a;
    public final RecyclerView b;
    public List<e> c;
    public final SeatListType d;
    public final SeatAnimEngineWrapper e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/seat/adapter/KtvRoomSeatListAdapter$SeatListType;", "", "KTV_HOST", "NORMAL_GUEST", "OPUS_GUEST", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum SeatListType extends Enum<SeatListType> {
        public static final SeatListType KTV_HOST = null;
        public static final SeatListType NORMAL_GUEST = null;
        public static final SeatListType OPUS_GUEST = null;
        public static final /* synthetic */ SeatListType[] a = null;

        static {
            SeatListType r1 = new SeatListType("KTV_HOST", 0);
            KTV_HOST = r1;
            SeatListType r2 = new SeatListType("NORMAL_GUEST", 1);
            NORMAL_GUEST = r2;
            SeatListType r3 = new SeatListType("OPUS_GUEST", 2);
            OPUS_GUEST = r3;
            a = new SeatListType[]{r1, r2, r3};
        }

        public static SeatListType valueOf(String r1) {
            return (SeatListType) r27.a.a(SeatListType.class, r1);
        }

        public static SeatListType[] values() {
            return (SeatListType[]) a.clone();
        }

        public SeatListType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public b() {
        }
    }

    static {
        f = s1.f(76.5f);
        g = s1.f(48.0f);
        h = s1.f(32.0f);
        i = s1.f(52.0f);
    }

    public final int getItemCount() {
        return this.c.size();
    }

    public final void E5(ch0.b r3) {
        Intrinsics.checkNotNullParameter(r3, "itemData");
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0 == null) goto L10;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r0 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r0 == null) goto L11;
        g r1 = r0.getLinkMicSeatCallback();
        if (r1 == null) goto L12;
        r1.Tf(r3.a, r3.b);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final int getItemViewType(int r2) {
        return !(ListProtector.get(this.c, r2) instanceof MultiLinkNormalEmptyViewBinder.a) ? 1 : 0;
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        if ((r2 instanceof KtvRoomSeatEmptyViewHolder) == false) goto L6;
        ((KtvRoomSeatEmptyViewHolder) r2).a.onDetach();
    L8:
        super.onViewDetachedFromWindow(r2);
        return;
    L6:
        if ((r2 instanceof KtvRoomSeatGuestViewHolder) == false) goto L8;
        ((KtvRoomSeatGuestViewHolder) r2).a.onDetach();
        goto L8
    }

    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g ph(int r3) {
        RecyclerView r0 = this.b;
        if (r0 == null) goto L5;
        RecyclerView.ViewHolder r4 = r0.findViewHolderForAdapterPosition(r3);
    L7:
        if ((r4 instanceof hg0.b) == true) goto L9;
        return null;
    L9:
        return ((hg0.b) r4).l().h();
    L5:
        r4 = null;
        goto L7
    }

    public final int z2(String r6) {
        Intrinsics.checkNotNullParameter(r6, "userId");
        Iterator<T> r0 = this.c.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L18;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        MultiLinkGuestViewBinder.a r4 = (e) r2;
        if ((r4 instanceof MultiLinkGuestViewBinder.a) == false) goto L17;
        IBaseUser r5 = r4.k.a.getUser();
        if (r5 == null) goto L13;
        String r7 = r5.getIdString();
    L15:
        if (Intrinsics.areEqual(r7, r6.toString()) == false) goto L17;
        return r1;
    L13:
        r7 = null;
    L17:
        r1 = r3;
        goto L4
    L18:
        return -1;
    }

    public final void K3(MultiLinkNormalEmptyViewBinder.a r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "itemData");
        if (Intrinsics.areEqual(o3.f().isAnchor(), Boolean.TRUE) == false) goto L12;
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0 == null) goto L30;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r0 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r0 == null) goto L31;
        g r1 = r0.getLinkMicSeatCallback();
        if (r1 == null) goto L32;
        r1.L8(r3.b(), r4);
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L12:
        if (c.f().h() == true) goto L21;
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0 == null) goto L34;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r2 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r2 == null) goto L35;
        g r5 = r2.getLinkMicSeatCallback();
        if (r5 == null) goto L36;
        r5.L8(r3.b(), r4);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L21:
        if (c.f().h() == true) goto L23;
        return;
    L23:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0 == null) goto L39;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r6 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r6 == null) goto L40;
        g r7 = r6.getLinkMicSeatCallback();
        if (r7 == null) goto L41;
        r7.um();
        return;
    L41:
        return;
    L40:
        return;
    }

    public final View Za(int r3, int r4) {
        RecyclerView r0 = this.b;
        if (r0 == null) goto L5;
        RecyclerView.ViewHolder r5 = r0.findViewHolderForAdapterPosition(r3);
    L7:
        if ((r5 instanceof hg0.b) == true) goto L9;
        return null;
    L9:
        return ((hg0.b) r5).l().m(r4);
    L5:
        r5 = null;
        goto L7
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        if ((r5 instanceof KtvRoomSeatEmptyViewHolder) == false) goto L15;
        if ((ListProtector.get(this.c, r6) instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L23;
        KtvRoomSeatEmptyViewHolder r0 = (KtvRoomSeatEmptyViewHolder) r5;
        Object r2 = ListProtector.get(this.c, r6);
        if (r2 == null) goto L13;
        MultiLinkNormalEmptyViewBinder.a r3 = (MultiLinkNormalEmptyViewBinder.a) r2;
        if (((e) r3).a != 0) goto L11;
        ((e) r3).a = r6;
    L11:
        Unit r4 = Unit.INSTANCE;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "itemData");
        r0.a.v(r3, ((e) r3).a);
        goto L23
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.EmptyItemData");
    L23:
        y2(r5.itemView, r6);
        return;
    L15:
        if ((r5 instanceof KtvRoomSeatGuestViewHolder) == false) goto L23;
        if ((ListProtector.get(this.c, r6) instanceof MultiLinkGuestViewBinder.a) == false) goto L23;
        KtvRoomSeatGuestViewHolder r1 = (KtvRoomSeatGuestViewHolder) r5;
        Object r7 = ListProtector.get(this.c, r6);
        if (r7 == null) goto L22;
        MultiLinkGuestViewBinder.a r8 = (MultiLinkGuestViewBinder.a) r7;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "itemData");
        r1.a.v(r8, ((e) r8).a);
        goto L23
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.GuestItemData");
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        if (r6 != 0) goto L5;
        int r7 = qe2.b.a;
        MicSeatScene r8 = MicSeatScene.KTV;
        SeatListType r2 = this.d;
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r8, "scene");
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        Intrinsics.checkNotNullParameter(this, "emptyItemListener");
        KtvRoomEmptyMicSeatBasicLayer r0 = new KtvRoomEmptyMicSeatBasicLayer(r8, r2, this);
        jg0.g r9 = new jg0.g(r5);
        r9.b(r0);
        r9.a(r5.getContext());
        return new KtvRoomSeatEmptyViewHolder(r9);
    L5:
        int r10 = qe2.b.a;
        MicSeatScene r11 = MicSeatScene.KTV;
        b r3 = new b();
        SeatAnimEngineWrapper r4 = this.e;
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r11, "scene");
        Intrinsics.checkNotNullParameter(r3, "guestItemListener");
        Intrinsics.checkNotNullParameter(this, "layerGetter");
        KtvRoomGuestMicSeatBasicLayer r1 = new KtvRoomGuestMicSeatBasicLayer(r11, r3);
        jg0.g r12 = new jg0.g(r5);
        r12.b(r1);
        r12.b(new com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.layer.b(this, r4, r11));
        r12.a(r5.getContext());
        Intrinsics.checkNotNullParameter(r12, "$this$recordAnimLayer");
        f<?> r13 = r12.n();
        if (r13 == null) goto L9;
        this.a.add(r13);
    L9:
        return new KtvRoomSeatGuestViewHolder(r12);
    }

    public final void y2(View r4, int r5) {
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (r0 == null) goto L17;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        r1.leftMargin = 0;
        r1.rightMargin = 0;
        if (r5 != 0) goto L12;
        SeatListType r6 = this.d;
        if (r6 != SeatListType.NORMAL_GUEST) goto L9;
    L10:
        r1.leftMargin = s1.f(8.0f);
        r4.setLayoutParams(r1);
    L14:
        r4.setLayoutParams(r1);
        return;
    L9:
        if (r6 != SeatListType.OPUS_GUEST) goto L14;
    L12:
        if (r5 != (this.c.size() - 1)) goto L14;
        r1.rightMargin = s1.f(8.0f);
        goto L14
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5, List<? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r6, "payloads");
        if (r6.isEmpty() == false) goto L5;
    L18:
        onBindViewHolder(r4, r5);
    L19:
        y2(r4.itemView, r5);
        return;
    L5:
        if ((r4 instanceof KtvRoomSeatEmptyViewHolder) == true) goto L18;
        if ((r4 instanceof KtvRoomSeatGuestViewHolder) == false) goto L19;
        Object r7 = ListProtector.get(r6, 0);
        if (r7 == null) goto L17;
        Bundle r8 = (Bundle) r7;
        KtvRoomSeatGuestViewHolder r0 = (KtvRoomSeatGuestViewHolder) r4;
        Object r1 = ListProtector.get(this.c, r5);
        if (r1 == null) goto L15;
        MultiLinkGuestViewBinder.a r2 = (MultiLinkGuestViewBinder.a) r1;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "itemData");
        Intrinsics.checkNotNullParameter(r8, "payload");
        r0.a.w(r2, ((e) r2).a, r8);
        goto L19
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.GuestItemData");
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Bundle");
    }

    public KtvRoomSeatListAdapter(RecyclerView r2, List<e> r3, SeatListType r4, SeatAnimEngineWrapper r5) {
        Intrinsics.checkNotNullParameter(r3, "guestList");
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TYPE);
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.a = new ArrayList();
    }
}
