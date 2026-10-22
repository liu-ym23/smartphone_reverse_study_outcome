package ff8;

import android.os.Build;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverImageEntity;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverItem;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b {
    public static final String a(CoverItem r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        CoverImageEntity r101 = r100.getPreviewImage();
        if (r101 == null) goto L5;
        String r102 = r101.getUrl();
    L7:
        if (o0.d(r102) == false) goto L12;
        CoverImageEntity r103 = r100.getPreviewImage();
        if (r103 != null) goto L11;
        return null;
    L11:
        return r103.getUrl();
    L12:
        return null;
    L5:
        r102 = null;
        goto L7
    }

    public static final String b(CoverItem r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r101 = true;
        if (z2.f365865a.imageGenerateHeicConfig().f486776a == true) goto L7;
        r101 = false;
    L7:
        if (r101 == false) goto L24;
        CoverImageEntity r102 = r100.getImageThumb();
        if (r102 == null) goto L11;
        String r103 = r102.getUrlV2();
    L13:
        if (o0.d(r103) == false) goto L24;
        if (Build.VERSION.SDK_INT <= 26) goto L24;
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("use urlV2 is ");
        CoverImageEntity r106 = r100.getImageThumb();
        if (r106 == null) goto L19;
        String r107 = r106.getUrlV2();
    L20:
        r105.append(r107);
        r104.d(" CoverItemExt", r105.toString());
        CoverImageEntity r108 = r100.getImageThumb();
        if (r108 != null) goto L23;
        return null;
    L23:
        return r108.getUrlV2();
    L19:
        r107 = null;
        goto L20
    L11:
        r103 = null;
    L24:
        CoverImageEntity r109 = r100.getImageThumb();
        if (r109 != null) goto L27;
        return null;
    L27:
        return r109.getUrl();
    }
}
