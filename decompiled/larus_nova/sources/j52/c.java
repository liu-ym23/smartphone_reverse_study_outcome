package j52;

import com.ss.ugc.live.sdk.message.data.LimitedSizeHashMap;
import h52.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements l52.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LimitedSizeHashMap f497449a;

    public c() {
        this.f497449a = new LimitedSizeHashMap(512);
    }

    @Override // l52.c.a
    public final boolean a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        long r101 = r100.e();
        if (this.f497449a.containsKey(Long.valueOf(r101)) == false) goto L6;
        return true;
    L6:
        this.f497449a.put(Long.valueOf(r101), null);
        return false;
    }
}
