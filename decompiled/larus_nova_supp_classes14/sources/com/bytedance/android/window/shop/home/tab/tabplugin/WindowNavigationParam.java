package com.bytedance.android.window.shop.home.tab.tabplugin;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \n*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0001\u000bR\u0019\u0010\u0003\u001a\u0004\u0018\u00018\u00008\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;", "Ljava/io/Serializable;", "T", "param", "Ljava/io/Serializable;", "getParam", "()Ljava/io/Serializable;", "", "useLast", "Z", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowNavigationParam<T extends Serializable> implements Serializable {
    public static final a Companion = null;
    public static final WindowNavigationParam a = null;
    private final T param;
    private final boolean useLast;

    public static final class a {
        public static WindowNavigationParam b() {
            WindowNavigationParam r0 = WindowNavigationParam.access$getUseLastParam$cp();
            if (r0 == null) goto L6;
            return r0;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.home.tab.tabplugin.WindowNavigationParam<T>");
        }

        public a() {
        }

        public static WindowNavigationParam c(Serializable r3) {
            return new WindowNavigationParam(r3, false, null);
        }

        public static Serializable a(WindowNavigationParam r2, Serializable r3) {
            if (r2 != null) goto L4;
        L6:
            if (r2 != null) goto L10;
            return null;
        L10:
            return r2.getParam();
        L4:
            if (WindowNavigationParam.access$getUseLast$p(r2) != true) goto L6;
            return r3;
        }
    }

    static {
        Companion = new a();
        a = new WindowNavigationParam(null, true);
    }

    public static final /* synthetic */ WindowNavigationParam access$getUseLastParam$cp() {
        return a;
    }

    public final T getParam() {
        return this.param;
    }

    public static final /* synthetic */ boolean access$getUseLast$p(WindowNavigationParam r0) {
        return r0.useLast;
    }

    public WindowNavigationParam(T r1, boolean r2) {
        this.param = r1;
        this.useLast = r2;
    }

    public /* synthetic */ WindowNavigationParam(Serializable r1, boolean r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    public /* synthetic */ WindowNavigationParam(Serializable r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }
}
