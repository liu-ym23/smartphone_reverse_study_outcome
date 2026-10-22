package qfc;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* JADX INFO: loaded from: classes38.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f532792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f532793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f532794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f532795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f532796e;

    public class a implements y.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f532797a;

        public a(j r100) {
            this.f532797a = r100;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f532798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f532799b;

        public b() {
            this.f532798a = 0.0f;
            this.f532799b = 0.0f;
        }
    }

    public j(Bitmap r100, y r101) {
        this.f532792a = r100;
        this.f532793b = r101;
        this.f532794c = new Matrix();
        this.f532795d = new b();
        this.f532796e = true;
        r101.f532858e = new a(this);
    }
}
