package kya;

import com.bytedance.lark.pb.basic.v1.File;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends MessageParams<a, C6633a> {
    public final String A;
    public final RichText B;
    public final boolean C;
    public final boolean D;
    public final List<File> E;

    /* JADX INFO: renamed from: kya.a$a, reason: collision with other inner class name */
    public static final class C6633a extends MessageParams.a<a, C6633a> {
        public String A;
        public RichText B;
        public boolean C;
        public boolean D;
        public List<File> E;

        public final a b() {
            this.f415276h = Message.Type.POST;
            return new a(this);
        }

        public C6633a() {
            this.E = Collections.emptyList();
        }

        @Override // com.ss.android.lark.chat.entity.message.MessageParams.a
        public final /* bridge */ /* synthetic */ MessageParams a() {
            return b();
        }
    }

    public a(C6633a r100) {
        super(r100);
        this.A = r100.A;
        this.B = r100.B;
        this.C = r100.C;
        this.D = r100.D;
        this.E = r100.E;
    }

    @Override // com.ss.android.lark.chat.entity.message.MessageParams
    public final Message c(String r100, String r101) {
        Message r102 = b(r100, r101);
        r102.setType(Message.Type.POST);
        PostContent r103 = new PostContent();
        r103.setRichText(this.B);
        r103.setGroupAnnouncement(this.D);
        r103.setTitle(this.A);
        r103.setNotified(this.C);
        r103.setAttachments(this.E);
        r102.setMessageContent(r103);
        return r102;
    }
}
