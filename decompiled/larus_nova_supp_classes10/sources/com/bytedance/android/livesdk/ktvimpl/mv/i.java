package com.bytedance.android.livesdk.ktvimpl.mv;

import com.ss.ttvideoengine.DataSource;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements DataSource {
    public final /* synthetic */ KtvMvPlayer a;
    public final /* synthetic */ u b;

    public i(KtvMvPlayer r1, u r2) {
        this.a = r1;
        this.b = r2;
    }

    public final String apiForFetcher(Map<String, String> r3, int r4) {
        KtvMvPlayer r5 = this.a;
        String r6 = this.b.b;
        r5.getClass();
        return String.format("https://open.bytedanceapi.com/?%s", new Object[]{r6});
    }
}
