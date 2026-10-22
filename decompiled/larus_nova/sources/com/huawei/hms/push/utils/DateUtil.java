package com.huawei.hms.push.utils;

import com.huawei.hms.support.log.HMSLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes23.dex */
public class DateUtil {
    private DateUtil() {
    }

    public static String parseMilliSecondToString(Long r100) {
        if (r100 != null) goto L10;
        return null;
    L10:
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(r100);
    L7:
        e = move-exception;
        HMSLog.e("DateUtil", "parseMilliSecondToString Exception.", e);
        return null;
    }

    public static long parseUtcToMillisecond(String r100) throws ParseException, StringIndexOutOfBoundsException {
        SimpleDateFormat r101 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        r101.setTimeZone(TimeZone.getTimeZone("UTC"));
        return r101.parse(r100.substring(0, r100.indexOf(".")) + (r100.substring(r100.indexOf(".")).substring(0, 4) + "Z")).getTime();
    }
}
