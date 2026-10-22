package com.ss.android.lark.biz.im.api;

import com.bytedance.lark.pb.basic.v1.File;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class j1 extends MessageParams<j1, a> {
    public final RichText A;
    public final boolean B;
    public final List<File> C;

    public static final class a extends MessageParams.a<j1, a> {
        public RichText A;
        public boolean B;
        public List<File> C;

        public final j1 b() {
            this.f415276h = Message.Type.TEXT;
            return new j1(this);
        }

        public a() {
            this.C = Collections.emptyList();
        }

        @Override // com.ss.android.lark.chat.entity.message.MessageParams.a
        public final /* bridge */ /* synthetic */ MessageParams a() {
            return b();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f410258a;

        public b() {
            this.f410258a = true;
        }
    }

    public j1(a r100) {
        super(r100);
        this.A = r100.A;
        this.B = r100.B;
        this.C = r100.C;
    }

    @Override // com.ss.android.lark.chat.entity.message.MessageParams
    public final Message c(String r100, String r101) {
        Message r102 = b(r100, r101);
        r102.setType(Message.Type.TEXT);
        TextContent r103 = new TextContent();
        r103.setRichText(this.A);
        r103.setAttachments(this.C);
        r102.setMessageContent(r103);
        if (this.B == false) goto L5;
        r102.putExtra(b.class, new b());
    L5:
        return r102;
    }
}
