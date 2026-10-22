package s3b;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.AudioContent;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends com.ss.android.lark.chatbase.model.c.b<f5b.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioContent.AudioState f540505a;

    public a(AudioContent.AudioState r100) {
        this.f540505a = r100;
    }

    @Override // com.ss.android.lark.chatbase.model.c.b
    public final f5b.b b(Object r100) {
        f5b.b r101 = (f5b.b) r100;
        Message r102 = r101.getMessage();
        if (r102.getType() == Message.Type.AUDIO) goto L5;
    L10:
        return r101;
    L5:
        if (r102.getContent() == null) goto L10;
        if (this.f540505a == null) goto L10;
        ((AudioContent) r102.getContent()).setFileState(this.f540505a);
        goto L10
    }
}
