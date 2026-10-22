package jtb;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements itb.d {
    public c() {
    }

    @Override // itb.d
    public final int H1(int r100, boolean r101, Integer r102) {
        itb.d r103 = (itb.d) OfficeSDKManager.getHostGlobalService(itb.d.class);
        if (r103 != null) goto L5;
        return r100;
    L5:
        return r103.H1(r100, r101, r102);
    }

    @Override // itb.d
    public final float v0(float r100, boolean r101, Float r102) {
        itb.d r103 = (itb.d) OfficeSDKManager.getHostGlobalService(itb.d.class);
        if (r103 != null) goto L5;
        return r100;
    L5:
        return r103.v0(r100, r101, r102);
    }
}
