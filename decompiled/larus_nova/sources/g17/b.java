package g17;

import android.text.TextUtils;
import com.bytedance.lynx.webview.adblock.TTAdblockClient;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements n07.a.InterfaceC6878a {
    public b() {
    }

    public final boolean a(String r100) {
        TTAdblockClient r101 = TTAdblockClient.b.f265047a;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        String r102 = null;
    L6:
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (r101.f265039e != null) goto L11;
        monitor-exit(r101);
        return false;
    L11:
        boolean r103 = r101.f265039e.a(r100, r102);     // Catch: Throwable -> L14
        monitor-exit(r101);
        return r103;
    L5:
        r102 = UriProtector.parse(r100).getHost();
        goto L6
    }
}
