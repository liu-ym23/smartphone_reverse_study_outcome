package com.bytedance.ee.bear.search.picker.filter;

import com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.FilterViewV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class BaseSearchFilterView$initItemClickListener$itemClickListener$1 implements FilterViewV2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseSearchFilterView f236843a;

    public BaseSearchFilterView$initItemClickListener$itemClickListener$1(BaseSearchFilterView r100) {
        this.f236843a = r100;
    }

    @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.FilterViewV2.c
    public final void a(cpc.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        String r101 = r100.f464753a;
        switch(r101.hashCode()) {
            case -1058114788: goto L34;
            case -862523263: goto L28;
            case -287027157: goto L22;
            case -286430077: goto L16;
            case 797302193: goto L10;
            case 1502331690: goto L6;
            default: goto L50;
        };
    L50:
        return;
    L6:
        if (r101.equals("doc/my_own") == false) goto L51;
        em5.b r102 = this.f236843a.getFilterDataHolder();
        final BaseSearchFilterView r103 = this.f236843a;
        r102.c("doc/my_own", null, new BaseSearchFilterView$initItemClickListener$itemClickListener$1$onFilterItemClick$1(r103));
        return;
    L51:
        return;
    L10:
        if (r101.equals("doc/type") == false) goto L52;
        a r104 = this.f236843a.getListener();
        if (r104 == null) goto L41;
        r104.Hj((em5.a) r100);
        return;
    L41:
        return;
    L52:
        return;
    L16:
        if (r101.equals("doc/in/wiki") == false) goto L53;
        a r105 = this.f236843a.getListener();
        if (r105 == null) goto L43;
        r105.WZ((em5.a) r100);
        return;
    L43:
        return;
    L53:
        return;
    L22:
        if (r101.equals("doc/in/chat") == false) goto L54;
        a r106 = this.f236843a.getListener();
        if (r106 == null) goto L45;
        r106.lZ((em5.a) r100);
        return;
    L45:
        return;
    L54:
        return;
    L28:
        if (r101.equals("doc/in/folder") == false) goto L55;
        a r107 = this.f236843a.getListener();
        if (r107 == null) goto L47;
        r107.PF((em5.a) r100);
        return;
    L47:
        return;
    L55:
        return;
    L34:
        if (r101.equals("doc/owner") == false) goto L56;
        a r108 = this.f236843a.getListener();
        if (r108 == null) goto L49;
        r108.j20((em5.a) r100);
        return;
    L49:
        return;
    }

    @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.FilterViewV2.c
    public final void b(cpc.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        em5.b r101 = this.f236843a.getFilterDataHolder();
        String r102 = r100.f464753a;
        final BaseSearchFilterView r103 = this.f236843a;
        r101.c(r102, null, new BaseSearchFilterView$initItemClickListener$itemClickListener$1$onFilterItemCancelClick$1(r103));
    }
}
