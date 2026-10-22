package com.ss.android.lark.chameleonv2.container.webcontainer.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import com.ss.android.lark.officesdk.utils.di.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f411293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f411294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f411295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f411296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f411297e;

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.getAction() != 0) goto L36;
        long r101 = System.currentTimeMillis();
        int r102 = this.f411294b;
        if (r102 != 0) goto L8;
        this.f411293a = r101;
    L8:
        if ((r101 - this.f411293a) <= this.f411296d) goto L10;
        this.f411294b = 0;
        goto L36
    L10:
        int r103 = r102 + 1;
        this.f411294b = r103;
        if (r103 < this.f411297e) goto L36;
        com.ss.android.lark.storage.a r104 = ChameleonDebugUtils.f411281a;
        Context r105 = this.f411295c;
        if (r105 != null) goto L16;
    L21:
        Activity r106 = null;
    L23:
        if (r106 == null) goto L34;
        com.ss.android.lark.storage.a r107 = ChameleonDebugUtils.f411281a;
        Intrinsics.checkNotNullParameter(r106, "activity");
        if (b.a() == true) goto L38;
    L35:
        this.f411294b = 0;
        goto L36
    L38:
        Intent r108 = new Intent("com.ss.android.lark.ACTION_CML_DEBUG_V2");     // Catch: Exception -> L32
        r108.addCategory("android.intent.category.DEFAULT");     // Catch: Exception -> L32
        r108.addFlags(268435456);     // Catch: Exception -> L32
        r108.setPackage(r106.getPackageName());     // Catch: Exception -> L32
        if (r106.getPackageManager().resolveActivity(r108, 0) != null) goto L30;
        j.b("CML_TAG_ChameleonDebugUtils", "CmlDebugActivity not resolve");     // Catch: Exception -> L32
    L37:
        goto L35
    L30:
        r106.startActivity(r108);     // Catch: Exception -> L32
    L32:
        e = move-exception;
        j.c("CML_TAG_ChameleonDebugUtils", "Failed to launch CmlDebugActivity", e);
        goto L35
    L34:
        j.b("CML_TAG_ChameleonDebugUtils", "Unable to find Activity from context");
    L16:
        if ((r105 instanceof ContextWrapper) == false) goto L21;
        if ((r105 instanceof Activity) == true) goto L19;
        r105 = ((ContextWrapper) r105).getBaseContext();
        goto L16
    L19:
        r106 = (Activity) r105;
    L36:
        return false;
    }

    public c(Context r100, long r101, int r102) {
        this.f411295c = r100;
        this.f411296d = r101;
        this.f411297e = r102;
        super(r100);
    }
}
