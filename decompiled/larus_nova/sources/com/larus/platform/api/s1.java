package com.larus.platform.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.larus.platform.model.webview.AbsWebFragment;
import com.larus.search.api.event.HybridEventParams;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public interface s1 {
    void a(AppletAppActivity r100, String r101);

    void b(ts9.a r100);

    AbsWebFragment c();

    void d(View r100, Bundle r101);

    void e(Context r100, Bundle r101, HybridEventParams r102);

    ts9.a f();

    boolean g(Activity r100);

    String h();

    void i(Context r100);

    Object o(String r100, Continuation<? super String> r101);
}
