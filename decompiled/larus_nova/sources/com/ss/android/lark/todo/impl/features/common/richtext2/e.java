package com.ss.android.lark.todo.impl.features.common.richtext2;

import android.graphics.Rect;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import mcc.p;

/* JADX INFO: loaded from: classes38.dex */
public final class e extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hob.f f442463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.widget.span.m f442464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f442465c;

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        d r101 = this.f442465c;
        if (r101 == null) goto L6;
        hob.f r102 = this.f442463a;
        com.ss.android.lark.widget.span.m r103 = this.f442464b;
        p r104 = new p();
        Rect r105 = r103.a(r100);
        int r106 = r105.left;
        r104.f513260f = r106;
        int r107 = r105.top;
        r104.f513261g = r107;
        r104.f513258d = r105.right - r106;
        r104.f513259e = r105.bottom - r107;
        r104.f513262h = r103.b();
        r101.g(r100, r102, r104);
        return;
    }

    public e(hob.f r100, com.ss.android.lark.widget.span.m r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "spanClickCoordinator");
        this.f442463a = r100;
        this.f442464b = r101;
        this.f442465c = r102;
    }
}
