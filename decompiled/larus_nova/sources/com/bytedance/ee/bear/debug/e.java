package com.bytedance.ee.bear.debug;

import android.content.SharedPreferences;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppendParamsActivity f217374a;

    public e(AppendParamsActivity r100) {
        this.f217374a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        SharedPreferences r101 = this.f217374a.f217345g;
        String r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("appendParamsSP");
        r101 = null;
    L5:
        r101.edit().clear().apply();
        Iterator<AppendParamsActivity.b> r103 = this.f217374a.f217348j.iterator();
    L7:
        if (r103.hasNext() == false) goto L22;
        AppendParamsActivity.b r104 = r103.next();
        boolean r105 = true;
        if (r104.f217350a.length() <= 0) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L7;
        if (r104.f217351b.length() > 0) goto L17;
        r105 = false;
    L17:
        if (r105 == false) goto L7;
        SharedPreferences r107 = this.f217374a.f217345g;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("appendParamsSP");
        r107 = null;
    L21:
        r107.edit().putString(r104.f217350a, r104.f217351b).apply();
        goto L7
    L11:
        r106 = false;
        goto L12
    L22:
        AppendParamsActivity r108 = this.f217374a;
        String r109 = r108.f217347i;
        if (r109 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("toastMsg");
    L26:
        Toast.showText(r108, r102);
        this.f217374a.finish();
        return;
    L25:
        r102 = r109;
        goto L26
    }
}
