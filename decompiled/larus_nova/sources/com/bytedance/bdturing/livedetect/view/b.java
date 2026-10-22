package com.bytedance.bdturing.livedetect.view;

import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.livedetect.TuringLiveDetectActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import vb4.s;
import vb4.t;
import vb4.u;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f201988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Exception f201989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LiveDetectView f201990c;

    public final void a() {
        if (this.f201990c.f201969d.get() == 3) goto L12;
        LiveDetectView.c r100 = this.f201990c.f201971f;
        int r101 = this.f201988a;
        String r102 = this.f201989b.getMessage();
        s r103 = (s) r100;
        if (40001 != r101) goto L10;
        TuringLiveDetectActivity r104 = r103.f554046a;
        int r105 = r104.f201846u;
        if (r105 >= 2) goto L9;
        int r106 = r105 + 1;
        r104.f201846u = r106;
        r104.f201830e.postDelayed(new t(r104), ((long) r106) * 500);
        goto L10
    L9:
        r104.M1(new u(r104));
    L10:
        EventReport.p(r101, r102, r103.f554046a.f201847v);
        return;
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

    public b(LiveDetectView r100, int r101, Exception r102) {
        this.f201990c = r100;
        this.f201988a = r101;
        this.f201989b = r102;
    }
}
