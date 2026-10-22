package j6b;

import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.image.entity.Image;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f497539a = 0;

    static {
    }

    @JvmStatic
    public static final Image a(com.bytedance.lark.pb.basic.v1.Image r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Image r101 = new Image();
        r101.setType(Image.Type.valueOf(r100.type.getValue()));
        r101.setWidth(r100.width.intValue());
        r101.setHeight(r100.height.intValue());
        r101.setKey(r100.key);
        r101.setUrls(r100.urls);
        r101.setCrypto(r100.crypto);
        r101.setFsUnit(r100.fs_unit);
        return r101;
    }

    @JvmStatic
    public static final ImageSet b(com.bytedance.lark.pb.basic.v1.ImageSet r110) {
        if (r110 != null) goto L6;
        return null;
    L6:
        return new ImageSet(r110.key, a(r110.origin), a(r110.thumbnail), a(r110.middle), a(r110.thumbnail_webp), a(r110.middle_webp), a(r110.middle_mp4), a(r110.cover));
    }

    @JvmStatic
    public static final com.bytedance.lark.pb.basic.v1.Image c(Image r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new com.bytedance.lark.pb.basic.v1.Image.Builder().type(com.bytedance.lark.pb.basic.v1.Image.Type.fromValue(r100.getType().getNumber())).width(Integer.valueOf(r100.getWidth())).height(Integer.valueOf(r100.getHeight())).key(r100.getKey()).urls(r100.getUrls()).crypto(r100.getCrypto()).fs_unit(r100.getFsUnit()).build();
    }
}
