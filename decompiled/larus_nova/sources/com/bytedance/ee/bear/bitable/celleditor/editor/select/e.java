package com.bytedance.ee.bear.bitable.celleditor.editor.select;

import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e extends com.bytedance.ee.bear.bitable.celleditor.editor.b {
    public e() {
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "optionId");
        ActionPayload r101 = new ActionPayload();
        r101.setAction("SelectClickOption");
        r101.setId(r100);
        a(r101);
    }
}
