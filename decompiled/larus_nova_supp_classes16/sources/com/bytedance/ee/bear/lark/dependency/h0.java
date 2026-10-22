package com.bytedance.ee.bear.lark.dependency;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.bytedance.supervisor.token.Token;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface h0 {

    public interface a {
        void a(String r1);

        Boolean b();

        void c();

        void d(ClipboardManager.OnPrimaryClipChangedListener r1);

        void e(ClipboardManager.OnPrimaryClipChangedListener r1);

        Boolean f();

        boolean g(String r1, ClipData r2, boolean r3, Token r4);

        boolean h(ClipData r1, Token r2);

        void i();

        void j(String r1);

        ClipData k(String r1, Token r2);

        ClipData l(Token r1);

        boolean m(ClipData r1, boolean r2, Token r3);
    }

    a a();
}
