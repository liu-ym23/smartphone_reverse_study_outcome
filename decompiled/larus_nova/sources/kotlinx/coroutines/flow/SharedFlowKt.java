package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapController;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a0\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t\u001a6\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u000b\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0000\u001a#\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010\u0015\u001a+\u0010\u0016\u001a\u00020\u0017*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u0019\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"NO_VALUE", "Lkotlinx/coroutines/internal/Symbol;", "MutableSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", ExifInterface.GPS_DIRECTION_TRUE, "replay", "", "extraBufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "fuseSharedFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharedFlow;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lkotlin/coroutines/CoroutineContext;", "capacity", "getBufferAt", "", "", "index", "", "([Ljava/lang/Object;J)Ljava/lang/Object;", "setBufferAt", "", MapController.ITEM_LAYER_TAG, "([Ljava/lang/Object;JLjava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class SharedFlowKt {
    public static final kotlinx.coroutines.internal.b0 NO_VALUE = null;

    static {
        NO_VALUE = new kotlinx.coroutines.internal.b0("NO_VALUE");
    }

    public static final /* synthetic */ Object access$getBufferAt(Object[] r100, long r101) {
        return getBufferAt(r100, r101);
    }

    private static final Object getBufferAt(Object[] r100, long r101) {
        return r100[(r100.length - 1) & ((int) r101)];
    }

    public static final <T> MutableSharedFlow<T> MutableSharedFlow(int r100, int r101, BufferOverflow r102) {
        boolean r103 = true;
        if (r100 < 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L28;
        if (r101 < 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L26;
        if (r100 > 0) goto L17;
        if (r101 > 0) goto L17;
        if (r102 == BufferOverflow.SUSPEND) goto L17;
        r103 = false;
    L17:
        if (r103 == false) goto L24;
        int r106 = r101 + r100;
        if (r106 >= 0) goto L22;
        r106 = Integer.MAX_VALUE;
    L22:
        return new SharedFlowImpl(r100, r106, r102);
    L24:
        throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + r102).toString());
    L26:
        throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + r101).toString());
    L9:
        r105 = false;
        goto L10
    L28:
        throw new IllegalArgumentException(("replay cannot be negative, but was " + r100).toString());
    L5:
        r104 = false;
        goto L6
    }

    public static final /* synthetic */ void access$setBufferAt(Object[] r100, long r101, Object r102) {
        setBufferAt(r100, r101, r102);
    }

    private static final void setBufferAt(Object[] r100, long r101, Object r102) {
        r100[(r100.length - 1) & ((int) r101)] = r102;
    }

    public static final <T> Flow<T> fuseSharedFlow(d1<? extends T> r100, CoroutineContext r101, int r102, BufferOverflow r103) {
        if (r102 == 0) goto L6;
        if (r102 == (-3)) goto L6;
    L9:
        return new kotlinx.coroutines.flow.internal.h(r100, r101, r102, r103);
    L6:
        if (r103 != BufferOverflow.SUSPEND) goto L9;
        return r100;
    }

    public static /* synthetic */ MutableSharedFlow MutableSharedFlow$default(int r100, int r101, BufferOverflow r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L12;
        r102 = BufferOverflow.SUSPEND;
    L12:
        return MutableSharedFlow(r100, r101, r102);
    }
}
