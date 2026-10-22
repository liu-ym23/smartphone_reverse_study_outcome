package com.ss.android.lark.widget.photopicker.gallery;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.chat.entity.media.MediaImageSet;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/chat/entity/media/MediaImageSet;", "Lkotlin/internal/NoInfer;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class OriginalMediaHandler$syncPreloadMediaMessages$1 extends Lambda implements Function1<MediaImageSet, String> {
    public static final OriginalMediaHandler$syncPreloadMediaMessages$1 INSTANCE = null;

    static {
        INSTANCE = new OriginalMediaHandler$syncPreloadMediaMessages$1();
    }

    public OriginalMediaHandler$syncPreloadMediaMessages$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(MediaImageSet r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        MessageIdentity r101 = r100.getMessageIdentity();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getMessageId();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(MediaImageSet r100) {
        return invoke2(r100);
    }
}
