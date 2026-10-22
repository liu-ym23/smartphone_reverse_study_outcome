package com.larus.dora.impl.file;

import com.byted.cast.common.Constants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.DoraFileFetchManager", f = "DoraFileFetchManager.kt", i = {0, 0, 1, 1, 1}, l = {579, 582}, m = Constants.ROLE_SINK, n = {"maxRetries", DBDefinition.RETRY_COUNT, "currentWrapper", "maxRetries", DBDefinition.RETRY_COUNT}, s = {"I$0", "I$1", "L$0", "I$0", "I$1"})
public final class DoraFileFetchManager$sink$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraFileFetchManager this$0;

    public DoraFileFetchManager$sink$1(DoraFileFetchManager r100, Continuation<? super DoraFileFetchManager$sink$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DoraFileFetchManager r101 = this.this$0;
        int r102 = DoraFileFetchManager.f335684n;
        return r101.i(null, this);
    }
}
