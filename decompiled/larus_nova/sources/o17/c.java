package o17;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f.a f521712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, List<String>> f521713b;

    public c() {
    }

    public final void a(f r100) {
        if (r100.f521720b != null) goto L5;
    L9:
        f.a r101 = this.f521712a;
        if (r101 == null) goto L15;
        r101.a(r100);
        return;
    L15:
        return;
    L5:
        if (TextUtils.equals("200", r100.f521719a) == false) goto L9;
        f.a r102 = this.f521712a;
        if (r102 == null) goto L13;
        r100.f521723e = this.f521713b;
        r102.b(r100);
        return;
    }
}
