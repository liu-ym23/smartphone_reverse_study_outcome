package com.ss.android.lark.featuregating.interfaces;

import java.util.Map;
import java.util.Set;
import jdb.c;
import jdb.g;

/* JADX INFO: loaded from: classes35.dex */
public interface IFeatureGatingService extends g {
    @Override // jdb.g
    void addFeatureGatingUpdateListener(String r100, c r101, String r102);

    /* synthetic */ Set<String> allFg(String r100);

    void clear();

    Map<String, String> getChangedKeysBySyncUpdate(String r100, Map<String, String> r101);

    Set<String> getRuntimeFGSPCache(String r100, String r101);

    Set<String> getSettingsFGKeys();

    Map<String, Boolean> getUsedFGMap(String r100, String r101);

    /* synthetic */ boolean isCrossUserEnable(String r100);

    @Override // jdb.g
    boolean isCurrentEnable(String r100);

    boolean isCurrentEnable(String r100, boolean r101);

    @Override // jdb.g
    boolean isEnable(String r100);

    boolean isEnable(String r100, boolean r101);

    boolean isNoUserFGEnable(String r100);

    boolean isUserFGEnable(String r100);

    void notifySettingsFGChanged(Map<String, Boolean> r100, String r101);

    void notifySettingsFGNoUserChanged(Map<String, Boolean> r100, String r101);

    void reload();

    void removeFeatureGatingUpdateListener(c r100, String r101);
}
