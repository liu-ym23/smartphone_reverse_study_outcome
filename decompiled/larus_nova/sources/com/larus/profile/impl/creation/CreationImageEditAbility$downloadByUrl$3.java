package com.larus.profile.impl.creation;

import com.ss.bduploader.BDAbstractUpload;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationImageEditAbility", f = "CreationImageEditAbility.kt", i = {0}, l = {BDAbstractUpload.KeyIsXQuicLibAvailable}, m = "downloadByUrl", n = {"dataSubscriber"}, s = {"L$0"})
public final class CreationImageEditAbility$downloadByUrl$3 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationImageEditAbility this$0;

    public CreationImageEditAbility$downloadByUrl$3(CreationImageEditAbility r100, Continuation<? super CreationImageEditAbility$downloadByUrl$3> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        CreationImageEditAbility r101 = this.this$0;
        int r102 = CreationImageEditAbility.f366144d;
        return r101.d(null, null, null, this);
    }
}
