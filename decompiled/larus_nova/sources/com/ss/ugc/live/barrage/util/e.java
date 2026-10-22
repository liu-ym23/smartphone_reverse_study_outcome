package com.ss.ugc.live.barrage.util;

import android.graphics.Bitmap;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bitmap f458162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f458163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f458164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f458165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function3 f458166e;

    public e(Bitmap r100, int r101, int r102, View r103, olc.a r104, Function3 r105) {
        this.f458162a = r100;
        this.f458163b = r101;
        this.f458164c = r102;
        this.f458165d = r103;
        this.f458166e = r105;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f458166e.invoke(this.f458162a, Integer.valueOf(this.f458163b), Integer.valueOf(this.f458164c));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
