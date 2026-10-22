package com.ss.android.lark.integrator.im.chat.core.dependency;

import android.content.Context;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.dependency.StickerDependency;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.chatbase.view.ChatImageView;
import com.ss.android.lark.image.impl.PerfLoadPicMonitor;
import com.ss.android.lark.sticker_office.OfficeStickerModule;
import java.util.List;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes36.dex */
public final class v implements StickerDependency {
    public v() {
    }

    @Override // com.ss.android.lark.chat.core.dependency.StickerDependency
    public final void p0() {
    }

    @Override // com.ss.android.lark.chat.core.dependency.StickerDependency
    public final Sticker y(String r100) {
        Lazy r101 = OfficeStickerModule.f440846a;
        return com.ss.android.lark.sticker.core.di.c.a().y(r100);
    }

    @Override // com.ss.android.lark.chat.core.dependency.StickerDependency
    public final void n0(List<Sticker> r100, IGetDataCallback<Boolean> r101) {
        Lazy r102 = OfficeStickerModule.f440846a;
        com.ss.android.lark.sticker.core.di.c.a().n0(r100, r101);
    }

    @Override // com.ss.android.lark.chat.core.dependency.StickerDependency
    public final void saveImage2Stickers(String r100, String r101, IGetDataCallback<Boolean> r102) {
        Lazy r103 = OfficeStickerModule.f440846a;
        com.ss.android.lark.sticker.core.di.c.a().saveImage2Stickers(r100, r101, r102);
    }

    @Override // com.ss.android.lark.chat.core.dependency.StickerDependency
    public final void o0(Context r110, int r111, int r112, String r113, ChatImageView r114, String r115, PerfLoadPicMonitor.MonitorRequestListener r210, int r211, int r212, int r213) {
        b6c.a.C0273a.f17896a.a(r110, r111, r112, r113, r114, R.drawable.common_chat_window_image_item_holder, R.drawable.common_failed_chat_picture, r210, r211, r212, r213, 0);
    }
}
