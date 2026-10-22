package gr2;

import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import com.bytedance.live.livelink.kmp.api.base.config.StreamType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class r implements IConfig.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f482329b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r f482330c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StreamType f482331a;

    public static final class a {
    }

    static {
        f482329b = new r(StreamType.AUDIO);
        f482330c = new r(StreamType.VIDEO);
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f482331a;
    }

    public r(StreamType r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f482331a = r100;
    }
}
