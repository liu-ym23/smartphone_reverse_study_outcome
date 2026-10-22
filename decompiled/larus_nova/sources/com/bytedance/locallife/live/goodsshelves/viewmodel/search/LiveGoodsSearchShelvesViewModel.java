package com.bytedance.locallife.live.goodsshelves.viewmodel.search;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomLifeGrouponInfo;
import com.bytedance.locallife.live.dsl.shelf.LiveLocalLifeShelfDSLEngine;
import com.bytedance.locallife.live.experiment.a0;
import com.bytedance.locallife.live.experiment.m0;
import com.bytedance.locallife.live.experiment.n0;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesCard;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesDSLPagingResponse;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesResponse;
import com.bytedance.locallife.live.goodsshelves.manager.ShelfDefaultTabManager;
import com.bytedance.locallife.live.goodsshelves.manager.i;
import com.bytedance.locallife.live.goodsshelves.repository.GoodsShelvesRepository;
import com.bytedance.locallife.live.goodsshelves.repository.l;
import com.bytedance.locallife.live.goodsshelves.repository.m;
import com.bytedance.locallife.live.goodsshelves.viewmodel.LiveGoodsShelvesViewModel;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.locallife.live.util.LiveLocalLifeUtil;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nv6.l0;
import qv6.f;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J.\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\nR\"\u0010\u0013\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 ¨\u0006)"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/viewmodel/search/LiveGoodsSearchShelvesViewModel;", "Lcom/bytedance/locallife/live/goodsshelves/viewmodel/LiveGoodsShelvesViewModel;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/locallife/live/goodsshelves/manager/i;", "couponMigrationInfo", "Lqv6/f;", com.bytedance.android.ec.core.event.a.KEY_TRACKER, "Lcom/bytedance/locallife/live/goodsshelves/repository/GoodsShelvesRepository;", "repository", "", "init", "Lcom/bytedance/locallife/live/goodsshelves/viewmodel/LiveGoodsShelvesViewModel$ShelfType;", "getShelfType", "initSearchResultList", "hideEmptyListFragment", "Lcom/bytedance/locallife/live/goodsshelves/repository/m;", "getSearchShelvesRepository", LiveCommonConstants.REASON_ON_DEDTROY, "goodsShelvesRepository", "Lcom/bytedance/locallife/live/goodsshelves/repository/GoodsShelvesRepository;", "getGoodsShelvesRepository", "()Lcom/bytedance/locallife/live/goodsshelves/repository/GoodsShelvesRepository;", "setGoodsShelvesRepository", "(Lcom/bytedance/locallife/live/goodsshelves/repository/GoodsShelvesRepository;)V", "Landroidx/lifecycle/MutableLiveData;", "Lnv6/l0;", "searchResult", "Landroidx/lifecycle/MutableLiveData;", "getSearchResult", "()Landroidx/lifecycle/MutableLiveData;", "setSearchResult", "(Landroidx/lifecycle/MutableLiveData;)V", "", "closeListFragment", "getCloseListFragment", "setCloseListFragment", "", "uniqueKey", "<init>", "(Ljava/lang/String;)V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveGoodsSearchShelvesViewModel extends LiveGoodsShelvesViewModel {
    private MutableLiveData<Boolean> closeListFragment;
    private GoodsShelvesRepository goodsShelvesRepository;
    private MutableLiveData<l0> searchResult;

    public final m getSearchShelvesRepository() {
        GoodsShelvesRepository r100 = getGoodsShelvesRepository();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.locallife.live.goodsshelves.repository.SearchShelvesRepository");
        return (m) r100;
    }

    public final void hideEmptyListFragment() {
        if (getLiveGoodsShelfPagingResponse().getValue() == null) goto L18;
        LiveGoodsShelvesDSLPagingResponse r100 = getLiveGoodsShelfPagingResponse().getValue();
        if (r100 == null) goto L7;
        LiveGoodsShelvesResponse r101 = r100.f259555e;
    L8:
        if (r101 == null) goto L18;
        LiveGoodsShelvesDSLPagingResponse r102 = getLiveGoodsShelfPagingResponse().getValue();
        if (r102 == null) goto L16;
        LiveGoodsShelvesResponse r103 = r102.f259555e;
        if (r103 == null) goto L16;
        List<LiveGoodsShelvesCard> r104 = r103.getCard_list();
        if (r104 == null) goto L16;
        int r105 = r104.size();
    L17:
        if (r105 <= 0) goto L18;
        return;
    L16:
        r105 = 0;
        goto L17
    L7:
        r101 = null;
    L18:
        this.closeListFragment.setValue(Boolean.TRUE);
    }

    public final void initSearchResultList() {
        Room r100 = LiveLocalLifeUtil.d(getUniqueKey());
        boolean r101 = LiveLifeSaaSUtil.v().a();
        LinkedHashMap r110 = new LinkedHashMap();
        m r111 = getSearchShelvesRepository();
        if (r100 == null) goto L9;
        RoomLifeGrouponInfo r102 = r100.lifeGrouponInfo;
        if (r102 == null) goto L9;
        Long r103 = r102.getAggCardId();
        if (r103 == null) goto L9;
        String r104 = r103.toString();
    L10:
        String r105 = String.valueOf(r101 ? 1 : 0);
        if (r100 == null) goto L13;
        String r106 = r100.getIdStr();
    L14:
        if (r100 == null) goto L16;
        String r107 = r100.getOwnerUserIdString();
    L17:
        i r108 = getCouponMigrationInfo();
        if (r108 != null) goto L20;
        r108 = new i();
    L20:
        l r109 = new l(r104, r105, r106, r107, 1, ShelfDefaultTabManager.b(), r108, n0.a().c(), n0.a().a(), r110);
        setPagingRequestParam(r109);
        Unit r112 = Unit.INSTANCE;
        setLifeShelfPagedList(r111.c(r109));
        return;
    L16:
        r107 = null;
        goto L17
    L13:
        r106 = null;
    L9:
        r104 = null;
        goto L10
    }

    public final MutableLiveData<Boolean> getCloseListFragment() {
        return this.closeListFragment;
    }

    @Override // com.bytedance.locallife.live.goodsshelves.viewmodel.LiveGoodsShelvesViewModel
    public GoodsShelvesRepository getGoodsShelvesRepository() {
        return this.goodsShelvesRepository;
    }

    public final MutableLiveData<l0> getSearchResult() {
        return this.searchResult;
    }

    @Override // com.bytedance.locallife.live.goodsshelves.viewmodel.LiveGoodsShelvesViewModel
    public LiveGoodsShelvesViewModel.ShelfType getShelfType() {
        return LiveGoodsShelvesViewModel.ShelfType.Search;
    }

    public final void onDestroy() {
        super.onDestory();
    }

    public LiveGoodsSearchShelvesViewModel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        super(r100);
        this.goodsShelvesRepository = new m(r100);
        this.searchResult = new MutableLiveData();
        this.closeListFragment = new MutableLiveData();
    }

    public final void setCloseListFragment(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.closeListFragment = r100;
    }

    @Override // com.bytedance.locallife.live.goodsshelves.viewmodel.LiveGoodsShelvesViewModel
    public void setGoodsShelvesRepository(GoodsShelvesRepository r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.goodsShelvesRepository = r100;
    }

    public final void setSearchResult(MutableLiveData<l0> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.searchResult = r100;
    }

    @Override // com.bytedance.locallife.live.goodsshelves.viewmodel.LiveGoodsShelvesViewModel
    public void init(Context r100, i r101, f r102, GoodsShelvesRepository r103) {
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_TRACKER);
        setLiveLifeLynxTracker(r102);
        setCurrentTabFilterData(new nv6.m(1, false));
        getDslCardEngine().a(r100, getLiveLifeLynxTracker());
        if (m0.a() == false) goto L10;
        m r104 = getSearchShelvesRepository();
        r104.getClass();
        Intrinsics.checkNotNullParameter(this, "shelfViewModel");
        r104.f259780o = this;
        LiveLocalLifeShelfDSLEngine r105 = getDslCardEngine();
        LiveLocalLifeShelfDSLEngine.a r106 = r104.e();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "dataReceiver");
        if (a0.a() == false) goto L8;
        r105.f259480m.add(r106);
    L8:
        r104.f259777l.f260492c = this;
        return;
    }
}
