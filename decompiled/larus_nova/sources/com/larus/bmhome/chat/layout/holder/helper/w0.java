package com.larus.bmhome.chat.layout.holder.helper;

import android.graphics.Point;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.c4;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.actionbar.api.ChatUIBlockConfig;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.common.spi.interaction.ObricMessagePopupServiceDelegate;
import com.skydoves.balloon.Balloon;
import java.util.Calendar;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class w0 implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f303691a;

    public /* synthetic */ w0(a1 r100) {
        this.f303691a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, com.larus.bmhome.chat.layout.holder.helper.x0] */
    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(final View r210) {
        final a1 r110 = this.f303691a;
        com.larus.bmhome.chat.api.q0 r100 = r110.f303571b;
        if (r100 != null) goto L5;
    L4:
        return true;
    L5:
        wc9.e r111 = (wc9.e) r100.A7().invoke();
        Fragment r101 = r110.f303571b.getHostFragment().invoke();
        z19.j r211 = null;
        if (r101 == null) goto L10;
        t1a.b r102 = s1a.a.g(r101);
        if (r102 == null) goto L10;
        ss8.g r103 = (ss8.g) r102.getAbility(ss8.g.class);
    L11:
        if (r103 != null) goto L13;
    L15:
        boolean r104 = false;
    L16:
        FLogger r105 = FLogger.f375446a;
        r105.i("LongClickHelper", "onLongClick: forbidSendMsg=" + ic8.n.d(r111) + ", isLongPressBlocked=" + r104);
        if (ic8.n.d(r111) == true) goto L19;
    L21:
        if (r104 == true) goto L4;
        com.larus.bmhome.chat.api.q0.a r106 = r110.f303572c;
        if (r106 == null) goto L4;
        com.larus.bmhome.chat.component.cvs.y r107 = r106.u0();
        if (r107 == null) goto L4;
        BotModel r112 = r107.j0();
        if (r112 == null) goto L4;
        List<? extends ot8.a> r113 = t0.a.a(r110.f303573d, r210.getContext(), r110.f303570a, null, r110.f303571b, r112, r111, r110.f303572c, r110.f303575f, 4);
        final Integer r114 = a1.e(r110.f303575f);
        if (r113.isEmpty() == true) goto L4;
        ObricMessagePopupServiceDelegate r115 = ObricMessagePopupServiceDelegate.f387845b;
        r115.filterMessageMenuItemsIfNeeded(r210.getContext(), r113);
        if (ObricFeatureServiceDelegate.f387839b.a() == true) goto L36;
    L38:
        final ef8.c r108 = new ef8.c(r113);
        final boolean r109 = com.larus.platform.service.z2.f365865a.enableMessageMenuTimestamp();
        if (r109 == false) goto L41;
        Calendar r116 = oo8.b.f524650a;
        String r117 = oo8.b.a(r110.f303570a.getCreateTime() * 1000, true);
    L42:
        final Ref.ObjectRef r118 = new Ref.ObjectRef();
        r118.element = new x0(r110, r210, r108, r109, r118, r114);
        List<ot8.a> r119 = com.larus.bmhome.view.screenmenu.u0.b(r113, r109, r117);
        CommonMenu r120 = new CommonMenu(r210.getContext());
        com.larus.bmhome.view.screenmenu.g.a(r120);
        com.larus.bmhome.view.screenmenu.u0.a(r120, r109);
        r120.g(r119, (Function1) r118.element);
        r110.f303578i = r120;
        com.larus.bmhome.view.screenmenu.d r121 = com.larus.bmhome.view.screenmenu.d.f317270a;
        Intrinsics.checkNotNull(r210);
        Balloon r122 = com.larus.bmhome.view.screenmenu.d.a(r121, r210, r120.i(), false, null, null, null, new z0(r110), 60);
        if ((r210 instanceof z19.j) == false) goto L45;
        r211 = (z19.j) r210;
    L45:
        if (r211 == null) goto L49;
        Float r123 = r211.getLastMotionX();
        if (r123 == null) goto L49;
        int r124 = (int) r123.floatValue();
    L50:
        if (r211 == null) goto L54;
        Float r125 = r211.getLastMotionY();
        if (r125 == null) goto L54;
        int r126 = (int) r125.floatValue();
    L55:
        r115.markNextDropdownRewriteIfNeeded(r210, r122.f406022e);
        if (Build.VERSION.SDK_INT >= 26) goto L61;
        ChatMessageList r127 = r110.f303571b.B7();
        if (r127 == null) goto L60;
        Point r128 = com.larus.utils.e1.n(r210, r127);
        r120.measure(0, 0);
        r126 = Math.max(r120.getMeasuredHeight() - r128.y, r126);
    L60:
        r122.v(r210, 0, r126);
    L62:
        r110.f303576g = r122;
        ChatMessageList r129 = r110.f303571b.B7();
        if (r129 == null) goto L65;
        r129.requestDisallowInterceptTouchEvent(true);
    L65:
        ViewGroup r130 = r110.f303574e;
        if (r130 == null) goto L68;
        r130.requestDisallowInterceptTouchEvent(true);
    L68:
        r110.b(r113, false, r114);
        r110.d();
        return true;
    L61:
        r122.v(r210, r124, r126);
    L54:
        r126 = r210.getHeight() / 2;
    L49:
        r124 = r210.getWidth() / 2;
        goto L50
    L41:
        r117 = null;
        goto L42
    L36:
        if (r113.isEmpty() == false) goto L38;
        r105.i("LongClickHelper", "skip empty message menu after OBRIC filter, messageId=" + r110.f303570a.getMessageId());
        goto L4
    L19:
        if (c4.a(r110.f303571b.getHostFragment().invoke()) == true) goto L21;
    L13:
        if (r103.bc(ChatUIBlockConfig.DISABLE_MSG_LONG_PRESS) != true) goto L15;
        r104 = true;
    L10:
        r103 = null;
        goto L11
    }
}
