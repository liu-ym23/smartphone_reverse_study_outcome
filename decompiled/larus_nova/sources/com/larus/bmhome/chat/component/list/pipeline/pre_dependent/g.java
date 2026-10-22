package com.larus.bmhome.chat.component.list.pipeline.pre_dependent;

import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes25.dex */
public final class g implements td8.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Long f301206b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final td8.d f301207a;

    public static final class a {
    }

    static {
    }

    @Override // td8.c
    public final boolean a(int r100, xc8.b r101, xc8.b r102, List<? extends xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        return true;
    }

    public g(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f301207a = r100;
    }

    public final void c(Message r110, String r111) {
        ChatControlTrace r100 = ChatControlTrace.f309996b;
        String r101 = r110.getMessageId();
        String r102 = r110.getSenderId();
        String r103 = com.larus.bmhome.chat.bean.d.Z0(r110);
        Long r104 = Long.valueOf(RangesKt.coerceAtLeast(System.currentTimeMillis() - (r110.getCreateTime() * ((long) 1000)), 0));
        long r105 = this.f301207a.b();
        if (com.larus.bmhome.chat.bean.d.x(r110).getNextPulseType() == null) goto L5;
        boolean r106 = true;
    L6:
        Boolean r107 = Boolean.valueOf(r106);
        Integer r108 = com.larus.bmhome.chat.bean.d.x(r110).getNextPulseType();
        r100.getClass();
        ChatControlTrace.Q(r101, r102, r103, r111, r104, r105, r107, r108);
        return;
    L5:
        r106 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // td8.c
    public final List<xc8.b> b(int r210, xc8.b r211, xc8.b r212, List<xc8.b> r213) {
        Intrinsics.checkNotNullParameter(r212, "current");
        Intrinsics.checkNotNullParameter(r213, "input");
        List r100 = CollectionsKt.takeLast(r213, 10);
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (com.larus.bmhome.chat.bean.d.k0(((xc8.b) r103).getMessage()) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        Iterator r104 = r101.iterator();
        if (r104.hasNext() == true) goto L11;
        Long r105 = null;
    L17:
        if (r105 == null) goto L38;
        long r106 = r105.longValue();
        LinkedHashSet r107 = new LinkedHashSet();
        ?? r110 = new ArrayList();
        Iterator r111 = r101.iterator();
    L20:
        if (r111.hasNext() == false) goto L40;
        Object r112 = r111.next();
        Message r113 = ((xc8.b) r112).getMessage();
        if (r113.getServerIndex() != r106) goto L34;
        String r114 = r113.getMessageId();
        if (r114 != null) goto L27;
    L30:
        boolean r115 = true;
    L31:
        if (r115 == false) goto L33;
    L35:
        boolean r116 = false;
    L36:
        if (r116 == false) goto L20;
        r110.add(r112);
        goto L20
    L33:
        if (r107.add(r114) == true) goto L35;
    L27:
        if (r114.length() == 0) goto L30;
        r115 = false;
    L34:
        r116 = true;
    L40:
        if (r110.isEmpty() == false) goto L42;
        Message r108 = null;
    L73:
        ArrayList r109 = new ArrayList();
        Iterator r117 = r213.iterator();
    L75:
        if (r117.hasNext() == false) goto L109;
        xc8.b r118 = (xc8.b) r117.next();
        Message r119 = r118.getMessage();
        if (com.larus.bmhome.chat.bean.d.i0(r119) == false) goto L82;
        if (com.larus.bmhome.chat.bean.d.w(r119) == true) goto L82;
    L101:
        boolean r120 = false;
    L102:
        if (r120 == false) goto L107;
        if (b0.f(r118.getMessage()) == true) goto L107;
        r109.add(r118);
    L107:
        if (r109.size() >= 2) goto L109;
    L82:
        if (com.larus.bmhome.chat.bean.d.T(r119) == true) goto L101;
        if (com.larus.bmhome.chat.bean.d.p0(r119) == true) goto L101;
        if (com.larus.bmhome.chat.bean.d.C0(r119) == true) goto L89;
    L91:
        MessageStatus r121 = r119.getMessageStatus();
        if (r121 != null) goto L94;
    L96:
        boolean r122 = false;
    L97:
        if (r122 == false) goto L99;
    L100:
        r120 = true;
        goto L102
    L99:
        if (b0.f(r119) == false) goto L101;
    L94:
        if (r121.isVisible() != true) goto L96;
        r122 = true;
        goto L97
    L89:
        if (r119.getRegenVisible() == true) goto L91;
    L109:
        boolean r123 = false;
        Pair r124 = TuplesKt.to(CollectionsKt.getOrNull(r109, 0), CollectionsKt.getOrNull(r109, 1));
        xc8.b r125 = (xc8.b) r124.component1();
        xc8.b r126 = (xc8.b) r124.component2();
        if (r125 != null) goto L112;
        return r213;
    L112:
        Message r127 = r125.getMessage();
        if (com.larus.bmhome.chat.bean.d.W0(r127) == true) goto L115;
    L114:
        boolean r128 = false;
    L120:
        if (r128 == false) goto L123;
        c(r125.getMessage(), "wcb downgrade");
        r213.remove(r125);
        return r213;
    L123:
        Message r129 = r125.getMessage();
        if (r126 == null) goto L126;
        Message r130 = r126.getMessage();
    L128:
        if (com.larus.bmhome.chat.bean.d.W0(r129) == false) goto L143;
        if (r130 == null) goto L143;
        if (com.larus.bmhome.chat.bean.d.Y0(r129) == true) goto L143;
        if (com.larus.bmhome.chat.bean.d.X0(r129) == true) goto L143;
        long r131 = r129.getCreateTime() - r130.getCreateTime();
        long r132 = z2.f365865a.showWCBMinIntervalBeforePrevMessage();
        if (r132 <= 0) goto L143;
        if (r131 >= r132) goto L143;
        if (Intrinsics.areEqual(com.larus.bmhome.chat.bean.d.x(r129).get("next_pulse_scene"), "2") == false) goto L142;
        FLogger.f375446a.i("Pipeline_List_PreDependentFilterTask", "isWrongSequenceWelcomeBack but is regenerate, timeAfterPrevMessage = " + r131 + ", local messageId is " + r129.getLocalMessageId());
        goto L143
    L142:
        FLogger.f375446a.i("Pipeline_List_PreDependentFilterTask", "isWrongSequenceWelcomeBack timeAfterPrevMessage = " + r131 + ", local messageId is " + r129.getLocalMessageId());
        r123 = true;
    L143:
        if (r123 == false) goto L145;
        c(r125.getMessage(), "wrong sequence");
        r213.remove(r125);
    L145:
        return r213;
    L126:
        r130 = r108;
        goto L128
    L115:
        long r133 = z2.f365865a.hideWcbBeforeTimestamp();
        if (r133 <= 0) goto L114;
        if (r127.getCreateTime() >= r133) goto L114;
        FLogger.f375446a.i("Pipeline_List_PreDependentFilterTask", "hideWcbDowngrade hideWcbBeforeTimestamp = " + r133 + ", local messageId is " + r127.getLocalMessageId());
        r128 = true;
        goto L120
    L42:
        LinkedHashMap r134 = new LinkedHashMap();
        Iterator r135 = r101.iterator();
    L44:
        if (r135.hasNext() == false) goto L49;
        Object r136 = r135.next();
        Long r137 = Long.valueOf(((xc8.b) r136).getMessage().getServerIndex());
        Object r138 = r134.get(r137);
        if (r138 != null) goto L48;
        r138 = new ArrayList();
        r134.put(r137, r138);
    L48:
        ((List) r138).add(r136);
        goto L44
    L49:
        ArrayList r139 = new ArrayList(r134.size());
        Iterator r140 = r134.entrySet().iterator();
    L51:
        if (r140.hasNext() == false) goto L57;
        Map.Entry r141 = (Map.Entry) r140.next();
        StringBuilder r142 = new StringBuilder();
        r142.append(((Number) r141.getKey()).longValue());
        r142.append(':');
        Iterable r143 = (Iterable) r141.getValue();
        ArrayList r144 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r143, 10));
        Iterator r145 = r143.iterator();
    L54:
        if (r145.hasNext() == false) goto L56;
        xc8.b r146 = (xc8.b) r145.next();
        r144.add(r146.getMessage().getMessageId() + '_' + r146.getMessage().getLocalMessageId() + '_' + r146.getMessage().getLocalIndex() + '_' + r146.getMessage().getCreateTime());
        goto L54
    L56:
        r142.append(r144);
        r139.add(r142.toString());
        goto L51
    L57:
        String r147 = r139.toString();
        FLogger r148 = FLogger.f375446a;
        r148.e("Pipeline_List_PreDependentFilterTask", "dedupeFirstMetMsg firstMeet map size = " + r134.size() + ", content=" + r147);
        if (this.f301207a.e() == true) goto L60;
    L59:
        r108 = null;
    L67:
        if (z2.f365865a.a3().a() == false) goto L73;
        r213.removeAll((Collection) r110);
        StringBuilder r149 = new StringBuilder("do remove duplicate firstMet ");
        Iterable r150 = (Iterable) r110;
        ArrayList r151 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r150, 10));
        Iterator r152 = r150.iterator();
    L70:
        if (r152.hasNext() == false) goto L72;
        xc8.b r153 = (xc8.b) r152.next();
        r151.add(r153.getMessage().getMessageId() + '_' + r153.getMessage().getLocalIndex() + '_' + r153.getMessage().getCreateTime());
        goto L70
    L72:
        r149.append(r151);
        r148.e("Pipeline_List_PreDependentFilterTask", r149.toString());
        goto L73
    L60:
        Long r154 = f301206b;
        if (r154 != null) goto L63;
    L65:
        f301206b = Long.valueOf(this.f301207a.b());
        r108 = null;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PreDependentFilterTask$monitorDuplicateFirstMeetMsg$1(this, r134, r147, null), 3, null);
        goto L67
    L63:
        if (r154.longValue() != this.f301207a.b()) goto L65;
    L38:
        r110 = CollectionsKt.emptyList();
        goto L40
    L11:
        r105 = Long.valueOf(((xc8.b) r104.next()).getMessage().getServerIndex());
    L13:
        if (r104.hasNext() == false) goto L17;
        Long r155 = Long.valueOf(((xc8.b) r104.next()).getMessage().getServerIndex());
        if (r105.compareTo(r155) >= 0) goto L13;
        r105 = r155;
        goto L13
    }
}
