package com.ss.cast.discovery.mdns;

import com.byted.cast.common.ContextManager;
import com.byted.cast.common.NsdHelper;
import com.byted.cast.common.config.ConfigConstants;
import com.byted.cast.common.config.ConfigManager;

/* JADX INFO: loaded from: classes40.dex */
public class NsdUtils {
    private static final String TAG = null;

    public NsdUtils() {
    }

    public static NsdFactory.Type getNsdType() {
        return getNsdType(null);
    }

    public static boolean isDnssdEnabledFromGrayConfig() {
        return isDnssdEnabledFromGrayConfig(null);
    }

    public static boolean isDnssdEnabledFromLocalConfig() {
        return isDnssdEnabledFromLocalConfig(null);
    }

    public static boolean isEnableDnssd() {
        return isEnableDnssd(null);
    }

    public static boolean isEnableJmDNS() {
        return isEnableJmDNS(null);
    }

    public static boolean isJmDNSEnabledFromGrayConfig() {
        return isJmDNSEnabledFromGrayConfig(null);
    }

    public static boolean isJmDNSEnabledFromLocalConfig() {
        return isJmDNSEnabledFromLocalConfig(null);
    }

    static {
        TAG = "NsdUtils";
    }

    public static NsdFactory.Type getNsdType(ContextManager.CastContext r100) {
        NsdHelper r101 = ContextManager.getNsdHelper(r100);
        if (r101.isEnableJmdns() == false) goto L7;
        return NsdFactory.Type.TypeJmDNS;
    L7:
        if (r101.isEnableDnssd() == false) goto L11;
        return NsdFactory.Type.TypeDnssd;
    L11:
        return NsdFactory.Type.TypeNsdManager;
    }

    public static boolean isDnssdEnabledFromGrayConfig(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L6:
        return r101.getLocalGrayConfigByBoolean(ConfigConstants.FEATURE_DNSSD_SWITCH, false);
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L6
    }

    public static boolean isDnssdEnabledFromLocalConfig(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L6:
        if (Boolean.TRUE.equals(r101.getInitConfig().isForceDnssd()) == false) goto L8;
    L9:
        return true;
    L8:
        if (r101.getOptionByBoolean(10033, false) == true) goto L9;
        return false;
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L6
    }

    public static boolean isEnableDnssd(ContextManager.CastContext r100) {
        if (getNsdType(r100) != NsdFactory.Type.TypeDnssd) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isEnableJmDNS(ContextManager.CastContext r100) {
        if (getNsdType(r100) != NsdFactory.Type.TypeJmDNS) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isJmDNSEnabledFromGrayConfig(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L6:
        return r101.getLocalGrayConfigByBoolean(ConfigConstants.FEATURE_JMDNS_SWITCH, false);
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L6
    }

    public static boolean isJmDNSEnabledFromLocalConfig(ContextManager.CastContext r100) {
        if (r100 != null) goto L4;
        ConfigManager r101 = ConfigManager.getInstance();
    L6:
        if (Boolean.TRUE.equals(r101.getInitConfig().isForceJmDNS()) == false) goto L8;
    L9:
        return true;
    L8:
        if (r101.getOptionByBoolean(10074, false) == true) goto L9;
        return false;
    L4:
        r101 = ContextManager.getConfigManager(r100);
        goto L6
    }
}
