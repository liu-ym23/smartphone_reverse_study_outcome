package xb7;

import android.content.Context;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.sdk.account.impl.c0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class d extends c0<ua7.d> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f563136l = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<String> f563137k;

    @Override // com.bytedance.sdk.account.impl.c0
    public final void i(JSONObject r100, JSONObject r101) {
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void h(ua7.b r100) {
        com.bytedance.sdk.account.monitor.c.g("passport_logout_others", null, null, (ua7.d) r100, this.f268956e);
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void k(JSONObject r100, JSONObject r101) throws Exception {
        JSONArray r102 = r101.optJSONArray("logout_user_ids");
        if (r102 == null) goto L7;
        int r103 = r102.length();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L9;
        String r105 = JSONArrayProtectorUtils.getString(r102, r104);
        ((ArrayList) this.f563137k).add(r105);
        r104 = r104 + 1;
        goto L5
    L9:
        return;
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final ua7.b n(boolean r100, lb7.b r101) {
        ua7.d r102 = new ua7.d(r100);
        if (r100 == false) goto L5;
        r102.f549263p = this.f563137k;
    L6:
        return r102;
    L5:
        r102.f549253g = r101.f508366b;
        r102.f549255i = r101.f508367c;
        goto L6
    }

    public d(Context r100, lb7.a r101, sa7.c r102) {
        super(r100, r101, r102);
        this.f563137k = new ArrayList();
    }
}
