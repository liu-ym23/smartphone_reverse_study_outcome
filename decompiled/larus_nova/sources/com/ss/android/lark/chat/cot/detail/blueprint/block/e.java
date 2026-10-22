package com.ss.android.lark.chat.cot.detail.blueprint.block;

import android.view.View;
import com.ss.android.lark.chat.core.api.ChatCoreModule;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f414936a;

    public e(String r100) {
        this.f414936a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ChatCoreModule.a().getBrowserDependency().openUrl(r100.getContext(), this.f414936a);
    }
}
