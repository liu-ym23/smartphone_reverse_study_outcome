package com.larus.bmhome.chat.layout.holder.menu.item;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.menu.item.SaveMenuItemKt", f = "SaveMenuItem.kt", i = {0}, l = {480}, m = "requireDownloadFileUrlByResourceId", n = {"resourceId"}, s = {"L$0"})
public final class SaveMenuItemKt$requireDownloadFileUrlByResourceId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public SaveMenuItemKt$requireDownloadFileUrlByResourceId$1(Continuation<? super SaveMenuItemKt$requireDownloadFileUrlByResourceId$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return SaveMenuItemKt.b(null, this);
    }
}
