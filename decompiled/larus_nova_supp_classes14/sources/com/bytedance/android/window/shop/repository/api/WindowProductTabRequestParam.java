package com.bytedance.android.window.shop.repository.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mq3.c;
import mq3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b \u0010!R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0017\u0010\u0005\"\u0004\b\u0018\u0010\u0007R\u001c\u0010\u001c\u001a\u00020\u00038\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001a\u0010\u0005\"\u0004\b\u001b\u0010\u0007R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001d\u0010\u0005\"\u0004\b\u001e\u0010\u0007¨\u0006\""}, d2 = {"Lcom/bytedance/android/window/shop/repository/api/WindowProductTabRequestParam;", "Lcom/bytedance/android/window/shop/repository/api/WindowTabRequestParam;", "Lmq3/c;", "", "getChildCategory", "()Ljava/lang/String;", "setChildCategory", "(Ljava/lang/String;)V", "childCategory", "getClickedProducts", "clickedProducts", "", "getSort", "()Ljava/lang/Integer;", "setSort", "(Ljava/lang/Integer;)V", "sort", "", "getSortType", "()Ljava/lang/Long;", "setSortType", "(Ljava/lang/Long;)V", "sortType", "getTargetCategory", "setTargetCategory", "targetCategory", "getTargetFilterType", "setTargetFilterType", "targetFilterType", "getTargetSubCategory", "setTargetSubCategory", "targetSubCategory", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowProductTabRequestParam extends WindowTabRequestParam implements c {
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

    public WindowProductTabRequestParam() {
        this.$$delegate_0 = new d();
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
