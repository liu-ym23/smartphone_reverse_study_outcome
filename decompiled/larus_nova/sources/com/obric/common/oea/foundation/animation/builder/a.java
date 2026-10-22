package com.obric.common.oea.foundation.animation.builder;

import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RunMode f396357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RepeatMode f396358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f396359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f396360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f396361e;

    public a(RunMode r100, RepeatMode r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, "runMode");
        Intrinsics.checkNotNullParameter(r101, "repeatMode");
        this.f396357a = r100;
        this.f396358b = r101;
        this.f396359c = r102;
        this.f396360d = r103;
        this.f396361e = false;
    }
}
