package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import androidx.lifecycle.Observer;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public final class e0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f430278a;

    public e0(b0 r100) {
        this.f430278a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L6;
        b0.a(this.f430278a, R.string.Lark_Chat_AudioToTextPoorNetworkError);
        return;
    }
}
