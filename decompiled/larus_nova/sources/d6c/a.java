package d6c;

import com.bytedance.lark.pb.basic.v1.Image;
import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.bytedance.lark.pb.im.v1.Sticker;
import com.ss.android.lark.image.entity.BaseImageSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static Image a(com.ss.android.lark.image.entity.Image r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new Image.Builder().key(r100.getKey()).urls(r100.getUrls()).width(Integer.valueOf(r100.getWidth())).height(Integer.valueOf(r100.getHeight())).type(Image.Type.fromValue(1)).build();
    }

    public static List<Sticker> b(List<com.ss.android.lark.chat.entity.sticker.Sticker> r100) {
        if (r100 == null) goto L4;
        ArrayList r101 = new ArrayList();
        Iterator<com.ss.android.lark.chat.entity.sticker.Sticker> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L21;
        com.ss.android.lark.chat.entity.sticker.Sticker r103 = r102.next();
        Sticker r104 = null;
        ImageSet r105 = null;
        if (r103 == null) goto L20;
        Sticker.Builder r106 = new Sticker.Builder().position(Integer.valueOf(r103.getPosition()));
        BaseImageSet r107 = r103.getImageSet();
        if (r107 == null) goto L15;
        r105 = new ImageSet.Builder().key(r107.getKey()).origin(a(r107.getOrigin())).thumbnail(a(r107.getThumbnail())).middle(a(r107.getMiddle())).build();
    L15:
        Sticker.Builder r108 = r106.image(r105).description(r103.getDesc());
        if (r103.getMode() == null) goto L18;
        int r109 = r103.getMode().getNumber();
    L19:
        r104 = r108.mode(Sticker.Mode.fromValue(r109)).has_paid(Boolean.valueOf(r103.isHasPaid())).sticker_set_id(r103.getStickerSetId()).sticker_id(r103.getStickerId()).small_url(r103.getSmallUrl()).build();
        goto L20
    L18:
        r109 = 1;
    L20:
        r101.add(r104);
        goto L7
    L21:
        return r101;
    L4:
        return Collections.emptyList();
    }
}
