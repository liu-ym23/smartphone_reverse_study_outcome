package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.graphics.RectF;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a$a, reason: collision with other inner class name */
    public static final class C3240a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f225310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f225311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f225312c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final RectF f225313d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f225314e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f225315f;

        public C3240a(int r100, int r101, int r102, RectF r103) {
            Intrinsics.checkNotNullParameter(r103, "bounds");
            this.f225310a = r100;
            this.f225311b = r101;
            this.f225312c = r102;
            this.f225313d = r103;
            this.f225314e = false;
            this.f225315f = true;
        }
    }

    void a();

    void b(ImageView r100, C3240a r101);

    void pause();

    void resume();
}
