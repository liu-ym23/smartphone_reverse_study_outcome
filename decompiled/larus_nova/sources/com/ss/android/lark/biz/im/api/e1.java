package com.ss.android.lark.biz.im.api;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.content.ProfileContent;

/* JADX INFO: loaded from: classes34.dex */
public final class e1 extends MessageParams<e1, a> {
    public final String A;
    public final String B;
    public final String C;

    public static final class a extends MessageParams.a<e1, a> {
        public String A;
        public String B;
        public String C;

        @Override // com.ss.android.lark.chat.entity.message.MessageParams.a
        public final MessageParams a() {
            this.f415276h = Message.Type.SHARE_USER_CARD;
            return new e1(this);
        }

        public a() {
        }
    }

    public e1(a r100) {
        super(r100);
        this.A = r100.A;
        this.B = r100.B;
        this.C = r100.C;
    }

    @Override // com.ss.android.lark.chat.entity.message.MessageParams
    public final Message c(String r100, String r101) {
        Message r102 = b(r100, r101);
        r102.setType(Message.Type.SHARE_USER_CARD);
        ProfileContent r103 = new ProfileContent();
        r103.setId(this.A);
        r103.setAvatarKey(this.B);
        r103.setDisplayName(this.C);
        r102.setMessageContent(r103);
        return r102;
    }
}
