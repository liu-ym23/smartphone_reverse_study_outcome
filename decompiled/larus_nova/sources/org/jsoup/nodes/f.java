package org.jsoup.nodes;

import com.larus.media.MediaScene;
import java.io.IOException;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes42.dex */
public final class f extends i {
    @Override // org.jsoup.nodes.j
    public final String t() {
        return "#doctype";
    }

    @Override // org.jsoup.nodes.j
    public final void w(Appendable r100, int r101, Document.OutputSettings r102) {
    }

    public final boolean H(String r100) {
        return !fwc.b.d(d(r100));
    }

    public f(String r100, String r101, String r102) {
        ewc.b.d(r100);
        ewc.b.d(r101);
        ewc.b.d(r102);
        e("name", r100);
        e("publicId", r101);
        e("systemId", r102);
        if (H("publicId") == false) goto L6;
        e("pubSysKey", "PUBLIC");
        return;
    L6:
        if (H("systemId") == false) goto L10;
        e("pubSysKey", MediaScene.SYSTEM);
        return;
    }

    @Override // org.jsoup.nodes.j
    public final void v(Appendable r100, int r101, Document.OutputSettings r102) throws IOException {
        if (this.f525934b <= 0) goto L8;
        if (r102.f525897e == false) goto L8;
        r100.append('\n');
    L8:
        if (r102.f525900h == Document.OutputSettings.Syntax.html) goto L10;
    L14:
        r100.append("<!DOCTYPE");
    L16:
        if (H("name") == false) goto L19;
        r100.append(" ").append(d("name"));
    L19:
        if (H("pubSysKey") == false) goto L22;
        r100.append(" ").append(d("pubSysKey"));
    L22:
        if (H("publicId") == false) goto L25;
        r100.append(" \"").append(d("publicId")).append(Typography.quote);
    L25:
        if (H("systemId") == false) goto L27;
        r100.append(" \"").append(d("systemId")).append(Typography.quote);
    L27:
        r100.append(Typography.greater);
        return;
    L10:
        if (H("publicId") == true) goto L14;
        if (H("systemId") == true) goto L14;
        r100.append("<!doctype");
        goto L16
    }
}
