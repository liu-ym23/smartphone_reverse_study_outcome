package com.ss.android.lark.storage.kv.flash;

import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.storage.kv.repo.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f extends com.ss.android.lark.storage.kv.repo.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f441044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f441045d;

    public static final class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f441046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f441047b;

        public a(com.ss.android.lark.storage.kv.flash.a r100) {
            Intrinsics.checkNotNullParameter(r100, "migrationSource");
            this.f441046a = r100;
            this.f441047b = false;
        }

        @Override // com.ss.android.lark.storage.kv.repo.f
        public final com.ss.android.lark.storage.kv.repo.c a(KVRepo r100) {
            Intrinsics.checkNotNullParameter(r100, "delegate");
            return new f(r100, this.f441046a, this.f441047b);
        }

        @Override // com.ss.android.lark.storage.kv.repo.g
        public final void b(com.ss.android.lark.storage.a r100) {
            Intrinsics.checkNotNullParameter(r100, "domain");
        }
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final boolean contains(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (super.contains(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f441044c.contains(r100) == true) goto L8;
        return false;
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final boolean getBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        boolean r102 = super.getBoolean(r100, r101);
        if (r102 == r101) goto L5;
    L13:
        return r102;
    L5:
        if (super.contains(r100) == true) goto L13;
        r102 = this.f441044c.getBoolean(r100, r101);
        if (r102 == r101) goto L9;
    L10:
        putBoolean(r100, r102);
        if (this.f441045d == false) goto L13;
        this.f441044c.remove(r100);
        goto L13
    L9:
        if (this.f441044c.contains(r100) == false) goto L13;
        goto L10
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final long getLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        long r102 = super.getLong(r100, r101);
        if (r102 == r101) goto L5;
    L13:
        return r102;
    L5:
        if (super.contains(r100) == true) goto L13;
        r102 = this.f441044c.getLong(r100, r101);
        if (r102 == r101) goto L9;
    L10:
        putLong(r100, r102);
        if (this.f441045d == false) goto L13;
        this.f441044c.remove(r100);
        goto L13
    L9:
        if (this.f441044c.contains(r100) == false) goto L13;
        goto L10
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final String getString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r102 = super.getString(r100, r101);
        if (Intrinsics.areEqual(r102, r101) == true) goto L5;
    L13:
        return r102;
    L5:
        if (super.contains(r100) == true) goto L13;
        r102 = this.f441044c.getString(r100, r101);
        if (Intrinsics.areEqual(r102, r101) == true) goto L9;
    L10:
        putString(r100, r102);
        if (this.f441045d == false) goto L13;
        this.f441044c.remove(r100);
        goto L13
    L9:
        if (this.f441044c.contains(r100) == false) goto L13;
        goto L10
    }

    public f(KVRepo r100, e r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "source");
        super(r100);
        this.f441044c = r101;
        this.f441045d = r102;
    }
}
