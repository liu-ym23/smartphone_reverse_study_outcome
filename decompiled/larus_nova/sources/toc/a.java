package toc;

import android.content.Context;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ss.android.lark.storage.a f546993a = null;

    static {
        f546993a = new com.ss.android.lark.storage.a("media");
    }

    @JvmStatic
    public static final com.ss.android.lark.storage.kv.repo.a a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "name");
        LarkKVStorage.KVStorageBuilder r102 = new LarkKVStorage.KVStorageBuilder(r100);
        r102.f440930b = "lark";
        return com.ss.android.lark.storage.kv.storage.a.b(r102.b(), f546993a, r101, null, 4);
    }
}
