package com.ss.android.lark.chat.chatwindow.chat.message.actionimpl;

import android.content.Context;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import mya.t;

/* JADX INFO: loaded from: classes35.dex */
public final class h implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f412610a;

    public final Context getContext() {
        return this.f412610a;
    }

    public h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f412610a = r100;
    }

    @Override // mya.t
    public final void o(String r100, String r101, Integer r102, Boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "threadId");
        l1.a r104 = new l1.a();
        r104.f410298e = r100;
        r104.f410308o = true;
        if (r101 == null) goto L5;
        r104.f410305l = r101;
    L5:
        if (r102 == null) goto L7;
        r104.f410299f = r102.intValue();
    L7:
        if (r103 == null) goto L9;
        r104.f410295b = r103.booleanValue();
    L9:
        l1 r105 = new l1(r104);
        Context r106 = this.f412610a;
        Intrinsics.checkNotNull(r105);
        Boolean r107 = ReplyInThreadUtil.f416628a;
        Intrinsics.checkNotNullParameter(r106, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r105, "bundle");
        ReplyInThreadUtil.c(r106, r105, null);
    }
}
