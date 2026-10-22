package com.bytedance.android.window.shop.innerflow;

import android.graphics.Bitmap;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import com.bytedance.android.window.shop.innerflow.repo.ECWindowInnerFlowRepo;
import com.bytedance.android.window.shop.innerflow.repo.d;
import com.bytedance.android.window.shop.innerflow.repo.e;
import com.bytedance.android.window.shop.innerflow.widget.ControllerState;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002CDB\u0007¢\u0006\u0004\bA\u0010BJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nJ=\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00110\u00102\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u000e\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0004H\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\"8\u0006¢\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010'R\u0017\u0010,\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001b\u00105\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R/\u00108\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\n060\u00108\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001b\u0010@\u001a\u00020<8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u00102\u001a\u0004\b>\u0010?¨\u0006E"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/ECWindowInnerFlowViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "Lcom/bytedance/android/window/shop/innerflow/repo/d;", "callback", "", "loadMore", "getShopCartInfo", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "release", "", "key", CommentConstants$CmtLongPanelStrategy.DEFAULT, "getParam", "", "keys", "", "Lkotlin/Pair;", "getParamPairs", "([Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "onCleared", "Lcom/bytedance/android/window/shop/innerflow/b;", "fakeInnerFlowParam", "Lcom/bytedance/android/window/shop/innerflow/b;", "innerFlowParam", "getInnerFlowParam", "()Lcom/bytedance/android/window/shop/innerflow/b;", "setInnerFlowParam", "(Lcom/bytedance/android/window/shop/innerflow/b;)V", "Lcom/bytedance/android/window/shop/innerflow/ECWindowInnerFlowViewModel$b;", "cardUIStatus", "Lcom/bytedance/android/window/shop/innerflow/ECWindowInnerFlowViewModel$b;", "getCardUIStatus", "()Lcom/bytedance/android/window/shop/innerflow/ECWindowInnerFlowViewModel$b;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lvp3/a;", "cartInfoLiveData", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getCartInfoLiveData", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "", "lynxModuleStatus", "getLynxModuleStatus", "Lcom/bytedance/android/window/shop/innerflow/ECWindowInnerFlowViewModel$a;", "flyWeight", "Lcom/bytedance/android/window/shop/innerflow/ECWindowInnerFlowViewModel$a;", "getFlyWeight", "()Lcom/bytedance/android/window/shop/innerflow/ECWindowInnerFlowViewModel$a;", "Lcom/bytedance/android/window/shop/innerflow/repo/ECWindowInnerFlowRepo;", "dataSource$delegate", "Lkotlin/Lazy;", "getDataSource", "()Lcom/bytedance/android/window/shop/innerflow/repo/ECWindowInnerFlowRepo;", "dataSource", "Lkotlin/Triple;", "", "viewCacheTriples", "Ljava/util/List;", "getViewCacheTriples", "()Ljava/util/List;", "Lcom/bytedance/android/ec/core/imagex/r;", "imageCallerContext$delegate", "getImageCallerContext", "()Lcom/bytedance/android/ec/core/imagex/r;", "imageCallerContext", "<init>", "()V", "a", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowInnerFlowViewModel extends BaseViewModel {
    private final b cardUIStatus;
    private final QLiveData<vp3.a> cartInfoLiveData;
    private final Lazy dataSource$delegate;
    private final com.bytedance.android.window.shop.innerflow.b fakeInnerFlowParam;
    private final a flyWeight;
    private final Lazy imageCallerContext$delegate;
    private com.bytedance.android.window.shop.innerflow.b innerFlowParam;
    private final QLiveData<Boolean> lynxModuleStatus;
    private final List<Triple<Integer, Integer, String>> viewCacheTriples;

    public static final class a {
        public final Set<String> a;
        public Bitmap b;
        public final RecyclerView.RecycledViewPool c;
        public final RecyclerView.RecycledViewPool d;
        public final C0037a e;
        public final b f;

        /* JADX INFO: renamed from: com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel$a$a, reason: collision with other inner class name */
        public static final class C0037a extends com.bytedance.android.ec.window.base.utils.window.c<ECVideoPlayer> {
            public C0037a() {
                super(3);
            }
        }

        public static final class b extends com.bytedance.android.ec.window.base.utils.window.c<TextView> {
            public b() {
                super(1);
            }
        }

        public final void a() {
            this.c.clear();
            this.d.clear();
            C0037a r0 = this.e;
            Iterator r1 = ((com.bytedance.android.ec.window.base.utils.window.c) r0).a.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ECVideoPlayer r2 = (ECVideoPlayer) r1.next();
            r2.q();
            r2.l();
            goto L4
        L6:
            Iterator r3 = ((com.bytedance.android.ec.window.base.utils.window.c) r0).b.iterator();
        L8:
            if (r3.hasNext() == false) goto L10;
            ECVideoPlayer r4 = (ECVideoPlayer) r3.next();
            r4.q();
            r4.l();
            goto L8
        L10:
            this.b = null;
        }

        public a() {
            this.a = new LinkedHashSet();
            this.c = new RecyclerView.RecycledViewPool();
            this.d = new RecyclerView.RecycledViewPool();
            this.e = new C0037a();
            this.f = new b();
        }
    }

    public static final class b {
        public final QLiveData<ControllerState> a;
        public final QLiveData<ControllerState> b;

        public b() {
            QLiveData<ControllerState> r0 = new QLiveData();
            ControllerState r1 = ControllerState.ENABLED;
            r0.g(r1);
            Unit r2 = Unit.INSTANCE;
            this.a = r0;
            QLiveData<ControllerState> r3 = new QLiveData();
            r3.g(r1);
            this.b = r3;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel$getShopCartInfo$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel$getShopCartInfo$1", f = "ECWindowInnerFlowViewModel.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ECWindowInnerFlowViewModel this$0;

        public AnonymousClass1(ECWindowInnerFlowViewModel r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new AnonymousClass1(this.this$0, r3);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            vp3.a r5 = (vp3.a) r4;
            if (r5 == null) goto L15;
            this.this$0.getCartInfoLiveData().e(r5);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ECWindowInnerFlowRepo r6 = ECWindowInnerFlowViewModel.access$getDataSource$p(this.this$0);
            this.label = 1;
            r4 = r6.d(this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel$loadMore$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel$loadMore$1", f = "ECWindowInnerFlowViewModel.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ d $callback;
        int label;
        final /* synthetic */ ECWindowInnerFlowViewModel this$0;

        public C02071(ECWindowInnerFlowViewModel r1, d r2, Continuation r3) {
            this.this$0 = r1;
            this.$callback = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Intrinsics.checkNotNullParameter(r4, "completion");
            return new C02071(this.this$0, this.$callback, r4);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            e r5 = (e) r4;
            if ((r5 instanceof e.d) == false) goto L15;
            this.$callback.b((List) ((e.d) r5).a);
        L22:
            return Unit.INSTANCE;
        L15:
            if ((r5 instanceof e.a) == false) goto L18;
            this.$callback.onError();
            goto L22
        L18:
            if ((r5 instanceof e.c) == false) goto L20;
            this.$callback.a();
            goto L22
        L20:
            boolean r6 = r5 instanceof e.b;
            goto L22
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ECWindowInnerFlowRepo r7 = ECWindowInnerFlowViewModel.access$getDataSource$p(this.this$0);
            this.label = 1;
            r4 = r7.b(this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    public ECWindowInnerFlowViewModel() {
        super(null, null, 3, null);
        com.bytedance.android.window.shop.innerflow.b r0 = new com.bytedance.android.window.shop.innerflow.b(MapsKt.emptyMap(), "", -1);
        this.fakeInnerFlowParam = r0;
        this.innerFlowParam = r0;
        this.cardUIStatus = new b();
        this.cartInfoLiveData = new QLiveData();
        QLiveData<Boolean> r1 = new QLiveData();
        r1.g(Boolean.FALSE);
        Unit r2 = Unit.INSTANCE;
        this.lynxModuleStatus = r1;
        this.flyWeight = new a();
        this.dataSource$delegate = LazyKt.lazy(new ECWindowInnerFlowViewModel$dataSource$2(this));
        this.viewCacheTriples = CollectionsKt.listOf(new Triple[]{new Triple(2131560891, 2, "ec_shop_layout_inner_flow_video_card"), new Triple(2131560882, 2, "ec_shop_layout_inner_flow_element_hot_comment"), new Triple(2131560881, 2, "ec_shop_layout_inner_flow_element_barrage"), new Triple(2131560884, 2, "ec_shop_layout_inner_flow_element_item_comment_banner"), new Triple(2131560883, 2, "ec_shop_layout_inner_flow_element_item_barrage")});
        this.imageCallerContext$delegate = LazyKt.lazy(ECWindowInnerFlowViewModel$imageCallerContext$2.INSTANCE);
    }

    private final ECWindowInnerFlowRepo getDataSource() {
        return (ECWindowInnerFlowRepo) this.dataSource$delegate.getValue();
    }

    public final r getImageCallerContext() {
        return (r) this.imageCallerContext$delegate.getValue();
    }

    public final void getShopCartInfo() {
        BuildersKt.launch$default(mg.b.a(this), Dispatchers.getMain(), null, new AnonymousClass1(this, null), 2, null);
    }

    public void onCleared() {
        super.onCleared();
        this.flyWeight.a();
    }

    public final b getCardUIStatus() {
        return this.cardUIStatus;
    }

    public final QLiveData<vp3.a> getCartInfoLiveData() {
        return this.cartInfoLiveData;
    }

    public final a getFlyWeight() {
        return this.flyWeight;
    }

    public final com.bytedance.android.window.shop.innerflow.b getInnerFlowParam() {
        return this.innerFlowParam;
    }

    public final QLiveData<Boolean> getLynxModuleStatus() {
        return this.lynxModuleStatus;
    }

    public final List<Triple<Integer, Integer, String>> getViewCacheTriples() {
        return this.viewCacheTriples;
    }

    public static final /* synthetic */ ECWindowInnerFlowRepo access$getDataSource$p(ECWindowInnerFlowViewModel r0) {
        return r0.getDataSource();
    }

    public final void loadMore(d r8) {
        Intrinsics.checkNotNullParameter(r8, "callback");
        BuildersKt.launch$default(mg.b.a(this), Dispatchers.getMain().getImmediate(), null, new C02071(this, r8, null), 2, null);
    }

    public final void release(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        this.flyWeight.a();
        b r1 = this.cardUIStatus;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        r1.a.a.removeObservers(r3);
        r1.b.a.removeObservers(r3);
    }

    public final void setInnerFlowParam(com.bytedance.android.window.shop.innerflow.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.innerFlowParam = r2;
    }

    public final String getParam(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, CommentConstants$CmtLongPanelStrategy.DEFAULT);
        com.bytedance.android.window.shop.innerflow.b r1 = this.innerFlowParam;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "key");
        String r5 = r1.a.get(r3);
        if (r5 != null) goto L6;
        return r4;
    L6:
        return r5;
    }

    public final List<Pair<String, String>> getParamPairs(String[] r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "keys");
        Intrinsics.checkNotNullParameter(r8, CommentConstants$CmtLongPanelStrategy.DEFAULT);
        ArrayList r0 = new ArrayList(r7.length);
        int r1 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        String r3 = r7[r2];
        com.bytedance.android.window.shop.innerflow.b r4 = this.innerFlowParam;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "key");
        String r5 = r4.a.get(r3);
        if (r5 != null) goto L7;
        r5 = r8;
    L7:
        r0.add(TuplesKt.to(r3, r5));
        r2 = r2 + 1;
        goto L3
    L8:
        return r0;
    }

    public static /* synthetic */ String getParam$default(ECWindowInnerFlowViewModel r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = "";
    L6:
        return r0.getParam(r1, r2);
    }

    public static /* synthetic */ List getParamPairs$default(ECWindowInnerFlowViewModel r0, String[] r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = "";
    L6:
        return r0.getParamPairs(r1, r2);
    }
}
