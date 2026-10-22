package com.larus.bmhome.block.newheader.foldcontainer;

import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import kb8.n;
import lb8.h;
import nb8.l;
import tk8.f;

/* JADX INFO: loaded from: classes25.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r100, int r101, int r102) {
            r100.a(r101, r102, new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        }
    }

    void a(int r100, int r101, Interpolator r102);

    void b(String r100);

    void c();

    h d();

    n e();

    f f();

    l g();

    void h(st8.a r100, CustomMarkdownTextView r101);

    com.larus.bmhome.chat.standarduikit.vlm.view.b i();
}
