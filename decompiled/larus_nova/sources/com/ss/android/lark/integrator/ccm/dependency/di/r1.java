package com.ss.android.lark.integrator.ccm.dependency.di;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import com.ss.android.lark.utils.LarkContext;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class r1 implements cx4.a {
    public r1() {
        if (com.larksuite.framework.utils.z.e(LarkContext.getApplication()) == false) goto L6;
        UICallbackExecutor.executeDelayed(new q1(), 15000);
        return;
    }

    @Override // cx4.a
    public final DefaultEmojiPanelData a() {
        return k2c.a.a().a();
    }

    @Override // cx4.a
    public final List<String> f() {
        return k2c.a.a().f();
    }

    @Override // cx4.a
    public final List<String> h() {
        return k2c.a.a().h();
    }

    @Override // cx4.a
    public final List<String> o() {
        return k2c.a.a().o();
    }

    @Override // cx4.a
    public final void q(String r100, IGetDataCallback<Integer> r101) {
        k2c.a.b().q(r100, r101);
    }
}
