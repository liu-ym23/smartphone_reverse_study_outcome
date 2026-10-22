package io.ktor.utils.io;

import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.ttvideoengine.model.VideoRef;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelKt", f = "ByteReadChannel.kt", i = {0}, l = {VideoRef.VALUE_VIDEO_REF_CATEGORY}, m = "discardExact", n = {OfficeSDKRequestTag.KEY_NEW_USER}, s = {"J$0"})
final class ByteReadChannelKt$discardExact$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;

    public ByteReadChannelKt$discardExact$1(Continuation<? super ByteReadChannelKt$discardExact$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        ByteReadChannelKt$discardExact$1 r102 = this;
    L6:
        Object r103 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L17;
        if (r104 != 1) goto L16;
        long r105 = r102.J$0;
        ResultKt.throwOnFailure(r103);
        if (((Number) r103).longValue() != r105) goto L14;
        return Unit.INSTANCE;
    L14:
        throw new EOFException("Unable to discard " + r105 + " bytes");
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r103);
        r102.J$0 = 0;
        r102.label = 1;
        throw null;
    L5:
        r102 = new ByteReadChannelKt$discardExact$1(this);
        goto L6
    }
}
