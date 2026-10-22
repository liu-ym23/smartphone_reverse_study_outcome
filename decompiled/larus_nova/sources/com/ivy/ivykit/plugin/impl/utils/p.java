package com.ivy.ivykit.plugin.impl.utils;

import android.content.Context;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.lynx.tasm.ui.image.a0;
import com.lynx.tasm.ui.image.b0;
import com.lynx.tasm.ui.image.z;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class p extends com.bytedance.ies.bullet.lynx.init.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f278452a;

    @Override // com.bytedance.ies.bullet.lynx.init.b
    public final com.lynx.tasm.ui.image.c a() {
        if (Fresco.hasBeenInitialized() == true) goto L6;
        Fresco.initialize(this.f278452a);
    L6:
        return new com.lynx.tasm.ui.image.c();
    }

    @Override // com.bytedance.ies.bullet.lynx.init.b
    public final List<com.lynx.tasm.behavior.a> b() {
        if (Fresco.hasBeenInitialized() == true) goto L5;
        Fresco.initialize(this.f278452a);
    L5:
        ArrayList r100 = new ArrayList();
        r100.add(new z());
        r100.add(new a0());
        r100.add(new b0());
        return r100;
    }

    public p(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        this.f278452a = r100;
    }
}
