package com.ss.android.lark.ai.smartreply.inter;

import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum ISmartReplyInterface$ReplyAction extends Enum<ISmartReplyInterface$ReplyAction> {
    public static final ISmartReplyInterface$ReplyAction CHAT_REPLY = null;
    public static final ISmartReplyInterface$ReplyAction INPUT_DIRECT = null;
    public static final ISmartReplyInterface$ReplyAction THREAD_REPLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ISmartReplyInterface$ReplyAction[] f408637a = null;
    private String value;

    static {
        ISmartReplyInterface$ReplyAction r100 = new ISmartReplyInterface$ReplyAction("CHAT_REPLY", 0, GestureAction.longPress);
        CHAT_REPLY = r100;
        ISmartReplyInterface$ReplyAction r101 = new ISmartReplyInterface$ReplyAction("INPUT_DIRECT", 1, "direct");
        INPUT_DIRECT = r101;
        ISmartReplyInterface$ReplyAction r102 = new ISmartReplyInterface$ReplyAction("THREAD_REPLY", 2, "thread");
        THREAD_REPLY = r102;
        f408637a = new ISmartReplyInterface$ReplyAction[]{r100, r101, r102};
    }

    public static ISmartReplyInterface$ReplyAction[] values() {
        return (ISmartReplyInterface$ReplyAction[]) f408637a.clone();
    }

    public String getValue() {
        return this.value;
    }

    public static ISmartReplyInterface$ReplyAction valueOf(String r100) {
        return (ISmartReplyInterface$ReplyAction) a.a(ISmartReplyInterface$ReplyAction.class, r100);
    }

    public ISmartReplyInterface$ReplyAction(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
