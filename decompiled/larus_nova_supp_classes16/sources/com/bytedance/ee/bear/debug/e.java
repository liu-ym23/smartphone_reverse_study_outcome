package com.bytedance.ee.bear.debug;

import android.content.SharedPreferences;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ AppendParamsActivity a;

    public e(AppendParamsActivity r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r7v9, types: [android.content.Context, com.bytedance.ee.bear.debug.AppendParamsActivity] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        SharedPreferences r8 = this.a.g;
        String r1 = null;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("appendParamsSP");
        r8 = null;
    L5:
        r8.edit().clear().apply();
        Iterator<AppendParamsActivity.b> r9 = this.a.j.iterator();
    L7:
        if (r9.hasNext() == false) goto L22;
        AppendParamsActivity.b r2 = r9.next();
        boolean r4 = true;
        if (r2.a.length() <= 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L7;
        if (r2.b.length() > 0) goto L17;
        r4 = false;
    L17:
        if (r4 == false) goto L7;
        SharedPreferences r5 = this.a.g;
        if (r5 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("appendParamsSP");
        r5 = null;
    L21:
        r5.edit().putString(r2.a, r2.b).apply();
        goto L7
    L11:
        r3 = false;
        goto L12
    L22:
        ?? r10 = this.a;
        String r0 = r10.i;
        if (r0 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("toastMsg");
    L26:
        Toast.showText(r10, r1);
        this.a.finish();
        return;
    L25:
        r1 = r0;
        goto L26
    }
}
