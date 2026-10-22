package com.relax;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes34.dex */
public class RelaxEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f404542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RelaxJNI f404543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BackendWorker f404544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f404545d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f404546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f404547b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f404548c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f404549d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f404550e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f404551f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f404552g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f404553h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f404554i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f404555j;

        public a() {
            this.f404546a = 0;
            this.f404547b = 0;
            this.f404548c = 1.0f;
            this.f404549d = 0;
            this.f404550e = 1.0f;
            this.f404551f = 0;
            this.f404552g = 0;
            this.f404553h = 0;
            this.f404554i = 0;
            this.f404555j = 0;
        }
    }

    public final synchronized void a() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f404544c.b() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.f404543b == null) goto L10;
        this.f404544c.a();     // Catch: Throwable -> L12
        this.f404543b = null;     // Catch: Throwable -> L12
        this.f404544c = null;     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
    }

    public final void b(boolean r100) {
        Context r101 = this.f404542a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        Resources r102 = r101.getResources();
        DisplayMetrics r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics());
        a r104 = this.f404545d;
        r104.f404546a = r103.widthPixels;
        r104.f404547b = r103.heightPixels;
        r104.f404550e = r103.density;
        r104.f404551f = r103.densityDpi;
        r104.f404549d = r102.getConfiguration().uiMode;
    L7:
        this.f404543b.updateViewport(this.f404545d);
    }

    public final synchronized void c(RelaxView.n r100) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f404544c.b() == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        RelaxJNI r101 = this.f404543b;     // Catch: Throwable -> L12
        if (r101 == null) goto L10;
        r101.setRequestFrame(r100);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
    }

    public RelaxEngine(Context r100, RuntimeType r101, float r102) {
        this.f404542a = null;
        this.f404543b = null;
        this.f404544c = null;
        this.f404545d = null;
        this.f404542a = r100;
        RelaxJNI r103 = new RelaxJNI(r101);
        this.f404543b = r103;
        this.f404544c = new BackendWorker(r103.getBackendWorkerJNI(), r101);
        a r104 = new a();
        this.f404545d = r104;
        r104.f404548c = r102;
        b(true);
    }
}
