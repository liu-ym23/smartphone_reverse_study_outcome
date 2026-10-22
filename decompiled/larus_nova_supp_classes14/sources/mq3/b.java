package mq3;

import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.home.tab.tabplugin.TabNavigationParams;
import com.bytedance.android.window.shop.home.tab.tabplugin.WindowNavigationParam;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements mq3.a {
    public static final int n = 0;
    public String a;
    public int b;
    public int c;
    public int d;
    public String e;
    public String f;
    public String g;
    public String h;
    public final Integer i;
    public String j;
    public boolean k;
    public String l;
    public int m;

    public static final class a {
    }

    static {
        fo.a<WindowLayoutType> r0 = WindowConstDef.a;
        n = ((Number) WindowConstDef.h.getValue()).intValue();
    }

    public b() {
        this.a = "";
        this.d = n;
        this.i = 1;
    }

    @Override // mq3.a
    public final String getCommonPassThroughParam() {
        return this.f;
    }

    @Override // mq3.a
    public final String getEcExtra() {
        return this.l;
    }

    @Override // mq3.a
    public final String getExtensionCardParam() {
        return this.g;
    }

    @Override // mq3.a
    public final String getForceInsertInfo() {
        return this.j;
    }

    @Override // mq3.a
    public final int getPageNum() {
        return this.c;
    }

    @Override // mq3.a
    public final int getPageSize() {
        return this.d;
    }

    @Override // mq3.a
    public final String getPassThroughApi() {
        return this.e;
    }

    @Override // mq3.a
    public final String getPath() {
        return this.h;
    }

    @Override // mq3.a
    public final String getSecAuthorId() {
        return this.a;
    }

    @Override // mq3.a
    public final int getTabType() {
        return this.b;
    }

    @Override // mq3.a
    public final Integer getUpgradeVersion() {
        return this.i;
    }

    @Override // mq3.a
    public final boolean isFirstEnter() {
        return this.k;
    }

    @Override // mq3.a
    public final int isPrefetch() {
        return this.m;
    }

    @Override // mq3.a
    public final void fillWithNaviParams(TabNavigationParams r3) {
        Intrinsics.checkNotNullParameter(r3, "naviParams");
        WindowNavigationParam<String> r4 = r3.getForceInsertInfo();
        if (r4 == null) goto L5;
        WindowNavigationParam.a r0 = WindowNavigationParam.Companion;
        String r1 = this.j;
        r0.getClass();
        String r5 = (String) WindowNavigationParam.a.a(r4, r1);
    L6:
        this.j = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // mq3.a
    public final void setCommonPassThroughParam(String r1) {
        this.f = r1;
    }

    @Override // mq3.a
    public final void setExtensionCardParam(String r1) {
        this.g = r1;
    }

    @Override // mq3.a
    public final void setFirstEnter(boolean r1) {
        this.k = r1;
    }

    @Override // mq3.a
    public final void setForceInsertInfo(String r1) {
        this.j = r1;
    }

    @Override // mq3.a
    public final void setPageNum(int r1) {
        this.c = r1;
    }

    @Override // mq3.a
    public final void setPassThroughApi(String r1) {
        this.e = r1;
    }

    @Override // mq3.a
    public final void setPath(String r1) {
        this.h = r1;
    }

    @Override // mq3.a
    public final void setSecAuthorId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    @Override // mq3.a
    public final void setTabType(int r1) {
        this.b = r1;
    }
}
