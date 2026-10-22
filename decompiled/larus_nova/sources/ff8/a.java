package ff8;

import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverImageEntity;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverItem;
import com.obric.sva.sdk.data.ISmModel;
import kotlin.jvm.internal.Intrinsics;
import nr9.f;
import nr9.g;

/* JADX INFO: loaded from: classes25.dex */
public final class a {
    public static final g a(AiGenVideoContentData r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r100 = r110.getVid();
        String r101 = r110.getVideoModel();
        String r102 = r110.getDownloadUrl();
        String r103 = r110.getDownloadFilehash();
        Double r104 = r110.getDuration();
        String r105 = r110.getVideoType();
        CoverItem r106 = r110.getVideoCover();
        if (r106 == null) goto L5;
        String r111 = b.b(r106);
    L6:
        CoverItem r107 = r110.getVideoCover();
        if (r107 == null) goto L9;
        String r112 = b.a(r107);
    L10:
        CoverItem r108 = r110.getVideoCover();
        if (r108 == null) goto L15;
        CoverImageEntity r109 = r108.getPreviewImage();
        if (r109 == null) goto L15;
        Integer r113 = Integer.valueOf(r109.getHeight());
    L16:
        CoverItem r114 = r110.getVideoCover();
        if (r114 == null) goto L21;
        CoverImageEntity r115 = r114.getPreviewImage();
        if (r115 == null) goto L21;
        Integer r116 = Integer.valueOf(r115.getWidth());
    L23:
        return new g(r100, r101, r102, r103, r104, r105, new f(r111, r112, null, r113, r116, null, 36), r110.getLocalUrl(), null, null, ISmModel.VERSION_0300);
    L21:
        r116 = null;
    L15:
        r113 = null;
        goto L16
    L9:
        r112 = null;
        goto L10
    L5:
        r111 = null;
        goto L6
    }
}
