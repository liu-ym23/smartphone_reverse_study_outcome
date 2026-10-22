package kn4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes15.dex */
public interface l {

    public interface a {
        Drawable a(Context r100, String r101, String r102, int r103);
    }

    public interface b {
        void a(FrameLayout r100);

        a b();

        c c();
    }

    public interface c {
        String getDocumentDefaultName(Context r100, int r101);
    }

    bo4.c a();

    com.bytedance.ee.bear.atfinder.f b();

    n c();

    boolean d();

    k e();

    kn4.b f();
}
