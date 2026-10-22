package com.ss.android.ugc.aweme.poi.utils;

import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.ss.android.download.api.constant.BaseConstants;
import java.text.SimpleDateFormat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/utils/TimeUtils;", "", "<init>", "()V", "locallife-saas-common_release"}, k = 1, mv = {1, 4, 3})
public final class TimeUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeUtils f451368a = null;

    private TimeUtils() {
    }

    static {
        f451368a = new TimeUtils();
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
