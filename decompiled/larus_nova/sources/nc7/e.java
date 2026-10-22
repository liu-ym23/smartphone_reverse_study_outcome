package nc7;

import android.content.Context;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.sdk.account.impl.c0;
import com.bytedance.sdk.account.impl.w;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class e extends c0<xa7.h> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f518648l = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public xa7.h f518649k;

    @Override // com.bytedance.sdk.account.impl.c0
    public final void h(ua7.b r100) {
        com.bytedance.sdk.account.monitor.c.g("passport_open_token_info", null, null, (xa7.h) r100, this.f268956e);
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void i(JSONObject r100, JSONObject r101) {
        xa7.h r102 = new xa7.h(false);
        this.f518649k = r102;
        r102.f549259m = r101;
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void k(JSONObject r100, JSONObject r101) throws Exception {
        xa7.h r102 = new xa7.h(true);
        this.f518649k = r102;
        r102.f549259m = r100;
        if (r101 == null) goto L15;
        r101.optString("client_key");
        xa7.h r103 = this.f518649k;
        r101.optString(Constants.JumpUrlConstants.URL_KEY_OPENID);
        r103.getClass();
        JSONArray r104 = r101.optJSONArray(ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE);
        if (r104 != null) goto L7;
        return;
    L7:
        if (r104.length() <= 0) goto L17;
        ArrayList r105 = new ArrayList();
        int r106 = 0;
    L10:
        if (r106 >= r104.length()) goto L12;
        r105.add(JSONArrayProtectorUtils.getString(r104, r106));
        r106 = r106 + 1;
        goto L10
    L12:
        this.f518649k.getClass();
        return;
    L17:
        return;
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final ua7.b n(boolean r100, lb7.b r101) {
        if (this.f518649k != null) goto L5;
        this.f518649k = new xa7.h(r100);
    L5:
        xa7.h r102 = this.f518649k;
        r102.f549253g = r101.f508366b;
        r102.f549255i = r101.f508367c;
        return r102;
    }

    public e(Context r100, lb7.a r101, w r102) {
        super(r100, r101, r102);
    }
}
