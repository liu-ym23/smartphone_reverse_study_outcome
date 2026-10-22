package com.bytedance.ee.bear.document.at;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k implements kn4.l.b {

    public class a implements kn4.l.c {
        public a() {
        }

        public final String getDocumentDefaultName(Context r2, int r3) {
            return ((rc5.a) org.koin.java.a.a(rc5.a.class)).getDocumentDefaultName(r2, r3);
        }
    }

    public class b implements kn4.l.a {
        public b() {
        }

        public final Drawable a(Context r2, String r3, String r4, int r5) {
            return ((uz4.a) org.koin.java.a.a(uz4.a.class)).a(r2, r3, r4, r5);
        }
    }

    public k() {
    }

    public final kn4.l.a b() {
        return new b();
    }

    public final kn4.l.c c() {
        return new a();
    }

    public final void a(FrameLayout r2) {
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).p(r2);
    }
}
