package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu;

import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.message.menu.v2.PanelType;
import com.ss.android.lark.chat.message.menu.v2.j0;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f414110a;

    @Override // com.ss.android.lark.chat.message.menu.v2.j0
    public final void a(PanelType r100) {
        Intrinsics.checkNotNullParameter(r100, "toType");
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.j0
    public final void c(zya.b r100, List<zya.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "parentAction");
        Intrinsics.checkNotNullParameter(r101, "childActions");
    }

    public b(a r100) {
        this.f414110a = r100;
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.j0
    public final void d(boolean r100, MessageActionType r101, boolean r102) {
        Function0<Unit> r103 = this.f414110a.f414109b;
        if (r103 == null) goto L6;
        r103.invoke();
        return;
    }
}
