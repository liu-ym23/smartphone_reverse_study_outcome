package com.bytedance.nita.api;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsNitaView implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f265990a;

    @Override // com.bytedance.nita.api.c
    public void e(View r100, Activity r101) {
    }

    public AbsNitaView() {
        this.f265990a = LazyKt.lazy(AbsNitaView$lockMap$2.INSTANCE);
    }

    @Override // com.bytedance.nita.api.c
    public String h() {
        return getClass().toString();
    }

    @Override // com.bytedance.nita.api.c
    public com.bytedance.nita.view.b c() {
        return com.bytedance.nita.view.a.f266016a;
    }

    @Override // com.bytedance.nita.api.c
    public final NitaThreadMode threadMode() {
        return NitaThreadMode.SINGLE;
    }

    @Override // com.bytedance.nita.api.c
    public final ViewGroup d(Context r100) {
        return new FrameLayout(r100);
    }

    @Override // com.bytedance.nita.api.c
    public final Object g(int r100) {
        o37.b r101 = o37.a.f521912a;
        if ((o37.a.a() & 32) == 0) goto L6;
        return new Object();
    L6:
        if ((o37.a.a() & 2) == 0) goto L14;
        ConcurrentHashMap r102 = (ConcurrentHashMap) this.f265990a.getValue();
        Integer r103 = Integer.valueOf(r100);
        Object r104 = r102.get(r103);
        if (r104 != null) goto L16;
        r104 = new Object();
        Object r105 = r102.putIfAbsent(r103, r104);
        if (r105 == null) goto L16;
        return r105;
    L16:
        return r104;
    L14:
        return this;
    }
}
