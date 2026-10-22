package com.larus.common_ui.floatwindow.view;

import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes27.dex */
public interface v {
    void a(Function0<Unit> r100);

    void b(SingleFloatWindowState r100, boolean r101);

    void c();

    SingleFloatWindowState d();

    void e();

    Rect f(boolean r100);

    void g();

    void h(e19.h r100, SingleFloatWindowState r101, boolean r102);

    void i(AppCompatActivity r100);

    void removeView(View r100);
}
