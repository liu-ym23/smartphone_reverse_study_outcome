package pl5;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.ee.bear.quoto.SingleFileQuotaConfig;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f529759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SingleFileQuotaConfig f529760b;

    public a(Intent r100) {
        Bundle r101 = r100.getExtras();
        if (r101 == null) goto L6;
        this.f529759a = Long.valueOf(r101.getLong("key_file_size"));
        this.f529760b = (SingleFileQuotaConfig) r101.getParcelable("key_quota_config");
        return;
    }
}
