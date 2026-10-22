package jdb;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes35.dex */
public interface e {
    boolean B0(String r100, String r101);

    void Kb(String r100, c r101, String r102);

    void T(String r100, String r101, c r102, String r103);

    void Tc(String r100, boolean r101);

    void U1();

    void Y9();

    Set<String> allFg(String r100);

    Map<String, String> getChangedKeysBySyncUpdate(String r100, Map<String, String> r101);

    Set<String> getRuntimeFGSPCache(String r100, String r101);

    Set<String> getSettingsFGKeys();

    Map<String, Boolean> getUsedFGMap(String r100, String r101);

    void init();

    boolean isNoUserFGEnable(String r100);

    void notifySettingsFGChanged(Map<String, Boolean> r100, String r101);

    void notifySettingsFGNoUserChanged(Map<String, Boolean> r100, String r101);

    boolean tb(String r100, String r101);

    boolean x(String r100, String r101);
}
