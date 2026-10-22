package com.bytedance.flow.search.kmp.impl.provider;

import com.bytedance.flow.search.kmp.api.model.FlowQuery;
import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.SearchCursor;
import com.bytedance.flow.search.kmp.api.model.payload.AutoLoadMorePayload;
import com.bytedance.flow.search.kmp.api.model.payload.MixedFeedPayload;
import com.bytedance.flow.search.kmp.api.model.payload.SingleLinePayload;
import com.bytedance.flow.search.kmp.api.spi.SearchMixedFeedService;
import com.bytedance.flow.search.kmp.impl.util.RecentTopicConversationProvider;
import com.larus.im.bean.conversation.ConversationArchiveFilter;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageListRequest;
import com.larus.nova.R;
import ic8.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import wc9.l;
import wc9.o;
import zv5.k;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultSearchRecentConvDataSourceProvider implements vv5.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f243622h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wc9.e f243623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f243624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f243625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Message f243626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f243627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<FlowSearchData> f243628f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<com.bytedance.flow.search.kmp.impl.util.e> f243629g;

    public static final class a {
    }

    static {
    }

    @Override // vv5.a
    public final void reset() {
        this.f243623a = null;
        this.f243624b = null;
        this.f243625c = Long.MAX_VALUE;
        this.f243626d = null;
        this.f243627e = false;
        ((ArrayList) this.f243628f).clear();
        this.f243629g = null;
    }

    public DefaultSearchRecentConvDataSourceProvider() {
        this.f243625c = Long.MAX_VALUE;
        this.f243628f = new ArrayList();
    }

    public static boolean c(FlowQuery r100) {
        if (r100.f243271b.size() == 1) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(CollectionsKt.firstOrNull(r100.f243271b), "contact") == false) goto L7;
        return true;
    }

    public static boolean d(String r100) {
        int r101 = com.bytedance.flow.search.kmp.impl.util.f.f243669a;
        return Intrinsics.areEqual(r100, yg9.a.a(new yg9.b(R.string.larus_new_chat_default)));
    }

    @Override // vv5.a
    public final Object a(FlowQuery r110, Continuation<? super vv5.b> r111) {
        if ((r111 instanceof DefaultSearchRecentConvDataSourceProvider$search$1) == false) goto L7;
        DefaultSearchRecentConvDataSourceProvider$search$1 r100 = (DefaultSearchRecentConvDataSourceProvider$search$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        int r105 = 3;
        List r106 = null;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        ResultKt.throwOnFailure(r112);
    L94:
        return r112;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r110 = (FlowQuery) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L88:
        vv5.b r113 = (vv5.b) r112;
        if (r113 == null) goto L91;
        return r113;
    L91:
        r100.L$0 = null;
        r100.label = 3;
        r112 = g(r110, r100);
        if (r112 != r102) goto L94;
        return r102;
    L17:
        ResultKt.throwOnFailure(r112);
    L50:
        return r112;
    L18:
        ResultKt.throwOnFailure(r112);
        boolean r107 = false;
        if ((!r110.f243271b.isEmpty()) == false) goto L27;
        if (r110.f243271b.contains("message") == true) goto L27;
        if (r110.f243271b.contains("contact") == true) goto L27;
        return new vv5.b(r106, r107, r105);
    L27:
        if ((!StringsKt.isBlank(r110.f243270a)) == false) goto L30;
    L45:
        String r114 = null;
    L46:
        if (r114 == null) goto L95;
        r100.label = 1;
        r112 = f(r110, r114, r100);
        if (r112 != r102) goto L50;
        return r102;
    L95:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L53
        pd6.b r116 = pd6.c.f528682a;     // Catch: Throwable -> L53
        Object r117 = Result.m9449constructorimpl((SearchMixedFeedService) pd6.c.a(Reflection.getOrCreateKotlinClass(SearchMixedFeedService.class)));     // Catch: Throwable -> L53
    L56:
        if (Result.m9455isFailureimpl(r117) == false) goto L58;
        r117 = null;
    L58:
        SearchMixedFeedService r118 = (SearchMixedFeedService) r117;
        if (r118 != null) goto L61;
    L63:
        boolean r108 = false;
    L65:
        if (r110.f243271b.isEmpty() == false) goto L67;
    L70:
        boolean r109 = true;
    L71:
        if (r109 == false) goto L73;
    L81:
        if (r108 == true) goto L84;
    L83:
        r104 = false;
    L84:
        if (r104 == false) goto L91;
        r100.L$0 = r110;
        r100.label = 2;
        r112 = h(r110, r118, r100);
        if (r112 != r102) goto L88;
        return r102;
    L73:
        if (r110.f243271b.size() == 1) goto L75;
    L77:
        boolean r119 = false;
    L78:
        if (r119 == true) goto L81;
        if (c(r110) == false) goto L83;
    L75:
        if (Intrinsics.areEqual(CollectionsKt.firstOrNull(r110.f243271b), "message") == false) goto L77;
        r119 = true;
        goto L78
    L67:
        if (r110.f243271b.size() > 1) goto L70;
        r109 = false;
        goto L71
    L61:
        if (r118.i3() != true) goto L63;
        r108 = true;
    L53:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L56
    L30:
        if (r110.f243271b.size() != 1) goto L45;
        if (Intrinsics.areEqual(CollectionsKt.firstOrNull(r110.f243271b), "message") == false) goto L45;
        Map<String, Object> r121 = r110.f243275f;
        if (r121 == null) goto L45;
        Object r122 = r121.get("conversationId");
        if (r122 == null) goto L40;
        r114 = r122.toString();
    L41:
        if (r114 != null) goto L44;
        r114 = "";
    L44:
        if (StringsKt.isBlank(r114) == false) goto L46;
    L40:
        r114 = null;
    L7:
        r100 = new DefaultSearchRecentConvDataSourceProvider$search$1(this, r111);
        goto L8
    }

    public final Object e(String r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof DefaultSearchRecentConvDataSourceProvider$loadSubConversationSnapshotIfNeeded$1) == false) goto L7;
        DefaultSearchRecentConvDataSourceProvider$loadSubConversationSnapshotIfNeeded$1 r102 = (DefaultSearchRecentConvDataSourceProvider$loadSubConversationSnapshotIfNeeded$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        DefaultSearchRecentConvDataSourceProvider r107 = (DefaultSearchRecentConvDataSourceProvider) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L22:
        r107.f243629g = (List) r104;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (this.f243629g != null) goto L17;
        RecentTopicConversationProvider r108 = RecentTopicConversationProvider.f243662a;
        r102.L$0 = this;
        r102.label = 1;
        r104 = r108.b(r100, r102);
        if (r104 != r105) goto L21;
        return r105;
    L21:
        r107 = this;
        goto L22
    L17:
        return Unit.INSTANCE;
    L7:
        r102 = new DefaultSearchRecentConvDataSourceProvider$loadSubConversationSnapshotIfNeeded$1(this, r101);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v6, types: [boolean, int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00ae -> B:29:0x00b6). Please report as a decompilation issue!!! */
    public final Object g(FlowQuery r210, Continuation<? super vv5.b> r211) {
        if ((r211 instanceof DefaultSearchRecentConvDataSourceProvider$searchLegacyRecentConversationList$1) == false) goto L7;
        DefaultSearchRecentConvDataSourceProvider$searchLegacyRecentConversationList$1 r100 = (DefaultSearchRecentConvDataSourceProvider$searchLegacyRecentConversationList$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        int r105 = 2;
        int r106 = 1;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        int r107 = r100.I$2;
        int r110 = r100.I$1;
        int r111 = r100.I$0;
        wc9.e r112 = (wc9.e) r100.L$1;
        List r113 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
        int r108 = r107;
        Object r109 = r103;
        DefaultSearchRecentConvDataSourceProvider$searchLegacyRecentConversationList$1 r114 = r100;
        DefaultSearchRecentConvDataSourceProvider r115 = this;
    L29:
        wc9.j r116 = (wc9.j) r102;
        if (r116 != null) goto L32;
        ?? r117 = 1;
        int r118 = 1;
    L75:
        r115.f243623a = r112;
        if (r118 != 0) goto L78;
    L81:
        ArrayList r119 = new ArrayList();
        Iterator r120 = r113.iterator();
    L83:
        if (r120.hasNext() == false) goto L148;
        l r121 = (l) r120.next();
        wc9.e r122 = r121.f559248a;
        if (r122 == null) goto L91;
        IconImage r123 = r122.f559199b;
        if (r123 == null) goto L91;
        ImageObj r124 = r123.imageThumb;
        if (r124 == null) goto L91;
        String r125 = r124.url;
    L93:
        if (r125 != null) goto L95;
        r125 = "";
    L95:
        String r126 = n.g(r122, "");
        if (StringsKt.isBlank(r126) == false) goto L113;
        wc9.e r127 = r121.f559248a;
        if (r127 == null) goto L100;
        r126 = r127.f559200c;
    L101:
        if (r126 != null) goto L104;
        r126 = "";
    L104:
        if (StringsKt.isBlank(r126) == false) goto L113;
        int r128 = ew5.c.f474602a;
        List<Message> r129 = r121.f559249b;
        if (r129 == null) goto L111;
        Message r130 = (Message) CollectionsKt.firstOrNull(r129);
        if (r130 == null) goto L111;
        r126 = ew5.c.a(r130, "");
    L111:
        r126 = "";
        goto L113
    L100:
        r126 = null;
    L113:
        if (i(r126, r125, "") == false) goto L115;
        FlowSearchData r131 = null;
    L145:
        if (r131 == null) goto L83;
        r119.add(r131);
        goto L83
    L115:
        int r132 = ew5.a.f474601a;
        List<Message> r133 = r121.f559249b;
        if (r133 == null) goto L120;
        Message r134 = (Message) CollectionsKt.firstOrNull(r133);
        if (r134 == null) goto L120;
        Long r135 = Boxing.boxLong(r134.getCreateTime());
    L121:
        wc9.e r136 = r121.f559248a;
        if (r136 == null) goto L124;
        Long r137 = r136.f559201d;
    L125:
        long r212 = ew5.a.a(r135, r137);
        wc9.e r138 = r121.f559248a;
        if (r138 == null) goto L128;
        String r213 = r138.f559198a;
    L129:
        if (r138 == null) goto L133;
        Integer r139 = r138.f559207j;
        if (r139 == null) goto L133;
        String r214 = r139.toString();
    L134:
        wc9.e r140 = r121.f559248a;
        if (r140 == null) goto L143;
        Integer r141 = r140.f559202e;
        if (r141 == null) goto L143;
        if (r141.intValue() != 1) goto L143;
        boolean r142 = true;
    L144:
        r131 = new FlowSearchData("message", 103, new SingleLinePayload(r125, r126, r212, r213, r214, Boxing.boxBoolean(r142), 32));
    L143:
        r142 = false;
    L133:
        r214 = null;
        goto L134
    L128:
        r213 = null;
        goto L129
    L124:
        r137 = null;
    L120:
        r135 = null;
    L91:
        r125 = null;
        goto L93
    L148:
        if (r111 == 0) goto L150;
        boolean r143 = true;
    L151:
        SearchCursor.b r144 = SearchCursor.Companion;
        wc9.e r145 = r115.f243623a;
        if (r145 == null) goto L154;
        String r146 = r145.f559198a;
    L155:
        r144.getClass();
        return new vv5.b(CollectionsKt.plus(r119, new FlowSearchData("message", 110, new AutoLoadMorePayload("message", r143, SearchCursor.b.a(r146)))), false, r105);
    L154:
        r146 = null;
        goto L155
    L150:
        r143 = false;
        goto L151
    L78:
        if (r113.isEmpty() == false) goto L81;
        return new vv5.b(null, r117, r117);
    L32:
        List<l> r147 = r116.f559241a;
        if (r147 != null) goto L35;
        r147 = CollectionsKt.emptyList();
    L35:
        r111 = !r116.f559242b ? 1 : 0;
        if (((r147.isEmpty() ? 1 : 0) ^ r106) == 0) goto L38;
        r112 = ((l) CollectionsKt.last(r147)).f559248a;
    L38:
        ArrayList r148 = new ArrayList();
        Iterator<T> r149 = r147.iterator();
    L40:
        if (r149.hasNext() == false) goto L67;
        Object r150 = r149.next();
        l r151 = (l) r150;
        wc9.e r152 = r151.f559248a;
        if (r152 == null) goto L49;
        Integer r153 = r152.f559219v;
        if (r153 == null) goto L49;
        if (r153.intValue() != 3) goto L49;
        boolean r154 = true;
    L50:
        if (r154 == true) goto L63;
        wc9.e r155 = r151.f559248a;
        if (r155 == null) goto L59;
        Integer r156 = r155.f559219v;
        if (r156 == null) goto L59;
        if (r156.intValue() != 2) goto L59;
        boolean r157 = true;
    L60:
        if (r157 == true) goto L63;
        boolean r158 = false;
    L64:
        if (r158 == false) goto L40;
        r148.add(r150);
    L59:
        r157 = false;
    L63:
        r158 = true;
    L49:
        r154 = false;
        goto L50
    L67:
        r113.addAll(r148);
        if (r113.size() >= 30) goto L72;
        if (r111 == 0) goto L72;
        r106 = 1;
        Object r215 = r109;
        int r159 = r108 + 1;
        DefaultSearchRecentConvDataSourceProvider r160 = r115;
        r100 = r114;
        r103 = r215;
    L22:
        if (r159 >= 3) goto L73;
        r100.L$0 = r113;
        r100.L$1 = r112;
        r100.I$0 = r111;
        r100.I$1 = r110;
        r100.I$2 = r159;
        r100.label = r106;
        SafeContinuation r161 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        o r162 = new o(r112, 60, ConversationArchiveFilter.EXCLUDE, r106);
        int r163 = m4a.a.f511902a;
        d r164 = new d(r161);
        Intrinsics.checkNotNullParameter(r162, "request");
        Intrinsics.checkNotNullParameter(r162, "request");
        com.larus.im.d.d().getConversationList(r162, r164);
        Object r165 = r161.getOrThrow();
        if (r165 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L26:
        if (r165 != r103) goto L28;
        return r103;
    L28:
        DefaultSearchRecentConvDataSourceProvider$searchLegacyRecentConversationList$1 r216 = r100;
        r115 = r160;
        r102 = r165;
        r108 = r159;
        r109 = r103;
        r114 = r216;
        goto L29
    L73:
        boolean r166 = true;
    L74:
        r115 = r160;
        r118 = r110;
        r117 = r166;
    L72:
        r166 = true;
        r160 = r115;
        goto L74
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (r210.f243273d == null) goto L17;
        boolean r167 = true;
    L18:
        if (r167 == false) goto L20;
        wc9.e r168 = this.f243623a;
    L21:
        r112 = r168;
        r113 = new ArrayList();
        r159 = 0;
        r110 = 0;
        r111 = 1;
        r160 = this;
        goto L22
    L20:
        r168 = null;
        goto L21
    L17:
        r167 = false;
    L7:
        r100 = new DefaultSearchRecentConvDataSourceProvider$searchLegacyRecentConversationList$1(this, r211);
        goto L8
    }

    public static boolean i(String r100, String r101, String r102) {
        if (StringsKt.isBlank(r100) == true) goto L5;
    L14:
        return false;
    L5:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        if (StringsKt.isBlank(r101) == false) goto L14;
        if (r102 != null) goto L12;
        r102 = "";
    L12:
        if (StringsKt.isBlank(r102) == false) goto L14;
        return true;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00e4 -> B:31:0x00eb). Please report as a decompilation issue!!! */
    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException
        */
    public final java.lang.Object f(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r50v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */
    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException
        */

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:110:0x0275 -> B:111:0x0283). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x01a6 -> B:81:0x01ae). Please report as a decompilation issue!!! */
    public final Object h(FlowQuery r410, SearchMixedFeedService r411, Continuation<? super vv5.b> r412) {
        FlowQuery r100 = r410;
        if ((r412 instanceof DefaultSearchRecentConvDataSourceProvider$searchMixedFeedRecentConversationList$1) == false) goto L7;
        DefaultSearchRecentConvDataSourceProvider$searchMixedFeedRecentConversationList$1 r101 = (DefaultSearchRecentConvDataSourceProvider$searchMixedFeedRecentConversationList$1) r412;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        int r106 = 3;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L15;
        boolean r107 = r101.Z$0;
        int r108 = r101.I$0;
        Iterator r109 = (Iterator) r101.L$4;
        Collection r110 = (Collection) r101.L$3;
        Map<String, wc9.e> r111 = (Map) r101.L$2;
        String r112 = (String) r101.L$1;
        FlowQuery r113 = (FlowQuery) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Iterator r114 = r109;
        Object r115 = r104;
        DefaultSearchRecentConvDataSourceProvider$searchMixedFeedRecentConversationList$1 r116 = r101;
        DefaultSearchRecentConvDataSourceProvider r117 = this;
    L81:
        FlowSearchData r118 = (FlowSearchData) r103;
        Object r413 = r115;
        Iterator r119 = r114;
    L111:
        if (r118 == null) goto L113;
        r110.add(r118);
    L113:
        DefaultSearchRecentConvDataSourceProvider r120 = r117;
        r101 = r116;
        r104 = r413;
        r106 = 3;
    L72:
        if (r119.hasNext() == false) goto L114;
        k r121 = (k) r119.next();
        if (r107 == false) goto L76;
    L82:
        zv5.j r122 = r121.f573725b;
        if (r122 == null) goto L110;
        String r123 = r122.f573705a;
        String r124 = r122.f573706b;
        boolean r414 = r107;
        if (i(r122.f573708d, r122.f573707c, r122.f573715k) == false) goto L87;
        r413 = r104;
        r107 = r414;
        r116 = r101;
        r117 = r120;
        r119 = r119;
        r111 = r111;
        r118 = null;
        goto L111
    L87:
        String r125 = r122.f573707c;
        DefaultSearchRecentConvDataSourceProvider$searchMixedFeedRecentConversationList$1 r415 = r101;
        String r126 = r122.f573708d;
        r413 = r104;
        String r127 = r122.f573709e;
        int r128 = ew5.a.f474601a;
        Iterator r416 = r119;
        Long r129 = r122.f573710f;
        Map<String, wc9.e> r417 = r111;
        Long r130 = r122.f573711g;
        if (r130 != null) goto L90;
        r130 = r121.f573726c;
    L90:
        long r210 = ew5.a.a(r129, r130);
        int r131 = r122.f573712h;
        Integer r132 = r122.f573713i;
        if (r132 == null) goto L93;
        String r211 = r132.toString();
    L94:
        boolean r212 = StringsKt.isBlank(r124);
        Integer r133 = r121.f573727d;
        if (r133 == null) goto L97;
        int r134 = r133.intValue();
    L98:
        if (r134 > 0) goto L107;
        Long r135 = r121.f573728e;
        if (r135 == null) goto L102;
        long r136 = r135.longValue();
    L104:
        if (r136 > 0) goto L107;
        boolean r213 = false;
    L108:
        FlowSearchData r137 = new FlowSearchData(r112, 119, new MixedFeedPayload(r125, r126, r127, r210, r131, r123, r211, r212, r213, false, r122.f573715k, r123, r124, r122.f573716l, r122.f573717m, r122.f573718n, r122.f573719o, r122.f573720p, r122.f573721q, r122.f573722r, r122.f573723s));
        r107 = r414;
        r116 = r415;
        r117 = r120;
        r119 = r416;
        r111 = r417;
        r118 = r137;
        goto L111
    L102:
        r136 = 0;
    L107:
        r213 = true;
        goto L108
    L97:
        r134 = 0;
        goto L98
    L93:
        r211 = null;
        goto L94
    L110:
        r413 = r104;
        r116 = r101;
        r117 = r120;
        r118 = null;
        goto L111
    L76:
        if (r121.f573724a == null) goto L82;
        r101.L$0 = r113;
        r101.L$1 = r112;
        r101.L$2 = r111;
        r101.L$3 = r110;
        r101.L$4 = r119;
        r101.I$0 = r108;
        r101.Z$0 = r107;
        r101.label = r106;
        Object r138 = r120.b(r121, r111, r112, r101);
        if (r138 != r104) goto L80;
        return r104;
    L80:
        DefaultSearchRecentConvDataSourceProvider$searchMixedFeedRecentConversationList$1 r418 = r101;
        r117 = r120;
        r103 = r138;
        r114 = r119;
        r115 = r104;
        r116 = r418;
        goto L81
    L114:
        List r139 = (List) r110;
        if (r139.isEmpty() == true) goto L117;
    L120:
        List r140 = r139;
        if (r108 == 0) goto L123;
        boolean r141 = true;
    L124:
        SearchCursor.b r142 = SearchCursor.Companion;
        String r143 = r120.f243624b;
        r142.getClass();
        return new vv5.b(CollectionsKt.plus(r140, new FlowSearchData(r112, 110, new AutoLoadMorePayload(r112, r141, SearchCursor.b.a(r143)))), false, 2);
    L123:
        r141 = false;
        goto L124
    L117:
        if (r113.f243273d != null) goto L120;
        return null;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r107 = r101.Z$0;
        r108 = r101.I$0;
        String r144 = (String) r101.L$2;
        List<k> r145 = (List) r101.L$1;
        FlowQuery r146 = (FlowQuery) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L67:
        Map<String, wc9.e> r147 = (Map) r103;
        if (r147 != null) goto L70;
        return null;
    L70:
        ArrayList r148 = new ArrayList();
        r112 = r144;
        r119 = r145.iterator();
        r113 = r146;
        r111 = r147;
        r110 = r148;
        r120 = this;
        goto L72
    L17:
        r100 = (FlowQuery) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L28:
        zv5.l r149 = (zv5.l) r103;
        if (r149 != null) goto L31;
        return null;
    L31:
        r145 = r149.f573729a;
        String r150 = r149.f573730b;
        this.f243624b = r150;
        if (r150 == null) goto L34;
        r108 = 1;
    L35:
        boolean r151 = c(r100);
        if (c(r100) == false) goto L38;
        r144 = "contact";
    L39:
        ArrayList r152 = new ArrayList();
        Iterator<T> r153 = r145.iterator();
    L41:
        if (r153.hasNext() == false) goto L45;
        Object r154 = r153.next();
        k r155 = (k) r154;
        if ((!r151) == false) goto L41;
        r152.add(r154);
        goto L41
    L45:
        ArrayList r156 = new ArrayList();
        Iterator r157 = r152.iterator();
    L47:
        if (r157.hasNext() == false) goto L51;
        String r158 = ((k) r157.next()).f573724a;
        if (r158 == null) goto L47;
        r156.add(r158);
        goto L47
    L51:
        ArrayList r159 = new ArrayList();
        Iterator r160 = r156.iterator();
    L53:
        if (r160.hasNext() == false) goto L57;
        Object r161 = r160.next();
        if ((!StringsKt.isBlank((String) r161)) == false) goto L53;
        r159.add(r161);
        goto L53
    L57:
        List<String> r162 = CollectionsKt.distinct(r159);
        r101.L$0 = r100;
        r101.L$1 = r145;
        r101.L$2 = r144;
        r101.I$0 = r108;
        r101.Z$0 = r151;
        r101.label = 2;
        if (r162.isEmpty() == false) goto L60;
        Object r163 = MapsKt.emptyMap();
    L64:
        if (r163 != r104) goto L66;
        return r104;
    L66:
        Object r419 = r163;
        r146 = r100;
        r107 = r151;
        r103 = r419;
        goto L67
    L60:
        SafeContinuation r164 = new SafeContinuation(IntrinsicsKt.intercepted(r101));
        int r165 = m4a.a.f511902a;
        c r166 = new c(r164);
        Intrinsics.checkNotNullParameter(r162, "cvsIdList");
        Intrinsics.checkNotNullParameter(r162, "cvsIdList");
        com.larus.im.d.d().batchGetConversationByIds(r162, r166);
        Object r167 = r164.getOrThrow();
        if (r167 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L63;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L63:
        r163 = r167;
        goto L64
    L38:
        r144 = "message";
        goto L39
    L34:
        r108 = 0;
        goto L35
    L18:
        ResultKt.throwOnFailure(r103);
        if (r411 != null) goto L22;
        return null;
    L22:
        if (r100.f243273d == null) goto L24;
        String r168 = this.f243624b;
    L25:
        r101.L$0 = r100;
        r101.label = 1;
        r103 = r411.r2(r168, 30, r101);
        if (r103 != r104) goto L28;
        return r104;
    L24:
        r168 = null;
    L7:
        r101 = new DefaultSearchRecentConvDataSourceProvider$searchMixedFeedRecentConversationList$1(this, r412);
        goto L8
    }

    public final Object b(k r210, Map<String, wc9.e> r211, String r212, Continuation<? super FlowSearchData> r213) {
        k r100 = r210;
        if ((r213 instanceof DefaultSearchRecentConvDataSourceProvider$buildDoubaoRecentConversationData$1) == false) goto L7;
        DefaultSearchRecentConvDataSourceProvider$buildDoubaoRecentConversationData$1 r101 = (DefaultSearchRecentConvDataSourceProvider$buildDoubaoRecentConversationData$1) r213;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = false;
        String r107 = null;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        wc9.e r108 = (wc9.e) r101.L$2;
        String r109 = (String) r101.L$1;
        k r110 = (k) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Object r111 = r103;
        wc9.e r112 = r108;
        r100 = r110;
    L41:
        Message r113 = (Message) r111;
        IconImage r114 = r112.f559199b;
        if (r114 == null) goto L46;
        ImageObj r115 = r114.imageThumb;
        if (r115 == null) goto L46;
        String r116 = r115.url;
    L47:
        if (r116 != null) goto L49;
        String r117 = "";
    L50:
        String r118 = n.g(r112, "");
        if (i(r118, r117, "") == false) goto L53;
        return null;
    L53:
        int r119 = ew5.a.f474601a;
        if (r113 == null) goto L56;
        Long r120 = Boxing.boxLong(r113.getCreateTime());
    L57:
        Long r121 = r112.f559201d;
        if (r121 != null) goto L60;
        r121 = r100.f573726c;
    L60:
        long r122 = ew5.a.a(r120, r121);
        String r123 = r112.f559198a;
        Integer r124 = r112.f559207j;
        if (r124 == null) goto L63;
        r107 = r124.toString();
    L63:
        String r125 = r107;
        Integer r126 = r112.f559202e;
        if (r126 == null) goto L70;
        if (r126.intValue() != 1) goto L70;
        r106 = true;
    L70:
        return new FlowSearchData(r109, 103, new SingleLinePayload(r117, r118, r122, r123, r125, Boxing.boxBoolean(r106), 32));
    L56:
        r120 = null;
        goto L57
    L49:
        r117 = r116;
    L46:
        r116 = null;
        goto L47
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        String r127 = r100.f573724a;
        if (r127 != null) goto L17;
        r127 = "";
    L17:
        r112 = r211.get(r127);
        if (r112 != null) goto L20;
        return null;
    L20:
        Integer r128 = r112.f559217t;
        if (r128 != null) goto L24;
    L26:
        r101.L$0 = r100;
        r101.L$1 = r212;
        r101.L$2 = r112;
        r101.label = 1;
        String r129 = r112.f559211n;
        if (r129 != null) goto L29;
    L32:
        boolean r130 = true;
    L33:
        if (r130 == false) goto L35;
        r111 = null;
    L38:
        if (r111 != r104) goto L40;
        return r104;
    L40:
        r109 = r212;
        goto L41
    L35:
        SafeContinuation r131 = new SafeContinuation(IntrinsicsKt.intercepted(r101));
        int r132 = m4a.a.f511902a;
        m4a.a.a(new MessageListRequest(r112.f559198a, 0, 0, 2, 0, null, false, 118, null), new b(r131, r129));
        r111 = r131.getOrThrow();
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L38;
        DebugProbesKt.probeCoroutineSuspended(r101);
        goto L38
    L29:
        if (StringsKt.isBlank(r129) == true) goto L32;
        r130 = false;
        goto L33
    L24:
        if (r128.intValue() != 8) goto L26;
        return null;
    L7:
        r101 = new DefaultSearchRecentConvDataSourceProvider$buildDoubaoRecentConversationData$1(this, r213);
        goto L8
    }
}
