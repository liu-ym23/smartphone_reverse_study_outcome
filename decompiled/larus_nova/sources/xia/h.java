package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.PhotoFaceEntity;
import com.obric.capabilitykit.entity.app.VideoFrame;
import com.obric.capabilitykit.entity.meta.MetaLocation;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f563987a = null;

    static {
        f563987a = new h();
    }

    public h() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof PhotoEntity) == false) goto L40;
        PhotoEntity r101 = (PhotoEntity) r100;
        int r102 = (((((((((r101.getName().hashCode() + 0) * 31) + r101.getFile().hashCode()) * 31) + r101.getAssetType().name().hashCode()) * 31) + r101.getInAlbum().hashCode()) * 31) + r101.getResolution().hashCode()) * 31;
        long r103 = r101.getFileSize();
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        if (r101.isFavorite() == false) goto L7;
        int r105 = 1231;
    L8:
        int r106 = r104 + r105;
        List<String> r107 = r101.getTags();
        if (r107 == null) goto L11;
        r106 = (r106 * 31) + r107.hashCode();
    L11:
        List<PhotoFaceEntity> r108 = r101.getFaces();
        if (r108 == null) goto L14;
        r106 = (r106 * 31) + r108.hashCode();
    L14:
        MetaLocation r109 = r101.getLocation();
        if (r109 == null) goto L17;
        r106 = (r106 * 31) + r109.hashCode();
    L17:
        String r110 = r101.getCaption();
        if (r110 == null) goto L20;
        r106 = (r106 * 31) + r110.hashCode();
    L20:
        String r111 = r101.getOcr();
        if (r111 == null) goto L23;
        r106 = (r106 * 31) + r111.hashCode();
    L23:
        String r112 = r101.getSourcePackageName();
        if (r112 == null) goto L26;
        r106 = (r106 * 31) + r112.hashCode();
    L26:
        String r113 = r101.getSourceAppName();
        if (r113 == null) goto L29;
        r106 = (r106 * 31) + r113.hashCode();
    L29:
        String r114 = r101.getSourceDevice();
        if (r114 == null) goto L32;
        r106 = (r106 * 31) + r114.hashCode();
    L32:
        List<VideoFrame> r115 = r101.getVideoFrames();
        if (r115 == null) goto L35;
        r106 = (r106 * 31) + r115.hashCode();
    L35:
        List<VideoFrame> r116 = r101.getSearchFrames();
        if (r116 != null) goto L38;
        return r106;
    L38:
        return (r106 * 31) + r116.hashCode();
    L7:
        r105 = 1237;
        goto L8
    L40:
        throw new IllegalStateException("Check failed.".toString());
    }
}
