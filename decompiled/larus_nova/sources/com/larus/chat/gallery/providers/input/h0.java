package com.larus.chat.gallery.providers.input;

import android.view.View;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f324915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f324916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CommonDownLoadLayout f324917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f324918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f324919e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f324920f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f324921g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Unit> f324922h;

    public final void a() {
        CommonDownLoadLayout r100 = this.f324917c;
        if (this.f324920f == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        r100.setLayoutEnable(r101);
        if (this.f324921g == false) goto L11;
        this.f324917c.T5();
        return;
    L11:
        this.f324917c.R5();
        return;
    L5:
        if (this.f324921g == true) goto L7;
        r101 = true;
        goto L8
    }

    public h0(View r100, View r101, CommonDownLoadLayout r102, x r103, y r104) {
        Intrinsics.checkNotNullParameter(r100, "inputContainer");
        Intrinsics.checkNotNullParameter(r101, "bottomContainer");
        Intrinsics.checkNotNullParameter(r102, "saveButton");
        Intrinsics.checkNotNullParameter(r103, "hideInputMethod");
        Intrinsics.checkNotNullParameter(r104, "removeInputInterceptor");
        this.f324915a = r100;
        this.f324916b = r101;
        this.f324917c = r102;
        this.f324918d = r103;
        this.f324919e = r104;
        this.f324920f = true;
        r102.setOnClickListener(new g0(this));
    }
}
