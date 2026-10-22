package com.ss.android.lark.widget.light.image;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.Transformation;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.api.Target;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f446115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f446116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f446117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f446118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ List<Transformation<Bitmap>> f446119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Target f446120f;

    public g(Context r100, String r101, int r102, int r103, List r104, SimpleTarget r105) {
        this.f446115a = r100;
        this.f446116b = r101;
        this.f446117c = r102;
        this.f446118d = r103;
        this.f446119e = r104;
        this.f446120f = r105;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageLoader.with(this.f446115a).load(this.f446116b).asDrawable().override(this.f446117c, this.f446118d).transforms(this.f446119e).into(this.f446120f);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
