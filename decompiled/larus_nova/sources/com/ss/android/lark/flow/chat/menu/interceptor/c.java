package com.ss.android.lark.flow.chat.menu.interceptor;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.log.Log;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements yya.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<MessageActionType> f422229b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<PageType> f422230c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Boolean> f422231a;

    public static final class a {
    }

    @Override // yya.l
    public final String getTAG() {
        return "DoubaoChatSettingActionInterceptor";
    }

    static {
        f422229b = SetsKt.setOf(new MessageActionType[]{MessageActionType.FLOW_ASK_DOUBAO, MessageActionType.FOLLOW_UP_QUESTION, MessageActionType.WORDS_ASK_DOUBAO});
        f422230c = SetsKt.setOf(new PageType[]{PageType.CHAT_WINDOW, PageType.REPLY_IN_THREAD});
    }

    public c() {
        DoubaoChatSettingActionInterceptor$1 r100 = DoubaoChatSettingActionInterceptor$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "enterpriseAccountProvider");
        this.f422231a = r100;
    }

    @Override // yya.l
    public final boolean a(MessageActionType r100, yya.a r101) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r101, "actionContext");
        boolean r102 = false;
        if (f422229b.contains(r100) == true) goto L6;
        return false;
    L6:
        if (f422230c.contains(r101.r()) == true) goto L9;
        return false;
    L9:
        if (this.f422231a.invoke().booleanValue() == false) goto L12;
        Log.d("DoubaoChatSettingAction", "intercept Ask Doubao action for enterprise account");
        return true;
    L12:
        Chat r103 = r101.getChat();
        if (r103 != null) goto L15;
        return false;
    L15:
        boolean r104 = r103.getDoubaoSetting().isDoubaoUsingEnabled();
        int r105 = com.ss.android.lark.biz.im.api.h.f410251a;
        if (r104 == false) goto L18;
        r102 = true;
    L18:
        boolean r106 = !r102;
        if (r106 == false) goto L21;
        Log.d("DoubaoChatSettingAction", "intercept Ask Doubao action, pageType=" + r101.r());
    L21:
        return r106;
    }
}
