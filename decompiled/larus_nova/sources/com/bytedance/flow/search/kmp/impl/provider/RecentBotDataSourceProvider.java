package com.bytedance.flow.search.kmp.impl.provider;

import com.bytedance.flow.search.kmp.api.model.FlowQuery;
import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.SearchCursor;
import com.bytedance.flow.search.kmp.api.model.payload.AutoLoadMorePayload;
import com.bytedance.flow.search.kmp.api.model.payload.SingleLinePayload;
import com.larus.im.bean.conversation.ConversationArchiveFilter;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import wc9.l;
import wc9.o;

/* JADX INFO: loaded from: classes3.dex */
public final class RecentBotDataSourceProvider implements vv5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wc9.e f243635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f243636b;

    public static final class a {
    }

    static {
    }

    public RecentBotDataSourceProvider() {
    }

    @Override // vv5.a
    public final void reset() {
        this.f243635a = null;
        this.f243636b = false;
    }

    @Override // vv5.a
    public final Object a(FlowQuery r210, Continuation<? super vv5.b> r211) {
        FlowQuery r100 = r210;
        if ((r211 instanceof RecentBotDataSourceProvider$search$1) == false) goto L7;
        RecentBotDataSourceProvider$search$1 r101 = (RecentBotDataSourceProvider$search$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        int r106 = 3;
        ConversationArchiveFilter r107 = null;
        int r110 = 1;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        int r108 = r101.I$2;
        int r109 = r101.I$1;
        int r111 = r101.I$0;
        wc9.e r112 = (wc9.e) r101.L$2;
        List r113 = (List) r101.L$1;
        FlowQuery r114 = (FlowQuery) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Object r115 = r103;
        int r116 = r108;
        r100 = r114;
        RecentBotDataSourceProvider r117 = this;
    L33:
        wc9.j r118 = (wc9.j) r115;
        if (r118 != null) goto L36;
        int r119 = 1;
    L63:
        r117.f243635a = r112;
        if (r111 == 0) goto L66;
        boolean r120 = true;
    L67:
        r117.f243636b = r120;
        if (r119 != 0) goto L70;
    L73:
        List r121 = r113;
        ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
        Iterator r123 = r121.iterator();
    L74:
        String r124 = "";
        if (r123.hasNext() == false) goto L107;
        l r125 = (l) r123.next();
        wc9.e r126 = r125.f559248a;
        if (r126 == null) goto L83;
        IconImage r127 = r126.f559199b;
        if (r127 == null) goto L83;
        ImageObj r128 = r127.imageThumb;
        if (r128 == null) goto L83;
        String r129 = r128.url;
    L84:
        if (r129 != null) goto L86;
        String r130 = "";
    L87:
        if (r126 == null) goto L89;
        String r131 = r126.f559200c;
    L90:
        if (r131 != null) goto L92;
        String r132 = "";
    L93:
        int r133 = ew5.a.f474601a;
        List<Message> r134 = r125.f559249b;
        if (r134 == null) goto L98;
        Message r135 = (Message) CollectionsKt.firstOrNull(r134);
        if (r135 == null) goto L98;
        Long r136 = Boxing.boxLong(r135.getCreateTime());
    L99:
        if (r126 == null) goto L101;
        Long r137 = r126.f559201d;
    L102:
        long r138 = ew5.a.a(r136, r137);
        if (r126 == null) goto L105;
        String r212 = r126.f559198a;
    L106:
        r122.add(new FlowSearchData("bot", 103, new SingleLinePayload(r130, r132, r138, r212, null, null, 112)));
        goto L74
    L105:
        r212 = null;
        goto L106
    L101:
        r137 = null;
    L98:
        r136 = null;
        goto L99
    L92:
        r132 = r131;
        goto L93
    L89:
        r131 = null;
        goto L90
    L86:
        r130 = r129;
    L83:
        r129 = null;
        goto L84
    L107:
        String r139 = (String) CollectionsKt.firstOrNull(r100.f243271b);
        if (r139 == null) goto L111;
        r124 = r139;
    L111:
        boolean r140 = r117.f243636b;
        SearchCursor.b r141 = SearchCursor.Companion;
        wc9.e r142 = r117.f243635a;
        if (r142 == null) goto L114;
        String r143 = r142.f559198a;
    L115:
        r141.getClass();
        return new vv5.b(CollectionsKt.plus(r122, new FlowSearchData("bot", 110, new AutoLoadMorePayload(r124, r140, SearchCursor.b.a(r143)))), false, 2);
    L114:
        r143 = null;
        goto L115
    L70:
        if (r113.isEmpty() == false) goto L73;
        return new vv5.b(null, true, 1 == true ? 1 : 0);
    L66:
        r120 = false;
        goto L67
    L36:
        List<l> r144 = r118.f559241a;
        if (r144 != null) goto L39;
        r144 = CollectionsKt.emptyList();
    L39:
        r111 = !r118.f559242b ? 1 : 0;
        if ((!r144.isEmpty()) == false) goto L42;
        r112 = ((l) CollectionsKt.last(r144)).f559248a;
    L42:
        ArrayList r145 = new ArrayList();
        Iterator<T> r146 = r144.iterator();
    L44:
        if (r146.hasNext() == false) goto L57;
        Object r147 = r146.next();
        wc9.e r148 = ((l) r147).f559248a;
        if (r148 == null) goto L53;
        Integer r149 = r148.f559219v;
        if (r149 == null) goto L53;
        if (r149.intValue() != 2) goto L53;
        boolean r150 = true;
    L54:
        if (r150 == false) goto L44;
        r145.add(r147);
    L53:
        r150 = false;
        goto L54
    L57:
        r113.addAll(r145);
        if (r113.size() >= 30) goto L62;
        if (r111 == 0) goto L62;
        r116 = r116 + 1;
        r106 = 3;
        r107 = null;
        r110 = 1;
    L27:
        if (r116 >= r106) goto L62;
        r101.L$0 = r100;
        r101.L$1 = r113;
        r101.L$2 = r112;
        r101.I$0 = r111;
        r101.I$1 = r109;
        r101.I$2 = r116;
        r101.label = r110;
        SafeContinuation r151 = new SafeContinuation(IntrinsicsKt.intercepted(r101));
        o r152 = new o(r112, 60, r107, 9);
        int r153 = m4a.a.f511902a;
        i r154 = new i(r151);
        Intrinsics.checkNotNullParameter(r152, "request");
        Intrinsics.checkNotNullParameter(r152, "request");
        com.larus.im.d.d().getConversationList(r152, r154);
        r115 = r151.getOrThrow();
        if (r115 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L31;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L31:
        if (r115 != r104) goto L33;
        return r104;
    L119:
        if (r115 != r104) goto L33;
    L62:
        r119 = r109;
        goto L63
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        if (r100.f243271b.size() != 1) goto L118;
        if (r100.f243271b.contains("bot") == false) goto L118;
        if (r100.f243273d == null) goto L22;
        boolean r155 = true;
    L23:
        if (r155 == false) goto L25;
        wc9.e r156 = this.f243635a;
    L26:
        r117 = this;
        r112 = r156;
        r113 = new ArrayList();
        r116 = 0;
        r109 = 0;
        r111 = 1;
        goto L27
    L25:
        r156 = null;
        goto L26
    L22:
        r155 = false;
    L118:
        return new vv5.b(null, false, 3);
    L7:
        r101 = new RecentBotDataSourceProvider$search$1(this, r211);
        goto L8
    }
}
