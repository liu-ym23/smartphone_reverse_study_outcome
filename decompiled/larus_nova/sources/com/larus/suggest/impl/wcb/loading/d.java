package com.larus.suggest.impl.wcb.loading;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.list.cell.prompt.w0;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.MessageTag;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d implements td8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final td8.d f369949a;

    public d(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f369949a = r100;
    }

    @Override // td8.c
    public final boolean a(int r100, xc8.b r101, xc8.b r102, List<? extends xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        ConcurrentHashMap<Long, b> r104 = c.f369948a;
        b r105 = c.a(this.f369949a.b());
        if (r105 != null) goto L5;
        return false;
    L5:
        Iterator<T> r106 = r103.iterator();
    L6:
        Message r107 = null;
        if (r106.hasNext() == false) goto L41;
        Object r108 = r106.next();
        xc8.b r109 = (xc8.b) r108;
        Message r110 = r109.getMessage();
        if (com.larus.bmhome.chat.bean.d.i0(r110) == false) goto L14;
        if (com.larus.bmhome.chat.bean.d.w(r110) == true) goto L14;
    L33:
        boolean r111 = false;
    L34:
        if (r111 == true) goto L36;
    L38:
        boolean r112 = false;
    L39:
        if (r112 == false) goto L6;
    L42:
        xc8.b r113 = (xc8.b) r108;
        if (r113 == null) goto L45;
        r107 = r113.getMessage();
    L45:
        if (r107 != null) goto L47;
    L49:
        boolean r114 = false;
    L50:
        if (r114 == false) goto L56;
        if (Intrinsics.areEqual(r107.getLocalMessageId(), r105.f369941i) == true) goto L56;
        ConcurrentHashMap<Long, b> r115 = c.f369948a;
        c.b(r105.f369933a, r105.f369934b);
        FLogger.f375446a.d("WcbLog", "[WcbLoadingTask] list.yieldToUserMessage chat=" + r105.f369933a + " exec=" + r105.f369934b + " latest=" + r107.getLocalMessageId() + " boundary=" + r105.f369941i);
        return false;
    L56:
        if (r105.f369946n == true) goto L58;
        return false;
    L58:
        if (r105.f369947o.isCompleted() == true) goto L67;
        return true;
    L67:
        return false;
    L47:
        if (com.larus.bmhome.chat.bean.d.G0(r107) != true) goto L49;
        r114 = true;
        goto L50
    L36:
        if (b0.f(r109.getMessage()) == true) goto L38;
        r112 = true;
    L14:
        if (com.larus.bmhome.chat.bean.d.T(r110) == true) goto L33;
        if (com.larus.bmhome.chat.bean.d.p0(r110) == true) goto L33;
        if (com.larus.bmhome.chat.bean.d.C0(r110) == true) goto L21;
    L23:
        MessageStatus r116 = r110.getMessageStatus();
        if (r116 != null) goto L26;
    L28:
        boolean r117 = false;
    L29:
        if (r117 == false) goto L31;
    L32:
        r111 = true;
        goto L34
    L31:
        if (b0.f(r110) == false) goto L33;
    L26:
        if (r116.isVisible() != true) goto L28;
        r117 = true;
        goto L29
    L21:
        if (r110.getRegenVisible() == true) goto L23;
    L41:
        r108 = null;
        goto L42
    }

    @Override // td8.c
    public final List<xc8.b> b(int r910, xc8.b r100, xc8.b r101, List<xc8.b> r102) {
        Intrinsics.checkNotNullParameter(r101, "current");
        Intrinsics.checkNotNullParameter(r102, "input");
        ConcurrentHashMap<Long, b> r103 = c.f369948a;
        b r104 = c.a(this.f369949a.b());
        if (r104 != null) goto L5;
        return r102;
    L5:
        Map r105 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("next_pulse_scene", String.valueOf(r104.f369937e)), TuplesKt.to("next_pulse_type", "1"), TuplesKt.to("wcb_message_hidden", "true"), TuplesKt.to("wcb_title", r104.f369943k), TuplesKt.to("wcb_title_style", String.valueOf(r104.f369944l))});
        String r106 = r104.f369935c;
        String r110 = r104.f369936d;
        String r107 = r104.f369939g;
        MessageStatus r111 = MessageStatus.MessageStatus_AVAILABLE;
        String r108 = r104.f369942j;
        List r410 = CollectionsKt.listOf(Integer.valueOf(MessageTag.MessageTag_Onboarding_WELCOMEBACK.value));
        Map r109 = MapsKt.toMutableMap(r105);
        r109.put("transient_wcb_loading_session_id", String.valueOf(r104.f369934b));
        Message r112 = Message.copy$default(b0.j(new Message(r106, null, r110, 0, 21, r111, 2, false, null, null, null, null, null, r105, r107, r107, 0, 0, false, r108, null, null, r109, null, null, 0, false, 0, null, r410, false, null, null, 0, null, null, null, -541646966, 31, null), 1), null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, r104.f369940h, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -16385, 31, null);
        ListProtector.add(r102, 0, new w0(r112));
        FLogger.f375446a.d("WcbLog", "[WcbLoadingTask] list.insertSkeleton chat=" + r104.f369933a + " exec=" + r104.f369934b + " localId=" + r112.getLocalMessageId() + " size=" + r102.size() + " index=" + r910);
        return r102;
    }
}
