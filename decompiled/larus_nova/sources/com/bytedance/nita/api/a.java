package com.bytedance.nita.api;

import android.app.Activity;
import android.view.View;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends AbsNitaView {
    public a() {
    }

    @Override // com.bytedance.nita.api.c
    public final TtlType f() {
        return TtlType.INFINITE;
    }

    public final View i(int r100, Activity r101, boolean r102) {
        ConcurrentHashMap<String, c> r103 = com.bytedance.nita.view.d.f266017a;
        return (View) com.bytedance.nita.view.d.a(h(), r100, r101, r102);
    }
}
