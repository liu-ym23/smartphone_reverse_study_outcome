package y82;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {
    public static final void b(View r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "layoutData");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r102 = null;
    L5:
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102;
        if (r103 != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r101, "layoutData");
        int r104 = r103.width;
        int r105 = r101.f566849a;
        if (r104 == r105) goto L11;
    L21:
        boolean r106 = false;
    L22:
        if (r106 == false) goto L24;
        return;
    L24:
        r103.width = r105;
        r103.height = r101.f566850b;
        r103.leftMargin = r101.f566852d;
        r103.rightMargin = r101.f566853e;
        r103.topMargin = r101.f566851c;
        r103.gravity = r101.f566854f;
        r100.setLayoutParams(r103);
        return;
    L11:
        if (r103.height != r101.f566850b) goto L21;
        if (r103.leftMargin != r101.f566852d) goto L21;
        if (r103.rightMargin != r101.f566853e) goto L21;
        if (r103.topMargin != r101.f566851c) goto L21;
        if (r103.gravity != r101.f566854f) goto L21;
        r106 = true;
        goto L22
    }

    public static final Integer a(int r100, int r101, List r110) {
        Intrinsics.checkNotNullParameter(r110, "windows");
        ArrayList r102 = new ArrayList();
        Iterator r111 = r110.iterator();
    L3:
        Double r103 = null;
        if (r111.hasNext() == false) goto L16;
        SeiRegion r104 = ((com.bytedance.android.livesdk.interactivity.medialink.ui.a) r111.next()).getMSeiRegion();
        if (r104 != null) goto L9;
    L14:
        if (r103 == null) goto L3;
        r102.add(r103);
        goto L3
    L9:
        if (r104.getWidth() == AudioStats.AUDIO_AMPLITUDE_NONE) goto L14;
        if (r104.getHeight() == AudioStats.AUDIO_AMPLITUDE_NONE) goto L14;
        r103 = Double.valueOf(r104.getY());
        goto L14
    L16:
        Double r112 = (Double) CollectionsKt.firstOrNull(CollectionsKt.sorted(r102));
        if (r112 != null) goto L19;
        return null;
    L19:
        return Integer.valueOf((int) ((r112.doubleValue() * ((double) r101)) + ((double) r100)));
    }
}
