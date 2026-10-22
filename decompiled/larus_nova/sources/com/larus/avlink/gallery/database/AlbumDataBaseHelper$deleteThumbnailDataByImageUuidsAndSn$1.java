package com.larus.avlink.gallery.database;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.database.AlbumDataBaseHelper", f = "AlbumDataBaseHelper.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {358}, m = "deleteThumbnailDataByImageUuidsAndSn", n = {"imageUuids", "sn", "this_$iv", "operation$iv", "store$iv", "count$iv", "startTime$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "J$0"})
public final class AlbumDataBaseHelper$deleteThumbnailDataByImageUuidsAndSn$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlbumDataBaseHelper this$0;

    public AlbumDataBaseHelper$deleteThumbnailDataByImageUuidsAndSn$1(AlbumDataBaseHelper r100, Continuation<? super AlbumDataBaseHelper$deleteThumbnailDataByImageUuidsAndSn$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, null, this);
    }
}
