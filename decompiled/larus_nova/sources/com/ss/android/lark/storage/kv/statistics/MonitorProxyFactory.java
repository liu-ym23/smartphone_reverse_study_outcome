package com.ss.android.lark.storage.kv.statistics;

import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.storage.kv.repo.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class MonitorProxyFactory implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m6c.a f441081a;

    public static final class KVMonitorRepoProxy extends com.ss.android.lark.storage.kv.repo.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final m6c.a f441082c;

        public KVMonitorRepoProxy(KVRepo r100, m6c.a r101) {
            Intrinsics.checkNotNullParameter(r100, "delegate");
            Intrinsics.checkNotNullParameter(r101, "realMonitor");
            super(r100);
            this.f441082c = r101;
        }

        @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
        public final String getString(final String r100, final String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            return this.f441082c.b(this.f441079b, r100, new MonitorProxyFactory$KVMonitorRepoProxy$getString$1(this, r100, r101));
        }

        @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
        public final void putString(final String r100, final String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.f441082c.a(this.f441079b, r100, new MonitorProxyFactory$KVMonitorRepoProxy$putString$1(this, r100, r101));
        }

        public static final /* synthetic */ String d(KVMonitorRepoProxy r100, String r101, String r102) {
            return super.getString(r101, r102);
        }

        public static final /* synthetic */ void e(KVMonitorRepoProxy r100, String r101, String r102) {
            super.putString(r101, r102);
        }
    }

    public MonitorProxyFactory(m6c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "realMonitor");
        this.f441081a = r100;
    }

    @Override // com.ss.android.lark.storage.kv.repo.f
    public final com.ss.android.lark.storage.kv.repo.c a(KVRepo r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        return new KVMonitorRepoProxy(r100, this.f441081a);
    }
}
