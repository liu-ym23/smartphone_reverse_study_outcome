package hj7;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.luckycat.impl.browser.bridge.LuckyCatLoginBridge;
import java.net.URLDecoder;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f485437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f485438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LuckyCatLoginBridge f485439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f485440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f485441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public pi7.i f485442f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ij7.i f485443g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f485444h;

    public e() {
    }

    public static boolean a(String r100) {
        Uri r101 = UriProtector.parse(r100);
        if ("log_event_v3".equals(r101.getHost()) == true) goto L14;
        return false;
    L14:
        String r102 = UriProtector.getQueryParameter(r101, "event");     // Catch: Exception -> L13
        String r103 = UriProtector.getQueryParameter(r101, "params");     // Catch: Exception -> L13
        if (TextUtils.isEmpty(r102) == true) goto L10;
        if (TextUtils.isEmpty(r103) == true) goto L10;
        com.bytedance.ug.sdk.luckycat.impl.model.d.a(URLDecoder.decode(r102, "UTF-8"), new JSONObject(URLDecoder.decode(r103, "UTF-8")), true);     // Catch: Exception -> L13
    L10:
        return true;
    }
}
