package yn2;

import com.bytedance.android.livesdkapi.performance.ILiveReleasable;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<ILiveReleasable> f568522a;

    public a(ILiveReleasable r100) {
        Intrinsics.checkNotNullParameter(r100, "releasable");
        this.f568522a = new WeakReference(r100);
    }
}
