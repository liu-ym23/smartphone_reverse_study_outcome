package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.ss.ttvideoengine.model.VideoRef;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {VideoRef.VALUE_VIDEO_REF_CODEC_HAS_BYTEVC2, 229, 229}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
final class ChannelsKt__DeprecatedKt$filter$1 extends SuspendLambda implements Function2<k<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<Object> $this_filter;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$filter$1(ReceiveChannel<Object> r100, Function2<Object, ? super Continuation<? super Boolean>, ? extends Object> r101, Continuation<? super ChannelsKt__DeprecatedKt$filter$1> r102) {
        this.$this_filter = r100;
        this.$predicate = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ChannelsKt__DeprecatedKt$filter$1 r102 = new ChannelsKt__DeprecatedKt$filter$1(this.$this_filter, this.$predicate, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(k<Object> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(k<Object> r100, Continuation<? super Unit> r101) {
        return ((ChannelsKt__DeprecatedKt$filter$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L12;
        if (r101 == 1) goto L11;
        if (r101 == 2) goto L10;
        if (r101 != 3) goto L9;
        ChannelIterator<Object> r102 = (ChannelIterator) this.L$1;
        k r103 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
    L13:
        ChannelsKt__DeprecatedKt$filter$1 r111 = this;
    L14:
        r111.L$0 = r103;
        r111.L$1 = r102;
        r111.L$2 = null;
        r111.label = 1;
        Object r104 = r102.hasNext(r111);
        if (r104 != r100) goto L17;
        return r100;
    L17:
        Object r105 = r100;
        ChannelsKt__DeprecatedKt$filter$1 r106 = r111;
        r110 = r104;
        k r107 = r103;
        ChannelIterator<Object> r108 = r102;
        Object r109 = r105;
    L19:
        if (((Boolean) r110).booleanValue() == false) goto L31;
        Object r112 = r108.next();
        Function2<Object, Continuation<? super Boolean>, Object> r113 = r106.$predicate;
        r106.L$0 = r107;
        r106.L$1 = r108;
        r106.L$2 = r112;
        r106.label = 2;
        Object r114 = r113.invoke(r112, r106);
        if (r114 != r109) goto L23;
        return r109;
    L23:
        k r115 = r107;
        Object r116 = r112;
        r110 = r114;
        k r117 = r115;
    L25:
        if (((Boolean) r110).booleanValue() == false) goto L29;
        r106.L$0 = r117;
        r106.L$1 = r108;
        r106.L$2 = null;
        r106.label = 3;
        if (r117.send(r116, r106) != r109) goto L29;
        return r109;
    L29:
        r111 = r106;
        r100 = r109;
        r102 = r108;
        r103 = r117;
        goto L14
    L32:
        r111 = r106;
        r100 = r109;
        r102 = r108;
        r103 = r117;
        goto L14
    L31:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Object r118 = this.L$2;
        r108 = (ChannelIterator) this.L$1;
        k r119 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        r117 = r119;
        r116 = r118;
        r109 = r100;
        r106 = this;
        goto L25
    L11:
        ChannelIterator<Object> r120 = (ChannelIterator) this.L$1;
        k r121 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        r107 = r121;
        r108 = r120;
        r109 = r100;
        r106 = this;
        goto L19
    L12:
        ResultKt.throwOnFailure(r110);
        k r122 = (k) this.L$0;
        r102 = this.$this_filter.iterator();
        r103 = r122;
        goto L13
    }
}
