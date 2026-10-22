package com.larus.gallery.api;

import android.view.View;
import com.larus.common_ui.photoviewer.transition.TransitionLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class e implements i {
    public e() {
    }

    @Override // com.larus.gallery.api.i
    public final void a(View r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "data");
    }

    @Override // com.larus.gallery.api.i
    public final u b(TransitionLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new d(new View(r100.getContext()));
    }
}
