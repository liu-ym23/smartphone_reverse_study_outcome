package com.bytedance.ee.bear.middleground.permission.secret;

import android.view.View;
import com.bytedance.ee.bear.secret.SecretLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ SecretLevelAdapter c;
    public final /* synthetic */ SecretLevel d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r2) {
        if (this.c.f != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("appCall");
    L5:
        SecretLevelAdapter.a r3 = this.c.f;
        if (r3 == null) goto L11;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("appCall");
        r3 = null;
    L9:
        r3.a(this.d);
        return;
    }

    public t(SecretLevelAdapter r1, SecretLevel r2) {
        this.c = r1;
        this.d = r2;
    }
}
