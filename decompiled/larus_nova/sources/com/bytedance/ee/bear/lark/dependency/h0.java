package com.bytedance.ee.bear.lark.dependency;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.bytedance.supervisor.token.Token;

/* JADX INFO: loaded from: classes16.dex */
public interface h0 {

    public interface a {
        void a(String r100);

        Boolean b();

        void c();

        void d(ClipboardManager.OnPrimaryClipChangedListener r100);

        void e(ClipboardManager.OnPrimaryClipChangedListener r100);

        Boolean f();

        boolean g(String r100, ClipData r101, boolean r102, Token r103);

        boolean h(ClipData r100, Token r101);

        void i();

        void j(String r100);

        ClipData k(String r100, Token r101);

        ClipData l(Token r100);

        boolean m(ClipData r100, boolean r101, Token r102);
    }

    a a();
}
