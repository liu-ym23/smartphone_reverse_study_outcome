package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "K", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {417, 418, 420}, m = "invokeSuspend", n = {"$this$produce", "keys", "$this$produce", "keys", "e", "$this$produce", "keys", ce.f26396k}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
final class ChannelsKt__DeprecatedKt$distinctBy$1 extends SuspendLambda implements Function2<k<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object, Continuation<Object>, Object> $selector;
    final /* synthetic */ ReceiveChannel<Object> $this_distinctBy;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$distinctBy$1(ReceiveChannel<Object> r100, Function2<Object, ? super Continuation<Object>, ? extends Object> r101, Continuation<? super ChannelsKt__DeprecatedKt$distinctBy$1> r102) {
        this.$this_distinctBy = r100;
        this.$selector = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ChannelsKt__DeprecatedKt$distinctBy$1 r102 = new ChannelsKt__DeprecatedKt$distinctBy$1(this.$this_distinctBy, this.$selector, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(k<Object> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(k<Object> r100, Continuation<? super Unit> r101) {
        return ((ChannelsKt__DeprecatedKt$distinctBy$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00c5 -> B:29:0x00cb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00d2 -> B:13:0x0071). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L12;
        if (r101 == 1) goto L11;
        if (r101 == 2) goto L10;
        if (r101 != 3) goto L9;
        Object r102 = this.L$3;
        ChannelIterator<Object> r103 = (ChannelIterator) this.L$2;
        HashSet r104 = (HashSet) this.L$1;
        k r105 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        ChannelsKt__DeprecatedKt$distinctBy$1 r111 = this;
    L29:
        r104.add(r102);
        ChannelIterator<Object> r106 = r103;
        HashSet r107 = r104;
        k r108 = r105;
    L13:
        r111.L$0 = r108;
        r111.L$1 = r107;
        r111.L$2 = r106;
        r111.L$3 = null;
        r111.label = 1;
        Object r109 = r106.hasNext(r111);
        if (r109 != r100) goto L16;
        return r100;
    L16:
        Object r112 = r100;
        ChannelsKt__DeprecatedKt$distinctBy$1 r113 = r111;
        r110 = r109;
        k r114 = r108;
        HashSet r115 = r107;
        r103 = r106;
        Object r116 = r112;
    L18:
        if (((Boolean) r110).booleanValue() == false) goto L32;
        Object r117 = r103.next();
        Function2<Object, Continuation<Object>, Object> r118 = r113.$selector;
        r113.L$0 = r114;
        r113.L$1 = r115;
        r113.L$2 = r103;
        r113.L$3 = r117;
        r113.label = 2;
        Object r119 = r118.invoke(r117, r113);
        if (r119 != r116) goto L22;
        return r116;
    L22:
        HashSet r120 = r115;
        Object r121 = r117;
        r110 = r119;
        k r122 = r114;
        HashSet r123 = r120;
    L24:
        if (r123.contains(r110) == true) goto L30;
        r113.L$0 = r122;
        r113.L$1 = r123;
        r113.L$2 = r103;
        r113.L$3 = r110;
        r113.label = 3;
        if (r122.send(r121, r113) != r116) goto L28;
        return r116;
    L28:
        r104 = r123;
        r105 = r122;
        Object r124 = r116;
        r102 = r110;
        r111 = r113;
        r100 = r124;
        goto L29
    L30:
        r111 = r113;
        r100 = r116;
        r106 = r103;
        r107 = r123;
        r108 = r122;
        goto L13
    L32:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Object r125 = this.L$3;
        r103 = (ChannelIterator) this.L$2;
        HashSet r126 = (HashSet) this.L$1;
        k r127 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        r122 = r127;
        r123 = r126;
        r121 = r125;
        r116 = r100;
        r113 = this;
        goto L24
    L11:
        ChannelIterator<Object> r128 = (ChannelIterator) this.L$2;
        HashSet r129 = (HashSet) this.L$1;
        k r130 = (k) this.L$0;
        ResultKt.throwOnFailure(r110);
        r114 = r130;
        r115 = r129;
        r103 = r128;
        r116 = r100;
        r113 = this;
        goto L18
    L12:
        ResultKt.throwOnFailure(r110);
        k r131 = (k) this.L$0;
        HashSet r132 = new HashSet();
        ChannelIterator<Object> r133 = this.$this_distinctBy.iterator();
        r108 = r131;
        r111 = this;
        r107 = r132;
        r106 = r133;
        goto L13
    }
}
