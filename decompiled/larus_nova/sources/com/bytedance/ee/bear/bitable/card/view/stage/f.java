package com.bytedance.ee.bear.bitable.card.view.stage;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f208721a;

    public f(View r100) {
        this.f208721a = r100;
    }

    public final void a() {
        Object r100 = this.f208721a.getParent();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.view.View");
        int r101 = UIHelper.dp2px(10.0f);
        Rect r102 = new Rect();
        this.f208721a.getHitRect(r102);
        r102.top -= r101;
        r102.left -= r101;
        r102.bottom += r101;
        r102.right += r101;
        ((View) r100).setTouchDelegate(new TouchDelegate(r102, this.f208721a));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
