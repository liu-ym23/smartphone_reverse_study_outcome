package com.bytedance.ies.argus.aspect;

import com.bytedance.ies.argus.api.ArgusLynxDelegate;
import com.bytedance.ies.argus.api.params.t;
import com.bytedance.ies.argus.bean.i;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.JavaOnlyArray;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements LynxModule.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<ArgusLynxDelegate> f245799a;

    public b(ArgusLynxDelegate r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxDelegate");
        this.f245799a = new WeakReference(r100);
    }

    @Override // com.lynx.jsbridge.LynxModule.a
    public final boolean a(String r100, String r101, JavaOnlyArray r102) {
        t r103 = new t(r100, r101, r102);
        ArgusLynxDelegate r104 = this.f245799a.get();
        if (r104 == null) goto L9;
        i r105 = r104.g(r103);
        if (r105 != null) goto L8;
        return false;
    L8:
        return !r105.c();
    L9:
        return false;
    }
}
