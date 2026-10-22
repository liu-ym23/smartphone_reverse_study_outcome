package com.huawei.hms.framework.common.grs;

import com.huawei.hms.framework.common.StringUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes23.dex */
public class GrsUtils {
    private static final int GRS_KEY_INDEX = 1;
    private static final int GRS_PATH_INDEX = 2;
    private static final String GRS_SCHEMA = "grs://";
    private static final int GRS_SERVICE_INDEX = 0;
    private static final int MAX_GRS_SPLIT = 3;
    private static final String SEPARATOR = "/";

    public GrsUtils() {
    }

    public static boolean isGRSSchema(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.startsWith(GRS_SCHEMA) == false) goto L6;
        return true;
    }

    public static String[] parseGRSSchema(String r100) {
        String[] r101 = StringUtils.substring(r100, r100.toLowerCase(Locale.ENGLISH).indexOf(GRS_SCHEMA) + 6).split("/", 3);
        if (r101.length == 1) goto L5;
        return r101;
    L5:
        return new String[]{r101[0], "ROOT"};
    }

    public static String[] parseParams(String r100) {
        if (r100.endsWith("/") == false) goto L6;
        r100 = StringUtils.substring(r100, r100.indexOf(GRS_SCHEMA), r100.length() - 1);
    L6:
        return parseGRSSchema(r100);
    }

    public static String fixResult(String[] r100, String r101) {
        if (r100.length > 2) goto L5;
        return r101;
    L5:
        if (r101.endsWith("/") == false) goto L8;
        return r101 + r100[2];
    L8:
        return r101 + "/" + r100[2];
    }
}
