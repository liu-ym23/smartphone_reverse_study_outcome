package com.ss.android.lark.picker.recommand;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.picker.Searcher;
import com.ss.android.lark.picker.UnKnownError;
import com.ss.android.lark.picker.config.SearcherConfig;
import com.ss.android.lark.search.dto.SearchResponse;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import y3c.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011H\u0016J\u001c\u0010\u0014\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/picker/recommand/DefaultRecommendDataPuller;", "Lcom/ss/android/lark/search/dto/recommend/IRecommendPageDataPuller;", "<init>", "()V", "config", "Lcom/ss/android/lark/picker/config/SearcherConfig;", "getConfig", "()Lcom/ss/android/lark/picker/config/SearcherConfig;", "setConfig", "(Lcom/ss/android/lark/picker/config/SearcherConfig;)V", "search", "Lcom/ss/android/lark/picker/Searcher;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "loadData", "", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "onLoadMore", "canLoadMore", "", "needHeader", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultRecommendDataPuller implements a {
    private SearcherConfig config;
    private final transient CoroutineScope scope;
    private final transient Searcher search;

    /* JADX INFO: renamed from: com.ss.android.lark.picker.recommand.DefaultRecommendDataPuller$loadData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.picker.recommand.DefaultRecommendDataPuller$loadData$1", f = "DefaultRecommendDataPuller.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IGetDataCallback<List<SearchBaseInfo>> $callback;
        int label;
        final /* synthetic */ DefaultRecommendDataPuller this$0;

        public AnonymousClass1(DefaultRecommendDataPuller r100, IGetDataCallback<List<SearchBaseInfo>> r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$callback = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$callback, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L13;
            if (r101 != 1) goto L12;
            ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L7 ErrorResult -> L9
        L17:
            this.$callback.onSuccess(((SearchResponse) r110).getInfoList());     // Catch: Throwable -> L7 ErrorResult -> L9
        L25:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            ResultKt.throwOnFailure(r110);
            Searcher r102 = DefaultRecommendDataPuller.access$getSearch$p(this.this$0);     // Catch: Throwable -> L7 ErrorResult -> L9
            String r103 = qqb.a.c();     // Catch: Throwable -> L7 ErrorResult -> L9
            SearcherConfig r104 = this.this$0.getConfig();     // Catch: Throwable -> L7 ErrorResult -> L9
            this.label = 1;     // Catch: Throwable -> L7 ErrorResult -> L9
            r110 = Searcher.search$default(r102, r103, "", r104, false, false, this, 24, null);     // Catch: Throwable -> L7 ErrorResult -> L9
            if (r110 != r100) goto L17;
            return r100;
        L9:
            e = move-exception;
            this.$callback.onError(e);
        L7:
            th = move-exception;
            IGetDataCallback<List<SearchBaseInfo>> r105 = this.$callback;
            String r111 = th.getMessage();
            if (r111 != null) goto L22;
            r111 = "";
        L22:
            r105.onError(new UnKnownError(r111));
            goto L25
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.picker.recommand.DefaultRecommendDataPuller$onLoadMore$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.picker.recommand.DefaultRecommendDataPuller$onLoadMore$1", f = "DefaultRecommendDataPuller.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    public static final class C120951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IGetDataCallback<List<SearchBaseInfo>> $callback;
        int label;
        final /* synthetic */ DefaultRecommendDataPuller this$0;

        public C120951(DefaultRecommendDataPuller r100, IGetDataCallback<List<SearchBaseInfo>> r101, Continuation<? super C120951> r102) {
            this.this$0 = r100;
            this.$callback = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C120951(this.this$0, this.$callback, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C120951) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L13;
            if (r102 != 1) goto L12;
            ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L7 ErrorResult -> L9
        L17:
            this.$callback.onSuccess(((SearchResponse) r100).getInfoList());     // Catch: Throwable -> L7 ErrorResult -> L9
        L25:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            ResultKt.throwOnFailure(r100);
            Searcher r103 = DefaultRecommendDataPuller.access$getSearch$p(this.this$0);     // Catch: Throwable -> L7 ErrorResult -> L9
            String r104 = qqb.a.c();     // Catch: Throwable -> L7 ErrorResult -> L9
            this.label = 1;     // Catch: Throwable -> L7 ErrorResult -> L9
            r100 = r103.loadMore(r104, this);     // Catch: Throwable -> L7 ErrorResult -> L9
            if (r100 != r101) goto L17;
            return r101;
        L9:
            e = move-exception;
            this.$callback.onError(e);
        L7:
            th = move-exception;
            IGetDataCallback<List<SearchBaseInfo>> r105 = this.$callback;
            String r106 = th.getMessage();
            if (r106 != null) goto L22;
            r106 = "";
        L22:
            r105.onError(new UnKnownError(r106));
            goto L25
        }
    }

    @Override // y3c.a
    public boolean canLoadMore() {
        return true;
    }

    @Override // y3c.a
    public boolean needHeader() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultRecommendDataPuller() {
        this.search = new Searcher(null, 1, 0 == true ? 1 : 0);
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public final SearcherConfig getConfig() {
        return this.config;
    }

    public static final /* synthetic */ Searcher access$getSearch$p(DefaultRecommendDataPuller r100) {
        return r100.search;
    }

    @Override // y3c.a
    public void loadData(IGetDataCallback<List<SearchBaseInfo>> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        BuildersKt.launch$default(this.scope, null, null, new AnonymousClass1(this, r100, null), 3, null);
    }

    @Override // y3c.a
    public void onLoadMore(IGetDataCallback<List<SearchBaseInfo>> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        BuildersKt.launch$default(this.scope, null, null, new C120951(this, r100, null), 3, null);
    }

    public final void setConfig(SearcherConfig r100) {
        this.config = r100;
    }
}
