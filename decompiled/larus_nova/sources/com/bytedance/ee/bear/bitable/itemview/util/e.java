package com.bytedance.ee.bear.bitable.itemview.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f214281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f214282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f214283c;

    public e(View r100, AppCompatImageView r101) {
        this.f214281a = r100;
        this.f214282b = r101;
        this.f214283c = 4;
    }

    public final void a() {
        TouchDelegate r100 = this.f214281a.getTouchDelegate();
        if ((r100 instanceof u) == false) goto L5;
        u r101 = (u) r100;
    L6:
        if (r101 != null) goto L8;
        r101 = new u(this.f214281a);
        this.f214281a.setTouchDelegate(r101);
    L8:
        Rect r102 = new Rect();
        this.f214282b.getHitRect(r102);
        int r103 = -com.bytedance.ee.util.ui.n.d(this.f214283c);
        r102.inset(r103, r103);
        TouchDelegate r104 = new TouchDelegate(r102, this.f214282b);
        Intrinsics.checkNotNullParameter(r104, "delegate");
        ((ArrayList) r101.f214311b).add(r104);
        return;
    L5:
        r101 = null;
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
