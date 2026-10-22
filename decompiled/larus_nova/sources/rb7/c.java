package rb7;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.impl.c0;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends c0<xa7.c> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f536945n = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public JSONObject f536946k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public JSONObject f536947l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.ss.android.account.d f536948m;

    @Override // com.bytedance.sdk.account.impl.c0
    public final void h(ua7.b r100) {
        xa7.c r101 = (xa7.c) r100;
        if (TextUtils.isEmpty(r101.f549250d) == false) goto L5;
        return;
    L5:
        if (r101.f549250d.contains("/passport/token/beat/v2/") == false) goto L7;
        return;
    L7:
        if (r101.f549250d.contains("/passport/account/info/v2/") == true) goto L12;
        com.bytedance.sdk.account.monitor.c.g("passport_sdk_common_request", null, null, r101, this.f268956e);
        return;
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void i(JSONObject r100, JSONObject r101) {
        this.f536946k = r101;
        this.f536947l = r100;
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void k(JSONObject r100, JSONObject r101) throws Exception {
        this.f536946k = r100;
        this.f536947l = r101;
        boolean r102 = false;
        if (r101.optLong("user_id", 0) <= 0) goto L5;
        boolean r103 = true;
    L6:
        com.bytedance.sdk.account.settings.common.a.a();
        int r104 = com.bytedance.sdk.account.settings.common.a.f269401y;
        if (r103 == true) goto L9;
    L16:
        if (r103 == true) goto L18;
    L20:
        if (r103 == false) goto L23;
        com.ss.android.account.d r105 = new com.ss.android.account.d(r100);
        r105.a();
        this.f536948m = r105;
        return;
    L23:
        return;
    L18:
        if ((r104 & 2) == 0) goto L20;
        r103 = !TextUtils.isEmpty(this.f268954c.f508372h);
        goto L20
    L9:
        if ((r104 & 1) == 0) goto L16;
        if (TextUtils.isEmpty(this.f268953b.f508352a) == false) goto L13;
    L15:
        r103 = r102;
        goto L16
    L13:
        if (this.f268953b.f508352a.contains("/passport/") == false) goto L15;
        r102 = true;
        goto L15
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final ua7.b n(boolean r100, lb7.b r101) {
        xa7.c r102 = new xa7.c(r100);
        if (r100 == true) goto L5;
        r102.f549253g = r101.f508366b;
        r102.f549255i = r101.f508367c;
    L6:
        r102.f549259m = this.f536946k;
        r102.f563072z = this.f536947l;
        if (r100 == false) goto L9;
        r101.f508365a.getClass();
    L9:
        return r102;
    L5:
        r102.f549279p = this.f536948m;
        goto L6
    }

    public c(Context r100, lb7.a r101, ua7.a<xa7.c> r102) {
        super(r100, r101, r102);
    }

    public static lb7.a p(String r100, Map<String, String> r101, Map<String, String> r102, boolean r103) {
        lb7.a.C6671a r104 = new lb7.a.C6671a();
        r104.f508360a = r100;
        if (r101 != null) goto L5;
    L14:
        r104.f(r102);
        if (r103 == false) goto L19;
        r104.f508361b = MonitorConstants.CONNECT_TYPE_GET;
        return r104.c();
    L19:
        return r104.h();
    L5:
        if (r101.isEmpty() == true) goto L14;
        if (r104.f508363d != null) goto L10;
        r104.f508363d = new ArrayList();
    L10:
        Iterator<Map.Entry<String, String>> r105 = r101.entrySet().iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        Map.Entry<String, String> r106 = r105.next();
        r104.f508363d.add(new wqa.i(r106.getKey(), r106.getValue()));
        goto L12
    }
}
