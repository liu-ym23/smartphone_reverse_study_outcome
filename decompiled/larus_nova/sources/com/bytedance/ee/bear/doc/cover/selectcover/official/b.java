package com.bytedance.ee.bear.doc.cover.selectcover.official;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import lt7.d;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f217855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f217856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f217857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f217858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ImageView f217859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d f217860f;

    public b(Context r100, String r101, int r102, int r103, CoverImageAdapter r104, ImageView r105, d r106) {
        this.f217855a = r100;
        this.f217856b = r101;
        this.f217857c = r102;
        this.f217858d = r103;
        this.f217859e = r105;
        this.f217860f = r106;
    }

    public final void a() {
        Glide.with(this.f217855a).asBitmap().load(this.f217856b).diskCacheStrategy(DiskCacheStrategy.ALL).error(R.drawable.doc_cover_error_view).override(this.f217857c, this.f217858d).into(new CoverImageAdapter.b(this.f217859e, this.f217860f));
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
