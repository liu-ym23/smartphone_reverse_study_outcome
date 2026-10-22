package com.larus.voicecall.impl.utils;

import android.graphics.Bitmap;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes32.dex */
public final class h implements Function1<Bitmap, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Bitmap> f379543a;

    public h(kotlinx.coroutines.j r100) {
        this.f379543a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Bitmap r100) {
        Bitmap r101 = r100;
        if (r101 != null) goto L5;
        FLogger.f375446a.e("getBitmapFromUrl", "return null bitmap");
        if (this.f379543a.isActive() == false) goto L11;
        this.f379543a.resumeWith(Result.m9449constructorimpl(null));
    L11:
        return Unit.INSTANCE;
    L5:
        if (this.f379543a.isActive() == false) goto L11;
        this.f379543a.resumeWith(Result.m9449constructorimpl(r101));
        goto L11
    }
}
