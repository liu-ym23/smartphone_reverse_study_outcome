package t69;

import com.bytedance.dora.camera.model.DoraVisionQueryTrackInfo;
import com.bytedance.dora.vision.DoraDataFrame;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j implements uj4.h {
    public j() {
    }

    @Override // uj4.h
    public final void d(DoraDataFrame r110) {
        Iterator<h49.d> r100 = k.f544689a.iterator();
    L4:
        if (r100.hasNext() == false) goto L12;
        h49.d r101 = r100.next();
        int r102 = r110.stage;
        int r103 = r110.scene;
        int r104 = r110.f204666id;
        int r105 = r110.type;
        int r106 = r110.seq;
        int r107 = r110.count;
        byte[] r108 = r110.data;
        if (r108 != null) goto L8;
        r108 = new byte[0];
    L8:
        byte[] r111 = r108;
        int r112 = r110.assId;
        byte[] r109 = r110.assData;
        if (r109 != null) goto L11;
        r109 = new byte[0];
    L11:
        r101.d(new b49.g(r102, r103, r104, r105, r106, r107, r111, r112, r109));
        goto L4
    }

    @Override // uj4.h
    public final void g(DoraVisionQueryTrackInfo r100) {
        b49.k r101 = new b49.k(r100.ttsStartTimestamp, r100.preCaptureLatency, r100.soundLatency);
        Iterator<h49.d> r102 = k.f544689a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().w(r101);
        goto L4
    }

    @Override // uj4.h
    public final void e(uj4.g r110, uj4.a r111) {
        Intrinsics.checkNotNullParameter(r110, "doraImageInfo");
        b49.h r100 = new b49.h(r110.f550366a, r110.f550367b, r110.f550368c, r110.f550369d, r110.f550370e, r110.f550371f, r110.f550372g, r110.f550373h, r110.f550374i);
        b49.d r112 = new b49.d(r111.f550323a, r111.f550324b);
        Iterator<h49.d> r113 = k.f544689a.iterator();
    L4:
        if (r113.hasNext() == false) goto L6;
        r113.next().c(r100, r112);
        goto L4
    }

    @Override // uj4.h
    public final void j(boolean r100, int r101, byte r102) {
        Iterator<h49.d> r103 = k.f544689a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().j(r100, r101, r102);
        goto L4
    }

    @Override // uj4.h
    public final void b(int r210, int r211, int r212, int r213, int r214, int r215, int r216, int r310, int r311, int r312, int r313, int r314, int r315, int r316, long r317, int r318, int r410, int r411) {
        Iterator<h49.d> r100 = k.f544689a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().b(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411);
        goto L4
    }
}
