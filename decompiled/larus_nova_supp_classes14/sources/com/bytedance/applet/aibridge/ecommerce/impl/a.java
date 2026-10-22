package com.bytedance.applet.aibridge.ecommerce.impl;

import android.os.SystemClock;
import com.larus.bmhome.chat.bean.d;
import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import com.larus.platform.model.mainbot.ECommerceProductCardPreloadConfig;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import lv3.e;
import nf9.b;
import nf9.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements b, c {
    public static final a a = null;
    public static final Object b = null;
    public static boolean c;
    public static ECommerceProductCardPreloadGroup d;
    public static final Map<String, Double> e = null;
    public static final Set<String> f = null;
    public static final Map<String, Message> g = null;

    /* JADX INFO: renamed from: com.bytedance.applet.aibridge.ecommerce.impl.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0048a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ECommerceProductCardPreloadGroup.values().length];
            r0[ECommerceProductCardPreloadGroup.DISABLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ECommerceProductCardPreloadGroup.CARD_EXPOSURE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ECommerceProductCardPreloadGroup.LATEST_NEW_MESSAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public a() {
    }

    public final void a(String r2, Message r3) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "msg");
    }

    public final void b(String r2, MessageListState r3, List<Message> r4) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r4, "msgList");
    }

    public final void d(String r2, Message r3) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "msg");
    }

    public final void f(String r2, Message r3) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "msg");
    }

    public final void onMessageListReplaced(String r2, List<Message> r3, List<Message> r4) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "oldMsgList");
        Intrinsics.checkNotNullParameter(r4, "newMsgList");
    }

    static {
        a = new a();
        b = new Object();
        d = ECommerceProductCardPreloadGroup.DISABLED;
        e = new LinkedHashMap();
        f = new LinkedHashSet();
        g = new LinkedHashMap();
    }

    public static lv3.a g() {
        ECommerceProductCardPreloadConfig r0 = z2.a.getECommerceProductCardPreloadConfig();
        ECommerceProductCardPreloadGroup.a r1 = ECommerceProductCardPreloadGroup.Companion;
        int r2 = r0.getProductCardPreloadGroup();
        r1.getClass();
        Iterator r3 = ECommerceProductCardPreloadGroup.getEntries().iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        Object r4 = r3.next();
        if (((ECommerceProductCardPreloadGroup) r4).getValue() != r2) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L4;
    L12:
        ECommerceProductCardPreloadGroup r6 = (ECommerceProductCardPreloadGroup) r4;
        if (r6 != null) goto L16;
        FLogger.a.w("ECommerceProductCardPreload", "[product_card_preload] stage=config_parse result=fallback_disabled invalid_group=" + r0.getProductCardPreloadGroup());
    L16:
        if (r6 != null) goto L19;
        r6 = ECommerceProductCardPreloadGroup.DISABLED;
    L19:
        return new lv3.a(r6, RangesKt.coerceAtLeast(r0.getProductCardPreloadThrottleInterval(), 0.0d), RangesKt.coerceAtLeast(r0.getProductCardPreloadMaxCardCount(), 0));
    L8:
        r5 = false;
        goto L9
    L11:
        r4 = null;
        goto L12
    }

    public static Set l(Message r5) {
        Set r6 = SetsKt.setOfNotNull(new String[]{r5.getMessageId(), r5.getLocalMessageId()});
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L12;
        Object r3 = r7.next();
        if (((String) r3).length() <= 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
        r0.add(r3);
        goto L4
    L8:
        r4 = false;
        goto L9
    L12:
        return CollectionsKt.toSet(r0);
    }

    public static void m(ECommerceProductCardPreloadGroup r3) {
        if (d != r3) goto L5;
        return;
    L5:
        FLogger.a.i("ECommerceProductCardPreload", "[product_card_preload] stage=group_change from=" + d.getValue() + " to=" + r3.getValue());
        d = r3;
        ((LinkedHashMap) e).clear();
    }

    public static void n(Message r12) {
        boolean r2 = true;
        if (r12.getContentType() == 1) goto L5;
        return;
    L5:
        if (d.G0(r12) == false) goto L7;
        return;
    L7:
        if (com.larus.im.bean.message.a.r0(r12) == false) goto L9;
        return;
    L9:
        if (com.larus.im.bean.message.a.y0(r12) == false) goto L11;
        return;
    L11:
        if (com.larus.im.bean.message.a.x0(r12) == true) goto L69;
        String r1 = r12.getConversationId();
        if (r1 == null) goto L16;
        String r3 = StringsKt.trim(r1).toString();
    L17:
        if (r3 != null) goto L19;
        r3 = "";
    L19:
        boolean r4 = false;
        if (r3.length() != 0) goto L22;
        boolean r5 = true;
    L23:
        if (r5 == false) goto L25;
        return;
    L25:
        Object r6 = b;
        monitor-enter(r6);
        Map<String, Message> r7 = g;     // Catch: Throwable -> L60
        Message r8 = (Message) ((LinkedHashMap) r7).get(r3);     // Catch: Throwable -> L60
        if (r8 != null) goto L30;
    L49:
        if (r8 == null) goto L51;
        r2 = true ^ h(r8, r12);     // Catch: Throwable -> L60
    L51:
        r7.put(r3, r12);     // Catch: Throwable -> L60
        if (r2 == false) goto L57;
        FLogger r9 = FLogger.a;     // Catch: Throwable -> L60
        StringBuilder r10 = new StringBuilder("[product_card_preload] stage=latest_text_message_update conversation_id=");     // Catch: Throwable -> L60
        r10.append(r3);     // Catch: Throwable -> L60
        r10.append(" message_id=");     // Catch: Throwable -> L60
        String r13 = r12.getMessageId();     // Catch: Throwable -> L60
        if (r13 != null) goto L56;
        r13 = "";
    L56:
        r10.append(r13);     // Catch: Throwable -> L60
        r9.i("ECommerceProductCardPreload", r10.toString());     // Catch: Throwable -> L60
    L57:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L60
        monitor-exit(r6);
        return;
    L30:
        if (h(r8, r12) == false) goto L33;
    L45:
        r4 = true;
    L46:
        if (r4 == true) goto L49;
        monitor-exit(r6);
        return;
    L33:
        if (r8.getServerIndex() == r12.getServerIndex()) goto L38;
        if (r12.getServerIndex() <= r8.getServerIndex()) goto L46;
    L38:
        if (r8.getLocalIndex() == r12.getLocalIndex()) goto L44;
        if (r12.getLocalIndex() <= r8.getLocalIndex()) goto L46;
    L44:
        if (r12.getCreateTime() < r8.getCreateTime()) goto L46;
    L60:
        th = move-exception;
        throw th;
    L22:
        r5 = false;
        goto L23
    L16:
        r3 = null;
        goto L17
    }

    public final void A(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        n(r2);
    }

    public final void B(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        n(r2);
    }

    public final void C(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        n(r2);
    }

    public static boolean h(Message r3, Message r4) {
        Set r5 = l(r3);
        if ((!r5.isEmpty()) == false) goto L18;
        Set r6 = r5;
        Set r7 = l(r4);
        if ((r6 instanceof Collection) == true) goto L7;
    L9:
        Iterator r8 = r6.iterator();
    L11:
        if (r8.hasNext() == false) goto L15;
        if (r7.contains((String) r8.next()) == false) goto L11;
        boolean r9 = true;
    L16:
        if (r9 == false) goto L18;
        return true;
    L15:
        r9 = false;
        goto L16
    L7:
        if (r6.isEmpty() == false) goto L9;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v15, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.util.List, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.util.List] */
    public static ECommerceProductCardPreloadDecision j(e r10, lv3.a r11) {
        if (r11.a == ECommerceProductCardPreloadGroup.DISABLED) goto L5;
        String r0 = StringsKt.trim(r10.a).toString();
        String r1 = StringsKt.trim(r10.b).toString();
        String r2 = StringsKt.trim(r10.c).toString();
        if (r0.length() != 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L80;
        if (r1.length() != 0) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == true) goto L80;
        if (r2.length() != 0) goto L19;
        boolean r5 = true;
    L20:
        if (r5 == true) goto L80;
        ?? r12 = r10.d;
        int r6 = r11.c;
        if (r6 > 0) goto L26;
        r12 = CollectionsKt.emptyList();
    L47:
        if (r12.isEmpty() == true) goto L49;
        String r7 = r2 + '#' + r0 + '#' + r1;
        int r8 = C0048a.a[r11.a.ordinal()];
        if (r8 == 1) goto L78;
        if (r8 != 2) goto L55;
        Object r9 = b;
        monitor-enter(r9);
        ECommerceProductCardPreloadDecision r13 = i(r7, r12, r11.b);     // Catch: Throwable -> L74
        monitor-exit(r9);
        return r13;
    L74:
        th = move-exception;
        throw th;
    L55:
        if (r8 != 3) goto L68;
        Object r14 = b;
        monitor-enter(r14);
    L64:
        th = move-exception;
        throw th;
    L59:
        if (d == r11.a) goto L61;
        ECommerceProductCardPreloadDecision r15 = new ECommerceProductCardPreloadDecision.b(ECommerceProductCardPreloadDecision.Reason.EXPERIMENT_CHANGED);     // Catch: Throwable -> L64
    L62:
        monitor-exit(r14);
        return r15;
    L61:
        r15 = k(r7, r0, r1, r2, r12);     // Catch: Throwable -> L64
        goto L62
    L68:
        throw new NoWhenBranchMatchedException();
    L78:
        return new ECommerceProductCardPreloadDecision.b(ECommerceProductCardPreloadDecision.Reason.EXPERIMENT_DISABLED);
    L49:
        return new ECommerceProductCardPreloadDecision.b(ECommerceProductCardPreloadDecision.Reason.EMPTY_SCHEMA_LIST);
    L26:
        if (r12.size() <= r6) goto L47;
        LinkedHashSet r16 = new LinkedHashSet();
        List r17 = CollectionsKt.take((Iterable) r12, r6);
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r19 = r17.iterator();
    L30:
        if (r19.hasNext() == false) goto L32;
        r18.add(StringsKt.trim((String) r19.next()).toString());
        goto L30
    L32:
        r12 = new ArrayList();
        Iterator r20 = r18.iterator();
    L34:
        if (r20.hasNext() == false) goto L47;
        Object r21 = r20.next();
        String r22 = (String) r21;
        if (r22.length() <= 0) goto L38;
        boolean r23 = true;
    L39:
        if (r23 == true) goto L41;
    L43:
        boolean r24 = false;
    L44:
        if (r24 == false) goto L34;
        r12.add(r21);
        goto L34
    L41:
        if (r16.add(r22) == false) goto L43;
        r24 = true;
        goto L44
    L38:
        r23 = false;
        goto L39
    L19:
        r5 = false;
        goto L20
    L14:
        r4 = false;
    L80:
        return new ECommerceProductCardPreloadDecision.b(ECommerceProductCardPreloadDecision.Reason.INVALID_CONTEXT);
    L9:
        r3 = false;
        goto L10
    L5:
        return new ECommerceProductCardPreloadDecision.b(ECommerceProductCardPreloadDecision.Reason.EXPERIMENT_DISABLED);
    }

    public static ECommerceProductCardPreloadDecision i(String r6, List r7, final double r8) {
        final double r0 = SystemClock.elapsedRealtime() / 1000.0d;
        Map<String, Double> r2 = e;
        Double r3 = (Double) ((LinkedHashMap) r2).get(r6);
        if (r3 != null) goto L5;
    L8:
        r2.put(r6, Double.valueOf(r0));
        if (r8 > 0.0d) goto L11;
        ((LinkedHashMap) r2).clear();
    L13:
        return new ECommerceProductCardPreloadDecision.a(r7);
    L11:
        CollectionsKt.removeAll(((LinkedHashMap) r2).entrySet(), new lv3.d(r0, r8));
        goto L13
    L5:
        if ((r0 - r3.doubleValue()) >= r8) goto L8;
        return new ECommerceProductCardPreloadDecision.b(ECommerceProductCardPreloadDecision.Reason.CARD_THROTTLED);
    }

    public final void c(String r2, Message r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "msg");
        if (com.larus.im.bean.message.a.h0(r4) == false) goto L6;
        n(r3);
        return;
    }

    public final void e(String r1, Message r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r1, "cid");
        Intrinsics.checkNotNullParameter(r2, "msg");
        n(r2);
    }

    public static ECommerceProductCardPreloadDecision k(String r8, String r9, String r10, String r11, List r12) {
        Message r0 = (Message) ((LinkedHashMap) g).get(r11);
        boolean r1 = true;
        Set r13 = SetsKt.mutableSetOf(new String[]{r8});
        if (r0 != null) goto L5;
    L16:
        Set r14 = r13;
        Set<String> r15 = f;
        if ((r14 instanceof Collection) == true) goto L19;
    L21:
        Iterator r16 = r14.iterator();
    L23:
        if (r16.hasNext() == false) goto L27;
        if (r15.contains((String) r16.next()) == false) goto L23;
        boolean r17 = true;
    L28:
        if (r17 == false) goto L30;
        boolean r18 = false;
    L31:
        if (r18 == false) goto L33;
        if (r0 == null) goto L46;
        if (Intrinsics.areEqual(r0.getMessageId(), r9) == false) goto L38;
    L41:
        if (r1 == false) goto L46;
        return new ECommerceProductCardPreloadDecision.a(r12);
    L38:
        if (Intrinsics.areEqual(r0.getLocalMessageId(), r9) == true) goto L41;
        r1 = false;
    L46:
        return new ECommerceProductCardPreloadDecision.b(ECommerceProductCardPreloadDecision.Reason.NOT_LATEST_MESSAGE);
    L33:
        return new ECommerceProductCardPreloadDecision.b(ECommerceProductCardPreloadDecision.Reason.NOT_NEW_MESSAGE);
    L30:
        CollectionsKt.addAll(f, r14);
        r18 = true;
    L27:
        r17 = false;
        goto L28
    L19:
        if (r14.isEmpty() == false) goto L21;
    L5:
        if (Intrinsics.areEqual(r0.getMessageId(), r9) == false) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L16;
        Iterator r3 = l(r0).iterator();
    L14:
        if (r3.hasNext() == false) goto L16;
        r13.add(r11 + '#' + ((String) r3.next()) + '#' + r10);
        goto L14
    L7:
        if (Intrinsics.areEqual(r0.getLocalMessageId(), r9) == true) goto L10;
        r2 = false;
        goto L11
    }
}
