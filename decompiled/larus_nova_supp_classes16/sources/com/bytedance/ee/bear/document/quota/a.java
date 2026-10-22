package com.bytedance.ee.bear.document.quota;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ ShowQuotaBannerPlugin a;
    public final /* synthetic */ long b;
    public final /* synthetic */ boolean c;

    public a(ShowQuotaBannerPlugin r1, long r2, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r8) {
        Boolean r9 = (Boolean) r8;
        Intrinsics.checkNotNullParameter(this.a, "<this>");
        long r1 = 0;
        r1 = new JSONObject((String) c.a.a.d("ccm_platform_tenant_quota_oversize_limit_transition_dead_line", "")).optLong("time", 0);     // Catch: Throwable -> L5
    L7:
        if (Math.abs((this.b * ((long) UploadResult.UPLOAD_CACELL)) - System.currentTimeMillis()) < 60000) goto L9;
        return;
    L9:
        if (this.c == true) goto L11;
        return;
    L11:
        if (r9.booleanValue() == true) goto L13;
        return;
    L13:
        if (System.currentTimeMillis() >= r1) goto L21;
        ShowQuotaBannerPlugin.access$showQuotaBanner(this.a, r1);
        return;
    }
}
