package vt9;

import com.larus.common.apphost.AppHost;
import com.larus.platform.model.audio.CloseAudioConnectionAppBackgroundConfig;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class u {
    public u() {
    }

    public static CloseAudioConnectionAppBackgroundConfig a() {
        if (AppHost.a.isOversea() == false) goto L6;
        return new CloseAudioConnectionAppBackgroundConfig(false, null, 3, null);
    L6:
        return new CloseAudioConnectionAppBackgroundConfig(true, CollectionsKt.listOf("honor"));
    }
}
