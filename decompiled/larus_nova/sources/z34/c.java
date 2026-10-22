package z34;

import com.bytedance.awemeopen.domain.feed.preload.framework.AosAwemePreloadModel;
import kotlin.jvm.internal.Intrinsics;
import v34.b;

/* JADX INFO: loaded from: classes44.dex */
public final class c<T extends v34.b<T>> implements y34.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w34.b<?> f569873a;

    public c(w34.b<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "preloadDataCachePool");
        this.f569873a = r100;
    }

    @Override // y34.a
    public final y34.b a(AosAwemePreloadModel r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        String r101 = r100.id();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == true) goto L30;
        w34.b<?> r103 = this.f569873a;
        String r104 = r100.id();
        Intrinsics.checkNotNull(r104);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "key");
        r103.f558147b.lock();     // Catch: Throwable -> L25
        boolean r105 = r103.f558148c.containsKey(r104);     // Catch: Throwable -> L25
        r103.f558147b.unlock();
        if (r105 == false) goto L24;
        w34.b<?> r106 = this.f569873a;
        String r107 = r100.id();
        Intrinsics.checkNotNull(r107);
        w34.a<?> r108 = r106.a(r107);
        if (r108 != null) goto L20;
        w34.b<?> r109 = this.f569873a;
        String r110 = r100.id();
        Intrinsics.checkNotNull(r110);
        r109.d(r110);
        return new y34.b(false, "");
    L20:
        if (r108.a() == false) goto L22;
        w34.b<?> r111 = this.f569873a;
        String r112 = r100.id();
        Intrinsics.checkNotNull(r112);
        r111.b(r112);
        return new y34.b(true, "data already in PreloadDataCachePool and validate");
    L22:
        w34.b<?> r113 = this.f569873a;
        String r114 = r100.id();
        Intrinsics.checkNotNull(r114);
        r113.d(r114);
    L24:
        return new y34.b(false, "");
    L25:
        th = move-exception;
        r103.f558147b.unlock();
        throw th;
    L30:
        return new y34.b(false, "");
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L10
    }
}
