package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.RealTimeChorusUIInfo;
import com.bytedance.android.livesdkapi.depend.message.RealTimeChorusUIInfoKt;
import com.bytedance.android.livesdkapi.depend.message.UserChorusInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ RTChorusLogView a;
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.o b;
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.widget.j1 c;

    public e(RTChorusLogView r1, com.bytedance.android.livesdk.chatroom.o r2, y r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r12) {
        ClientUIInfo r13 = ((IRoomLinkMicSyncData) ((dc2.c.b) r12).b).getClientUIInfo();
        String r0 = null;
        if (r13 == null) goto L5;
        RealTimeChorusUIInfo r14 = r13.getRealTimeChorusInfo();
    L6:
        if (r14 == null) goto L61;
        com.bytedance.live.datacontext.j r1 = this.b.A2();
        if (r1 == null) goto L14;
        DataCenter r2 = (DataCenter) r1.getValue();
        if (r2 == null) goto L14;
        Iterable r3 = (List) r2.get("data_online_changed_list", new ArrayList());
        if (r3 == null) goto L14;
    L15:
        Map r15 = RealTimeChorusUIInfoKt.getUserInfoString(r14);
        if (r15 == null) goto L58;
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r15, "chorusInfoList");
        Intrinsics.checkNotNullParameter(r3, "userInfoList");
        ArrayList r4 = new ArrayList();
        Iterator r16 = r15.values().iterator();
    L19:
        if (r16.hasNext() == false) goto L33;
        UserChorusInfo r5 = (UserChorusInfo) r16.next();
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r3.iterator();
    L22:
        if (r7.hasNext() == false) goto L30;
        T r8 = r7.next();
        IBaseUser r9 = ((ILinkPlayerInfoBridge) r8).getUser();
        if (r9 == null) goto L26;
        String r10 = r9.getUserId();
    L28:
        if (Intrinsics.areEqual(r10, String.valueOf(r5.getUserId())) == false) goto L22;
        r6.add(r8);
        goto L22
    L26:
        r10 = null;
        goto L28
    L30:
        ILinkPlayerInfoBridge r11 = (ILinkPlayerInfoBridge) KtvUtilsKt.K(r6, 0);
        if (r11 == null) goto L19;
        b r17 = new b();
        r17.b = r11.getUser();
        r17.a = r5;
        r4.add(r17);
        goto L19
    L33:
        RTChorusLogView r18 = this.a;
        com.bytedance.android.livesdk.chatroom.widget.j1 r19 = this.c;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r4, "chorusInfoList");
        Intrinsics.checkNotNullParameter(r19, "outerScopeProvider");
        w.a("RealTimeChorusSingerInfoView", "updateChorusSingerInfo " + r4.size());
        ChorusUserAdapter r20 = r18.b;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r4, "content");
        r20.a = r4;
        r18.b.notifyDataSetChanged();
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L59;
        cg6.a r21 = r19.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r21 == null) goto L38;
        hg6.g r22 = r21.getRtcManager();
    L39:
        TextView r110 = r18.d;
        if (r110 == null) goto L60;
        StringBuilder r23 = new StringBuilder("mixType: ");
        if (r22 == null) goto L46;
        MixStreamType r24 = r22.getMixStreamType();
        if (r24 == null) goto L46;
        r0 = r24.name();
    L46:
        r23.append(r0);
        r110.setText(r23.toString());
        return;
    L60:
        return;
    L38:
        r22 = null;
        goto L39
    L59:
        return;
    L58:
        return;
    L14:
        r3 = new ArrayList();
        goto L15
    L61:
        return;
    L5:
        r14 = null;
        goto L6
    }
}
