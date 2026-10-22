package com.ss.android.lark.chat.utils;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ReplyInThreadUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f416628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f416629b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/utils/ReplyInThreadUtil$ReplyOptimizeFGState;", "", "<init>", "(Ljava/lang/String;I)V", "ONLINE_STATE", "EXP1_STATE", "EXP2_STATE", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ReplyOptimizeFGState extends Enum<ReplyOptimizeFGState> {
        public static final ReplyOptimizeFGState EXP1_STATE = null;
        public static final ReplyOptimizeFGState EXP2_STATE = null;
        public static final ReplyOptimizeFGState ONLINE_STATE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ReplyOptimizeFGState[] f416630a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f416631b = null;

        public static EnumEntries<ReplyOptimizeFGState> getEntries() {
            return f416631b;
        }

        static {
            ReplyOptimizeFGState r100 = new ReplyOptimizeFGState("ONLINE_STATE", 0);
            ONLINE_STATE = r100;
            ReplyOptimizeFGState r101 = new ReplyOptimizeFGState("EXP1_STATE", 1);
            EXP1_STATE = r101;
            ReplyOptimizeFGState r102 = new ReplyOptimizeFGState("EXP2_STATE", 2);
            EXP2_STATE = r102;
            ReplyOptimizeFGState[] r103 = {r100, r101, r102};
            f416630a = r103;
            f416631b = EnumEntriesKt.enumEntries(r103);
        }

        public static ReplyOptimizeFGState[] values() {
            return (ReplyOptimizeFGState[]) f416630a.clone();
        }

        public static ReplyOptimizeFGState valueOf(String r100) {
            return (ReplyOptimizeFGState) r27.a.a(ReplyOptimizeFGState.class, r100);
        }

        public ReplyOptimizeFGState(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
    }

    @JvmStatic
    public static final boolean a(p5b.c r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof MessageInfo) == true) goto L8;
        return false;
    L8:
        Message r101 = ((MessageInfo) r100).getMessage();
        w4b.c.f r102 = ChatCoreModule.a().getMyAIDependency();
        r101.getAiChatModeId();
        r102.b();
        if (r101.getThreadMessageType() != null) goto L11;
        return false;
    L11:
        if (r101.getThreadMessageType() == Message.ThreadMessageType.UNKNOWN_THREAD_MESSAGE) goto L15;
        return true;
    L15:
        return false;
    }

    @JvmStatic
    public static final boolean b(y6b.a<? extends v5b.a<? extends Content>> r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        w4b.c.f r101 = ChatCoreModule.a().getMyAIDependency();
        r100.o();
        r101.b();
        if ((r100 instanceof y6b.c) == true) goto L9;
        return false;
    L9:
        if (((y6b.c) r100).S1 != Message.ThreadMessageType.THREAD_ROOT_MESSAGE) goto L12;
        return true;
    L12:
        return false;
    }

    @JvmStatic
    public static final ReplyOptimizeFGState d(jdb.g r100) {
        Intrinsics.checkNotNullParameter(r100, "fgService");
        if (f416628a != null) goto L5;
        f416628a = Boolean.valueOf(r100.isEnable("messenger.message.reply_optimize"));
    L5:
        Boolean r101 = f416628a;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Boolean");
        if (r101.booleanValue() == false) goto L16;
        if (f416629b != null) goto L10;
        f416629b = Boolean.valueOf(r100.isEnable("messenger.message.reply_optimize_exp1"));
    L10:
        Boolean r102 = f416629b;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Boolean");
        if (r102.booleanValue() == false) goto L14;
        return ReplyOptimizeFGState.EXP1_STATE;
    L14:
        return ReplyOptimizeFGState.EXP2_STATE;
    L16:
        return ReplyOptimizeFGState.ONLINE_STATE;
    }

    @JvmStatic
    public static final ReplyOptimizeFGState e(jdb.g r100, Chat r101) {
        Intrinsics.checkNotNullParameter(r100, "fgService");
        if (r101 != null) goto L7;
        return ReplyOptimizeFGState.ONLINE_STATE;
    L7:
        if (r101.isSecret() == false) goto L11;
        return ReplyOptimizeFGState.ONLINE_STATE;
    L11:
        if (f416628a != null) goto L13;
        f416628a = Boolean.valueOf(r100.isEnable("messenger.message.reply_optimize"));
    L13:
        Boolean r102 = f416628a;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Boolean");
        if (r102.booleanValue() == false) goto L24;
        if (f416629b != null) goto L18;
        f416629b = Boolean.valueOf(r100.isEnable("messenger.message.reply_optimize_exp1"));
    L18:
        Boolean r103 = f416629b;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Boolean");
        if (r103.booleanValue() == false) goto L22;
        return ReplyOptimizeFGState.EXP1_STATE;
    L22:
        return ReplyOptimizeFGState.EXP2_STATE;
    L24:
        return ReplyOptimizeFGState.ONLINE_STATE;
    }

    @JvmStatic
    public static final void c(Context r100, com.ss.android.lark.biz.im.api.l1 r101, Fragment r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bundle");
        if (ForsetiConfig.a(r100) == false) goto L6;
        if (r102 == null) goto L6;
        ChatCoreModule.a().getChatDependency().g(r100, r101, r102);
        return;
    L6:
        ChatCoreModule.a().getChatDependency().j(r100, r101);
    }
}
