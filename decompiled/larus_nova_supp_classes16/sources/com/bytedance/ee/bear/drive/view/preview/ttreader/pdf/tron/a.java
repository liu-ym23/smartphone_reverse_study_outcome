package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.graphics.RectF;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a$a, reason: collision with other inner class name */
    public static final class C0184a {
        public final int a;
        public final int b;
        public final int c;
        public final RectF d;
        public final boolean e;
        public final boolean f;

        public C0184a(int r2, int r3, int r4, RectF r5) {
            Intrinsics.checkNotNullParameter(r5, "bounds");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = false;
            this.f = true;
        }
    }

    void a();

    void b(ImageView r1, C0184a r2);

    void pause();

    void resume();
}
