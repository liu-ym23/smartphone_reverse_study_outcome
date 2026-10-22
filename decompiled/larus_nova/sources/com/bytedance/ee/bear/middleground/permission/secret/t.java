package com.bytedance.ee.bear.middleground.permission.secret;

import android.view.View;
import com.bytedance.ee.bear.secret.SecretLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class t extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SecretLevelAdapter f234132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SecretLevel f234133d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        if (this.f234132c.f233953f != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("appCall");
    L5:
        SecretLevelAdapter.a r101 = this.f234132c.f233953f;
        if (r101 == null) goto L11;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("appCall");
        r101 = null;
    L9:
        r101.a(this.f234133d);
        return;
    }

    public t(SecretLevelAdapter r100, SecretLevel r101) {
        this.f234132c = r100;
        this.f234133d = r101;
    }
}
