package y8c;

import com.ss.android.lark.storage.LarkKVStorage;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ss.android.lark.storage.a f566938a = null;

    static {
        f566938a = new com.ss.android.lark.storage.a("TASK");
    }

    public static com.ss.android.lark.storage.kv.repo.a a() {
        return LarkKVStorage.h(f566938a, true);
    }
}
