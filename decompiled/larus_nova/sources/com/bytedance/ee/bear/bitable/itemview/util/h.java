package com.bytedance.ee.bear.bitable.itemview.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f214286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Integer f214287b;

    public h(View r100, Integer r101) {
        this.f214286a = r100;
        this.f214287b = r101;
    }

    public final void a() {
        Object r100 = this.f214286a.getParent();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.view.View");
        View r101 = (View) r100;
        Integer r102 = this.f214287b;
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L6:
        Rect r104 = new Rect();
        this.f214286a.getHitRect(r104);
        r104.top -= r103;
        r104.left -= r103;
        r104.bottom += r103;
        r104.right += r103;
        r101.setTouchDelegate(new TouchDelegate(r104, this.f214286a));
        return;
    L5:
        r103 = UIHelper.dp2px(10.0f);
        goto L6
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
