package com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.animation.universalwidget.utils.ListDiffUtils;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.adapter.KtvRoomSeatListAdapter;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.diff.KtvRoomDiffCallback;
import com.bytedance.android.livesdk.message.model.nd;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import hg6.i;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ KtvRoomViewManager a;

    public d(a r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r6v37, types: [boolean] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void accept(Object r14) {
        List r15 = (List) r14;
        ALogger.i("ktv_seat_view_manager", "mDataDispatcher.userListObservable, size: " + r15.size());
        final KtvRoomViewManager r0 = this.a;
        r0.getClass();
        if (r15.isEmpty() == false) goto L6;
        return;
    L6:
        if (i.a() == false) goto L18;
        ArrayList r1 = new ArrayList();
        List<tf0.e> r3 = r0.M;
        if (r3 == null) goto L10;
        r1.addAll(r3);
    L10:
        MultiLinkGuestViewBinder.a r4 = r0.Q;
        if (r4 == null) goto L13;
        ListProtector.add(r1, 0, r4);
    L13:
        ArrayList r7 = new ArrayList();
        r7.addAll(r15);
        if (ListDiffUtils.c(r1, r7) == true) goto L18;
        DataCenter r2 = r0.P0.getDataCenter();
        if (r2 == null) goto L18;
        r2.put("data_multi_link_dynamic_guest_list_change", new nh0.f("guest_list", null, r7, null, null, null, false, 246));
    L18:
        Iterator<T> r5 = r15.iterator();
    L20:
        if (r5.hasNext() == false) goto L33;
        T r6 = r5.next();
        MultiLinkGuestViewBinder.a r8 = (tf0.e) r6;
        if ((r8 instanceof MultiLinkGuestViewBinder.a) == false) goto L30;
        IBaseUser r9 = r8.k.a.getUser();
        if (r9 == null) goto L26;
        String r10 = r9.getIdString();
    L28:
        if (Intrinsics.areEqual(r10, r0.d.toString()) == false) goto L30;
        boolean r11 = true;
    L31:
        if (r11 == false) goto L20;
    L34:
        MultiLinkGuestViewBinder.a r12 = (tf0.e) r6;
        if (r12 != null) goto L37;
    L103:
        ArrayList r13 = new ArrayList(8);
        int r16 = r15.size();
        if (1 <= r16) goto L107;
    L204:
        ALogger.d("ktv_label", "refreshKtvStatusLabel");
        r0.J();
        return;
    L107:
        if (9 < r16) goto L204;
        int r17 = 0;
    L109:
        if (r17 >= 8) goto L111;
        r0.k1.getClass();
        r13.add(qe2.c.a(r17));
        r17 = r17 + 1;
        goto L109
    L111:
        ArrayList r18 = new ArrayList();
        r18.addAll(r13);
        if (r18.size() != 9) goto L114;
        ListProtector.remove(r18, 0);
    L114:
        int r19 = r15.size();
        int r20 = 1;
    L115:
        if (r20 >= r19) goto L120;
        tf0.e r21 = (tf0.e) ListProtector.get(r15, r20);
        int r22 = r20 - 1;
        if (r22 >= r18.size()) goto L119;
        ListProtector.set(r18, r22, r21);
    L119:
        r20 = r20 + 1;
        goto L115
    L120:
        List<tf0.e> r110 = CollectionsKt.toMutableList(r18);
        if (r0.B == null) goto L125;
        RecyclerView r23 = r0.s;
        if (r23 == null) goto L125;
        int r24 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.e;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.a.a(r23, new KtvRoomViewManager$updateGuestListWithDiff$1(r0));
    L125:
        List<tf0.e> r25 = r110;
        ArrayList r26 = new ArrayList();
        Iterator<T> r27 = r25.iterator();
    L127:
        if (r27.hasNext() == false) goto L136;
        T r28 = r27.next();
        MultiLinkGuestViewBinder.a r29 = (tf0.e) r28;
        if ((r29 instanceof MultiLinkGuestViewBinder.a) == true) goto L131;
    L133:
        boolean r30 = false;
    L134:
        if (r30 == false) goto L127;
        r26.add(r28);
        goto L127
    L131:
        if (n.g(r29.k.a) == false) goto L133;
        r30 = true;
        goto L134
    L136:
        List r31 = CollectionsKt.toMutableList(r26);
        r0.k1.getClass();
        List<tf0.e> r32 = qe2.c.b(r110);
        r0.k1.getClass();
        List<tf0.e> r33 = qe2.c.d(r110);
        MiddlewareRoomContext r34 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r34 == null) goto L163;
        m r111 = r34.getKtvHostConfig();
        if (r111 == null) goto L141;
        r111.setValue(new nd.a(r31.size(), ((nd) r111.getValue()).b));
    L141:
        String r35 = k.n(IMiddlewareUserService.class).user().b().getIdString();
        m r36 = r34.getCurUserIsKtvHost();
        List<tf0.e> r112 = r32;
        if ((r112 instanceof Collection) == true) goto L144;
    L146:
        Iterator<T> r113 = r112.iterator();
    L148:
        if (r113.hasNext() == false) goto L161;
        MultiLinkGuestViewBinder.a r114 = (tf0.e) r113.next();
        if ((r114 instanceof MultiLinkGuestViewBinder.a) == false) goto L158;
        IBaseUser r115 = r114.k.a.getUser();
        if (r115 == null) goto L154;
        String r116 = r115.getIdString();
    L156:
        if (Intrinsics.areEqual(r116, r35) == false) goto L158;
        boolean r117 = true;
    L159:
        if (r117 == false) goto L148;
        boolean r37 = true;
    L162:
        r36.setValue(Boolean.valueOf(r37));
        goto L163
    L154:
        r116 = null;
    L158:
        r117 = false;
    L161:
        r37 = false;
        goto L162
    L144:
        if (r112.isEmpty() == false) goto L146;
    L163:
        KtvRoomSeatManager r38 = r0.F;
        if (r38 == null) goto L169;
        Intrinsics.checkNotNullParameter(r32, "hostList");
        KtvRoomSeatListAdapter r39 = r38.f;
        if (r39 == null) goto L169;
        Intrinsics.checkNotNullParameter(r32, "newList");
        DiffUtil.DiffResult r40 = DiffUtil.calculateDiff(new KtvRoomDiffCallback(r39.c, r32), true);
        r39.c = r32;
        r40.dispatchUpdatesTo(r39);
    L169:
        if ((!r32.isEmpty()) == false) goto L176;
        RecyclerView r41 = r0.t;
        if (r41 == null) goto L173;
        r41.setVisibility(0);
    L173:
        View r42 = r0.u;
        if (r42 == null) goto L182;
        a1.m(r42, s1.f(8.0f));
    L182:
        r0.M = r110;
        KtvRoomSeatManager r43 = r0.F;
        if (r43 == null) goto L187;
        Intrinsics.checkNotNullParameter(r33, "normalGuestList");
        r43.l = r33;
        KtvRoomSeatListAdapter r44 = r43.e;
        if (r44 == null) goto L187;
        Intrinsics.checkNotNullParameter(r33, "newList");
        DiffUtil.DiffResult r45 = DiffUtil.calculateDiff(new KtvRoomDiffCallback(r44.c, r33), true);
        r44.c = r33;
        r45.dispatchUpdatesTo(r44);
    L187:
        r0.N(r110);
        ArrayList r118 = new ArrayList();
        Iterator<T> r46 = r25.iterator();
    L189:
        if (r46.hasNext() == false) goto L198;
        MultiLinkGuestViewBinder.a r47 = (tf0.e) r46.next();
        if ((r47 instanceof MultiLinkGuestViewBinder.a) == true) goto L192;
        r118.add(new LinkPlayerInfo());
        goto L189
    L192:
        LinkPlayerInfo r48 = jm2.a.d(r47.k.a);
        if (r48 == null) goto L196;
        r118.add(r48);
        goto L189
    L196:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo");
    L198:
        DataCenter r49 = r0.P0.getDataCenter();
        if (r49 == null) goto L204;
        LinkPlayerInfo r50 = r0.s();
        if (r50 == null) goto L203;
        ListProtector.add(r118, 0, r50);
    L203:
        Unit r51 = Unit.INSTANCE;
        r49.put("data_ktv_micseat_list", r118);
        goto L204
    L176:
        RecyclerView r52 = r0.t;
        if (r52 == null) goto L179;
        r52.setVisibility(8);
    L179:
        View r53 = r0.u;
        if (r53 == null) goto L182;
        a1.m(r53, s1.f(8.0f));
        goto L182
    L37:
        if ((r12 instanceof MultiLinkGuestViewBinder.a) == true) goto L39;
        MultiLinkGuestViewBinder.a r54 = null;
    L40:
        MultiLinkGuestViewBinder.a r55 = r54;
        if (r55 == null) goto L100;
        ch0.e r56 = r55.k;
        if (r56 == null) goto L100;
        ILinkPlayerInfoBridge r57 = r56.a;
        if (r57 == null) goto L100;
        if (((Boolean) vm2.h.H2.getValue(null, vm2.h.a[188(0xbc, float:2.63E-43)])).booleanValue() == false) goto L66;
        MultiLinkGuestViewBinder.a r58 = r0.Q;
        if (r58 == null) goto L66;
        Intrinsics.checkNotNull(r58);
        MultiLinkGuestViewBinder.a r59 = r12;
        if (ch0.f.a(r58.k) != ch0.f.a(r59.k)) goto L53;
        boolean r60 = true;
    L54:
        if (r60 == true) goto L66;
        qe2.c r61 = r0.k1;
        r61.getClass();
        int r62 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a;
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(r61.e()) == true) goto L66;
        ?? r63 = ch0.f.a(r59.k);
        if (r59.k.a.getSilenceStatus() == 0) goto L60;
        r0.I();
        goto L66
    L60:
        if (r63 <= 0) goto L65;
        HSImageView r64 = r0.o;
        if (r64 == null) goto L64;
        r64.setVisibility(0);
    L64:
        r0.H(r59, r63 == true ? 1 : 0);
        goto L66
    L65:
        r0.B(r59);
        goto L66
    L53:
        r60 = false;
    L66:
        MultiLinkGuestViewBinder.a r65 = r12;
        r0.Q = r65;
        LinkPlayerInfo r66 = (LinkPlayerInfo) r57;
        r0.P = r66;
        r0.F(r66, ch0.f.a(r65.k));
        if (r65.k.a.isBackground() == false) goto L83;
        AnchorPauseTipsView r67 = r0.n;
        if (r67 == null) goto L71;
        UtilityKotlinExtentionsKt.w(r67);
    L71:
        TextView r68 = r0.w;
        if (r68 == null) goto L74;
        UtilityKotlinExtentionsKt.w(r68);
    L74:
        FrameLayout r69 = r0.v;
        if (r69 == null) goto L77;
        UtilityKotlinExtentionsKt.w(r69);
    L77:
        TextView r70 = r0.y;
        if (r70 == null) goto L80;
        UtilityKotlinExtentionsKt.t(r70);
    L80:
        TextView r71 = r0.w;
        if (r71 == null) goto L96;
        r71.setText(s1.B(2131919493));
    L96:
        if (r65.k.a.getSilenceStatus() == 0) goto L98;
        boolean r72 = true;
    L99:
        r0.i(r72);
        goto L100
    L98:
        r72 = false;
        goto L99
    L83:
        AnchorPauseTipsView r73 = r0.n;
        if (r73 == null) goto L86;
        UtilityKotlinExtentionsKt.t(r73);
    L86:
        TextView r74 = r0.w;
        if (r74 == null) goto L89;
        UtilityKotlinExtentionsKt.t(r74);
    L89:
        FrameLayout r75 = r0.v;
        if (r75 == null) goto L92;
        UtilityKotlinExtentionsKt.t(r75);
    L92:
        TextView r76 = r0.w;
        if (r76 == null) goto L96;
        r76.setText(s1.B(2131919495));
    L100:
        com.bytedance.live.datacontext.k<Object> r77 = r0.g1.getKtvRoomLabelChangeEvent();
        if (r77 == null) goto L103;
        r77.post(new Object());
        goto L103
    L39:
        r54 = r12;
        goto L40
    L26:
        r10 = null;
    L30:
        r11 = false;
        goto L31
    L33:
        r6 = null;
        goto L34
    }
}
