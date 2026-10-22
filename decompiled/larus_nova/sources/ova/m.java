package ova;

import android.content.Context;
import android.content.Intent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes34.dex */
public final class m implements b {
    @Inject
    public m() {
    }

    @Override // ova.b
    public final void a(Context r100, String r101) {
        Intent r102 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r101));
        r102.setFlags(268435456);
        r100.startActivity(r102);
    }
}
