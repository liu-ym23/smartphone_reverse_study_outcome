package w64;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.monitor.NetworkStatusMonitor;
import com.bytedance.badger.collect.impl.utils.KLog;
import z64.i;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements z64.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f558422a;

    public f(g r100) {
        this.f558422a = r100;
    }

    @Override // z64.g
    public final void a(i r100) {
        if ((r100 instanceof i.b) == false) goto L8;
        KLog.i(Constants.TAGS.NETWORK_MONITOR, "sim change, success " + ((i.b) r100).f570480c);
        if (NetworkStatusMonitor.isStarted() == false) goto L11;
        NetworkStatusMonitor.getInstance(this.f558422a.f558423a.f558424a).stop();
        return;
    L11:
        return;
    L8:
        if ((r100 instanceof i.a) == false) goto L13;
        KLog.e(Constants.TAGS.NETWORK_MONITOR, "sim change, error " + ((i.a) r100).f570475a);
        return;
    }
}
