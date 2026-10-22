package jg;

import android.view.View;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class g {
    public static final boolean a(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.length() <= 0) goto L6;
        return true;
    }

    public static String c(String r100) {
        Intrinsics.checkNotNullParameter("", "default");
        if (r100 == null) goto L5;
        return r100;
    L5:
        return "";
    }

    public static final JSONObject e(String r100) {
    L6:
        e = move-exception;
        ECExceptionMonitor.f(e, "json_format_error");
        return null;
    L3:
        if (a(r100) == false) goto L12;
        return new JSONObject(r100);
    L12:
        return null;
    }

    public static final JSONObject f(String r100) {
    L6:
        e = move-exception;
        ECExceptionMonitor.f(e, "json_format_error");
        return null;
    L3:
        if (a(r100) == false) goto L12;
        return new JSONObject(r100);
    L12:
        return null;
    }

    public static final long b(Long r100, long r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        return r100.longValue();
    }

    public static final void d(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setVisible");
        if (r101 == false) goto L5;
        int r102 = 0;
    L6:
        r100.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }
}
