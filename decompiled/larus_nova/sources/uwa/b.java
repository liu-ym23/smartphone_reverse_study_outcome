package uwa;

import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.utils.v;
import java.util.Locale;
import yob.e;

/* JADX INFO: loaded from: classes34.dex */
public class b extends d {
    public b() {
    }

    @Override // uwa.d, uwa.a.InterfaceC7940a
    public Context injectBaseContext(Context r100) {
        e.a().getClass();
        int r101 = com.ss.android.lark.language.service.impl.a.f431092f;
        return com.ss.android.lark.language.service.impl.a.b.f431098a.i(r100, new Locale("zh", "cn"));
    }

    @Override // uwa.d, uwa.a.InterfaceC7940a
    public Intent injectGetIntent(Intent r100) {
        return v.a(r100);
    }
}
