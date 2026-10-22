package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.base.view.vo.message.d;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import mya.h;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements com.ss.android.lark.biz.im.api.extension.message.system.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SystemContent f412233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v5b.c<d> f412234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m2b.a f412235c;

    @Override // com.ss.android.lark.biz.im.api.extension.message.system.a
    public final h a() {
        return this.f412235c.j5();
    }

    @Override // com.ss.android.lark.biz.im.api.extension.message.system.a
    public final FragmentActivity context() {
        return this.f412235c.getContext();
    }

    @Override // com.ss.android.lark.biz.im.api.extension.message.system.a
    public final SystemContent content() {
        return this.f412233a;
    }

    @Override // com.ss.android.lark.biz.im.api.extension.message.system.a
    public final v5b.c<d> message() {
        return this.f412234b;
    }

    public c(SystemContent r100, y6b.a r101, m2b.a r102) {
        this.f412233a = r100;
        this.f412234b = r101;
        this.f412235c = r102;
    }
}
