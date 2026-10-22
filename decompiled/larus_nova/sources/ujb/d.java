package ujb;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f550461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f550462b;

    public interface a {
        void a(View r100, f r101);
    }

    public d(String r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "buttonAction");
        this.f550461a = r100;
        this.f550462b = r101;
    }
}
