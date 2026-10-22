package com.ss.android.lark.storage.kv.keva;

import android.content.Context;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.storage.kv.repo.KVRepoConfig;
import com.ss.android.lark.storage.kv.repo.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f441052b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f441053a;

    /* JADX INFO: renamed from: com.ss.android.lark.storage.kv.keva.a$a, reason: collision with other inner class name */
    public static final class C5308a {
    }

    static {
    }

    public a() {
    }

    @Override // com.ss.android.lark.storage.kv.repo.e
    public final String a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = this.f441053a;
        if (r101 != null) goto L6;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f441053a = "keva/larksuite/";
        return "keva/larksuite/";
    L6:
        return r101;
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
        l6c.a.f507756a.init(r100);
        return new KevaRepo(a(r100), r101, r110, r111, r112);
    }
}
