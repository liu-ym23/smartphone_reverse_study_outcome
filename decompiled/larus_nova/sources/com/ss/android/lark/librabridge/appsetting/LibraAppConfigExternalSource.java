package com.ss.android.lark.librabridge.appsetting;

import com.ss.android.lark.log.Log;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class LibraAppConfigExternalSource implements awa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f431164a;

    public static final class a {
    }

    static {
    }

    @Inject
    public LibraAppConfigExternalSource() {
        this.f431164a = LazyKt.lazy(LibraAppConfigExternalSource$libraProxy$2.INSTANCE);
    }

    @Override // awa.a
    public final Object a(String r100, Class r101, Class r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "configClass");
        Intrinsics.checkNotNullParameter(r102, "valueClass");
        zpb.a r103 = (zpb.a) this.f431164a.getValue();
        if (r103 != null) goto L11;
        return null;
    L11:
        return r103.getConfig(r100, r102, true);
    L8:
        th = move-exception;
        Log.e("LibraAppConfigExternalSource", "libra getConfig failed, key=" + r100 + " valueClass=" + r102.getName(), th);
        return null;
    }
}
