package com.ss.android.lark.reaction.widget.panel;

import android.text.TextUtils;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes37.dex */
public final class d implements com.ss.android.lark.newemoji.emoji_list.adapter.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReactionPanelFacade f439493a;

    @Override // com.ss.android.lark.newemoji.emoji_list.adapter.e
    public final void b(String r100, String r101) {
    }

    public d(ReactionPanelFacade r100) {
        this.f439493a = r100;
    }

    @Override // com.ss.android.lark.newemoji.emoji_list.adapter.e
    public final void a(String r100, s5c.d r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        Log.e("ReactionPanelFacade", "reaction ===> reaction key is null");
        return;
    L6:
        ReactionPanelFacade.b r102 = this.f439493a.f439451b;
        if (r102 == null) goto L9;
        r102.a(r100, 0);
    L9:
        ReactionPanelFacade.b(this.f439493a, r101);
        this.f439493a.c();
    }
}
