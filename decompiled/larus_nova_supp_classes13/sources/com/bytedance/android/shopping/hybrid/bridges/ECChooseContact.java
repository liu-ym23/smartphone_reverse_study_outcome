package com.bytedance.android.shopping.hybrid.bridges;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.common.utility.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/hybrid/bridges/ECChooseContact;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "Lpd/a;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECChooseContact extends ECBaseBridgeMethod implements pd.a {
    public Fragment e;
    public final String f;

    public final void release() {
        this.e = null;
    }

    public ECChooseContact() {
        com.bytedance.android.ec.sdk.helper.d.b.getIECContactService();
        this.f = "ecChooseContact";
    }

    public final String getName() {
        return this.f;
    }

    public final void setFragment(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.e = r2;
    }

    public final void c(JSONObject r2, ECBaseBridgeMethod.a r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "iReturn");
        if (this.e == null) goto L10;
        boolean r4 = true;
        if (r2.optInt("skipPermissionRequest") == 1) goto L8;
        r4 = false;
    L8:
        Logger.i("contacts_log", "call jsb ecChooseContact, skipPermissionRequest " + r4);
        return;
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        getContext();
    }
}
