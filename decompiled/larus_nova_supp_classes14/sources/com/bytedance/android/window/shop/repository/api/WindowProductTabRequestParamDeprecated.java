package com.bytedance.android.window.shop.repository.api;

import com.bytedance.android.window.shop.home.tab.tabplugin.TabNavigationParams;
import com.bytedance.android.window.shop.home.tab.tabplugin.WindowNavigationParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mq3.c;
import mq3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u000bR\u001c\u0010 \u001a\u00020\u00078\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u000bR\u001e\u0010#\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b!\u0010\t\"\u0004\b\"\u0010\u000b¨\u0006&"}, d2 = {"Lcom/bytedance/android/window/shop/repository/api/WindowProductTabRequestParamDeprecated;", "Lcom/bytedance/android/window/shop/repository/api/WindowTabRequestParam;", "Lmq3/c;", "Lcom/bytedance/android/window/shop/home/tab/tabplugin/TabNavigationParams;", "naviParams", "", "fillWithNaviParams", "", "getChildCategory", "()Ljava/lang/String;", "setChildCategory", "(Ljava/lang/String;)V", "childCategory", "getClickedProducts", "clickedProducts", "", "getSort", "()Ljava/lang/Integer;", "setSort", "(Ljava/lang/Integer;)V", "sort", "", "getSortType", "()Ljava/lang/Long;", "setSortType", "(Ljava/lang/Long;)V", "sortType", "getTargetCategory", "setTargetCategory", "targetCategory", "getTargetFilterType", "setTargetFilterType", "targetFilterType", "getTargetSubCategory", "setTargetSubCategory", "targetSubCategory", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowProductTabRequestParamDeprecated extends WindowTabRequestParam implements c {
    private final /* synthetic */ d $$delegate_0;

    @Override // mq3.c
    public String getClickedProducts() {
        return this.$$delegate_0.getClickedProducts();
    }

    @Override // mq3.c
    public String getChildCategory() {
        return this.$$delegate_0.f;
    }

    @Override // mq3.c
    public Integer getSort() {
        return this.$$delegate_0.b;
    }

    @Override // mq3.c
    public Long getSortType() {
        return this.$$delegate_0.a;
    }

    @Override // mq3.c
    public String getTargetCategory() {
        return this.$$delegate_0.d;
    }

    @Override // mq3.c
    public String getTargetFilterType() {
        return this.$$delegate_0.c;
    }

    @Override // mq3.c
    public String getTargetSubCategory() {
        return this.$$delegate_0.e;
    }

    public WindowProductTabRequestParamDeprecated() {
        this.$$delegate_0 = new d();
    }

    @Override // com.bytedance.android.window.shop.repository.api.WindowTabRequestParam, mq3.a
    public void fillWithNaviParams(TabNavigationParams r5) {
        Intrinsics.checkNotNullParameter(r5, "naviParams");
        super.fillWithNaviParams(r5);
        WindowNavigationParam<String> r0 = r5.getForceInsertInfo();
        String r1 = null;
        if (r0 == null) goto L5;
        WindowNavigationParam.a r2 = WindowNavigationParam.Companion;
        String r3 = getForceInsertInfo();
        r2.getClass();
        String r4 = (String) WindowNavigationParam.a.a(r0, r3);
    L6:
        setForceInsertInfo(r4);
        WindowNavigationParam<String> r6 = r5.getCategoryId();
        if (r6 == null) goto L9;
        WindowNavigationParam.a r7 = WindowNavigationParam.Companion;
        String r8 = getTargetCategory();
        r7.getClass();
        r1 = (String) WindowNavigationParam.a.a(r6, r8);
    L9:
        setTargetCategory(r1);
        if (r5.getSortType() == null) goto L13;
        setSortType(r5.getSortType());
        return;
    L13:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public void setChildCategory(String r2) {
        this.$$delegate_0.f = r2;
    }

    public void setSort(Integer r2) {
        this.$$delegate_0.b = r2;
    }

    public void setSortType(Long r2) {
        this.$$delegate_0.a = r2;
    }

    public void setTargetCategory(String r2) {
        this.$$delegate_0.d = r2;
    }

    public void setTargetFilterType(String r3) {
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        d r1 = this.$$delegate_0;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r1.c = r3;
    }

    public void setTargetSubCategory(String r2) {
        this.$$delegate_0.e = r2;
    }
}
