package com.ss.android.lark.flow.chat.message;

import android.content.Context;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f422290a = 0;

    static {
    }

    public static void a(Context r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "chatId");
        int r103 = FlowChatModule.f422022d;
        String r104 = FlowChatModule.a.a().a().getBrowserDependency().getAppLinkDomain();
        if (r104.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L8;
        return;
    L8:
        FlowChatModule.a.a().a().getBrowserDependency().openUrl(r100, UriProtector.parse("https://" + r104 + "/client/chat/open").buildUpon().appendQueryParameter("chatId", r101).appendQueryParameter("position", String.valueOf(r102)).build().toString());
        return;
    L5:
        r105 = false;
        goto L6
    }
}
