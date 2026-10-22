package w3b;

import android.text.TextUtils;
import com.larksuite.framework.utils.l0;
import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.DataPreLoaderType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements d<i7b.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fxa.b f558210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f558211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f558212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f558213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f558214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final fxa.b f558215f;

    /* JADX INFO: renamed from: w3b.a$a, reason: collision with other inner class name */
    public static final class C8064a {
    }

    static {
    }

    @Override // w3b.d
    public final DataPreLoaderType type() {
        return DataPreLoaderType.CHAT_DATA;
    }

    public a(fxa.b r100) {
        Intrinsics.checkNotNullParameter(r100, "chatBundle");
        this.f558210a = r100;
        this.f558212c = r100.getChatId();
        this.f558213d = r100.getMessageId();
        String r101 = r100.b();
        this.f558214e = r101;
        r100.o();
        r100.isSecretChat();
        this.f558215f = r100;
        if (TextUtils.isEmpty(this.f558212c) == true) goto L5;
        r101 = this.f558212c;
    L5:
        if (r101 != null) goto L7;
        r101 = l0.a().toString();
    L7:
        this.f558211b = r101;
    }
}
