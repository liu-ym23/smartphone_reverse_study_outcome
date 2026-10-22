package com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.record.cover;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.UIHelper;
import ip4.s;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f213501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f213502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ GalleryCoverAdapter f213503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f213504d;

    public g(String r100, ImageView r101, GalleryCoverAdapter r102, View r103) {
        this.f213501a = r100;
        this.f213502b = r101;
        this.f213503c = r102;
        this.f213504d = r103;
    }

    public final void a() {
        s.a r100 = s.b(this.f213501a);
        this.f213502b.setImageResource(kac.a.b(r100.f495303b));
        this.f213502b.getLayoutParams().width = UIHelper.dp2px(60.0f);
        this.f213502b.getLayoutParams().height = UIHelper.dp2px(60.0f);
        ColorDrawable r101 = new ColorDrawable();
        r101.setColor(this.f213503c.getContext().getResources().getColor(r100.f495304c));
        this.f213504d.setBackground(r101);
        tt5.a.h("GalleryCoverAdapter", "renderPlaceholderView" + this.f213501a);
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
