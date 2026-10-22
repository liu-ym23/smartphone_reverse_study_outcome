package qob;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import com.ss.android.lark.widget.richtext.RichText;

/* JADX INFO: loaded from: classes36.dex */
public interface a {
    Message a(m5b.d r100);

    void b(m5b.d r100);

    PartialReplyInfo c();

    String d();

    Message e(String r100, String r101, String r102, String r103, com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r104);

    com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo f();

    void g(m5b.d r100);

    String getChatId();

    String h();

    void i();

    void j(Message r100, String r101, String r102, String r103);

    String k();

    MonitorMessageSendCallback l(String r100, String r101, int r102);

    void m(String r100);

    com.ss.android.lark.keyboard.b n();

    void o(String r100, String r101, String r102, RichText r103);

    void p(Message r100, String r101);
}
