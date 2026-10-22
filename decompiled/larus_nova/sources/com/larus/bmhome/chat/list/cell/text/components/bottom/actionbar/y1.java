package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import android.view.View;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: classes25.dex */
public final class y1 implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u7 f306228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Message f306229b;

    public y1(u7 r100, Message r101) {
        this.f306228a = r100;
        this.f306229b = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        u7 r109 = this.f306228a;
        String r110 = this.f306229b.getMessageId();
        if (r110 != null) goto L5;
        r110 = "";
    L5:
        r109.kx(r110, false);
    }
}
