package com.larus.drive.sdk.impl.gallery.datasource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.gallery.datasource.DriveDataSourceHelper", f = "DriveDataSourceHelper.kt", i = {0, 0, 1, 1}, l = {26, 46}, m = "convertToGalleryData", n = {"file", "galleryService", "file", "galleryService"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class DriveDataSourceHelper$convertToGalleryData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DriveDataSourceHelper this$0;

    public DriveDataSourceHelper$convertToGalleryData$1(DriveDataSourceHelper r100, Continuation<? super DriveDataSourceHelper$convertToGalleryData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DriveDataSourceHelper r101 = this.this$0;
        DriveDataSourceHelper r102 = DriveDataSourceHelper.f341800a;
        return r101.a(null, this);
    }
}
