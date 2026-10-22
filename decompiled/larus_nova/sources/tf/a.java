package tf;

import cf.k;
import cf.o;
import com.bytedance.android.ec.common.api.IPageStateService;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements IPageStateService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f545681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, WeakReference<o>> f545682b;

    /* JADX INFO: renamed from: tf.a$a, reason: collision with other inner class name */
    public static final class C7717a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f545683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f545684b;

        @Override // cf.k
        public final void remove() {
            this.f545683a.f545682b.remove(this.f545684b);
        }

        @Override // cf.k
        public final String getId() {
            return this.f545684b;
        }

        public C7717a(a r100, String r101) {
            this.f545683a = r100;
            this.f545684b = r101;
        }
    }

    public a() {
        this.f545681a = new AtomicInteger(0);
        this.f545682b = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.ec.common.api.IPageStateService
    public final o getPageStateListener(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        WeakReference<o> r101 = this.f545682b.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get();
    }

    @Override // com.bytedance.android.ec.common.api.IPageStateService
    public final k setPageStateListener(o r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        String r101 = String.valueOf(this.f545681a.incrementAndGet());
        this.f545682b.put(r101, new WeakReference(r100));
        return new C7717a(this, r101);
    }
}
