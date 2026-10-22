package com.obric.oui.texteffects.runtime;

import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Float;"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ExternalViewLayerBinding$1 extends Lambda implements Function0<Float> {
    final /* synthetic */ View $view;

    public ExternalViewLayerBinding$1(View r100) {
        this.$view = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Float invoke() {
        Integer r100 = Integer.valueOf(this.$view.getWidth());
        if (r100.intValue() <= 0) goto L5;
        boolean r101 = true;
    L6:
        Float r102 = null;
        if (r101 == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L13;
        r102 = Float.valueOf(r100.intValue());
    L13:
        if (r102 != null) goto L15;
        float r103 = this.$view.getMeasuredWidth();
    L17:
        return Float.valueOf(r103);
    L15:
        r103 = r102.floatValue();
        goto L17
    L5:
        r101 = false;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Float invoke() {
        return invoke();
    }
}
