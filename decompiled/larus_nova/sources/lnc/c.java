package lnc;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.component.logger.Log;
import com.suite.component.logger.api.LogLevel;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes40.dex */
public final class c implements com.suite.component.logger.api.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f510070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f510071b;

    public c() {
        this(0);
    }

    public c(int r100) {
        this.f510070a = 30;
        this.f510071b = 4096;
    }

    @Override // com.suite.component.logger.api.d
    public final void a(com.suite.component.logger.api.d.a r110, com.suite.component.logger.b r111, com.suite.component.logger.c r112) {
        Intrinsics.checkNotNullParameter(r110, "chain");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "entity");
        int r100 = r112.f460116b.length();
        int r101 = this.f510070a;
        if (r100 <= r101) goto L5;
        String r102 = r112.f460116b.substring(0, r101);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r112.f460116b = r102;
    L5:
        String r103 = r112.f460117c;
        int r104 = r103.length();
        if (r104 > this.f510071b) goto L9;
        r110.a(r111, r112);
        return;
    L9:
        int r105 = 0;
        int r113 = 1;
    L11:
        if (r105 >= r103.length()) goto L28;
        String r114 = r103.substring(r105, RangesKt.coerceAtMost(this.f510071b + r105, r103.length()));
        com.suite.component.logger.interceptor.b r115 = r110.clone();
        Object r116 = com.suite.component.logger.c.f460112w;
        Intrinsics.checkNotNullParameter(r112, PlayerResolution.SDKKEY.ORIGIN);
        com.suite.component.logger.c r117 = com.suite.component.logger.c.a.a();
        LogLevel r118 = r112.f460115a;
        Intrinsics.checkNotNullParameter(r118, "<set-?>");
        r117.f460115a = r118;
        String r119 = r112.f460116b;
        Intrinsics.checkNotNullParameter(r119, "<set-?>");
        r117.f460116b = r119;
        r117.b(r112.f460117c);
        r117.f460119e = r112.f460119e;
        r117.f460120f = r112.f460120f;
        r117.f460121g = r112.f460121g;
        r117.f460122h = r112.f460122h;
        r117.f460123i = r112.f460123i;
        r117.f460124j = r112.f460124j;
        r117.f460125k = r112.f460125k;
        String r120 = r112.f460126l;
        Intrinsics.checkNotNullParameter(r120, "<set-?>");
        r117.f460126l = r120;
        r117.f460127m = r112.f460127m;
        String r121 = r112.f460128n;
        Intrinsics.checkNotNullParameter(r121, "<set-?>");
        r117.f460128n = r121;
        r117.f460129o = r112.f460129o;
        r117.c(r112.f460130p);
        HashMap<String, Object> r122 = r112.f460131q;
        if (r122 != null) goto L15;
    L18:
        boolean r123 = true;
    L19:
        if (r123 == true) goto L27;
        if (r117.f460131q != null) goto L24;
        r117.f460131q = new HashMap(4);
    L24:
        HashMap<String, Object> r106 = r117.f460131q;
        if (r106 == null) goto L27;
        r106.putAll(r122);
    L27:
        String r107 = r117.f460116b + '-' + r113;
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r117.f460116b = r107;
        r117.b(r114);
        Unit r108 = Unit.INSTANCE;
        r115.a(r111, r117);
        r105 = r105 + this.f510071b;
        r113 = r113 + 1;
        goto L11
    L15:
        if (r122.isEmpty() == true) goto L18;
        r123 = false;
        goto L19
    L28:
        com.suite.lark.component.logger.dynamic.a r109 = Log.f460091e;
        if (r109 == null) goto L36;
        r109.c(r112.f460116b, r104);
        return;
    }
}
