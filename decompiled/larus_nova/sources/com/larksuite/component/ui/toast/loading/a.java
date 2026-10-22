package com.larksuite.component.ui.toast.loading;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import j08.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LKUILoadingToastImpl f284489a;

    public a(LKUILoadingToastImpl r100) {
        this.f284489a = r100;
    }

    public final void a() {
        LKUILoadingToastImpl.b r100 = this.f284489a.f284481f;
        if (1 == r100.f284485c) goto L17;
        r100.f284485c = 1;
        ValueAnimator r101 = r100.f284487e;
        Intrinsics.checkNotNull(r101);
        r101.cancel();
        r100.f284486d = 0.0f;
        ImageView r102 = r100.f284484b;
        Intrinsics.checkNotNull(r102);
        r102.setRotation(0.0f);
        int r103 = r100.f284485c;
        if (r103 != 1) goto L8;
        Drawable r104 = AppCompatResources.getDrawable(r100.getContext(), R.drawable.lkui_icon_loading);
    L15:
        if (r104 == null) goto L17;
        r104.setTint(b.c(r100.getContext(), R.color.lkui_N00, 1.0f));
        ImageView r105 = r100.f284484b;
        Intrinsics.checkNotNull(r105);
        r105.setImageDrawable(r104);
        goto L17
    L8:
        if (r103 != 2) goto L10;
        r104 = AppCompatResources.getDrawable(r100.getContext(), R.drawable.lkui_icon_succcess);
        goto L15
    L10:
        if (r103 == 3) goto L12;
        r104 = null;
        goto L15
    L12:
        r104 = AppCompatResources.getDrawable(r100.getContext(), R.drawable.lkui_icon_fail);
    L17:
        ValueAnimator r106 = r100.f284487e;
        if (r106 == null) goto L21;
        r106.start();
        return;
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
