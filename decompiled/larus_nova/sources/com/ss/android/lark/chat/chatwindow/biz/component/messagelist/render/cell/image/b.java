package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image;

import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f412211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageCellLoader.b f412212b;

    public b(Object r100, ImageCellLoader.b r101) {
        this.f412211a = r100;
        this.f412212b = r101;
    }

    public final void a() {
        Object r100 = this.f412211a;
        if ((r100 instanceof GifDrawable) == true) goto L5;
        ImageCellLoader.b r101 = this.f412212b;
        if (r101.f412197c.f412209e == true) goto L17;
        r101.f412196b.a().setVisibility(8);
        return;
    L17:
        return;
    L5:
        if (((GifDrawable) r100).isOverLimit() == false) goto L7;
        this.f412212b.f412196b.a().setText(UIHelper.getString(R.string.Lark_IM_GIF_Tag));
        this.f412212b.f412196b.a().setVisibility(0);
        return;
    L7:
        ImageCellLoader.b r102 = this.f412212b;
        if (r102.f412197c.f412209e == true) goto L15;
        r102.f412196b.a().setVisibility(8);
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
