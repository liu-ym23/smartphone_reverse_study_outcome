package spb;

import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.util.share_preference.UserSP;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    public static com.ss.android.lark.storage.kv.repo.a a() {
        return LarkKVStorage.f(new com.ss.android.lark.storage.a("core"), "larksetting", new n6c.a(eac.a.a()));
    }

    public static com.ss.android.lark.storage.kv.repo.a b() {
        return LarkKVStorage.o(new com.ss.android.lark.storage.a("core"), "larksetting", new n6c.a(UserSP.getInstance()));
    }
}
