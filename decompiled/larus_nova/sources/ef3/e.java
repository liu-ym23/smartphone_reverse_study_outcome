package ef3;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class e<T> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f472426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f472427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f472428c;

    public void c() {
    }

    public void d() {
    }

    public final Context getContext() {
        return this.f472426a;
    }

    public e(View r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "cardView");
        Intrinsics.checkNotNullParameter(r101, "mallContext");
        this.f472428c = r101;
        this.f472426a = r100.getContext();
    }
}
