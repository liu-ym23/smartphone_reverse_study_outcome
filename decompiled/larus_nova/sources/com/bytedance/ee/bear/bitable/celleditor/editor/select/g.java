package com.bytedance.ee.bear.bitable.celleditor.editor.select;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements hp4.g.b<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f209470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SelectEditorModel f209471b;

    @Override // hp4.g.b
    public final void c(Object r100) {
    }

    public g(h r100, SelectEditorModel r101) {
        this.f209470a = r100;
        this.f209471b = r101;
    }

    @Override // hp4.g.b
    public final void d(Map<String, Object> r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        this.f209470a.f209472d.b(this.f209471b.getFieldUIType(), r100, r101);
    }
}
