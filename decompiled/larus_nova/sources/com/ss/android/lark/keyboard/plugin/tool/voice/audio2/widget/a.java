package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget;

import android.content.Context;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends UDDialogController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f430058a;

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View createView() {
        return this.f430058a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
