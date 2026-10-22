package com.bytedance.ee.android.file.picker.lib.v2.ui.main;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.android.file.picker.lib.v2.ui.main.OpenSystemPickerHandler", f = "OpenSystemPickerHandler.kt", i = {}, l = {70, 76}, m = "toPickerResult", n = {}, s = {})
final class OpenSystemPickerHandler$toPickerResult$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OpenSystemPickerHandler this$0;

    public OpenSystemPickerHandler$toPickerResult$1(OpenSystemPickerHandler r100, Continuation<? super OpenSystemPickerHandler$toPickerResult$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return OpenSystemPickerHandler.a(this.this$0, 0, null, this);
    }
}
