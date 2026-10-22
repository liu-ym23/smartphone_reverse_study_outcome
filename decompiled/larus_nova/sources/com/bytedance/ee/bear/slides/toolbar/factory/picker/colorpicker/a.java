package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import android.view.View;
import com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.model.ColorValueItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<ColorValueItem, Unit> f238656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ColorValueItem f238657b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super ColorValueItem, Unit> r100, ColorValueItem r101) {
        this.f238656a = r100;
        this.f238657b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f238656a.invoke(this.f238657b);
    }
}
