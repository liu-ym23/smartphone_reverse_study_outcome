package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.baidu.platform.comapi.map.MapController;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmEndWindowWebHelper", f = "MmEndWindowWebHelper.kt", i = {0, 0, 0, 0, 0}, l = {608}, m = "buildAvatarInfoArray", n = {"avatarArray", "endWindowInfo", MapController.ITEM_LAYER_TAG, "avatarSize", DyPayConstant.KEY_START_TIME}, s = {"L$0", "L$1", "L$3", "I$0", "J$0"})
final class MmEndWindowWebHelper$buildAvatarInfoArray$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmEndWindowWebHelper this$0;

    public MmEndWindowWebHelper$buildAvatarInfoArray$1(MmEndWindowWebHelper r100, Continuation<? super MmEndWindowWebHelper$buildAvatarInfoArray$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MmEndWindowWebHelper.a(this.this$0, 0, this);
    }
}
