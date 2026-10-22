package com.larus.feedback.impl.service;

import com.google.gson.Gson;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.jni.bean.OmniArchiveStatus;
import com.larus.im.internal.jni.bean.OmniConversationProjectStatus;
import com.larus.im.internal.jni.bean.OmniConversationSortType;
import com.larus.im.internal.jni.bean.OmniDeviceStatus;
import com.larus.im.internal.jni.bean.OmniMainConversationStatus;
import com.larus.im.internal.jni.bean.OmniPinStatus;
import com.larus.im.internal.jni.bean.OmniSelectConversationListRequest;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.j;
import wc9.e;
import wc9.l;
import wc9.s;

/* JADX INFO: loaded from: classes27.dex */
public final class RecentFeedbackMessageCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RecentFeedbackMessageCollector f343115a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f343116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f343117b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f343118c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f343116a, r101.f343116a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f343117b, r101.f343117b) == true) goto L15;
            return false;
        L15:
            if (this.f343118c == r101.f343118c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f343116a.hashCode() * 31) + this.f343117b.hashCode()) * 31;
            long r101 = this.f343118c;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "CollectedMessage(messageId=" + this.f343116a + ", logId=" + this.f343117b + ", createTime=" + this.f343118c + ')';
        }

        public a(String r100, String r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "messageId");
            Intrinsics.checkNotNullParameter(r101, "logId");
            this.f343116a = r100;
            this.f343117b = r101;
            this.f343118c = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f343119a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f343120b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f343119a, r101.f343119a) == true) goto L12;
            return false;
        L12:
            if (this.f343120b == r101.f343120b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f343119a.hashCode() * 31;
            long r101 = this.f343120b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "RecentConversation(conversation=" + this.f343119a + ", latestMessageTime=" + this.f343120b + ')';
        }

        public b(e r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "conversation");
            this.f343119a = r100;
            this.f343120b = r101;
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((a) r101).f343118c), Long.valueOf(((a) r100).f343118c));
        }
    }

    public static final class d<T> implements Comparator {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((b) r101).f343120b), Long.valueOf(((b) r100).f343120b));
        }
    }

    static {
        f343115a = new RecentFeedbackMessageCollector();
    }

    public RecentFeedbackMessageCollector() {
    }

    public final Object a(Continuation<? super String> r210) {
        if ((r210 instanceof RecentFeedbackMessageCollector$collect$1) == false) goto L7;
        RecentFeedbackMessageCollector$collect$1 r100 = (RecentFeedbackMessageCollector$collect$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        long r105 = r100.J$1;
        long r110 = r100.J$0;
        List r106 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L35:
        List r107 = (List) r102;
        if ((r107 instanceof Collection) == true) goto L38;
    L40:
        Iterator r111 = r107.iterator();
    L42:
        if (r111.hasNext() == false) goto L39;
        if (((List) r111.next()) != null) goto L46;
        boolean r112 = true;
    L47:
        if (r112 == false) goto L42;
        boolean r113 = true;
    L49:
        if (r113 == false) goto L52;
        FLogger.f375446a.e("RecentFeedbackMessageCollector", "load recent messages failed");
        return null;
    L52:
        List r108 = CollectionsKt.flatten(CollectionsKt.filterNotNull(r107));
        ArrayList r114 = new ArrayList();
        Iterator r109 = r108.iterator();
    L54:
        if (r109.hasNext() == false) goto L71;
        Message r115 = (Message) r109.next();
        String r116 = r115.getMessageId();
        if (r116 != null) goto L58;
    L67:
        a r117 = null;
    L68:
        if (r117 == null) goto L54;
        r114.add(r117);
        goto L54
    L58:
        if ((!StringsKt.isBlank(r116)) == true) goto L61;
        r116 = null;
    L61:
        if (r116 == null) goto L67;
        String r118 = com.larus.im.bean.message.a.x(r115);
        if (r118 != null) goto L66;
        r118 = "";
    L66:
        r117 = new a(r116, r118, r115.getCreateTime());
        goto L68
    L71:
        ArrayList r119 = new ArrayList();
        Iterator r120 = r114.iterator();
    L73:
        if (r120.hasNext() == false) goto L80;
        Object r121 = r120.next();
        if (((a) r121).f343118c < r105) goto L77;
        boolean r122 = true;
    L78:
        if (r122 == false) goto L73;
        r119.add(r121);
        goto L73
    L77:
        r122 = false;
        goto L78
    L80:
        List r123 = CollectionsKt.sortedWith(r119, new c());
        HashSet r124 = new HashSet();
        ArrayList r125 = new ArrayList();
        Iterator r126 = r123.iterator();
    L82:
        if (r126.hasNext() == false) goto L86;
        Object r127 = r126.next();
        if (r124.add(((a) r127).f343116a) == false) goto L82;
        r125.add(r127);
        goto L82
    L86:
        List r128 = CollectionsKt.take(r125, 20);
        if (r128.isEmpty() == false) goto L100;
        FLogger.f375446a.d("RecentFeedbackMessageCollector", "no valid recent messages");
        return null;
    L100:
        Gson r129 = new Gson();     // Catch: Exception -> L97
        List r130 = r128;     // Catch: Exception -> L97
        ArrayList r131 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r130, 10));     // Catch: Exception -> L97
        Iterator r132 = r130.iterator();     // Catch: Exception -> L97
    L92:
        if (r132.hasNext() == false) goto L94;
        a r133 = (a) r132.next();     // Catch: Exception -> L97
        r131.add(MapsKt.mapOf(new Pair[]{TuplesKt.to("msg_id", r133.f343116a), TuplesKt.to("log_id", r133.f343117b)}));     // Catch: Exception -> L97
        goto L92
    L94:
        String r134 = r129.toJson(MapsKt.mapOf(TuplesKt.to("recent_msgs", r131)));     // Catch: Exception -> L97
        FLogger.f375446a.d("RecentFeedbackMessageCollector", "collect recent messages success, conversations=" + r106.size() + ", messages=" + r128.size() + ", cost=" + (System.currentTimeMillis() - r110));
        return r134;
    L97:
        e = move-exception;
        FLogger.f375446a.e("RecentFeedbackMessageCollector", "encode recent messages failed", e);
        return null;
    L46:
        r112 = false;
    L39:
        r113 = false;
        goto L49
    L38:
        if (r107.isEmpty() == false) goto L40;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r135 = r100.J$1;
        long r136 = r100.J$0;
        ResultKt.throwOnFailure(r102);
    L20:
        List r137 = (List) r102;
        if (r137 != null) goto L24;
        return null;
    L24:
        if (r137.isEmpty() == false) goto L27;
        FLogger.f375446a.d("RecentFeedbackMessageCollector", "no recent conversation with messages");
        return null;
    L27:
        List r138 = r137;
        ArrayList r139 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r138, 10));
        Iterator r140 = r138.iterator();
    L29:
        if (r140.hasNext() == false) goto L31;
        r139.add(((b) r140.next()).f343119a);
        goto L29
    L31:
        RecentFeedbackMessageCollector$collect$messageLists$1 r141 = new RecentFeedbackMessageCollector$collect$messageLists$1(r139, null);
        r100.L$0 = r139;
        r100.J$0 = r136;
        r100.J$1 = r135;
        r100.label = 2;
        r102 = CoroutineScopeKt.coroutineScope(r141, r100);
        if (r102 != r103) goto L34;
        return r103;
    L34:
        r106 = r139;
        r105 = r135;
        r110 = r136;
        goto L35
    L16:
        ResultKt.throwOnFailure(r102);
        long r142 = System.currentTimeMillis();
        long r143 = (r142 / ((long) 1000)) - 172800;
        r100.J$0 = r142;
        r100.J$1 = r143;
        r100.label = 1;
        r102 = b(r100);
        if (r102 != r103) goto L19;
        return r103;
    L19:
        r135 = r143;
        r136 = r142;
    L7:
        r100 = new RecentFeedbackMessageCollector$collect$1(this, r210);
        goto L8
    }

    public final Object b(Continuation<? super List<b>> r210) {
        if ((r210 instanceof RecentFeedbackMessageCollector$loadRecentConversations$1) == false) goto L7;
        RecentFeedbackMessageCollector$loadRecentConversations$1 r100 = (RecentFeedbackMessageCollector$loadRecentConversations$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L19:
        s r105 = (s) r102;
        if (r105 != null) goto L22;
        return null;
    L22:
        ArrayList r106 = new ArrayList();
        LinkedHashSet r107 = new LinkedHashSet();
        Iterator<T> r108 = r105.f559261a.iterator();
    L24:
        if (r108.hasNext() == false) goto L52;
        l r109 = (l) r108.next();
        e r110 = r109.f559248a;
        if (r110 == null) goto L24;
        List<Message> r111 = r109.f559249b;
        if (r111 == null) goto L39;
        Iterator<T> r112 = r111.iterator();
        if (r112.hasNext() == false) goto L39;
        Long r113 = Boxing.boxLong(((Message) r112.next()).getCreateTime());
    L35:
        if (r112.hasNext() == false) goto L40;
        Long r114 = Boxing.boxLong(((Message) r112.next()).getCreateTime());
        if (r113.compareTo(r114) >= 0) goto L35;
        r113 = r114;
    L40:
        if (r113 == null) goto L24;
        if (StringsKt.isBlank(r110.f559198a) == true) goto L24;
        Integer r115 = r110.f559219v;
        if (r115 == null) goto L49;
        if (r115.intValue() == 6) goto L24;
    L49:
        if (r107.add(r110.f559198a) == false) goto L24;
        r106.add(new b(r110, r113.longValue()));
    L39:
        r113 = null;
        goto L40
    L52:
        FLogger.f375446a.d("RecentFeedbackMessageCollector", "load recent conversations success, count=" + RangesKt.coerceAtMost(r106.size(), 3));
        return CollectionsKt.take(CollectionsKt.sortedWith(r106, new d()), 3);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        r100.label = 1;
        j r116 = new j(IntrinsicsKt.intercepted(r100), 1);
        r116.C();
        OmniPinStatus r117 = null;
        OmniConversationProjectStatus r118 = null;
        OmniDeviceStatus r119 = null;
        com.larus.im.d.d().selectConversationList(new OmniSelectConversationListRequest(r117, r118, r119, OmniMainConversationStatus.MainConversationStatus_INCLUDE, OmniArchiveStatus.ArchiveStatus_ALL, true, Long.MAX_VALUE, "", OmniConversationSortType.OmniConversationSortType_UPDATE_TIME, 10, 7, null), new com.larus.feedback.impl.service.b(r116));
        r102 = r116.B();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L17:
        if (r102 != r103) goto L19;
        return r103;
    L7:
        r100 = new RecentFeedbackMessageCollector$loadRecentConversations$1(this, r210);
        goto L8
    }
}
