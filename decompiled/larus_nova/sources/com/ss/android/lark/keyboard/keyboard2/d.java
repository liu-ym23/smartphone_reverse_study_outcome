package com.ss.android.lark.keyboard.keyboard2;

import com.ss.android.lark.keyboard.editor.input.interceptor.ChatEditorMenuLayoutManager;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioKBPlugin;

/* JADX INFO: loaded from: classes36.dex */
public interface d extends c {
    public static final a N1 = null;

    public static final class a implements c.a<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f429544a = null;

        static {
            f429544a = new a();
        }

        public a() {
        }
    }

    static {
        N1 = a.f429544a;
    }

    void C(ChatEditorMenuLayoutManager.b r100);

    void G(m r100);

    void M(e r100);

    void f(KeyboardMenuItemKey r100);

    boolean h();

    <T extends m> T i(KeyboardMenuItemKey r100, Class<T> r101);

    m k();

    void m();

    void q(g.a.C5103a r100);

    boolean w(KeyboardMenuItemKey r100);

    void x(AudioKBPlugin r100);
}
