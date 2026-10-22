package com.ss.android.lark.keyboard.edittext2.edittors.inlinecode;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.LineBackgroundSpan;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.InlineCodeInfo;
import com.ss.android.lark.widget.span.p;
import com.ss.android.lark.widget.span.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends CharacterStyle implements LineBackgroundSpan, z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f429073a;

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        if (r100 == null) goto L5;
        r100.setColor(0);
        return;
    }

    public b(Context r100, InlineCodeInfo r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spanInfo");
        this.f429073a = new p(r100, r101);
    }

    @Override // android.text.style.LineBackgroundSpan
    public final void drawBackground(Canvas r110, Paint r111, int r112, int r113, int r114, int r210, int r211, CharSequence r212, int r213, int r214, int r215) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "paint");
        Intrinsics.checkNotNullParameter(r212, "text");
        Spanned r115 = (Spanned) r212;
        int r100 = r115.getSpanStart(this);
        int r101 = r115.getSpanEnd(this);
        int r116 = Math.max(r100, r213);
        if (r116 < Math.min(r101, r214)) goto L5;
        return;
    L5:
        this.f429073a.a(r110, r111, r112, r113, r114, r211, r115, r213, r214, r116);
    }
}
