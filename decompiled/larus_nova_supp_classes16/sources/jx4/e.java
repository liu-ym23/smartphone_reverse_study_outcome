package jx4;

import android.content.Context;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public final Context a;
    public final boolean b;

    public e(Context r4) {
        Intrinsics.checkNotNullParameter("debug_config", "name");
        com.ss.android.lark.storage.kv.repo.a r0 = ay4.b.b("debug_config", true, ay4.b.a("debug_config"));
        Intrinsics.checkNotNullParameter(r0, "repo");
        new ArrayList();
        this.a = r4;
        Intrinsics.checkNotNullParameter("offline_auto_download_full_res", "key");
        this.b = r0.getBoolean("offline_auto_download_full_res", true);
    }
}
