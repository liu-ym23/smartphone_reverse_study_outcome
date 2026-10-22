package z5c;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;

/* JADX INFO: loaded from: classes38.dex */
public final class q extends s5c.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s5c.a f570299c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s5c.a f570300d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final s5c.a f570301e = null;

    static {
        q r100 = new q();
        r100.a("p2p");
        f570299c = r100.a("group");
        r100.a("topicgroup");
        f570300d = r100.a("single");
        f570301e = r100.a("topic");
        r100.a("thread");
        r100.a(INotificationHitPoint.ChatType.CHAT_TYPE_SINGLE_BOT);
        r100.a("group_chat");
    }

    public q() {
        super("chat_type");
    }
}
