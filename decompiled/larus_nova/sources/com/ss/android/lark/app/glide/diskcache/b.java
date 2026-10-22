package com.ss.android.lark.app.glide.diskcache;

import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.SafeKeyGenerator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements DiskCache.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f408725a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SafeKeyGenerator f408726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SafeKeyGenerator.IKeyGeneratorHandler f408727b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public DiskCache.Factory f408728c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public LarkGlideDiskCache.d f408729d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f408730e;

        public a() {
            this.f408730e = 52428800;
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
    public final DiskCache build() {
        LarkGlideDiskCache.a r100 = new LarkGlideDiskCache.a();
        SafeKeyGenerator r101 = this.f408725a.f408726a;
        Intrinsics.checkNotNull(r101);
        SafeKeyGenerator.IKeyGeneratorHandler r102 = this.f408725a.f408727b;
        Intrinsics.checkNotNull(r102);
        bva.a r103 = new bva.a(r101, r102, this.f408725a.f408730e);
        Intrinsics.checkNotNullParameter(r103, "handlerDisk");
        r100.f408718a.add(r103);
        SafeKeyGenerator r104 = this.f408725a.f408726a;
        Intrinsics.checkNotNull(r104);
        cva.a r105 = new cva.a(r104, this.f408725a.f408730e);
        Intrinsics.checkNotNullParameter(r105, "handlerDisk");
        r100.f408718a.add(r105);
        a r106 = this.f408725a;
        r100.f408719b = r106.f408728c;
        r100.f408720c = r106.f408729d;
        return new LarkGlideDiskCache(r100);
    }

    public b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f408725a = r100;
    }
}
