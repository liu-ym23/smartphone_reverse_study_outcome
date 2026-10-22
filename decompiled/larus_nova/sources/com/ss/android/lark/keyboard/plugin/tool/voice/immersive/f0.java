package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import androidx.lifecycle.Observer;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public final class f0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f430281a;

    public f0(b0 r100) {
        this.f430281a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        if (r101 != null) goto L6;
    L7:
        if (r101 != null) goto L10;
    L12:
        b0.b(this.f430281a, R.string.Lark_Chat_VoiceMessageFailedToast);
        return;
    L10:
        if (r101.intValue() != 10006) goto L12;
    L13:
        b0.b(this.f430281a, R.string.Lark_IM_RecordingInterrupted_Toast);
        return;
    L6:
        if (r101.intValue() == 10005) goto L13;
        goto L7
    }
}
