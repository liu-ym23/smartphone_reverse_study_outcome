package com.ss.android.lark.storage.kv.repo;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f441080a = null;

    static {
        f441080a = new h();
    }

    public h() {
    }

    @Override // com.ss.android.lark.storage.kv.repo.e
    public final String a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return r100.getFilesDir().getParent() + "/shared_prefs/";
    }

    @Override // com.ss.android.lark.storage.kv.repo.e
    public final void c(Context r100, String r101) {
        e.a.a(this, r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.e
    public final KVRepo b(Context r100, String r101, com.ss.android.lark.storage.a r110, String r111, KVRepoConfig.Mode r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spaceName");
        Intrinsics.checkNotNullParameter(r110, "domain");
        Intrinsics.checkNotNullParameter(r112, "mode");
        return new SharedPreferencesRepo(r100, a(r100), r101, r110, r111);
    }
}
