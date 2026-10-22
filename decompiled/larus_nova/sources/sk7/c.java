package sk7;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.luckydog.api.log.d;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.appdownloader.util.RomUtils;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements a.InterfaceC7625a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f542426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f542427b;

    @Override // sk7.a.InterfaceC7625a
    public final void onFail(String r100) {
        boolean r101 = a.f542422a;
        d.d("LuckyMarketUtils", r100);
        d.d("LuckyMarketUtils", "getXiaomiMarketSchema, jump default market schema");
        String r102 = BaseConstants.MARKET_PREFIX + this.f542427b;
        Intent r103 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r103.setData(UriProtector.parse(r102));
        r103.addFlags(268435456);
        this.f542426a.startActivity(r103);
    }

    @Override // sk7.a.InterfaceC7625a
    public final void onSuccess(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L18;
        boolean r101 = a.f542422a;
        d.d("LuckyMarketUtils", "getXiaomiMarketSchema success, schema: " + r100);
    L9:
        th = move-exception;
        d.c("LuckyMarketUtils", th.getLocalizedMessage(), th);
    L11:
        Intent r102 = null;
    L12:
        if (r102 == null) goto L14;
        this.f542426a.startActivity(r102);
        return;
    L14:
        onFail("get intent error");
        return;
    L6:
        if (a.a(this.f542426a) == false) goto L11;
        r102 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Throwable -> L9
        r102.setData(UriProtector.parse(r100));     // Catch: Throwable -> L9
        r102.setPackage(RomUtils.MARKET_PKG_NAME_MIUI);     // Catch: Throwable -> L9
        r102.addFlags(268435456);     // Catch: Throwable -> L9
        goto L12
    }

    public c(Context r100, String r101) {
        this.f542426a = r100;
        this.f542427b = r101;
    }
}
