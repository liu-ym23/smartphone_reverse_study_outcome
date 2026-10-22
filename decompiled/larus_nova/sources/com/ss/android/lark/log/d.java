package com.ss.android.lark.log;

import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.suite.component.logger.api.h f431382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f431383b;

    public d(com.suite.component.logger.api.h r100) {
        Intrinsics.checkNotNullParameter(r100, "newLogger");
        this.f431382a = r100;
        this.f431383b = "lark";
    }

    @Override // com.ss.android.lark.log.c
    public final void d(String r100, String r101) {
        com.suite.component.logger.api.h r102 = this.f431382a;
        if (r100 != null) goto L5;
        r100 = this.f431383b;
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r102.d(r100, r101, null);
    }

    @Override // com.ss.android.lark.log.c
    public final void e(String r100, String r101) {
        com.suite.component.logger.api.h r102 = this.f431382a;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r102.g(r100, r101, null, false);
    }

    @Override // com.ss.android.lark.log.c
    public final void i(String r100, String r101) {
        com.suite.component.logger.api.h r102 = this.f431382a;
        if (r100 != null) goto L5;
        r100 = this.f431383b;
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r102.i(r100, r101, null);
    }

    @Override // com.ss.android.lark.log.c
    public final void v(String r100, String r101) {
        com.suite.component.logger.api.h r102 = this.f431382a;
        if (r100 != null) goto L5;
        r100 = this.f431383b;
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r102.v(r100, r101, null);
    }

    @Override // com.ss.android.lark.log.c
    public final void w(String r100, String r101) {
        com.suite.component.logger.api.h r102 = this.f431382a;
        if (r100 != null) goto L5;
        r100 = this.f431383b;
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r102.w(r100, r101, null);
    }

    @Override // com.ss.android.lark.log.c
    public final void wtf(String r100, String r101) {
        com.suite.component.logger.api.h r102 = this.f431382a;
        if (r100 != null) goto L5;
        r100 = this.f431383b;
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r102.w(r100, r101, null);
    }

    @Override // com.ss.android.lark.log.c
    public final void a(String r100, String r101, String r102) {
        com.suite.component.logger.api.h r103 = this.f431382a;
        if (r100 != null) goto L5;
        r100 = this.f431383b;
    L5:
        StringBuilder r104 = new StringBuilder();
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r104.append(r101);
        r104.append(", jsonContent:");
        r104.append(r102);
        r103.i(r100, r104.toString(), null);
    }

    @Override // com.ss.android.lark.log.c
    public final void c(String r100, String r101, String r102) {
        com.suite.component.logger.api.h r103 = this.f431382a;
        if (r100 != null) goto L5;
        r100 = this.f431383b;
    L5:
        StringBuilder r104 = new StringBuilder();
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r104.append(r101);
        r104.append(", xmlContent:");
        r104.append(r102);
        r103.i(r100, r104.toString(), null);
    }

    @Override // com.ss.android.lark.log.c
    public final void d(String r100, String r101, Throwable r102) {
        com.suite.component.logger.api.h r103 = this.f431382a;
        if (r100 != null) goto L5;
        r100 = this.f431383b;
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r103.d(r100, r101, r102);
    }

    @Override // com.ss.android.lark.log.c
    public final void e(String r100, String r101, Throwable r102) {
        com.suite.component.logger.api.h r103 = this.f431382a;
        if (r100 != null) goto L5;
        r100 = this.f431383b;
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r103.g(r100, r101, r102, false);
    }

    @Override // com.ss.android.lark.log.c
    public final void i(String r100, String r101, Throwable r102) {
        com.suite.component.logger.api.h r103 = this.f431382a;
        if (r100 != null) goto L5;
        r100 = this.f431383b;
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r103.i(r100, r101, r102);
    }

    @Override // com.ss.android.lark.log.c
    public final void v(String r100, String r101, Throwable r102) {
        com.suite.component.logger.api.h r103 = this.f431382a;
        if (r100 != null) goto L5;
        r100 = this.f431383b;
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r103.v(r100, r101, r102);
    }

    @Override // com.ss.android.lark.log.c
    public final void w(String r100, String r101, Throwable r102) {
        com.suite.component.logger.api.h r103 = this.f431382a;
        if (r100 != null) goto L5;
        r100 = this.f431383b;
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r103.w(r100, r101, r102);
    }

    @Override // com.ss.android.lark.log.c
    public final void wtf(String r100, String r101, Throwable r102) {
        com.suite.component.logger.api.h r103 = this.f431382a;
        if (r100 != null) goto L5;
        r100 = this.f431383b;
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r103.w(r100, r101, r102);
    }

    @Override // com.ss.android.lark.log.c
    public final void b(int r110, String r111, String[] r112, String r113, Map<String, String> r114) {
        com.suite.component.logger.c r100 = com.suite.component.logger.Log.f460088b.obtain();
        com.suite.component.logger.api.LogLevel.Companion.getClass();
        com.suite.component.logger.api.LogLevel r101 = com.suite.component.logger.api.LogLevel.a.a(r110);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f460115a = r101;
        r100.f460120f = r111;
        String r102 = "";
        if (r112 == null) goto L6;
        String r103 = ArraysKt.joinToString$default(r112, "-", null, null, 0, null, null, 62, null);
        if (r103 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r100.f460116b = r103;
        if (r113 == null) goto L11;
        r102 = r113;
    L11:
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r100.f460117c = r102;
        if (r114 != null) goto L14;
    L17:
        boolean r104 = true;
    L18:
        if (r104 == true) goto L20;
        r100.c(r114);
    L20:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        com.suite.component.logger.api.h r105 = r100.f460132r;
        if (r105 == null) goto L24;
        r105.h(r100);
        return;
    L24:
        return;
    L14:
        if (r114.isEmpty() == true) goto L17;
        r104 = false;
    L6:
        r103 = "";
        goto L7
    }
}
