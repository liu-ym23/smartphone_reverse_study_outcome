package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a>\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u001aU\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2#\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u000b0\bH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a[\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000b0\f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2#\u0010\u0015\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0016\u0010\u0013\u001a[\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2#\u0010\u0015\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0017\u0010\u0013\u001aY\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u000b0\f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u001a\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Channel", "Lkotlinx/coroutines/channels/Channel;", ExifInterface.LONGITUDE_EAST, "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "onUndeliveredElement", "Lkotlin/Function1;", "", "getOrElse", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/ChannelResult;", "onFailure", "", "Lkotlin/ParameterName;", "name", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, "getOrElse-WpGqRn0", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "onClosed", "action", "onClosed-WpGqRn0", "onFailure-WpGqRn0", "onSuccess", "value", "onSuccess-WpGqRn0", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ChannelKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    public static final /* synthetic */ Channel Channel(int r100) {
        return Channel$default(r100, null, null, 6, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOrElse-WpGqRn0, reason: not valid java name */
    public static final <T> T m10965getOrElseWpGqRn0(Object r100, Function1<? super Throwable, ? extends T> r101) {
        if ((r100 instanceof g.c) == true) goto L5;
        return r100;
    L5:
        return r101.invoke(g.a(r100));
    }

    /* JADX INFO: renamed from: onClosed-WpGqRn0, reason: not valid java name */
    public static final <T> Object m10966onClosedWpGqRn0(Object r100, Function1<? super Throwable, Unit> r101) {
        if ((r100 instanceof g.a) == false) goto L5;
        r101.invoke(g.a(r100));
    L5:
        return r100;
    }

    /* JADX INFO: renamed from: onFailure-WpGqRn0, reason: not valid java name */
    public static final <T> Object m10967onFailureWpGqRn0(Object r100, Function1<? super Throwable, Unit> r101) {
        if ((r100 instanceof g.c) == false) goto L5;
        r101.invoke(g.a(r100));
    L5:
        return r100;
    }

    /* JADX INFO: renamed from: onSuccess-WpGqRn0, reason: not valid java name */
    public static final <T> Object m10968onSuccessWpGqRn0(Object r100, Function1<? super T, Unit> r101) {
        if ((r100 instanceof g.c) == true) goto L5;
        r101.invoke(r100);
    L5:
        return r100;
    }

    public static final <E> Channel<E> Channel(int r100, BufferOverflow r101, Function1<? super E, Unit> r102) {
        if (r100 == (-2)) goto L27;
        boolean r103 = false;
        if (r100 == (-1)) goto L20;
        if (r100 == 0) goto L15;
        if (r100 == Integer.MAX_VALUE) goto L32;
        if (r101 != BufferOverflow.SUSPEND) goto L31;
        return new BufferedChannel(r100, r102);
    L31:
        return new i(r100, r101, r102);
    L32:
        return new BufferedChannel(Integer.MAX_VALUE, r102);
    L15:
        if (r101 != BufferOverflow.SUSPEND) goto L17;
        Channel<E> r104 = new BufferedChannel(0, r102);
    L33:
        return r104;
    L17:
        r104 = new i(1, r101, r102);
        goto L33
    L20:
        if (r101 != BufferOverflow.SUSPEND) goto L22;
        r103 = true;
    L22:
        if (r103 == false) goto L25;
        return new i(1, BufferOverflow.DROP_OLDEST, r102);
    L25:
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
    L27:
        if (r101 != BufferOverflow.SUSPEND) goto L29;
        Channel.Factory.getClass();
        r104 = new BufferedChannel(Channel.a.f504670b, r102);
        goto L33
    L29:
        r104 = new i(1, r101, r102);
        goto L33
    }

    public static /* synthetic */ Channel Channel$default(int r100, int r101, Object r102) {
        if ((r101 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        return Channel(r100);
    }

    public static /* synthetic */ Channel Channel$default(int r100, BufferOverflow r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = BufferOverflow.SUSPEND;
    L9:
        if ((r103 & 4) == 0) goto L12;
        r102 = null;
    L12:
        return Channel(r100, r101, r102);
    }
}
