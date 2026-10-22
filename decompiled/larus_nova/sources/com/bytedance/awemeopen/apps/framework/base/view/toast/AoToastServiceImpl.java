package com.bytedance.awemeopen.apps.framework.base.view.toast;

import android.content.Context;
import com.bytedance.awemeopen.servicesapi.toast.AoToastService;
import kotlin.Metadata;
import zx3.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/toast/AoToastServiceImpl;", "Lcom/bytedance/awemeopen/servicesapi/toast/AoToastService;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class AoToastServiceImpl implements AoToastService {
    public AoToastServiceImpl() {
    }

    @Override // com.bytedance.awemeopen.servicesapi.toast.AoToastService
    public final void showToast(Context r100, String r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L6;
        return;
    L6:
        new a(r100, r101).d();
    }

    @Override // com.bytedance.awemeopen.servicesapi.toast.AoToastService
    public final void G1(Context r100, String r101, int r102, int r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L6;
        return;
    L6:
        a r104 = new a(r100, r101);
        r104.f573878a = r103;
        r104.d();
    }
}
