package com.obric.assistant.ipc;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class l {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.os.Bundle, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v7 */
    public static final Bundle a(ContentResolver r210, String r211, Bundle r212) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        Intrinsics.checkNotNullParameter(r211, com.alipay.sdk.m.p.e.f25671s);
        Uri r110 = com.obric.assistant.voice.k.f394380a;
        ArrayList r111 = new ArrayList();
        Object[] r112 = {r110};
        f06.b r113 = new f06.b();
        g06.a r100 = ApiHookConfig.f245611b.get(240008);
        if (r100 == null) goto L5;
        f06.a[] r101 = r100.f479473i;
    L6:
        f06.a[] r102 = r101;
        int r103 = r102.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r102[r104];
        int r114 = r104;
        int r115 = r103;
        f06.a[] r213 = r102;
        f06.d r106 = r105.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r210, r112, "android.content.ContentProviderClient", r113);     // Catch: Exception -> L45
        if (r106.f474982a == true) goto L12;
        r111.add(r105);     // Catch: Exception -> L45
        goto L14
    L12:
        ?? r107 = 0;
    L17:
        if (r106.f474982a == false) goto L19;
        ContentProviderClient r108 = (ContentProviderClient) r106.f474983b;
    L20:
        ContentProviderClient r109 = r108;
        if (r109 != 0) goto L46;
        return r107;
    L46:
        Bundle r116 = r109.call(r211, r107, r212);     // Catch: Throwable -> L34
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L31
        if (Build.VERSION.SDK_INT < 24) goto L28;
        r109.close();     // Catch: Throwable -> L31
        Object r118 = Unit.INSTANCE;     // Catch: Throwable -> L31
    L29:
        Result.m9449constructorimpl(r118);     // Catch: Throwable -> L31
    L33:
        return r116;
    L28:
        r118 = Boolean.valueOf(r109.release());     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L34:
        th = move-exception;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L42
        if (Build.VERSION.SDK_INT < 24) goto L39;
        r109.close();     // Catch: Throwable -> L42
        Object r121 = Unit.INSTANCE;     // Catch: Throwable -> L42
    L40:
        Result.m9449constructorimpl(r121);     // Catch: Throwable -> L42
        throw th;
    L39:
        r121 = Boolean.valueOf(r109.release());     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        throw th;
    L19:
        r108 = r210.acquireUnstableContentProviderClient(r110);
    L14:
        r104 = r114 + 1;
        r103 = r115;
        r102 = r213;
        goto L8
    L15:
        r107 = 0;
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r101 = ApiHookConfig.f245613d;
        goto L6
    }
}
