package com.ss.android.lark.flow.feed.sidebar.view;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f423611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f423612b;

    public b(FeedSidebarCommonViewHolder r100, ImageView r101, Bitmap r102) {
        this.f423611a = r101;
        this.f423612b = r102;
    }

    public final void a() {
        ImageView r100 = this.f423611a;
        Bitmap r101 = this.f423612b;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        ViewGroup r103 = null;
        r100.setRenderEffect(null);     // Catch: Throwable -> L13
        r100.setImageDrawable(null);     // Catch: Throwable -> L13
        ViewParent r104 = r100.getParent();     // Catch: Throwable -> L13
        if ((r104 instanceof ViewGroup) == false) goto L6;
        r103 = (ViewGroup) r104;     // Catch: Throwable -> L13
    L6:
        if (r103 == null) goto L9;
        r103.removeView(r100);     // Catch: Throwable -> L13
    L9:
        if (r101.isRecycled() == true) goto L11;
        r101.recycle();     // Catch: Throwable -> L13
    L11:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
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
