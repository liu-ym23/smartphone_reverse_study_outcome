package com.ss.android.lark.chat.message.menu.v2.popup;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f415882f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final yya.a f415883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.chat.message.menu.d f415884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.message.params.m f415885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.ss.android.lark.chat.message.menu.v2.popup.a f415886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f415887e;

    public static final class a {
    }

    static {
    }

    public final com.ss.android.lark.chat.message.menu.v2.popup.a a() {
        com.ss.android.lark.chat.message.menu.v2.popup.a r100 = this.f415886d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("menuControl");
        return null;
    }

    public d(yya.a r100, com.ss.android.lark.chat.message.menu.d r101, com.ss.android.lark.biz.im.api.message.params.m r102) {
        Intrinsics.checkNotNullParameter(r100, "actionContext");
        Intrinsics.checkNotNullParameter(r101, SlcCommonAction.KEY_ACTIONS);
        this.f415883a = r100;
        this.f415884b = r101;
        this.f415885c = r102;
    }
}
