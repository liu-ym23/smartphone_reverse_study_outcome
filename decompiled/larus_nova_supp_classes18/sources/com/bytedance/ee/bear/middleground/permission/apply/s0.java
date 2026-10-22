package com.bytedance.ee.bear.middleground.permission.apply;

import android.text.Editable;
import android.view.View;
import com.bytedance.ee.bear.bitable.pro.applypro.BitableApplyProFetcher;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.larksuite.framework.utils.KeyboardUtils;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s0 extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ OfficeBitableApplyPermissionFragment c;

    public s0(OfficeBitableApplyPermissionFragment r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r5) {
        OfficeBitableApplyPermissionFragment r6 = this.c;
        SpaceEditText r0 = r6.k;
        BitableApplyProFetcher r1 = null;
        if (r0 == null) goto L7;
        Editable r2 = r0.getText();
        if (r2 == null) goto L7;
        String r3 = r2.toString();
    L8:
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        if (r3.length() > 300) goto L27;
        UDEditText r4 = r6.k;
        if (r4 == null) goto L17;
        r4.clearFocus();
        KeyboardUtils.hideKeyboard(r4.getContext(), r4);
    L17:
        boolean r7 = true;
        r6.setLoading(true);
        int r8 = com.bytedance.ee.bear.bitable.pro.d.a;
        if (r3.length() > 0) goto L21;
        r7 = false;
    L21:
        com.bytedance.ee.bear.bitable.pro.d.a(r7);
        CompositeDisposable r9 = r6.g;
        BitableApplyProFetcher r10 = r6.f;
        if (r10 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("fetcher");
    L25:
        r9.add(r1.a(r3).subscribe(new z0(r6), new a1(r6)));
        return;
    L24:
        r1 = r10;
        goto L25
    L27:
        return;
    L7:
        r3 = null;
        goto L8
    }
}
