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
import com.larus.nova.R;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes16.dex */
public class LazyLoadingWrapper implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f220185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f220186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LoadingLayout.c f220187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LoadingLayout.b f220188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LoadingLayout f220189e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f220190f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f220191g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f220192h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewGroup f220193i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f220194j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f220195k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LoadingState f220196l;

    public static final enum LoadingState extends Enum<LoadingState> {
        public static final LoadingState FAIL = null;
        public static final LoadingState INITIALIZED = null;
        public static final LoadingState LOADING = null;
        public static final LoadingState SUC = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoadingState[] f220197a = null;

        static {
            LoadingState r100 = new LoadingState("INITIALIZED", 0);
            INITIALIZED = r100;
            LoadingState r101 = new LoadingState("LOADING", 1);
            LOADING = r101;
            LoadingState r102 = new LoadingState("FAIL", 2);
            FAIL = r102;
            LoadingState r103 = new LoadingState("SUC", 3);
            SUC = r103;
            f220197a = new LoadingState[]{r100, r101, r102, r103};
        }

        public static LoadingState[] values() {
            return (LoadingState[]) f220197a.clone();
        }

        public static LoadingState valueOf(String r100) {
            return (LoadingState) r27.a.a(LoadingState.class, r100);
        }

        public LoadingState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f220198a = null;

        static {
            int[] r100 = new int[LoadingState.values().length];
            f220198a = r100;
            r100[LoadingState.INITIALIZED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f220198a[LoadingState.LOADING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f220198a[LoadingState.SUC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f220198a[LoadingState.FAIL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<LazyLoadingWrapper> f220199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f220200b;

        @Override // java.lang.Runnable
        public final void run() {
            LazyLoadingWrapper r100 = this.f220199a.get();     // Catch: Throwable -> L10
            if (r100 != null) goto L6;
            return;
        L6:
            if (this.f220200b == true) goto L17;
            r100.show();     // Catch: Throwable -> L10
            return;
        L17:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }

        public b(LazyLoadingWrapper r100) {
            this.f220199a = new WeakReference(r100);
        }
    }

    @Override // com.bytedance.ee.bear.document.loading.d
    public final void b() {
        if (c(LoadingState.LOADING) == true) goto L6;
        return;
    L6:
        if (this.f220194j == false) goto L16;
        LayoutInflater r100 = LayoutInflater.from(this.f220185a.getContext());
        if (TextUtils.equals(this.f220195k, sbb.e.f541296g.getType()) == false) goto L11;
        r100.inflate(R.layout.doc_new_create, this.f220193i, true);
    L13:
        this.f220193i.setVisibility(0);
        return;
    L11:
        if (TextUtils.equals(this.f220195k, sbb.e.f541304o.getType()) == false) goto L13;
        r100.inflate(R.layout.docx_new_create, this.f220193i, true);
        goto L13
    L16:
        if (this.f220192h == null) goto L19;
        tt5.a.h("LazyLoadingWrapper", "lazyShow: is already showing");
        return;
    L19:
        this.f220193i.setVisibility(0);
        LoadingLayout r101 = this.f220189e;
        if (r101 == null) goto L22;
        r101.e();
        this.f220189e.hide();
    L22:
        b r102 = new b(this);
        this.f220192h = r102;
        long r103 = DocOpenConfig.f218554h;
        this.f220186b.removeCallbacks(r102);
        this.f220186b.postDelayed(this.f220192h, r103);
    }

    public final LoadingLayout d() {
        View r100 = this.f220185a.findViewById(R.id.loading);
        if ((r100 instanceof ViewStub) == false) goto L5;
        this.f220189e = (LoadingLayout) ((ViewStub) r100).inflate();
    L6:
        LoadingLayout r101 = this.f220189e;
        if (r101 == null) goto L19;
        LoadingLayout.c r102 = this.f220187c;
        if (r102 == null) goto L11;
        r101.setOnRetryListener(r102);
    L11:
        LoadingLayout.b r103 = this.f220188d;
        if (r103 == null) goto L14;
        this.f220189e.setOnBackSourceDocListener(r103);
    L14:
        Integer r104 = this.f220190f;
        if (r104 == null) goto L18;
        this.f220189e.a(r104.intValue(), this.f220191g);
        this.f220190f = null;
    L18:
        return this.f220189e;
    L19:
        return null;
    L5:
        this.f220189e = (LoadingLayout) r100;
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public void hide() {
        if (c(LoadingState.SUC) == true) goto L5;
        return;
    L5:
        this.f220193i.setVisibility(8);
        b r100 = this.f220192h;
        if (r100 == null) goto L8;
        this.f220186b.removeCallbacks(r100);
        this.f220192h.f220200b = true;
        this.f220192h = null;
    L8:
        LoadingLayout r101 = this.f220189e;
        if (r101 == null) goto L12;
        r101.hide();
        return;
    }

    @Override // com.bytedance.ee.bear.document.loading.d
    public final void reset() {
        if (c(LoadingState.INITIALIZED) == true) goto L5;
        return;
    L5:
        b r100 = this.f220192h;
        if (r100 == null) goto L8;
        this.f220186b.removeCallbacks(r100);
        this.f220192h.f220200b = true;
        this.f220192h = null;
    L8:
        this.f220187c = null;
        LoadingLayout r101 = this.f220189e;
        if (r101 == null) goto L12;
        r101.setOnRetryListener(null);
        this.f220189e.setOnBackSourceDocListener(null);
        return;
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public void show() {
        this.f220193i.setVisibility(8);
        b r100 = this.f220192h;
        if (r100 == null) goto L5;
        this.f220186b.removeCallbacks(r100);
        this.f220192h.f220200b = true;
        this.f220192h = null;
    L5:
        LoadingLayout r101 = d();
        if (r101 == null) goto L9;
        r101.setVisibility(0);
        return;
    }

    public final boolean c(LoadingState r100) {
        LoadingState r101 = this.f220196l;
        int r102 = a.f220198a[r101.ordinal()];
        boolean r103 = true;
        if (r102 == 1) goto L22;
        if (r102 == 2) goto L22;
        if (r102 == 3) goto L17;
        if (r102 == 4) goto L12;
    L24:
        r103 = false;
    L26:
        if (r103 == true) goto L28;
        tt5.a.h("LazyLoadingWrapper", "error while transfer from " + r101.name() + " to " + r100.name());
    L29:
        return r103;
    L28:
        this.f220196l = r100;
        tt5.a.h("LazyLoadingWrapper", "change from " + r101.name() + " to " + this.f220196l.name());
        goto L29
    L12:
        if (r100 == LoadingState.INITIALIZED) goto L26;
        if (r100 != LoadingState.LOADING) goto L24;
    L17:
        if (r100 == LoadingState.FAIL) goto L26;
        if (r100 != LoadingState.INITIALIZED) goto L24;
    L22:
        if (this.f220196l.ordinal() > r100.ordinal()) goto L24;
        goto L24
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public final void setOnBackSourceDocListener(LoadingLayout.b r100) {
        LoadingLayout r101 = this.f220189e;
        if (r101 == null) goto L5;
        r101.setOnBackSourceDocListener(r100);
        return;
    L5:
        this.f220188d = r100;
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public final void setOnRetryListener(LoadingLayout.c r100) {
        LoadingLayout r101 = this.f220189e;
        if (r101 == null) goto L5;
        r101.setOnRetryListener(r100);
        return;
    L5:
        this.f220187c = r100;
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public final void a(int r100, String r101) {
        if (c(LoadingState.FAIL) == true) goto L5;
        return;
    L5:
        LoadingLayout r102 = this.f220189e;
        if (r102 == null) goto L8;
        r102.a(r100, r101);
        return;
    L8:
        this.f220190f = Integer.valueOf(r100);
        this.f220191g = r101;
    }

    public LazyLoadingWrapper(View r100, boolean r101, String r102) {
        LoadingState r103 = LoadingState.INITIALIZED;
        this.f220196l = r103;
        this.f220186b = new Handler(Looper.getMainLooper());
        this.f220185a = r100;
        this.f220195k = r102;
        this.f220194j = r101;
        this.f220193i = (ViewGroup) r100.findViewById(R.id.doc_webview_cover);
        View r104 = r100.findViewById(R.id.loading);
        if ((r104 instanceof ViewStub) == true) goto L5;
        this.f220189e = (LoadingLayout) r104;
    L5:
        this.f220196l = r103;
    }
}
