package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import com.larus.im.bean.message.block.RichMediaItem;
import com.larus.im.bean.message.block.RichMediaType;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class j implements Function1 {
    public /* synthetic */ j() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        RichMediaItem r101 = (RichMediaItem) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        Integer r102 = r101.type;
        int r103 = RichMediaType.CREATION.getValue();
        if (r102 != null) goto L6;
    L8:
        boolean r104 = false;
    L10:
        return Boolean.valueOf(r104);
    L6:
        if (r102.intValue() != r103) goto L8;
        r104 = true;
        goto L10
    }
}
