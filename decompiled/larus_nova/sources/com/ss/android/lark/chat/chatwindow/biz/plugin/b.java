package com.ss.android.lark.chat.chatwindow.biz.plugin;

import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.chatwindow.biz.plugin.core.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f412309g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f412310h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Runnable f412311i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Runnable f412312j;

    public final void F() {
        Runnable r100 = this.f412312j;
        if (r100 == null) goto L5;
        UICallbackExecutor.removeCallbacks(r100);
        this.f412312j = null;
    L5:
        Runnable r101 = this.f412311i;
        if (r101 == null) goto L9;
        UICallbackExecutor.removeCallbacks(r101);
        this.f412311i = null;
    L9:
        if (this.f412310h == false) goto L12;
        this.f412310h = false;
    L12:
        if (this.f412309g == false) goto L15;
        this.f412309g = false;
        return;
    }

    public b() {
        UIUtils.canShowSkeleton();
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void D() {
        super.D();
        F();
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r100, i7b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "chatApp");
        Intrinsics.checkNotNullParameter(r101, "initData");
        super.C(r100, r101);
        F();
    }
}
