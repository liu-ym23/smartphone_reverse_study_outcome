package z54;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.awemeopen.servicesapi.storage.AoKVStorageService;
import j64.b;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes46.dex */
public final class a {
    static {
    }

    public static /* synthetic */ SharedPreferences b(String r100) {
        return a(y54.a.a(), r100);
    }

    @JvmStatic
    public static final SharedPreferences a(Context r100, String r101) {
        int r102 = b.f497514a;
        return ((AoKVStorageService) b.a(AoKVStorageService.class)).h(r100, r101);
    }
}
