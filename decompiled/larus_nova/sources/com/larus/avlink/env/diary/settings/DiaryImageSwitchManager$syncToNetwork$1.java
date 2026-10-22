package com.larus.avlink.env.diary.settings;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.env.diary.settings.DiaryImageSwitchManager", f = "DiaryImageSwitchManager.kt", i = {0}, l = {149}, m = "syncToNetwork", n = {"enabled"}, s = {"Z$0"})
final class DiaryImageSwitchManager$syncToNetwork$1 extends ContinuationImpl {
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DiaryImageSwitchManager this$0;

    public DiaryImageSwitchManager$syncToNetwork$1(DiaryImageSwitchManager r100, Continuation<? super DiaryImageSwitchManager$syncToNetwork$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DiaryImageSwitchManager.b(this.this$0, false, this);
    }
}
