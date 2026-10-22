package com.larus.drive.sdk.impl.service;

import android.os.Bundle;
import com.larus.ui.arch.component.external.api.receiver.Container;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes27.dex */
public final class b implements Function1<fp8.b, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bundle f341932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Container f341933b;

    public b(Bundle r100, Container r101) {
        this.f341932a = r100;
        this.f341933b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(fp8.b r100) {
        fp8.b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        fp8.b r102 = fp8.b.a(r101, null, this.f341932a.getInt("bottom_tab_height", 0), 3);
        t1a.e r103 = s1a.d.a(this.f341933b).p(Reflection.getOrCreateKotlinClass(fp8.b.class));
        if (r103 == null) goto L5;
        r103.a(new c(r102));
    L9:
        return Unit.INSTANCE;
    L5:
        x1a.b r104 = x1a.a.f562152c;
        if (r104 == null) goto L9;
        r104.log(5, "ComponentArch", "updateData ignored: context destroyed for " + Reflection.getOrCreateKotlinClass(fp8.b.class).getQualifiedName());
        goto L9
    }
}
