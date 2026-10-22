package lsc;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;

/* JADX INFO: loaded from: classes41.dex */
public final class e implements d {
    public e() {
    }

    @Override // lsc.d
    public final void d(View r100, String r101) {
        Uri r102 = UriProtector.parse(r101);
        if (TextUtils.isEmpty(r102.getScheme()) == false) goto L5;
        r102 = r102.buildUpon().scheme("https").build();
    L5:
        Context r103 = r100.getContext();
        Intent r104 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, r102);
        r104.putExtra("com.android.browser.application_id", r103.getPackageName());
        r103.startActivity(r104);     // Catch: ActivityNotFoundException -> L8
        return;
    }
}
