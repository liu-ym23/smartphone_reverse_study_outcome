package v62;

import android.text.Editable;
import com.bytedance.android.live.core.utils.d2;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jf2.a f553389a;

    public c(jf2.a r100) {
        this.f553389a = r100;
    }

    @Override // com.bytedance.android.live.core.utils.d2, android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        jf2.a r101 = this.f553389a;
        if (r100 == null) goto L5;
        String r102 = r100.toString();
    L6:
        r101.a(r102);
        return;
    L5:
        r102 = null;
        goto L6
    }
}
