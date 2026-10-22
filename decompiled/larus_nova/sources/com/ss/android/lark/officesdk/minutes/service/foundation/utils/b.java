package com.ss.android.lark.officesdk.minutes.service.foundation.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.ToastType;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import qub.h;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile MmRecordingUILaunchMode f434029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile h f434030b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmRecordingUILaunchMode f434031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ rub.e f434032b;

        public a(MmRecordingUILaunchMode r100, rub.e r101) {
            this.f434031a = r100;
            this.f434032b = r101;
        }

        public final void a() {
            if (this.f434031a.shouldHandleUI() == false) goto L7;
            h r100 = b.f434030b;
            if (r100 == null) goto L9;
            r100.u(UIHelper.getContext(), this.f434032b);
            return;
        L9:
            return;
        L7:
            lvb.a.b("MmRecordToast", "[showInternal] skip toast, uiLaunchMode=" + this.f434031a + ", type=" + this.f434032b.getType());
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

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.foundation.utils.b$b, reason: collision with other inner class name */
    public static final class RunnableC5163b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f434033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ rub.e f434034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ rub.e f434035c;

        public RunnableC5163b(h r100, rub.e r101, rub.e r102) {
            this.f434033a = r100;
            this.f434034b = r101;
            this.f434035c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h r100 = this.f434033a;     // Catch: Throwable -> L7
            if (r100 == null) goto L5;
            r100.u(UIHelper.getContext(), this.f434034b);     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            MmRecordingUILaunchMode r101 = b.f434029a;     // Catch: Throwable -> L7
            b.c(this.f434035c);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }
    }

    static {
        f434029a = MmRecordingUILaunchMode.UNKNOWN;
    }

    public static void a(int r100) {
        String r101 = UIHelper.getString(r100);
        Intrinsics.checkNotNullParameter(r101, "toastMsg");
        c(new rub.e(r101, ToastType.ERROR, null, 26));
    }

    public static void c(rub.e r100) {
        if (StringsKt.isBlank(r100.f539329a) == false) goto L5;
        return;
    L5:
        MmRecordingUILaunchMode r101 = f434029a;
        d.a(new a(r101, rub.e.a(r100, r101)));
    }

    public static void d(int r100) {
        e(UIHelper.getString(r100));
    }

    public static void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "toastMsg");
        c(new rub.e(r100, ToastType.NORMAL, null, 26));
    }

    public static void f(int r100) {
        g(UIHelper.getString(r100));
    }

    public static void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "toastMsg");
        c(new rub.e(r100, ToastType.WARNING, null, 26));
    }

    public static void b(h r100, rub.e r101) {
        if (StringsKt.isBlank(r101.f539329a) == false) goto L6;
        lvb.a.b("MmRecordToast", "[showInternal] skip toast, content is blank");
        return;
    L6:
        d.a(new RunnableC5163b(r100, rub.e.a(r101, f434029a), r101));
    }
}
