package d26;

import android.content.Context;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.ss.android.lark.utils.statistics.PerfLog;
import iq7.f;
import kotlin.jvm.internal.Intrinsics;
import qq7.c;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f466530a = 0;

    static {
    }

    public static SSWebView a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return (SSWebView) ((c) f.a("webx_webkit", c.class)).g(r100, SSWebView.class);
    L6:
        return new SSWebView(r100, null, 6, 0);
    }
}
