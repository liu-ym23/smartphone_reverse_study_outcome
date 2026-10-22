package com.ss.android.lark.inline.ai.asr;

import android.view.View;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f426884a;

    public f(c r100) {
        this.f426884a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Log.i("InlineAIAsrView", "click input_stop_icon");
        this.f426884a.f426873b.e();
    }
}
