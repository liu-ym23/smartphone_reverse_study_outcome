package jtb;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements itb.a {
    public a() {
    }

    @Override // itb.a
    public final String i() {
        itb.a r100 = (itb.a) OfficeSDKManager.getHostGlobalService(itb.a.class);
        if (r100 == null) goto L6;
        String r101 = r100.i();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // itb.a
    public final boolean i1() {
        itb.a r100 = (itb.a) OfficeSDKManager.getHostGlobalService(itb.a.class);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.i1();
    }
}
