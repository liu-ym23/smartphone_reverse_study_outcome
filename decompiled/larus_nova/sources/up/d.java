package up;

import android.graphics.Rect;
import com.bytedance.android.ec.window.base.utils.playable.WindowPlayAbleType;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class d {
    public d() {
    }

    public abstract void d(List<tp.c> r100, com.bytedance.android.ec.window.base.utils.playable.controller.a r101, Rect r102);

    public static tp.c a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Object r102 = r101.next();
        tp.c r103 = (tp.c) r102;
        if (r103.P() == WindowPlayAbleType.VIDEO) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L4;
    L15:
        return (tp.c) r102;
    L8:
        if (r103.isPlaying() == false) goto L10;
        r104 = true;
        goto L11
    L13:
        r102 = null;
        goto L15
    }

    public static tp.c b(List r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Object r102 = r101.next();
        if (((tp.c) r102).P() != WindowPlayAbleType.VIDEO) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L4;
    L13:
        return (tp.c) r102;
    L8:
        r103 = false;
        goto L9
    L11:
        r102 = null;
        goto L13
    }

    public static tp.c c(Rect r100, com.bytedance.android.ec.window.base.utils.playable.controller.a r101) {
        Intrinsics.checkNotNullParameter(r100, "area");
        Intrinsics.checkNotNullParameter(r101, "mgr");
        tp.c r102 = b(r101.a());
        if (r102 != null) goto L5;
    L16:
        return null;
    L5:
        if (r102.isPlaying() == true) goto L7;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == false) goto L16;
        return r102;
    L7:
        if (r102.P() != WindowPlayAbleType.VIDEO) goto L13;
        Rect r104 = r102.r();
        if (r104 == null) goto L13;
        boolean r105 = r104.intersect(r100);
        r103 = true;
        if (r105 != true) goto L13;
        goto L13
    }
}
