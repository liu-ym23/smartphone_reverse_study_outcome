package com.ss.android.lark.forwardv3.plugins;

import com.ss.android.lark.picker.config.OnPickerFinishListener;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements OnPickerFinishListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForwardCreateGroupChatFragment f425502a;

    @Override // com.ss.android.lark.picker.config.OnPickerFinishListener
    public final void onFinished() {
        this.f425502a.f425461h.onBack();
    }

    public c(ForwardCreateGroupChatFragment r100) {
        this.f425502a = r100;
    }
}
