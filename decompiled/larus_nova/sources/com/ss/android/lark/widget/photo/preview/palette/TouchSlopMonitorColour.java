package com.ss.android.lark.widget.photo.preview.palette;

import android.view.MotionEvent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class TouchSlopMonitorColour extends k28.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f447113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f447114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f447115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f447116e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f447117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f447118g;

    public interface a {
        void a();
    }

    public TouchSlopMonitorColour() {
        this.f447113b = LazyKt.lazy(new TouchSlopMonitorColour$sTouchSlopValue$2(this));
    }

    @Override // k28.a
    public final Boolean a(MotionEvent r100, Function1<? super MotionEvent, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r101, "superMethod");
        a r102 = this.f447118g;
        if (r102 == null) goto L21;
        if (r100 == null) goto L21;
        int r103 = (int) r100.getRawX();
        int r104 = (int) r100.getRawY();
        int r105 = r100.getAction();
        if (r105 != 0) goto L8;
    L19:
        this.f447116e = 0;
        this.f447117f = 0;
    L20:
        this.f447114c = r103;
        this.f447115d = r104;
        goto L21
    L8:
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L12;
        this.f447116e += Math.abs(r103 - this.f447114c);
        this.f447117f += Math.abs(r104 - this.f447115d);
        if (this.f447116e <= ((Number) this.f447113b.getValue()).intValue()) goto L17;
    L18:
        this.f447116e = 0;
        this.f447117f = 0;
        r102.a();
        goto L20
    L17:
        if (this.f447117f <= ((Number) this.f447113b.getValue()).intValue()) goto L20;
    L12:
        if (r105 == 3) goto L19;
    L21:
        super.a(r100, r101);
        return null;
    }
}
