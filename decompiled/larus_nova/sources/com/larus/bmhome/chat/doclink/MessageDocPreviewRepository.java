package com.larus.bmhome.chat.doclink;

import com.bytedance.keva.Keva;
import com.larus.bmhome.auth.LaunchBiz;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes25.dex */
public final class MessageDocPreviewRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MessageDocPreviewRepository f302894a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, h> f302895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<String> f302896b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f302895a, r101.f302895a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f302896b, r101.f302896b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f302895a.hashCode() * 31) + this.f302896b.hashCode();
        }

        public final String toString() {
            return "FetchResult(previewsByUrl=" + this.f302895a + ", previewUrls=" + this.f302896b + ')';
        }

        public a(Map<String, h> r100, Set<String> r101) {
            Intrinsics.checkNotNullParameter(r100, "previewsByUrl");
            Intrinsics.checkNotNullParameter(r101, "previewUrls");
            this.f302895a = r100;
            this.f302896b = r101;
        }
    }

    public static final class b implements Function1<Map<String, ? extends h>, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<Map<String, h>> f302897a;

        public b(kotlinx.coroutines.j r100) {
            this.f302897a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Map<String, ? extends h> r100) {
            Map<String, ? extends h> r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "previews");
            if (this.f302897a.isActive() == false) goto L6;
            this.f302897a.resumeWith(Result.m9449constructorimpl(r101));
        L6:
            return Unit.INSTANCE;
        }
    }

    static {
        f302894a = new MessageDocPreviewRepository();
    }

    public MessageDocPreviewRepository() {
    }

    public static Map.Entry b(Map r100, String r101) {
        Set r102 = r100.entrySet();
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L3:
        Object r105 = null;
        if (r104.hasNext() == false) goto L13;
        Object r106 = r104.next();
        String r107 = l.a((String) ((Map.Entry) r106).getKey());
        boolean r108 = true;
        if ((!StringsKt.isBlank(r107)) == true) goto L8;
    L10:
        r108 = false;
    L11:
        if (r108 == false) goto L3;
        r103.add(r106);
        goto L3
    L8:
        if (StringsKt.startsWith$default(r101, r107, false, 2, null) == false) goto L10;
    L13:
        Iterator r109 = r103.iterator();
        if (r109.hasNext() == false) goto L26;
        r105 = r109.next();
        if (r109.hasNext() == false) goto L26;
        int r110 = l.a((String) ((Map.Entry) r105).getKey()).length();
    L20:
        Object r111 = r109.next();
        int r112 = l.a((String) ((Map.Entry) r111).getKey()).length();
        if (r110 >= r112) goto L24;
        r105 = r111;
        r110 = r112;
    L24:
        if (r109.hasNext() == true) goto L20;
    L26:
        return (Map.Entry) r105;
    }

    public static a e(String r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "urls");
        List r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(l.a((String) r104.next()));
        goto L4
    L6:
        ArrayList r105 = new ArrayList();
        Iterator r106 = r103.iterator();
    L8:
        if (r106.hasNext() == false) goto L12;
        Object r107 = r106.next();
        if ((!StringsKt.isBlank((String) r107)) == false) goto L8;
        r105.add(r107);
        goto L8
    L12:
        List r108 = CollectionsKt.distinct(r105);
        g.f302903a.getClass();
        List r109 = g.b(r108);
        f.f302900a.getClass();
        Map r110 = f.c(r100, r109);
        return new a(r110, r110.keySet());
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0130 -> B:55:0x0133). Please report as a decompilation issue!!! */
    public final Object f(List<String> r110, Continuation<? super List<String>> r111) {
        if ((r111 instanceof MessageDocPreviewRepository$normalizeDistinctPreviewUrlsForRemote$1) == false) goto L7;
        MessageDocPreviewRepository$normalizeDistinctPreviewUrlsForRemote$1 r100 = (MessageDocPreviewRepository$normalizeDistinctPreviewUrlsForRemote$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        long r104 = r100.J$0;
        List r113 = (List) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L55:
        r104 = r104 + 500;
        g.f302903a.getClass();
        List r114 = g.b(r113);
        if (g.c() == false) goto L49;
    L57:
        return r114;
    L49:
        if (r114.isEmpty() == false) goto L57;
        if (r104 >= 3000) goto L57;
        r100.L$0 = r113;
        r100.J$0 = r104;
        r100.label = 1;
        if (DelayKt.delay(500, r100) != r102) goto L55;
        return r102;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        List<String> r115 = r110;
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
        Iterator<T> r117 = r115.iterator();
    L16:
        if (r117.hasNext() == false) goto L18;
        r116.add(l.a((String) r117.next()));
        goto L16
    L18:
        ArrayList r118 = new ArrayList();
        Iterator r119 = r116.iterator();
    L20:
        if (r119.hasNext() == false) goto L24;
        Object r105 = r119.next();
        if ((!StringsKt.isBlank((String) r105)) == false) goto L20;
        r118.add(r105);
        goto L20
    L24:
        r113 = CollectionsKt.distinct(r118);
        g.f302903a.getClass();
        r114 = g.b(r113);
        if (r114.isEmpty() == false) goto L57;
        if ((!r113.isEmpty()) == false) goto L57;
        if (g.c() == true) goto L57;
        if (g.c() == false) goto L33;
    L47:
        r104 = 0;
        goto L49
    L33:
        if (g.f302904b.compareAndSet(false, true) == false) goto L47;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L37
        FLogger.f375446a.i("MessageDocPreviewDomainMatcher", "requestPreviewUrlRulesIfNeeded request im launch");     // Catch: Throwable -> L37
        AuthModelDelegate.f297134b.t("MessageDocPreviewDomainMatcher", SetsKt.setOf(LaunchBiz.IM), true);     // Catch: Throwable -> L37
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L37
    L39:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L43;
        g.f302904b.set(false);
        FLogger.f375446a.i("MessageDocPreviewDomainMatcher", "requestPreviewUrlRulesIfNeeded failed=" + r108.getMessage());
    L43:
        if (Result.m9456isSuccessimpl(r107) == false) goto L47;
        Unit r109 = (Unit) r107;
        g.f302903a.getClass();
        if (g.c() == true) goto L47;
        g.f302904b.set(false);
    L37:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new MessageDocPreviewRepository$normalizeDistinctPreviewUrlsForRemote$1(this, r111);
        goto L8
    }

    public static String c(Map r100, String r101, List r102) {
        String r103 = l.a(r101);
        Iterator r104 = r100.keySet().iterator();
    L3:
        Object r105 = null;
        if (r104.hasNext() == false) goto L14;
        Object r106 = r104.next();
        String r107 = (String) r106;
        if (Intrinsics.areEqual(r107, r101) == false) goto L8;
    L11:
        boolean r108 = true;
    L12:
        if (r108 == false) goto L3;
    L15:
        String r109 = (String) r106;
        if (r109 != null) goto L18;
    L23:
        Map.Entry r110 = b(r100, r103);
        if (r110 == null) goto L34;
        String r111 = (String) r110.getKey();
        if (r111 == null) goto L34;
        if ((!StringsKt.isBlank(r111)) == true) goto L31;
        r111 = null;
    L31:
        if (r111 == null) goto L34;
        return r111;
    L34:
        if (r102.size() == 1) goto L36;
        return null;
    L36:
        if (r100.size() != 1) goto L54;
        Iterator r112 = r100.keySet().iterator();
    L39:
        if (r112.hasNext() == false) goto L44;
        Object r113 = r112.next();
        if ((!StringsKt.isBlank((String) r113)) == false) goto L39;
        r105 = r113;
    L44:
        return (String) r105;
    L54:
        return null;
    L18:
        if ((!StringsKt.isBlank(r109)) == true) goto L21;
        r109 = null;
    L21:
        if (r109 == null) goto L23;
        return r109;
    L8:
        if (Intrinsics.areEqual(l.a(r107), r103) == true) goto L11;
        r108 = false;
        goto L12
    L14:
        r106 = null;
        goto L15
    }

    public static String d(Map r100, String r101, List r102) {
        String r103 = l.a(r101);
        String r104 = (String) r100.get(r101);
        Object r105 = null;
        if (r104 != null) goto L5;
    L10:
        String r106 = (String) r100.get(r103);
        if (r106 != null) goto L13;
    L18:
        Iterator r107 = r100.entrySet().iterator();
    L20:
        if (r107.hasNext() == false) goto L24;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(l.a((String) ((Map.Entry) r108).getKey()), r103) == false) goto L20;
    L25:
        Map.Entry r109 = (Map.Entry) r108;
        if (r109 == null) goto L35;
        String r110 = (String) r109.getValue();
        if (r110 == null) goto L35;
        if ((!StringsKt.isBlank(r110)) == true) goto L33;
        r110 = null;
    L33:
        if (r110 == null) goto L35;
        return r110;
    L35:
        Map.Entry r111 = b(r100, r103);
        if (r111 == null) goto L46;
        String r112 = (String) r111.getValue();
        if (r112 == null) goto L46;
        if ((!StringsKt.isBlank(r112)) == true) goto L43;
        r112 = null;
    L43:
        if (r112 == null) goto L46;
        return r112;
    L46:
        if (r102.size() == 1) goto L48;
        return null;
    L48:
        if (r100.size() != 1) goto L64;
        Iterator r113 = r100.values().iterator();
    L51:
        if (r113.hasNext() == false) goto L56;
        Object r114 = r113.next();
        if ((!StringsKt.isBlank((String) r114)) == false) goto L51;
        r105 = r114;
    L56:
        return (String) r105;
    L64:
        return null;
    L24:
        r108 = null;
        goto L25
    L13:
        if ((!StringsKt.isBlank(r106)) == true) goto L16;
        r106 = null;
    L16:
        if (r106 == null) goto L18;
        return r106;
    L5:
        if ((!StringsKt.isBlank(r104)) == true) goto L8;
        r104 = null;
    L8:
        if (r104 == null) goto L10;
        return r104;
    }

    public final Object a(String r110, List<String> r210, Continuation<? super a> r211) {
        if ((r211 instanceof MessageDocPreviewRepository$fetchRemotePreviews$1) == false) goto L7;
        MessageDocPreviewRepository$fetchRemotePreviews$1 r100 = (MessageDocPreviewRepository$fetchRemotePreviews$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        Map r105 = (Map) r100.L$5;
        List r106 = (List) r100.L$4;
        Set r107 = (Set) r100.L$3;
        LinkedHashMap r108 = (LinkedHashMap) r100.L$2;
        List r109 = (List) r100.L$1;
        String r111 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L112:
        Map r112 = (Map) r102;
        LinkedHashMap r113 = new LinkedHashMap();
        Iterator r114 = r109.iterator();
    L114:
        if (r114.hasNext() == false) goto L134;
        String r115 = (String) r114.next();
        String r116 = d(r108, r115, r109);
        if (r116 == null) goto L114;
        h r117 = (h) r112.get(r116);
        if (r117 == null) goto L121;
    L126:
        if (r117 == null) goto L114;
        String r118 = c(r108, r115, r109);
        if (r118 != null) goto L130;
        r118 = r115;
    L130:
        String r119 = l.a(r115);
        String r120 = r117.f302911c;
        if (StringsKt.isBlank(r120) == false) goto L133;
        r120 = r118;
    L133:
        r113.put(r119, h.a(r117, null, r120, r118, 4091));
        goto L114
    L121:
        if (r109.size() == 1) goto L123;
    L125:
        r117 = null;
        goto L126
    L123:
        if (r112.values().size() != 1) goto L125;
        r117 = (h) CollectionsKt.firstOrNull(r112.values());
        goto L126
    L134:
        f.f302900a.getClass();
        Intrinsics.checkNotNullParameter(r111, "messageId");
        Intrinsics.checkNotNullParameter(r113, "previewsByUrl");
        if (StringsKt.isBlank(r111) == false) goto L137;
    L163:
        FLogger.f375446a.i("MessageDocPreviewRepository", "fetchRemotePreviews entityCount=" + r112.size() + ", renderCount=" + r113.size());
        return new a(r113, r107);
    L137:
        if (r113.isEmpty() == true) goto L163;
        Iterator r121 = r113.entrySet().iterator();
    L141:
        if (r121.hasNext() == false) goto L163;
        Map.Entry r122 = (Map.Entry) r121.next();
        String r123 = (String) r122.getKey();
        h r124 = (h) r122.getValue();
        f r125 = f.f302900a;
        r125.getClass();
        Intrinsics.checkNotNullParameter(r111, "messageId");
        Intrinsics.checkNotNullParameter(r123, "url");
        Intrinsics.checkNotNullParameter(r124, "preview");
        String r126 = f.a(r111, r123);
        if (r126 == null) goto L141;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L157
        Keva r128 = f.d();     // Catch: Throwable -> L157
        String r129 = r124.f302911c;     // Catch: Throwable -> L157
        if (StringsKt.isBlank(r129) == false) goto L148;
        r129 = r123;
    L148:
        String r130 = r124.f302921m;     // Catch: Throwable -> L157
        if (r130 == null) goto L167;
        r123 = r130;
    L167:
        r128.storeString(r126, f.j(h.a(r124, null, r129, r123, 4091)).toString());     // Catch: Throwable -> L155
        r125.h(r126);     // Catch: Throwable -> L155
        Object r131 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L155
    L160:
        Throwable r132 = Result.m9452exceptionOrNullimpl(r131);
        if (r132 == null) goto L141;
        FLogger.f375446a.w("MessageDocPreviewCache", "store failed, key=" + r126 + ", err=" + r132.getMessage());
    L155:
        th = th;
    L159:
        Result.Companion r133 = Result.Companion;
        r131 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L157:
        th = th;
        goto L159
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        LinkedHashMap r134 = (LinkedHashMap) r100.L$5;
        LinkedHashMap r135 = (LinkedHashMap) r100.L$4;
        List r136 = (List) r100.L$3;
        Map r137 = (Map) r100.L$2;
        List r138 = (List) r100.L$1;
        String r139 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L63:
        r134.putAll((Map) r102);
        r108 = r135;
        r109 = r138;
    L65:
        List r140 = r109;
        ArrayList r141 = new ArrayList();
        Iterator r142 = r140.iterator();
    L67:
        if (r142.hasNext() == false) goto L74;
        String r143 = (String) r142.next();
        if (d(r108, r143, r109) != null) goto L72;
        r143 = null;
    L72:
        if (r143 == null) goto L67;
        r141.add(r143);
        goto L67
    L74:
        ArrayList r144 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r141, 10));
        Iterator r145 = r141.iterator();
    L76:
        if (r145.hasNext() == false) goto L78;
        r144.add(l.a((String) r145.next()));
        goto L76
    L78:
        Set r146 = CollectionsKt.toSet(r144);
        ArrayList r147 = new ArrayList();
        Iterator r148 = r140.iterator();
    L80:
        if (r148.hasNext() == false) goto L85;
        String r149 = d(r108, (String) r148.next(), r109);
        if (r149 == null) goto L80;
        r147.add(r149);
        goto L80
    L85:
        List r150 = CollectionsKt.distinct(r147);
        FLogger.f375446a.i("MessageDocPreviewRepository", "fetchRemotePreviews previewIdCount=" + r150.size() + ", cachedPreviewIdCount=" + r137.size() + ", proxyUrlCount=" + r136.size() + ", rawMapSize=" + r108.size());
        if (r150.isEmpty() == true) goto L88;
        ArrayList r151 = new ArrayList();
        Iterator r152 = r140.iterator();
    L91:
        if (r152.hasNext() == false) goto L102;
        String r153 = (String) r152.next();
        String r154 = d(r108, r153, r109);
        if (r154 == null) goto L99;
        String r155 = c(r108, r153, r109);
        if (r155 == null) goto L98;
        r153 = r155;
    L98:
        Pair r156 = TuplesKt.to(r154, r153);
    L100:
        if (r156 == null) goto L91;
        r151.add(r156);
        goto L91
    L99:
        r156 = null;
        goto L100
    L102:
        Map r157 = MapsKt.toMap(r151);
        r100.L$0 = r139;
        r100.L$1 = r109;
        r100.L$2 = r108;
        r100.L$3 = r146;
        r100.L$4 = r150;
        r100.L$5 = r157;
        r100.label = 3;
        kotlinx.coroutines.j r158 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r158.C();
        int r159 = k.f302933a;
        b r160 = new b(r158);
        Intrinsics.checkNotNullParameter(r150, "previewIds");
        Intrinsics.checkNotNullParameter(r157, "fallbackUrlsByPreviewId");
        Intrinsics.checkNotNullParameter(r160, "callback");
        IMessageDocPreviewService r161 = k.a();
        if (r161 == null) goto L105;
        r161.c(r150, r157, r160);
    L106:
        r102 = r158.B();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L109;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L109:
        if (r102 != r103) goto L111;
        return r103;
    L111:
        r107 = r146;
        r111 = r139;
        goto L112
    L105:
        r160.invoke(MapsKt.emptyMap());
        goto L106
    L88:
        return new a(MapsKt.emptyMap(), r146);
    L17:
        String r162 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r163 = r102;
        String r164 = r162;
    L30:
        r138 = (List) r163;
        if (StringsKt.isBlank(r164) == true) goto L166;
        if (r138.isEmpty() == true) goto L166;
        f.f302900a.getClass();
        Map r165 = f.c(r164, r138);
        LinkedHashMap r166 = new LinkedHashMap(MapsKt.mapCapacity(r165.size()));
        Iterator r167 = r165.entrySet().iterator();
    L37:
        if (r167.hasNext() == false) goto L39;
        Map.Entry r168 = (Map.Entry) r167.next();
        r166.put(r168.getKey(), ((h) r168.getValue()).f302909a);
        goto L37
    L39:
        LinkedHashMap r169 = new LinkedHashMap();
        Iterator r170 = r166.entrySet().iterator();
    L41:
        if (r170.hasNext() == false) goto L45;
        Map.Entry r171 = (Map.Entry) r170.next();
        if ((!StringsKt.isBlank((String) r171.getValue())) == false) goto L41;
        r169.put(r171.getKey(), r171.getValue());
        goto L41
    L45:
        ArrayList r172 = new ArrayList();
        Iterator r173 = r138.iterator();
    L47:
        if (r173.hasNext() == false) goto L57;
        Object r174 = r173.next();
        String r175 = d(r169, (String) r174, r138);
        if (r175 != null) goto L51;
    L54:
        boolean r176 = true;
    L55:
        if (r176 == false) goto L47;
        r172.add(r174);
        goto L47
    L51:
        if (StringsKt.isBlank(r175) == true) goto L54;
        r176 = false;
        goto L55
    L57:
        r135 = new LinkedHashMap();
        r135.putAll(r169);
        if ((!r172.isEmpty()) == false) goto L64;
        CoroutineDispatcher r177 = Dispatchers.getIO();
        MessageDocPreviewRepository$fetchRemotePreviews$2 r178 = new MessageDocPreviewRepository$fetchRemotePreviews$2(r172, r164, null);
        r100.L$0 = r164;
        r100.L$1 = r138;
        r100.L$2 = r169;
        r100.L$3 = r172;
        r100.L$4 = r135;
        r100.L$5 = r135;
        r100.label = 2;
        Object r179 = BuildersKt.withContext(r177, r178, r100);
        if (r179 != r103) goto L62;
        return r103;
    L62:
        r137 = r169;
        r134 = r135;
        r139 = r164;
        r102 = r179;
        r136 = r172;
        goto L63
    L64:
        r137 = r169;
        r108 = r135;
        r109 = r138;
        r136 = r172;
        r139 = r164;
    L166:
        return new a(MapsKt.emptyMap(), SetsKt.emptySet());
    L18:
        ResultKt.throwOnFailure(r102);
        IMessageDocPreviewService r180 = k.a();
        if (r180 != null) goto L21;
    L23:
        boolean r181 = false;
    L24:
        if (r181 == false) goto L26;
        r164 = r110;
        r100.L$0 = r164;
        r100.label = 1;
        r163 = f(r210, r100);
        if (r163 != r103) goto L30;
        return r103;
    L26:
        return new a(MapsKt.emptyMap(), SetsKt.emptySet());
    L21:
        if (r180.isSupported() != true) goto L23;
        r181 = true;
    L7:
        r100 = new MessageDocPreviewRepository$fetchRemotePreviews$1(this, r211);
        goto L8
    }
}
