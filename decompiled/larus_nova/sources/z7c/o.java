package z7c;

import android.text.Editable;
import com.ss.android.lark.utils.q0;

/* JADX INFO: loaded from: classes38.dex */
public final class o extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f570798a;

    public o(m r100) {
        this.f570798a = r100;
    }

    @Override // com.ss.android.lark.utils.q0, android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        m r101 = this.f570798a;
        if (r100 == null) goto L6;
        String r102 = r100.toString();
        if (r102 == null) goto L6;
    L7:
        r101.f570794i = r102;
        m r103 = this.f570798a;
        r103.b(r103.f570786a, r103.f570787b);
        return;
    L6:
        r102 = "";
        goto L7
    }
}
