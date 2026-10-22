package cva;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.SafeKeyGenerator;
import com.ss.android.lark.log.Log;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import znc.d;
import znc.h;
import znc.m;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements DiskCache {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f465505c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SafeKeyGenerator f465506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f465507b;

    public static final class a {
    }

    /* JADX INFO: renamed from: cva.b$b, reason: collision with other inner class name */
    public static final class C5594b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f465508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DiskCache.Writer f465509b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Key f465510c;

        @Override // znc.d
        public final boolean a(m.c r100) {
            Intrinsics.checkNotNullParameter(r100, "editor");
            this.f465508a.element = this.f465509b.write(new com.ss.android.lark.app.glide.diskcache.a(r100));
            if (this.f465508a.element == true) goto L6;
            Log.e("UniDiskLruCache", "write cache failed, key:" + this.f465510c);
        L6:
            return this.f465508a.element;
        }

        public C5594b(Ref.BooleanRef r100, DiskCache.Writer r101, Key r102) {
            this.f465508a = r100;
            this.f465509b = r101;
            this.f465510c = r102;
        }
    }

    static {
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public final void clear() {
        this.f465507b.delete();
    }

    public static void a(String r100) {
        if (r100 != null) goto L4;
    L6:
        f465505c = r100;
        return;
    L4:
        if (Intrinsics.areEqual(r100, f465505c) == true) goto L6;
        Log.w("UniDiskLruCache", "cache dir changed: " + f465505c + " -> " + r100);
        goto L6
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f465507b.remove(this.f465506a.getSafeKey(r100));
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public final File get(Key r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r101 = this.f465506a.getSafeKey(r100);
        h r102 = this.f465507b;
        Intrinsics.checkNotNull(r101);
        File r103 = r102.a(r101);
        a(this.f465507b.b());
        return r103;
    }

    public b(SafeKeyGenerator r100, m r101) {
        Intrinsics.checkNotNullParameter(r100, "keyGenerator");
        Intrinsics.checkNotNullParameter(r101, "uniDiskCache");
        this.f465506a = r100;
        this.f465507b = r101;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public final void put(Key r100, DiskCache.Writer r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "writer");
        String r102 = this.f465506a.getSafeKey(r100);
        a(this.f465507b.b());
        Ref.BooleanRef r103 = new Ref.BooleanRef();
        h r104 = this.f465507b;
        Intrinsics.checkNotNull(r102);
        r104.d(r102, new C5594b(r103, r101, r100));
    }
}
