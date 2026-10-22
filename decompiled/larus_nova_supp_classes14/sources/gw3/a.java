package gw3;

import com.bytedance.sdk.xbridge.cn.system.s;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import hq9.a3;
import kotlin.jvm.internal.Intrinsics;
import re7.e;
import re7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements a3 {
    public final /* synthetic */ e a;

    /* JADX INFO: renamed from: gw3.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0131a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LocationResult.values().length];
            r0[LocationResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public a(s.a r1) {
        this.a = r1;
    }

    public final void a(LocationResult r5, Integer r6, GeoLocationInfo r7) {
        Intrinsics.checkNotNullParameter(r5, "code");
        if (C0131a.a[r5.ordinal()] != 1) goto L11;
        e r8 = this.a;
        double r0 = 0.0d;
        if (r7 == null) goto L7;
        double r2 = r7.getLatitude();
    L8:
        if (r7 == null) goto L10;
        r0 = r7.getLongitude();
    L10:
        r8.a(new f(r2, r0));
        return;
    L7:
        r2 = 0.0d;
        goto L8
    L11:
        this.a.onFail(r5.getMessage());
    }
}
