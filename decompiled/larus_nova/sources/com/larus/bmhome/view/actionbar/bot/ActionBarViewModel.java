package com.larus.bmhome.view.actionbar.bot;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.bmhome.chat.api.ActionBarApi;
import com.larus.bmhome.chat.api.ActionBarTempData;
import com.larus.im.bean.conversation.Templates;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.c1;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0001&B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u001fJ*\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"0!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0082@¢\u0006\u0002\u0010%R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006'"}, d2 = {"Lcom/larus/bmhome/view/actionbar/bot/ActionBarViewModel;", "Landroidx/lifecycle/ViewModel;", CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, "", "<init>", "(Ljava/lang/String;)V", "newPageList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/im/bean/conversation/Templates;", "getNewPageList", "()Landroidx/lifecycle/MutableLiveData;", "dataList", "getDataList", "dataLoading", "", "getDataLoading", EffectConfiguration.KEY_CURSOR, "", "getCursor", "()J", "setCursor", "(J)V", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "loadData", "", "isColdStart", "(Ljava/lang/Boolean;)V", "executeApiCall", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/chat/api/ActionBarTempData;", "(Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionBarViewModel extends ViewModel {
    public static final a Companion = null;
    private static final int LOAD_PAGE_SIZE = 20;
    private long cursor;
    private final MutableLiveData<List<Templates>> dataList;
    private final MutableLiveData<Boolean> dataLoading;
    private boolean hasMore;
    private final String lang;
    private final MutableLiveData<List<Templates>> newPageList;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.bot.ActionBarViewModel$executeApiCall$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Result;", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/chat/api/ActionBarTempData;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.bot.ActionBarViewModel$executeApiCall$2", f = "ActionBarViewModel.kt", i = {0}, l = {59, 63, 65}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends BizResponse<ActionBarTempData>>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Boolean $isColdStart;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ActionBarViewModel this$0;

        public AnonymousClass2(ActionBarViewModel r100, Boolean r101, Continuation<? super AnonymousClass2> r102) {
            this.this$0 = r100;
            this.$isColdStart = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass2 r102 = new AnonymousClass2(this.this$0, this.$isColdStart, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends BizResponse<ActionBarTempData>>> r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<BizResponse<ActionBarTempData>>> r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r100 = this.label;
            if (r100 == 0) goto L12;
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L10;
            if (r100 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r110);
        L29:
            return Unit.INSTANCE;
        L11:
            FlowCollector r101 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r110);
            FlowCollector r112 = r101;
            Object r102 = r110;
        L15:
            dm9.a r103 = (dm9.a) r102;
            if ((r103 instanceof dm9.a.b) == false) goto L21;
            Result.Companion r104 = Result.Companion;
            Result r105 = Result.m9448boximpl(Result.m9449constructorimpl(((dm9.a.b) r103).f469231a));
            this.L$0 = null;
            this.label = 2;
            if (r112.emit(r105, this) != r111) goto L29;
            return r111;
        L21:
            if ((r103 instanceof dm9.a.C5690a) == false) goto L29;
            Result.Companion r106 = Result.Companion;
            Throwable r107 = ((dm9.a.C5690a) r103).f469230c;
            if (r107 != null) goto L25;
            r107 = new Exception();
        L25:
            Result r108 = Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(r107)));
            this.L$0 = null;
            this.label = 3;
            if (r112.emit(r108, this) != r111) goto L29;
            return r111;
        L12:
            ResultKt.throwOnFailure(r110);
            r112 = (FlowCollector) this.L$0;
            ActionBarApi.a r109 = ActionBarApi.f297124a;
            ActionBarViewModel$executeApiCall$2$result$1 r113 = new ActionBarViewModel$executeApiCall$2$result$1(this.this$0, this.$isColdStart, null);
            this.L$0 = r112;
            this.label = 1;
            r109.getClass();
            FlowHttpConnection r114 = FlowHttpConnection.f359975a;
            r102 = FlowHttpConnection.g(ServiceType.IM, ActionBarApi.class, r113, false, null, null, null, this, 248);
            if (r102 != r111) goto L15;
            return r111;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.bot.ActionBarViewModel$loadData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.bot.ActionBarViewModel$loadData$1", f = "ActionBarViewModel.kt", i = {}, l = {30, 30}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Boolean $isColdStart;
        int label;
        final /* synthetic */ ActionBarViewModel this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.bot.ActionBarViewModel$loadData$1$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ActionBarViewModel f315688a;

            public a(ActionBarViewModel r100) {
                this.f315688a = r100;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r100, Continuation<? super Unit> r101) {
                Result r102 = (Result) r100;
                if (Result.m9456isSuccessimpl(r102.m9458unboximpl()) == false) goto L24;
                Object r103 = r102.m9458unboximpl();
                ActionBarViewModel r104 = this.f315688a;
                if (Result.m9452exceptionOrNullimpl(r103) != null) goto L22;
                ActionBarTempData r105 = (ActionBarTempData) ((BizResponse) r103).getData();
                if (r105 == null) goto L26;
                ActionBarViewModel r106 = this.f315688a;
                r105.bindRequestId();
                r106.getDataLoading().setValue(Boxing.boxBoolean(false));
                r106.setHasMore(r105.getHasMore());
                r106.setCursor(r105.getNextCursor());
                List<Templates> r107 = r105.getTemplateInfos();
                if (r107 == null) goto L26;
                List<Templates> r108 = CollectionsKt.filterNotNull(r107);
                if (r108 == null) goto L26;
                r106.getNewPageList().postValue(r108);
                List<Templates> r109 = r106.getDataList().getValue();
                if (r109 != null) goto L15;
                r109 = CollectionsKt.emptyList();
            L15:
                List r110 = CollectionsKt.plus(r109, r108);
                HashSet r111 = new HashSet();
                ArrayList r112 = new ArrayList();
                Iterator<T> r113 = r110.iterator();
            L17:
                if (r113.hasNext() == false) goto L21;
                T r114 = r113.next();
                if (r111.add(((Templates) r114).getId()) == false) goto L17;
                r112.add(r114);
                goto L17
            L21:
                r106.getDataList().postValue(r112);
            L26:
                return Unit.INSTANCE;
            L22:
                r104.getDataLoading().setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            L24:
                this.f315688a.getDataLoading().setValue(Boxing.boxBoolean(false));
                goto L26
            }
        }

        public AnonymousClass1(ActionBarViewModel r100, Boolean r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$isColdStart = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$isColdStart, r101);
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
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 != 2) goto L8;
            ResultKt.throwOnFailure(r100);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
        L13:
            a r103 = new a(this.this$0);
            this.label = 2;
            if (((Flow) r100).collect(r103, this) != r101) goto L17;
            return r101;
        L10:
            ResultKt.throwOnFailure(r100);
            ActionBarViewModel r104 = this.this$0;
            Boolean r105 = this.$isColdStart;
            this.label = 1;
            r100 = ActionBarViewModel.access$executeApiCall(r104, r105, this);
            if (r100 != r101) goto L13;
            return r101;
        }
    }

    static {
        Companion = new a();
    }

    public final long getCursor() {
        return this.cursor;
    }

    public final MutableLiveData<List<Templates>> getDataList() {
        return this.dataList;
    }

    public final MutableLiveData<Boolean> getDataLoading() {
        return this.dataLoading;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final MutableLiveData<List<Templates>> getNewPageList() {
        return this.newPageList;
    }

    public ActionBarViewModel(String r100) {
        this.lang = r100;
        this.newPageList = new MutableLiveData();
        this.dataList = new MutableLiveData();
        this.dataLoading = new MutableLiveData();
        this.hasMore = true;
    }

    public static final /* synthetic */ String access$getLang$p(ActionBarViewModel r100) {
        return r100.lang;
    }

    public final void loadData(Boolean r100) {
        this.dataLoading.setValue(Boolean.TRUE);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r100, null), 3, null);
    }

    public final void setCursor(long r100) {
        this.cursor = r100;
    }

    public final void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    private final Object executeApiCall(Boolean r100, Continuation<? super Flow<Result<BizResponse<ActionBarTempData>>>> r101) {
        return new c1(new AnonymousClass2(this, r100, null));
    }

    public static final /* synthetic */ Object access$executeApiCall(ActionBarViewModel r100, Boolean r101, Continuation r102) {
        return r100.executeApiCall(r101, r102);
    }
}
