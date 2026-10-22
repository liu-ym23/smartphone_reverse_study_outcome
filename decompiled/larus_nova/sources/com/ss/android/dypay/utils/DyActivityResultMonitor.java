package com.ss.android.dypay.utils;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/ss/android/dypay/utils/DyActivityResultMonitor;", "Landroid/app/Instrumentation$ActivityMonitor;", "Landroid/content/Intent;", "intent", "Landroid/app/Instrumentation$ActivityResult;", "onStartActivity", "(Landroid/content/Intent;)Landroid/app/Instrumentation$ActivityResult;", "", "result", "Landroid/os/Bundle;", "bOptions", "", "onStartActivityResult", "(ILandroid/os/Bundle;)V", "Lcom/ss/android/dypay/utils/l;", "callback", "Lcom/ss/android/dypay/utils/l;", "getCallback", "()Lcom/ss/android/dypay/utils/l;", "<init>", "(Lcom/ss/android/dypay/utils/l;)V", "dy-pay-sdk_withoutLogRelease"}, k = 1, mv = {1, 1, 15})
public final class DyActivityResultMonitor extends Instrumentation.ActivityMonitor {
    private final l callback;

    public DyActivityResultMonitor(l r100) {
        this.callback = r100;
    }

    public final l getCallback() {
        return this.callback;
    }

    @Override // android.app.Instrumentation.ActivityMonitor
    public Instrumentation.ActivityResult onStartActivity(Intent r100) {
        return super.onStartActivity(r100);
    }

    public final void onStartActivityResult(int r100, Bundle r101) {
        l r102 = this.callback;
        if (r102 == null) goto L6;
        ((rta.c) r102).f539203a.invoke(Integer.valueOf(r100));
        return;
    }
}
