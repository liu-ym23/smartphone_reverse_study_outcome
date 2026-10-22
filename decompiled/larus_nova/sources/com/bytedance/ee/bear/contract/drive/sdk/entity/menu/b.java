package com.bytedance.ee.bear.contract.drive.sdk.entity.menu;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.browser.plugin.t;
import com.monitor.cloudmessage.consts.CloudControlInf;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f217024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FragmentActivity f217025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f<?> f217026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f217027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Observer<com.bytedance.ee.bear.contract.drive.sdk.entity.menu.a> f217028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Observer<String> f217029f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FragmentActivity f217030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f<?> f217031b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final t f217032c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CompositeDisposable f217033d;

        public final FragmentActivity getActivity() {
            return this.f217030a;
        }

        public a(FragmentActivity r100, f<?> r101, t r102) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, CloudControlInf.PLUGIN);
            Intrinsics.checkNotNullParameter(r102, "uiContainer");
            this.f217030a = r100;
            this.f217031b = r101;
            this.f217032c = r102;
            this.f217033d = new CompositeDisposable();
        }
    }

    public final boolean a() {
        return this.f217026c.getHost().isDestroyed();
    }

    public final FragmentActivity getActivity() {
        return this.f217025b;
    }

    public b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f217024a = r100.f217033d;
        this.f217025b = r100.getActivity();
        this.f217026c = r100.f217031b;
        this.f217027d = r100.f217032c;
    }
}
