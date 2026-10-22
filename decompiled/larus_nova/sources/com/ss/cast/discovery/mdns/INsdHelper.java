package com.ss.cast.discovery.mdns;

import com.byted.cast.common.ContextManager;
import com.byted.cast.common.api.ILibraryLoader;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public interface INsdHelper {
    public static final int NSDHELPER_TYPE_DNSSD = 2;
    public static final int NSDHELPER_TYPE_JMDNS = 3;
    public static final int NSDHELPER_TYPE_NSDMANAGER = 1;

    /* JADX INFO: renamed from: com.ss.cast.discovery.mdns.INsdHelper$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$setLibraryLoader(INsdHelper r100, ILibraryLoader r101) {
        }

        public static String $default$startDiscovery(INsdHelper r100, ContextManager.CastContext r101, String r102, String r103, NsdListener r104) {
            return null;
        }

        public static void $default$stopDiscovery(INsdHelper r100, ContextManager.CastContext r101, String r102) {
        }
    }

    int getNsdHelperType();

    String registerService(String r100, String r101, int r102, Map<String, String> r103, NsdListener r104);

    void setDiscoveryTimeout(int r100);

    void setLibraryLoader(ILibraryLoader r100);

    void setLogEnabled(boolean r100);

    void setNsdListener(NsdListener r100);

    String startDiscovery(ContextManager.CastContext r100, String r101, String r102, NsdListener r103);

    String startDiscovery(String r100, String r101, NsdListener r102);

    void stopDiscovery(ContextManager.CastContext r100, String r101);

    void stopDiscovery(String r100);

    void unregisterService(String r100);
}
