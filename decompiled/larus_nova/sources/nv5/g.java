package nv5;

import android.webkit.WebView;
import com.bytedance.falconx.statistic.InterceptorModel;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f520897a;

    public interface a {
    }

    public static void a(WebView r100, InterceptorModel r101, boolean r102) {
        if (f520897a == null) goto L9;
        if (r100 == null) goto L10;
        if (r101 == null) goto L11;
        ry2.b.a().execute(new com.bytedance.webx.monitor.falconx.a(r102, r101, r100));
        return;
    L11:
        return;
    L10:
        return;
    }
}
