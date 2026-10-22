package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u000e\u0010\u0003\u001a\u00020\u0004H¦B¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0000H\u0097@¢\u0006\u0004\b\u0006\u0010\u0005¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/ChannelIterator;", ExifInterface.LONGITUDE_EAST, "", "hasNext", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", TeaEventTrack.ACTION_DRAMA_NEXT, "()Ljava/lang/Object;", "next0", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ChannelIterator<E> {

    /* JADX INFO: loaded from: classes42.dex */
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public static /* synthetic */ Object a(ChannelIterator r100, Continuation r101) {
            if ((r101 instanceof ChannelIterator$next0$1) == false) goto L7;
            ChannelIterator$next0$1 r102 = (ChannelIterator$next0$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L14;
            if (r106 != 1) goto L13;
            r100 = (ChannelIterator) r102.L$0;
            ResultKt.throwOnFailure(r104);
        L18:
            if (((Boolean) r104).booleanValue() == false) goto L22;
            return r100.next();
        L22:
            throw new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r104);
            r102.L$0 = r100;
            r102.label = 1;
            r104 = r100.hasNext(r102);
            if (r104 != r105) goto L18;
            return r105;
        L7:
            r102 = new ChannelIterator$next0$1(r101);
            goto L8
        }
    }

    Object hasNext(Continuation<? super Boolean> r100);

    E next();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
    /* synthetic */ Object next(Continuation r100);
}
