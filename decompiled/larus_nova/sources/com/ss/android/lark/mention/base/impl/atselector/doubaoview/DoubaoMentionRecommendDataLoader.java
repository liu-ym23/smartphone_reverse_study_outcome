package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.chat.entity.chatter.WorkStatus;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.SearchBean;
import com.ss.android.lark.pb.graph.ChatterMeta;
import com.ss.android.lark.pb.graph.PullClosestChattersResponse;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.config.SearcherConfig;
import com.ss.android.lark.search.dto.SearchResponse;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes36.dex */
public final class DoubaoMentionRecommendDataLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Continuation<? super Result<PullClosestChattersResponse>>, Object> f431733a;

    /* JADX INFO: renamed from: com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionRecommendDataLoader$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Continuation<? super Result<? extends PullClosestChattersResponse>>, Object>, SuspendFunction {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1, g.class, "requestClosestChatters", "requestClosestChatters(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Result<? extends PullClosestChattersResponse>> r100) {
            return m8645invokeIoAF18A(r100);
        }

        /* JADX INFO: renamed from: invoke-IoAF18A, reason: not valid java name */
        public final Object m8645invokeIoAF18A(Continuation<? super Result<PullClosestChattersResponse>> r100) {
            Object r101 = g.a(r100);
            if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r101;
        L6:
            return Result.m9448boximpl(r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public DoubaoMentionRecommendDataLoader() {
        this(null);
    }

    public DoubaoMentionRecommendDataLoader(Object r100) {
        AnonymousClass1 r101 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "closestChatterRequester");
        this.f431733a = r101;
    }

    public static SearchBean c(ChatterMeta r210) {
        String r100 = r210.mavatar_key;
        if (r100 != null) goto L5;
        String r101 = "";
    L6:
        String r102 = r210.mid;
        if (r102 != null) goto L9;
        String r103 = "";
    L10:
        String r104 = r210.mname;
        if (r104 != null) goto L13;
        String r105 = "";
    L14:
        String r106 = r210.mdefaultDepartmentName;
        if (r106 != null) goto L17;
        String r107 = "";
    L19:
        return new SearchBean(new com.ss.android.lark.mention.base.impl.atselector.bean.a(r103, r101, r105, r107, CollectionsKt.emptyList(), CollectionsKt.emptyList(), Chatter.ChatterType.USER, new ChatterDescription(), true, "#", null, 0, false, CollectionsKt.emptyList(), CollectionsKt.emptyList(), null, false, false));
    L17:
        r107 = r106;
        goto L19
    L13:
        r105 = r104;
        goto L14
    L9:
        r103 = r102;
        goto L10
    L5:
        r101 = r100;
        goto L6
    }

    public final Object a(Continuation<? super Result<? extends List<? extends BaseAtBean>>> r100) {
        if ((r100 instanceof DoubaoMentionRecommendDataLoader$loadEmptySearchRecommend$1) == false) goto L7;
        DoubaoMentionRecommendDataLoader$loadEmptySearchRecommend$1 r101 = (DoubaoMentionRecommendDataLoader$loadEmptySearchRecommend$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 != 1) goto L15;
        DoubaoMentionRecommendDataLoader r106 = (DoubaoMentionRecommendDataLoader) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L33
    L21:
        Object r107 = ((Result) r103).m9458unboximpl();     // Catch: Throwable -> L33
        ResultKt.throwOnFailure(r107);     // Catch: Throwable -> L33
        PullClosestChattersResponse r108 = (PullClosestChattersResponse) r107;     // Catch: Throwable -> L33
        if (r108 == null) goto L24;
        List<ChatterMeta> r109 = r108.mchatters;     // Catch: Throwable -> L33
    L25:
        if (r109 != null) goto L27;
        r109 = CollectionsKt.emptyList();     // Catch: Throwable -> L33
    L27:
        List<ChatterMeta> r110 = r109;     // Catch: Throwable -> L33
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));     // Catch: Throwable -> L33
        Iterator<T> r112 = r110.iterator();     // Catch: Throwable -> L33
    L29:
        if (r112.hasNext() == false) goto L31;
        ChatterMeta r113 = (ChatterMeta) r112.next();     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r113);     // Catch: Throwable -> L33
        r106.getClass();     // Catch: Throwable -> L33
        r111.add(c(r113));     // Catch: Throwable -> L33
        goto L29
    L31:
        List r114 = CollectionsKt.take(r111, 10);     // Catch: Throwable -> L33
        Log.i("DoubaoMentionRecommendDataLoader", "load closest chatters count=" + r109.size() + ", result count=" + r114.size());     // Catch: Throwable -> L33
        Object r115 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L33
    L35:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 != null) goto L38;
    L41:
        return r115;
    L38:
        if ((r116 instanceof CancellationException) == true) goto L40;
        Log.e("DoubaoMentionRecommendDataLoader", "load closest chatters failed", r116);
        goto L41
    L40:
        throw r116;
    L24:
        r109 = null;
        goto L25
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L33
        Function1<Continuation<? super Result<PullClosestChattersResponse>>, Object> r118 = this.f431733a;     // Catch: Throwable -> L33
        r101.L$0 = this;     // Catch: Throwable -> L33
        r101.label = 1;     // Catch: Throwable -> L33
        r103 = r118.invoke(r101);     // Catch: Throwable -> L33
        if (r103 != r104) goto L20;
        return r104;
    L20:
        r106 = this;
    L33:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = new DoubaoMentionRecommendDataLoader$loadEmptySearchRecommend$1(this, r100);
        goto L8
    }

    public final Object b(String r310, String r311, Continuation<? super Result<? extends List<? extends BaseAtBean>>> r312) {
        String r100 = r311;
        if ((r312 instanceof DoubaoMentionRecommendDataLoader$search$1) == false) goto L7;
        DoubaoMentionRecommendDataLoader$search$1 r101 = (DoubaoMentionRecommendDataLoader$search$1) r312;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 != 1) goto L15;
        r100 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L22
    L20:
        Object r106 = Result.m9449constructorimpl((SearchResponse) r103);     // Catch: Throwable -> L22
    L24:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 != null) goto L75;
        List<SearchBaseInfo> r108 = ((SearchResponse) r106).getInfoList();
        ArrayList r109 = new ArrayList();
        Iterator<T> r110 = r108.iterator();
    L28:
        if (r110.hasNext() == false) goto L32;
        Object r111 = r110.next();
        if ((r111 instanceof SearchChatterInfo) == false) goto L28;
        r109.add(r111);
        goto L28
    L32:
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator r113 = r109.iterator();
    L34:
        if (r113.hasNext() == false) goto L68;
        SearchChatterInfo r114 = (SearchChatterInfo) r113.next();
        String r115 = r114.getId();
        if (r115 != null) goto L38;
        String r116 = "";
    L39:
        r114.getAvatarKey();
        String r117 = r114.getAvatarKey();
        if (r117 != null) goto L42;
        String r118 = "";
    L43:
        String r119 = r114.getTitle();
        if (r119 != null) goto L46;
        String r120 = "";
    L47:
        String r121 = r114.getSubTitle();
        if (r121 != null) goto L50;
        String r122 = "";
    L51:
        List<String> r123 = r114.getTitleHitTerms();
        if (r123 != null) goto L54;
        r123 = CollectionsKt.emptyList();
    L54:
        List<String> r124 = r123;
        List<String> r125 = r114.getSubTitleHitTerms();
        if (r125 != null) goto L57;
        r125 = CollectionsKt.emptyList();
    L57:
        List<String> r126 = r125;
        Chatter.ChatterType r127 = r114.getChatterType();
        if (r127 != null) goto L60;
        r127 = Chatter.ChatterType.USER;
    L60:
        Chatter.ChatterType r128 = r127;
        ChatterDescription r129 = r114.getChatterDescription();
        if (r129 != null) goto L63;
        r129 = new ChatterDescription();
    L63:
        ChatterDescription r210 = r129;
        boolean r211 = r114.isRegistered();
        boolean r212 = r114.isResigned();
        WorkStatus r213 = r114.getWorkStatus();
        long r214 = r114.getZenModeEndTime();
        boolean r215 = r114.isCrossTenant();
        List r216 = CollectionsKt.emptyList();
        List<com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus> r217 = r114.getStatusList();
        TagData r313 = r114.getTagData();
        if (r114.getChatterType() != Chatter.ChatterType.BOT) goto L66;
        boolean r314 = true;
    L67:
        String r130 = r116;
        String r131 = r118;
        String r132 = r120;
        String r133 = r122;
        boolean r218 = r314;
        com.ss.android.lark.mention.base.impl.atselector.bean.a r134 = new com.ss.android.lark.mention.base.impl.atselector.bean.a(r130, r131, r132, r133, r124, r126, r128, r210, r211, r212, "#", r213, r214, r215, r216, r217, r313, r218, r114.isAgent());
        r114.getBotExtType();
        r112.add(new SearchBean(r134));
        goto L34
    L66:
        r314 = false;
        goto L67
    L50:
        r122 = r121;
        goto L51
    L46:
        r120 = r119;
        goto L47
    L42:
        r118 = r117;
        goto L43
    L38:
        r116 = r115;
        goto L39
    L68:
        List r135 = CollectionsKt.take(r112, 10);
        StringBuilder r136 = new StringBuilder("search people count=");
        r136.append(r109.size());
        r136.append(", result count=");
        r136.append(r135.size());
        r136.append(", keyword empty=");
        if (r100.length() != 0) goto L71;
        boolean r137 = true;
    L72:
        r136.append(r137);
        Log.i("DoubaoMentionRecommendDataLoader", r136.toString());
        return Result.m9449constructorimpl(r135);
    L71:
        r137 = false;
        goto L72
    L75:
        if ((r107 instanceof CancellationException) == true) goto L82;
        StringBuilder r138 = new StringBuilder("search failed, keyword empty=");
        if (r100.length() != 0) goto L79;
        boolean r139 = true;
    L80:
        r138.append(r139);
        Log.e("DoubaoMentionRecommendDataLoader", r138.toString(), r107);
        return Result.m9449constructorimpl(ResultKt.createFailure(r107));
    L79:
        r139 = false;
        goto L80
    L82:
        throw r107;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        SearcherConfig r140 = new SearcherConfig(new Permissions(CollectionsKt.emptyList()));
        SearcherConfig.chatter$default(r140, false, DoubaoMentionRecommendDataLoader$search$config$1$1.INSTANCE, 1, null);
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L22
        CoroutineDispatcher r142 = Dispatchers.getIO();     // Catch: Throwable -> L22
        DoubaoMentionRecommendDataLoader$search$searchResponse$1$1 r143 = new DoubaoMentionRecommendDataLoader$search$searchResponse$1$1(r310, r100, r140, null);     // Catch: Throwable -> L22
        r101.L$0 = r100;     // Catch: Throwable -> L22
        r101.label = 1;     // Catch: Throwable -> L22
        r103 = BuildersKt.withContext(r142, r143, r101);     // Catch: Throwable -> L22
        if (r103 != r104) goto L20;
        return r104;
    L22:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = new DoubaoMentionRecommendDataLoader$search$1(this, r312);
        goto L8
    }
}
