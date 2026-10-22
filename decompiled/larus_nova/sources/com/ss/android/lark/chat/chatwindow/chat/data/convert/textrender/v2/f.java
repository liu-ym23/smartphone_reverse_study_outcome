package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f extends e implements com.ss.android.lark.movable.selection.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.movable.selection.h f412507c;

    @Override // com.ss.android.lark.movable.selection.h
    public final boolean a(String r100, String r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "markdownStr");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f412507c.a(r100, r101, r102);
    }

    @Override // com.ss.android.lark.movable.selection.h
    public final void b(String r100, String r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "markdownStr");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f412507c.b(r100, r101, r102);
    }

    public f(a r100, com.ss.android.lark.movable.selection.h r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "action");
        super(r100, "copy");
        this.f412507c = r101;
    }
}
