package com.ss.android.lark.integrator.im.impl.preview;

import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements ucb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeUrlPreviewSessionImpl f428015a;

    public e(OfficeUrlPreviewSessionImpl r100) {
        this.f428015a = r100;
    }

    @Override // ucb.a
    public final void a(Map<String, UrlCardPreviewEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "previewEntities");
        if (this.f428015a.f427990h.get() == false) goto L5;
        return;
    L5:
        this.f428015a.f(r100, null);
    }
}
