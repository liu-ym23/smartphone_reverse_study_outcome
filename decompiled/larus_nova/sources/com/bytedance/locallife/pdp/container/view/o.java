package com.bytedance.locallife.pdp.container.view;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ww6.d f261336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f261337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f261338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f261339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Rect f261340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q f261341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f261342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f261343h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f261344i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Boolean f261345j;

    public interface a {
        void t(int r100, Rect r101);
    }

    public static final class b {
    }

    public interface c {
        boolean x();
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f261346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f261347b;

        public d(o r100, View r101) {
            this.f261346a = r100;
            this.f261347b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = (String) r100;
            o r102 = this.f261346a;
            View r103 = this.f261347b;
            boolean r104 = false;
            if (r102.f261337b.x() == false) goto L18;
            int r105 = r103.getWidth();
            int r106 = r103.getHeight();
            int r107 = r102.f261342g;
            int r108 = r102.f261343h;
            Rect r109 = new Rect(r107, r108, r105 + r107, r106 + r108);
            if (r109.isEmpty() == false) goto L7;
            r102.f261338c.t(2, r109);
            return;
        L7:
            Rect r110 = r102.f261340e;
            if (r109.left >= r110.left) goto L10;
        L16:
            if (r104 == true) goto L21;
            r102.f261338c.t(1, r109);
            return;
        L21:
            return;
        L10:
            if (r109.top < r110.top) goto L16;
            if (r109.right > r110.right) goto L16;
            if (r109.bottom > r110.bottom) goto L16;
            r104 = true;
            goto L16
        L18:
            r102.f261338c.t(0, null);
        }
    }

    static {
    }

    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (Intrinsics.areEqual(this.f261345j, Boolean.TRUE) == true) goto L6;
        return;
    L6:
        if (this.f261344i == false) goto L11;
        qs6.b r101 = HostServiceUtilsKt.k();
        if (r101 == null) goto L18;
        r101.i("PayFVChecker", "startPayFooterVisibleCheck: already start");
        return;
    L18:
        return;
    L11:
        this.f261344i = true;
        qs6.b r102 = HostServiceUtilsKt.k();
        if (r102 == null) goto L14;
        r102.i("PayFVChecker", "startPayFooterVisibleCheck");
    L14:
        Disposable r103 = Observable.just("").delay(3000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r100));
        if (r103 == null) goto L19;
        this.f261339d.add(r103);
        return;
    }

    public o(ww6.d r100, c r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, "recoverProvider");
        Intrinsics.checkNotNullParameter(r101, "lynxViewStatusFetcher");
        Intrinsics.checkNotNullParameter(r102, "checkResultCallback");
        this.f261336a = r100;
        this.f261337b = r101;
        this.f261338c = r102;
        this.f261339d = new CompositeDisposable();
        this.f261340e = new Rect();
    }
}
