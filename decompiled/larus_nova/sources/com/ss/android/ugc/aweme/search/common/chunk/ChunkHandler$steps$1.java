package com.ss.android.ugc.aweme.search.common.chunk;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "p1", "", "p2", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/String;Ljava/lang/Object;)Z"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ChunkHandler$steps$1<T> extends FunctionReferenceImpl implements Function2<String, T, Boolean> {
    public ChunkHandler$steps$1(ChunkHandler r100) {
        super(2, r100, ChunkHandler.class, "handlePrecedence", "handlePrecedence(Ljava/lang/String;Ljava/lang/Object;)Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ChunkHandler r102 = (ChunkHandler) this.receiver;
        r102.f451585a.getClass();
        r102.f451585a.getClass();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(String r100, Object r101) {
        return Boolean.valueOf(invoke2(r100, r101));
    }
}
