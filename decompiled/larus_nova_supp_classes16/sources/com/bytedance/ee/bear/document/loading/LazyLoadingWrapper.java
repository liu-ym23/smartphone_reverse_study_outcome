package com.bytedance.ee.bear.document.loading;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class LazyLoadingWrapper implements d {
    public final View a;
    public final Handler b;
    public LoadingLayout.c c;
    public LoadingLayout.b d;
    public LoadingLayout e;
    public Integer f;
    public String g;
    public b h;
    public final ViewGroup i;
    public final boolean j;
    public final String k;
    public LoadingState l;

    public static final enum LoadingState extends Enum<LoadingState> {
        public static final LoadingState FAIL = null;
        public static final LoadingState INITIALIZED = null;
        public static final LoadingState LOADING = null;
        public static final LoadingState SUC = null;
        public static final /* synthetic */ LoadingState[] a = null;

        static {
            LoadingState r0 = new LoadingState("INITIALIZED", 0);
            INITIALIZED = r0;
            LoadingState r1 = new LoadingState("LOADING", 1);
            LOADING = r1;
            LoadingState r3 = new LoadingState("FAIL", 2);
            FAIL = r3;
            LoadingState r5 = new LoadingState("SUC", 3);
            SUC = r5;
            a = new LoadingState[]{r0, r1, r3, r5};
        }

        public static LoadingState[] values() {
            return (LoadingState[]) a.clone();
        }

        public static LoadingState valueOf(String r1) {
            return (LoadingState) r27.a.a(LoadingState.class, r1);
        }

        public LoadingState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LoadingState.values().length];
            a = r0;
            r0[LoadingState.INITIALIZED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            a[LoadingState.LOADING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            a[LoadingState.SUC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            a[LoadingState.FAIL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public class b implements Runnable {
        public final WeakReference<LazyLoadingWrapper> a;
        public volatile boolean b;

        @Override // java.lang.Runnable
        public final void run() {
            LazyLoadingWrapper r0 = this.a.get();     // Catch: Throwable -> L10
            if (r0 != null) goto L6;
            return;
        L6:
            if (this.b == true) goto L17;
            r0.show();     // Catch: Throwable -> L10
            return;
        L17:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }

        public b(LazyLoadingWrapper r2) {
            this.a = new WeakReference(r2);
        }
    }

    @Override // com.bytedance.ee.bear.document.loading.d
    public final void b() {
        if (c(LoadingState.LOADING) == true) goto L6;
        return;
    L6:
        if (this.j == false) goto L16;
        LayoutInflater r0 = LayoutInflater.from(this.a.getContext());
        if (TextUtils.equals(this.k, sbb.e.g.getType()) == false) goto L11;
        r0.inflate(2131560092, this.i, true);
    L13:
        this.i.setVisibility(0);
        return;
    L11:
        if (TextUtils.equals(this.k, sbb.e.o.getType()) == false) goto L13;
        r0.inflate(2131560132, this.i, true);
        goto L13
    L16:
        if (this.h == null) goto L19;
        tt5.a.h("LazyLoadingWrapper", "lazyShow: is already showing");
        return;
    L19:
        this.i.setVisibility(0);
        LoadingLayout r1 = this.e;
        if (r1 == null) goto L22;
        r1.e();
        this.e.hide();
    L22:
        b r2 = new b(this);
        this.h = r2;
        long r3 = DocOpenConfig.h;
        this.b.removeCallbacks(r2);
        this.b.postDelayed(this.h, r3);
    }

    public final LoadingLayout d() {
        View r0 = this.a.findViewById(2131378977);
        if ((r0 instanceof ViewStub) == false) goto L5;
        this.e = (LoadingLayout) ((ViewStub) r0).inflate();
    L6:
        LoadingLayout r1 = this.e;
        if (r1 == null) goto L19;
        LoadingLayout.c r2 = this.c;
        if (r2 == null) goto L11;
        r1.setOnRetryListener(r2);
    L11:
        LoadingLayout.b r3 = this.d;
        if (r3 == null) goto L14;
        this.e.setOnBackSourceDocListener(r3);
    L14:
        Integer r4 = this.f;
        if (r4 == null) goto L18;
        this.e.a(r4.intValue(), this.g);
        this.f = null;
    L18:
        return this.e;
    L19:
        return null;
    L5:
        this.e = (LoadingLayout) r0;
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public void hide() {
        if (c(LoadingState.SUC) == true) goto L5;
        return;
    L5:
        this.i.setVisibility(8);
        b r0 = this.h;
        if (r0 == null) goto L8;
        this.b.removeCallbacks(r0);
        this.h.b = true;
        this.h = null;
    L8:
        LoadingLayout r1 = this.e;
        if (r1 == null) goto L12;
        r1.hide();
        return;
    }

    @Override // com.bytedance.ee.bear.document.loading.d
    public final void reset() {
        if (c(LoadingState.INITIALIZED) == true) goto L5;
        return;
    L5:
        b r0 = this.h;
        if (r0 == null) goto L8;
        this.b.removeCallbacks(r0);
        this.h.b = true;
        this.h = null;
    L8:
        this.c = null;
        LoadingLayout r1 = this.e;
        if (r1 == null) goto L12;
        r1.setOnRetryListener(null);
        this.e.setOnBackSourceDocListener(null);
        return;
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public void show() {
        this.i.setVisibility(8);
        b r0 = this.h;
        if (r0 == null) goto L5;
        this.b.removeCallbacks(r0);
        this.h.b = true;
        this.h = null;
    L5:
        LoadingLayout r1 = d();
        if (r1 == null) goto L9;
        r1.setVisibility(0);
        return;
    }

    public final boolean c(LoadingState r7) {
        LoadingState r0 = this.l;
        int r1 = a.a[r0.ordinal()];
        boolean r2 = true;
        if (r1 == 1) goto L22;
        if (r1 == 2) goto L22;
        if (r1 == 3) goto L17;
        if (r1 == 4) goto L12;
    L24:
        r2 = false;
    L26:
        if (r2 == true) goto L28;
        tt5.a.h("LazyLoadingWrapper", "error while transfer from " + r0.name() + " to " + r7.name());
    L29:
        return r2;
    L28:
        this.l = r7;
        tt5.a.h("LazyLoadingWrapper", "change from " + r0.name() + " to " + this.l.name());
        goto L29
    L12:
        if (r7 == LoadingState.INITIALIZED) goto L26;
        if (r7 != LoadingState.LOADING) goto L24;
    L17:
        if (r7 == LoadingState.FAIL) goto L26;
        if (r7 != LoadingState.INITIALIZED) goto L24;
    L22:
        if (this.l.ordinal() > r7.ordinal()) goto L24;
        goto L24
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public final void setOnBackSourceDocListener(LoadingLayout.b r2) {
        LoadingLayout r0 = this.e;
        if (r0 == null) goto L5;
        r0.setOnBackSourceDocListener(r2);
        return;
    L5:
        this.d = r2;
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public final void setOnRetryListener(LoadingLayout.c r2) {
        LoadingLayout r0 = this.e;
        if (r0 == null) goto L5;
        r0.setOnRetryListener(r2);
        return;
    L5:
        this.c = r2;
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public final void a(int r2, String r3) {
        if (c(LoadingState.FAIL) == true) goto L5;
        return;
    L5:
        LoadingLayout r0 = this.e;
        if (r0 == null) goto L8;
        r0.a(r2, r3);
        return;
    L8:
        this.f = Integer.valueOf(r2);
        this.g = r3;
    }

    public LazyLoadingWrapper(View r4, boolean r5, String r6) {
        LoadingState r0 = LoadingState.INITIALIZED;
        this.l = r0;
        this.b = new Handler(Looper.getMainLooper());
        this.a = r4;
        this.k = r6;
        this.j = r5;
        this.i = (ViewGroup) r4.findViewById(2131369384);
        View r7 = r4.findViewById(2131378977);
        if ((r7 instanceof ViewStub) == true) goto L5;
        this.e = (LoadingLayout) r7;
    L5:
        this.l = r0;
    }
}
