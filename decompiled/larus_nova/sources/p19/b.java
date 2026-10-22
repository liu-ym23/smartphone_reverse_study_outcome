package p19;

import android.graphics.Bitmap;
import androidx.core.graphics.drawable.DrawableKt;
import com.github.alexzhirkevich.customqrgenerator.QrErrorCorrectionLevel;
import com.github.alexzhirkevich.customqrgenerator.vector.style.d;
import com.github.alexzhirkevich.customqrgenerator.vector.style.e;
import com.github.alexzhirkevich.customqrgenerator.vector.style.g;
import com.github.alexzhirkevich.customqrgenerator.vector.style.h;
import com.github.alexzhirkevich.customqrgenerator.vector.style.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f527331a = 0;

    static {
    }

    public static Bitmap a(String r110, int r111, int r112, int r113) {
        Intrinsics.checkNotNullParameter(r110, "url");
        pu7.c.a r100 = new pu7.c.a();
        r100.f530758g = false;
        QrErrorCorrectionLevel r101 = QrErrorCorrectionLevel.Low;
        Intrinsics.checkNotNullParameter(r101, "errorCorrectionLevel");
        r100.f530757f = r101;
        g r102 = new g(new e.a(r113), new e.a(0), new e.a(r113), new e.a(r113));
        Intrinsics.checkNotNullParameter(r102, "colors");
        r100.f530754c = r102;
        n r103 = new n(new a(1.0f), new d.b(), new h.c(), 18);
        Intrinsics.checkNotNullParameter(r103, "shapes");
        pu7.c r104 = new pu7.c(r100.f530752a, r103, r100.f530753b, r100.f530754c, r100.f530755d, r100.f530756e, r100.f530757f, r100.f530758g, r100.f530759h);
        com.github.alexzhirkevich.customqrgenerator.c.a r105 = new com.github.alexzhirkevich.customqrgenerator.c.a(r110);
        Intrinsics.checkNotNullParameter(r105, "data");
        Intrinsics.checkNotNullParameter(r104, "options");
        return DrawableKt.toBitmap$default(new pu7.b(r105, r104, null), r111, r112, null, 4, null);
    }
}
