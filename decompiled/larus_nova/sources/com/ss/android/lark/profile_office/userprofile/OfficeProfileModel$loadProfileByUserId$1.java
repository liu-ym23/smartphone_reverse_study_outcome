package com.ss.android.lark.profile_office.userprofile;

import com.ss.android.ugc.aweme.discover.model.commodity.select.RenderLine;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileModel", f = "OfficeProfileModel.kt", i = {0}, l = {54}, m = "loadProfileByUserId", n = {RenderLine.STRATEGY_SERVER}, s = {"Z$0"})
public final class OfficeProfileModel$loadProfileByUserId$1 extends ContinuationImpl {
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeProfileModel this$0;

    public OfficeProfileModel$loadProfileByUserId$1(OfficeProfileModel r100, Continuation<? super OfficeProfileModel$loadProfileByUserId$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, false, this);
    }
}
