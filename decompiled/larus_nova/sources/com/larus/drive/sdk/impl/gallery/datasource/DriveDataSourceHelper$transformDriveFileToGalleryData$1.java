package com.larus.drive.sdk.impl.gallery.datasource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.gallery.datasource.DriveDataSourceHelper", f = "DriveDataSourceHelper.kt", i = {}, l = {18}, m = "transformDriveFileToGalleryData", n = {}, s = {})
public final class DriveDataSourceHelper$transformDriveFileToGalleryData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DriveDataSourceHelper this$0;

    public DriveDataSourceHelper$transformDriveFileToGalleryData$1(DriveDataSourceHelper r100, Continuation<? super DriveDataSourceHelper$transformDriveFileToGalleryData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
