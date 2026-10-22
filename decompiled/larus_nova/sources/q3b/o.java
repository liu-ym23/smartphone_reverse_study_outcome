package q3b;

import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: classes35.dex */
public final class o implements hya.b<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f531587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f531588b;

    @Override // hya.b
    public final String a() {
        return this.f531587a;
    }

    @Override // hya.b
    public final String b() {
        return this.f531588b;
    }

    public o(Message r100) {
        this.f531587a = r100.getId();
        if (r100.isPreMessage() == false) goto L5;
        String r101 = null;
    L6:
        this.f531588b = r101;
        return;
    L5:
        r101 = r100.getcId();
        goto L6
    }
}
