package com.larus.bmhome.chat.layout.holder.menu.item;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.menu.item.SaveMenuItemKt", f = "SaveMenuItem.kt", i = {}, l = {TTVideoEngineInterface.PLAYER_OPTION_SEGMENT_FORMAT_FLAG}, m = "requireDownloadFileUrlByTosKey", n = {}, s = {})
public final class SaveMenuItemKt$requireDownloadFileUrlByTosKey$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public SaveMenuItemKt$requireDownloadFileUrlByTosKey$1(Continuation<? super SaveMenuItemKt$requireDownloadFileUrlByTosKey$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return SaveMenuItemKt.c(null, this);
    }
}
