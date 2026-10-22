package m46;

import android.app.Activity;
import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class c extends l46.b {
    public abstract Intent e(Activity r100);

    public abstract void f();

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "permission");
        super(r100);
    }
}
