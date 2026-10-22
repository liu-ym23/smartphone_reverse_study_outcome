package com.ss.android.lark.chameleon.util;

import android.content.Context;
import android.webkit.WebSettings;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chameleon/util/UserAgentUtil;", "", "()V", "getUserAgent", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UserAgentUtil {
    public static final UserAgentUtil INSTANCE = null;

    static {
        INSTANCE = new UserAgentUtil();
    }

    private UserAgentUtil() {
    }

    public final String getUserAgent(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = WebSettings.getDefaultUserAgent(r100.getApplicationContext());     // Catch: Exception -> L5
    L6:
        StringBuffer r102 = new StringBuffer();
        if (r101 == null) goto L19;
        int r103 = r101.length();
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L19;
        char r105 = r101.charAt(r104);
        if (Intrinsics.compare(r105, 31) > 0) goto L13;
    L16:
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;
        r102.append(String.format("\\u%04x", Arrays.copyOf(new Object[]{Integer.valueOf(r105)}, 1)));
    L17:
        r104 = r104 + 1;
        goto L9
    L13:
        if (Intrinsics.compare(r105, 127) >= 0) goto L16;
        r102.append(r105);
    L19:
        return r102.toString();
    L5:
        r101 = System.getProperty("http.agent");
        goto L6
    }
}
