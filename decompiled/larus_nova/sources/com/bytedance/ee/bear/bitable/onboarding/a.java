package com.bytedance.ee.bear.bitable.onboarding;

import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.ee.bear.route.h;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f214800a;

    public a(Ref.ObjectRef<String> r100) {
        this.f214800a = r100;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        h r101 = (h) k.a(LarkContext.getApplication(), h.class);
        if (r101 == null) goto L6;
        r101.u5(this.f214800a.element);
        return;
    }
}
