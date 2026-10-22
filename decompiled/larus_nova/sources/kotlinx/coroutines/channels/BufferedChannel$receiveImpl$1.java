package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "R", ExifInterface.LONGITUDE_EAST, "<anonymous parameter 0>", "Lkotlinx/coroutines/channels/ChannelSegment;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class BufferedChannel$receiveImpl$1 extends Lambda implements Function3 {
    public static final BufferedChannel$receiveImpl$1 INSTANCE = null;

    static {
        INSTANCE = new BufferedChannel$receiveImpl$1();
    }

    public BufferedChannel$receiveImpl$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101, Object r102) {
        return invoke((h) r100, ((Number) r101).intValue(), ((Number) r102).longValue());
    }

    public final Void invoke(h<Object> r100, int r101, long r102) {
        throw new IllegalStateException("unexpected".toString());
    }
}
