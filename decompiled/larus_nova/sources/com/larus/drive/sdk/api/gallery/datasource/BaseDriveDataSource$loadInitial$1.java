package com.larus.drive.sdk.api.gallery.datasource;

import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.impl.gallery.datasource.DriveDataSourceHelper;
import com.larus.gallery.api.b0;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.api.gallery.datasource.BaseDriveDataSource", f = "BaseDriveDataSource.kt", i = {}, l = {15}, m = "loadInitial$suspendImpl", n = {}, s = {})
final class BaseDriveDataSource$loadInitial$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a<T> this$0;

    public BaseDriveDataSource$loadInitial$1(a<T> r100, Continuation<? super BaseDriveDataSource$loadInitial$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        a<T> r102 = this.this$0;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        BaseDriveDataSource$loadInitial$1<T> r103 = this;
    L6:
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L12;
        if (r106 != 1) goto L11;
        ResultKt.throwOnFailure(r104);
    L15:
        List r107 = (List) r104;
        if (r107 != null) goto L19;
        r107 = CollectionsKt.emptyList();
    L19:
        return new b0.b(r107, false, false, 6);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r104);
        DriveFileItem r108 = r102.f341589a;
        r103.label = 1;
        r104 = DriveDataSourceHelper.f341800a.b(r108, r103);
        if (r104 != r105) goto L15;
        return r105;
    L5:
        r103 = new BaseDriveDataSource$loadInitial$1(r102, this);
        goto L6
    }
}
