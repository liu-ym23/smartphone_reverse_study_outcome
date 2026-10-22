package com.ss.android.lark.officesdk.minutes.ui.record.recording.summary;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f436596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f436597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f436598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f436599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f436600e;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f436601a;

        public b(c r100) {
            this.f436601a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f436601a.f436599d = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public c(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onManualScroll");
        this.f436596a = r100;
        this.f436597b = new Handler(Looper.getMainLooper());
        this.f436600e = new b(this);
    }

    public final void a(int r100, int r101) {
        if (r100 != r101) goto L5;
        return;
    L5:
        if (this.f436598c <= 0) goto L8;
        return;
    L8:
        if (this.f436599d == true) goto L10;
        this.f436599d = true;
        this.f436596a.invoke();
    L10:
        this.f436597b.removeCallbacks(this.f436600e);
        this.f436597b.postDelayed(this.f436600e, 200);
    }
}
