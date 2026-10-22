package ef3;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class e<T> implements c<T> {
    public final Context a;
    public T b;
    public final a c;

    public void c() {
    }

    public void d() {
    }

    public final Context getContext() {
        return this.a;
    }

    public e(View r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "cardView");
        Intrinsics.checkNotNullParameter(r3, "mallContext");
        this.c = r3;
        this.a = r2.getContext();
    }
}
