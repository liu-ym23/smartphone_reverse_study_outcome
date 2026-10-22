package com.ss.android.lark.watermark.userscope;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwner;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Boolean f445459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WatermarkImplV3 f445460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f445461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f445462d;

    public m(Boolean r100, WatermarkImplV3 r101, Activity r102, LifecycleOwner r103) {
        this.f445459a = r100;
        this.f445460b = r101;
        this.f445461c = r102;
        this.f445462d = r103;
    }

    public final void a() {
        if (Intrinsics.areEqual(this.f445459a, Boolean.TRUE) == false) goto L5;
    L10:
        WatermarkImplV3 r100 = this.f445460b;
        WatermarkImplV3.c(r100, r100.f().f(), this.f445461c, this.f445462d);
        return;
    L5:
        if (this.f445459a == null) goto L7;
    L9:
        WatermarkImplV3 r101 = this.f445460b;
        WatermarkImplV3.c(r101, r101.f().b(), this.f445461c, this.f445462d);
        return;
    L7:
        if (this.f445460b.g() == false) goto L9;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
