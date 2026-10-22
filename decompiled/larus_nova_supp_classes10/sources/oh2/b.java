package oh2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class b extends QUIModule {
    public View l;
    public Context m;

    public b() {
        super(0);
    }

    public final Context getContext() {
        return this.m;
    }

    public void e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.m = r2;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        View r3 = this.l;
        if (r3 == null) goto L9;
        if (r3 == null) goto L7;
        return r3;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L9:
        throw new IllegalStateException("set rootView or override onCreateView");
    }
}
