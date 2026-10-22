package com.ss.android.lark.flow.passport.ui.widget.common;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class CodeView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f423802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f423803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f423804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f423805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f423806e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f423807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f423808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f423809c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f423810d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f423811e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f423812f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f423813g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f423814h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f423815i;

        public a(Context r100) {
            this.f423807a = true;
            this.f423810d = 17;
            this.f423815i = 18;
            this.f423811e = UDColorUtils.getColor(r100, R.color.text_title);
            this.f423812f = UDColorUtils.getColor(r100, R.color.line_border_card);
            this.f423813g = UDColorUtils.getColor(r100, R.color.primary_fill_default);
            this.f423814h = UDColorUtils.getColor(r100, R.color.function_danger_fill_default);
            this.f423809c = UDColorUtils.getColor(r100, R.color.primary_fill_default);
        }
    }

    public final void b() {
        h r100 = this.f423806e;
        r100.getClass();
        g.c r101 = g.f423843a;
        Intrinsics.checkNotNullParameter(r101, "state");
        r100.c(r101);
        View r102 = this.f423803b;
        if (r102 == null) goto L6;
        r102.setVisibility(8);
        setCursorFlicker(false);
        return;
    }

    public final void c() {
        TextView r100 = this.f423802a;
        if (r100 == null) goto L5;
        r100.setText("");
    L5:
        h r101 = this.f423806e;
        r101.getClass();
        g.c r102 = g.f423843a;
        Intrinsics.checkNotNullParameter(r102, "state");
        r101.c(r102);
        View r103 = this.f423803b;
        if (r103 == null) goto L9;
        r103.setVisibility(8);
        setCursorFlicker(false);
        return;
    }

    public final void d() {
        View r100 = this.f423803b;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
        setCursorFlicker(false);
        return;
    }

    public final void e() {
        if (this.f423805d.f423807a == false) goto L7;
        View r100 = this.f423803b;
        if (r100 == null) goto L7;
        r100.setVisibility(0);
        setCursorFlicker(this.f423805d.f423808b);
    L7:
        TextView r101 = this.f423802a;
        if (r101 == null) goto L10;
        r101.setText("");
    L10:
        h r102 = this.f423806e;
        r102.getClass();
        g.b r103 = g.f423844b;
        Intrinsics.checkNotNullParameter(r103, "state");
        r102.c(r103);
    }

    public final void f() {
        if (this.f423805d.f423807a == false) goto L8;
        View r100 = this.f423803b;
        if (r100 == null) goto L9;
        r100.setVisibility(0);
        setCursorFlicker(this.f423805d.f423808b);
        return;
    L9:
        return;
    }

    public String getText() {
        TextView r100 = this.f423802a;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.getText().toString();
    }

    public CodeView(Context r100) {
        this(r100, null);
    }

    private void setCursorFlicker(boolean r100) {
        if (r100 == false) goto L4;
        this.f423804c.start();
        return;
    L4:
        this.f423804c.cancel();
    }

    public final int a(float r100) {
        Resources r101 = getContext().getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public void setText(String r100) {
        TextView r101 = this.f423802a;
        if (r101 == null) goto L5;
        r101.setText(r100);
    L5:
        h r102 = this.f423806e;
        r102.getClass();
        g.b r103 = g.f423844b;
        Intrinsics.checkNotNullParameter(r103, "state");
        r102.c(r103);
        View r104 = this.f423803b;
        if (r104 == null) goto L9;
        r104.setVisibility(8);
        setCursorFlicker(false);
        return;
    }

    public CodeView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r102, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (r102 * 1.05f), 1073741824));
    }

    public CodeView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        Context r103 = getContext();
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f423806e = new h(r103, 6.0f, 4);
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.f423804c = r104;
        r104.setRepeatCount(-1);
        this.f423804c.setRepeatMode(2);
        this.f423804c.setDuration(600);
        this.f423804c.setInterpolator(new LinearInterpolator());
        this.f423804c.addUpdateListener(new b(this));
        setClipChildren(false);
    }
}
