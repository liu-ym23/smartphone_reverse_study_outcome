package ph1;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f529239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f529240b;

    public /* synthetic */ a() {
        throw null;
    }

    public final int hashCode() {
        int r100 = this.f529239a.hashCode() * 31;
        if (this.f529240b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final boolean equals(Object r100) {
        View r101 = null;
        if ((r100 instanceof a) == true) goto L5;
        r100 = null;
    L5:
        a r102 = (a) r100;
        if (r102 == null) goto L11;
        WeakReference<View> r103 = r102.f529239a;
        if (r103 == null) goto L11;
        r101 = r103.get();
    L11:
        return Intrinsics.areEqual(r101, this.f529239a.get());
    }

    public a(WeakReference<View> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "viewRef");
        this.f529239a = r100;
        this.f529240b = r101;
    }
}
