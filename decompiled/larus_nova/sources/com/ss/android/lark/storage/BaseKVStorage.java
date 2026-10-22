package com.ss.android.lark.storage;

import android.content.Context;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.util.share_preference.UserSP;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public abstract class BaseKVStorage {

    public static final class a {
    }

    static {
    }

    public BaseKVStorage() {
    }

    public static String a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        return UserSP.TEMP_NAME;
    L11:
        return r100;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static com.ss.android.lark.storage.kv.storage.a b(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spaceName");
        return com.ss.android.lark.storage.kv.storage.b.a(r100, r101, BaseKVStorage$createKVStorage$1.INSTANCE);
    }

    public static com.ss.android.lark.storage.kv.repo.a c(Context r100, String r101, com.ss.android.lark.storage.a r102, String r103, final KVRepo r104, final boolean r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spaceName");
        Intrinsics.checkNotNullParameter(r102, "domain");
        if (r104 == null) goto L6;
        return b(r100, r101).a(r102, r103, new BaseKVStorage$getKVRepo$1(r104, r105));
    L6:
        return com.ss.android.lark.storage.kv.storage.a.b(b(r100, r101), r102, r103, null, 4);
    }
}
