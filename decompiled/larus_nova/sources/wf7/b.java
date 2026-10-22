package wf7;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.view.PixelCopy;
import android.view.Window;
import com.bytedance.supervisor.token.AtomicInfoDef;
import com.bytedance.supervisor.token.Token;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lf7.d;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f559487a = null;

    static {
        f559487a = new b();
    }

    public b() {
    }

    @Override // wf7.a
    public final void e(Window r100, Rect r110, Bitmap r111, PixelCopy.OnPixelCopyFinishedListener r112, Handler r113, Token r114) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r111, "dest");
        Intrinsics.checkNotNullParameter(r112, "listener");
        Intrinsics.checkNotNullParameter(r113, "listenerThread");
        Intrinsics.checkNotNullParameter(r114, "token");
        rf7.a.a(r114, new of7.b(CollectionsKt.listOf(AtomicInfoDef.PIXEL_COPY_REQUEST)));
        lf7.b r101 = d.f509087a;
        Intrinsics.checkNotNullParameter(this, "this");
        lf7.a r102 = d.a("pixelcopy");
        if ((r102 instanceof a) == false) goto L5;
        a r103 = (a) r102;
    L6:
        r103.e(r100, r110, r111, r112, r113, r114);
        return;
    L5:
        r103 = new c();
        goto L6
    }
}
