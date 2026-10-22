package vt9;

import com.larus.common.apphost.AppHost;
import com.larus.platform.model.SpeakStyleConfig;

/* JADX INFO: loaded from: classes.dex */
public final class y {
    public y() {
    }

    public static SpeakStyleConfig a() {
        if (AppHost.f326268a.isOversea() == false) goto L6;
        return new SpeakStyleConfig(false, false, 3, null);
    L6:
        return new SpeakStyleConfig(true, true);
    }
}
