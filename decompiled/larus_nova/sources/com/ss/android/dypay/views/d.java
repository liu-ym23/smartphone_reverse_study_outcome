package com.ss.android.dypay.views;

import android.graphics.Bitmap;
import android.widget.ImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
public final class d extends Lambda implements Function1<Bitmap, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f408511a;

    public d(e r100) {
        this.f408511a = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Bitmap r100) {
        Bitmap r101 = r100;
        if (r101 == null) goto L8;
        ImageView r102 = this.f408511a.f408512a.f408518e;
        if (r102 == null) goto L8;
        r102.setImageBitmap(r101);
    L8:
        return Unit.INSTANCE;
    }
}
