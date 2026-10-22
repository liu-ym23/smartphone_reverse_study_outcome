package com.mammon.audiosdk.structures;

import com.mammon.audiosdk.enums.SAMICoreAbConfigType;

/* JADX INFO: loaded from: classes4.dex */
public class SAMICoreAbContext {
    private static volatile SAMICoreAbContext samiCoreABContext;
    public SAMICoreAbCallback callback;

    public static SAMICoreAbContext getInstance() {
        if (samiCoreABContext != null) goto L15;
        monitor-enter(SAMICoreAbContext.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (samiCoreABContext != null) goto L9;
        samiCoreABContext = new SAMICoreAbContext();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SAMICoreAbContext.class);     // Catch: Throwable -> L11
    L15:
        return samiCoreABContext;
    }

    public SAMICoreAbContext() {
        this.callback = null;
    }

    public static Boolean abConfigGettingBool(String r100) {
        System.out.println("[mammon] SAMI AB Config, abConfigGettingBool()");
        return getInstance().callback.getSAMICoreAbBoolConfig(r100);
    }

    public static Float abConfigGettingFloat(String r100) {
        System.out.println("[mammon] SAMI AB Config, abConfigGettingFloat()");
        return getInstance().callback.getSAMICoreAbFloatConfig(r100);
    }

    public static Integer abConfigGettingInt(String r100) {
        System.out.println("[mammon] SAMI AB Config, abConfigGettingInt()");
        return getInstance().callback.getSAMICoreAbIntConfig(r100);
    }

    public static String abConfigGettingString(String r100) {
        System.out.println("[mammon] SAMI AB Config, abConfigGettingString()");
        return getInstance().callback.getSAMICoreAbStringConfig(r100);
    }

    public void init(SAMICoreAbCallback r100) {
        this.callback = r100;
    }

    public static Object abConfigGetting(String r100, int r101) {
        System.out.println("[mammon] SAMI AB Config, abConfigGetting()");
        return getInstance().callback.getSAMICoreAbConfig(r100, SAMICoreAbConfigType.fromInt(r101));
    }
}
