package mq3;

import com.bytedance.android.window.shop.home.tab.tabplugin.TabNavigationParams;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface a extends e {
    void fillWithNaviParams(TabNavigationParams r1);

    String getCommonPassThroughParam();

    String getEcExtra();

    String getExtensionCardParam();

    String getForceInsertInfo();

    int getPageNum();

    int getPageSize();

    String getPassThroughApi();

    String getPath();

    String getSecAuthorId();

    int getTabType();

    Integer getUpgradeVersion();

    boolean isFirstEnter();

    int isPrefetch();

    void setCommonPassThroughParam(String r1);

    void setExtensionCardParam(String r1);

    void setFirstEnter(boolean r1);

    void setForceInsertInfo(String r1);

    void setPageNum(int r1);

    void setPassThroughApi(String r1);

    void setPath(String r1);

    void setSecAuthorId(String r1);

    void setTabType(int r1);
}
