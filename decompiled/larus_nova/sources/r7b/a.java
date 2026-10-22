package r7b;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.utils.k;

/* JADX INFO: loaded from: classes35.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r7b.b<Chat> f536478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC7445a f536479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f536480c;

    /* JADX INFO: renamed from: r7b.a$a, reason: collision with other inner class name */
    public interface InterfaceC7445a {
        boolean a();
    }

    public interface b {
        void a();

        int b();

        int getTitleBarHeight();

        void getWidgetHeight();

        void z4();
    }

    @Override // r7b.c
    public final int G7() {
        return this.f536478a.get().getLastMessagePosition();
    }

    @Override // r7b.c
    public final boolean a() {
        return this.f536479b.a();
    }

    @Override // r7b.c
    public final int b() {
        return this.f536478a.get().getFirstMessagePosition();
    }

    @Override // r7b.c
    public final int e() {
        return this.f536478a.get().getReadPositionBadgeCount();
    }

    @Override // r7b.c
    public final Chat.MessagePosition f() {
        return k.c(this.f536478a.get());
    }

    @Override // r7b.c
    public final int h() {
        return this.f536478a.get().getUnReadBadgeCount();
    }

    @Override // r7b.c
    public final int i() {
        return this.f536478a.get().getLastMessagePositionBadgeCount();
    }

    @Override // r7b.c
    public final int j() {
        int r100 = this.f536480c.b();
        this.f536480c.z4();
        this.f536480c.getWidgetHeight();
        this.f536480c.a();
        return (((r100 + 0) + 0) + 0) + this.f536480c.getTitleBarHeight();
    }

    @Override // r7b.c
    public final int l() {
        return this.f536478a.get().getReadPosition();
    }

    @Override // r7b.c
    public final int c(Message r100) {
        return r100.getPosition();
    }

    @Override // r7b.c
    public final int d(MessageInfo r100) {
        return r100.getMessage().getBadgeCount();
    }

    @Override // r7b.c
    public final boolean k(MessageInfo r100) {
        if (d(r100) > e()) goto L5;
        return true;
    L5:
        return false;
    }

    public a(r7b.b<Chat> r100, InterfaceC7445a r101, b r102) {
        this.f536478a = r100;
        this.f536479b = r101;
        this.f536480c = r102;
    }
}
