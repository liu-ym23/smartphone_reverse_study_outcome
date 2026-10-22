package com.huawei.hms.hwid;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.android.ec.slice.SliceInitService;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.account.result.AccountIcon;
import com.huawei.hms.support.account.result.GetChannelResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.tencent.open.SocialConstants;
import org.json.JSONException;

/* JADX INFO: loaded from: classes23.dex */
public class i extends TaskApiCall<c, AccountIcon> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f277511a;

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 10;
    }

    private Bitmap a(String r100) {
        byte[] r101 = Base64.decode(r100, 0);     // Catch: Exception -> L5 OutOfMemoryError -> L7
    L12:
        return BitmapFactory.decodeByteArray(r101, 0, r101.length);
    L5:
        e = move-exception;
        as.d("[AccountSDK]AccountGetChannelTaskApiCall", "stringToBitmap Exception is ".concat(e.getClass().getSimpleName()), true);
    L8:
        return null;
    L7:
        as.d("[AccountSDK]AccountGetChannelTaskApiCall", "out of memory error ", true);
        goto L8
    }

    public i(String r100, String r101, String r102, Context r103) {
        super(r100, r101, r102);
        this.f277511a = r103;
    }

    public void a(c r100, ResponseErrorCode r101, String r110, TaskCompletionSource<AccountIcon> r111) {
        if (r101 != null) goto L6;
        as.b("[AccountSDK]AccountGetChannelTaskApiCall", "response is null.", true);
        r111.setException(new ApiException(new Status(2003, "response is null.")));
        return;
    L6:
        int r102 = r101.getErrorCode();
        if (r102 != 0) goto L9;
    L12:
        as.b("[AccountSDK]AccountGetChannelTaskApiCall", "ResponseErrorCode.status:" + r101.getErrorCode(), true);
        AccountIcon r103 = new AccountIcon();
        if (TextUtils.isEmpty(r110) == false) goto L15;
        as.b("[AccountSDK]AccountGetChannelTaskApiCall", "getChannel complete, response is null, failed", true);
        r111.setException(new ApiException(new Status(r102, r101.getErrorReason())));
        return;
    L15:
        if (SliceInitService.DEFAULT_SWITCH.equals(r110) == false) goto L27;
        as.b("[AccountSDK]AccountGetChannelTaskApiCall", "getChannel complete, body is null", true);
        r111.setException(new ApiException(new Status(r101.getErrorCode(), r101.getErrorReason())));
        return;
    L27:
        GetChannelResult r112 = new GetChannelResult().fromJson(r110);     // Catch: JSONException -> L23
        if (r112.isSuccess() == false) goto L21;
        as.b("[AccountSDK]AccountGetChannelTaskApiCall", "getChannel success", true);     // Catch: JSONException -> L23
        r103.setDescription(r112.getDescription());     // Catch: JSONException -> L23
        r103.setIcon(a(r112.getIcon()));     // Catch: JSONException -> L23
        r111.setResult(r103);     // Catch: JSONException -> L23
        long r104 = ao.a();     // Catch: JSONException -> L23
        SharedPreferences.Editor r105 = this.f277511a.getSharedPreferences("ACCOUNT_CHANNEL_CACHE", 0).edit();     // Catch: JSONException -> L23
        r105.putLong("cache_time", r104);     // Catch: JSONException -> L23
        r105.putString(SocialConstants.PARAM_APP_DESC, r112.getDescription());     // Catch: JSONException -> L23
        r105.putString("icon", r112.getIcon());     // Catch: JSONException -> L23
        r105.apply();     // Catch: JSONException -> L23
    L26:
        return;
    L21:
        as.b("[AccountSDK]AccountGetChannelTaskApiCall", "getChannel failed", true);     // Catch: JSONException -> L23
        r111.setException(new ApiException(r112.getStatus()));     // Catch: JSONException -> L23
    L23:
        as.c("[AccountSDK]AccountGetChannelTaskApiCall", "getChannel complete, but parser json exception", true);
        r111.setException(new ApiException(new Status(r102, r101.getErrorReason())));
        return;
    L9:
        if (CommonCode.Resolution.HAS_RESOLUTION.equals(r101.getResolution()) == false) goto L12;
        as.b("[AccountSDK]AccountGetChannelTaskApiCall", "apk version is low or is not exist.", true);
        Status r106 = new Status(r102, r101.getErrorReason());
        ao.a(r101, r106);
        r111.setException(new ResolvableApiException(r106));
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* synthetic */ void doExecute(AnyClient r100, ResponseErrorCode r101, String r102, TaskCompletionSource<AccountIcon> r103) {
        a((c) r100, r101, r102, r103);
    }
}
