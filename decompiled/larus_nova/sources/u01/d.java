package u01;

import com.bytedance.android.livesdkapi.feed.ImCacheUnit;
import com.bytedance.android.livesdkapi.service.RevImCacheUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements ImCacheUnit {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RevImCacheUnit f548130a;

    @Override // com.bytedance.android.livesdkapi.feed.ImCacheUnit
    public final String getMessageMethod() {
        return this.f548130a.getMessageMethod();
    }

    @Override // com.bytedance.android.livesdkapi.feed.ImCacheUnit
    public final String getTag() {
        return this.f548130a.getTag();
    }

    public d(RevImCacheUnit r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f548130a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ImCacheUnit
    public final void doHandle(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f548130a.doHandle((yh6.c) r100);
    }
}
