package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import android.view.View;
import com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.model.ColorValueItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ Function1<ColorValueItem, Unit> a;
    public final /* synthetic */ ColorValueItem b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super ColorValueItem, Unit> r1, ColorValueItem r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.invoke(this.b);
    }
}
