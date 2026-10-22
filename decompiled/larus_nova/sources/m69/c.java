package m69;

import com.larus.im.service.audio.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f512303a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<f> f512304b = null;

    public c() {
    }

    static {
        f512303a = new c();
        f512304b = new ArrayList();
    }

    @Override // m69.f
    public final void a() {
        Iterator r100 = ((ArrayList) f512304b).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((f) r100.next()).a();
        goto L4
    }

    @Override // m69.f
    public final void b(Map<String, String> r100) {
        Iterator r101 = ((ArrayList) f512304b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((f) r101.next()).b(r100);
        goto L4
    }

    @Override // m69.f
    public final void c(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Iterator r101 = ((ArrayList) f512304b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((f) r101.next()).c(r100);
        goto L4
    }

    @Override // m69.f
    public final void d(Integer r100) {
        Iterator r101 = ((ArrayList) f512304b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((f) r101.next()).d(r100);
        goto L4
    }

    @Override // m69.f
    public final void e(z0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Iterator r101 = ((ArrayList) f512304b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((f) r101.next()).e(r100);
        goto L4
    }
}
