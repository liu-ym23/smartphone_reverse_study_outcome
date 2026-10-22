package gz2;

import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.util.q;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements com.bytedance.android.monitorV2.listener.g {
    public d() {
    }

    @Override // com.bytedance.android.monitorV2.listener.g
    public void onEventCreated(HybridEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        HybridEvent.a r101 = r100.f163004d;
        r101.f163016a = HybridEvent.EventPhase.EVENT_CREATE;
        Iterator<com.bytedance.android.monitorV2.listener.g> r102 = e.f483376a.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        r102.next().onEventCreated(r100);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        goto L4
    L10:
        Iterator<com.bytedance.android.monitorV2.listener.f> r103 = e.f483377b.iterator();
    L12:
        if (r103.hasNext() == false) goto L17;
        com.bytedance.android.monitorV2.listener.f r104 = r103.next();
        String r105 = r100.f163001a;     // Catch: Throwable -> L16
        HybridEvent.a r106 = r100.f163004d;     // Catch: Throwable -> L16
        String r107 = r100.a().toString();     // Catch: Throwable -> L16
        q.f163249a.getClass();     // Catch: Throwable -> L16
        r104.onEventCreated(new com.bytedance.android.monitorV2.event.c(r105, r106, r107, q.e(r100)));     // Catch: Throwable -> L16
        goto L12
    }

    @Override // com.bytedance.android.monitorV2.listener.g
    public void onEventSampled(HybridEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        HybridEvent.a r101 = r100.f163004d;
        r101.f163016a = HybridEvent.EventPhase.SAMPLE_THROW;
        Iterator<com.bytedance.android.monitorV2.listener.g> r102 = e.f483376a.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        r102.next().onEventSampled(r100);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        goto L4
    L10:
        Iterator<com.bytedance.android.monitorV2.listener.f> r103 = e.f483377b.iterator();
    L12:
        if (r103.hasNext() == false) goto L17;
        com.bytedance.android.monitorV2.listener.f r104 = r103.next();
        String r105 = r100.f163001a;     // Catch: Throwable -> L16
        HybridEvent.a r106 = r100.f163004d;     // Catch: Throwable -> L16
        String r107 = r100.a().toString();     // Catch: Throwable -> L16
        q.f163249a.getClass();     // Catch: Throwable -> L16
        r104.onEventSampled(new com.bytedance.android.monitorV2.event.c(r105, r106, r107, q.e(r100)));     // Catch: Throwable -> L16
        goto L12
    }

    @Override // com.bytedance.android.monitorV2.listener.g
    public void onEventTerminated(HybridEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        HybridEvent.a r101 = r100.f163004d;
        r101.f163016a = HybridEvent.EventPhase.EVENT_TERMINATED;
        Iterator<com.bytedance.android.monitorV2.listener.g> r102 = e.f483376a.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        r102.next().onEventTerminated(r100);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        goto L4
    L10:
        Iterator<com.bytedance.android.monitorV2.listener.f> r103 = e.f483377b.iterator();
    L12:
        if (r103.hasNext() == false) goto L17;
        com.bytedance.android.monitorV2.listener.f r104 = r103.next();
        String r105 = r100.f163001a;     // Catch: Throwable -> L16
        HybridEvent.a r106 = r100.f163004d;     // Catch: Throwable -> L16
        String r107 = r100.a().toString();     // Catch: Throwable -> L16
        q.f163249a.getClass();     // Catch: Throwable -> L16
        r104.onEventTerminated(new com.bytedance.android.monitorV2.event.c(r105, r106, r107, q.e(r100)));     // Catch: Throwable -> L16
        goto L12
    }

    @Override // com.bytedance.android.monitorV2.listener.g
    public void onEventUpdated(HybridEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        HybridEvent.a r101 = r100.f163004d;
        r101.f163016a = HybridEvent.EventPhase.EVENT_UPDATED;
        Iterator<com.bytedance.android.monitorV2.listener.g> r102 = e.f483376a.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        r102.next().onEventUpdated(r100);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        goto L4
    L10:
        Iterator<com.bytedance.android.monitorV2.listener.f> r103 = e.f483377b.iterator();
    L12:
        if (r103.hasNext() == false) goto L17;
        com.bytedance.android.monitorV2.listener.f r104 = r103.next();
        String r105 = r100.f163001a;     // Catch: Throwable -> L16
        HybridEvent.a r106 = r100.f163004d;     // Catch: Throwable -> L16
        String r107 = r100.a().toString();     // Catch: Throwable -> L16
        q.f163249a.getClass();     // Catch: Throwable -> L16
        r104.onEventUpdated(new com.bytedance.android.monitorV2.event.c(r105, r106, r107, q.e(r100)));     // Catch: Throwable -> L16
        goto L12
    }

    @Override // com.bytedance.android.monitorV2.listener.g
    public void onEventUploaded(HybridEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        HybridEvent.a r101 = r100.f163004d;
        r101.f163016a = HybridEvent.EventPhase.EVENT_UPLOAD;
        Iterator<com.bytedance.android.monitorV2.listener.g> r102 = e.f483376a.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        r102.next().onEventUploaded(r100);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        goto L4
    L10:
        Iterator<com.bytedance.android.monitorV2.listener.f> r103 = e.f483377b.iterator();
    L12:
        if (r103.hasNext() == false) goto L17;
        com.bytedance.android.monitorV2.listener.f r104 = r103.next();
        String r105 = r100.f163001a;     // Catch: Throwable -> L16
        HybridEvent.a r106 = r100.f163004d;     // Catch: Throwable -> L16
        String r107 = r100.a().toString();     // Catch: Throwable -> L16
        q.f163249a.getClass();     // Catch: Throwable -> L16
        r104.onEventUploaded(new com.bytedance.android.monitorV2.event.c(r105, r106, r107, q.e(r100)));     // Catch: Throwable -> L16
        goto L12
    }
}
