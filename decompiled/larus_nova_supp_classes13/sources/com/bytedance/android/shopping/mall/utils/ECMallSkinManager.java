package com.bytedance.android.shopping.mall.utils;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.mall.homepage.component.ECFMiddleware;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallSkinManager {
    public final List<Function1<Boolean, Unit>> a;
    public String b;
    public final Lazy c;
    public final Lazy d;
    public final ECFMiddleware e;

    public final MutableLiveData<Boolean> b() {
        return (MutableLiveData) this.c.getValue();
    }

    public final boolean a() {
        if (((Boolean) this.d.getValue()).booleanValue() == true) goto L5;
        this.e.getClass();
    L15:
        return false;
    L5:
        if (Intrinsics.areEqual(this.e.e(), "popup_mall_homepage") == true) goto L15;
        Boolean r0 = (Boolean) b().getValue();
        if (r0 != null) goto L17;
        IHybridHostService r1 = com.bytedance.android.ec.hybrid.a.h();
        if (r1 == null) goto L12;
        r0 = Boolean.valueOf(r1.getStorageTheme(this.e.e()));
        goto L17
    L12:
        r0 = null;
    L17:
        return Intrinsics.areEqual(r0, Boolean.TRUE);
    }

    public ECMallSkinManager(ECFMiddleware r2) {
        Intrinsics.checkNotNullParameter(r2, "middleware");
        this.e = r2;
        this.a = new ArrayList();
        this.c = LazyKt.lazy(ECMallSkinManager$isDarkMode$2.INSTANCE);
        this.d = LazyKt.lazy(ECMallSkinManager$enableSkinCMS$2.INSTANCE);
    }
}
