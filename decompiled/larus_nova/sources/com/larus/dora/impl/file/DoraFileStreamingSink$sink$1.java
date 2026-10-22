package com.larus.dora.impl.file;

import com.byted.cast.common.Constants;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.DoraFileStreamingSink", f = "DoraFileStreamingSink.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1}, l = {323, 332}, m = Constants.ROLE_SINK, n = {"deferred", "assembler", "callback", "requestId", DyPayConstant.KEY_START_TIME, "assembler", "callback", "requestId", DyPayConstant.KEY_START_TIME}, s = {"L$0", "L$1", "L$2", "I$0", "J$0", "L$0", "L$1", "I$0", "J$0"})
public final class DoraFileStreamingSink$sink$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraFileStreamingSink this$0;

    public DoraFileStreamingSink$sink$1(DoraFileStreamingSink r100, Continuation<? super DoraFileStreamingSink$sink$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, this);
    }
}
