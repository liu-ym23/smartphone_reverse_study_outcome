package ix0;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.scope.o;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements o, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f496315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, WeakReference<Object>> f496316b;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f496316b.clear();
    }

    public c() {
        this.f496315a = new AtomicInteger(1);
        this.f496316b = new ConcurrentHashMap();
    }

    @Override // ix0.a
    public final <T> T e1(b<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        String r101 = r100.f496314a;
        WeakReference<Object> r102 = this.f496316b.get(r101);
        if (r102 == null) goto L10;
        T r103 = (T) r102.get();
        if (r103 == null) goto L8;
        return r103;
    L8:
        throw new IllegalStateException("object ID '" + r101 + "' is recycled");
    L10:
        throw new IllegalArgumentException("object ID '" + r101 + "' is invalid");
    }

    @Override // ix0.a
    public final <T> b<T> f1(T r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        String r101 = r100.getClass().getSimpleName() + '@' + this.f496315a.getAndIncrement();
        this.f496316b.put(r101, new WeakReference(r100));
        return new b(r101);
    }
}
