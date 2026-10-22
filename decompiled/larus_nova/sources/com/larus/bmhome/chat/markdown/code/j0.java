package com.larus.bmhome.chat.markdown.code;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class j0 extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f306993a;

    public j0(int r100) {
        this.f306993a = r100;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r101, "outline");
        r101.setRoundRect(0, this.f306993a, r100.getWidth(), r100.getHeight(), MarkdownDimensExtKt.b());
    }
}
