package rv3;

import com.bytedance.applet.aibridge.navi.OpenNavigationMapMethod;
import com.google.gson.Gson;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class s implements Function1 {
    public final /* synthetic */ long a;
    public final /* synthetic */ OpenNavigationMapMethod b;
    public final /* synthetic */ f3.h c;
    public final /* synthetic */ OpenNavigationMapMethod.c d;

    public /* synthetic */ s(long r1, OpenNavigationMapMethod r3, f3.h r4, OpenNavigationMapMethod.c r5) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public final Object invoke(Object r7) {
        long r0 = this.a;
        OpenNavigationMapMethod r2 = this.b;
        f3.h r3 = this.c;
        OpenNavigationMapMethod.c r4 = this.d;
        String r8 = (String) r7;
        Gson r5 = OpenNavigationMapMethod.b;
        Intrinsics.checkNotNullParameter(r8, "reason");
        if (OpenNavigationMapMethod.a.a(r0) == true) goto L5;
        r2.getClass();
        OpenNavigationMapMethod.c(r3, r4);
        return Unit.INSTANCE;
    L5:
        int r1 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.b("jsb_open_nav_map", "origin location fetch failed: " + r8);
        r4.a();
        f3.h.a.a(r3, "location_acquisition_failed: " + r8, null, null, 14);
        return Unit.INSTANCE;
    }
}
