package com.bytedance.ee.bear.middleground.permission.apply;

import android.content.Context;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ ApplyPermissionPanel a;
    public final /* synthetic */ String b;

    public u(ApplyPermissionPanel r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        Throwable r9 = (Throwable) r8;
        boolean r2 = false;
        tt5.a.e("ApplyPermissionPanel", "request perm fail. ", r9, false);
        Context r0 = this.a.requireContext();
        Intrinsics.checkNotNull(r9);
        String r1 = this.a.m;
        String r3 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ownerName");
        r1 = null;
    L5:
        String r4 = this.a.j;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(ResourceData.KEY_TOKEN);
        r4 = null;
    L8:
        String r6 = this.a.k;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("module");
        r6 = null;
    L11:
        ui5.a.b(r0, r9, r1, r4, r6);
        ApplyPermissionPanel r10 = this.a;
        int r5 = r10.i;
        String r11 = r10.j;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException(ResourceData.KEY_TOKEN);
    L16:
        if (this.b.length() <= 0) goto L18;
        r2 = true;
    L18:
        PermissionAnalytic.g(r5, r3, "edit", r2);
        return;
    L14:
        r3 = r11;
        goto L16
    }
}
