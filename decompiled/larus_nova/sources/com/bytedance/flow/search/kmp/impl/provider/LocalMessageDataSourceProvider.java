package com.bytedance.flow.search.kmp.impl.provider;

import com.bytedance.flow.search.kmp.api.model.FlowQuery;
import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.payload.AutoLoadMorePayload;
import com.bytedance.flow.search.kmp.api.model.payload.MessagePayload;
import com.bytedance.flow.search.kmp.api.model.payload.model.MessageSearchResult;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.im.bean.conversation.ConversationArchiveFilter;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageListRequest;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.core.conversation.FtsSearchParam;
import com.larus.im.internal.core.conversation.FtsSearchResult;
import com.larus.im.internal.delegate.y0;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import ic8.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class LocalMessageDataSourceProvider implements vv5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f243630c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f243631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f243632b;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes19.dex */
    public static final class b implements IIMCallback<List<? extends wc9.e>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<List<wc9.e>> f243633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LocalMessageDataSourceProvider f243634b;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return true;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f243634b.f243631a = true;
            Continuation<List<wc9.e>> r101 = this.f243633a;
            Result.Companion r102 = Result.Companion;
            r101.resumeWith(Result.m9449constructorimpl(CollectionsKt.emptyList()));
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(List<? extends wc9.e> r100) {
            List<? extends wc9.e> r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            this.f243633a.resumeWith(Result.m9449constructorimpl(r101));
        }

        public b(SafeContinuation r100, LocalMessageDataSourceProvider r101) {
            this.f243633a = r100;
            this.f243634b = r101;
        }
    }

    /* JADX INFO: loaded from: classes19.dex */
    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((MessageSearchResult) r101).f243519d), Long.valueOf(((MessageSearchResult) r100).f243519d));
        }
    }

    static {
    }

    @Override // vv5.a
    public final void reset() {
        this.f243631a = false;
        this.f243632b.clear();
    }

    public LocalMessageDataSourceProvider() {
        this.f243632b = new LinkedHashSet();
    }

    public static boolean f(wc9.e r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Integer r101 = r100.f559217t;
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.intValue() != 3) goto L17;
        Integer r102 = r100.f559207j;
        if (r102 != null) goto L14;
        return false;
    L14:
        if (r102.intValue() != 2) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.ArrayList, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r41v0, types: [com.bytedance.flow.search.kmp.impl.provider.LocalMessageDataSourceProvider] */
    @Override // vv5.a
    public final Object a(FlowQuery r410, Continuation<? super vv5.b> r411) {
        if ((r411 instanceof LocalMessageDataSourceProvider$search$1) == false) goto L7;
        LocalMessageDataSourceProvider$search$1 r100 = (LocalMessageDataSourceProvider$search$1) r411;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = false;
        int r110 = 3;
        List r111 = null;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L19;
        if (r104 == 2) goto L18;
        if (r104 == 3) goto L17;
        if (r104 != 4) goto L16;
        List r106 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L131:
        long r107 = fuc.a.a().f478932a.getEpochSecond() - 15552000;
        List r108 = CollectionsKt.plus(r106, (List) r102);
        ArrayList r109 = new ArrayList();
        Iterator r112 = r108.iterator();
    L133:
        if (r112.hasNext() == false) goto L140;
        Object r113 = r112.next();
        if (((MessageSearchResult) r113).f243519d < r107) goto L137;
        boolean r114 = true;
    L138:
        if (r114 == false) goto L133;
        r109.add(r113);
        goto L133
    L137:
        r114 = false;
        goto L138
    L140:
        List r115 = CollectionsKt.sortedWith(r109, new c());
        List r116 = CollectionsKt.take(r115, 3);
        if (r115.size() <= 3) goto L143;
        boolean r117 = true;
    L144:
        List r118 = r116;
        ?? r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10));
        Iterator r120 = r118.iterator();
    L146:
        if (r120.hasNext() == false) goto L159;
        MessageSearchResult r121 = (MessageSearchResult) r120.next();
        String r122 = r121.f243518c;
        wc9.e r123 = r121.f243525j;
        if (r123 != null) goto L163;
        String r124 = "";
    L158:
        r119.add(new FlowSearchData("message", 1, new MessagePayload(r122, r121, r124, true)));
        goto L146
    L163:
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L152
        Intrinsics.checkNotNullParameter(r123, "conv");     // Catch: Throwable -> L152
        Object r126 = Result.m9449constructorimpl(IAIChatService.f365899a.U7(r123));     // Catch: Throwable -> L152
    L155:
        if (Result.m9455isFailureimpl(r126) == false) goto L157;
        r126 = "";
    L157:
        r124 = (String) r126;
    L152:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L155
    L159:
        if (r117 == false) goto L162;
        r119 = CollectionsKt.plus(r119, new FlowSearchData("message", 110, new AutoLoadMorePayload("message", true, 4)));
    L162:
        return new vv5.b(r119, this.f243631a);
    L143:
        r117 = false;
        goto L144
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        FtsSearchResult r128 = (FtsSearchResult) r100.L$1;
        FlowQuery r129 = (FlowQuery) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L121:
        List r130 = (List) r102;
        if (r128 == null) goto L124;
        List r131 = r128.getData();
    L125:
        if (r131 != null) goto L127;
        r131 = CollectionsKt.emptyList();
    L127:
        String r132 = r129.f243270a;
        r100.L$0 = r130;
        r100.L$1 = null;
        r100.label = 4;
        Object r133 = b(r131, r130, r132, r100);
        if (r133 != r103) goto L130;
        return r103;
    L130:
        r102 = r133;
        r106 = r130;
        goto L131
    L124:
        r131 = null;
        goto L125
    L18:
        FtsSearchResult r134 = (FtsSearchResult) r100.L$1;
        r129 = (FlowQuery) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L110:
        FtsSearchResult r135 = (FtsSearchResult) r102;
    L112:
        if (r134 == null) goto L114;
        List r136 = r134.getData();
    L115:
        if (r136 != null) goto L117;
        r136 = CollectionsKt.emptyList();
    L117:
        String r137 = r129.f243270a;
        r100.L$0 = r129;
        r100.L$1 = r135;
        r100.L$2 = null;
        r100.label = 3;
        Object r138 = c(r136, r137, r100);
        if (r138 != r103) goto L120;
        return r103;
    L120:
        FtsSearchResult r412 = r135;
        r102 = r138;
        r128 = r412;
        goto L121
    L114:
        r136 = null;
        goto L115
    L19:
        ConversationArchiveFilter r139 = (ConversationArchiveFilter) r100.L$2;
        String r140 = (String) r100.L$1;
        FlowQuery r141 = (FlowQuery) r100.L$0;
        ResultKt.throwOnFailure(r102);
        ConversationArchiveFilter r310 = r139;
    L99:
        r134 = (FtsSearchResult) r102;
        if (r140.length() != 0) goto L102;
        boolean r142 = true;
    L103:
        if (r142 == false) goto L111;
        String r143 = r141.f243270a;
        r100.L$0 = r141;
        r100.L$1 = r134;
        r100.L$2 = null;
        r100.label = 2;
        SafeContinuation r144 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        int r145 = m4a.a.f511902a;
        FtsSearchParam r146 = new FtsSearchParam(r143, true, Long.MAX_VALUE, 30, true, null, null, null, r310, 224, null);
        g r147 = new g(r144, this);
        Intrinsics.checkNotNullParameter(r146, "param");
        Intrinsics.checkNotNullParameter(r146, "param");
        com.larus.im.d.d().searchConversationByFts(r146, r147);
        r102 = r144.getOrThrow();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L107;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L107:
        if (r102 != r103) goto L109;
        return r103;
    L109:
        r129 = r141;
        goto L110
    L111:
        r135 = null;
        r129 = r141;
        goto L112
    L102:
        r142 = false;
        goto L103
    L20:
        ResultKt.throwOnFailure(r102);
        if (StringsKt.isBlank(r410.f243270a) == false) goto L25;
        return new vv5.b(r111, r105, r110);
    L25:
        if (r410.f243271b.contains("message") == false) goto L27;
        this.f243631a = false;
        this.f243632b.clear();
        Map<String, List<String>> r148 = r410.f243274e;
        if (r148 == null) goto L31;
        List<String> r149 = r148.get("search_range");
    L32:
        if (r149 != null) goto L34;
        r149 = CollectionsKt.emptyList();
    L34:
        String r150 = (String) CollectionsKt.firstOrNull(r149);
        if (r150 != null) goto L38;
        r150 = "";
    L38:
        if (Intrinsics.areEqual(r150, "real_chat") == true) goto L40;
        int r151 = com.bytedance.flow.search.kmp.impl.util.a.f243663a;
        LaunchInfo r152 = AuthModelDelegate.f297134b.x().getValue();
        if (r152 == null) goto L45;
        String r153 = r152.W();
        if (r153 == null) goto L45;
    L46:
        String r154 = com.larus.im.internal.delegate.b.f348193b.getUserId();
        int r155 = r150.hashCode();
        if (r155 == (-594329379)) goto L60;
        if (r155 == (-594329011)) goto L57;
        if (r155 != 0) goto L52;
        r150.equals("");
    L61:
        r154 = "";
    L69:
        r140 = r154;
    L70:
        if (r140 != null) goto L74;
        return new vv5.b(r111, r105, r110);
    L74:
        if (y0.l() == true) goto L77;
        ConversationArchiveFilter r156 = ConversationArchiveFilter.ALL;
    L80:
        String r157 = r410.f243270a;
        r100.L$0 = r410;
        r100.L$1 = r140;
        r100.L$2 = r156;
        r100.label = 1;
        if (r140.length() != 0) goto L83;
        boolean r158 = true;
    L84:
        if (r158 == false) goto L86;
        String r210 = null;
    L87:
        SafeContinuation r159 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        int r160 = m4a.a.f511902a;
        int r211 = com.bytedance.flow.search.kmp.impl.util.g.f243670a;
        z2 r212 = z2.f365865a;
        if (r212.getChatListSearchConfig().f482396c == true) goto L90;
    L92:
        boolean r213 = false;
    L93:
        FtsSearchParam r161 = new FtsSearchParam(r157, true, Long.MAX_VALUE, 30, r213, null, null, r210, r156, 96, null);
        h r162 = new h(r159, this);
        Intrinsics.checkNotNullParameter(r161, "query");
        Intrinsics.checkNotNullParameter(r161, "query");
        com.larus.im.d.e().searchMessageByFts(r161, r162);
        Object r163 = r159.getOrThrow();
        if (r163 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L96;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L96:
        if (r163 != r103) goto L98;
        return r103;
    L98:
        r141 = r410;
        r310 = r156;
        r102 = r163;
        goto L99
    L90:
        if (r212.searchForceByLike() == true) goto L92;
        r213 = true;
        goto L93
    L86:
        r210 = r140;
        goto L87
    L83:
        r158 = false;
        goto L84
    L77:
        if (Intrinsics.areEqual(r150, "select_archive_conv") == false) goto L79;
        r156 = ConversationArchiveFilter.INCLUDE;
        goto L80
    L79:
        r156 = ConversationArchiveFilter.ALL;
        goto L80
    L52:
        if (r155 != 987015101) goto L61;
        r150.equals("no_limit");
        goto L61
    L57:
        if (r150.equals("from_me") == true) goto L69;
    L60:
        if (r150.equals("from_ai") == false) goto L61;
        if ((!StringsKt.isBlank(r153)) == true) goto L66;
        r153 = null;
    L66:
        if (r153 != null) goto L68;
        r140 = null;
        goto L70
    L68:
        r154 = r153;
    L45:
        r153 = "";
        goto L46
    L40:
        return new vv5.b(r111, r105, r110);
    L31:
        r149 = null;
        goto L32
    L27:
        return new vv5.b(r111, r105, r110);
    L7:
        r100 = new LocalMessageDataSourceProvider$search$1(this, r411);
        goto L8
    }

    public final Object d(List<Message> r100, Continuation<? super Map<String, wc9.e>> r101) {
        if ((r101 instanceof LocalMessageDataSourceProvider$fetchConversationMap$1) == false) goto L7;
        LocalMessageDataSourceProvider$fetchConversationMap$1 r102 = (LocalMessageDataSourceProvider$fetchConversationMap$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        List r107 = (List) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L29:
        List r108 = (List) r104;
        LinkedHashMap r109 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r108, 10)), 16));
        Iterator r110 = r108.iterator();
    L31:
        if (r110.hasNext() == false) goto L33;
        Object r111 = r110.next();
        r109.put(((wc9.e) r111).f559198a, r111);
        goto L31
    L33:
        return r109;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        ArrayList r112 = new ArrayList();
        Iterator<T> r113 = r100.iterator();
    L16:
        if (r113.hasNext() == false) goto L20;
        String r114 = ((Message) r113.next()).getConversationId();
        if (r114 == null) goto L16;
        r112.add(r114);
        goto L16
    L20:
        List<String> r115 = CollectionsKt.distinct(r112);
        if (r115.isEmpty() == true) goto L23;
        r102.L$0 = r115;
        r102.label = 1;
        SafeContinuation r116 = new SafeContinuation(IntrinsicsKt.intercepted(r102));
        int r117 = m4a.a.f511902a;
        b r118 = new b(r116, this);
        Intrinsics.checkNotNullParameter(r115, "cvsIdList");
        Intrinsics.checkNotNullParameter(r115, "cvsIdList");
        com.larus.im.d.d().batchGetConversationByIds(r115, r118);
        r104 = r116.getOrThrow();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L27:
        if (r104 != r105) goto L29;
        return r105;
    L23:
        return MapsKt.emptyMap();
    L7:
        r102 = new LocalMessageDataSourceProvider$fetchConversationMap$1(this, r101);
        goto L8
    }

    public final Object c(List<Message> r210, String r310, Continuation<? super List<MessageSearchResult>> r311) {
        List<Message> r100 = r210;
        if ((r311 instanceof LocalMessageDataSourceProvider$buildMessageItems$1) == false) goto L7;
        LocalMessageDataSourceProvider$buildMessageItems$1 r101 = (LocalMessageDataSourceProvider$buildMessageItems$1) r311;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        String r106 = (String) r101.L$1;
        List<Message> r107 = (List) r101.L$0;
        ResultKt.throwOnFailure(r103);
        String r108 = r106;
        r100 = r107;
        Object r109 = r103;
    L21:
        Map r110 = (Map) r109;
        com.larus.im.internal.delegate.b r111 = com.larus.im.internal.delegate.b.f348193b;
        String r112 = r111.getUserId();
        String r113 = r111.h();
        ArrayList r114 = new ArrayList();
        Iterator<T> r115 = r100.iterator();
    L23:
        if (r115.hasNext() == false) goto L35;
        Object r116 = r115.next();
        Message r117 = (Message) r116;
        Map<String, String> r118 = r117.getExt();
        if (r118 == null) goto L27;
        String r119 = r118.get("wcb_message_hidden");
    L28:
        boolean r120 = false;
        if (Intrinsics.areEqual(r119, "true") == true) goto L33;
        String r121 = ew5.c.a(r117, r108);
        Locale r122 = Locale.ROOT;
        if (StringsKt.contains$default(r121.toLowerCase(r122), r108.toLowerCase(r122), false, 2, null) == false) goto L33;
        r120 = true;
    L33:
        if (r120 == false) goto L23;
        r114.add(r116);
        goto L23
    L27:
        r119 = null;
        goto L28
    L35:
        ArrayList r123 = new ArrayList();
        Iterator r124 = r114.iterator();
    L37:
        if (r124.hasNext() == false) goto L56;
        Message r125 = (Message) r124.next();
        String r126 = r125.getConversationId();
        if (r126 == null) goto L41;
        wc9.e r127 = (wc9.e) r110.get(r126);
    L43:
        if (f(r127) == false) goto L45;
        MessageSearchResult r128 = null;
    L54:
        if (r128 == null) goto L37;
        r123.add(r128);
        goto L37
    L45:
        if (r127 == null) goto L49;
        String r129 = r127.f559198a;
        if (r129 == null) goto L49;
        Boxing.boxBoolean(this.f243632b.add(r129));
    L49:
        String r130 = r125.getMessageId();
        if (r130 != null) goto L52;
        String r131 = "";
    L53:
        String r132 = n.g(r127, "");
        String r133 = ew5.c.a(r125, r108);
        int r134 = ew5.a.f474601a;
        r128 = new MessageSearchResult(r131, r132, r133, ew5.a.a(Boxing.boxLong(r125.getCreateTime()), null), null, CollectionsKt.listOf(r108), false, r125.getLocalIndex(), e(r125.getSenderId(), r112, r113, r127), r127, r125, 0, 14416);
        goto L54
    L52:
        r131 = r130;
        goto L53
    L41:
        r127 = null;
        goto L43
    L56:
        return r123;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        if (r210.isEmpty() == true) goto L17;
        r101.L$0 = r100;
        r108 = r310;
        r101.L$1 = r108;
        r101.label = 1;
        r109 = d(r100, r101);
        if (r109 != r104) goto L21;
        return r104;
    L17:
        return CollectionsKt.emptyList();
    L7:
        r101 = new LocalMessageDataSourceProvider$buildMessageItems$1(this, r311);
        goto L8
    }

    public static String e(String r100, String r101, String r102, wc9.e r103) {
        if (r100 != null) goto L4;
    L7:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        return "";
    L11:
        if (r103 != null) goto L13;
        return "";
    L13:
        Intrinsics.checkNotNullParameter(r103, "conv");
        boolean r105 = Intrinsics.areEqual(IAIChatService.f365899a.U7(r103), "default_new");
        if (Intrinsics.areEqual(r100, r101) == true) goto L28;
        if (r105 == false) goto L22;
        int r106 = com.bytedance.flow.search.kmp.impl.util.a.f243663a;
        wc9.e r107 = AuthModelDelegate.f297134b.u().getValue();
        if (r107 == null) goto L25;
        String r108 = r107.f559200c;
        if (r108 == null) goto L25;
        return r108;
    L25:
        return "";
    L22:
        String r109 = r103.f559200c;
        if (r109 == null) goto L25;
        return r109;
    L28:
        return r102;
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r104 = false;
        goto L9
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0142 -> B:49:0x0149). Please report as a decompilation issue!!! */
    public final Object b(List<wc9.e> r410, List<MessageSearchResult> r411, String r412, Continuation<? super List<MessageSearchResult>> r413) {
        if ((r413 instanceof LocalMessageDataSourceProvider$buildConversationItems$1) == false) goto L7;
        LocalMessageDataSourceProvider$buildConversationItems$1 r100 = (LocalMessageDataSourceProvider$buildConversationItems$1) r413;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        int r105 = 1;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        wc9.e r106 = (wc9.e) r100.L$5;
        Iterator r107 = (Iterator) r100.L$4;
        Collection r108 = (Collection) r100.L$3;
        String r109 = (String) r100.L$2;
        String r110 = (String) r100.L$1;
        String r111 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        LocalMessageDataSourceProvider r112 = this;
    L49:
        Message r113 = (Message) r102;
        if (r113 == null) goto L52;
        String r210 = ew5.c.a(r113, "");
    L53:
        Long r114 = r106.f559201d;
        if (r114 != null) goto L60;
        if (r113 == null) goto L58;
        r114 = Boxing.boxLong(r113.getCreateTime());
    L59:
        if (r114 != null) goto L60;
        long r115 = 0;
    L62:
        String r116 = r106.f559198a;
        String r211 = n.g(r106, "");
        int r117 = ew5.a.f474601a;
        long r212 = ew5.a.a(Boxing.boxLong(r115), null);
        List r310 = CollectionsKt.listOf(r111);
        List r311 = null;
        boolean r312 = false;
        if (r113 == null) goto L65;
        long r118 = r113.getLocalIndex();
    L66:
        long r313 = r118;
        if (r113 == null) goto L69;
        String r119 = r113.getSenderId();
    L70:
        r108.add(new MessageSearchResult(r116, r211, r210, r212, r310, r311, r312, r313, e(r119, r110, r109, r106), r106, r113, 0, 14432));
        LocalMessageDataSourceProvider r120 = r112;
        String r121 = r111;
        r105 = 1;
    L42:
        if (r107.hasNext() == false) goto L72;
        wc9.e r122 = (wc9.e) r107.next();
        String r123 = r122.f559198a;
        r100.L$0 = r121;
        r100.L$1 = r110;
        r100.L$2 = r109;
        r100.L$3 = r108;
        r100.L$4 = r107;
        r100.L$5 = r122;
        r100.label = r105;
        SafeContinuation r124 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        int r125 = m4a.a.f511902a;
        m4a.a.a(new MessageListRequest(r123, 0, 0, 2, 0, null, false, 118, null), new f(r124, r120));
        Object r126 = r124.getOrThrow();
        if (r126 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L46;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L46:
        if (r126 != r103) goto L48;
        return r103;
    L48:
        r111 = r121;
        r102 = r126;
        r112 = r120;
        r106 = r122;
        goto L49
    L72:
        return (List) r108;
    L69:
        r119 = null;
        goto L70
    L65:
        r118 = -1;
        goto L66
    L58:
        r114 = null;
    L60:
        r115 = r114.longValue();
        goto L62
    L52:
        r210 = "";
        goto L53
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (r410.isEmpty() == true) goto L17;
        ArrayList r127 = new ArrayList();
        Iterator<T> r128 = r411.iterator();
    L20:
        if (r128.hasNext() == false) goto L27;
        wc9.e r129 = ((MessageSearchResult) r128.next()).f243525j;
        if (r129 == null) goto L24;
        String r130 = r129.f559198a;
    L25:
        if (r130 == null) goto L20;
        r127.add(r130);
        goto L20
    L24:
        r130 = null;
        goto L25
    L27:
        Set r131 = CollectionsKt.toSet(r127);
        ArrayList r132 = new ArrayList();
        Iterator<T> r133 = r410.iterator();
    L29:
        if (r133.hasNext() == false) goto L40;
        Object r134 = r133.next();
        wc9.e r135 = (wc9.e) r134;
        if (f(r135) == false) goto L33;
    L37:
        boolean r136 = false;
    L38:
        if (r136 == false) goto L29;
        r132.add(r134);
        goto L29
    L33:
        if (this.f243632b.contains(r135.f559198a) == true) goto L37;
        if (r131.contains(r135.f559198a) == true) goto L37;
        r136 = true;
        goto L38
    L40:
        com.larus.im.internal.delegate.b r137 = com.larus.im.internal.delegate.b.f348193b;
        String r138 = r137.getUserId();
        String r139 = r137.h();
        r108 = new ArrayList();
        r107 = r132.iterator();
        r109 = r139;
        r110 = r138;
        r121 = r412;
        r120 = this;
        goto L42
    L17:
        return CollectionsKt.emptyList();
    L7:
        r100 = new LocalMessageDataSourceProvider$buildConversationItems$1(this, r413);
        goto L8
    }
}
