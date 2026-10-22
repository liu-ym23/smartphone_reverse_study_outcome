package com.ss.android.dypay.views;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
public final class c extends Lambda implements Function1<Drawable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f408509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f408510b;

    public c(f r100, Function0 r101) {
        this.f408509a = r100;
        this.f408510b = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Drawable r100) {
        Drawable r101 = r100;
        if (r101 != null) goto L5;
    L10:
        this.f408510b.invoke();
    L12:
        return Unit.INSTANCE;
    L5:
        if ((r101 instanceof AnimatedImageDrawable) == false) goto L10;
        ImageView r102 = this.f408509a.f408518e;
        if (r102 == null) goto L9;
        r102.setImageDrawable(r101);
    L9:
        ((AnimatedImageDrawable) r101).start();
        goto L12
    }
}
