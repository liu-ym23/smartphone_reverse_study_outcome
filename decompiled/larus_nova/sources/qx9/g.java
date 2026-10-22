package qx9;

import com.bytedance.news.common.settings.bytesync.SettingsByteSyncManager;
import kotlin.text.Charsets;
import yf7.j;
import yf7.n;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements n {
    public g() {
    }

    @Override // yf7.n
    public final void a(j.a r100) {
        if (r100 == null) goto L7;
        byte[] r101 = r100.f567450a;
        if (r101 == null) goto L8;
        SettingsByteSyncManager.onReceiveConnectEvent(new String(r101, Charsets.UTF_8));
        return;
    L8:
        return;
    }
}
