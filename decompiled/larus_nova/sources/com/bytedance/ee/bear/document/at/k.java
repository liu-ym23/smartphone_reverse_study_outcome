package com.bytedance.ee.bear.document.at;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes16.dex */
public final class k implements kn4.l.b {

    public class a implements kn4.l.c {
        public a() {
        }

        @Override // kn4.l.c
        public final String getDocumentDefaultName(Context r100, int r101) {
            return ((rc5.a) org.koin.java.a.a(rc5.a.class)).getDocumentDefaultName(r100, r101);
        }
    }

    public class b implements kn4.l.a {
        public b() {
        }

        @Override // kn4.l.a
        public final Drawable a(Context r100, String r101, String r102, int r103) {
            return ((uz4.a) org.koin.java.a.a(uz4.a.class)).a(r100, r101, r102, r103);
        }
    }

    public k() {
    }

    @Override // kn4.l.b
    public final kn4.l.a b() {
        return new b();
    }

    @Override // kn4.l.b
    public final kn4.l.c c() {
        return new a();
    }

    @Override // kn4.l.b
    public final void a(FrameLayout r100) {
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).p(r100);
    }
}
