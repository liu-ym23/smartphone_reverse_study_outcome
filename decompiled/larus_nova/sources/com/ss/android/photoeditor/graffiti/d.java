package com.ss.android.photoeditor.graffiti;

import android.graphics.Bitmap;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GraffitiView f449243a;

    public d(GraffitiView r100) {
        this.f449243a = r100;
    }

    public final void a(Bitmap r100) {
        this.f449243a.f449204e = r100;
        Log.i("onGraffitiLayerChanged", "object = " + this.f449243a.f449209j);
        this.f449243a.invalidate();
    }
}
