package na5;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.jvm.JvmStatic;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final int a(String r1) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        if (r1 == null) goto L52;
        switch(r1.hashCode()) {
            case -1846317854: goto L48;
            case -581022908: goto L44;
            case -443857913: goto L40;
            case 67864: goto L36;
            case 2103872: goto L32;
            case 2157948: goto L28;
            case 2664368: goto L24;
            case 78865727: goto L20;
            case 615206855: goto L16;
            default: goto L52;
        };
    L16:
        if (r1.equals("BITABLE") == false) goto L52;
        return e.i.b;
    L20:
        if (r1.equals("SHEET") == false) goto L52;
        return e.h.b;
    L24:
        if (r1.equals("WIKI") == false) goto L52;
        return e.n.b;
    L28:
        if (r1.equals("FILE") == false) goto L52;
        return e.l.b;
    L32:
        if (r1.equals(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX) == false) goto L52;
        return e.o.b;
    L36:
        if (r1.equals(PreloadConfigModel.VERSION_CHECK_TYPE_DOC) == false) goto L52;
        return e.g.b;
    L40:
        if (r1.equals("DOCX_SYNCED_BLOCK") == false) goto L52;
        return e.y.b;
    L44:
        if (r1.equals(PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE) == false) goto L52;
        return e.k.b;
    L48:
        if (r1.equals("SLIDES") == false) goto L52;
        return e.m.b;
    L52:
        return e.e.b;
    L10:
        return e.e.b;
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }
}
