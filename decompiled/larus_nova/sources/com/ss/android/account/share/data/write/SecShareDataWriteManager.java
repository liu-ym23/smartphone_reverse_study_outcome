package com.ss.android.account.share.data.write;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
public final class SecShareDataWriteManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f406331a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f406332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f406333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Context f406334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f406335e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final SecShareDataWriteManager f406336f = null;

    static {
        f406331a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SecShareDataWriteManager.class), "gson", "getGson()Lcom/google/gson/Gson;"))};
        f406336f = new SecShareDataWriteManager();
        f406332b = new d();
        f406335e = LazyKt.lazy(SecShareDataWriteManager$gson$2.INSTANCE);
    }

    public SecShareDataWriteManager() {
    }

    public static boolean a(String r100) {
        if (f406333c == true) goto L5;
        dra.b r101 = new dra.b();
        r101.b("share_sdk_no_init");
        r101.c();
        boolean r102 = false;
    L6:
        if (r102 == true) goto L8;
        return false;
    L8:
        String r103 = "";
        if (TextUtils.isEmpty(r100) == false) goto L11;
    L36:
        dra.b r104 = new dra.b();
        r104.b("share_sdk_check_pkg_sign_failed");
        r104.a("pkg_name", r100);
        r104.a("pkg_sign", r103);
        r104.c();
        return false;
    L11:
        if (f406333c == false) goto L36;
        if (CollectionsKt.contains(f406332b.f406344a.keySet(), r100) == false) goto L36;
        int r105 = c.f406343a;
        Context r106 = f406334d;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
    L17:
        if (r100 != null) goto L19;
        Intrinsics.throwNpe();
    L19:
        String r107 = null;
        String r108 = c.a(r106.getPackageManager().getPackageInfo(r100, 64).signatures[0]);     // Catch: Exception -> L22
    L24:
        if (r108 == null) goto L27;
        r103 = r108;
    L27:
        if (TextUtils.isEmpty(r103) == true) goto L36;
        if (TextUtils.isEmpty(f406332b.f406344a.get(r100)) == true) goto L36;
        String r109 = r103.toLowerCase();
        String r110 = f406332b.f406344a.get(r100);
        if (r110 == null) goto L34;
        r107 = r110.toLowerCase();
    L34:
        if (Intrinsics.areEqual(r109, r107) == false) goto L36;
        return true;
    L22:
        e = move-exception;
        e.printStackTrace();
        dra.b r111 = new dra.b();
        r111.b("share_sdk_get_pkg_sign_failed");
        r111.a(LocationMonitorConst.ERR_MSG, e.getMessage());
        r111.a("err_msg_stack", Log.getStackTraceString(e));
        r111.c();
        r108 = null;
        goto L24
    L5:
        r102 = true;
        goto L6
    }
}
