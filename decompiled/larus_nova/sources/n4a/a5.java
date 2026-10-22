package n4a;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.loc.bo;

/* JADX INFO: loaded from: classes32.dex */
public abstract class a5 extends bo {
    public a5() {
    }

    @Override // com.loc.bo
    public String e() {
        if (TextUtils.isEmpty(c()) == true) goto L5;
        String r100 = c();
        Uri r101 = UriProtector.parse(r100);
        if (r101.getAuthority().startsWith("dualstack-") == false) goto L10;
        return r100;
    L10:
        if (r101.getAuthority().startsWith("restsdk.amap.com") == false) goto L14;
        Uri.Builder r102 = r101.buildUpon();
        String r103 = "dualstack-arestapi.amap.com";
    L13:
        return r102.authority(r103).build().toString();
    L14:
        r102 = r101.buildUpon();
        r103 = "dualstack-" + r101.getAuthority();
        goto L13
    L5:
        return c();
    }
}
