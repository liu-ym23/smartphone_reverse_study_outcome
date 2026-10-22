package com.bytedance.ee.android.file.picker.lib.v2.ui.main;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.android.file.picker.lib.v2.ui.main.OpenSystemPickerHandler", f = "OpenSystemPickerHandler.kt", i = {0, 0}, l = {87}, m = "toFileItem", n = {"$this$toFileItem", "data"}, s = {"L$0", "L$1"})
public final class OpenSystemPickerHandler$toFileItem$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OpenSystemPickerHandler this$0;

    public OpenSystemPickerHandler$toFileItem$1(OpenSystemPickerHandler r100, Continuation<? super OpenSystemPickerHandler$toFileItem$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        OpenSystemPickerHandler r101 = this.this$0;
        List<String> r102 = OpenSystemPickerHandler.f206129e;
        return r101.c(null, null, this);
    }
}
