package l84;

import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.service.BDLocationExtrasService;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static e0 f507940b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseLocate f507941a;

    public e0() {
        this.f507941a = BDLocationExtrasService.getLocate(BDLocationConfig.getContext(), 3);
    }

    public final BaseLocate a(int r100) {
        if (BDLocationConfig.isMockEnable() == false) goto L7;
        return BDLocationExtrasService.getLocate(BDLocationConfig.getContext(), 4);
    L7:
        if (r100 != 3) goto L9;
        BaseLocate r101 = this.f507941a;
    L10:
        if (r101 == null) goto L12;
        return r101;
    L12:
        return BDLocationExtrasService.getLocate(BDLocationConfig.getContext(), r100);
    L9:
        r101 = null;
        goto L10
    }
}
