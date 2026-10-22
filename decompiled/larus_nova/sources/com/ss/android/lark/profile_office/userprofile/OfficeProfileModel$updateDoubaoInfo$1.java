package com.ss.android.lark.profile_office.userprofile;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileModel", f = "OfficeProfileModel.kt", i = {}, l = {214}, m = "updateDoubaoInfo", n = {}, s = {})
public final class OfficeProfileModel$updateDoubaoInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeProfileModel this$0;

    public OfficeProfileModel$updateDoubaoInfo$1(OfficeProfileModel r100, Continuation<? super OfficeProfileModel$updateDoubaoInfo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, null, this);
    }
}
