package com.ss.android.lark.todo.impl.features.detail.time;

import com.ss.bytertc.engine.type.ErrorCode;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements l08.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoTimePickerFragment f443561a;

    public i(TodoTimePickerFragment r100) {
        this.f443561a = r100;
    }

    @Override // l08.a
    public final void a(int r100, int r110, int r111) {
        TodoTimePickerFragment r101 = this.f443561a;
        r101.f443533p = true;
        r101.f443528k = r100;
        r101.f443529l = r110;
        r101.f443530m = r111;
        int r102 = k8c.a.f502137a;
        long r103 = k8c.a.b(r101.f443522e, r101.f443523f, r101.f443524g, r101.f443525h, r101.f443526i, 96).getTimeInMillis();
        TodoTimePickerFragment r112 = this.f443561a;
        if (r103 <= k8c.a.b(r112.f443528k, r112.f443529l, r112.f443530m, r112.f443531n, r112.f443532o, 96).getTimeInMillis()) goto L8;
        TodoTimePickerFragment r104 = this.f443561a;
        r104.f443522e = r104.f443528k;
        r104.f443523f = r104.f443529l;
        r104.f443524g = r104.f443530m;
        if (r104.f443535r == true) goto L7;
        r104.f443525h = r104.f443531n;
        r104.f443526i = r104.f443532o;
    L7:
        r104.da0();
    L8:
        TodoTimePickerFragment r105 = this.f443561a;
        if (r105.f443541x == (-1)) goto L11;
    L13:
        r105.ea0(true);
        this.f443561a.ca0();
        this.f443561a.aa0();
        this.f443561a.ba0();
        return;
    L11:
        if (r105.f443540w == true) goto L13;
        r105.f443541x = ErrorCode.ERROR_CODE_OVER_STREAM_PUBLISH_LIMIT;
        goto L13
    }
}
