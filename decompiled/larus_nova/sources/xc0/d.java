package xc0;

import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import py.k;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    public static void a(String r100, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        List<k> r102 = r101.getResources();
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.size() != 0) goto L10;
        return;
    L10:
        Iterator<k> r103 = r102.iterator();
    L12:
        if (r103.hasNext() == false) goto L15;
        k r104 = r103.next();
        r104.getUrls();
        ArrayList r105 = new ArrayList();
        r105.add(MSkiaImageRegionDecoder.FILE_PREFIX + r100 + r104.getUri());
        Unit r106 = Unit.INSTANCE;
        r104.setUrls(r105);
        goto L12
    L15:
        if (r101.getSoundUrl() == null) goto L19;
        r101.setSoundUrl(MSkiaImageRegionDecoder.FILE_PREFIX + r100 + r101.getSoundUrl());
        return;
    }
}
