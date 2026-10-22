package com.ss.android.ugc.aweme.search.filter.view.component;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.model.commodity.select.RenderItem;
import com.ss.android.ugc.aweme.search.filter.ECSearchBaseFilterViewHolder;
import com.ss.android.ugc.aweme.search.filter.ECSearchFilterViewModel;
import com.ss.android.ugc.aweme.search.filter.IFilterAbility;
import com.ss.android.ugc.aweme.search.filter.IFilterMob;
import com.ss.android.ugc.aweme.search.mob.ItemMobParam;
import com.ss.android.ugc.aweme.search.mob.base.BaseFilterMobEvent;
import com.ss.android.ugc.aweme.search.mob.base.TrendingWordsMobEvent;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import com.ss.android.ugc.aweme.search.utils.DimensUtilKt;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/component/ECSearchBaseSearchFilterViewHolder;", "Lcom/ss/android/ugc/aweme/search/filter/ECSearchBaseFilterViewHolder;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECSearchBaseSearchFilterViewHolder extends ECSearchBaseFilterViewHolder {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f452988k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f452989l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ECSearchBaseSearchFilterViewHolder$attachStateChange$1 f452990m;

    public final ItemMobParam y() {
        ECSearchFilterViewModel r100 = this.f452777e;
        Object r101 = null;
        if (r100 == null) goto L7;
        HashMap<Class<?>, Object> r102 = r100.getBusinessParams();
        if (r102 == null) goto L7;
        Object r103 = r102.get(ItemMobParam.class);
    L9:
        if ((r103 instanceof ItemMobParam) == false) goto L12;
        r101 = r103;
    L12:
        ItemMobParam r104 = (ItemMobParam) r101;
        if (r104 != null) goto L16;
        ItemMobParam.f453297v.getClass();
        return ItemMobParam.Companion.a();
    L16:
        return r104;
    L7:
        r103 = null;
        goto L9
    }

    @Override // com.ss.android.ugc.aweme.search.filter.ECSearchBaseFilterViewHolder
    public void o() {
        super.o();
        this.f452989l = false;
        this.f452782j.removeOnAttachStateChangeListener(this.f452990m);
    }

    public boolean z() {
        return this.f452988k;
    }

    public ECSearchBaseSearchFilterViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f452988k = true;
        this.f452990m = new ECSearchBaseSearchFilterViewHolder$attachStateChange$1(this, r100);
    }

    @Override // com.ss.android.ugc.aweme.discover.model.commodity.select.BaseSelectItemView
    public void f(RenderItem r100) {
        Intrinsics.checkNotNullParameter(r100, "renderItem");
        super.f(r100);
        if (this.f452989l == true) goto L6;
        this.f452782j.removeOnAttachStateChangeListener(this.f452990m);
        this.f452782j.addOnAttachStateChangeListener(this.f452990m);
        this.f452989l = true;
        return;
    }

    @Override // com.ss.android.ugc.aweme.search.filter.ECSearchBaseFilterViewHolder, android.view.View.OnClickListener
    public void onClick(View r100) {
        super.onClick(r100);
        if (z() == false) goto L10;
        ECSearchFilterViewModel r101 = this.f452777e;
        if (r101 == null) goto L11;
        IFilterAbility r102 = r101.getFilterContainer();
        if (r102 == null) goto L12;
        r102.h(DimensUtilKt.a(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS)));
        return;
    L12:
        return;
    L11:
        return;
    }

    public static void A(ECSearchBaseSearchFilterViewHolder r100, SearchResultParam r101, int r102) {
        if ((r102 & 4) == 0) goto L5;
        r101 = new SearchResultParam();
    L5:
        SearchResultParam r103 = r101;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "searchResultParam");
        ECSearchFilterViewModel r104 = r100.f452777e;
        if (r104 == null) goto L11;
        IFilterAbility r105 = r104.getFilterContainer();
        if (r105 == null) goto L12;
        IFilterAbility.DefaultImpls.a(r105, false, false, r103, null, 24);
        return;
    L12:
        return;
    }

    public final void w(BaseFilterMobEvent r100, SearchResultParam r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendSearchResultParam");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        ECSearchFilterViewModel r103 = this.f452777e;
        String r104 = null;
        if (r103 == null) goto L9;
        IFilterAbility r105 = r103.getFilterContainer();
        if (r105 == null) goto L9;
        IFilterMob r106 = r105.b();
        if (r106 == null) goto L9;
        String r107 = r106.getSearchType();
    L10:
        r100.f("search_type", r107);
        ECSearchFilterViewModel r108 = this.f452777e;
        if (r108 == null) goto L17;
        IFilterAbility r109 = r108.getFilterContainer();
        if (r109 == null) goto L17;
        IFilterMob r110 = r109.b();
        if (r110 == null) goto L17;
        String r111 = r110.getEnterFrom();
    L18:
        r100.f("enter_from", r111);
        if (r101 == null) goto L21;
        r104 = r101.getKeyword();
    L21:
        r100.f("search_keyword", r104);
        return;
    L17:
        r111 = null;
    L9:
        r107 = null;
        goto L10
    }

    public final void x(TrendingWordsMobEvent r100, SearchResultParam r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendSearchResultParam");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        ECSearchFilterViewModel r103 = this.f452777e;
        String r104 = null;
        if (r103 == null) goto L9;
        IFilterAbility r105 = r103.getFilterContainer();
        if (r105 == null) goto L9;
        IFilterMob r106 = r105.b();
        if (r106 == null) goto L9;
        String r107 = r106.getSearchType();
    L10:
        r100.f("search_type", r107);
        ECSearchFilterViewModel r108 = this.f452777e;
        if (r108 == null) goto L17;
        IFilterAbility r109 = r108.getFilterContainer();
        if (r109 == null) goto L17;
        IFilterMob r110 = r109.b();
        if (r110 == null) goto L17;
        String r111 = r110.getEnterFrom();
    L18:
        r100.f("enter_from", r111);
        if (r101 == null) goto L21;
        r104 = r101.getKeyword();
    L21:
        r100.f("search_keyword", r104);
        return;
    L17:
        r111 = null;
    L9:
        r107 = null;
        goto L10
    }
}
