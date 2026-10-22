package com.bytedance.awemeopen.apps.framework.base.view.toast;

import android.content.Context;
import com.bytedance.awemeopen.servicesapi.toast.AoToastService;
import kotlin.Metadata;
import zx3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/toast/AoToastServiceImpl;", "Lcom/bytedance/awemeopen/servicesapi/toast/AoToastService;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class AoToastServiceImpl implements AoToastService {
    public AoToastServiceImpl() {
    }

    public final void showToast(Context r1, String r2, int r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r2 != null) goto L6;
        return;
    L6:
        new a(r1, r2).d();
    }

    public final void G1(Context r1, String r2, int r3, int r4) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r2 != null) goto L6;
        return;
    L6:
        a r5 = new a(r1, r2);
        r5.a = r4;
        r5.d();
    }
}
