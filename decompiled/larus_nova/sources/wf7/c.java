package wf7;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.view.PixelCopy;
import android.view.Window;
import com.bytedance.supervisor.token.Token;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements a {
    public c() {
    }

    @Override // wf7.a
    public final void e(Window r100, Rect r101, Bitmap r102, PixelCopy.OnPixelCopyFinishedListener r103, Handler r104, Token r105) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r102, "dest");
        Intrinsics.checkNotNullParameter(r103, "listener");
        Intrinsics.checkNotNullParameter(r104, "listenerThread");
        Intrinsics.checkNotNullParameter(r105, "token");
        PixelCopy.request(r100, r101, r102, r103, r104);
    }
}
