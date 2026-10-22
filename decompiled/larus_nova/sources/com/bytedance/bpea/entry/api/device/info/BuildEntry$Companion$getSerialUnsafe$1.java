package com.bytedance.bpea.entry.api.device.info;

import android.os.Build;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class BuildEntry$Companion$getSerialUnsafe$1 extends Lambda implements Function0<String> {
    public static final BuildEntry$Companion$getSerialUnsafe$1 INSTANCE = null;

    static {
        INSTANCE = new BuildEntry$Companion$getSerialUnsafe$1();
    }

    public BuildEntry$Companion$getSerialUnsafe$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        if (Build.VERSION.SDK_INT < 26) goto L22;
        ArrayList r100 = new ArrayList();
        Object[] r101 = new Object[0];
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(101200);
        if (r102 == null) goto L7;
        f06.a[] r103 = r102.f479473i;
    L8:
        f06.a[] r111 = r103;
        int r112 = r111.length;
        int r104 = 0;
    L10:
        if (r104 >= r112) goto L17;
        f06.a r105 = r111[r104];
        int r113 = r104;
        int r114 = r112;
        f06.a[] r115 = r111;
        f06.d r106 = r105.preInvoke(101200, "android/os/Build", "getSerial", Build.class, r101, "java.lang.String", r110);     // Catch: Exception -> L41
        if (r106.f474982a == true) goto L19;
        r100.add(r105);     // Catch: Exception -> L41
    L19:
        if (r106.f474982a == false) goto L54;
        return (String) r106.f474983b;
    L54:
        return Build.getSerial();
    L16:
        r104 = r113 + 1;
        r112 = r114;
        r111 = r115;
        goto L10
    L17:
        r106 = new f06.d(false, null);
        goto L19
    L7:
        r103 = ApiHookConfig.f245613d;
        goto L8
    L22:
        ArrayList r107 = new ArrayList();
        Object[] r108 = new Object[0];
        f06.b r109 = new f06.b();
        g06.a r116 = ApiHookConfig.f245611b.get(102002);
        if (r116 == null) goto L25;
        f06.a[] r117 = r116.f479473i;
    L26:
        f06.a[] r118 = r117;
        int r119 = r118.length;
        int r120 = 0;
    L28:
        if (r120 >= r119) goto L35;
        f06.a r121 = r118[r120];
        int r122 = r120;
        int r123 = r119;
        f06.a[] r124 = r118;
        f06.d r125 = r121.preInvoke(102002, "android/os/Build", "SERIAL", Build.class, r108, "java.lang.String", r109);     // Catch: Exception -> L42
        if (r125.f474982a == true) goto L37;
        r107.add(r121);     // Catch: Exception -> L42
    L37:
        if (r125.f474982a == false) goto L40;
        return (String) r125.f474983b;
    L40:
        return Build.SERIAL;
    L34:
        r120 = r122 + 1;
        r119 = r123;
        r118 = r124;
        goto L28
    L35:
        r125 = new f06.d(false, null);
        goto L37
    L25:
        r117 = ApiHookConfig.f245613d;
        goto L26
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
