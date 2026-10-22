package com.bytedance.android.window.shop.home.presenter.plugin;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowInfoAreaBubblePlugin extends ECWindowJsbPlugin {
    public static final /* synthetic */ int f = 0;
    public Disposable b;
    public final LifecycleOwner c;
    public final ECWindowViewModel d;
    public final Function1<Boolean, Unit> e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ECWindowInfoAreaBubblePlugin a;

        public b(ECWindowInfoAreaBubblePlugin r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.e.invoke(Boolean.FALSE);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final List<com.bytedance.android.window.shop.home.tab.tabplugin.c> c() {
        return CollectionsKt.listOf(new com.bytedance.android.window.shop.home.tab.tabplugin.c("ecom.coupon.component_close", new ECWindowInfoAreaBubblePlugin$createJsbActions$1(this)));
    }

    public final void h() {
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b = Observable.timer(5000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), c.a);
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin, com.bytedance.android.window.shop.home.tab.tabplugin.e
    public final void a() {
        super.a();
        this.d.getFloatLayerShowDenied().observe(this.c, new ECWindowInfoAreaBubblePlugin$observeFloatLynxShowDenied$1(this));
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin, com.bytedance.android.window.shop.home.tab.tabplugin.e
    public final void b() {
        super.b();
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECWindowInfoAreaBubblePlugin(LifecycleOwner r2, ECWindowViewModel r3, Function1<? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "viewVisibilitySwitch");
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }
}
