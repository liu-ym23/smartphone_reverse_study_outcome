package d6c;

import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.image.entity.BaseImageSet;
import com.ss.android.lark.image.entity.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class b {
    public static Image a(com.bytedance.lark.pb.basic.v1.Image r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Image r101 = new Image();
        r101.setKey(r100.key);
        r101.setWidth(r100.width.intValue());
        r101.setHeight(r100.height.intValue());
        r101.setUrls(new ArrayList(r100.urls));
        r101.setType(Image.Type.forNumber(r100.type.getValue()));
        return r101;
    }

    public static List<Sticker> b(List<com.bytedance.lark.pb.im.v1.Sticker> r100) {
        if (r100 == null) goto L4;
        ArrayList r101 = new ArrayList();
        Iterator<com.bytedance.lark.pb.im.v1.Sticker> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L20;
        com.bytedance.lark.pb.im.v1.Sticker r103 = r102.next();
        Sticker r104 = null;
        BaseImageSet r105 = null;
        if (r103 == null) goto L19;
        Sticker r106 = new Sticker();
        r106.setPosition(r103.position.intValue());
        ImageSet r107 = r103.image;
        if (r107 == null) goto L15;
        r105 = new BaseImageSet();
        r105.setKey(r107.key);
        r105.setOrigin(a(r107.origin));
        r105.setThumbnail(a(r107.thumbnail));
        r105.setMiddle(a(r107.middle));
    L15:
        r106.setImageSet(r105);
        r106.setDesc(r103.description);
        com.bytedance.lark.pb.im.v1.Sticker.Mode r108 = r103.mode;
        if (r108 == null) goto L18;
        r106.setMode(Sticker.Mode.forNumber(r108.getValue()));
    L18:
        r106.setHasPaid(r103.has_paid.booleanValue());
        r106.setStickerSetId(r103.sticker_set_id);
        r106.setStickerId(r103.sticker_id);
        r106.setSmallUrl(r103.small_url);
        r104 = r106;
    L19:
        r101.add(r104);
        goto L7
    L20:
        return r101;
    L4:
        return Collections.emptyList();
    }
}
