package pl5;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.ee.bear.quoto.SingleFileQuotaConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final Long a;
    public final SingleFileQuotaConfig b;

    public a(Intent r3) {
        Bundle r4 = r3.getExtras();
        if (r4 == null) goto L6;
        this.a = Long.valueOf(r4.getLong("key_file_size"));
        this.b = (SingleFileQuotaConfig) r4.getParcelable("key_quota_config");
        return;
    }
}
