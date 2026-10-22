package nc0;

import androidx.lifecycle.LiveData;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements ey.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<ey.j, com.bytedance.android.live.revenuelink.connect.m> f518603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<ey.h, com.bytedance.android.live.revenuelink.connect.i> f518604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.live.revenuelink.connect.f f518605d;

    public final LiveData<ey.f> c() {
        return this.f518605d.connectState();
    }

    public b(com.bytedance.android.live.revenuelink.connect.f r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f518605d = r100;
        this.f518603b = new HashMap();
        this.f518604c = new HashMap();
    }

    @Override // ey.g
    public final void a(int r100, ey.j r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        com.bytedance.android.live.revenuelink.connect.m r102 = (com.bytedance.android.live.revenuelink.connect.m) ((HashMap) this.f518603b).remove(r101);
        if (r102 == null) goto L6;
        this.f518605d.removeLinkOutListener(r100, r102);
        return;
    }

    public final void b(int r100, ey.j r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        i r102 = new i(r101);
        this.f518605d.addLinkOutListener(r100, r102);
        ((HashMap) this.f518603b).put(r101, r102);
    }
}
