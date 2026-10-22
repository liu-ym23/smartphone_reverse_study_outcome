package com.ss.android.lark.reaction.widget.panel;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements com.ss.android.lark.newemoji.emoji_list.adapter.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReactionPanelFacade f439491a;

    public b(ReactionPanelFacade r100) {
        this.f439491a = r100;
    }

    @Override // com.ss.android.lark.newemoji.emoji_list.adapter.e
    public final void a(String r100, s5c.d r101) {
        ReactionPanelFacade r102 = this.f439491a;
        if (r102.f439451b == null) goto L5;
        ReactionPanelFacade.b(r102, r101);
        this.f439491a.f439451b.a(r100, 2);
    L5:
        this.f439491a.c();
    }

    @Override // com.ss.android.lark.newemoji.emoji_list.adapter.e
    public final void b(String r100, String r101) {
        k2c.a.a().Wc(r100, r101);
    }
}
