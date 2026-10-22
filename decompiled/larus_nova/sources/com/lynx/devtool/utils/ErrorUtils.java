package com.lynx.devtool.utils;

import android.text.TextUtils;
import com.lynx.tasm.LynxError;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class ErrorUtils {
    protected static final int CONSOLE_LOG_ERROR = 2;
    private static final int CONSOLE_LOG_INFO = 0;
    private static final int CONSOLE_LOG_VERBOSE = -1;
    protected static final int CONSOLE_LOG_WARNING = 1;

    public ErrorUtils() {
    }

    public static int errorLevelStrToInt(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return 2;
    L5:
        if (r100 != null) goto L7;
        return 2;
    L7:
        if (r100.equalsIgnoreCase("warn") == false) goto L11;
        return 1;
    L11:
        return 2;
    }

    public static String getKeyMessage(LynxError r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.isValid() == false) goto L21;
        StringBuilder r101 = new StringBuilder("code: ");
        r101.append(r100.getSubCode());
        r101.append("\nmessage: ");
        r101.append(r100.getSummaryMessage());
        r101.append("\n");
        if (TextUtils.isEmpty(r100.getRootCause()) == true) goto L9;
        r101.append("root_cause: ");
        r101.append(r100.getRootCause());
        r101.append("\n");
    L9:
        Iterator<Map.Entry<String, String>> r102 = r100.getContextInfo().entrySet().iterator();
    L11:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<String, String> r103 = r102.next();
        r101.append(r103.getKey());
        r101.append(": ");
        r101.append(r103.getValue());
        r101.append("\n");
        goto L11
    L14:
        if (TextUtils.isEmpty(r100.getFixSuggestion()) == true) goto L17;
        r101.append("fix_suggestion: ");
        r101.append(r100.getFixSuggestion());
    L17:
        return r101.toString();
    L21:
        return "";
    }
}
