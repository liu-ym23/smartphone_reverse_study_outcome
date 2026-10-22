package com.ss.android.lark.reaction.widget.flowlayout.reaction;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class d extends ClearCacheDynamicDrawableSpan {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f439441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f439442d;

    public void c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public d(int r100) {
        super(r100);
    }

    @Override // com.ss.android.lark.reaction.widget.flowlayout.reaction.ClearCacheDynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r110, Paint r111) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r111, "paint");
        r100.save();
        r100.translate(this.f439441c, this.f439442d);
        super.draw(r100, r101, r102, r103, r104, r105, r106, r110, r111);
        r100.restore();
    }
}
