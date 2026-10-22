package com.ss.android.lark.sticker_office.ui.custom_sticker.panel;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements OfficeEmojiPreviewPopWindow.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeCustomStickerAdapter f440914a;

    public e(OfficeCustomStickerAdapter r100) {
        this.f440914a = r100;
    }

    @Override // com.ss.android.lark.sticker_office.ui.custom_sticker.panel.OfficeEmojiPreviewPopWindow.c
    public final void a(Context r110, int r111, int r112, String r113, AppCompatImageView r114, String r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r113, "key");
        Intrinsics.checkNotNullParameter(r114, "view");
        Intrinsics.checkNotNullParameter(r210, "<unused var>");
        b6c.a.C0273a.f17896a.a(r110, r111, r112, r113, r114, -2, R.drawable.common_failed_chat_picture, null, 0, r111, r112, this.f440914a.f440871k);
    }
}
