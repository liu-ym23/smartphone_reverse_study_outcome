package com.larus.bmhome.auth;

import com.bytedance.keva.Keva;
import com.larus.platform.service.o2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f295812a = null;

    public l0() {
    }

    static {
        f295812a = Keva.getRepo(o2.f365782a.e(), 0);
    }

    public static void a(LaunchInfo r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "userId");
        boolean r102 = false;
        if (r100 == null) goto L5;
        boolean r103 = Intrinsics.areEqual(r100.b0(), Boolean.TRUE);
    L6:
        if (r103 == false) goto L9;
        ColdStartTtsType r104 = ColdStartTtsType.DISABLED;
    L23:
        f295812a.storeInt("launch_info_cold_start_tts_type" + r101, r104.getType());
        return;
    L9:
        if (r100 != null) goto L11;
    L13:
        boolean r105 = false;
    L14:
        if (r105 == false) goto L16;
        r104 = ColdStartTtsType.DISABLED;
        goto L23
    L16:
        if (r100 != null) goto L18;
    L20:
        if (r102 == false) goto L22;
        r104 = ColdStartTtsType.ENABLED;
        goto L23
    L22:
        r104 = ColdStartTtsType.INVALID;
        goto L23
    L18:
        if (r100.z() != true) goto L20;
        r102 = true;
        goto L20
    L11:
        if (r100.z() == true) goto L13;
        r105 = true;
        goto L14
    L5:
        r103 = false;
        goto L6
    }
}
