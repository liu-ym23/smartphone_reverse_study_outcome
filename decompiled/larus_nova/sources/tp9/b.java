package tp9;

import android.graphics.PointF;
import android.util.Property;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f547064a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C7758b f547065b = null;

    public class a extends Property<c, float[]> {
        public a() {
            super(float[].class, "nonTranslations");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ float[] get(c r100) {
            return null;
        }

        @Override // android.util.Property
        public final void set(c r100, float[] r101) {
            c r102 = r100;
            float[] r103 = r101;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "values");
            System.arraycopy(r103, 0, r102.f547070e, 0, r103.length);
            r102.a();
        }
    }

    /* JADX INFO: renamed from: tp9.b$b, reason: collision with other inner class name */
    public class C7758b extends Property<c, PointF> {
        public C7758b(Class r100) {
            super(r100, "translations");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(c r100) {
            return null;
        }

        @Override // android.util.Property
        public final void set(c r100, PointF r101) {
            c r102 = r100;
            PointF r103 = r101;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "translation");
            r102.f547071f = r103.x;
            r102.f547072g = r103.y;
            r102.a();
        }
    }

    static {
        f547064a = new a();
        f547065b = new C7758b(PointF.class);
    }
}
