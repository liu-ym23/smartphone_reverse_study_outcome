package na5;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.jvm.JvmStatic;
import sbb.e;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f518465a = 0;

    static {
    }

    @JvmStatic
    public static final int a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        if (r100 == null) goto L52;
        switch(r100.hashCode()) {
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
        if (r100.equals("BITABLE") == false) goto L52;
        return e.f541298i.f541317b;
    L20:
        if (r100.equals("SHEET") == false) goto L52;
        return e.f541297h.f541317b;
    L24:
        if (r100.equals("WIKI") == false) goto L52;
        return e.f541303n.f541317b;
    L28:
        if (r100.equals("FILE") == false) goto L52;
        return e.f541301l.f541317b;
    L32:
        if (r100.equals(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX) == false) goto L52;
        return e.f541304o.f541317b;
    L36:
        if (r100.equals(PreloadConfigModel.VERSION_CHECK_TYPE_DOC) == false) goto L52;
        return e.f541296g.f541317b;
    L40:
        if (r100.equals("DOCX_SYNCED_BLOCK") == false) goto L52;
        return e.f541314y.f541317b;
    L44:
        if (r100.equals(PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE) == false) goto L52;
        return e.f541300k.f541317b;
    L48:
        if (r100.equals("SLIDES") == false) goto L52;
        return e.f541302m.f541317b;
    L52:
        return e.f541294e.f541317b;
    L10:
        return e.f541294e.f541317b;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }
}
