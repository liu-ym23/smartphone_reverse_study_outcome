package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002H\u00032\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"<anonymous>", "", "R", ExifInterface.LONGITUDE_EAST, "<anonymous parameter 0>", "Lkotlinx/coroutines/channels/ChannelSegment;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "<anonymous parameter 3>", "", AbsMethodDelegate.TAG_INVOKE, "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;J)Ljava/lang/Void;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class BufferedChannel$sendImpl$1 extends Lambda implements Function4 {
    public static final BufferedChannel$sendImpl$1 INSTANCE = null;

    static {
        INSTANCE = new BufferedChannel$sendImpl$1();
    }

    public BufferedChannel$sendImpl$1() {
        super(4);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101, Object r102, Object r110) {
        return invoke((h) r100, ((Number) r101).intValue(), r102, ((Number) r110).longValue());
    }

    public final Void invoke(h<Object> r100, int r101, Object r102, long r103) {
        throw new IllegalStateException("unexpected".toString());
    }
}
