package yd6;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class e extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f567310c;

    public final String getIdentifier() {
        return this.f567310c;
    }

    public e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        super(r101, 0);
        this.f567310c = r100;
    }
}
