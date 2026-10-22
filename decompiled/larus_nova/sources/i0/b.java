package i0;

import android.graphics.Path;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<s> f487737a;

    public b() {
        this.f487737a = new ArrayList();
    }

    public final void a(Path r100) {
        int r101 = ((ArrayList) this.f487737a).size() - 1;
    L3:
        if (r101 < 0) goto L5;
        u0.f.b(r100, (s) ListProtector.get(this.f487737a, r101));
        r101 = r101 - 1;
        goto L3
    }
}
