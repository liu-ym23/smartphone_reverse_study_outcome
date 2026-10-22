package g49;

import com.bytedance.keva.Keva;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f480007a = null;

    static {
        f480007a = Keva.getRepo("dora_kv_env", 0);
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        f480007a.storeString("key_http_response" + r100, r101);
    }
}
