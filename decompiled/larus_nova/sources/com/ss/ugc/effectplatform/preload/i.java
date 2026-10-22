package com.ss.ugc.effectplatform.preload;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.download.j;

/* JADX INFO: loaded from: classes36.dex */
public final class i implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EffectConfig f457469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f457470b;

    @Override // com.ss.ugc.effectplatform.download.j
    public final boolean a(String r100) {
        com.ss.ugc.effectplatform.util.i r101 = com.ss.ugc.effectplatform.util.i.f458038a;
        boolean r102 = false;
        if (com.ss.ugc.effectplatform.util.i.g(r100) == null) goto L21;
        String r103 = com.ss.ugc.effectplatform.util.i.a(this.f457470b);
        if (r103 == null) goto L21;
        String r104 = FileManager.f21782a;     // Catch: Exception -> L18
        FileManager.o(r103);     // Catch: Exception -> L18
        if (this.f457469a.f457170p == false) goto L9;
        boolean r105 = FileManager.r(r100, r103);     // Catch: Exception -> L18
    L10:
        if (r105 == true) goto L12;
    L14:
        FileManager.o(r100);     // Catch: Exception -> L18
        if (r102 == true) goto L17;
        FileManager.o(r103);     // Catch: Exception -> L18
        FileManager.o(this.f457470b);     // Catch: Exception -> L18
    L17:
        return r102;
    L12:
        if (com.ss.ugc.effectplatform.util.i.h(r103, this.f457470b, true) == false) goto L14;
        r102 = true;
        goto L14
    L9:
        r105 = FileManager.q(r100, r103);     // Catch: Exception -> L18
    L18:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "JKL", "[预加载][解压][失败][" + r100 + ']', null, 4, null);
        String r106 = FileManager.f21782a;
        FileManager.o(r103);
        FileManager.o(this.f457470b);
        throw e;
    L21:
        return false;
    }

    public i(EffectConfig r100, String r101) {
        this.f457469a = r100;
        this.f457470b = r101;
    }
}
