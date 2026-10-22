package pc7;

import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.impl.b0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f528537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ jb7.a.InterfaceC6411a f528538b;

    @Override // pc7.g
    public final void onFail() {
        ((b0) this.f528538b).a(false, false, null);
    }

    public b(Map r100, b0 r101) {
        this.f528537a = r100;
        this.f528538b = r101;
    }

    @Override // pc7.g
    public final void b(String r100, String r101, Map<String, String> r102, Map<String, Object> r103) {
        Map r104 = this.f528537a;
        if (r104 != null) goto L5;
    L11:
        ((b0) this.f528538b).a(true, true, r102);
        return;
    L5:
        if (r104.get("mix_mode") == null) goto L11;
        boolean r105 = "1".equals(this.f528537a.get("mix_mode"));
        HashMap r106 = (HashMap) r102;
        String r107 = (String) r106.get("sms_code_key");
        if (r105 == false) goto L11;
        if (TextUtils.isEmpty(r107) == true) goto L11;
        r106.put("sms_code_key", StringUtils.encryptWithXor(r107));
        goto L11
    }
}
