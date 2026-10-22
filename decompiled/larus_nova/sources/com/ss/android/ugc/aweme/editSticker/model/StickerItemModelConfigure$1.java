package com.ss.android.ugc.aweme.editSticker.model;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/ugc/aweme/editSticker/model/StickerItemModel;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
final class StickerItemModelConfigure$1 extends Lambda implements Function1<StickerItemModel, Boolean> {
    public static final StickerItemModelConfigure$1 INSTANCE = null;

    static {
        INSTANCE = new StickerItemModelConfigure$1();
    }

    public StickerItemModelConfigure$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StickerItemModel r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return true;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StickerItemModel r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
