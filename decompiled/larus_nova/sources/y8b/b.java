package y8b;

import android.os.Handler;
import com.larus.nova.R;
import com.ss.android.lark.contact.base.common_ui.SearchEditText;
import com.ss.android.lark.utils.a1;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements SearchEditText.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f566933a = null;

    static {
        f566933a = new b();
    }

    public b() {
    }

    @Override // com.ss.android.lark.contact.base.common_ui.SearchEditText.b
    public final void h(String r100) {
        boolean r101 = a1.f444690f;
        Handler r102 = a1.a.f444696a.f444691a;
        r102.sendMessage(r102.obtainMessage(R.id.UiMessageExternalContactSearch, r100));
    }
}
