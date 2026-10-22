package com.ss.android.lark.team;

import android.app.Activity;
import android.content.Context;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.bundle.ChatTeamBundle;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import w4b.e;
import w4b.g;

/* JADX INFO: loaded from: classes38.dex */
public final class TeamUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f441169a = null;

    static {
        f441169a = LazyKt.lazy(TeamUtils$teamDependency$2.INSTANCE);
    }

    public static /* synthetic */ boolean b(Chat r100) {
        a(r100, null);
        return false;
    }

    @JvmStatic
    public static final boolean a(Chat r100, Long r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        ((e) f441169a.getValue()).a(r100);
        return false;
    }

    @JvmStatic
    public static final void c(Context r100, Chat r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "chat");
        ChatBundle.a r103 = new ChatBundle.a();
        r103.f409934a = r101.getId();
        r103.f409956w = new ChatTeamBundle(r102, false);
        ChatBundle r104 = new ChatBundle(r103);
        g r105 = ChatCoreModule.a().getChatDependency();
        Intrinsics.checkNotNull(r104);
        r105.openChat(r100, r104);
        if ((r100 instanceof Activity) == false) goto L5;
        Activity r106 = (Activity) r100;
    L6:
        if (r106 == null) goto L9;
        r106.finish();
        r106.overridePendingTransition(0, 0);
        return;
    L9:
        return;
    L5:
        r106 = null;
        goto L6
    }
}
