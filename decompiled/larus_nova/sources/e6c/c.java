package e6c;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.sticker.core.model.StickerFileInfo;
import com.ss.android.lark.sticker_office.ui.custom_sticker.panel.OfficeCustomStickerModel$deleteStickers$2$1;
import com.ss.android.lark.sticker_office.ui.custom_sticker.panel.OfficeCustomStickerModel$getCustomStickers$2$1;
import com.ss.android.lark.sticker_office.ui.custom_sticker.panel.OfficeCustomStickerModel$uploadStickers$2$1;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public interface c {
    void Pa(List r100, boolean r101, OfficeCustomStickerModel$uploadStickers$2$1 r102);

    StickerFileInfo Uc(String r100);

    void cf(List r100, OfficeCustomStickerModel$deleteStickers$2$1 r101);

    void de(boolean r100, OfficeCustomStickerModel$getCustomStickers$2$1 r101);

    void n0(List<Sticker> r100, IGetDataCallback<Boolean> r101);

    void saveImage2Stickers(String r100, String r101, IGetDataCallback<Boolean> r102);

    Sticker y(String r100);
}
