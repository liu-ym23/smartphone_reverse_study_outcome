package gg5;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements com.ss.android.lark.reaction.widget.panel.e.a {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ b c;
    public final /* synthetic */ int d;
    public final /* synthetic */ TranslateConfig e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ String i;
    public final /* synthetic */ Integer j;

    public d(boolean r1, String r2, b r3, int r4, TranslateConfig r5, String r6, String r7, boolean r8, String r9, Integer r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }

    public final void a(View r7) {
        if (this.a == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).h().put(this.b, Boolean.TRUE);
        this.c.a.invoke(Integer.valueOf(this.d));
        return;
    L6:
        if (((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).c(this.e, this.b, this.f, this.g) == false) goto L12;
        Boolean r8 = ((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).h().get(this.b);
        if (r8 != null) goto L10;
        r8 = Boolean.FALSE;
    L10:
        ((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).h().put(this.b, Boolean.valueOf(!r8.booleanValue()));
        this.c.a.invoke(Integer.valueOf(this.d));
        return;
    L12:
        if (this.h == true) goto L14;
        this.c.b.invoke(this.i, this.b, this.j);
        return;
    L14:
        ((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).h().remove(this.b);
        this.c.a.invoke(Integer.valueOf(this.d));
    }
}
