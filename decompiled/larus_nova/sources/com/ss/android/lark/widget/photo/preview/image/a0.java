package com.ss.android.lark.widget.photo.preview.image;

import android.graphics.drawable.Drawable;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.entity.PhotoState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f446651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PhotoItem f446652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PhotoState f446653c;

    public a0(n r100, PhotoItem r101, PhotoState r102) {
        this.f446651a = r100;
        this.f446652b = r101;
        this.f446653c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n r100 = this.f446651a;     // Catch: Throwable -> L4
        PhotoItem r101 = this.f446652b;     // Catch: Throwable -> L4
        Drawable r102 = this.f446653c.getInlinePreviewDrawable();     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L4
        r100.h(r101, r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
