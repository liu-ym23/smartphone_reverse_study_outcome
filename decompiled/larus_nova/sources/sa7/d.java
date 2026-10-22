package sa7;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class d extends va7.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ua7.a f541184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f541185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f541186c;

    @Override // sa7.h
    public final void onSuccess(ua7.b r100) {
        this.f541184a.onResponse(new ua7.f((xa7.j) r100, "switch", this.f541186c.f541187a));
    }

    @Override // sa7.h
    public final void onError(ua7.b r100, int r101) {
        ua7.f r102 = new ua7.f((xa7.j) r100, "switch", this.f541186c.f541187a);
        if (TextUtils.isEmpty(r102.f549266r) == true) goto L5;
        e r103 = this.f541186c;
        String r104 = r102.f549266r;
        Map<String, String> r105 = this.f541185b;
        ua7.a r106 = this.f541184a;
        r103.f541190d.h(r104, r105, new d(r103, r106, r105));
        return;
    L5:
        this.f541184a.onResponse(r102);
    }

    public d(e r100, ua7.a r101, Map r102) {
        this.f541186c = r100;
        this.f541184a = r101;
        this.f541185b = r102;
    }
}
