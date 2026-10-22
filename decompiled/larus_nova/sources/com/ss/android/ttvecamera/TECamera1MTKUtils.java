package com.ss.android.ttvecamera;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ttvecamera.framework.TEReflectUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class TECamera1MTKUtils {
    private static List<String> sNoZsdPlatforms;
    private static String sPlatform;
    private static boolean sZsdModeSupport;

    public TECamera1MTKUtils() {
    }

    static {
        sNoZsdPlatforms = new ArrayList();
        sPlatform = (String) TEReflectUtil.invokeStatic("android.os.SystemProperties", MonitorConstants.CONNECT_TYPE_GET, new String[]{"ro.mediatek.platform"});
        Collections.addAll(sNoZsdPlatforms, new String[]{"MT6571", "MT6595", "MT6795", "MT6572", "MT6752", "MT6582", "MT6735", "MT6592", "MT6753", "MT6589", "MT6755", "MT6735m", "MT6737T", "MT6580", "MT6750", "MT6750S", "MT6737", "MT6739", "MT6570", "MT6761"});
    }

    public static boolean isMTKPlatform() {
        return !TextUtils.isEmpty(sPlatform);
    }

    public static boolean isSupportZsdMode() {
        if (sZsdModeSupport == true) goto L10;
        if (Collections.unmodifiableList(sNoZsdPlatforms).indexOf(sPlatform) >= 0) goto L7;
        boolean r100 = true;
    L8:
        sZsdModeSupport = r100;
        goto L10
    L7:
        r100 = false;
    L10:
        return sZsdModeSupport;
    }
}
