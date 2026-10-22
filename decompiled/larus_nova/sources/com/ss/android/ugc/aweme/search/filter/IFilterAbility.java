package com.ss.android.ugc.aweme.search.filter;

import android.view.View;
import com.ss.android.ugc.aweme.discover.model.commodity.select.RenderItem;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/IFilterAbility;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IFilterAbility {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void a(IFilterAbility r100, boolean r101, boolean r102, SearchResultParam r103, RenderItem r104, int r105) {
            if ((r105 & 1) == 0) goto L6;
            r101 = false;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = false;
        L9:
            if ((r105 & 4) == 0) goto L11;
            r103 = new SearchResultParam();
        L11:
            r100.l(r101, r102, r103);
        }
    }

    Integer a(View r100);

    IFilterMob b();

    boolean c(float r100);

    ILayoutFormatSwitch d();

    void f(boolean r100);

    View getContainerView();

    void h(float r100);

    void i();

    void l(boolean r100, boolean r101, SearchResultParam r102);

    ITabFilterAbility p();

    void t();
}
