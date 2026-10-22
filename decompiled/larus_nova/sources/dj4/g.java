package dj4;

import android.graphics.PointF;
import android.util.Property;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f468916a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f468917b = null;

    public class a extends Property<h, float[]> {
        public a() {
            super(float[].class, "nonTranslations");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ float[] get(h r100) {
            return null;
        }

        @Override // android.util.Property
        public final void set(h r100, float[] r101) {
            h r102 = r100;
            float[] r103 = r101;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "values");
            System.arraycopy(r103, 0, r102.f468922e, 0, r103.length);
            r102.a();
        }
    }

    public class b extends Property<h, PointF> {
        public b(Class r100) {
            super(r100, "translations");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(h r100) {
            return null;
        }

        @Override // android.util.Property
        public final void set(h r100, PointF r101) {
            h r102 = r100;
            PointF r103 = r101;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "translation");
            r102.f468923f = r103.x;
            r102.f468924g = r103.y;
            r102.a();
        }
    }

    static {
        f468916a = new a();
        f468917b = new b(PointF.class);
    }
}
