package com.bytedance.ee.bear.contract.drive.sdk.entity.menu;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.browser.plugin.t;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public final CompositeDisposable a;
    public final FragmentActivity b;
    public final f<?> c;
    public final t d;
    public Observer<com.bytedance.ee.bear.contract.drive.sdk.entity.menu.a> e;
    public Observer<String> f;

    public static final class a {
        public final FragmentActivity a;
        public final f<?> b;
        public final t c;
        public CompositeDisposable d;

        public final FragmentActivity getActivity() {
            return this.a;
        }

        public a(FragmentActivity r2, f<?> r3, t r4) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "plugin");
            Intrinsics.checkNotNullParameter(r4, "uiContainer");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = new CompositeDisposable();
        }
    }

    public final boolean a() {
        return this.c.getHost().isDestroyed();
    }

    public final FragmentActivity getActivity() {
        return this.b;
    }

    public b(a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        this.a = r2.d;
        this.b = r2.getActivity();
        this.c = r2.b;
        this.d = r2.c;
    }
}
