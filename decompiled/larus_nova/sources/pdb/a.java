package pdb;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.ss.android.lark.g;
import com.ss.android.lark.storage.LarkKVStorage;

/* JADX INFO: loaded from: classes35.dex */
public final class a {
    public static com.ss.android.lark.storage.kv.repo.a a() {
        return LarkKVStorage.g(new com.ss.android.lark.storage.a("core"), AppConstants.APP_FG, false);
    }

    public static com.ss.android.lark.storage.kv.repo.a b(String r100) {
        return LarkKVStorage.n(g.getContext(), r100, new com.ss.android.lark.storage.a("core"), AppConstants.APP_FG, null);
    }
}
