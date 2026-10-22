package com.bytedance.ee.bear.document.at.search;

import com.bytedance.ee.bear.atfinder.MentionModel;
import com.ss.android.lark.picker.Searcher;
import com.ss.android.lark.picker.config.SearcherConfig;
import com.ss.android.lark.search.dto.SearchResponse;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/search/dto/SearchResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.document.at.search.SearchDataLoader$search$job$1$searchNormalJob$1", f = "SearchDataLoader.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
public final class SearchDataLoader$search$job$1$searchNormalJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SearchResponse>, Object> {
    final /* synthetic */ MentionModel $mentionModel;
    final /* synthetic */ boolean $searchBot;
    final /* synthetic */ Set<Integer> $searchDocSet;
    final /* synthetic */ boolean $searchGroup;
    final /* synthetic */ boolean $searchUser;
    int label;

    public SearchDataLoader$search$job$1$searchNormalJob$1(MentionModel r1, Set<Integer> r2, boolean r3, boolean r4, boolean r5, Continuation<? super SearchDataLoader$search$job$1$searchNormalJob$1> r6) {
        this.$mentionModel = r1;
        this.$searchDocSet = r2;
        this.$searchUser = r3;
        this.$searchGroup = r4;
        this.$searchBot = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new SearchDataLoader$search$job$1$searchNormalJob$1(this.$mentionModel, this.$searchDocSet, this.$searchUser, this.$searchGroup, this.$searchBot, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super SearchResponse> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L19
        Object r2 = r14;
    L17:
        Object r3 = Result.constructor-impl((SearchResponse) r2);     // Catch: Throwable -> L19
    L21:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L28;
        tt5.a.e("SearchDataLoader", "search normal error", r4, false);
        return new SearchResponse();
    L28:
        return r3;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
        MentionModel r5 = this.$mentionModel;
        Set<Integer> r6 = this.$searchDocSet;
        boolean r7 = this.$searchUser;
        boolean r8 = this.$searchGroup;
        boolean r9 = this.$searchBot;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L19
        Searcher r11 = new Searcher(null, 1, null);     // Catch: Throwable -> L19
        String r12 = com.ss.android.lark.sdk.a.a();     // Catch: Throwable -> L19
        String r13 = r5.getKeyword();     // Catch: Throwable -> L19
        int r16 = SearchDataLoader.a;     // Catch: Throwable -> L19
        if (r9 == false) goto L13;
        boolean r17 = true;
    L14:
        SearcherConfig r18 = SearchDataLoader.b(r6, r7, r8, r17, CollectionsKt.emptyList());     // Catch: Throwable -> L19
        this.label = 1;     // Catch: Throwable -> L19
        r2 = Searcher.search$default(r11, r12, r13, r18, false, false, this, 24, null);     // Catch: Throwable -> L19
        if (r2 != r0) goto L17;
        return r0;
    L13:
        r17 = false;
    L19:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }
}
