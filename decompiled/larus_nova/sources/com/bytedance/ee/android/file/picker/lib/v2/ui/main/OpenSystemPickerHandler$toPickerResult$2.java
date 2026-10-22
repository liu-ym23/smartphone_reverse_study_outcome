package com.bytedance.ee.android.file.picker.lib.v2.ui.main;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.android.file.picker.lib.v2.ui.main.OpenSystemPickerHandler", f = "OpenSystemPickerHandler.kt", i = {0, 0, 0, 0, 0}, l = {115}, m = "toPickerResult", n = {"$this$toPickerResult", "data", "fileItems", "selectedCount", RXScreenCaptureService.KEY_INDEX}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"})
public final class OpenSystemPickerHandler$toPickerResult$2 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OpenSystemPickerHandler this$0;

    public OpenSystemPickerHandler$toPickerResult$2(OpenSystemPickerHandler r100, Continuation<? super OpenSystemPickerHandler$toPickerResult$2> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        OpenSystemPickerHandler r101 = this.this$0;
        List<String> r102 = OpenSystemPickerHandler.f206129e;
        return r101.d(null, null, this);
    }
}
