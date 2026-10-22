package com.ss.android.lark.storage;

import android.content.Context;
import com.ss.android.lark.g;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c extends BaseKVStorage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f440945a = null;

    static {
        f440945a = new c();
    }

    public c() {
    }

    public static com.ss.android.lark.storage.kv.repo.a d(Context r100, String r101, a r102, String r103, KVRepo r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r100 = g.getContext();
    L5:
        Context r104 = r100;
        if ((r111 & 8) == 0) goto L8;
        String r105 = null;
    L10:
        if ((r111 & 16) == 0) goto L12;
        KVRepo r106 = null;
    L14:
        if ((r111 & 32) == 0) goto L16;
        boolean r107 = true;
    L17:
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "domain");
        f440945a.getClass();
        return BaseKVStorage.c(r104, BaseKVStorage.a(r101), r102, r105, r106, r107);
    L16:
        r107 = false;
        goto L17
    L12:
        r106 = r110;
        goto L14
    L8:
        r105 = r103;
        goto L10
    }
}
