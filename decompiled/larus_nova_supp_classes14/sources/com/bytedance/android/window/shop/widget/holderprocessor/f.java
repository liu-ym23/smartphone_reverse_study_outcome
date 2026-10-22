package com.bytedance.android.window.shop.widget.holderprocessor;

import android.os.SystemClock;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends gr3.d {
    public Disposable a;
    public WindowLayoutType b;
    public long c;
    public final Function0<WindowLayoutType> d;
    public final Function0<Unit> e;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function0<? extends WindowLayoutType> r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "layoutTypeFetcher");
        Intrinsics.checkNotNullParameter(r3, "changedNotifier");
        this.d = r2;
        this.e = r3;
    }

    @Override // gr3.d
    public final void a(ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r5, com.bytedance.android.window.shop.repository.tab.entity.f r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "vo");
        WindowLayoutType r8 = (WindowLayoutType) this.d.invoke();
        if (this.b == r8) goto L6;
    L7:
        boolean r9 = true;
    L9:
        if (r9 == false) goto L19;
        this.b = (WindowLayoutType) this.d.invoke();
        this.c = SystemClock.elapsedRealtime();
        Disposable r10 = this.a;
        if (r10 != null) goto L13;
    L17:
        this.a = bg4.b.b(Observable.timer(1000, TimeUnit.MILLISECONDS)).subscribe(new g(this), h.a);
        return;
    L13:
        if (r10.isDisposed() == true) goto L17;
        Disposable r11 = this.a;
        if (r11 == null) goto L17;
        r11.dispose();
        goto L17
    L19:
        return;
    L6:
        if ((SystemClock.elapsedRealtime() - this.c) > 1000) goto L7;
        r9 = false;
        goto L9
    }
}
