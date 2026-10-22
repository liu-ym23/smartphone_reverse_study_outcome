package ro0;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<b<?>> f538749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f538750b;

    public a(d r100) {
        this.f538750b = r100;
        this.f538749a = new ArrayList();
    }

    public final void a(b<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        d r101 = this.f538750b;
        if (r101 == null) goto L5;
        r101.addMessageListener(r100.a().getIntType(), r100.f538751a);
    L5:
        this.f538749a.add(r100);
    }
}
