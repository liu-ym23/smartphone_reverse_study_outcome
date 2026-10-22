package ij7;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ug.sdk.luckycat.impl.utils.LuckyCatUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class g extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f490096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f490097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final hj7.f f490098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final pi7.i f490099d;

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView r100, int r101) {
        pi7.i r102 = this.f490099d;
        if (r102 == null) goto L6;
        r102.I7(r101);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView r100, String r101) {
        super.onReceivedTitle(r100, r101);
        if (this.f490097b == true) goto L5;
        return;
    L5:
        if (this.f490096a != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        this.f490096a.setTitle(r101);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public final void onConsoleMessage(String r100, int r101, String r102) {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatWebChromeClient", r100 + " -- line " + r101);
        hj7.f r103 = this.f490098c;     // Catch: Exception -> L27
        if (r103 != null) goto L6;
    L15:
        List<String> r104 = LuckyCatUtils.f271506a;     // Catch: Exception -> L27
        if (TextUtils.isEmpty(r100) == false) goto L19;
        return;
    L19:
        if (r100.startsWith("luckycat_webview_custom_report_") == true) goto L31;
        return;
    L31:
        LuckyCatUtils.c(new JSONObject(r100.substring(31)));     // Catch: JSONException -> L24 Exception -> L27
    L37:
        return;
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L27
        return;
    L6:
        if (r103.f485447c == null) goto L15;
        if (r100 == null) goto L15;
        if (r100.startsWith("bytedance://") == false) goto L15;
        if (TextUtils.isEmpty(r100) == true) goto L15;
        hj7.e.a(r100);     // Catch: Throwable -> L29
    L27:
        com.bytedance.ug.sdk.luckycat.impl.utils.a.b("LuckyCatWebChromeClient", r100 + " -- line " + r101);
    }

    public g(WebView r100, FragmentActivity r101, hj7.f r102, pi7.i r103) {
        this.f490096a = r101;
        this.f490098c = r102;
        this.f490099d = r103;
    }
}
