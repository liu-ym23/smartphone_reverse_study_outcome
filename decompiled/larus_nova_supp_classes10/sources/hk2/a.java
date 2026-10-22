package hk2;

import ak2.b;
import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends b {
    public final Context a;

    public final View getView() {
        return new View(this.a);
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }
}
