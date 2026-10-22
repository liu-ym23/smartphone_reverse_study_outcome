package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.u0;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"kotlinx/coroutines/channels/ChannelsKt__ChannelsKt", "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt", "kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt"}, k = 4, mv = {1, 9, 0}, xi = 48)
public final class ChannelsKt {
    public static final String DEFAULT_CLOSE_MESSAGE = "Channel was closed";

    public static final Function1<Throwable, Unit> consumes(final ReceiveChannel<?> r100) {
        return new ChannelsKt__DeprecatedKt$consumes$1(r100);
    }

    public static final Function1<Throwable, Unit> consumesAll(final ReceiveChannel<?>... r100) {
        return new ChannelsKt__DeprecatedKt$consumesAll$1(r100);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel distinct(ReceiveChannel r100) {
        return distinctBy$default(r100, null, new ChannelsKt__DeprecatedKt$distinct$1(null), 1, null);
    }

    public static final <E> ReceiveChannel<E> filterNotNull(ReceiveChannel<? extends E> r100) {
        ReceiveChannel<E> r101 = filter$default(r100, null, new ChannelsKt__DeprecatedKt$filterNotNull$1(null), 1, null);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterNotNull>");
        return r101;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'onReceiveCatching'")
    public static final /* synthetic */ kotlinx.coroutines.selects.g onReceiveOrNull(ReceiveChannel r100) {
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.onReceiveOrNull?>");
        return r100.getOnReceiveOrNull();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Left for binary compatibility")
    public static final /* synthetic */ ReceiveChannel requireNoNulls(ReceiveChannel r100) {
        return map$default(r100, null, new ChannelsKt__DeprecatedKt$requireNoNulls$1(r100, null), 1, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object any(ReceiveChannel r100, Continuation r101) {
        if ((r101 instanceof ChannelsKt__DeprecatedKt$any$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$any$1 r102 = (ChannelsKt__DeprecatedKt$any$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 != 1) goto L15;
        r100 = (ReceiveChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L22
    L20:
        cancelConsumed(r100, null);
        return r104;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r104);
        ChannelIterator r107 = r100.iterator();     // Catch: Throwable -> L22
        r102.L$0 = r100;     // Catch: Throwable -> L22
        r102.label = 1;     // Catch: Throwable -> L22
        r104 = r107.hasNext(r102);     // Catch: Throwable -> L22
        if (r104 != r105) goto L20;
        return r105;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        cancelConsumed(r100, th);
        throw th;
    L7:
        r102 = new ChannelsKt__DeprecatedKt$any$1(r101);
        goto L8
    }

    public static final void cancelConsumed(ReceiveChannel<?> r100, Throwable r101) {
        CancellationException r102 = null;
        if (r101 != null) goto L5;
    L9:
        r100.cancel(r102);
        return;
    L5:
        if ((r101 instanceof CancellationException) == false) goto L7;
        r102 = (CancellationException) r101;
    L7:
        if (r102 != null) goto L9;
        r102 = u0.a("Channel was consumed, consumer had failed", r101);
        goto L9
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E, R> R consume(BroadcastChannel<E> r100, Function1<? super ReceiveChannel<? extends E>, ? extends R> r101) {
        ReceiveChannel<E> r102 = r100.openSubscription();
        R r103 = r101.invoke(r102);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r102.cancel(null);
        InlineMarker.finallyEnd(1);
        return r103;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r102.cancel(null);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005b -> B:23:0x005e). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object count(ReceiveChannel r100, Continuation r101) {
        if ((r101 instanceof ChannelsKt__DeprecatedKt$count$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$count$1 r102 = (ChannelsKt__DeprecatedKt$count$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L17;
        ChannelIterator r107 = (ChannelIterator) r102.L$2;
        ReceiveChannel r108 = (ReceiveChannel) r102.L$1;
        Ref.IntRef r109 = (Ref.IntRef) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L14
        ChannelIterator r110 = r107;
        r100 = r108;
    L24:
        if (((Boolean) r104).booleanValue() == false) goto L26;
        r110.next();     // Catch: Throwable -> L29
        r109.element++;     // Catch: Throwable -> L29
    L20:
        r102.L$0 = r109;     // Catch: Throwable -> L29
        r102.L$1 = r100;     // Catch: Throwable -> L29
        r102.L$2 = r110;     // Catch: Throwable -> L29
        r102.label = 1;     // Catch: Throwable -> L29
        r104 = r110.hasNext(r102);     // Catch: Throwable -> L29
        if (r104 != r105) goto L24;
        return r105;
    L26:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L29
        cancelConsumed(r100, null);
        return Boxing.boxInt(r109.element);
    L29:
        th = move-exception;
        r108 = r100;
        Throwable th10 = th;
    L35:
        throw th10;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        cancelConsumed(r108, th10);
        throw th;
    L14:
        th10 = th;
        goto L35
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        Ref.IntRef r112 = new Ref.IntRef();
        r110 = r100.iterator();     // Catch: Throwable -> L29
        r109 = r112;
    L7:
        r102 = new ChannelsKt__DeprecatedKt$count$1(r101);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object first(ReceiveChannel r100, Continuation r101) {
        if ((r101 instanceof ChannelsKt__DeprecatedKt$first$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$first$1 r102 = (ChannelsKt__DeprecatedKt$first$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L17;
        ChannelIterator r107 = (ChannelIterator) r102.L$1;
        ReceiveChannel r108 = (ReceiveChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L14
    L24:
        if (((Boolean) r104).booleanValue() == false) goto L29;
        r105 = r107.next();     // Catch: Throwable -> L14
        cancelConsumed(r108, null);
    L27:
        return r105;
    L29:
        throw new NoSuchElementException("ReceiveChannel is empty.");     // Catch: Throwable -> L14
    L14:
        Throwable th10 = th;
    L36:
        throw th10;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        cancelConsumed(r108, th10);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        ChannelIterator r109 = r100.iterator();     // Catch: Throwable -> L30
        r102.L$0 = r100;     // Catch: Throwable -> L30
        r102.L$1 = r109;     // Catch: Throwable -> L30
        r102.label = 1;     // Catch: Throwable -> L30
        Object r110 = r109.hasNext(r102);     // Catch: Throwable -> L30
        if (r110 == r105) goto L27;
        r108 = r100;
        r107 = r109;
        r104 = r110;
    L30:
        th = move-exception;
        r108 = r100;
        th10 = th;
    L7:
        r102 = new ChannelsKt__DeprecatedKt$first$1(r101);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object firstOrNull(ReceiveChannel r100, Continuation r101) {
        if ((r101 instanceof ChannelsKt__DeprecatedKt$firstOrNull$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$firstOrNull$1 r102 = (ChannelsKt__DeprecatedKt$firstOrNull$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L17;
        ChannelIterator r107 = (ChannelIterator) r102.L$1;
        ReceiveChannel r108 = (ReceiveChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L14
    L25:
        if (((Boolean) r104).booleanValue() == true) goto L27;
        cancelConsumed(r108, null);
        return null;
    L27:
        Object r109 = r107.next();     // Catch: Throwable -> L14
        cancelConsumed(r108, null);
        return r109;
    L14:
        Throwable th10 = th;
    L40:
        throw th10;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        cancelConsumed(r108, th10);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        ChannelIterator r110 = r100.iterator();     // Catch: Throwable -> L30
        r102.L$0 = r100;     // Catch: Throwable -> L30
        r102.L$1 = r110;     // Catch: Throwable -> L30
        r102.label = 1;     // Catch: Throwable -> L30
        Object r111 = r110.hasNext(r102);     // Catch: Throwable -> L30
        if (r111 == r105) goto L43;
        r108 = r100;
        r107 = r110;
        r104 = r111;
        goto L25
    L43:
        return r105;
    L30:
        th = move-exception;
        r108 = r100;
        th10 = th;
    L7:
        r102 = new ChannelsKt__DeprecatedKt$firstOrNull$1(r101);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x008b -> B:15:0x0038). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object last(ReceiveChannel r100, Continuation r101) {
        if ((r101 instanceof ChannelsKt__DeprecatedKt$last$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$last$1 r102 = (ChannelsKt__DeprecatedKt$last$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L25;
        if (r106 == 1) goto L20;
        if (r106 != 2) goto L19;
        Object r107 = r102.L$2;
        ChannelIterator r108 = (ChannelIterator) r102.L$1;
        ReceiveChannel r109 = (ReceiveChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L16
        Object r110 = r105;
        r105 = r107;
        r100 = r109;
    L15:
        ChannelIterator r111 = r108;
        Object r112 = r110;
    L44:
        th = move-exception;
        r109 = r100;
        Throwable th10 = th;
    L60:
        throw th10;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        cancelConsumed(r109, th10);
        throw th;
    L39:
        if (((Boolean) r104).booleanValue() == false) goto L42;
        Object r113 = r111.next();     // Catch: Throwable -> L44
        r105 = r112;
        r108 = r111;
    L34:
        r102.L$0 = r100;     // Catch: Throwable -> L49
        r102.L$1 = r108;     // Catch: Throwable -> L49
        r102.L$2 = r113;     // Catch: Throwable -> L49
        r102.label = 2;     // Catch: Throwable -> L49
        Object r114 = r108.hasNext(r102);     // Catch: Throwable -> L49
        if (r114 == r105) goto L43;
        r110 = r105;
        r105 = r113;
        r104 = r114;
    L43:
        return r105;
    L49:
        th = move-exception;
        ReceiveChannel r115 = r100;
        th10 = th;
        r109 = r115;
        goto L60
    L42:
        cancelConsumed(r100, null);
    L16:
        th10 = th;
        goto L60
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ChannelIterator r116 = (ChannelIterator) r102.L$1;
        ReceiveChannel r117 = (ReceiveChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L23
    L31:
        if (((Boolean) r104).booleanValue() == false) goto L47;
        r113 = r116.next();     // Catch: Throwable -> L23
        ReceiveChannel r118 = r117;
        r108 = r116;
        r100 = r118;
        goto L34
    L47:
        throw new NoSuchElementException("ReceiveChannel is empty.");     // Catch: Throwable -> L23
    L23:
        th10 = th;
        r109 = r117;
        goto L60
    L25:
        ResultKt.throwOnFailure(r104);
        ChannelIterator r119 = r100.iterator();     // Catch: Throwable -> L49
        r102.L$0 = r100;     // Catch: Throwable -> L49
        r102.L$1 = r119;     // Catch: Throwable -> L49
        r102.label = 1;     // Catch: Throwable -> L49
        Object r120 = r119.hasNext(r102);     // Catch: Throwable -> L49
        if (r120 == r105) goto L43;
        r117 = r100;
        r116 = r119;
        r104 = r120;
    L7:
        r102 = new ChannelsKt__DeprecatedKt$last$1(r101);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0092 -> B:15:0x0039). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object lastOrNull(ReceiveChannel r100, Continuation r101) {
        if ((r101 instanceof ChannelsKt__DeprecatedKt$lastOrNull$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$lastOrNull$1 r102 = (ChannelsKt__DeprecatedKt$lastOrNull$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L25;
        if (r106 == 1) goto L20;
        if (r106 != 2) goto L19;
        Object r107 = r102.L$2;
        ChannelIterator r108 = (ChannelIterator) r102.L$1;
        ReceiveChannel r109 = (ReceiveChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L16
        Object r110 = r105;
        Object r111 = r107;
        r100 = r109;
    L15:
        ChannelIterator r112 = r108;
        Object r113 = r110;
    L45:
        th = move-exception;
        r109 = r100;
        th = th;
    L56:
        throw th;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        cancelConsumed(r109, th);
        throw th;
    L40:
        if (((Boolean) r104).booleanValue() == false) goto L43;
        Object r114 = r112.next();     // Catch: Throwable -> L45
        r105 = r113;
        r108 = r112;
    L35:
        r102.L$0 = r100;     // Catch: Throwable -> L48
        r102.L$1 = r108;     // Catch: Throwable -> L48
        r102.L$2 = r114;     // Catch: Throwable -> L48
        r102.label = 2;     // Catch: Throwable -> L48
        Object r115 = r108.hasNext(r102);     // Catch: Throwable -> L48
        if (r115 == r105) goto L66;
        r110 = r105;
        r111 = r114;
        r104 = r115;
        goto L15
    L66:
        return r105;
    L48:
        th = move-exception;
        ReceiveChannel r116 = r100;
        th = th;
        r109 = r116;
        goto L56
    L43:
        cancelConsumed(r100, null);
        return r111;
    L16:
        th = th;
        goto L56
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ChannelIterator r117 = (ChannelIterator) r102.L$1;
        ReceiveChannel r118 = (ReceiveChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L23
    L31:
        if (((Boolean) r104).booleanValue() == true) goto L33;
        cancelConsumed(r118, null);
        return null;
    L33:
        r114 = r117.next();     // Catch: Throwable -> L23
        ReceiveChannel r119 = r118;
        r108 = r117;
        r100 = r119;
    L23:
        th = th;
        r109 = r118;
        goto L56
    L25:
        ResultKt.throwOnFailure(r104);
        ChannelIterator r120 = r100.iterator();     // Catch: Throwable -> L48
        r102.L$0 = r100;     // Catch: Throwable -> L48
        r102.L$1 = r120;     // Catch: Throwable -> L48
        r102.label = 1;     // Catch: Throwable -> L48
        Object r121 = r120.hasNext(r102);     // Catch: Throwable -> L48
        if (r121 == r105) goto L65;
        r118 = r100;
        r117 = r120;
        r104 = r121;
        goto L31
    L65:
        return r105;
    L7:
        r102 = new ChannelsKt__DeprecatedKt$lastOrNull$1(r101);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object none(ReceiveChannel r100, Continuation r101) {
        if ((r101 instanceof ChannelsKt__DeprecatedKt$none$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$none$1 r102 = (ChannelsKt__DeprecatedKt$none$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = true;
        if (r106 == 0) goto L16;
        if (r106 != 1) goto L15;
        r100 = (ReceiveChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L27
    L21:
        if (((Boolean) r104).booleanValue() == false) goto L24;
        r107 = false;
    L24:
        r105 = Boxing.boxBoolean(r107);     // Catch: Throwable -> L27
        cancelConsumed(r100, null);
    L26:
        return r105;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r104);
        ChannelIterator r108 = r100.iterator();     // Catch: Throwable -> L27
        r102.L$0 = r100;     // Catch: Throwable -> L27
        r102.label = 1;     // Catch: Throwable -> L27
        r104 = r108.hasNext(r102);     // Catch: Throwable -> L27
        if (r104 != r105) goto L21;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        cancelConsumed(r100, th);
        throw th;
    L7:
        r102 = new ChannelsKt__DeprecatedKt$none$1(r101);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'receiveCatching'", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public static final /* synthetic */ Object receiveOrNull(ReceiveChannel r100, Continuation r101) {
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.receiveOrNull?>");
        return r100.receiveOrNull(r101);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith = @ReplaceWith(expression = "trySendBlocking(element)", imports = {}))
    public static final void sendBlocking(SendChannel r100, Object r101) {
        Object r102 = r100.mo10962trySendJP2dKIU(r101);
        g.c r103 = g.f504696b;
        if ((!(r102 instanceof g.c)) == true) goto L7;
        BuildersKt.runBlocking$default(null, new ChannelsKt__ChannelsKt$sendBlocking$1(r100, r101, null), 1, null);
        return;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object single(ReceiveChannel r100, Continuation r101) {
        if ((r101 instanceof ChannelsKt__DeprecatedKt$single$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$single$1 r102 = (ChannelsKt__DeprecatedKt$single$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L24;
        if (r106 == 1) goto L19;
        if (r106 != 2) goto L18;
        Object r107 = r102.L$1;
        ReceiveChannel r108 = (ReceiveChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L15
        r105 = r107;
    L36:
        if (((Boolean) r104).booleanValue() == true) goto L40;
        cancelConsumed(r108, null);
    L38:
        return r105;
    L40:
        throw new IllegalArgumentException("ReceiveChannel has more than one element.");     // Catch: Throwable -> L15
    L15:
        Throwable th10 = th;
    L50:
        throw th10;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        cancelConsumed(r108, th10);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ChannelIterator r109 = (ChannelIterator) r102.L$1;
        ReceiveChannel r110 = (ReceiveChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L22
    L30:
        if (((Boolean) r104).booleanValue() == false) goto L42;
        Object r111 = r109.next();     // Catch: Throwable -> L22
        r102.L$0 = r110;     // Catch: Throwable -> L22
        r102.L$1 = r111;     // Catch: Throwable -> L22
        r102.label = 2;     // Catch: Throwable -> L22
        Object r112 = r109.hasNext(r102);     // Catch: Throwable -> L22
        if (r112 == r105) goto L38;
        r105 = r111;
        r108 = r110;
        r104 = r112;
        goto L36
    L42:
        throw new NoSuchElementException("ReceiveChannel is empty.");     // Catch: Throwable -> L22
    L22:
        th10 = th;
        r108 = r110;
        goto L50
    L24:
        ResultKt.throwOnFailure(r104);
        ChannelIterator r113 = r100.iterator();     // Catch: Throwable -> L44
        r102.L$0 = r100;     // Catch: Throwable -> L44
        r102.L$1 = r113;     // Catch: Throwable -> L44
        r102.label = 1;     // Catch: Throwable -> L44
        Object r114 = r113.hasNext(r102);     // Catch: Throwable -> L44
        if (r114 == r105) goto L38;
        r110 = r100;
        r109 = r113;
        r104 = r114;
    L44:
        th = move-exception;
        r108 = r100;
        th10 = th;
    L7:
        r102 = new ChannelsKt__DeprecatedKt$single$1(r101);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object singleOrNull(ReceiveChannel r100, Continuation r101) {
        if ((r101 instanceof ChannelsKt__DeprecatedKt$singleOrNull$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$singleOrNull$1 r102 = (ChannelsKt__DeprecatedKt$singleOrNull$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L24;
        if (r106 == 1) goto L19;
        if (r106 != 2) goto L18;
        Object r107 = r102.L$1;
        ReceiveChannel r108 = (ReceiveChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L15
        Object r109 = r107;
    L37:
        if (((Boolean) r104).booleanValue() == false) goto L40;
        cancelConsumed(r108, null);
    L57:
        return null;
    L40:
        cancelConsumed(r108, null);
        return r109;
    L15:
        Throwable th10 = th;
    L55:
        throw th10;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        cancelConsumed(r108, th10);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ChannelIterator r110 = (ChannelIterator) r102.L$1;
        ReceiveChannel r111 = (ReceiveChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L22
    L30:
        if (((Boolean) r104).booleanValue() == true) goto L33;
        cancelConsumed(r111, null);
        goto L57
    L33:
        Object r112 = r110.next();     // Catch: Throwable -> L22
        r102.L$0 = r111;     // Catch: Throwable -> L22
        r102.L$1 = r112;     // Catch: Throwable -> L22
        r102.label = 2;     // Catch: Throwable -> L22
        Object r113 = r110.hasNext(r102);     // Catch: Throwable -> L22
        if (r113 == r105) goto L59;
        r109 = r112;
        r108 = r111;
        r104 = r113;
        goto L37
    L59:
        return r105;
    L22:
        th10 = th;
        r108 = r111;
        goto L55
    L24:
        ResultKt.throwOnFailure(r104);
        ChannelIterator r114 = r100.iterator();     // Catch: Throwable -> L43
        r102.L$0 = r100;     // Catch: Throwable -> L43
        r102.L$1 = r114;     // Catch: Throwable -> L43
        r102.label = 1;     // Catch: Throwable -> L43
        Object r115 = r114.hasNext(r102);     // Catch: Throwable -> L43
        if (r115 == r105) goto L58;
        r111 = r100;
        r110 = r114;
        r104 = r115;
        goto L30
    L58:
        return r105;
    L43:
        th = move-exception;
        r108 = r100;
        th10 = th;
    L7:
        r102 = new ChannelsKt__DeprecatedKt$singleOrNull$1(r101);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0061 -> B:23:0x0064). Please report as a decompilation issue!!! */
    public static final <E> Object toList(ReceiveChannel<? extends E> r100, Continuation<? super List<? extends E>> r101) {
        if ((r101 instanceof ChannelsKt__Channels_commonKt$toList$1) == false) goto L7;
        ChannelsKt__Channels_commonKt$toList$1 r102 = (ChannelsKt__Channels_commonKt$toList$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L17;
        ChannelIterator<? extends E> r107 = (ChannelIterator) r102.L$3;
        ReceiveChannel<? extends E> r108 = (ReceiveChannel) r102.L$2;
        List r109 = (List) r102.L$1;
        List r110 = (List) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L14
        ChannelIterator<? extends E> r111 = r107;
        r100 = r108;
    L24:
        if (((Boolean) r104).booleanValue() == false) goto L26;
        r109.add(r111.next());     // Catch: Throwable -> L29
    L20:
        r102.L$0 = r110;     // Catch: Throwable -> L29
        r102.L$1 = r109;     // Catch: Throwable -> L29
        r102.L$2 = r100;     // Catch: Throwable -> L29
        r102.L$3 = r111;     // Catch: Throwable -> L29
        r102.label = 1;     // Catch: Throwable -> L29
        r104 = r111.hasNext(r102);     // Catch: Throwable -> L29
        if (r104 != r105) goto L24;
        return r105;
    L26:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L29
        cancelConsumed(r100, null);
        return CollectionsKt.build(r110);
    L29:
        th = move-exception;
        r108 = r100;
        Throwable th10 = th;
    L35:
        throw th10;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        cancelConsumed(r108, th10);
        throw th;
    L14:
        th10 = th;
        goto L35
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        List r113 = CollectionsKt.createListBuilder();
        r111 = r100.iterator();     // Catch: Throwable -> L29
        r109 = r113;
        r110 = r109;
    L7:
        r102 = new ChannelsKt__Channels_commonKt$toList$1(r101);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object toMap(ReceiveChannel r100, Continuation r101) {
        return toMap(r100, new LinkedHashMap(), r101);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object toMutableList(ReceiveChannel r100, Continuation r101) {
        return toCollection(r100, new ArrayList(), r101);
    }

    public static final <E> Object toMutableSet(ReceiveChannel<? extends E> r100, Continuation<? super Set<E>> r101) {
        return toCollection(r100, new LinkedHashSet(), r101);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object toSet(ReceiveChannel r100, Continuation r101) {
        return toMutableSet(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> Object trySendBlocking(SendChannel<? super E> r100, E r101) {
        Object r102 = r100.mo10962trySendJP2dKIU(r101);
        if ((r102 instanceof g.c) == true) goto L6;
        Unit r103 = (Unit) r102;
        g.c r104 = g.f504696b;
        return Unit.INSTANCE;
    L6:
        return ((g) BuildersKt.runBlocking$default(null, new ChannelsKt__ChannelsKt$trySendBlocking$2(r100, r101, null), 1, null)).f504697a;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel withIndex(ReceiveChannel r100, CoroutineContext r101) {
        return ProduceKt.d(GlobalScope.INSTANCE, r101, consumes(r100), new ChannelsKt__DeprecatedKt$withIndex$1(r100, null));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel zip(ReceiveChannel r100, ReceiveChannel r101) {
        return zip$default(r100, r101, null, ChannelsKt__DeprecatedKt$zip$1.INSTANCE, 2, null);
    }

    public static final <E, R> R consume(ReceiveChannel<? extends E> r100, Function1<? super ReceiveChannel<? extends E>, ? extends R> r101) {
        R r102 = r101.invoke(r100);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        cancelConsumed(r100, null);
        InlineMarker.finallyEnd(1);
        return r102;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        InlineMarker.finallyStart(1);
        cancelConsumed(r100, th);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> Object consumeEach(BroadcastChannel<E> r100, Function1<? super E, Unit> r101, Continuation<? super Unit> r102) {
        return ChannelsKt__DeprecatedKt.a(r100, r101, r102);
    }

    public static final <E, K> ReceiveChannel<E> distinctBy(ReceiveChannel<? extends E> r100, CoroutineContext r101, Function2<? super E, ? super Continuation<? super K>, ? extends Object> r102) {
        return ProduceKt.d(GlobalScope.INSTANCE, r101, consumes(r100), new ChannelsKt__DeprecatedKt$distinctBy$1(r100, r102, null));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel drop(ReceiveChannel r100, int r101, CoroutineContext r102) {
        return ProduceKt.d(GlobalScope.INSTANCE, r102, consumes(r100), new ChannelsKt__DeprecatedKt$drop$1(r101, r100, null));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel dropWhile(ReceiveChannel r100, CoroutineContext r101, Function2 r102) {
        return ProduceKt.d(GlobalScope.INSTANCE, r101, consumes(r100), new ChannelsKt__DeprecatedKt$dropWhile$1(r100, r102, null));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005f -> B:25:0x0064). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object elementAt(ReceiveChannel r100, int r110, Continuation r111) {
        if ((r111 instanceof ChannelsKt__DeprecatedKt$elementAt$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$elementAt$1 r101 = (ChannelsKt__DeprecatedKt$elementAt$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        int r105 = r101.I$1;
        r110 = r101.I$0;
        ChannelIterator r106 = (ChannelIterator) r101.L$1;
        ReceiveChannel r107 = (ReceiveChannel) r101.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r112).booleanValue() == false) goto L34;
        Object r113 = r106.next();     // Catch: Throwable -> L14
        int r108 = r105 + 1;
        if (r110 != r105) goto L32;
        cancelConsumed(r107, null);
        return r113;
    L32:
        ChannelIterator r114 = r106;
        r100 = r107;
        int r109 = r108;
    L21:
        r101.L$0 = r100;     // Catch: Throwable -> L37
        r101.L$1 = r114;     // Catch: Throwable -> L37
        r101.I$0 = r110;     // Catch: Throwable -> L37
        r101.I$1 = r109;     // Catch: Throwable -> L37
        r101.label = 1;     // Catch: Throwable -> L37
        Object r115 = r114.hasNext(r101);     // Catch: Throwable -> L37
        if (r115 == r103) goto L48;
        r107 = r100;
        r105 = r109;
        r106 = r114;
        r112 = r115;
        goto L26
    L48:
        return r103;
    L34:
        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + r110 + '.');     // Catch: Throwable -> L14
    L14:
        Throwable th10 = th;
    L43:
        throw th10;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        cancelConsumed(r107, th10);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r112);
        if (r110 < 0) goto L36;
        r114 = r100.iterator();     // Catch: Throwable -> L37
        r109 = 0;
        goto L21
    L36:
        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + r110 + '.');     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        th10 = th;
        r107 = r100;
    L7:
        r101 = new ChannelsKt__DeprecatedKt$elementAt$1(r111);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0066 -> B:26:0x006b). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object elementAtOrNull(ReceiveChannel r100, int r101, Continuation r110) {
        if ((r110 instanceof ChannelsKt__DeprecatedKt$elementAtOrNull$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$elementAtOrNull$1 r102 = (ChannelsKt__DeprecatedKt$elementAtOrNull$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        int r106 = r102.I$1;
        r101 = r102.I$0;
        ChannelIterator r107 = (ChannelIterator) r102.L$1;
        ReceiveChannel r108 = (ReceiveChannel) r102.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L14
        int r109 = r106;
        r100 = r108;
        Object r112 = r104;
        ChannelsKt__DeprecatedKt$elementAtOrNull$1 r113 = r102;
        ChannelIterator r114 = r107;
    L26:
        if (((Boolean) r111).booleanValue() == true) goto L28;
    L20:
        cancelConsumed(r100, null);
        return null;
    L28:
        Object r115 = r114.next();     // Catch: Throwable -> L34
        int r116 = r109 + 1;
        if (r101 != r109) goto L32;
        cancelConsumed(r100, null);
        return r115;
    L32:
        ChannelIterator r117 = r114;
        r102 = r113;
        r104 = r112;
        r109 = r116;
    L22:
        r102.L$0 = r100;     // Catch: Throwable -> L34
        r102.L$1 = r117;     // Catch: Throwable -> L34
        r102.I$0 = r101;     // Catch: Throwable -> L34
        r102.I$1 = r109;     // Catch: Throwable -> L34
        r102.label = 1;     // Catch: Throwable -> L34
        Object r118 = r117.hasNext(r102);     // Catch: Throwable -> L34
        if (r118 == r104) goto L46;
        ChannelsKt__DeprecatedKt$elementAtOrNull$1 r119 = r102;
        r114 = r117;
        r111 = r118;
        r112 = r104;
        r113 = r119;
        goto L26
    L46:
        return r104;
    L34:
        th = move-exception;
        ReceiveChannel r120 = r100;
        Throwable th10 = th;
        r108 = r120;
    L42:
        throw th10;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        cancelConsumed(r108, th10);
        throw th;
    L14:
        th10 = th;
        goto L42
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r111);
        if (r101 < 0) goto L20;
        r117 = r100.iterator();     // Catch: Throwable -> L34
        r109 = 0;
    L7:
        r102 = new ChannelsKt__DeprecatedKt$elementAtOrNull$1(r110);
        goto L8
    }

    public static final <E> ReceiveChannel<E> filter(ReceiveChannel<? extends E> r100, CoroutineContext r101, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> r102) {
        return ProduceKt.d(GlobalScope.INSTANCE, r101, consumes(r100), new ChannelsKt__DeprecatedKt$filter$1(r100, r102, null));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterIndexed(ReceiveChannel r100, CoroutineContext r101, Function3 r102) {
        return ProduceKt.d(GlobalScope.INSTANCE, r101, consumes(r100), new ChannelsKt__DeprecatedKt$filterIndexed$1(r100, r102, null));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterNot(ReceiveChannel r100, CoroutineContext r101, Function2 r102) {
        return filter(r100, r101, new ChannelsKt__DeprecatedKt$filterNot$1(r102, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object, kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007c -> B:14:0x0037). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x008a -> B:14:0x0037). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel r100, SendChannel r101, Continuation r102) {
        if ((r102 instanceof ChannelsKt__DeprecatedKt$filterNotNullTo$3) == false) goto L7;
        ChannelsKt__DeprecatedKt$filterNotNullTo$3 r103 = (ChannelsKt__DeprecatedKt$filterNotNullTo$3) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L22;
        if (r107 == 1) goto L17;
        if (r107 != 2) goto L16;
        ChannelIterator r108 = (ChannelIterator) r103.L$2;
        ReceiveChannel r109 = (ReceiveChannel) r103.L$1;
        SendChannel r110 = (SendChannel) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L20
        ?? r111 = r110;
        ?? r112 = r109;
    L14:
        ChannelIterator r113 = r108;
        r100 = r112;
        ?? r114 = r111;
    L24:
        r103.L$0 = r114;     // Catch: Throwable -> L38
        r103.L$1 = r100;     // Catch: Throwable -> L38
        r103.L$2 = r113;     // Catch: Throwable -> L38
        r103.label = 1;     // Catch: Throwable -> L38
        Object r115 = r113.hasNext(r103);     // Catch: Throwable -> L38
        if (r115 == r106) goto L51;
        ?? r116 = r114;
        r101 = r100;
        r108 = r113;
        r105 = r115;
        ?? r117 = r116;
    L29:
        if (((Boolean) r105).booleanValue() == false) goto L35;
        Object r118 = r108.next();     // Catch: Throwable -> L20
        r111 = r117;
        r112 = r101;
        if (r118 == null) goto L14;
        r103.L$0 = r117;     // Catch: Throwable -> L20
        r103.L$1 = r101;     // Catch: Throwable -> L20
        r103.L$2 = r108;     // Catch: Throwable -> L20
        r103.label = 2;     // Catch: Throwable -> L20
        Object r119 = r117.send(r118, r103);     // Catch: Throwable -> L20
        r111 = r117;
        r112 = r101;
        if (r119 != r106) goto L14;
        return r106;
    L35:
        Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L20
        cancelConsumed(r101, null);
        return r117;
    L51:
        return r106;
    L38:
        th = move-exception;
        r101 = r100;
        th = th;
    L48:
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        cancelConsumed(r101, th);
        throw th;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r108 = (ChannelIterator) r103.L$2;
        ReceiveChannel r121 = (ReceiveChannel) r103.L$1;
        SendChannel r122 = (SendChannel) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L20
        r117 = r122;
        r101 = r121;
        goto L29
    L22:
        ResultKt.throwOnFailure(r105);
        r113 = r100.iterator();     // Catch: Throwable -> L38
        r100 = r100;
        r114 = r101;
    L20:
        th = th;
    L7:
        r103 = new ChannelsKt__DeprecatedKt$filterNotNullTo$3(r102);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel flatMap(ReceiveChannel r100, CoroutineContext r101, Function2 r102) {
        return ProduceKt.d(GlobalScope.INSTANCE, r101, consumes(r100), new ChannelsKt__DeprecatedKt$flatMap$1(r100, r102, null));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0062 -> B:24:0x0066). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object indexOf(ReceiveChannel r100, Object r101, Continuation r102) {
        if ((r102 instanceof ChannelsKt__DeprecatedKt$indexOf$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$indexOf$1 r103 = (ChannelsKt__DeprecatedKt$indexOf$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L18;
        if (r107 != 1) goto L17;
        ChannelIterator r108 = (ChannelIterator) r103.L$3;
        ReceiveChannel r109 = (ReceiveChannel) r103.L$2;
        Ref.IntRef r110 = (Ref.IntRef) r103.L$1;
        Object r111 = r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L14
        ChannelIterator r112 = r108;
        r100 = r109;
        r101 = r111;
    L25:
        if (((Boolean) r105).booleanValue() == true) goto L27;
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L34
        cancelConsumed(r100, null);
        return Boxing.boxInt(-1);
    L27:
        if (Intrinsics.areEqual(r101, r112.next()) == false) goto L30;
        Integer r114 = Boxing.boxInt(r110.element);     // Catch: Throwable -> L34
        cancelConsumed(r100, null);
        return r114;
    L30:
        r110.element++;     // Catch: Throwable -> L34
        Ref.IntRef r115 = r110;
        ChannelIterator r116 = r112;
    L20:
        r103.L$0 = r101;     // Catch: Throwable -> L34
        r103.L$1 = r115;     // Catch: Throwable -> L34
        r103.L$2 = r100;     // Catch: Throwable -> L34
        r103.L$3 = r116;     // Catch: Throwable -> L34
        r103.label = 1;     // Catch: Throwable -> L34
        Object r117 = r116.hasNext(r103);     // Catch: Throwable -> L34
        if (r117 == r106) goto L45;
        ChannelIterator r118 = r116;
        r110 = r115;
        r105 = r117;
        r112 = r118;
        goto L25
    L45:
        return r106;
    L14:
        Throwable th10 = th;
    L41:
        throw th10;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        cancelConsumed(r109, th10);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r105);
        r115 = new Ref.IntRef();
        r116 = r100.iterator();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        r109 = r100;
        th10 = th;
    L7:
        r103 = new ChannelsKt__DeprecatedKt$indexOf$1(r102);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0070 -> B:24:0x0074). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object lastIndexOf(ReceiveChannel r100, Object r101, Continuation r102) {
        if ((r102 instanceof ChannelsKt__DeprecatedKt$lastIndexOf$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$lastIndexOf$1 r103 = (ChannelsKt__DeprecatedKt$lastIndexOf$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L18;
        if (r107 != 1) goto L17;
        ChannelIterator r108 = (ChannelIterator) r103.L$4;
        ReceiveChannel r109 = (ReceiveChannel) r103.L$3;
        Ref.IntRef r110 = (Ref.IntRef) r103.L$2;
        Ref.IntRef r111 = (Ref.IntRef) r103.L$1;
        Object r112 = r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L14
        ChannelIterator r113 = r108;
        r100 = r109;
        r101 = r112;
    L25:
        if (((Boolean) r105).booleanValue() == true) goto L27;
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L33
        cancelConsumed(r100, null);
        return Boxing.boxInt(r111.element);
    L33:
        th = move-exception;
        r109 = r100;
        Throwable th10 = th;
    L39:
        throw th10;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        cancelConsumed(r109, th10);
        throw th;
    L27:
        if (Intrinsics.areEqual(r101, r113.next()) == false) goto L29;
        r111.element = r110.element;     // Catch: Throwable -> L33
    L29:
        r110.element++;     // Catch: Throwable -> L33
        Ref.IntRef r115 = r111;
        ChannelIterator r116 = r113;
    L20:
        r103.L$0 = r101;     // Catch: Throwable -> L33
        r103.L$1 = r115;     // Catch: Throwable -> L33
        r103.L$2 = r110;     // Catch: Throwable -> L33
        r103.L$3 = r100;     // Catch: Throwable -> L33
        r103.L$4 = r116;     // Catch: Throwable -> L33
        r103.label = 1;     // Catch: Throwable -> L33
        Object r117 = r116.hasNext(r103);     // Catch: Throwable -> L33
        if (r117 == r106) goto L45;
        ChannelIterator r118 = r116;
        r111 = r115;
        r105 = r117;
        r113 = r118;
        goto L25
    L45:
        return r106;
    L14:
        th10 = th;
        goto L39
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r105);
        r115 = new Ref.IntRef();
        r115.element = -1;
        r110 = new Ref.IntRef();
        r116 = r100.iterator();     // Catch: Throwable -> L33
    L7:
        r103 = new ChannelsKt__DeprecatedKt$lastIndexOf$1(r102);
        goto L8
    }

    public static final <E, R> ReceiveChannel<R> map(ReceiveChannel<? extends E> r100, CoroutineContext r101, Function2<? super E, ? super Continuation<? super R>, ? extends Object> r102) {
        return ProduceKt.d(GlobalScope.INSTANCE, r101, consumes(r100), new ChannelsKt__DeprecatedKt$map$1(r100, r102, null));
    }

    public static final <E, R> ReceiveChannel<R> mapIndexed(ReceiveChannel<? extends E> r100, CoroutineContext r101, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> r102) {
        return ProduceKt.d(GlobalScope.INSTANCE, r101, consumes(r100), new ChannelsKt__DeprecatedKt$mapIndexed$1(r100, r102, null));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapIndexedNotNull(ReceiveChannel r100, CoroutineContext r101, Function3 r102) {
        return filterNotNull(mapIndexed(r100, r101, r102));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapNotNull(ReceiveChannel r100, CoroutineContext r101, Function2 r102) {
        return filterNotNull(map(r100, r101, r102));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x009e -> B:38:0x00a1). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object maxWith(ReceiveChannel r100, Comparator r101, Continuation r110) {
        if ((r110 instanceof ChannelsKt__DeprecatedKt$maxWith$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$maxWith$1 r102 = (ChannelsKt__DeprecatedKt$maxWith$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L24;
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L18;
        Object r106 = r102.L$3;
        ChannelIterator r107 = (ChannelIterator) r102.L$2;
        ReceiveChannel r108 = (ReceiveChannel) r102.L$1;
        Comparator r109 = (Comparator) r102.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L15
        Object r112 = r106;
        r100 = r108;
    L38:
        if (((Boolean) r111).booleanValue() == false) goto L44;
        Object r113 = r107.next();     // Catch: Throwable -> L46
        if (r109.compare(r112, r113) < 0) goto L34;
        r113 = r112;
    L34:
        r102.L$0 = r109;     // Catch: Throwable -> L46
        r102.L$1 = r100;     // Catch: Throwable -> L46
        r102.L$2 = r107;     // Catch: Throwable -> L46
        r102.L$3 = r113;     // Catch: Throwable -> L46
        r102.label = 2;     // Catch: Throwable -> L46
        Object r114 = r107.hasNext(r102);     // Catch: Throwable -> L46
        if (r114 == r104) goto L62;
        r112 = r113;
        r111 = r114;
        goto L38
    L62:
        return r104;
    L44:
        cancelConsumed(r100, null);
        return r112;
    L46:
        th = move-exception;
        ReceiveChannel r115 = r100;
        th = th;
    L48:
        r108 = r115;
    L53:
        throw th;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        cancelConsumed(r108, th);
        throw th;
    L15:
        th = th;
        goto L53
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ChannelIterator r116 = (ChannelIterator) r102.L$2;
        r115 = (ReceiveChannel) r102.L$1;
        Comparator r117 = (Comparator) r102.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L22
    L30:
        if (((Boolean) r111).booleanValue() == true) goto L32;
        cancelConsumed(r115, null);
        return null;
    L32:
        r113 = r116.next();     // Catch: Throwable -> L22
        r109 = r117;
        ReceiveChannel r118 = r115;
        r107 = r116;
        r100 = r118;
    L22:
        th = th;
        goto L48
    L24:
        ResultKt.throwOnFailure(r111);
        ChannelIterator r119 = r100.iterator();     // Catch: Throwable -> L46
        r102.L$0 = r101;     // Catch: Throwable -> L46
        r102.L$1 = r100;     // Catch: Throwable -> L46
        r102.L$2 = r119;     // Catch: Throwable -> L46
        r102.label = 1;     // Catch: Throwable -> L46
        Object r120 = r119.hasNext(r102);     // Catch: Throwable -> L46
        if (r120 == r104) goto L63;
        r115 = r100;
        r116 = r119;
        r111 = r120;
        r117 = r101;
        goto L30
    L63:
        return r104;
    L7:
        r102 = new ChannelsKt__DeprecatedKt$maxWith$1(r110);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x009e -> B:38:0x00a1). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object minWith(ReceiveChannel r100, Comparator r101, Continuation r110) {
        if ((r110 instanceof ChannelsKt__DeprecatedKt$minWith$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$minWith$1 r102 = (ChannelsKt__DeprecatedKt$minWith$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L24;
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L18;
        Object r106 = r102.L$3;
        ChannelIterator r107 = (ChannelIterator) r102.L$2;
        ReceiveChannel r108 = (ReceiveChannel) r102.L$1;
        Comparator r109 = (Comparator) r102.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L15
        Object r112 = r106;
        r100 = r108;
    L38:
        if (((Boolean) r111).booleanValue() == false) goto L44;
        Object r113 = r107.next();     // Catch: Throwable -> L46
        if (r109.compare(r112, r113) > 0) goto L34;
        r113 = r112;
    L34:
        r102.L$0 = r109;     // Catch: Throwable -> L46
        r102.L$1 = r100;     // Catch: Throwable -> L46
        r102.L$2 = r107;     // Catch: Throwable -> L46
        r102.L$3 = r113;     // Catch: Throwable -> L46
        r102.label = 2;     // Catch: Throwable -> L46
        Object r114 = r107.hasNext(r102);     // Catch: Throwable -> L46
        if (r114 == r104) goto L62;
        r112 = r113;
        r111 = r114;
        goto L38
    L62:
        return r104;
    L44:
        cancelConsumed(r100, null);
        return r112;
    L46:
        th = move-exception;
        ReceiveChannel r115 = r100;
        th = th;
    L48:
        r108 = r115;
    L53:
        throw th;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        cancelConsumed(r108, th);
        throw th;
    L15:
        th = th;
        goto L53
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ChannelIterator r116 = (ChannelIterator) r102.L$2;
        r115 = (ReceiveChannel) r102.L$1;
        Comparator r117 = (Comparator) r102.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L22
    L30:
        if (((Boolean) r111).booleanValue() == true) goto L32;
        cancelConsumed(r115, null);
        return null;
    L32:
        r113 = r116.next();     // Catch: Throwable -> L22
        r109 = r117;
        ReceiveChannel r118 = r115;
        r107 = r116;
        r100 = r118;
    L22:
        th = th;
        goto L48
    L24:
        ResultKt.throwOnFailure(r111);
        ChannelIterator r119 = r100.iterator();     // Catch: Throwable -> L46
        r102.L$0 = r101;     // Catch: Throwable -> L46
        r102.L$1 = r100;     // Catch: Throwable -> L46
        r102.L$2 = r119;     // Catch: Throwable -> L46
        r102.label = 1;     // Catch: Throwable -> L46
        Object r120 = r119.hasNext(r102);     // Catch: Throwable -> L46
        if (r120 == r104) goto L63;
        r115 = r100;
        r116 = r119;
        r111 = r120;
        r117 = r101;
        goto L30
    L63:
        return r104;
    L7:
        r102 = new ChannelsKt__DeprecatedKt$minWith$1(r110);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel take(ReceiveChannel r100, int r101, CoroutineContext r102) {
        return ProduceKt.d(GlobalScope.INSTANCE, r102, consumes(r100), new ChannelsKt__DeprecatedKt$take$1(r101, r100, null));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel takeWhile(ReceiveChannel r100, CoroutineContext r101, Function2 r102) {
        return ProduceKt.d(GlobalScope.INSTANCE, r101, consumes(r100), new ChannelsKt__DeprecatedKt$takeWhile$1(r100, r102, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r7v0, types: [C extends kotlinx.coroutines.channels.SendChannel<? super E>] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object, kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0088 -> B:14:0x0037). Please report as a decompilation issue!!! */
    public static final <E, C extends SendChannel<? super E>> Object toChannel(ReceiveChannel<? extends E> r100, C r101, Continuation<? super C> r102) {
        if ((r102 instanceof ChannelsKt__DeprecatedKt$toChannel$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$toChannel$1 r103 = (ChannelsKt__DeprecatedKt$toChannel$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L22;
        if (r107 == 1) goto L17;
        if (r107 != 2) goto L16;
        ChannelIterator<? extends E> r108 = (ChannelIterator) r103.L$2;
        boolean r109 = (C) ((ReceiveChannel) r103.L$1);
        SendChannel r110 = (SendChannel) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L20
        ?? r111 = r110;
        ?? r112 = r109;
    L14:
        ChannelIterator<? extends E> r113 = r108;
        r100 = (ReceiveChannel<? extends E>) r112;
        ?? r114 = (C) r111;
    L24:
        r103.L$0 = r114;     // Catch: Throwable -> L36
        r103.L$1 = r100;     // Catch: Throwable -> L36
        r103.L$2 = r113;     // Catch: Throwable -> L36
        r103.label = 1;     // Catch: Throwable -> L36
        Object r115 = r113.hasNext(r103);     // Catch: Throwable -> L36
        if (r115 == r106) goto L49;
        ?? r116 = r114;
        boolean r117 = (C) r100;
        r108 = r113;
        r105 = r115;
        ?? r118 = r116;
        r101 = r117;
    L29:
        if (((Boolean) r105).booleanValue() == false) goto L33;
        E r119 = r108.next();     // Catch: Throwable -> L20
        r103.L$0 = r118;     // Catch: Throwable -> L20
        r103.L$1 = (Object) r101;     // Catch: Throwable -> L20
        r103.L$2 = r108;     // Catch: Throwable -> L20
        r103.label = 2;     // Catch: Throwable -> L20
        Object r120 = r118.send(r119, r103);     // Catch: Throwable -> L20
        r111 = r118;
        r112 = r101;
        if (r120 != r106) goto L14;
        return r106;
    L33:
        Unit r121 = Unit.INSTANCE;     // Catch: Throwable -> L20
        cancelConsumed((ReceiveChannel) r101, null);
        return r118;
    L49:
        return r106;
    L36:
        th = move-exception;
        r101 = r100;
        th = th;
    L46:
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        cancelConsumed(r101, th);
        throw th;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r108 = (ChannelIterator) r103.L$2;
        boolean r122 = (C) ((ReceiveChannel) r103.L$1);
        SendChannel r123 = (SendChannel) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L20
        r118 = r123;
        r101 = r122;
        goto L29
    L22:
        ResultKt.throwOnFailure(r105);
        r113 = r100.iterator();     // Catch: Throwable -> L36
        r114 = r101;
    L20:
        th = th;
    L7:
        r103 = new ChannelsKt__DeprecatedKt$toChannel$1(r102);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005b -> B:14:0x0038). Please report as a decompilation issue!!! */
    public static final <E, C extends Collection<? super E>> Object toCollection(ReceiveChannel<? extends E> r100, C r101, Continuation<? super C> r102) {
        if ((r102 instanceof ChannelsKt__DeprecatedKt$toCollection$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$toCollection$1 r103 = (ChannelsKt__DeprecatedKt$toCollection$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L19;
        if (r107 != 1) goto L18;
        ChannelIterator<? extends E> r108 = (ChannelIterator) r103.L$2;
        ReceiveChannel<? extends E> r109 = (ReceiveChannel) r103.L$1;
        Collection r110 = (Collection) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L15
        ChannelsKt__DeprecatedKt$toCollection$1 r111 = r103;
        ChannelIterator<? extends E> r112 = r108;
        r100 = r109;
        r101 = (C) r110;
    L14:
        Object r113 = r106;
        ChannelsKt__DeprecatedKt$toCollection$1 r114 = r111;
        if (((Boolean) r105).booleanValue() == false) goto L28;
        C r115 = r101;
        r115.add(r112.next());     // Catch: Throwable -> L31
        ChannelIterator<? extends E> r116 = r112;
        r103 = r114;
        r106 = r113;
    L21:
        r103.L$0 = r101;     // Catch: Throwable -> L31
        r103.L$1 = r100;     // Catch: Throwable -> L31
        r103.L$2 = r116;     // Catch: Throwable -> L31
        r103.label = 1;     // Catch: Throwable -> L31
        Object r117 = r116.hasNext(r103);     // Catch: Throwable -> L31
        if (r117 == r106) goto L43;
        r111 = r103;
        r112 = r116;
        r105 = r117;
        goto L14
    L43:
        return r106;
    L28:
        Unit r118 = Unit.INSTANCE;     // Catch: Throwable -> L31
        cancelConsumed(r100, null);
        return r101;
    L31:
        th = move-exception;
        r109 = r100;
        Throwable th10 = th;
    L41:
        throw th10;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        cancelConsumed(r109, th10);
        throw th;
    L15:
        th10 = th;
        goto L41
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r105);
        r116 = r100.iterator();     // Catch: Throwable -> L31
    L7:
        r103 = new ChannelsKt__DeprecatedKt$toCollection$1(r102);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005b -> B:14:0x0038). Please report as a decompilation issue!!! */
    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> r100, M r101, Continuation<? super M> r102) {
        if ((r102 instanceof ChannelsKt__DeprecatedKt$toMap$2) == false) goto L7;
        ChannelsKt__DeprecatedKt$toMap$2 r103 = (ChannelsKt__DeprecatedKt$toMap$2) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L19;
        if (r107 != 1) goto L18;
        ChannelIterator<? extends Pair<? extends K, ? extends V>> r108 = (ChannelIterator) r103.L$2;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> r109 = (ReceiveChannel) r103.L$1;
        Map r110 = (Map) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L15
        ChannelsKt__DeprecatedKt$toMap$2 r111 = r103;
        ChannelIterator<? extends Pair<? extends K, ? extends V>> r112 = r108;
        r100 = r109;
        r101 = (M) r110;
    L14:
        Object r113 = r106;
        ChannelsKt__DeprecatedKt$toMap$2 r114 = r111;
        if (((Boolean) r105).booleanValue() == false) goto L28;
        Pair<? extends K, ? extends V> r115 = r112.next();     // Catch: Throwable -> L31
        M r116 = r101;
        r116.put(r115.getFirst(), r115.getSecond());     // Catch: Throwable -> L31
        ChannelIterator<? extends Pair<? extends K, ? extends V>> r117 = r112;
        r103 = r114;
        r106 = r113;
    L21:
        r103.L$0 = r101;     // Catch: Throwable -> L31
        r103.L$1 = r100;     // Catch: Throwable -> L31
        r103.L$2 = r117;     // Catch: Throwable -> L31
        r103.label = 1;     // Catch: Throwable -> L31
        Object r118 = r117.hasNext(r103);     // Catch: Throwable -> L31
        if (r118 == r106) goto L43;
        r111 = r103;
        r112 = r117;
        r105 = r118;
        goto L14
    L43:
        return r106;
    L28:
        Unit r119 = Unit.INSTANCE;     // Catch: Throwable -> L31
        cancelConsumed(r100, null);
        return r101;
    L31:
        th = move-exception;
        r109 = r100;
        Throwable th10 = th;
    L39:
        throw th10;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        cancelConsumed(r109, th10);
        throw th;
    L15:
        th10 = th;
        goto L39
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r105);
        r117 = r100.iterator();     // Catch: Throwable -> L31
    L7:
        r103 = new ChannelsKt__DeprecatedKt$toMap$2(r102);
        goto L8
    }

    public static final <E> Object consumeEach(ReceiveChannel<? extends E> r100, Function1<? super E, Unit> r101, Continuation<? super Unit> r102) {
        return ChannelsKt__Channels_commonKt.a(r100, r101, r102);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005b -> B:14:0x0038). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel r100, Collection r101, Continuation r102) {
        if ((r102 instanceof ChannelsKt__DeprecatedKt$filterNotNullTo$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$filterNotNullTo$1 r103 = (ChannelsKt__DeprecatedKt$filterNotNullTo$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L19;
        if (r107 != 1) goto L18;
        ChannelIterator r108 = (ChannelIterator) r103.L$2;
        ReceiveChannel r109 = (ReceiveChannel) r103.L$1;
        Collection r110 = (Collection) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L15
        ChannelsKt__DeprecatedKt$filterNotNullTo$1 r111 = r103;
        ChannelIterator r112 = r108;
        r100 = r109;
        r101 = r110;
    L14:
        Object r113 = r106;
        ChannelsKt__DeprecatedKt$filterNotNullTo$1 r114 = r111;
        if (((Boolean) r105).booleanValue() == false) goto L31;
        Object r115 = r112.next();     // Catch: Throwable -> L34
        if (r115 == null) goto L30;
        r101.add(r115);     // Catch: Throwable -> L34
    L30:
        ChannelIterator r116 = r112;
        r103 = r114;
        r106 = r113;
    L21:
        r103.L$0 = r101;     // Catch: Throwable -> L34
        r103.L$1 = r100;     // Catch: Throwable -> L34
        r103.L$2 = r116;     // Catch: Throwable -> L34
        r103.label = 1;     // Catch: Throwable -> L34
        Object r117 = r116.hasNext(r103);     // Catch: Throwable -> L34
        if (r117 == r106) goto L46;
        r111 = r103;
        r112 = r116;
        r105 = r117;
        goto L14
    L46:
        return r106;
    L31:
        Unit r118 = Unit.INSTANCE;     // Catch: Throwable -> L34
        cancelConsumed(r100, null);
        return r101;
    L34:
        th = move-exception;
        r109 = r100;
        Throwable th10 = th;
    L40:
        throw th10;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        cancelConsumed(r109, th10);
        throw th;
    L15:
        th10 = th;
        goto L40
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r105);
        r116 = r100.iterator();     // Catch: Throwable -> L34
    L7:
        r103 = new ChannelsKt__DeprecatedKt$filterNotNullTo$1(r102);
        goto L8
    }

    public static /* synthetic */ ReceiveChannel withIndex$default(ReceiveChannel r100, CoroutineContext r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = Dispatchers.getUnconfined();
    L6:
        return withIndex(r100, r101);
    }

    public static final <E, R, V> ReceiveChannel<V> zip(ReceiveChannel<? extends E> r100, ReceiveChannel<? extends R> r101, CoroutineContext r102, Function2<? super E, ? super R, ? extends V> r103) {
        return ProduceKt.d(GlobalScope.INSTANCE, r102, consumesAll(new ReceiveChannel[]{r100, r101}), new ChannelsKt__DeprecatedKt$zip$2(r101, r100, r103, null));
    }

    public static /* synthetic */ ReceiveChannel distinctBy$default(ReceiveChannel r100, CoroutineContext r101, Function2 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = Dispatchers.getUnconfined();
    L6:
        return distinctBy(r100, r101, r102);
    }

    public static /* synthetic */ ReceiveChannel drop$default(ReceiveChannel r100, int r101, CoroutineContext r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = Dispatchers.getUnconfined();
    L6:
        return drop(r100, r101, r102);
    }

    public static /* synthetic */ ReceiveChannel dropWhile$default(ReceiveChannel r100, CoroutineContext r101, Function2 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = Dispatchers.getUnconfined();
    L6:
        return dropWhile(r100, r101, r102);
    }

    public static /* synthetic */ ReceiveChannel filter$default(ReceiveChannel r100, CoroutineContext r101, Function2 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = Dispatchers.getUnconfined();
    L6:
        return filter(r100, r101, r102);
    }

    public static /* synthetic */ ReceiveChannel filterIndexed$default(ReceiveChannel r100, CoroutineContext r101, Function3 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = Dispatchers.getUnconfined();
    L6:
        return filterIndexed(r100, r101, r102);
    }

    public static /* synthetic */ ReceiveChannel filterNot$default(ReceiveChannel r100, CoroutineContext r101, Function2 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = Dispatchers.getUnconfined();
    L6:
        return filterNot(r100, r101, r102);
    }

    public static /* synthetic */ ReceiveChannel flatMap$default(ReceiveChannel r100, CoroutineContext r101, Function2 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = Dispatchers.getUnconfined();
    L6:
        return flatMap(r100, r101, r102);
    }

    public static /* synthetic */ ReceiveChannel map$default(ReceiveChannel r100, CoroutineContext r101, Function2 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = Dispatchers.getUnconfined();
    L6:
        return map(r100, r101, r102);
    }

    public static /* synthetic */ ReceiveChannel mapIndexed$default(ReceiveChannel r100, CoroutineContext r101, Function3 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = Dispatchers.getUnconfined();
    L6:
        return mapIndexed(r100, r101, r102);
    }

    public static /* synthetic */ ReceiveChannel mapIndexedNotNull$default(ReceiveChannel r100, CoroutineContext r101, Function3 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = Dispatchers.getUnconfined();
    L6:
        return mapIndexedNotNull(r100, r101, r102);
    }

    public static /* synthetic */ ReceiveChannel mapNotNull$default(ReceiveChannel r100, CoroutineContext r101, Function2 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = Dispatchers.getUnconfined();
    L6:
        return mapNotNull(r100, r101, r102);
    }

    public static /* synthetic */ ReceiveChannel take$default(ReceiveChannel r100, int r101, CoroutineContext r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = Dispatchers.getUnconfined();
    L6:
        return take(r100, r101, r102);
    }

    public static /* synthetic */ ReceiveChannel takeWhile$default(ReceiveChannel r100, CoroutineContext r101, Function2 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = Dispatchers.getUnconfined();
    L6:
        return takeWhile(r100, r101, r102);
    }

    public static /* synthetic */ ReceiveChannel zip$default(ReceiveChannel r100, ReceiveChannel r101, CoroutineContext r102, Function2 r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = Dispatchers.getUnconfined();
    L6:
        return zip(r100, r101, r102, r103);
    }
}
