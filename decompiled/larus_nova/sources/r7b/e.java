package r7b;

import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;

/* JADX INFO: loaded from: classes35.dex */
public class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<ThreadTopic> f536483a;

    @Override // r7b.c
    public final int b() {
        return 0;
    }

    @Override // r7b.c
    public final int G7() {
        return this.f536483a.get().getLastMsgPos();
    }

    @Override // r7b.c
    public final int e() {
        return this.f536483a.get().getReadPosBadgeCount();
    }

    @Override // r7b.c
    public final int h() {
        ThreadTopic r100 = this.f536483a.get();
        return Math.min(r100.getLastMsgPos() - r100.getReadPos(), r100.getLastMsgPosBadgeCount() - r100.getReadPosBadgeCount());
    }

    @Override // r7b.c
    public final int i() {
        return this.f536483a.get().getLastMsgPosBadgeCount();
    }

    @Override // r7b.c
    public final int l() {
        return this.f536483a.get().getReadPos();
    }

    @Override // r7b.c
    public final Chat.MessagePosition f() {
        return Chat.MessagePosition.RECENT_LEFT;
    }

    public e(b<ThreadTopic> r100) {
        this.f536483a = r100;
    }

    @Override // r7b.c
    public final int c(Message r100) {
        return r100.getThreadPosition();
    }

    @Override // r7b.c
    public final int d(MessageInfo r100) {
        return r100.getMessage().getThreadBadgeCount();
    }

    @Override // r7b.c
    public final boolean k(MessageInfo r100) {
        if (d(r100) > e()) goto L5;
        return true;
    L5:
        return false;
    }
}
