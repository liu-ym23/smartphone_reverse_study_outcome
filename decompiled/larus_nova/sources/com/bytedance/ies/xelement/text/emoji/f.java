package com.bytedance.ies.xelement.text.emoji;

import android.content.Context;
import android.graphics.Canvas;
import com.lynx.tasm.behavior.ui.text.AndroidText;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f extends AndroidText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f250385a;

    @Override // com.lynx.tasm.behavior.ui.text.AndroidText, com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.lynx.tasm.behavior.ui.text.AndroidText, com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.lynx.tasm.behavior.ui.text.AndroidText, com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.lynx.tasm.behavior.ui.text.AndroidText, com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // com.lynx.tasm.behavior.ui.text.AndroidText, com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    @Override // com.lynx.tasm.behavior.ui.text.AndroidText, com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        setImportantForAccessibility(2);
        setFocusable(false);
    }

    @Override // com.lynx.tasm.behavior.ui.text.AndroidText, com.lynx.tasm.behavior.ui.view.a, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f250385a == false) goto L5;
        return;
    L5:
        super.onDraw(r100);
    }

    public final void setDrawHandledByParentText(boolean r100) {
        if (this.f250385a != r100) goto L5;
        return;
    L5:
        this.f250385a = r100;
        invalidate();
    }
}
