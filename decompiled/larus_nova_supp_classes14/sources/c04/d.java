package c04;

import android.content.SharedPreferences;
import com.bytedance.awemeopen.servicesapi.storage.AoKVStorageService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static final AoKVStorageService a = null;
    public static final SharedPreferences b = null;

    static {
        AoKVStorageService r0 = j64.a.a(AoKVStorageService.class);
        Intrinsics.checkNotNull(r0);
        AoKVStorageService r1 = r0;
        a = r1;
        b = r1.h(y54.a.a(), "long_press_speed");
    }
}
