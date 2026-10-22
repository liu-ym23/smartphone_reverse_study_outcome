package com.bytedance.nita.api;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Integer> f265994a;

    @Override // com.bytedance.nita.api.c
    public void e(View r100, Activity r101) {
    }

    @Override // com.bytedance.nita.api.c
    public final Object g(int r100) {
        return this;
    }

    @Override // com.bytedance.nita.api.c
    public final int[] b() {
        return CollectionsKt.toIntArray(this.f265994a);
    }

    public d() {
        this.f265994a = new ArrayList();
    }

    @Override // com.bytedance.nita.api.c
    public com.bytedance.nita.view.b c() {
        return com.bytedance.nita.view.a.f266016a;
    }

    @Override // com.bytedance.nita.api.c
    public final TtlType f() {
        return TtlType.ACTIVITY_DESTORY;
    }

    @Override // com.bytedance.nita.api.c
    public final NitaThreadMode threadMode() {
        return NitaThreadMode.SINGLE;
    }

    @Override // com.bytedance.nita.api.c
    public final ViewGroup d(Context r100) {
        return new FrameLayout(r100);
    }
}
