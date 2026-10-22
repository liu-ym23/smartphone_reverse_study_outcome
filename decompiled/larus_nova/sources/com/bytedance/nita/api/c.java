package com.bytedance.nita.api;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes3.dex */
public interface c {
    NitaSchdulerType a();

    int[] b();

    com.bytedance.nita.view.b c();

    ViewGroup d(Context r100);

    void e(View r100, Activity r101);

    TtlType f();

    Object g(int r100);

    String h();

    int theme();

    NitaThreadMode threadMode();
}
