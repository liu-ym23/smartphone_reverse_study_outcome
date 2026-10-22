package com.bytedance.ee.bear.document.at.search;

import com.bytedance.ee.bear.atfinder.MentionModel;
import com.ss.android.lark.picker.Searcher;
import com.ss.android.lark.picker.config.SearcherConfig;
import com.ss.android.lark.search.dto.SearchResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/search/dto/SearchResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.document.at.search.SearchDataLoader$search$job$1$searchInUserIdsJob$1", f = "SearchDataLoader.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
public final class SearchDataLoader$search$job$1$searchInUserIdsJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SearchResponse>, Object> {
    final /* synthetic */ List<Long> $inUserIds;
    final /* synthetic */ MentionModel $mentionModel;
    final /* synthetic */ boolean $searchUser;
    int label;

    public SearchDataLoader$search$job$1$searchInUserIdsJob$1(List<Long> r1, boolean r2, MentionModel r3, Continuation<? super SearchDataLoader$search$job$1$searchInUserIdsJob$1> r4) {
        this.$inUserIds = r1;
        this.$searchUser = r2;
        this.$mentionModel = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SearchDataLoader$search$job$1$searchInUserIdsJob$1(this.$inUserIds, this.$searchUser, this.$mentionModel, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super SearchResponse> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L21
        Object r2 = r13;
    L17:
        SearchResponse r3 = (SearchResponse) r2;     // Catch: Throwable -> L21
    L19:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L21
    L23:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L30;
        tt5.a.e("SearchDataLoader", "search in user ids error", r5, false);
        return new SearchResponse();
    L30:
        return r4;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r13);
        List<Long> r6 = this.$inUserIds;
        boolean r7 = this.$searchUser;
        MentionModel r8 = this.$mentionModel;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L21
        if (r6.isEmpty() == true) goto L18;
        if (r7 == false) goto L18;
        Searcher r10 = new Searcher(null, 1, null);     // Catch: Throwable -> L21
        String r11 = com.ss.android.lark.sdk.a.a();     // Catch: Throwable -> L21
        String r12 = r8.getKeyword();     // Catch: Throwable -> L21
        int r14 = SearchDataLoader.a;     // Catch: Throwable -> L21
        SearcherConfig r16 = SearchDataLoader.b(SetsKt.emptySet(), true, false, false, r6);     // Catch: Throwable -> L21
        this.label = 1;     // Catch: Throwable -> L21
        r2 = Searcher.search$default(r10, r11, r12, r16, false, false, this, 24, null);     // Catch: Throwable -> L21
        if (r2 != r0) goto L17;
        return r0;
    L18:
        r3 = new SearchResponse();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }
}
