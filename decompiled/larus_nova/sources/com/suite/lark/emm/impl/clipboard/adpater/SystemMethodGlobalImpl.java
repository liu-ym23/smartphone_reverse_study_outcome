package com.suite.lark.emm.impl.clipboard.adpater;

import android.content.ClipData;
import doc.b;
import doc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class SystemMethodGlobalImpl implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f460439a;

    public final d a() {
        return (d) this.f460439a.getValue();
    }

    public SystemMethodGlobalImpl() {
        this.f460439a = LazyKt.lazy(SystemMethodGlobalImpl$globalManager$2.INSTANCE);
    }

    @Override // doc.b
    public final boolean E6() {
        return a().E6();
    }

    @Override // doc.b
    public final void L3() {
        a().L3();
    }

    @Override // doc.b
    public final ClipData Ma() {
        return a().Ma();
    }

    @Override // doc.b
    public final void Sd() {
        a().Sd();
    }

    @Override // doc.b
    public final int Ua() {
        return a().Ua();
    }

    @Override // doc.b
    public final void wa() {
        a().wa();
    }

    @Override // doc.b
    public final void Ze(ClipData r100) {
        Intrinsics.checkNotNullParameter(r100, "clipData");
        a().Ze(r100);
    }

    @Override // doc.b
    public final int xb(ClipData r100) {
        return a().xb(r100);
    }
}
