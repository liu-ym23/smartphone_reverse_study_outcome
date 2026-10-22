package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import androidx.lifecycle.Observer;
import com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.entity.chat.Chat;

/* JADX INFO: loaded from: classes35.dex */
public final class h<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.a f414145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IMessageListComponent f414146b;

    public h(d.C4824d r100, IMessageListComponent r101) {
        this.f414145a = r100;
        this.f414146b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Chat r101 = (Chat) r100;
        IBannerComponent r102 = (IBannerComponent) this.f414145a.a(IBannerComponent.class);
        if (r102 == null) goto L10;
        ITitlebarComponent r103 = (ITitlebarComponent) this.f414145a.a(ITitlebarComponent.class);
        if (r103 == null) goto L11;
        d.c r104 = new d.c(this.f414146b);
        r102.jx(r104);
        r103.kq(r104);
        r103.sm(r104);
        r103.OY(r104);
        return;
    L11:
        return;
    }
}
