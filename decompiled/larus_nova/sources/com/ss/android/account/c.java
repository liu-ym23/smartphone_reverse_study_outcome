package com.ss.android.account;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c {

    /* JADX INFO: loaded from: classes34.dex */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f406238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ hb7.b f406239b;

        public a(Activity r100, hb7.b r101) {
            this.f406238a = r100;
            this.f406239b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            hb7.c r100 = new hb7.c(this.f406238a);     // Catch: Throwable -> L9
            r100.f484497a = this.f406239b;     // Catch: Throwable -> L9
            if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L15;
            DialogLancet.handleBlockedDialogShow(r100);     // Catch: Throwable -> L9
            return;
        L15:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14 Throwable -> L9
        L7:
            DialogLancet.beforeDialogShow(r100);     // Catch: Throwable -> L9
            r100.show();     // Catch: Throwable -> L9
            DialogLancet.afterDialogShow(r100);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L13;
            return;
        L13:
            throw th;
        }
    }

    public c() {
    }

    public boolean a(hb7.b r100) {
        Activity r101 = com.bytedance.sdk.account.utils.d.b();
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.isFinishing() == false) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L14;
        hb7.c r102 = new hb7.c(r101);
        r102.f484497a = r100;
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L20;
        DialogLancet.handleBlockedDialogShow(r102);
        return true;
    L20:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L13:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
        return true;
    L14:
        new Handler(Looper.getMainLooper()).post(new a(r101, r100));
        return true;
    }
}
