package nc7;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.impl.c0;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class d extends c0<xa7.a> {
    @Override // com.bytedance.sdk.account.impl.c0
    public final void i(JSONObject r100, JSONObject r101) {
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void k(JSONObject r100, JSONObject r101) throws Exception {
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void h(ua7.b r100) {
        com.bytedance.sdk.account.monitor.c.g("passport_auth_get_state", null, null, (xa7.a) r100, this.f268956e);
    }

    public static d p(Context r110, ua7.a<xa7.a> r111) {
        String r100 = ta7.d.a("/passport/auth/get_state/");
        TextUtils.isEmpty(MonitorConstants.CONNECT_TYPE_GET);
        return new d(r110, new lb7.a(r100, MonitorConstants.CONNECT_TYPE_GET, null, null, null, null, false, 0), r111);
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final ua7.b n(boolean r100, lb7.b r101) {
        xa7.a r102 = new xa7.a(r100);
        if (r100 == false) goto L14;
        List<wqa.i> r103 = r101.f508373i;
        if (r103 != null) goto L7;
    L15:
        return r102;
    L7:
        if (r103.isEmpty() == true) goto L15;
        Iterator<wqa.i> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L15;
        wqa.i r105 = r104.next();
        if ("x-tt-passport-auth-state".equals(r105.f560775a) == false) goto L10;
        r102.f563067p = r105.f560776b;
        goto L15
    L14:
        r102.f549253g = r101.f508366b;
        r102.f549255i = r101.f508367c;
        goto L15
    }

    public d(Context r100, lb7.a r101, ua7.a<xa7.a> r102) {
        super(r100, r101, r102);
    }
}
