package com.larus.shortcuts.impl;

import android.content.Intent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes31.dex */
public final class ShortcutCommonUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f369227a = 0;

    static {
    }

    public ShortcutCommonUtil() {
    }

    public static Intent b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        AppHost.Companion r101 = AppHost.f326268a;
        Intent r102 = r101.getApplication().getPackageManager().getLaunchIntentForPackage(r101.getApplication().getPackageName());
        if (r102 != null) goto L5;
        r102 = new Intent();
    L5:
        r102.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        r102.setPackage(r101.getApplication().getPackageName());
        r102.setData(UriProtector.parse(r100).buildUpon().build());
        r102.setFlags(268468224);
        return r102;
    }

    public static final Object a(String r100, Continuation r101) {
        j r102 = new j(IntrinsicsKt.intercepted(r101), 1);
        r102.C();
        ImageLoaderKt.l(r100, "realtime_call_avatar_utils", new a(r102), null, 52);
        Object r103 = r102.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L5:
        return r103;
    }

    public static Object c(tw9.a r100, Continuation r101) {
        Object r102 = BuildersKt.withContext(Dispatchers.getIO(), new ShortcutCommonUtil$downloadImage$2(r100, null), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public static Object d(List r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ShortcutCommonUtil$downloadImages$2(r100, null), r101);
    }
}
