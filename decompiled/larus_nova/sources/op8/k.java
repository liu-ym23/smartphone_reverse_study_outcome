package op8;

import android.view.View;
import androidx.fragment.app.Fragment;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k implements t1a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Fragment> f524779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<View> f524780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f524781c;

    public static final class a {
    }

    static {
    }

    public final Fragment a() {
        Fragment r100 = this.f524779a.get();
        if (r100 == null) goto L15;
        if (r100.isAdded() == true) goto L7;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == false) goto L15;
        return r100;
    L7:
        if (r100.getView() == null) goto L11;
        if (r100.getView() != this.f524780b.get()) goto L11;
        r101 = true;
    L15:
        return null;
    }

    public k(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f524779a = new WeakReference(r100);
        this.f524780b = new WeakReference(r100.getView());
    }
}
