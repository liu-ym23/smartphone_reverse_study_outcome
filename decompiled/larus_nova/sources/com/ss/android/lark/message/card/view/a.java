package com.ss.android.lark.message.card.view;

import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.image.entity.ResourceCleanScene;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends com.ss.android.lark.chat.base.view.vo.message.f<CardContent> implements com.ss.android.lark.chat.base.view.vo.message.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f431932h;

    @Override // com.ss.android.lark.chat.base.view.vo.message.b
    public final boolean a() {
        return ((CardContent) this.f553338a).resourceIsCleaned();
    }

    @Override // com.ss.android.lark.chat.base.view.vo.message.b
    public final ResourceCleanScene b() {
        return ((CardContent) this.f553338a).firstResourceScene();
    }

    public final CardContent.CardHeader f() {
        throw null;
    }

    @Override // com.ss.android.lark.chat.base.view.vo.message.f, v5b.a
    public final boolean d(v5b.a<?> r100) {
        if (super.d(r100) == true) goto L6;
        return false;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        if (this.f431932h != ((a) r100).f431932h) goto L12;
        return true;
    L12:
        return false;
    }
}
