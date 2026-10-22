package com.ss.android.lark.keyboard.base;

import com.ss.android.lark.widget.richtext.RichText;

/* JADX INFO: loaded from: classes36.dex */
public interface f extends mob.a, b, c {
    public static final a I1 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f428230a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final com.ss.android.lark.keyboard.event.d f428231b = null;

        public a() {
        }

        static {
            f428230a = new a();
            f428231b = new com.ss.android.lark.keyboard.event.d();
        }
    }

    static {
        I1 = a.f428230a;
    }

    void D();

    void E(l r100);

    void F(boolean r100, Long r101, boolean r102, String r103, r r104);

    void I(CharSequence r100);

    q N(boolean r100);

    void O(CharSequence r100, int r101);

    RichText getContent();

    void o(boolean r100);

    void p(l r100);
}
