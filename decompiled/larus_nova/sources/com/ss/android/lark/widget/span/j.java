package com.ss.android.lark.widget.span;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import android.text.style.ReplacementSpan;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class j extends ReplacementSpan implements com.ss.android.lark.widget.light.span.j, LineHeightSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f448692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f448693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f448694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f448695d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.widget.light.span.j
    public final com.ss.android.lark.widget.light.span.j.a c() {
        return null;
    }

    public j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f448692a = UIUtils.dp2px(r100, 1.0f);
        this.f448693b = UIUtils.dp2px(r100, 18.0f);
        this.f448694c = UIUtils.getColor(r100, R.color.line_divider_default);
        this.f448695d = 1;
    }

    @Override // com.ss.android.lark.widget.light.span.j
    public final boolean d(int r100, int r101) {
        if (r100 > 0) goto L5;
        return false;
    L5:
        this.f448695d = r100;
        return false;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Log.d("HRSpan", "getWidth " + this.f448695d);
        return this.f448695d;
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
        if (r105 == null) goto L5;
        int r106 = this.f448693b / 2;
        int r107 = -r106;
        r105.top = r107;
        r105.ascent = r107;
        r105.descent = r106;
        r105.bottom = r106;
        return;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r116, int r117, Paint r118) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r118, "paint");
        int r100 = r118.getColor();
        r118.setColor(this.f448694c);
        int r101 = r117 - r115;
        int r102 = this.f448692a;
        if (r101 <= r102) goto L5;
        float r103 = r115;
        float r104 = r101 / 2.0f;
        float r105 = (r104 - (r102 / 2.0f)) + r103;
        float r106 = this.f448695d + r114;
        float r107 = (r103 + r104) + (r102 / 2.0f);
        float r108 = r105;
    L6:
        r110.drawRect(r114, r108, r106, r107, r118);
        r118.setColor(r100);
        return;
    L5:
        r107 = r117;
        r106 = this.f448695d + r114;
        r108 = r115;
        goto L6
    }
}
