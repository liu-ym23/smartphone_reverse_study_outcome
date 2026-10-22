package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.content.Context;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class k implements com.ss.android.lark.movable.selection.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.movable.selection.a f414129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Chat f414130b;

    public k(com.ss.android.lark.movable.selection.a r100, Chat r101) {
        this.f414129a = r100;
        this.f414130b = r101;
    }

    @Override // com.ss.android.lark.movable.selection.h
    public final boolean a(String r100, String r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "markdownStr");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = y0.f416752a;
        if (y0.a(this.f414130b) == false) goto L6;
        return false;
    L6:
        y0.f(r102);
        return true;
    }

    @Override // com.ss.android.lark.movable.selection.h
    public final void b(String r100, String r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "markdownStr");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f414129a.b(r100, r101, r102);
    }
}
