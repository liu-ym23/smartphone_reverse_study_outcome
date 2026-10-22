package com.bytedance.android.window.shop.repository.api;

import com.bytedance.android.window.shop.home.tab.tabplugin.TabNavigationParams;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mq3.a;
import mq3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001c\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b5\u00106J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0017\u001a\u00020\u00168\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u00020\u001b8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\"\u001a\u00020\u001b8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001c\u0010%\u001a\u00020\u001b8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b#\u0010\u001d\"\u0004\b$\u0010\u001fR\u001e\u0010(\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b&\u0010\t\"\u0004\b'\u0010\u000bR\u001e\u0010+\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b)\u0010\t\"\u0004\b*\u0010\u000bR\u001c\u0010.\u001a\u00020\u00078\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b,\u0010\t\"\u0004\b-\u0010\u000bR\u001c\u00101\u001a\u00020\u001b8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u0010\u001fR\u0016\u00104\u001a\u0004\u0018\u00010\u001b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/bytedance/android/window/shop/repository/api/WindowTabRequestParam;", "Ljava/io/Serializable;", "Lmq3/a;", "Lcom/bytedance/android/window/shop/home/tab/tabplugin/TabNavigationParams;", "naviParams", "", "fillWithNaviParams", "", "getCommonPassThroughParam", "()Ljava/lang/String;", "setCommonPassThroughParam", "(Ljava/lang/String;)V", "commonPassThroughParam", "getEcExtra", "setEcExtra", "ecExtra", "getExtensionCardParam", "setExtensionCardParam", "extensionCardParam", "getForceInsertInfo", "setForceInsertInfo", "forceInsertInfo", "", "isFirstEnter", "()Z", "setFirstEnter", "(Z)V", "", "isPrefetch", "()I", "setPrefetch", "(I)V", "getPageNum", "setPageNum", "pageNum", "getPageSize", "setPageSize", "pageSize", "getPassThroughApi", "setPassThroughApi", "passThroughApi", "getPath", "setPath", "path", "getSecAuthorId", "setSecAuthorId", "secAuthorId", "getTabType", "setTabType", "tabType", "getUpgradeVersion", "()Ljava/lang/Integer;", "upgradeVersion", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class WindowTabRequestParam implements Serializable, a {
    private final /* synthetic */ b $$delegate_0;

    public void fillWithNaviParams(TabNavigationParams r2) {
        Intrinsics.checkNotNullParameter(r2, "naviParams");
        this.$$delegate_0.fillWithNaviParams(r2);
    }

    @Override // mq3.a
    public String getCommonPassThroughParam() {
        return this.$$delegate_0.f;
    }

    @Override // mq3.a
    public String getEcExtra() {
        return this.$$delegate_0.l;
    }

    @Override // mq3.a
    public String getExtensionCardParam() {
        return this.$$delegate_0.g;
    }

    @Override // mq3.a
    public String getForceInsertInfo() {
        return this.$$delegate_0.j;
    }

    @Override // mq3.a
    public int getPageNum() {
        return this.$$delegate_0.c;
    }

    @Override // mq3.a
    public int getPageSize() {
        return this.$$delegate_0.d;
    }

    @Override // mq3.a
    public String getPassThroughApi() {
        return this.$$delegate_0.e;
    }

    @Override // mq3.a
    public String getPath() {
        return this.$$delegate_0.h;
    }

    @Override // mq3.a
    public String getSecAuthorId() {
        return this.$$delegate_0.a;
    }

    @Override // mq3.a
    public int getTabType() {
        return this.$$delegate_0.b;
    }

    @Override // mq3.a
    public Integer getUpgradeVersion() {
        return this.$$delegate_0.i;
    }

    @Override // mq3.a
    public boolean isFirstEnter() {
        return this.$$delegate_0.k;
    }

    @Override // mq3.a
    public int isPrefetch() {
        return this.$$delegate_0.m;
    }

    public WindowTabRequestParam() {
        this.$$delegate_0 = new b();
    }

    @Override // mq3.a
    public void setCommonPassThroughParam(String r2) {
        this.$$delegate_0.f = r2;
    }

    public void setEcExtra(String r2) {
        this.$$delegate_0.l = r2;
    }

    @Override // mq3.a
    public void setExtensionCardParam(String r2) {
        this.$$delegate_0.g = r2;
    }

    @Override // mq3.a
    public void setFirstEnter(boolean r2) {
        this.$$delegate_0.k = r2;
    }

    @Override // mq3.a
    public void setForceInsertInfo(String r2) {
        this.$$delegate_0.j = r2;
    }

    @Override // mq3.a
    public void setPageNum(int r2) {
        this.$$delegate_0.c = r2;
    }

    public void setPageSize(int r2) {
        this.$$delegate_0.d = r2;
    }

    @Override // mq3.a
    public void setPassThroughApi(String r2) {
        this.$$delegate_0.e = r2;
    }

    @Override // mq3.a
    public void setPath(String r2) {
        this.$$delegate_0.h = r2;
    }

    public void setPrefetch(int r2) {
        this.$$delegate_0.m = r2;
    }

    @Override // mq3.a
    public void setSecAuthorId(String r3) {
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        b r1 = this.$$delegate_0;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r1.a = r3;
    }

    @Override // mq3.a
    public void setTabType(int r2) {
        this.$$delegate_0.b = r2;
    }
}
