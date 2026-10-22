package com.ss.android.lark.chat.chatwindow.chat.message.actionimpl;

import android.graphics.Rect;
import android.view.View;
import com.ss.android.lark.image.entity.Image;
import kotlin.jvm.internal.Intrinsics;
import mya.v;

/* JADX INFO: loaded from: classes35.dex */
public final class i implements v {
    public i() {
    }

    @Override // mya.q
    public final void b(m2b.a r100, View r101, Rect r110, y6b.a r111, Image r112, boolean r113, int r114) {
        Intrinsics.checkNotNullParameter(r100, "chatContext");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        Intrinsics.checkNotNullParameter(r111, "messageVO");
        e.b(r100, r101, null, r111, null, r113, r114);
    }
}
