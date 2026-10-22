package dq2;

import com.bytedance.android.livesdk.revenue.pushstream.RevLiveStreamImpl;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j extends com.bytedance.android.livesdk.revenue.util.b<qd0.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHashMap<com.bytedance.android.live.pushstream.d, com.bytedance.android.livesdk.revenue.pushstream.a> f469638b;

    public final com.bytedance.android.livesdk.revenue.pushstream.a n() {
        com.bytedance.android.live.pushstream.d r100 = ((qd0.a) this.f157529a).guestLiveStream();
        if (r100 != null) goto L6;
        return null;
    L6:
        com.bytedance.android.livesdk.revenue.pushstream.a r101 = this.f469638b.get(r100);
        if (r101 == null) goto L9;
        return r101;
    L9:
        RevLiveStreamImpl r102 = new RevLiveStreamImpl(r100);
        this.f469638b.put(r100, r102);
        return r102;
    }

    public j(qd0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        super(r100);
        this.f469638b = new WeakHashMap();
    }
}
