package com.ss.android.lark.watermark.userscope;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import androidx.lifecycle.LifecycleOwner;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.watermark.core.IAttachResultCallback;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class UiThreadExecutionWatermarkImplV3 implements com.ss.android.lark.watermark.v2.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WatermarkImplV3 f445332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f445333b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UiThreadExecutionWatermarkImplV3 f445334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f445335b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Boolean f445336c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ IAttachResultCallback f445337d;

        public a(UiThreadExecutionWatermarkImplV3 r100, Activity r101, Boolean r102, IAttachResultCallback r103) {
            this.f445334a = r100;
            this.f445335b = r101;
            this.f445336c = r102;
            this.f445337d = r103;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            WatermarkImplV3 r100 = this.f445334a.f445332a;     // Catch: Throwable -> L10
            Activity r101 = this.f445335b;     // Catch: Throwable -> L10
            Boolean r102 = this.f445336c;     // Catch: Throwable -> L10
            r100.getClass();     // Catch: Throwable -> L10
            Intrinsics.checkNotNullParameter(r101, "activity");     // Catch: Throwable -> L10
            if ((r101 instanceof LifecycleOwner) == false) goto L5;
            LifecycleOwner r103 = (LifecycleOwner) r101;     // Catch: Throwable -> L10
        L6:
            Intrinsics.checkNotNullParameter(r101, "activity");     // Catch: Throwable -> L10
            if (r103 == null) goto L13;
            r101.runOnUiThread(new m(r102, r100, r101, r103));     // Catch: Throwable -> L10
            return;
        L13:
            return;
        L5:
            r103 = null;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UiThreadExecutionWatermarkImplV3 f445338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Dialog f445339b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Boolean f445340c;

        public b(UiThreadExecutionWatermarkImplV3 r100, Dialog r101, Boolean r102) {
            this.f445338a = r100;
            this.f445339b = r101;
            this.f445340c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f445338a.f445332a.a(this.f445339b, this.f445340c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UiThreadExecutionWatermarkImplV3 f445341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Dialog f445342b;

        public c(UiThreadExecutionWatermarkImplV3 r100, Dialog r101) {
            this.f445341a = r100;
            this.f445342b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f445341a.f445332a.b(this.f445342b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.ss.android.lark.watermark.v2.o
    public final int s() {
        return this.f445332a.s();
    }

    public final Handler d() {
        return (Handler) this.f445333b.getValue();
    }

    @Inject
    public UiThreadExecutionWatermarkImplV3(WatermarkImplV3 r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f445332a = r100;
        this.f445333b = LazyKt.lazy(UiThreadExecutionWatermarkImplV3$mainThreadHandler$2.INSTANCE);
    }

    @Override // com.ss.android.lark.watermark.v2.o
    public final void b(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        j.a(d(), new c(this, r100));
    }

    @Override // com.ss.android.lark.watermark.v2.o
    public final void a(Dialog r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        j.a(d(), new b(this, r100, r101));
    }

    public final void c(Activity r100, Boolean r101, IAttachResultCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        j.a(d(), new a(this, r100, r101, r102));
    }
}
