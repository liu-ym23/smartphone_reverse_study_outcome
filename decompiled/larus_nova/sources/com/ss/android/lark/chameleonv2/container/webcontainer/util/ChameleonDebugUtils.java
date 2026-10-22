package com.ss.android.lark.chameleonv2.container.webcontainer.util;

import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ChameleonDebugUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ss.android.lark.storage.a f411281a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f411282b = null;

    static {
        f411281a = new com.ss.android.lark.storage.a("chameleon");
        f411282b = LazyKt.lazy(ChameleonDebugUtils$kvRepo$2.INSTANCE);
    }

    public static KVRepo b() {
        return (KVRepo) f411282b.getValue();
    }

    public static String a() {
        return b().getString("chameleon_ip_proxy_bizname", null);
    }

    public static String c(String r100) {
        if (b.a() == false) goto L36;
        boolean r101 = true;
        if (r100 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L36;
        if (b().getBoolean("chameleon_disable_ip_proxy", false) == false) goto L16;
        return "";
    L16:
        String r103 = a();
        if (r103 != null) goto L19;
        r103 = "";
    L19:
        String r104 = b().getString("chameleon_ip_proxy_url", null);
        if (r104 != null) goto L23;
        r104 = "";
    L23:
        if (r103.length() <= 0) goto L25;
        boolean r105 = true;
    L26:
        if (r105 == false) goto L36;
        if (r104.length() > 0) goto L31;
        r101 = false;
    L31:
        if (r101 == false) goto L36;
        if (Intrinsics.areEqual(r100, r103) == false) goto L36;
        j.e("CML_TAG_ChameleonDebugUtils", "Using proxy URL for biz: " + r100 + ", proxy: " + r104);
        return r104;
    L25:
        r105 = false;
        goto L26
    L7:
        if (r100.length() == 0) goto L10;
        r102 = false;
    L36:
        return "";
    }
}
