package s3b;

import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: classes35.dex */
public final class d extends com.ss.android.lark.chatbase.model.c.b<f5b.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f540509a;

    public d(Message r100) {
        this.f540509a = r100;
    }

    @Override // com.ss.android.lark.chatbase.model.c.b
    public final f5b.b b(Object r100) {
        f5b.b r101 = (f5b.b) r100;
        r101.setMessage(this.f540509a);
        return r101;
    }
}
