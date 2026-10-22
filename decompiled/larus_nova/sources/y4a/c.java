package y4a;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.lynx.animax.ui.ObjectFit;

/* JADX INFO: loaded from: classes32.dex */
public final class c {
    public static ObjectFit a(String r100) {
        ObjectFit r101 = ObjectFit.CONTAIN;
        if ("cover".equals(r100) == false) goto L6;
        return ObjectFit.COVER;
    L6:
        if ("center".equals(r100) == false) goto L9;
        return ObjectFit.CENTER;
    L9:
        if (LynxVideoManagerLite.FILL.equals(r100) == false) goto L12;
        return ObjectFit.FILL;
    L12:
        if ("scale-down".equals(r100) == true) goto L14;
        return r101;
    L14:
        return ObjectFit.SCALE_DOWN;
    }
}
