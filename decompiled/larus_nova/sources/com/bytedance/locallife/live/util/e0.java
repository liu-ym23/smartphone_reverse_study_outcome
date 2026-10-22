package com.bytedance.locallife.live.util;

import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.ss.android.download.api.constant.BaseConstants;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes21.dex */
public final class e0 {
    static {
        new SimpleDateFormat("yyyy-MM-dd");
    }

    public static String a(long r110) {
        StringBuilder r100 = new StringBuilder();
        long r101 = BaseConstants.Time.HOUR;
        long r102 = r110 / r101;
        long r103 = 60000;
        long r104 = (r110 / r103) % ((long) 60);
        long r111 = ((r110 % r101) % r103) / ((long) 1000);
        if (r102 > 0) goto L5;
        r100.append("00:");
    L10:
        long r105 = 10;
        if (r104 < r105) goto L14;
        r100.append(r104);
    L17:
        r100.append(":");
        if (r111 < r105) goto L21;
        r100.append(r111);
    L25:
        return r100.toString();
    L21:
        if (r111 <= 0) goto L23;
        r100.append(0);
        r100.append(r111);
        goto L25
    L23:
        r100.append(CustomAlbumViewModel.DEFAULT_TAB_ID);
        goto L25
    L14:
        if (r104 <= 0) goto L16;
        r100.append(0);
        r100.append(r104);
        goto L17
    L16:
        r100.append(CustomAlbumViewModel.DEFAULT_TAB_ID);
        goto L17
    L5:
        if (r102 < 10) goto L7;
        r100.append(r102);
    L8:
        r100.append(":");
        goto L10
    L7:
        r100.append(0);
        r100.append(r102);
        goto L8
    }
}
