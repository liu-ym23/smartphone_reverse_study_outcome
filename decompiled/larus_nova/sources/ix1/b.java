package ix1;

import com.bytedance.android.livesdk.feedback.service.FeedbackHideCode;
import com.bytedance.android.livesdk.feedback.service.d;
import com.bytedance.android.livesdk.feedback.service.e;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f496320a;

    @Override // ix1.a
    public final void b() {
        Iterator<T> r100 = this.f496320a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((d) r100.next()).d(FeedbackHideCode.REMOVE_DATA);
        goto L4
    }

    @Override // ix1.a
    public final void c() {
        Iterator<T> r100 = this.f496320a.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        e r101 = ((d) r100.next()).a();
        if (r101 == null) goto L4;
        r101.reset();
        goto L4
    }

    @Override // ix1.a
    public final void d() {
        Iterator<T> r100 = this.f496320a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((d) r100.next()).c();
        goto L4
    }

    @Override // ix1.a
    public final void f() {
        Iterator<T> r100 = this.f496320a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((d) r100.next()).onLeaveRoom();
        goto L4
    L6:
        ((ArrayList) this.f496320a).clear();
    }

    public b() {
        this.f496320a = new ArrayList();
    }

    @Override // ix1.a
    public final List<d> a() {
        return this.f496320a;
    }

    @Override // ix1.a
    public final void e(List<? extends d> r100) {
        Intrinsics.checkNotNullParameter(r100, FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY);
        ArrayList r101 = (ArrayList) this.f496320a;
        r101.clear();
        r101.addAll(r100);
    }
}
