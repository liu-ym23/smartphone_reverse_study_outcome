package u2b;

import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.image.entity.Image;

/* JADX INFO: loaded from: classes35.dex */
public final class o {
    public static Sticker a(StickerContent r100) {
        Sticker r101 = new Sticker();
        r101.setStickerId(r100.getStickerId());
        r101.setStickerSetId(r100.getStickerSetId());
        r101.setHasPaid(r100.isPaid());
        r101.setDesc(r100.getDescription());
        r101.setMode(Sticker.Mode.STICKER);
        ImageSet r102 = new ImageSet();
        Image r103 = new Image();
        r103.setKey(r100.getKey());
        r102.setOrigin(r103);
        r101.setImageSet(r102);
        return r101;
    }
}
