package h5b;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.chat.entity.sticker.StickerFileInfo;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends MessageParams<b, a> {
    public final StickerFileInfo A;

    public static final class a extends MessageParams.a<b, a> {
        public StickerFileInfo A;

        @Override // com.ss.android.lark.chat.entity.message.MessageParams.a
        public final MessageParams a() {
            this.f415276h = Message.Type.STICKER;
            return new b(this);
        }

        public a() {
        }
    }

    public b(a r100) {
        super(r100);
        this.A = r100.A;
    }

    @Override // com.ss.android.lark.chat.entity.message.MessageParams
    public final Message c(String r100, String r101) {
        Message r102 = b(r100, r101);
        r102.setType(Message.Type.STICKER);
        StickerContent r103 = new StickerContent();
        r103.setKey(this.A.key);
        r103.setWidth(this.A.width);
        r103.setHeight(this.A.height);
        r103.setStickerSetId(this.A.stickerSetId);
        r103.setStickerId(this.A.stickerId);
        r102.setMessageContent(r103);
        return r102;
    }
}
