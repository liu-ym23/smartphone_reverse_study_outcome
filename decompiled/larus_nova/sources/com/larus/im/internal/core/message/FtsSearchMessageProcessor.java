package com.larus.im.internal.core.message;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.larus.im.bean.conversation.ConversationArchiveFilter;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.callback.IIMCallback;
import com.larus.im.internal.core.AbsFtsSearchActionProcessor;
import com.larus.im.internal.core.conversation.FtsConversationArchiveResolver;
import com.larus.im.internal.core.conversation.FtsSearchParam;
import com.larus.im.internal.core.conversation.FtsSearchResult;
import com.larus.im.internal.core.message.converter.MessageEntityConverterKt;
import com.larus.im.internal.database.delegate.MessageDaoSource;
import com.larus.im.internal.database.entity.ConversationEntity;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.delegate.d0;
import com.larus.im.internal.delegate.d1;
import com.larus.im.internal.delegate.y0;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import ouc.e0;

/* JADX INFO: loaded from: classes29.dex */
public final class FtsSearchMessageProcessor extends AbsFtsSearchActionProcessor<Message> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<Integer> f347740f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<Integer> f347741g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f347742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f347743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f347744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Long> f347745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f347746e;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f347747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f347748b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f347749c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f347747a, r101.f347747a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f347748b, r101.f347748b) == true) goto L15;
            return false;
        L15:
            if (this.f347749c == r101.f347749c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f347747a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            List<String> r104 = this.f347748b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            int r105 = (r103 + r101) * 31;
            if (this.f347749c == false) goto L13;
            int r106 = 1231;
        L15:
            return r105 + r106;
        L13:
            r106 = 1237;
            goto L15
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ConversationSearchScope(conversationId=" + this.f347747a + ", conversationIdList=" + this.f347748b + ", archiveFilterApplied=" + this.f347749c + ')';
        }

        public b(String r100, List<String> r101, boolean r102) {
            this.f347747a = r100;
            this.f347748b = r101;
            this.f347749c = r102;
        }
    }

    /* JADX INFO: renamed from: com.larus.im.internal.core.message.FtsSearchMessageProcessor$search$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.message.FtsSearchMessageProcessor", f = "FtsSearchMessageProcessor.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 8}, l = {116, 118, 133, 149, 164, 189, 205, 207, 223}, m = "search$suspendImpl", n = {"destination$iv$iv", "$this", "result", "query", "$this", "result", "query", "searchConversationId", "searchConversationIdList", "tmpCursor", DyPayConstant.KEY_START_TIME, "daoStart", "$this", "result", "query", "searchConversationId", "searchConversationIdList", "tmpCursor", DyPayConstant.KEY_START_TIME, "ftsStart", "$this", "result", "query", "searchConversationId", "searchConversationIdList", "tmpCursor", "ftsAns", DyPayConstant.KEY_START_TIME, "likeStart", "$this", "result", "query", "searchConversationId", "searchConversationIdList", "tmpCursor", DyPayConstant.KEY_START_TIME, "daoStart", "$this", "result", "query", "searchConversationId", "searchConversationIdList", "tmpCursor", "tmp", "$this", "result", "query", "searchConversationId", "searchConversationIdList", "tmpCursor", "tmp", "destination$iv$iv"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FtsSearchMessageProcessor this$0;

        public AnonymousClass1(FtsSearchMessageProcessor r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return FtsSearchMessageProcessor.i(this.this$0, this);
        }
    }

    @Override // com.larus.im.internal.core.AbsFtsSearchActionProcessor
    public final Object search(Continuation<? super List<? extends Message>> r100) {
        return i(this, r100);
    }

    static {
        f347740f = CollectionsKt.listOf(new Integer[]{Integer.valueOf(MessageStatus.MessageStatus_INVISIBLE.value), Integer.valueOf(MessageStatus.MessageStatus_NOT_EXIST.value), Integer.valueOf(MessageStatus.MessageStatus_DELETED.value)});
        f347741g = CollectionsKt.listOf(new Integer[]{1, 8, 3, 7, 66, 9999});
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public final String getTAG() {
        return this.f347742a;
    }

    public static String c(List r100) {
        StringBuilder r101 = new StringBuilder("conversationIdListSize=");
        List r102 = null;
        if (r100 == null) goto L5;
        Integer r103 = Integer.valueOf(r100.size());
    L6:
        r101.append(r103);
        r101.append(", conversationIdListSample=");
        if (r100 == null) goto L9;
        r102 = CollectionsKt.take(r100, 10);
    L9:
        r101.append(r102);
        return r101.toString();
    L5:
        r103 = null;
        goto L6
    }

    public static String g(String r100) {
        return "queryLen=" + r100.length() + ", queryHash=" + r100.hashCode();
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v10, types: [T, java.util.List] */
    public final Object h(Continuation<? super b> r100) {
        if ((r100 instanceof FtsSearchMessageProcessor$resolveConversationSearchScope$1) == false) goto L7;
        FtsSearchMessageProcessor$resolveConversationSearchScope$1 r101 = (FtsSearchMessageProcessor$resolveConversationSearchScope$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L22:
        Ref.ObjectRef r106 = new Ref.ObjectRef();
        r106.element = CollectionsKt.distinct((List) r103);
        String r107 = getRequest().getConversationId();
        if (r107 == null) goto L31;
        Iterable r108 = (Iterable) r106.element;
        ?? r109 = new ArrayList();
        Iterator r110 = r108.iterator();
    L26:
        if (r110.hasNext() == false) goto L30;
        Object r111 = r110.next();
        if (Intrinsics.areEqual((String) r111, r107) == false) goto L26;
        r109.add(r111);
        goto L26
    L30:
        r106.element = r109;
    L31:
        List<String> r112 = getRequest().getConversationIdList();
        if (r112 == null) goto L48;
        if ((!r112.isEmpty()) == true) goto L37;
        r112 = null;
    L37:
        if (r112 == null) goto L48;
        HashSet r113 = CollectionsKt.toHashSet(r112);
        if (r113 == null) goto L48;
        Iterable r114 = (Iterable) r106.element;
        ?? r115 = new ArrayList();
        Iterator r116 = r114.iterator();
    L42:
        if (r116.hasNext() == false) goto L46;
        Object r117 = r116.next();
        if (r113.contains((String) r117) == false) goto L42;
        r115.add(r117);
        goto L42
    L46:
        r106.element = r115;
    L48:
        return new b(null, (List) r106.element, true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        ConversationArchiveFilter r118 = getRequest().getArchiveFilter();
        if (r118 == ConversationArchiveFilter.ALL) goto L50;
        if (y0.l() == false) goto L50;
        FtsConversationArchiveResolver r119 = FtsConversationArchiveResolver.INSTANCE;
        String r120 = this.f347742a;
        r101.label = 1;
        r103 = r119.loadConversationIds(r118, r120, r101);
        if (r103 != r104) goto L22;
        return r104;
    L50:
        return new b(getRequest().getConversationId(), getRequest().getConversationIdList(), false);
    L7:
        r101 = new FtsSearchMessageProcessor$resolveConversationSearchScope$1(this, r100);
        goto L8
    }

    public FtsSearchMessageProcessor(FtsSearchParam r100, IIMCallback<FtsSearchResult<Message>> r101) {
        Intrinsics.checkNotNullParameter(r100, "query");
        super(r100, r101);
        this.f347742a = "FtsSearchMessageProcessor";
        this.f347743b = LazyKt.lazy(new f(this));
        this.f347744c = LazyKt.lazy(new g(this));
        this.f347745d = new LinkedHashMap();
        this.f347746e = r100.getCursor();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:153:0x0a27 -> B:154:0x0a3c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:183:0x0be5 -> B:184:0x0bea). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0228 -> B:30:0x022d). Please report as a decompilation issue!!! */
    public static Object i(FtsSearchMessageProcessor r310, Continuation<? super List<Message>> r410) {
        FtsSearchMessageProcessor r100 = r310;
        if ((r410 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r101 = (AnonymousClass1) r410;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String r105 = ",cursor:";
        String r110 = ", senderIdEmpty=";
        String r111 = ", ";
        String r112 = ", conversationId=";
        String r113 = ", limit=";
        String r114 = ", cost=";
        String r115 = ", size=";
        String r116 = ", cursor=";
        switch(r101.label) {
            case 0: goto L21;
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            default: goto L11;
        };
    L12:
        Collection r106 = (Collection) r101.L$2;
        Iterator r107 = (Iterator) r101.L$1;
        Collection r108 = (Collection) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Iterator r109 = r107;
        Object r117 = r104;
        AnonymousClass1 r118 = r101;
        Object r119 = r103;
        Collection r120 = r108;
    L184:
        r106.add((Message) r119);
        r106 = r120;
        AnonymousClass1 r121 = r118;
        Object r122 = r117;
        Iterator r123 = r109;
    L179:
        if (r123.hasNext() == false) goto L186;
        MessageEntity r124 = (MessageEntity) r123.next();
        r121.L$0 = r106;
        r121.L$1 = r123;
        r121.L$2 = r106;
        r121.L$3 = null;
        r121.L$4 = null;
        r121.L$5 = null;
        r121.L$6 = null;
        r121.label = 9;
        Object r125 = MessageEntityConverterKt.a(r124, r121);
        if (r125 != r122) goto L183;
        return r122;
    L183:
        r109 = r123;
        r117 = r122;
        r118 = r121;
        r119 = r125;
        r120 = r106;
        goto L184
    L186:
        return (List) r106;
    L13:
        List<MessageEntity> r126 = (List) r101.L$6;
        Ref.LongRef r127 = (Ref.LongRef) r101.L$5;
        List<String> r128 = (List) r101.L$4;
        String r129 = (String) r101.L$3;
        String r130 = (String) r101.L$2;
        List r131 = (List) r101.L$1;
        FtsSearchMessageProcessor r132 = (FtsSearchMessageProcessor) r101.L$0;
        ResultKt.throwOnFailure(r103);
        String r133 = ", size=";
        AnonymousClass1 r134 = r101;
        Object r135 = r103;
        FtsSearchMessageProcessor r136 = r132;
        List<MessageEntity> r137 = r126;
        Object r138 = r104;
        String r139 = r129;
        String r140 = ", conversationId=";
        String r141 = ",cursor:";
        String r142 = ", limit=";
        List<String> r143 = r128;
        String r144 = ", cost=";
        String r145 = ", senderIdEmpty=";
        String r146 = ", ";
        List r147 = r131;
    L154:
        List r148 = (List) r135;
        Iterator<T> r149 = r137.iterator();
        if (r149.hasNext() == true) goto L157;
        String r210 = r144;
        Long r150 = null;
    L165:
        if (r150 == null) goto L167;
        long r151 = r150.longValue();
    L168:
        String r152 = r140;
        String r153 = r142;
        long r154 = r151;
        if (r154 <= 0) goto L171;
        r136.f347746e = r154;
    L171:
        com.larus.im.internal.delegate.a r155 = com.larus.im.internal.delegate.a.f348188b;
        String r156 = r136.f347742a;
        String r211 = r146;
        String r212 = r145;
        StringBuilder r157 = new StringBuilder("fts query im_message rawQueryLen=");
        r157.append(r136.getRequest().getQuery().length());
        r157.append(" rawQueryHash=");
        r157.append(r136.getRequest().getQuery().hashCode());
        r157.append(" limit=");
        r157.append(r136.getRequest().getLimit());
        r157.append(" cursor=");
        Object r158 = r138;
        AnonymousClass1 r213 = r134;
        r157.append(r127.element);
        r157.append(" newCursor=");
        r157.append(r154);
        r157.append(" data_size=");
        r157.append(r137.size());
        r157.append(" filtered_data_size=");
        r157.append(r148.size());
        r157.append(' ');
        r157.append(c(r143));
        r157.append(" async=");
        r157.append(r136.getRequest().getAsync());
        r155.i(r156, r157.toString());
        r127.element = r154;
        r155.i(r136.f347742a, "searchEnd, " + g(r130) + r141 + r127.element + ",result:" + r148.size());
        r147.addAll(r148);
        if (r147.size() < r136.getRequest().getLimit()) goto L174;
    L177:
        List r159 = CollectionsKt.take(r147, r136.getRequest().getLimit());
        ArrayList r160 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r159, 10));
        r123 = r159.iterator();
        r106 = r160;
        r122 = r158;
        r121 = r213;
        goto L179
    L174:
        if (r127.element <= 0) goto L177;
        String r161 = r139;
        r100 = r136;
        Ref.LongRef r162 = r127;
        List r163 = r147;
        String r164 = r130;
        Object r165 = r158;
        String r166 = r116;
        String r167 = r152;
        String r168 = r210;
        String r169 = r153;
        String r170 = r211;
        String r171 = r212;
        AnonymousClass1 r172 = r213;
    L49:
        com.larus.im.internal.delegate.a r173 = com.larus.im.internal.delegate.a.f348188b;
        String r174 = r100.f347742a;
        Object r311 = r165;
        List r175 = r163;
        StringBuilder r176 = new StringBuilder("searchStart, ");
        r176.append(g(r164));
        r176.append(r141);
        String r214 = r171;
        String r177 = r141;
        r176.append(r162.element);
        r176.append(",limit:");
        r176.append(r100.getRequest().getLimit());
        r173.i(r174, r176.toString());
        com.larus.im.internal.delegate.c r178 = com.larus.im.internal.delegate.c.f348197a;
        long r179 = r178.elapsedRealtime();
        if (r100.getRequest().isFts() == true) goto L52;
    L76:
        String r215 = r161;
        String r216 = r177;
        String r180 = r166;
        String r312 = r167;
        String r313 = r169;
        String r314 = r170;
        List<String> r217 = r143;
        AnonymousClass1 r315 = r172;
        if (d0.f348204b.isWCDBEnable() == false) goto L123;
        long r181 = r178.elapsedRealtime();
        String r182 = r100.f347742a;
        StringBuilder r183 = new StringBuilder("before searchMsgByFts, branch=ftsThenLike, ");
        r183.append(g(r164));
        r183.append(r180);
        r183.append(r162.element);
        r183.append(r313);
        r183.append(r100.getRequest().getLimit());
        r183.append(r312);
        r183.append(r215);
        r183.append(r314);
        r183.append(c(r217));
        r183.append(r214);
        String r184 = r100.getRequest().getSenderId();
        if (r184 != null) goto L81;
    L84:
        boolean r185 = true;
    L85:
        r183.append(r185);
        r173.i(r182, r183.toString());
        be9.d r186 = ae9.e.a();
        int r187 = r100.getRequest().getLimit();
        long r188 = r162.element;
        List<Integer> r189 = f347740f;
        List<Integer> r218 = f347741g;
        if (r217 != null) goto L88;
        List<String> r219 = new ArrayList();
    L89:
        String r220 = r100.getRequest().getSenderId();
        r315.L$0 = r100;
        FtsSearchMessageProcessor r221 = r100;
        r315.L$1 = r175;
        r315.L$2 = r164;
        r315.L$3 = r215;
        r315.L$4 = r217;
        r315.L$5 = r162;
        r315.L$6 = null;
        Ref.LongRef r222 = r162;
        r315.J$0 = r179;
        r315.J$1 = r181;
        r315.label = 4;
        String r190 = r314;
        Object r191 = ((MessageDaoSource) r186).b0(r164, r187, r188, r189, r218, r215, r219, r220, r315);
        if (r191 != r311) goto L92;
        return r311;
    L92:
        String r192 = r164;
        String r193 = r313;
        AnonymousClass1 r194 = r315;
        r103 = r191;
        Object r316 = r311;
        String r195 = r168;
        String r196 = r133;
        String r197 = r215;
        List r198 = r175;
        Ref.LongRef r199 = r222;
        String r1100 = r180;
        List<String> r1101 = r217;
        long r200 = r181;
        String r201 = r214;
        long r1102 = r179;
        String r202 = r312;
        FtsSearchMessageProcessor r203 = r221;
    L93:
        List r204 = (List) r103;
        if (r204 != null) goto L96;
        r204 = CollectionsKt.emptyList();
    L96:
        AnonymousClass1 r1103 = r194;
        com.larus.im.internal.delegate.a r1104 = com.larus.im.internal.delegate.a.f348188b;
        String r223 = r201;
        String r205 = r203.f347742a;
        List<String> r224 = r1101;
        String r225 = r190;
        StringBuilder r1105 = new StringBuilder("after searchMsgByFts, branch=ftsThenLike, ");
        r1105.append(g(r192));
        r1105.append(r1100);
        String r226 = r202;
        r1105.append(r199.element);
        r1105.append(r196);
        r1105.append(r204.size());
        r1105.append(r195);
        com.larus.im.internal.delegate.c r206 = com.larus.im.internal.delegate.c.f348197a;
        r1105.append(r206.elapsedRealtime() - r200);
        r1104.i(r205, r1105.toString());
        List r207 = r204;
        if (r207.isEmpty() == false) goto L121;
        long r208 = r206.elapsedRealtime();
        String r209 = r203.f347742a;
        StringBuilder r227 = new StringBuilder("before searchMsgByLike, branch=ftsThenLike, ");
        r227.append(g(r192));
        r227.append(r1100);
        String r1106 = r195;
        String r228 = r196;
        r227.append(r199.element);
        r227.append(r193);
        r227.append(r203.getRequest().getLimit());
        r227.append(r226);
        r227.append(r197);
        r227.append(r225);
        r227.append(c(r224));
        r227.append(r223);
        String r229 = r203.getRequest().getSenderId();
        if (r229 != null) goto L101;
    L104:
        boolean r230 = true;
    L105:
        r227.append(r230);
        r1104.i(r209, r227.toString());
        be9.d r231 = ae9.e.a();
        int r232 = r203.getRequest().getLimit();
        long r233 = r199.element;
        List<Integer> r234 = f347740f;
        List<Integer> r1107 = f347741g;
        if (r224 != null) goto L108;
        List<String> r235 = new ArrayList();
    L109:
        String r236 = r203.getRequest().getSenderId();
        String r237 = r1100;
        r1103.L$0 = r203;
        FtsSearchMessageProcessor r1108 = r203;
        r1103.L$1 = r198;
        r1103.L$2 = r192;
        r1103.L$3 = r197;
        r1103.L$4 = r224;
        r1103.L$5 = r199;
        r1103.L$6 = r204;
        String r238 = r197;
        long r1109 = r1102;
        r1103.J$0 = r1109;
        r1103.J$1 = r208;
        List<String> r1110 = r224;
        r1103.label = 5;
        List r239 = r204;
        Ref.LongRef r240 = r199;
        r114 = r1106;
        r115 = r228;
        Object r1111 = r316;
        String r241 = r193;
        r103 = ((MessageDaoSource) r231).c0(r192, r232, r233, r234, r1107, r238, r235, r236, r1103);
        if (r103 != r1111) goto L112;
        return r1111;
    L112:
        r104 = r1111;
        FtsSearchMessageProcessor r242 = r1108;
        r105 = r216;
        r110 = r223;
        r111 = r225;
        Ref.LongRef r243 = r240;
        String r244 = r237;
        long r245 = r208;
        long r246 = r1109;
        String r1112 = r226;
        AnonymousClass1 r317 = r1103;
        List r1113 = r198;
    L113:
        List r247 = (List) r103;
        Object r1114 = r104;
        com.larus.im.internal.delegate.a r248 = com.larus.im.internal.delegate.a.f348188b;
        long r249 = r246;
        String r250 = r242.f347742a;
        FtsSearchMessageProcessor r251 = r242;
        StringBuilder r252 = new StringBuilder("after searchMsgByLike, branch=ftsThenLike, ");
        r252.append(g(r192));
        r252.append(r244);
        String r253 = r105;
        String r254 = r110;
        r252.append(r243.element);
        r252.append(r115);
        if (r247 == null) goto L116;
        Integer r255 = Boxing.boxInt(r247.size());
    L117:
        r252.append(r255);
        r252.append(r114);
        r252.append(com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - r245);
        r248.i(r250, r252.toString());
        if (r247 != null) goto L120;
        r247 = CollectionsKt.emptyList();
    L120:
        r207 = r247;
        r164 = r192;
        r196 = r115;
        Object r1115 = r1114;
        long r318 = r249;
        String r256 = r254;
        r216 = r253;
        FtsSearchMessageProcessor r257 = r251;
        r225 = r111;
        AnonymousClass1 r1116 = r317;
        String r319 = r1112;
        String r1117 = r244;
        String r258 = r319;
        List r1118 = r1113;
    L122:
        List r259 = r207;
        d1 r260 = d1.f348206b;
        LinkedHashMap r261 = new LinkedHashMap();
        TuplesKt.to("empty", Boxing.boxBoolean(r259.isEmpty()));
        TuplesKt.to("fts_empty", Boxing.boxBoolean(r239.isEmpty()));
        TuplesKt.to("like_empty", Boxing.boxBoolean(r259.isEmpty()));
        Unit r262 = Unit.INSTANCE;
        r260.a("flow_search_result_info", new ouc.d0(r261));
        r112 = r258;
        r162 = r243;
        r115 = r196;
        r104 = r1115;
        List r263 = r1118;
        List<String> r264 = r1110;
        r105 = r216;
        r110 = r256;
        r116 = r1117;
        String r265 = r238;
        r113 = r241;
    L146:
        long r1119 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - r318;
        String r266 = r257.getRequest().getQuery();
        int r1120 = r257.getRequest().getLimit();
        String r320 = r105;
        String r267 = r110;
        long r268 = r162.element;
        String r269 = r112;
        d1 r1121 = d1.f348206b;
        String r270 = r113;
        e0 r1122 = new e0();
        String r271 = r114;
        String r272 = r115;
        ouc.j.c(r1122, "type", "message");
        ouc.j.c(r1122, "query", r266);
        ouc.j.b(r1122, VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, Integer.valueOf(r1120));
        ouc.j.b(r1122, "const", Long.valueOf(r1119));
        ouc.j.b(r1122, EffectConfiguration.KEY_CURSOR, Long.valueOf(r268));
        Unit r273 = Unit.INSTANCE;
        r1121.a("chat_message_search_cost", r1122.a());
        com.larus.im.internal.delegate.a.f348188b.i(r257.f347742a, "before filter, " + g(r164) + ", rawSize=" + r259.size());
        r1116.L$0 = r257;
        r1116.L$1 = r263;
        r1116.L$2 = r164;
        r1116.L$3 = r265;
        r1116.L$4 = r264;
        r1116.L$5 = r162;
        r1116.L$6 = r259;
        r1116.label = 7;
        Object r274 = r257.d(r259, r1116);
        if (r274 != r104) goto L149;
        return r104;
    L149:
        String r1123 = r320;
        String r275 = r265;
        List<String> r276 = r264;
        r112 = r269;
        r113 = r270;
        r114 = r271;
        r115 = r272;
        List r277 = r263;
        r127 = r162;
        r101 = r1116;
        r111 = r225;
        r130 = r164;
        r103 = r274;
    L150:
        List<MessageEntity> r278 = (List) r103;
        String r321 = r1123;
        String r1124 = r111;
        String r1125 = r112;
        String r279 = r113;
        com.larus.im.internal.delegate.a.f348188b.i(r257.f347742a, "after filter, " + g(r130) + ", filteredSize=" + r278.size());
        r101.L$0 = r257;
        r101.L$1 = r277;
        r101.L$2 = r130;
        r101.L$3 = r275;
        r101.L$4 = r276;
        r101.L$5 = r127;
        r101.L$6 = r259;
        r101.label = 8;
        Object r280 = r257.e(r278, r101);
        if (r280 != r104) goto L153;
        return r104;
    L153:
        r141 = r321;
        r143 = r276;
        r144 = r114;
        r146 = r1124;
        r145 = r267;
        r138 = r104;
        r139 = r275;
        r133 = r115;
        r142 = r279;
        r134 = r101;
        r135 = r280;
        r136 = r257;
        r137 = r259;
        r147 = r277;
        r140 = r1125;
        goto L154
    L116:
        r255 = null;
        goto L117
    L108:
        r235 = r224;
        goto L109
    L101:
        if (r229.length() == 0) goto L104;
        r230 = false;
        goto L105
    L121:
        r241 = r193;
        r318 = r1102;
        r1110 = r224;
        r239 = r204;
        r238 = r197;
        r114 = r195;
        r258 = r226;
        r1115 = r316;
        r164 = r192;
        r1116 = r1103;
        r257 = r203;
        r256 = r223;
        r243 = r199;
        r1117 = r1100;
        r1118 = r198;
        goto L122
    L88:
        r219 = r217;
        goto L89
    L81:
        if (r184.length() == 0) goto L84;
        r185 = false;
        goto L85
    L123:
        FtsSearchMessageProcessor r281 = r100;
        List r282 = r175;
        AnonymousClass1 r283 = r315;
        Ref.LongRef r284 = r162;
        long r1126 = r178.elapsedRealtime();
        String r285 = r281.f347742a;
        StringBuilder r286 = new StringBuilder("before searchMsgByLike, branch=like, ");
        r286.append(g(r164));
        r286.append(r180);
        r286.append(r284.element);
        r286.append(r313);
        r286.append(r281.getRequest().getLimit());
        r286.append(r312);
        r286.append(r215);
        r286.append(r314);
        r286.append(c(r217));
        r286.append(r214);
        String r1127 = r281.getRequest().getSenderId();
        if (r1127 != null) goto L126;
    L129:
        boolean r287 = true;
    L130:
        r286.append(r287);
        r173.i(r285, r286.toString());
        be9.d r288 = ae9.e.a();
        int r289 = r281.getRequest().getLimit();
        long r290 = r284.element;
        List<Integer> r1128 = f347740f;
        List<Integer> r291 = f347741g;
        if (r217 != null) goto L133;
        List<String> r292 = new ArrayList();
    L134:
        String r293 = r281.getRequest().getSenderId();
        r283.L$0 = r281;
        r283.L$1 = r282;
        r283.L$2 = r164;
        r283.L$3 = r215;
        r283.L$4 = r217;
        r283.L$5 = r284;
        r283.L$6 = null;
        r283.J$0 = r179;
        r283.J$1 = r1126;
        r283.label = 6;
        String r294 = r215;
        r162 = r284;
        String r295 = r180;
        long r296 = r1126;
        Object r297 = ((MessageDaoSource) r288).c0(r164, r289, r290, r1128, r291, r294, r292, r293, r283);
        if (r297 != r311) goto L137;
        return r311;
    L137:
        Object r322 = r311;
        r114 = r168;
        r115 = r133;
        FtsSearchMessageProcessor r298 = r281;
        r105 = r216;
        r264 = r217;
        r112 = r312;
        r111 = r314;
        r110 = r214;
        r113 = r313;
        long r299 = r179;
        List r2100 = r282;
    L138:
        r259 = (List) r297;
        AnonymousClass1 r1129 = r283;
        com.larus.im.internal.delegate.a r300 = com.larus.im.internal.delegate.a.f348188b;
        long r2101 = r299;
        String r301 = r298.f347742a;
        FtsSearchMessageProcessor r1130 = r298;
        StringBuilder r302 = new StringBuilder("after searchMsgByLike, branch=like, ");
        r302.append(g(r164));
        r302.append(r295);
        String r1131 = r164;
        r302.append(r162.element);
        r302.append(r115);
        if (r259 == null) goto L141;
        Integer r303 = Boxing.boxInt(r259.size());
    L142:
        r302.append(r303);
        r302.append(r114);
        r302.append(com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - r296);
        r300.i(r301, r302.toString());
        if (r259 != null) goto L145;
        r259 = CollectionsKt.emptyList();
    L145:
        r225 = r111;
        r1116 = r1129;
        r257 = r1130;
        r164 = r1131;
        r263 = r2100;
        r318 = r2101;
        r265 = r294;
        r116 = r295;
        r104 = r322;
        goto L146
    L141:
        r303 = null;
        goto L142
    L133:
        r292 = r217;
        goto L134
    L126:
        if (r1127.length() == 0) goto L129;
        r287 = false;
        goto L130
    L52:
        if (d0.f348204b.isWCDBEnable() == false) goto L76;
        long r1132 = r178.elapsedRealtime();
        String r304 = r100.f347742a;
        StringBuilder r1133 = new StringBuilder("before searchMsgByFts, branch=fts, ");
        r1133.append(g(r164));
        r1133.append(r166);
        r1133.append(r162.element);
        r1133.append(r169);
        r1133.append(r100.getRequest().getLimit());
        r1133.append(r167);
        r1133.append(r161);
        r1133.append(r170);
        r1133.append(c(r143));
        r1133.append(r214);
        String r1134 = r100.getRequest().getSenderId();
        if (r1134 != null) goto L56;
    L59:
        boolean r1135 = true;
    L60:
        r1133.append(r1135);
        r173.i(r304, r1133.toString());
        be9.d r305 = ae9.e.a();
        int r1136 = r100.getRequest().getLimit();
        String r1137 = r167;
        String r1138 = r169;
        long r306 = r162.element;
        List<Integer> r2102 = f347740f;
        List<Integer> r2103 = f347741g;
        if (r143 != null) goto L63;
        List<String> r2104 = new ArrayList();
    L64:
        String r2105 = r100.getRequest().getSenderId();
        r172.L$0 = r100;
        r172.L$1 = r175;
        r172.L$2 = r164;
        r172.L$3 = r161;
        r172.L$4 = r143;
        r172.L$5 = r162;
        r172.L$6 = null;
        List<String> r2106 = r143;
        r172.J$0 = r179;
        r172.J$1 = r1132;
        r172.label = 3;
        String r307 = r166;
        String r323 = r170;
        r318 = r179;
        String r2107 = r161;
        AnonymousClass1 r324 = r172;
        Object r308 = ((MessageDaoSource) r305).b0(r164, r1136, r306, r2102, r2103, r161, r2104, r2105, r172);
        if (r308 != r311) goto L67;
        return r311;
    L67:
        r114 = r168;
        r115 = r133;
        long r309 = r1132;
        r105 = r177;
        List<String> r325 = r2106;
        List r2108 = r175;
        r111 = r323;
        r110 = r214;
        r113 = r1138;
        r112 = r1137;
        Object r326 = r311;
        String r327 = r307;
    L68:
        r259 = (List) r308;
        Object r1139 = r326;
        com.larus.im.internal.delegate.a r328 = com.larus.im.internal.delegate.a.f348188b;
        List<String> r1140 = r325;
        String r329 = r100.f347742a;
        FtsSearchMessageProcessor r1141 = r100;
        String r2109 = r105;
        StringBuilder r330 = new StringBuilder("after searchMsgByFts, branch=fts, ");
        r330.append(g(r164));
        r330.append(r327);
        String r2110 = r110;
        r330.append(r162.element);
        r330.append(r115);
        if (r259 == null) goto L71;
        Integer r331 = Boxing.boxInt(r259.size());
    L72:
        r330.append(r331);
        r330.append(r114);
        r330.append(com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - r309);
        r328.i(r329, r330.toString());
        if (r259 != null) goto L75;
        r259 = CollectionsKt.emptyList();
    L75:
        r225 = r111;
        r264 = r1140;
        r257 = r1141;
        r263 = r2108;
        r105 = r2109;
        r110 = r2110;
        r265 = r2107;
        r1116 = r324;
        r116 = r327;
        r104 = r1139;
        goto L146
    L71:
        r331 = null;
        goto L72
    L63:
        r2104 = r143;
        goto L64
    L56:
        if (r1134.length() == 0) goto L59;
        r1135 = false;
        goto L60
    L167:
        r151 = -1;
        goto L168
    L157:
        r150 = Boxing.boxLong(((MessageEntity) r149.next()).getCreateTime());
    L159:
        if (r149.hasNext() == false) goto L164;
        String r2111 = r144;
        Long r332 = Boxing.boxLong(((MessageEntity) r149.next()).getCreateTime());
        if (r150.compareTo(r332) <= 0) goto L163;
        r150 = r332;
    L163:
        r144 = r2111;
        goto L159
    L164:
        r210 = r144;
        goto L165
    L14:
        List<MessageEntity> r333 = (List) r101.L$6;
        r127 = (Ref.LongRef) r101.L$5;
        List<String> r334 = (List) r101.L$4;
        String r335 = (String) r101.L$3;
        r130 = (String) r101.L$2;
        List r336 = (List) r101.L$1;
        r257 = (FtsSearchMessageProcessor) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r267 = ", senderIdEmpty=";
        r1123 = ",cursor:";
        r275 = r335;
        r276 = r334;
        r259 = r333;
        r277 = r336;
        goto L150
    L15:
        long r337 = r101.J$1;
        r299 = r101.J$0;
        Ref.LongRef r338 = (Ref.LongRef) r101.L$5;
        r264 = (List) r101.L$4;
        String r339 = (String) r101.L$3;
        String r340 = (String) r101.L$2;
        r2100 = (List) r101.L$1;
        r298 = (FtsSearchMessageProcessor) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r296 = r337;
        r294 = r339;
        r297 = r103;
        r283 = r101;
        r164 = r340;
        r162 = r338;
        r322 = r104;
        r295 = ", cursor=";
        goto L138
    L16:
        r245 = r101.J$1;
        r246 = r101.J$0;
        List r341 = (List) r101.L$6;
        r243 = (Ref.LongRef) r101.L$5;
        List<String> r342 = (List) r101.L$4;
        String r343 = (String) r101.L$3;
        String r344 = (String) r101.L$2;
        List r345 = (List) r101.L$1;
        r242 = (FtsSearchMessageProcessor) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r241 = ", limit=";
        r238 = r343;
        r1112 = ", conversationId=";
        r1110 = r342;
        r192 = r344;
        r239 = r341;
        r317 = r101;
        r244 = ", cursor=";
        r1113 = r345;
        goto L113
    L17:
        r200 = r101.J$1;
        long r346 = r101.J$0;
        Ref.LongRef r347 = (Ref.LongRef) r101.L$5;
        List<String> r348 = (List) r101.L$4;
        String r349 = (String) r101.L$3;
        String r350 = (String) r101.L$2;
        List r351 = (List) r101.L$1;
        r203 = (FtsSearchMessageProcessor) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r216 = ",cursor:";
        r196 = ", size=";
        r1101 = r348;
        r195 = ", cost=";
        r197 = r349;
        r199 = r347;
        r316 = r104;
        r201 = ", senderIdEmpty=";
        r190 = ", ";
        r193 = ", limit=";
        r1100 = ", cursor=";
        r198 = r351;
        r194 = r101;
        r202 = ", conversationId=";
        r192 = r350;
        r1102 = r346;
        goto L93
    L18:
        long r352 = r101.J$1;
        long r353 = r101.J$0;
        Ref.LongRef r354 = (Ref.LongRef) r101.L$5;
        r325 = (List) r101.L$4;
        String r355 = (String) r101.L$3;
        String r356 = (String) r101.L$2;
        r2108 = (List) r101.L$1;
        r100 = (FtsSearchMessageProcessor) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r318 = r353;
        r2107 = r355;
        r309 = r352;
        r308 = r103;
        r326 = r104;
        r327 = ", cursor=";
        r164 = r356;
        AnonymousClass1 r357 = r101;
        r162 = r354;
        r324 = r357;
        goto L68
    L19:
        String r358 = (String) r101.L$2;
        List r359 = (List) r101.L$1;
        FtsSearchMessageProcessor r360 = (FtsSearchMessageProcessor) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Object r361 = r103;
        r164 = r358;
        r100 = r360;
        List r362 = r359;
    L36:
        b r363 = (b) r361;
        if (r363.f347749c == false) goto L48;
        List<String> r364 = r363.f347748b;
        if (r364 != null) goto L41;
    L44:
        boolean r365 = true;
    L45:
        if (r365 == false) goto L48;
        com.larus.im.internal.delegate.a.f348188b.i(r100.f347742a, "skip message fts because no conversation matches archiveFilter=" + r100.getRequest().getArchiveFilter());
        return CollectionsKt.emptyList();
    L41:
        if (r364.isEmpty() == true) goto L44;
        r365 = false;
    L48:
        String r366 = r363.f347747a;
        List<String> r367 = r363.f347748b;
        Ref.LongRef r368 = new Ref.LongRef();
        r368.element = r100.getRequest().getCursor();
        r133 = ", size=";
        r172 = r101;
        r162 = r368;
        r167 = ", conversationId=";
        r141 = ",cursor:";
        r169 = ", limit=";
        r143 = r367;
        r165 = r104;
        r161 = r366;
        r166 = ", cursor=";
        r168 = ", cost=";
        r171 = ", senderIdEmpty=";
        r170 = ", ";
        r163 = r362;
        goto L49
    L20:
        Collection r369 = (Collection) r101.L$2;
        Iterator r370 = (Iterator) r101.L$1;
        Collection r371 = (Collection) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Iterator r372 = r370;
        Object r373 = r104;
        AnonymousClass1 r374 = r101;
        Object r375 = r103;
        Collection r376 = r371;
    L30:
        r369.add((Message) r375);
        r369 = r376;
        r101 = r374;
        r104 = r373;
        Iterator r377 = r372;
    L25:
        if (r377.hasNext() == false) goto L32;
        MessageEntity r378 = (MessageEntity) r377.next();
        r101.L$0 = r369;
        r101.L$1 = r377;
        r101.L$2 = r369;
        r101.label = 1;
        Object r379 = MessageEntityConverterKt.a(r378, r101);
        if (r379 != r104) goto L29;
        return r104;
    L29:
        r372 = r377;
        r373 = r104;
        r374 = r101;
        r375 = r379;
        r376 = r369;
        goto L30
    L32:
        return (List) r369;
    L21:
        ResultKt.throwOnFailure(r103);
        ArrayList r380 = new ArrayList();
        r164 = r100.escapeSpecialCharacters(r310.getRequest().getQuery());
        if (StringsKt.isBlank(StringsKt.trim(r164).toString()) == false) goto L33;
        r369 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r380, 10));
        r377 = r380.iterator();
        goto L25
    L33:
        r101.L$0 = r100;
        r101.L$1 = r380;
        r101.L$2 = r164;
        r101.label = 2;
        r361 = r100.h(r101);
        r362 = r380;
        if (r361 != r104) goto L36;
        return r104;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r101 = new AnonymousClass1(r100, r410);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00f8 -> B:53:0x0101). Please report as a decompilation issue!!! */
    public final Object d(List<MessageEntity> r110, Continuation<? super List<MessageEntity>> r111) {
        if ((r111 instanceof FtsSearchMessageProcessor$filter$1) == false) goto L7;
        FtsSearchMessageProcessor$filter$1 r100 = (FtsSearchMessageProcessor$filter$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
        FtsSearchMessageProcessor r102 = this;
    L8:
        Object r103 = r100.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r100.label;
        int r106 = 1;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        MessageEntity r107 = (MessageEntity) r100.L$3;
        Object r108 = r100.L$2;
        Iterator r109 = (Iterator) r100.L$1;
        Collection r112 = (Collection) r100.L$0;
        ResultKt.throwOnFailure(r103);
        Collection r113 = r112;
        Iterator r114 = r109;
        Object r115 = r108;
        MessageEntity r116 = r107;
        Object r117 = r104;
        FtsSearchMessageProcessor$filter$1 r118 = r100;
        FtsSearchMessageProcessor r119 = r102;
    L53:
        long r120 = ((Number) r103).longValue();
        if (r116.getLocalIndex() < (r120 * ((long) 1000))) goto L56;
        boolean r121 = true;
    L57:
        if (r121 == false) goto L59;
        r113.add(r115);
    L59:
        FtsSearchMessageProcessor r122 = r119;
        r100 = r118;
        r104 = r117;
        Iterator r123 = r114;
        Collection r124 = r113;
        r106 = 1;
    L45:
        if (r123.hasNext() == false) goto L61;
        Object r125 = r123.next();
        MessageEntity r126 = (MessageEntity) r125;
        String r127 = r126.getConversationId();
        if (r127 != null) goto L49;
        r127 = "";
    L49:
        r100.L$0 = r124;
        r100.L$1 = r123;
        r100.L$2 = r125;
        r100.L$3 = r126;
        r100.label = r106;
        Object r128 = r122.f(r127, r100);
        if (r128 != r104) goto L52;
        return r104;
    L52:
        FtsSearchMessageProcessor$filter$1 r129 = r100;
        r119 = r122;
        r103 = r128;
        r113 = r124;
        r114 = r123;
        r115 = r125;
        r116 = r126;
        r117 = r104;
        r118 = r129;
        goto L53
    L61:
        return (List) r124;
    L56:
        r121 = false;
        goto L57
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        ArrayList r130 = new ArrayList();
        Iterator<T> r131 = r110.iterator();
    L16:
        if (r131.hasNext() == false) goto L30;
        Object r132 = r131.next();
        MessageEntity r133 = (MessageEntity) r132;
        if (com.larus.im.internal.database.utils.k.e(r133) != 7) goto L22;
        if (r133.getStatus() != 12) goto L22;
    L26:
        boolean r134 = false;
    L28:
        if (r134 == false) goto L16;
        r130.add(r132);
    L22:
        if (com.larus.im.internal.database.utils.k.e(r133) == 6) goto L24;
    L27:
        r134 = true;
        goto L28
    L24:
        if (r133.getStatus() == 12) goto L26;
    L30:
        ArrayList r135 = new ArrayList();
        Iterator r136 = r130.iterator();
    L32:
        if (r136.hasNext() == false) goto L43;
        Object r137 = r136.next();
        String r138 = ((MessageEntity) r137).getConversationId();
        if (r138 != null) goto L36;
    L40:
        boolean r139 = false;
    L41:
        if (r139 == false) goto L32;
        r135.add(r137);
        goto L32
    L36:
        if (com.flow.kmp.common.util.f.a(r138) == false) goto L40;
        if (StringsKt.contains$default(r138, "local", false, 2, null) == true) goto L40;
        r139 = true;
        goto L41
    L43:
        ArrayList r140 = new ArrayList();
        r123 = r135.iterator();
        r122 = r102;
        r124 = r140;
    L7:
        r102 = this;
        r100 = new FtsSearchMessageProcessor$filter$1(r102, r111);
        goto L8
    }

    public final Object e(List<MessageEntity> r110, Continuation<? super List<MessageEntity>> r111) {
        if ((r111 instanceof FtsSearchMessageProcessor$filterConversation$1) == false) goto L7;
        FtsSearchMessageProcessor$filterConversation$1 r100 = (FtsSearchMessageProcessor$filterConversation$1) r111;
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
        r110 = (List) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L37:
        Iterable r113 = (Iterable) r112;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r114 = r113.iterator();
    L39:
        if (r114.hasNext() == false) goto L41;
        r105.add(((ConversationEntity) r114.next()).getConversationId());
        goto L39
    L41:
        ArrayList r115 = new ArrayList();
        Iterator r106 = r105.iterator();
    L43:
        if (r106.hasNext() == false) goto L51;
        Object r107 = r106.next();
        if (((String) r107).length() != 0) goto L47;
        boolean r108 = true;
    L49:
        if ((!r108) == false) goto L43;
        r115.add(r107);
        goto L43
    L47:
        r108 = false;
        goto L49
    L51:
        Set r116 = CollectionsKt.toSet(r115);
        ArrayList r109 = new ArrayList();
        Iterator<T> r117 = r110.iterator();
    L53:
        if (r117.hasNext() == false) goto L62;
        Object r118 = r117.next();
        String r119 = ((MessageEntity) r118).getConversationId();
        if (com.flow.kmp.common.util.f.a(r119) == true) goto L57;
    L59:
        boolean r120 = false;
    L60:
        if (r120 == false) goto L53;
        r109.add(r118);
        goto L53
    L57:
        if (CollectionsKt.contains(r116, r119) == false) goto L59;
        r120 = true;
        goto L60
    L62:
        long r121 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - r104;
        com.larus.im.internal.delegate.a.f348188b.i(this.f347742a, "filterConversation, inputMessageSize=" + r110.size() + ", resultMessageSize=" + r109.size() + ", cost=" + r121);
        return r109;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        if (((Boolean) this.f347744c.getValue()).booleanValue() == true) goto L17;
        return r110;
    L17:
        long r122 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime();
        ArrayList r123 = new ArrayList();
        Iterator<T> r124 = r110.iterator();
    L19:
        if (r124.hasNext() == false) goto L23;
        String r125 = ((MessageEntity) r124.next()).getConversationId();
        if (r125 == null) goto L19;
        r123.add(r125);
        goto L19
    L23:
        ArrayList r126 = new ArrayList();
        Iterator r127 = r123.iterator();
    L25:
        if (r127.hasNext() == false) goto L33;
        Object r128 = r127.next();
        if (((String) r128).length() != 0) goto L29;
        boolean r129 = true;
    L31:
        if ((!r129) == false) goto L25;
        r126.add(r128);
        goto L25
    L29:
        r129 = false;
        goto L31
    L33:
        be9.b r130 = ae9.b.a();
        r100.L$0 = r110;
        r100.J$0 = r122;
        r100.label = 1;
        r112 = r130.s(r126, r100);
        if (r112 != r102) goto L36;
        return r102;
    L36:
        r104 = r122;
    L7:
        r100 = new FtsSearchMessageProcessor$filterConversation$1(this, r111);
        goto L8
    }

    public final Object f(String r100, Continuation<? super Long> r110) {
        if ((r110 instanceof FtsSearchMessageProcessor$getCvsMessageCursor$1) == false) goto L7;
        FtsSearchMessageProcessor$getCvsMessageCursor$1 r101 = (FtsSearchMessageProcessor$getCvsMessageCursor$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        long r105 = 0;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        long r106 = r101.J$0;
        FtsSearchMessageProcessor r107 = (FtsSearchMessageProcessor) r101.L$1;
        String r108 = (String) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L25:
        ConversationEntity r112 = (ConversationEntity) r111;
        if (r112 == null) goto L28;
        Long r113 = r112.getMessageCursor();
    L29:
        if (r113 == null) goto L31;
        r107.f347745d.put(r108, r113);
    L31:
        if (r113 == null) goto L33;
        r105 = r113.longValue();
    L33:
        r100 = r108;
        long r109 = r106;
        long r114 = r105;
    L34:
        long r115 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - r109;
        com.larus.im.internal.delegate.a.f348188b.i(this.f347742a, "getCvsMessageCursor conversationId=" + r100 + " messageCursor=" + r114 + " cost=" + r115);
        return Boxing.boxLong(r114);
    L28:
        r113 = null;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        if (((Boolean) this.f347743b.getValue()).booleanValue() == false) goto L17;
        r109 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime();
        Long r116 = (Long) ((LinkedHashMap) this.f347745d).get(r100);
        if (r116 == null) goto L21;
        r114 = r116.longValue();
        goto L34
    L21:
        be9.b r117 = ae9.b.a();
        r101.L$0 = r100;
        r101.L$1 = this;
        r101.J$0 = r109;
        r101.label = 1;
        r111 = be9.b.C0295b.a(r117, r100, 0, r101, 6);
        if (r111 != r103) goto L24;
        return r103;
    L24:
        r108 = r100;
        r106 = r109;
        r107 = this;
        goto L25
    L17:
        return Boxing.boxLong(0);
    L7:
        r101 = new FtsSearchMessageProcessor$getCvsMessageCursor$1(this, r110);
        goto L8
    }

    @Override // com.larus.im.internal.core.AbsFtsSearchActionProcessor
    public final Object generateNewCursor(List<? extends Message> r100, Continuation<? super Long> r101) {
        return Boxing.boxLong(this.f347746e);
    }
}
