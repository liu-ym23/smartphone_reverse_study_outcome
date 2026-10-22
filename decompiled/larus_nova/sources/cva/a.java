package cva;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.SafeKeyGenerator;
import com.ss.android.lark.app.glide.diskcache.LarkGlideDiskCache;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import com.suite.lark.platform.component.storage.file.dirs.d;
import kotlin.jvm.internal.Intrinsics;
import znc.m;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements LarkGlideDiskCache.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SafeKeyGenerator f465503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f465504b;

    /* JADX INFO: renamed from: cva.a$a, reason: collision with other inner class name */
    public static final class C5593a {
    }

    static {
    }

    @Override // com.ss.android.lark.app.glide.diskcache.LarkGlideDiskCache.c
    public final boolean a() {
        return true;
    }

    @Override // com.ss.android.lark.app.glide.diskcache.LarkGlideDiskCache.c
    public final boolean b(Key r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return true;
    }

    @Override // com.ss.android.lark.app.glide.diskcache.LarkGlideDiskCache.c
    public final DiskCache c(String r100) {
        SafeKeyGenerator r101 = this.f465503a;
        m.a r102 = new m.a();
        int r103 = d.f460639a;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102.a(new d().d(LarkFileStorage.f(r100)).getRealPath());
        r102.f573061f = new com.suite.lark.platform.component.storage.file.cache.a(com.ss.android.lark.vfs.d.a());
        r102.f573060e = this.f465504b;
        return new b(r101, new m(r102));
    }

    public a(SafeKeyGenerator r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "keyGenerator");
        this.f465503a = r100;
        this.f465504b = r101;
    }
}
