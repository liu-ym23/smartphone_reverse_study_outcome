package ymb;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements qza.a {
    public a() {
    }

    @Override // qza.a
    public final boolean Q() {
        qza.a r100 = (qza.a) OfficeSDKManager.getHostGlobalService(qza.a.class);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.Q();
    }

    @Override // qza.a
    public final boolean m() {
        qza.a r100 = (qza.a) OfficeSDKManager.getHostGlobalService(qza.a.class);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.m();
    }

    @Override // qza.a
    public final boolean n() {
        qza.a r100 = (qza.a) OfficeSDKManager.getHostGlobalService(qza.a.class);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.n();
    }
}
