package com.bytedance.android.shopping.card_list.components;

import android.view.View;
import com.bytedance.android.shopping.card_list.components.c;
import com.bytedance.android.shopping.card_list.components.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class SimpleScene<VIEW_TYPE extends View, STATE extends c, ACTION extends q> {
    public VIEW_TYPE a;
    public STATE b;
    public ACTION c;
    public Function0<Unit> d;
    public final Function0<Unit> e;
    public final Function0<Unit> f;
    public final Function0<Unit> g;
    public final Function0<Unit> h;
    public final Function0<Unit> i;

    public SimpleScene() {
        this.d = SimpleScene$onCreate$1.INSTANCE;
        this.e = SimpleScene$onStart$1.INSTANCE;
        this.f = SimpleScene$onResume$1.INSTANCE;
        this.g = SimpleScene$onPause$1.INSTANCE;
        this.h = SimpleScene$onStop$1.INSTANCE;
        this.i = SimpleScene$onDestroy$1.INSTANCE;
    }
}
