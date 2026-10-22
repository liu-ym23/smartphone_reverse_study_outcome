package com.ss.android.lark.myai.export.widget;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f432903f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f432904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f432905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f432906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearGradient f432907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f432908e;

    /* JADX INFO: renamed from: com.ss.android.lark.myai.export.widget.a$a, reason: collision with other inner class name */
    public static final class C5147a {
    }

    static {
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (this.f432908e == true) goto L5;
    L18:
        this.f432904a.getPaint().setShader(null);
    L19:
        return true;
    L5:
        if (this.f432904a.getText().length() <= 0) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == false) goto L18;
        if (this.f432904a.getLayout() == null) goto L18;
        if (this.f432904a.isDirty() == true) goto L16;
        LinearGradient r101 = this.f432907d;
        if (r101 == null) goto L16;
    L17:
        this.f432904a.getPaint().setShader(r101);
    L16:
        LinearGradient r110 = new LinearGradient(0.0f, 0.0f, Math.min(this.f432904a.getLayout().getWidth(), this.f432904a.getWidth()), this.f432904a.getHeight(), this.f432905b, this.f432906c, Shader.TileMode.CLAMP);
        this.f432907d = r110;
        r101 = r110;
        goto L17
    L7:
        r100 = false;
        goto L8
    }

    public a(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f432904a = r100;
        Context r101 = r100.getContext();
        this.f432905b = UDColorUtils.getColor(r101, R.color.myai_gradient_left);
        this.f432906c = UDColorUtils.getColor(r101, R.color.myai_gradient_right);
        r100.getViewTreeObserver().addOnPreDrawListener(this);
        this.f432908e = true;
    }
}
