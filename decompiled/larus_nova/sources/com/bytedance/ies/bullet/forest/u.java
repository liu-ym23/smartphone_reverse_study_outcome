package com.bytedance.ies.bullet.forest;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f246770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f246771b;

    public final String toString() {
        return "ReactLynxSSRChunk(type=" + this.f246770a + ", body=" + Arrays.toString(this.f246771b) + ')';
    }

    public final int hashCode() {
        return (this.f246770a * 31) + Arrays.hashCode(this.f246771b);
    }

    public final int getType() {
        return this.f246770a;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(u.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ies.bullet.forest.ReactLynxSSRChunk");
        u r102 = (u) r100;
        if (this.f246770a == r102.f246770a) goto L16;
        return false;
    L16:
        if (Arrays.equals(this.f246771b, r102.f246771b) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public u(int r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r101, ContainerPosition.BODY);
        this.f246770a = r100;
        this.f246771b = r101;
    }
}
