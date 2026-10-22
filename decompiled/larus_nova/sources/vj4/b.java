package vj4;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import pk4.j;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<d> f555414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ak4.a f555415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f555416c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f555417a = null;

        static {
            f555417a = new b();
        }
    }

    public b() {
        this.f555414a = new CopyOnWriteArraySet();
        this.f555415b = ak4.a.d();
        this.f555416c = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("DoraCrossSysCommunication"));
    }

    public final void c(d r100) {
        if (r100 == null) goto L5;
        ((CopyOnWriteArraySet) this.f555414a).remove(r100);
        return;
    }

    public final int b(int r100, c r101) {
        j.d("DoraCrossSysCommunication", "request: requestId=" + r100 + ", event=" + r101);
        return this.f555415b.i(r101.getSid(), r101.getCid(), r101.getData(r100));
    }

    @Override // vj4.d
    public final void a(final long r110, final int r111, final int r112, final int r210, final int r211, final byte[] r212, final long r213, final byte[] r214) {
        this.f555416c.execute(new vj4.a(this, r110, r111, r112, r210, r211, r212, r213, r214));
    }
}
