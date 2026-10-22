package nz5;

import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.bytedance.helios.sdk.anchor.CustomAnchorMonitor;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.bytedance.helios.sdk.detector.l.b {
    public d() {
    }

    @Override // com.bytedance.helios.sdk.detector.l.b
    public final void a() {
        hz5.k.d("CustomAnchor", "Cam:onEventAllRemoved");
        Map<Integer, List<PrivacyEvent>> r100 = CustomAnchorMonitor.f245485b;
        monitor-enter(r100);
        List<PrivacyEvent> r101 = r100.get(1);     // Catch: Throwable -> L10
        if (r101 == null) goto L8;
        r101.clear();     // Catch: Throwable -> L10
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.helios.sdk.detector.l.b
    public final void b(long r100) {
        hz5.k.d("CustomAnchor", "Cam:onEventRemoved: " + r100);
        Map<Integer, List<PrivacyEvent>> r101 = CustomAnchorMonitor.f245485b;
        monitor-enter(r101);
        List<PrivacyEvent> r102 = r101.get(1);     // Catch: Throwable -> L16
        if (r102 == null) goto L14;
        Iterator<PrivacyEvent> r103 = r102.iterator();     // Catch: Throwable -> L16
    L9:
        if (r103.hasNext() == false) goto L13;
        if (r103.next().f245380q != r100) goto L9;
        r103.remove();     // Catch: Throwable -> L16
        goto L9
    L13:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r101);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.helios.sdk.detector.l.b
    public final void c(long r100, PrivacyEvent r101) {
        hz5.k.d("CustomAnchor", "Cam:onEventAdded: " + r100);
        Map<Integer, List<PrivacyEvent>> r102 = CustomAnchorMonitor.f245485b;
        monitor-enter(r102);
        List<PrivacyEvent> r103 = r102.get(1);     // Catch: Throwable -> L10
        if (r103 == null) goto L8;
        r103.add(r101);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r102);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
