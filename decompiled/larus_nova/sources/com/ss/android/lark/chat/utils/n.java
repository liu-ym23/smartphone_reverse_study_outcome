package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.chat.entity.sticker.StickerInfo;

/* JADX INFO: loaded from: classes35.dex */
public final class n {
    public static String a(StickerContent r100) {
        if (r100 == null) goto L5;
        StickerInfo r101 = r100.getStickerInfo();
        if (r101 == null) goto L9;
        String r102 = r101.getDescription();
        if (TextUtils.isEmpty(r102) == false) goto L15;
        return UIUtils.getString(ChatCoreModule.a().getContext(), R.string.Lark_Legacy_StickerHolder);
    L15:
        return "[" + r102 + "]";
    L9:
        return UIUtils.getString(ChatCoreModule.a().getContext(), R.string.Lark_Legacy_StickerHolder);
    L5:
        return UIUtils.getString(ChatCoreModule.a().getContext(), R.string.Lark_Legacy_StickerHolder);
    }
}
