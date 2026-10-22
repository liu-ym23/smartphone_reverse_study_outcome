package t2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {
    public static final Bundle a(Fragment r100) {
        Bundle r101 = r100.getArguments();
        if (r101 != null) goto L5;
        r101 = new Bundle();
        r100.setArguments(r101);
    L5:
        Bundle r102 = r101.getBundle("__applet_app_ext_bundle__");
        if (r102 != null) goto L9;
        Bundle r103 = new Bundle();
        r101.putBundle("__applet_app_ext_bundle__", r103);
        return r103;
    L9:
        return r102;
    }

    public static final Long b(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Bundle r101 = r100.getArguments();
        if (r101 == null) goto L10;
        Bundle r102 = r101.getBundle("__applet_app_ext_bundle__");
        if (r102 != null) goto L7;
        return null;
    L7:
        if (r102.containsKey(BindCardPayConfirmConstants.Key.TRACE_ID) == true) goto L9;
        return null;
    L9:
        return Long.valueOf(r102.getLong(BindCardPayConfirmConstants.Key.TRACE_ID));
    L10:
        return null;
    }

    public static final String c(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Bundle r101 = r100.getArguments();
        if (r101 == null) goto L7;
        Bundle r102 = r101.getBundle("__applet_app_ext_bundle__");
        if (r102 == null) goto L7;
        return r102.getString("url");
    L7:
        return null;
    }

    public static final void d(Fragment r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        a(r100).putString("url", r101);
    }
}
