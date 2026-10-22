package com.ss.android.lark.widget.light.touch;

import android.app.Activity;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TouchConsumeView f446305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TouchConsumeView.b f446306b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TouchConsumeView f446307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TouchConsumeView.b f446308b;

        public a(TouchConsumeView r100, TouchConsumeView.b r101) {
            this.f446307a = r100;
            this.f446308b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TouchConsumeView r100 = this.f446307a;     // Catch: Throwable -> L12
            if (r100.f446293f == false) goto L5;
        L10:
            r100.f446292e = false;     // Catch: Throwable -> L12
            r100.f446293f = false;     // Catch: Throwable -> L12
        L17:
            return;
        L5:
            if (r100.f446291d == true) goto L10;
            if (r100.f446292e == false) goto L10;
            int r101 = TouchConsumeView.f446288k;     // Catch: Throwable -> L12
            r100.setTag(R.id.tag_long_press, "tag_long_press");     // Catch: Throwable -> L12
            this.f446308b.a(this.f446307a);     // Catch: Throwable -> L12
            this.f446307a.f446292e = false;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Activity r100 = UIUtils.getActivityFromView(this.f446305a);     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.runOnUiThread(new a(this.f446305a, this.f446306b));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public b(TouchConsumeView r100, com.ss.android.lark.widget.light.touch.a r101) {
        this.f446305a = r100;
        this.f446306b = r101;
    }
}
