package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import android.content.Context;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class o implements com.ss.android.lark.movable.selection.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<String, Context, Unit> f412535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m2b.a f412536b;

    /* JADX WARN: Multi-variable type inference failed */
    public o(Function2<? super String, ? super Context, Unit> r100, m2b.a r101) {
        this.f412535a = r100;
        this.f412536b = r101;
    }

    @Override // com.ss.android.lark.movable.selection.h
    public final boolean a(String r100, String r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "markdownStr");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = y0.f416752a;
        if (y0.a(this.f412536b.getChat()) == false) goto L6;
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
        this.f412535a.invoke(r101, r102);
    }
}
