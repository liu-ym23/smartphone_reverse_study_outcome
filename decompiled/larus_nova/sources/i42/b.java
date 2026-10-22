package i42;

import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.utils.LimitedSizeHashMap;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LimitedSizeHashMap<String, Object> f488209a;

    public b() {
        this.f488209a = new LimitedSizeHashMap(128);
    }

    public final void a(String r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f488209a.containsKey(r100) == true) goto L8;
        TTLiveSDK.hostService().hostOpenPlatform().preloadMiniApp(r100);
        this.f488209a.put(r100, null);
        return;
    }
}
