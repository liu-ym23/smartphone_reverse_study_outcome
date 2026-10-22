package w4b;

import com.bytedance.lark.pb.basic.v1.FeedCard;
import com.ss.android.lark.feed.app.entity.UpdateUnreadStatusScene;

/* JADX INFO: loaded from: classes35.dex */
public interface m {
    void a(com.ss.android.lark.chat.chatwindow.chat.v2.push.c.b r100);

    void b(String r100, FeedCard.EntityType r101, boolean r102, UpdateUnreadStatusScene r103);

    void c(com.ss.android.lark.chat.chatwindow.chat.v2.push.c.b r100);

    void d();

    void e();

    void f(Long r100, Long r101);

    void g();

    int getBadge();
}
