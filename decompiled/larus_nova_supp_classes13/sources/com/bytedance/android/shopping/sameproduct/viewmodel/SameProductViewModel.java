package com.bytedance.android.shopping.sameproduct.viewmodel;

import android.text.TextUtils;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.ec.core.async.b;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.feed.model.InflowGuessFeedResponse;
import com.bytedance.android.shopping.feed.repository.api.InnerGuessULikeApi;
import com.bytedance.android.shopping.feed.utils.d0;
import com.bytedance.android.shopping.feed.utils.g;
import com.bytedance.android.shopping.feed.utils.m;
import com.bytedance.android.shopping.sameproduct.model.SameProductPageParams;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.State;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;
import rd3.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 _2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001`B\u0007¢\u0006\u0004\b]\u0010^J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0014J\u0010\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\tJ\u0011\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0014\u001a\u00020\tH\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0015H\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0017\u00102\u001a\u0002018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\"\u00106\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010-\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010B\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010I\u001a\u00020H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010O\u001a\u00020H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010J\u001a\u0004\bO\u0010L\"\u0004\bP\u0010NR2\u0010S\u001a\u0012\u0012\u0004\u0012\u00020\u00060Qj\b\u0012\u0004\u0012\u00020\u0006`R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010Y\u001a\u00020H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010J\u001a\u0004\bY\u0010L\"\u0004\bZ\u0010NR\"\u0010[\u001a\u00020H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010J\u001a\u0004\b[\u0010L\"\u0004\b\\\u0010N¨\u0006a"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/viewmodel/SameProductViewModel;", "Lcom/bytedance/jedi/arch/JediViewModel;", "Lcom/bytedance/android/shopping/sameproduct/viewmodel/SameProductState;", "Lcom/bytedance/android/ec/core/async/b;", "Lcom/bytedance/android/shopping/sameproduct/model/SameProductPageParams;", "params", "", "getFilterProductIds", "defaultState", "", "setPageParams", "getPageParams", "loadMainProductCard", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "promotionResult", "updatePromotion", "loadSameProductList", "Lio/reactivex/disposables/Disposable;", "disposable", "add", "clearDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "remove", "sameProductPageParams", "Lcom/bytedance/android/shopping/sameproduct/model/SameProductPageParams;", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/InnerFlowPageStyleDTO;", "innerFlowPageStyle", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/InnerFlowPageStyleDTO;", "getInnerFlowPageStyle", "()Lcom/bytedance/android/shopping/anchorv3/repository/dto/InnerFlowPageStyleDTO;", "setInnerFlowPageStyle", "(Lcom/bytedance/android/shopping/anchorv3/repository/dto/InnerFlowPageStyleDTO;)V", "mainCardPromotion", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "getMainCardPromotion", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "setMainCardPromotion", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;)V", "", "", "productHeaderList", "Ljava/util/List;", "", "listPage", "I", "listCursor", "sameProductListDisposable", "Lio/reactivex/disposables/Disposable;", "Lcom/bytedance/android/shopping/feed/utils/m;", "filterProductHelper", "Lcom/bytedance/android/shopping/feed/utils/m;", "getFilterProductHelper", "()Lcom/bytedance/android/shopping/feed/utils/m;", "productListStyle", "getProductListStyle", "()I", "setProductListStyle", "(I)V", "Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "skuPanelState", "Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "getSkuPanelState", "()Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "setSkuPanelState", "(Lcom/bytedance/android/ec/model/sku/SkuRestoreState;)V", "ecomSceneId", "Ljava/lang/String;", "getEcomSceneId", "()Ljava/lang/String;", "setEcomSceneId", "(Ljava/lang/String;)V", "", "hasFirstLoadedProductList", "Z", "getHasFirstLoadedProductList", "()Z", "setHasFirstLoadedProductList", "(Z)V", "isFirstLoadList", "setFirstLoadList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "showedProductIds", "Ljava/util/HashSet;", "getShowedProductIds", "()Ljava/util/HashSet;", "setShowedProductIds", "(Ljava/util/HashSet;)V", "isMainProductApiError", "setMainProductApiError", "isProductListApiError", "setProductListApiError", "<init>", "()V", "Companion", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SameProductViewModel extends JediViewModel<SameProductState> implements b {
    public static final a Companion = null;
    public static final int INTERNAL_FEED_PAGE_SIZE = 6;
    private final /* synthetic */ DisposableScope $$delegate_0;
    private String ecomSceneId;
    private final m filterProductHelper;
    private boolean hasFirstLoadedProductList;
    private InnerFlowPageStyleDTO innerFlowPageStyle;
    private boolean isFirstLoadList;
    private boolean isMainProductApiError;
    private boolean isProductListApiError;
    private int listCursor;
    private int listPage;
    private PromotionProductStruct mainCardPromotion;
    private List<? extends Object> productHeaderList;
    private int productListStyle;
    private Disposable sameProductListDisposable;
    private SameProductPageParams sameProductPageParams;
    private HashSet<String> showedProductIds;
    private SkuRestoreState skuPanelState;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.sameproduct.viewmodel.SameProductViewModel$loadSameProductList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/android/shopping/sameproduct/viewmodel/SameProductState;", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class C03261 extends Lambda implements Function1<SameProductState, Unit> {
        final /* synthetic */ String $mainProductId;
        final /* synthetic */ SameProductViewModel this$0;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.sameproduct.viewmodel.SameProductViewModel$loadSameProductList$1$2, reason: invalid class name */
        public static final class AnonymousClass2 implements Observer<InflowGuessFeedResponse> {
            public final /* synthetic */ C03261 a;

            public final void onComplete() {
                SameProductViewModel.access$setSameProductListDisposable$p(this.a.this$0, null);
            }

            public AnonymousClass2(C03261 r1) {
                this.a = r1;
            }

            public final void onError(Throwable r4) {
                Intrinsics.checkNotNullParameter(r4, "e");
                if (this.a.this$0.isFirstLoadList() == false) goto L5;
                this.a.this$0.setHasFirstLoadedProductList(true);
                this.a.this$0.setFirstLoadList(false);
            L5:
                SameProductViewModel.access$setState(this.a.this$0, SameProductViewModel$loadSameProductList$1$2$onError$1.INSTANCE);
                this.a.this$0.setProductListApiError(true);
                ECExceptionMonitor.e(r4);
            }

            public final void onNext(Object r5) {
                final InflowGuessFeedResponse r6 = (InflowGuessFeedResponse) r5;
                Intrinsics.checkNotNullParameter(r6, "resp");
                SameProductViewModel.access$setState(this.a.this$0, new SameProductViewModel$loadSameProductList$1$2$onNext$1(this, r6));
                int r1 = 0;
                this.a.this$0.setProductListApiError(false);
                if (this.a.this$0.isFirstLoadList() == false) goto L5;
                this.a.this$0.setHasFirstLoadedProductList(true);
                this.a.this$0.setFirstLoadList(false);
            L5:
                SameProductViewModel r0 = this.a.this$0;
                l r3 = r6.getPage();
                if (r3 == null) goto L10;
                Integer r4 = r3.a();
                if (r4 == null) goto L10;
                r1 = r4.intValue();
            L10:
                SameProductViewModel.access$setListCursor$p(r0, r1);
                this.a.this$0.getFilterProductHelper().b(r6.getFeedItemAnchors());
                SameProductViewModel r7 = this.a.this$0;
                SameProductViewModel.access$setListPage$p(r7, SameProductViewModel.access$getListPage$p(r7) + 1);
            }

            public final void onSubscribe(Disposable r2) {
                Intrinsics.checkNotNullParameter(r2, "d");
                com.bytedance.android.ec.core.async.a.a(r2, this.a.this$0);
                SameProductViewModel.access$setSameProductListDisposable$p(this.a.this$0, r2);
            }
        }

        public C03261(SameProductViewModel r1, String r2) {
            this.this$0 = r1;
            this.$mainProductId = r2;
            super(1);
        }

        public final void invoke(SameProductState r31) {
            Intrinsics.checkNotNullParameter(r31, "it");
            if (r31.d == false) goto L5;
            return;
        L5:
            if (r31.e == false) goto L44;
            Disposable r1 = SameProductViewModel.access$getSameProductListDisposable$p(this.this$0);
            if (r1 == null) goto L9;
            r1.dispose();
        L9:
            SameProductViewModel.access$setState(this.this$0, C01761.INSTANCE);
            InnerGuessULikeApi.a.getClass();
            InnerGuessULikeApi r2 = InnerGuessULikeApi.a.a;
            if (r2 == null) goto L45;
            String r3 = this.$mainProductId;
            int r5 = SameProductViewModel.access$getListPage$p(this.this$0);
            int r7 = SameProductViewModel.access$getListCursor$p(this.this$0);
            String r8 = g.a();
            SameProductViewModel r4 = this.this$0;
            String r9 = SameProductViewModel.access$getFilterProductIds(r4, SameProductViewModel.access$getSameProductPageParams$p(r4));
            SameProductPageParams r6 = SameProductViewModel.access$getSameProductPageParams$p(this.this$0);
            if (r6 == null) goto L16;
            AnchorV3PromotionRequestParam r10 = r6.getMainCardRequestParam();
            if (r10 == null) goto L16;
            String r11 = r10.getMetaParam();
        L17:
            SameProductPageParams r13 = SameProductViewModel.access$getSameProductPageParams$p(this.this$0);
            if (r13 == null) goto L20;
            String r14 = r13.getAuthorId();
        L21:
            SameProductPageParams r15 = SameProductViewModel.access$getSameProductPageParams$p(this.this$0);
            if (r15 == null) goto L24;
            String r16 = r15.getShopId();
        L25:
            SameProductPageParams r12 = SameProductViewModel.access$getSameProductPageParams$p(this.this$0);
            if (r12 == null) goto L28;
            String r17 = r12.getVideoId();
        L29:
            String r18 = d0.a();
            SameProductPageParams r19 = SameProductViewModel.access$getSameProductPageParams$p(this.this$0);
            if (r19 == null) goto L34;
            AnchorV3PromotionRequestParam r110 = r19.getMainCardRequestParam();
            if (r110 == null) goto L34;
            Integer r20 = r110.getSameProductScene();
        L35:
            Observable r21 = InnerGuessULikeApi.b.a(r2, r3, 6, r5, "product_flow_page", r7, r8, r9, "from_internal_feed", 7, r11, r14, null, r16, r17, r18, null, null, r20, null, null, null, null, null, false, false, null, 66947072);
            if (r21 == null) goto L46;
            Observable r22 = r21.subscribeOn(Schedulers.io());
            if (r22 == null) goto L47;
            Observable r23 = r22.observeOn(AndroidSchedulers.mainThread());
            if (r23 == null) goto L48;
            r23.subscribe(new AnonymousClass2(this));
            return;
        L48:
            return;
        L47:
            return;
        L46:
            return;
        L34:
            r20 = null;
            goto L35
        L28:
            r17 = null;
            goto L29
        L24:
            r16 = null;
            goto L25
        L20:
            r14 = null;
        L16:
            r11 = null;
            goto L17
        L45:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((SameProductState) r1);
            return Unit.INSTANCE;
        }
    }

    static {
        Companion = new a();
    }

    public Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.$$delegate_0.add(r2);
        return r2;
    }

    public void clearDisposable() {
        this.$$delegate_0.clearDisposable();
    }

    public void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.$$delegate_0.remove(r2);
    }

    public CompositeDisposable compositeDisposable() {
        return this.$$delegate_0.a();
    }

    public SameProductState defaultState() {
        return new SameProductState(0);
    }

    public final void loadMainProductCard() {
        SameProductPageParams r0 = this.sameProductPageParams;
        if (r0 == null) goto L5;
        final String r1 = r0.getMainPromotionId();
    L7:
        if (TextUtils.isEmpty(r1) == false) goto L9;
        return;
    L9:
        SameProductPageParams r2 = this.sameProductPageParams;
        if (r2 == null) goto L16;
        final AnchorV3PromotionRequestParam r3 = r2.getMainCardRequestParam();
        if (r3 == null) goto L17;
        withState(new AnonymousClass1(this, r3, r1));
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void loadSameProductList() {
        SameProductPageParams r0 = this.sameProductPageParams;
        if (r0 == null) goto L6;
        String r1 = r0.getMainProductId();
        if (r1 == null) goto L6;
    L8:
        if (TextUtils.isEmpty(r1) == false) goto L10;
        return;
    L10:
        withState(new C03261(this, r1));
        return;
    L6:
        r1 = "";
        goto L8
    }

    public SameProductViewModel() {
        this.$$delegate_0 = new DisposableScope();
        this.productHeaderList = CollectionsKt.emptyList();
        this.listPage = 1;
        this.filterProductHelper = new m();
        this.isFirstLoadList = true;
        this.showedProductIds = new HashSet();
    }

    public final String getEcomSceneId() {
        return this.ecomSceneId;
    }

    public final m getFilterProductHelper() {
        return this.filterProductHelper;
    }

    public final boolean getHasFirstLoadedProductList() {
        return this.hasFirstLoadedProductList;
    }

    public final InnerFlowPageStyleDTO getInnerFlowPageStyle() {
        return this.innerFlowPageStyle;
    }

    public final PromotionProductStruct getMainCardPromotion() {
        return this.mainCardPromotion;
    }

    public final SameProductPageParams getPageParams() {
        return this.sameProductPageParams;
    }

    public final int getProductListStyle() {
        return this.productListStyle;
    }

    public final HashSet<String> getShowedProductIds() {
        return this.showedProductIds;
    }

    public final SkuRestoreState getSkuPanelState() {
        return this.skuPanelState;
    }

    public final boolean isFirstLoadList() {
        return this.isFirstLoadList;
    }

    public final boolean isMainProductApiError() {
        return this.isMainProductApiError;
    }

    public final boolean isProductListApiError() {
        return this.isProductListApiError;
    }

    /* JADX INFO: renamed from: defaultState, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ State m2713defaultState() {
        return defaultState();
    }

    public static final /* synthetic */ int access$getListCursor$p(SameProductViewModel r0) {
        return r0.listCursor;
    }

    public static final /* synthetic */ int access$getListPage$p(SameProductViewModel r0) {
        return r0.listPage;
    }

    public static final /* synthetic */ List access$getProductHeaderList$p(SameProductViewModel r0) {
        return r0.productHeaderList;
    }

    public static final /* synthetic */ Disposable access$getSameProductListDisposable$p(SameProductViewModel r0) {
        return r0.sameProductListDisposable;
    }

    public static final /* synthetic */ SameProductPageParams access$getSameProductPageParams$p(SameProductViewModel r0) {
        return r0.sameProductPageParams;
    }

    private final String getFilterProductIds(SameProductPageParams r7) {
        StringBuilder r0 = new StringBuilder();
        ArrayList<String> r1 = this.filterProductHelper.b;
        if (r7 == null) goto L6;
        List<String> r8 = r7.getFilterProductIds();
        if (r8 == null) goto L6;
    L7:
        ArrayList r2 = new ArrayList();
        r2.addAll(r8);
        r2.addAll(r1);
        int r4 = 0;
        if ((r1.size() + r8.size()) <= 100) goto L10;
        r2.removeAll(r2.subList(0, (r1.size() + r8.size()) - 100));
    L10:
        Iterator r9 = r2.iterator();
    L12:
        if (r9.hasNext() == false) goto L21;
        Object r3 = r9.next();
        int r5 = r4 + 1;
        if (r4 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        r0.append((String) r3);
        if (r4 >= (r2.size() - 1)) goto L19;
        r0.append(",");
    L19:
        r4 = r5;
        goto L12
    L21:
        return r0.toString();
    L6:
        r8 = new ArrayList();
        goto L7
    }

    public final void setEcomSceneId(String r1) {
        this.ecomSceneId = r1;
    }

    public final void setFirstLoadList(boolean r1) {
        this.isFirstLoadList = r1;
    }

    public final void setHasFirstLoadedProductList(boolean r1) {
        this.hasFirstLoadedProductList = r1;
    }

    public final void setInnerFlowPageStyle(InnerFlowPageStyleDTO r1) {
        this.innerFlowPageStyle = r1;
    }

    public final void setMainCardPromotion(PromotionProductStruct r1) {
        this.mainCardPromotion = r1;
    }

    public final void setMainProductApiError(boolean r1) {
        this.isMainProductApiError = r1;
    }

    public final void setPageParams(SameProductPageParams r2) {
        this.sameProductPageParams = r2;
        if (r2 == null) goto L5;
        String r3 = r2.getEntranceInfo();
    L6:
        JSONObject r4 = z1.g(r3);
        if (r4 == null) goto L10;
        this.ecomSceneId = r4.optString("ecom_scene_id");
        return;
    L10:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void setProductListApiError(boolean r1) {
        this.isProductListApiError = r1;
    }

    public final void setProductListStyle(int r1) {
        this.productListStyle = r1;
    }

    public final void setShowedProductIds(HashSet<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.showedProductIds = r2;
    }

    public final void setSkuPanelState(SkuRestoreState r1) {
        this.skuPanelState = r1;
    }

    public final void updatePromotion(PromotionProductStruct r2) {
        Intrinsics.checkNotNullParameter(r2, "promotionResult");
        this.mainCardPromotion = r2;
        if (this.productHeaderList.isEmpty() == false) goto L8;
        ArrayList r3 = new ArrayList();
        PromotionProductStruct r0 = this.mainCardPromotion;
        if (r0 == null) goto L7;
        r3.add(r0);
    L7:
        Unit r1 = Unit.INSTANCE;
        this.productHeaderList = r3;
    L8:
        setState(new AnonymousClass2(this));
    }

    public static final /* synthetic */ String access$getFilterProductIds(SameProductViewModel r0, SameProductPageParams r1) {
        return r0.getFilterProductIds(r1);
    }

    public static final /* synthetic */ void access$setListCursor$p(SameProductViewModel r0, int r1) {
        r0.listCursor = r1;
    }

    public static final /* synthetic */ void access$setListPage$p(SameProductViewModel r0, int r1) {
        r0.listPage = r1;
    }

    public static final /* synthetic */ void access$setProductHeaderList$p(SameProductViewModel r0, List r1) {
        r0.productHeaderList = r1;
    }

    public static final /* synthetic */ void access$setSameProductListDisposable$p(SameProductViewModel r0, Disposable r1) {
        r0.sameProductListDisposable = r1;
    }

    public static final /* synthetic */ void access$setSameProductPageParams$p(SameProductViewModel r0, SameProductPageParams r1) {
        r0.sameProductPageParams = r1;
    }

    public static final /* synthetic */ void access$setState(SameProductViewModel r0, Function1 r1) {
        r0.setState(r1);
    }
}
