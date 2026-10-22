package com.suite.lark.platform.component.storage.file.dirs;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
@Deprecated(message = " temporary using, may refactor in the future")
public final class b {

    public static final class a {
    }

    static {
    }

    @JvmStatic
    public static final String a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = com.ss.android.lark.storage.f.f440959f.a(r100, "databases");
        if (StringsKt.endsWith$default(r101, HTTP.URL_DEFAULT, false, 2, null) == true) goto L7;
        r101 = r101 + '/';
    L7:
        return c.a(r101, "");
    }
}
