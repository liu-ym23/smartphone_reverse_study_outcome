package mq3;

import com.bytedance.android.window.shop.home.tab.tabplugin.TabNavigationParams;

/* JADX INFO: loaded from: classes14.dex */
public interface a extends e {
    void fillWithNaviParams(TabNavigationParams r100);

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

    void setCommonPassThroughParam(String r100);

    void setExtensionCardParam(String r100);

    void setFirstEnter(boolean r100);

    void setForceInsertInfo(String r100);

    void setPageNum(int r100);

    void setPassThroughApi(String r100);

    void setPath(String r100);

    void setSecAuthorId(String r100);

    void setTabType(int r100);
}
