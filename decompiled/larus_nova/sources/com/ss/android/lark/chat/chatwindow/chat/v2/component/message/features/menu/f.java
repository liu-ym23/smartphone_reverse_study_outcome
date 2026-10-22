package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu;

import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.ListMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageListMenuFeature f413859a;

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.a
    public final ListMode getCurrentMode() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r100 = this.f413859a.f413848b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r100 = null;
    L5:
        e4b.a r101 = (e4b.a) r100.b(e4b.a.class);
        if (r101 == null) goto L10;
        ListMode r102 = r101.o();
        if (r102 == null) goto L10;
        return r102;
    L10:
        return ListMode.NORMAL;
    }

    public f(MessageListMenuFeature r100) {
        this.f413859a = r100;
    }
}
