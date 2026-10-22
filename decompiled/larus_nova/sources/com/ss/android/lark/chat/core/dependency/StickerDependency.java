package com.ss.android.lark.chat.core.dependency;

import android.content.Context;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.chatbase.view.ChatImageView;
import com.ss.android.lark.image.impl.PerfLoadPicMonitor;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public interface StickerDependency {

    public static class UISticker implements Serializable {
        public final String filePath;
        public final int selected;
        public final Sticker sticker;

        public UISticker() {
            this.selected = -1;
            this.sticker = null;
            this.filePath = "";
        }

        public UISticker(Sticker r100) {
            this.sticker = r100;
            this.selected = -1;
            this.filePath = "";
        }

        public UISticker(Sticker r100, int r101, String r102) {
            this.sticker = r100;
            this.selected = r101;
            this.filePath = r102;
        }
    }

    void n0(List<Sticker> r100, IGetDataCallback<Boolean> r101);

    void o0(Context r100, int r101, int r102, String r103, ChatImageView r104, String r105, PerfLoadPicMonitor.MonitorRequestListener r106, int r107, int r108, int r110);

    void p0();

    void saveImage2Stickers(String r100, String r101, IGetDataCallback<Boolean> r102);

    Sticker y(String r100);
}
