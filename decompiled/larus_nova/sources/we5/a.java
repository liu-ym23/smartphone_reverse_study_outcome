package we5;

import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f559398a = 0;

    static {
    }

    public static void a(LinearLayout r100, View r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "voiceContainer");
        Intrinsics.checkNotNullParameter(r102, "imageView");
        int r103 = r100.indexOfChild(r101);
        int r104 = r100.indexOfChild(r102);
        if (r103 == (-1)) goto L9;
        if (r104 == (-1)) goto L10;
        if (r103 > r104) goto L11;
        r100.removeView(r101);
        r100.addView(r101, r100.indexOfChild(r102) + 1);
        return;
    L11:
        return;
    L10:
        return;
    }
}
