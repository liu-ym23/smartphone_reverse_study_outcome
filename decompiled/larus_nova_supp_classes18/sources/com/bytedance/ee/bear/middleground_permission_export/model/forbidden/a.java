package com.bytedance.ee.bear.middleground_permission_export.model.forbidden;

import android.content.Context;
import android.net.Uri;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a {
    String a(String r1, int r2, boolean r3);

    void b(Context r1);

    String c();

    Flowable<GetComplaintResult> d(int r1, String r2, boolean r3);

    Uri.Builder getReportHost();
}
