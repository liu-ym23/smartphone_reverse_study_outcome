package com.bytedance.android.shopping.store.shopfeed.viewmodel;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.ec.core.async.b;
import com.bytedance.android.ec.core.event.EventActionImpl;
import com.bytedance.android.ec.core.event.c;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListStyleDTO;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.shopfeed.ECShopInnerFlowShareHelper;
import com.bytedance.android.shopping.store.shopfeed.ShopFeedParam;
import com.bytedance.android.shopping.store.shopfeed.f;
import com.bytedance.android.shopping.store.shopfeed.list.ShopFeedDataSourceFactory;
import com.bytedance.android.shopping.store.shopfeed.list.ShopFeedLynxCardDataSource;
import com.bytedance.android.shopping.store.shopfeed.list.a;
import com.bytedance.android.shopping.store.slicecard.ShopSlcCardFactory;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001b\u0012\b\b\u0002\u0010q\u001a\u00020p\u0012\b\b\u0002\u0010s\u001a\u00020\u0003¢\u0006\u0004\bu\u0010vJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J \u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0006J\b\u0010\u000f\u001a\u00020\u0006H\u0014J\u0011\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0006H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001J@\u0010\u001b\u001a\u00020\u00062.\u0010\u001a\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00180\u0017\"\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001b\u001a\u00020\u00062\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001dH\u0096\u0001J\u001a\u0010!\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0096\u0001¢\u0006\u0004\b!\u0010\"J\t\u0010#\u001a\u00020\u0006H\u0096\u0001J`\u0010&\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00192\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010\u001d2.\u0010\u001a\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010%0\u00180\u0017\"\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010%0\u0018H\u0096\u0001¢\u0006\u0004\b&\u0010'Jp\u0010+\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00192\u0006\u0010*\u001a\u00020)2\u0006\u0010$\u001a\u00020\u00192\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010\u001d2.\u0010\u001a\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010%0\u00180\u0017\"\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010%0\u0018H\u0096\u0001¢\u0006\u0004\b+\u0010,JH\u0010-\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00192.\u0010\u001a\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00180\u0017\"\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0096\u0001¢\u0006\u0004\b-\u0010.J\\\u0010-\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010\u00192\b\u0010*\u001a\u0004\u0018\u00010)2.\u0010\u001a\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00180\u0017\"\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0096\u0001¢\u0006\u0004\b-\u0010/J;\u0010-\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010\u00192\b\u0010*\u001a\u0004\u0018\u00010)2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001dH\u0096\u0001J`\u0010-\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00192\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u001d2.\u0010\u001a\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00180\u0017\"\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0096\u0001¢\u0006\u0004\b-\u0010'J\u0017\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001dH\u0096\u0001J\t\u00102\u001a\u00020\u0019H\u0096\u0001J@\u00103\u001a\u00020\u00062.\u0010\u001a\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00180\u0017\"\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0096\u0001¢\u0006\u0004\b3\u0010\u001cJ\u001f\u00103\u001a\u00020\u00062\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001dH\u0096\u0001R\u001b\u00109\u001a\u0002048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u00106\u001a\u0004\b<\u0010=R\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020@0?8\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001d\u0010G\u001a\b\u0012\u0004\u0012\u00020F0E8\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR$\u0010L\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010R\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010\"R\u001d\u0010X\u001a\b\u0012\u0004\u0012\u00020W0?8\u0006¢\u0006\f\n\u0004\bX\u0010B\u001a\u0004\bY\u0010DR$\u0010[\u001a\u0004\u0018\u00010Z8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0014\u0010b\u001a\u00020a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010e\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR0\u0010j\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020i0h\u0018\u00010g8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u0014\u0010q\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010s\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010t¨\u0006w"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/viewmodel/ECShopFeedViewModel;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModel;", "Lcom/bytedance/android/ec/core/async/b;", "Lcom/bytedance/android/ec/core/event/c;", "Landroid/content/Context;", "context", "", "initSliceContext", "initDataSouce", "Landroid/os/Bundle;", "bundle", "", "needInitSlice", "initParam", "refresh", "onCleared", "Lio/reactivex/disposables/Disposable;", "disposable", "add", "clearDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "remove", "", "Lkotlin/Pair;", "", "params", "appendEventParams", "([Lkotlin/Pair;)V", "", "paramsMap", "", "monitorId", "bindMonitorId", "(Ljava/lang/Long;)V", "clearEventParams", "actionName", "", "doAnyEventAction", "(Ljava/lang/String;Ljava/util/Map;[Lkotlin/Pair;)V", "btm", "Lcom/bytedance/android/btm/api/model/PageFinder;", "pageFinder", "doAnyEventActionWithBtm", "(Ljava/lang/String;Lcom/bytedance/android/btm/api/model/PageFinder;Ljava/lang/String;Ljava/util/Map;[Lkotlin/Pair;)V", "doEventAction", "(Ljava/lang/String;[Lkotlin/Pair;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/btm/api/model/PageFinder;[Lkotlin/Pair;)V", "paramMap", "getBaseParams", "getBaseParamsJson", "initEventContext", "Lcom/bytedance/android/shopping/store/slicecard/b;", "sliceService$delegate", "Lkotlin/Lazy;", "getSliceService", "()Lcom/bytedance/android/shopping/store/slicecard/b;", "sliceService", "Lcom/bytedance/android/shopping/store/slicecard/ShopSlcCardFactory;", "sliceCardFactory$delegate", "getSliceCardFactory", "()Lcom/bytedance/android/shopping/store/slicecard/ShopSlcCardFactory;", "sliceCardFactory", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lfk3/a;", "topInfo", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getTopInfo", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Ljm/a;", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListStyleDTO;", "listStyle", "Ljm/a;", "getListStyle", "()Ljm/a;", "Lcom/bytedance/android/shopping/store/shopfeed/ShopFeedParam;", "shopFeedParam", "Lcom/bytedance/android/shopping/store/shopfeed/ShopFeedParam;", "getShopFeedParam", "()Lcom/bytedance/android/shopping/store/shopfeed/ShopFeedParam;", "setShopFeedParam", "(Lcom/bytedance/android/shopping/store/shopfeed/ShopFeedParam;)V", "routerStartTime", "Ljava/lang/Long;", "getRouterStartTime", "()Ljava/lang/Long;", "setRouterStartTime", "Lcom/bytedance/android/ec/store/shopping/paging/LoadStatus;", "loadStatus", "getLoadStatus", "Lcom/bytedance/android/shopping/store/shopfeed/ECShopInnerFlowShareHelper;", "shareHelper", "Lcom/bytedance/android/shopping/store/shopfeed/ECShopInnerFlowShareHelper;", "getShareHelper", "()Lcom/bytedance/android/shopping/store/shopfeed/ECShopInnerFlowShareHelper;", "setShareHelper", "(Lcom/bytedance/android/shopping/store/shopfeed/ECShopInnerFlowShareHelper;)V", "Lcom/bytedance/android/shopping/store/shopfeed/f;", "requestParam", "Lcom/bytedance/android/shopping/store/shopfeed/f;", "Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFeedDataSourceFactory;", "dataSourceFactory", "Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFeedDataSourceFactory;", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Lcom/bytedance/android/shopping/store/shopfeed/list/a;", "cardList", "Landroidx/lifecycle/LiveData;", "getCardList", "()Landroidx/lifecycle/LiveData;", "setCardList", "(Landroidx/lifecycle/LiveData;)V", "Lcom/bytedance/android/ec/core/async/DisposableScope;", "disposableContext", "Lcom/bytedance/android/ec/core/async/DisposableScope;", "eventAction", "Lcom/bytedance/android/ec/core/event/c;", "<init>", "(Lcom/bytedance/android/ec/core/async/DisposableScope;Lcom/bytedance/android/ec/core/event/c;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopFeedViewModel extends QViewModel implements b, c {
    private LiveData<PagedList<a>> cardList;
    private ShopFeedDataSourceFactory dataSourceFactory;
    private final DisposableScope disposableContext;
    private final c eventAction;
    private final jm.a<ECHybridListStyleDTO> listStyle;
    private final QLiveData<LoadStatus> loadStatus;
    private final f requestParam;
    private Long routerStartTime;
    private ECShopInnerFlowShareHelper shareHelper;
    private ShopFeedParam shopFeedParam;
    private final Lazy sliceCardFactory$delegate;
    private final Lazy sliceService$delegate;
    private final QLiveData<fk3.a> topInfo;

    public ECShopFeedViewModel() {
        DisposableScope r0 = null;
        this(r0, r0, 3, r0);
    }

    public Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.disposableContext.add(r2);
        return r2;
    }

    public void appendEventParams(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "paramsMap");
        this.eventAction.appendEventParams(r2);
    }

    public void appendEventParams(Pair<String, String>... r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.eventAction.appendEventParams(r2);
    }

    public void bindMonitorId(Long r2) {
        this.eventAction.bindMonitorId(r2);
    }

    public void clearDisposable() {
        this.disposableContext.clearDisposable();
    }

    public void clearEventParams() {
        this.eventAction.clearEventParams();
    }

    public void doAnyEventAction(String r2, Map<String, ? extends Object> r3, Pair<String, ? extends Object>... r4) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.eventAction.doAnyEventAction(r2, r3, r4);
    }

    public void doAnyEventActionWithBtm(String r8, PageFinder r9, String r10, Map<String, ? extends Object> r11, Pair<String, ? extends Object>... r12) {
        Intrinsics.checkNotNullParameter(r8, "btm");
        Intrinsics.checkNotNullParameter(r9, "pageFinder");
        Intrinsics.checkNotNullParameter(r10, "actionName");
        Intrinsics.checkNotNullParameter(r12, "params");
        this.eventAction.doAnyEventActionWithBtm(r8, r9, r10, r11, r12);
    }

    public void doEventAction(String r2, String r3, PageFinder r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r5, "paramMap");
        this.eventAction.doEventAction(r2, r3, r4, r5);
    }

    public void doEventAction(String r2, String r3, PageFinder r4, Pair<String, String>... r5) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r5, "params");
        this.eventAction.doEventAction(r2, r3, r4, r5);
    }

    public void doEventAction(String r2, Map<String, String> r3, Pair<String, String>... r4) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.eventAction.doEventAction(r2, r3, r4);
    }

    public void doEventAction(String r2, Pair<String, String>... r3) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.eventAction.doEventAction(r2, r3);
    }

    public Map<String, String> getBaseParams() {
        return this.eventAction.getBaseParams();
    }

    public String getBaseParamsJson() {
        return this.eventAction.getBaseParamsJson();
    }

    public final ShopSlcCardFactory getSliceCardFactory() {
        return (ShopSlcCardFactory) this.sliceCardFactory$delegate.getValue();
    }

    public final com.bytedance.android.shopping.store.slicecard.b getSliceService() {
        return (com.bytedance.android.shopping.store.slicecard.b) this.sliceService$delegate.getValue();
    }

    public void initEventContext(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "paramsMap");
        this.eventAction.initEventContext(r2);
    }

    public void initEventContext(Pair<String, String>... r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.eventAction.initEventContext(r2);
    }

    public void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.disposableContext.remove(r2);
    }

    private final void initDataSouce() {
        ShopFeedDataSourceFactory r8 = new ShopFeedDataSourceFactory(this.shopFeedParam, this.requestParam, this.loadStatus, this.topInfo, this.listStyle, getSliceService(), this);
        PagedList.Config.Builder r0 = new PagedList.Config.Builder();
        r0.setPageSize(5);
        r0.setInitialLoadSizeHint(5);
        ShopFeedParam r1 = this.shopFeedParam;
        if (r1 == null) goto L5;
        int r2 = r1.getPreloadNum();
    L6:
        r0.setPrefetchDistance(r2);
        r0.setEnablePlaceholders(false);
        this.cardList = new LivePagedListBuilder(r8, r0.build()).build();
        Unit r3 = Unit.INSTANCE;
        this.dataSourceFactory = r8;
        return;
    L5:
        r2 = 2;
        goto L6
    }

    public CompositeDisposable compositeDisposable() {
        return this.disposableContext.a();
    }

    public final void refresh() {
        f r0 = this.requestParam;
        r0.a = true;
        ShopFeedParam r1 = this.shopFeedParam;
        if (r1 == null) goto L5;
        String r2 = r1.getPaginationParams();
    L6:
        r0.f = r2;
        ShopFeedDataSourceFactory r3 = this.dataSourceFactory;
        if (r3 == null) goto L12;
        r3.h.clearDisposable();
        ShopFeedLynxCardDataSource r4 = (ShopFeedLynxCardDataSource) r3.a.getValue();
        if (r4 == null) goto L13;
        r4.invalidate();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public void onCleared() {
        super.onCleared();
        getSliceService().e();
    }

    public final LiveData<PagedList<a>> getCardList() {
        return this.cardList;
    }

    public final jm.a<ECHybridListStyleDTO> getListStyle() {
        return this.listStyle;
    }

    public final QLiveData<LoadStatus> getLoadStatus() {
        return this.loadStatus;
    }

    public final Long getRouterStartTime() {
        return this.routerStartTime;
    }

    public final ECShopInnerFlowShareHelper getShareHelper() {
        return this.shareHelper;
    }

    public final ShopFeedParam getShopFeedParam() {
        return this.shopFeedParam;
    }

    public final QLiveData<fk3.a> getTopInfo() {
        return this.topInfo;
    }

    private final void initSliceContext(Context r3) {
        getSliceService().b(r3, false);
    }

    public final void setCardList(LiveData<PagedList<a>> r1) {
        this.cardList = r1;
    }

    public final void setRouterStartTime(Long r1) {
        this.routerStartTime = r1;
    }

    public final void setShareHelper(ECShopInnerFlowShareHelper r1) {
        this.shareHelper = r1;
    }

    public final void setShopFeedParam(ShopFeedParam r1) {
        this.shopFeedParam = r1;
    }

    public ECShopFeedViewModel(DisposableScope r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "disposableContext");
        Intrinsics.checkNotNullParameter(r3, "eventAction");
        this.disposableContext = r2;
        this.eventAction = r3;
        this.sliceService$delegate = LazyKt.lazy(ECShopFeedViewModel$sliceService$2.INSTANCE);
        this.sliceCardFactory$delegate = LazyKt.lazy(new ECShopFeedViewModel$sliceCardFactory$2(this));
        this.topInfo = new QLiveData();
        this.listStyle = new jm.a(7);
        this.loadStatus = new QLiveData();
        this.requestParam = new f();
    }

    public final void initParam(Bundle r5, Context r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        String r0 = null;
        if (r5 == null) goto L5;
        Serializable r1 = r5.getSerializable("shop_feed_param");
    L7:
        if ((r1 instanceof ShopFeedParam) == true) goto L9;
        r1 = null;
    L9:
        this.shopFeedParam = (ShopFeedParam) r1;
        if (r5 == null) goto L12;
        Long r8 = Long.valueOf(r5.getLong("router_start_time", 0));
    L13:
        this.routerStartTime = r8;
        f r9 = this.requestParam;
        ShopFeedParam r2 = this.shopFeedParam;
        if (r2 == null) goto L16;
        Integer r3 = r2.getTabType();
    L17:
        r9.b = r3;
        ShopFeedParam r4 = this.shopFeedParam;
        if (r4 == null) goto L21;
        String r10 = r4.getSecShopId();
        if (r10 == null) goto L21;
    L22:
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r9.c = r10;
        ShopFeedParam r11 = this.shopFeedParam;
        if (r11 == null) goto L25;
        String r12 = r11.getScene();
    L26:
        r9.d = r12;
        ShopFeedParam r13 = this.shopFeedParam;
        if (r13 == null) goto L29;
        String r14 = r13.getBizExtra();
    L30:
        r9.e = r14;
        ShopFeedParam r15 = this.shopFeedParam;
        if (r15 == null) goto L33;
        r0 = r15.getPaginationParams();
    L33:
        r9.f = r0;
        initDataSouce();
        refresh();
        if (r7 == false) goto L37;
        initSliceContext(r6);
        return;
    L37:
        return;
    L29:
        r14 = null;
        goto L30
    L25:
        r12 = null;
    L21:
        r10 = "";
        goto L22
    L16:
        r3 = null;
        goto L17
    L12:
        r8 = null;
        goto L13
    L5:
        r1 = null;
        goto L7
    }

    public /* synthetic */ ECShopFeedViewModel(DisposableScope r1, c r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = new DisposableScope();
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = new EventActionImpl();
    L8:
        this(r1, r2);
    }
}
