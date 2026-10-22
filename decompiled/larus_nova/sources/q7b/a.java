package q7b;

import android.graphics.drawable.Drawable;
import android.util.LruCache;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C7295a f531997a = null;

    /* JADX INFO: renamed from: q7b.a$a, reason: collision with other inner class name */
    public static final class C7295a extends LruCache<String, WeakReference<Drawable>> {
        public C7295a() {
            super(10);
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r100, WeakReference<Drawable> r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            return 1;
        }
    }

    static {
        f531997a = new C7295a();
    }
}
