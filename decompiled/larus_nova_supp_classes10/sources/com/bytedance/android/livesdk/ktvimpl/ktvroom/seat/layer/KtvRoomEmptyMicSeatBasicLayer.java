package com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.layer;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.adapter.KtvRoomSeatListAdapter;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.UIUtils;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvRoomEmptyMicSeatBasicLayer extends com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b {
    public final KtvRoomSeatListAdapter.SeatListType q;
    public final MultiLinkNormalEmptyViewBinder.b r;

    public final int o() {
        return 2131566308;
    }

    public final com.bytedance.android.live.liveinteract.a t() {
        return new re2.b(q());
    }

    public final void v() {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r0 = ((com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b) this).i;
        if (r0 == null) goto L6;
        r0.d(2131251087);
        return;
    }

    public final void onDetach() {
        super.onDetach();
        UIUtils.setViewVisibility(((com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b) this).k, 4);
    }

    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.a(r2);
        if (this.q != KtvRoomSeatListAdapter.SeatListType.OPUS_GUEST) goto L10;
        ViewGroup r3 = q();
        if (r3 == null) goto L11;
        View r4 = r3.findViewById(2131389618);
        if (r4 == null) goto L12;
        r4.setBackgroundResource(2131249328);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final /* bridge */ /* synthetic */ void d(Object r1, int r2) {
        w((MultiLinkNormalEmptyViewBinder.a) r1, r2);
    }

    public final void w(MultiLinkNormalEmptyViewBinder.a r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "itemData");
        super.w(r5, r6);
        if (n() != 0) goto L5;
        q().setOnClickListener(x0.a(new KtvRoomEmptyMicSeatBasicLayer$onBind$1(this)));
    L5:
        v();
        ViewGroup r7 = q();
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        r3.a(r7, String.format(s1.B(2131918409), Arrays.copyOf(new Object[]{Integer.valueOf(r6 + 1)}, 1)));
    }

    public KtvRoomEmptyMicSeatBasicLayer(MicSeatScene r2, KtvRoomSeatListAdapter.SeatListType r3, MultiLinkNormalEmptyViewBinder.b r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TYPE);
        Intrinsics.checkNotNullParameter(r4, "emptyItemListener");
        super(r2, null);
        this.q = r3;
        this.r = r4;
    }

    public final /* bridge */ /* synthetic */ void k(Object r1, int r2, Bundle r3) {
        x((MultiLinkNormalEmptyViewBinder.a) r1, r2, r3);
    }

    public final void x(MultiLinkNormalEmptyViewBinder.a r4, int r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "itemData");
        Intrinsics.checkNotNullParameter(r6, "payload");
        ((com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b) this).e = r4;
        Iterator<String> r7 = r6.keySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L28;
        String r0 = r7.next();
        if (r0 == null) goto L4;
        if (r0.hashCode() != 223389637) goto L4;
        if (r0.equals("payload_key_friend_online_update") == false) goto L4;
        ch0.b r1 = r4.a();
        if (r1 == null) goto L4;
        ImageView r2 = ((com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b) this).l;
        IBaseUser r3 = r1.a;
        if (r3 == null) goto L18;
        k r8 = r3.getAvatarThumbKt();
    L19:
        ImageUtil.loadRoundImage(r2, r8);
        ((com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b) this).f = r1;
        com.bytedance.android.live.liveinteract.a r9 = ((com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b) this).m;
        if (r9 == null) goto L22;
        r9.c();
    L22:
        int r10 = com.bytedance.android.live.liveinteract.chatroom.chatroom.util.b.a;
        IBaseUser r11 = r1.a;
        if (r11 == null) goto L26;
        String r12 = r11.getIdString();
        if (r12 == null) goto L26;
    L27:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.util.b.c(r12);
    L26:
        r12 = "";
        goto L27
    L18:
        r8 = null;
        goto L19
    L28:
        ViewGroup r13 = q();
        StringCompanionObject r14 = StringCompanionObject.INSTANCE;
        r3.a(r13, String.format(s1.B(2131918409), Arrays.copyOf(new Object[]{Integer.valueOf(r5 + 1)}, 1)));
    }
}
