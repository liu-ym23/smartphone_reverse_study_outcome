package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.dto.chat.ProfileSource;
import kotlin.jvm.internal.Intrinsics;
import w4b.b0;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements mcc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f414068a;

    @Override // mcc.b
    public final boolean c(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "userId");
        return false;
    }

    public b(c r100) {
        Intrinsics.checkNotNullParameter(r100, "clickContext");
        this.f414068a = r100;
    }

    @Override // mcc.b
    public final void d(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "userId");
        b0 r103 = ChatCoreModule.a().getProfileDependency();
        Context r104 = this.f414068a.getContext();
        ProfileSource.a r105 = new ProfileSource.a();
        r105.f420573e = r102;
        r105.f420572d = this.f414068a.f414071c.getId();
        r105.f420570b = 1;
        r105.f420571c = com.ss.android.lark.chat.utils.k.a(this.f414068a.f414071c);
        r103.e(r104, r105.a());
    }
}
