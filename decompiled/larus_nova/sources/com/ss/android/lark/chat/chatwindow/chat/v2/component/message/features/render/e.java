package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render;

import com.baidu.platform.comapi.map.MapController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements com.ss.android.lark.chat.chatwindow.chat.v2.widget.c.b<y6b.c<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageListRendererFeature f413901a;

    public e(MessageListRendererFeature r100) {
        this.f413901a = r100;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.widget.c.b
    public final String a(y6b.c<?> r100) {
        y6b.c<?> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        return r101.f566482c;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.widget.c.b
    public final y6b.c getItem(int r100) {
        if (r100 >= 0) goto L4;
    L6:
        return null;
    L4:
        if (r100 >= this.f413901a.I().getItemCount()) goto L6;
        return this.f413901a.I().getItem(r100);
    }
}
