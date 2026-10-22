package com.bytedance.ee.bear.bitable.card.view.table;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes15.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f208919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f208920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecordPageCoverAdapter f208921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f208922d;

    public w(String r100, ImageView r101, RecordPageCoverAdapter r102, View r103) {
        this.f208919a = r100;
        this.f208920b = r101;
        this.f208921c = r102;
        this.f208922d = r103;
    }

    public final void a() {
        ip4.s.a r100 = ip4.s.b(this.f208919a);
        this.f208920b.setImageResource(kac.a.b(r100.f495303b));
        this.f208920b.getLayoutParams().width = UIHelper.dp2px(80.0f);
        this.f208920b.getLayoutParams().height = UIHelper.dp2px(80.0f);
        ColorDrawable r101 = new ColorDrawable();
        r101.setColor(this.f208921c.getContext().getResources().getColor(r100.f495304c));
        this.f208922d.setBackground(r101);
        tt5.a.h("RecordPageCoverAdapter", "renderPlaceholderView" + this.f208919a);
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
