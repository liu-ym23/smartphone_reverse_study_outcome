package com.bytedance.badger.z;

import com.bytedance.badger.module.BadgerModuleBase;
import java.util.Map;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class x0 {
    static {
    }

    public static void a(int r100, BadgerModuleBase r101) {
        Lazy r102 = w0.f199493b;
        KProperty r103 = w0.f199492a[0];
        if (((Map) r102.getValue()).containsKey(Integer.valueOf(r100)) == true) goto L8;
        if (r101 == null) goto L9;
        q r104 = new q(r100);
        com.bytedance.badger.t.c r105 = new com.bytedance.badger.t.c(901594402);
        r104.invoke(r105);
        r105.a(r101);
        return;
    L9:
        return;
    L8:
        throw new IllegalArgumentException("registerExternalProvider: " + r100 + " is already occupied");
    }
}
