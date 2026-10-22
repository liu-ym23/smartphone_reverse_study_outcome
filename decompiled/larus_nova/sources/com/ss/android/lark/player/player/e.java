package com.ss.android.lark.player.player;

import com.ss.ttvideoengine.TTVideoEngine;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference<TTVideoEngine> f438670a;

    public e(WeakReference<TTVideoEngine> r100) {
        this.f438670a = r100;
    }

    @Override // com.ss.android.lark.player.player.q
    public final void a(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "headers");
        TTVideoEngine r101 = this.f438670a.get();
        if (r101 == null) goto L8;
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, String> r103 = r102.next();
        r101.setCustomHeader(r103.getKey(), r103.getValue());
        goto L6
    L10:
        return;
    }
}
