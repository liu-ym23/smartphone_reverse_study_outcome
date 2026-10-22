package com.ss.android.lark.chat.chatwindow.biz.plugin.core;

import android.content.Context;
import android.os.Handler;
import com.larksuite.framework.callback.CallbackManager;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.chat.chatwindow.biz.plugin.watermark.WaterMarkPlugin;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class BaseChatPlugin implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f412313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CallbackManager f412314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BaseFragment f412315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public v f412316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f412317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f412318f;

    public boolean A() {
        return this instanceof WaterMarkPlugin;
    }

    public void D() {
        this.f412317e = true;
        ((Handler) this.f412318f.getValue()).removeCallbacksAndMessages(null);
    }

    public void E() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.d
    public final void onPause() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.d
    public void onStart() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.d
    public final void resume() {
    }

    public abstract boolean y(i7b.a r100);

    public void z(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r100, i7b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "chatApp");
        Intrinsics.checkNotNullParameter(r101, "initData");
    }

    public final BaseFragment B() {
        BaseFragment r100 = this.f412315c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("hostFragment");
        return null;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.d
    public final void destroy() {
        CallbackManager r100 = this.f412314b;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("callBackManager");
        r100 = null;
    L6:
        r100.cancelCallbacks();
        D();
    }

    public final Context getContext() {
        Context r100 = this.f412313a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    public BaseChatPlugin() {
        this.f412318f = LazyKt.lazy(BaseChatPlugin$mainThreadHandler$2.INSTANCE);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.d
    public final void stop() {
        E();
    }

    public void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r100, i7b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "chatApp");
        Intrinsics.checkNotNullParameter(r101, "initData");
        v r102 = (v) r100.get();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f412316d = r102;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.d
    public final void c(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r100, i7b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "chatApp");
        Intrinsics.checkNotNullParameter(r101, "initData");
        int r102 = com.ss.android.lark.chat.chatwindow.biz.component.keyboard.b.f412047a;
        Lazy r103 = ChatCoreModule.f414742a;
        if (A() == false) goto L6;
        z(r100, r101);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.d
    public final void j(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r100, i7b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "chatApp");
        Intrinsics.checkNotNullParameter(r101, "initData");
        Context r102 = r100.getContext();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f412313a = r102;
        v r103 = (v) r100.get();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f412316d = r103;
        CallbackManager r104 = new CallbackManager();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f412314b = r104;
        Object r105 = r100.getHost();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.ss.android.lark.base.fragment.BaseFragment");
        BaseFragment r106 = (BaseFragment) r105;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        this.f412315c = r106;
        if (y(r101) == true) goto L5;
        return;
    L5:
        C(r100, r101);
        if (A() == false) goto L8;
        int r107 = com.ss.android.lark.chat.chatwindow.biz.component.keyboard.b.f412047a;
        Lazy r108 = ChatCoreModule.f414742a;
        return;
    L8:
        z(r100, r101);
    }
}
