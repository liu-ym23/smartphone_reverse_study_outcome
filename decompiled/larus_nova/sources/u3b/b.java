package u3b;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f548621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f548622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f548623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f548624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final fxa.b f548625e;

    @Override // u3b.a
    public final String a() {
        return "ChatDataPreLoadTask_uniqueId:" + this.f548621a;
    }

    public b(fxa.b r100) {
        this.f548625e = r100;
        this.f548622b = r100.getChatId();
        this.f548623c = r100.getMessageId();
        String r101 = r100.b();
        this.f548624d = r101;
        r100.o();
        r100.isSecretChat();
        if (TextUtils.isEmpty(this.f548622b) == true) goto L5;
        r101 = this.f548622b;
    L5:
        this.f548621a = r101;
    }
}
