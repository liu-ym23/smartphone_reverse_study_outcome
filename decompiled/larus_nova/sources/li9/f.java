package li9;

import android.view.View;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f509446a;

    public static final class a {
    }

    static {
    }

    public final WeakReference<View> a() {
        return this.f509446a.c();
    }

    public f(ki9.a r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f509446a = r100;
    }
}
