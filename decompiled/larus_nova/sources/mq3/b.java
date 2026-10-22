package mq3;

import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.home.tab.tabplugin.TabNavigationParams;
import com.bytedance.android.window.shop.home.tab.tabplugin.WindowNavigationParam;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements mq3.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f514794n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f514795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f514796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f514797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f514798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f514799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f514800f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f514801g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f514802h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f514803i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f514804j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f514805k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f514806l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f514807m;

    public static final class a {
    }

    static {
        fo.a<WindowLayoutType> r100 = WindowConstDef.f188713a;
        f514794n = ((Number) WindowConstDef.f188720h.getValue()).intValue();
    }

    public b() {
        this.f514795a = "";
        this.f514798d = f514794n;
        this.f514803i = 1;
    }

    @Override // mq3.a
    public final String getCommonPassThroughParam() {
        return this.f514800f;
    }

    @Override // mq3.a
    public final String getEcExtra() {
        return this.f514806l;
    }

    @Override // mq3.a
    public final String getExtensionCardParam() {
        return this.f514801g;
    }

    @Override // mq3.a
    public final String getForceInsertInfo() {
        return this.f514804j;
    }

    @Override // mq3.a
    public final int getPageNum() {
        return this.f514797c;
    }

    @Override // mq3.a
    public final int getPageSize() {
        return this.f514798d;
    }

    @Override // mq3.a
    public final String getPassThroughApi() {
        return this.f514799e;
    }

    @Override // mq3.a
    public final String getPath() {
        return this.f514802h;
    }

    @Override // mq3.a
    public final String getSecAuthorId() {
        return this.f514795a;
    }

    @Override // mq3.a
    public final int getTabType() {
        return this.f514796b;
    }

    @Override // mq3.a
    public final Integer getUpgradeVersion() {
        return this.f514803i;
    }

    @Override // mq3.a
    public final boolean isFirstEnter() {
        return this.f514805k;
    }

    @Override // mq3.a
    public final int isPrefetch() {
        return this.f514807m;
    }

    @Override // mq3.a
    public final void fillWithNaviParams(TabNavigationParams r100) {
        Intrinsics.checkNotNullParameter(r100, "naviParams");
        WindowNavigationParam<String> r101 = r100.getForceInsertInfo();
        if (r101 == null) goto L5;
        WindowNavigationParam.a r102 = WindowNavigationParam.Companion;
        String r103 = this.f514804j;
        r102.getClass();
        String r104 = (String) WindowNavigationParam.a.a(r101, r103);
    L6:
        this.f514804j = r104;
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // mq3.a
    public final void setCommonPassThroughParam(String r100) {
        this.f514800f = r100;
    }

    @Override // mq3.a
    public final void setExtensionCardParam(String r100) {
        this.f514801g = r100;
    }

    @Override // mq3.a
    public final void setFirstEnter(boolean r100) {
        this.f514805k = r100;
    }

    @Override // mq3.a
    public final void setForceInsertInfo(String r100) {
        this.f514804j = r100;
    }

    @Override // mq3.a
    public final void setPageNum(int r100) {
        this.f514797c = r100;
    }

    @Override // mq3.a
    public final void setPassThroughApi(String r100) {
        this.f514799e = r100;
    }

    @Override // mq3.a
    public final void setPath(String r100) {
        this.f514802h = r100;
    }

    @Override // mq3.a
    public final void setSecAuthorId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f514795a = r100;
    }

    @Override // mq3.a
    public final void setTabType(int r100) {
        this.f514796b = r100;
    }
}
