package com.bytedance.assem.arch.reused;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.by.inflate_lib.AsyncInflater;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes14.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReusedUISlotAssem f193034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f193035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f193036c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f193037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f193038b;

        public a(r r100, View r101) {
            this.f193037a = r100;
            this.f193038b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((ViewGroup) this.f193037a.f193036c).addView(this.f193038b);     // Catch: Throwable -> L4
            this.f193037a.f193034a.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public r(ReusedUISlotAssem r100, int r101, View r102) {
        this.f193034a = r100;
        this.f193035b = r101;
        this.f193036c = r102;
    }

    public final void a() {
        Context r100 = this.f193034a.getContext();
        if (r100 == null) goto L7;
        View r101 = AsyncInflater.inflate((Activity) r100, this.f193035b);
        ReusedUISlotAssem r102 = this.f193034a;
        r102.f192984h = this.f193036c;
        r102.A = r101;
        r102.p(r101);
        ReusedUISlotAssem.x(this.f193034a).post(new a(this, r101));
        return;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
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
